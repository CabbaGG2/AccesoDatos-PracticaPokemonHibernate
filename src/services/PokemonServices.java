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
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Pokemon nuevoPokemon = new Pokemon();
            nuevoPokemon.setNome(nome);
            nuevoPokemon.setNacemento(nacemento);
            nuevoPokemon.setAdestrador(adestrador);
            nuevoPokemon.setPokedex(pokedex);
            session.save(nuevoPokemon);
            transaction.commit();
        }
    }


}
