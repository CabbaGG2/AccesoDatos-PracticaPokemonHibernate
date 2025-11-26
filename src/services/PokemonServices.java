package services;

import config.HibernateConfig;
import model.Adestrador;
import model.Pokedexes;
import model.Pokemon;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PokemonServices {

    public void crearPokemon(String nome, Date nacemento, Adestrador adestrador, Pokedexes pokedex) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Pokemon nuevoPokemon = new Pokemon();
            nuevoPokemon.setNome(nome);
            nuevoPokemon.setNacemento(nacemento);
            nuevoPokemon.setAdestrador(adestrador);
            nuevoPokemon.setPokedex(pokedex);
            session.save(nuevoPokemon);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al crear el pokemon: " + e.getMessage());
        }
    }

    public void actualizarPokemon(Pokemon pokemon) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(pokemon);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al actualizar el pokemon: " + e.getMessage());
        }
    }

    public Pokemon leerPokemon(Long id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.get(Pokemon.class, id);
        } catch (Exception e) {
            System.out.println("Error al leer el pokemon: " + e.getMessage());
            return null;
        }
    }

    public void actualizarPokemon(Long id, String nome, Date nacemento, Adestrador adestrador, Pokedexes pokedex) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Pokemon pokemon = session.get(Pokemon.class, id);
            if (pokemon != null) {
                pokemon.setNome(nome);
                pokemon.setNacemento(nacemento);
                pokemon.setAdestrador(adestrador);
                pokemon.setPokedex(pokedex);
                session.update(pokemon);
            } else {
                System.out.println("pokemon no encontrado para realizar actualización.");
            }
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al actualizar el pokemon: " + e.getMessage());
        }
    }

    public void eliminarPokemon(Long id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Pokemon pokemon = session.get(Pokemon.class, id);
            if (pokemon != null) {
                session.delete(pokemon);
            } else {
                System.out.println("pokemon no encontrado para eliminar.");
            }
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al eliminar el pokemon: " + e.getMessage());
        }
    }

    public List<Pokemon> listarPokemons() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("FROM Pokemon", Pokemon.class).list();
        } catch (Exception e) {
            System.out.println("Error al listar los pokemons: " + e.getMessage());
            return new ArrayList<>();
        }
    }

}