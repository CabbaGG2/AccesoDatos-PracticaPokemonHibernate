package services;

import config.HibernateConfig;
import model.Adestrador;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;

public class AdestradorServices {

    public void crearAdestrador(String nome, Date nacemento){
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Adestrador nuevoAdestrador = new Adestrador();
            nuevoAdestrador.setNome(nome);
            nuevoAdestrador.setNacemente(nacemento);
            session.save(nuevoAdestrador);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al crear el entrenador: " + e.getMessage());
        }
    }

    public Adestrador leerAdestrador(Long id) {
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.get(Adestrador.class, id);
        } catch (Exception e) {
            System.out.println("Error al leer el entrenador: " + e.getMessage());
            return null;
        }
    }

    public void actualizarAdestrador(Long id, String nome, Date nacemento) {
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Adestrador adestrador = session.get(Adestrador.class, id);
            if (adestrador != null) {
                adestrador.setNome(nome);
                adestrador.setNacemente(nacemento);
                session.update(adestrador);
            } else {
                System.out.println("entrenador no encontrando para realizar actualización");
            }
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al actualizar el entrenador: " + e.getMessage());
        }
    }

    public void actualizarAdestrador(Adestrador adestrador) {
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
                session.update(adestrador);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al actualizar el entrenador: " + e.getMessage());
        }
    }

    public void eliminarAdestrador(Long id) {
        try(Session session = HibernateConfig.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            Adestrador adestrador = session.get(Adestrador.class, id);
            if (adestrador != null) {
                session.delete(adestrador);
            } else {
                System.out.println("No existe el registro del entrenador solicitado");
            }
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al tratar de eliminar el entrenador: " + e.getMessage());
        }
    }

    public List<Adestrador> listarAdestradores() {
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("from Adestrador",Adestrador.class).getResultList();
        } catch (Exception e) {
            System.out.println("Error al listar los entrenadores: " + e.getMessage());
            return null;
        }
    }

    public Adestrador leerAdestradorPorID(Long id) {

        Adestrador adestrador = null;
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();

            List<Adestrador> adestradorList = session.createQuery("from Adestrador where id = :id", Adestrador.class)
                    .setParameter("id",id)
                    .getResultList();

            if(!adestradorList.isEmpty()) {
                adestrador = adestradorList.get(0); // Se regresa un solo objeto porque cada entrenador tiene un solo ID
            } else {
                System.out.println("No se encontró ningun entrenador con id: " + id);
            }

            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error al leer el entrenador: " + e.getMessage());
        }
        return adestrador;
    }


}
