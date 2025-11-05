package services;

import config.HibernateConfig;
import model.Pokedexes;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;
import java.util.List;

public class PokedexServices {

    public void crearPokedex(String nome, Double peso, String misc) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Pokedexes nuevoPokedex = new Pokedexes();
            nuevoPokedex.setNome(nome);
            nuevoPokedex.setPeso(peso);
            nuevoPokedex.setMisc(misc);
            session.save(nuevoPokedex);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al crear el pokedex: " + e.getMessage());
        }
    }

    public Pokedexes leerPokedex(Long id) {
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.get(Pokedexes.class, id);
        }catch (Exception e) {
            System.out.println("Error al leer el gato: " + e.getMessage());
            return null;
        }
    }

    public void actualizarPokedex(Long id, String nome, Double peso, String misc) {
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Pokedexes pokedex = session.get(Pokedexes.class, id);
            if (pokedex != null) {
                pokedex.setNome(nome);
                pokedex.setPeso(peso);
                pokedex.setMisc(misc);
                session.update(pokedex);
            } else {
                System.out.println("pokedex no encontrado para realizar actualización.");
            }
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al actualizar el pokedex: " + e.getMessage());
        }
    }

    public void actualizarPokedex(Pokedexes pokedex) {
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
                session.update(pokedex);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al actualizar el pokedex: " + e.getMessage());
        }
    }

    public void eliminarPokedex(Long id) {
        try(Session session = HibernateConfig.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            Pokedexes pokedex = session.get(Pokedexes.class, id);
            if (pokedex != null){
                session.delete(pokedex);
            } else {
                System.out.println("no existe el registo del pokedex solicitado.");
            }
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error tratando de eliminar el pokedex: " + e.getMessage());
        }
    }
    
    public List<Pokedexes> listarPokedex() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("from Pokedexes", Pokedexes.class).getResultList();
        } catch (Exception e) {
            System.out.println("Error al listar pokedex: " + e.getMessage());
            return null;
        }
    }

    public Pokedexes leerPokedexPorID(Long id){

        Pokedexes pokedex = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();

            List<Pokedexes> pokedexList = session.createQuery("from Pokedexes where id = :id", Pokedexes.class)
                    .setParameter("id",id)
                    .getResultList();

            if(!pokedexList.isEmpty()) {
                pokedex = pokedexList.get(0); //Se pasa uno porque solo hay un id.
            } else {
                System.out.println("No se encontró un pokemon con id: " + id);
            }

            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error al leer el pokedex: " + e.getMessage());
        }
        return pokedex;
    }


}
