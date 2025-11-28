import ServiciosSerializar.SerializarService;
import ServiciosXML.XMLService;
import model.Adestrador;
import model.Pokedexes;
import model.Pokemon;
import services.AdestradorServices;
import services.PokedexServices;
import services.PokemonServices;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Pokedexes> listPokedex = new ArrayList<>();
        PokedexServices pokedexServices = new PokedexServices();
        PokemonServices pokemonServices = new PokemonServices();
        AdestradorServices adestradorServices = new AdestradorServices();
        SerializarService serializarService = new SerializarService();
        XMLService xmlService = new XMLService();
        List<Pokedexes> actualizarPokemon = new ArrayList<>();

        /*System.out.println("-INSERTAMOS 10 POKEMONS-");
        pokedexServices.crearPokedex("Bulbasaur", 6.9,"Tras nacer, crece alimentandose de los nutrientes de su vulvo");
        pokedexServices.crearPokedex("Ivysaur", 13.0,"Cuanta más luz solar recibe, más aumenta su fuerza y más se desarrolla el capullo que tiene en el lomo");
        pokedexServices.crearPokedex("Venusaur", 100.0,"Puede convertir la luz del sol en energía. Por esa razón, es más poderoso en verano.");
        pokedexServices.crearPokedex("Charmander", 8.5,"La llama de su cola indica su fuerza vital. Si está débil, la llama arderá más tenue.");
        pokedexServices.crearPokedex("Charmeleon", 19.0,"Al agitar su ardiente cola, eleva poco a poco la temperatura a su alrededor para sofocar a sus rivales.");
        pokedexServices.crearPokedex("Charizard", 90.5,"Cuando se enfurece de verdad, la llama de la punta de su cola se vuelve de color azul claro.");
        pokedexServices.crearPokedex("Squirtle", 9.0,"Tras nacer, se le hincha el lomo y se le forma un caparazón. Escupe poderosa espuma por la boca.");
        pokedexServices.crearPokedex("Wartortle", 22.5,"Tiene una cola larga y peluda que simboliza la longevidad y lo hace popular entre los mayores.");
        pokedexServices.crearPokedex("Blastoise", 85.5,"Aumenta de peso deliberadamente para contrarrestar la fuerza de los chorros de agua que dispara.");
        pokedexServices.crearPokedex("Caterpie", 2.9,"Para protegerse, despide un hedor horrible por las antenas con el que repele a sus enemigos.");

        System.out.println("-INSERTAMOS 2 ENTRENADORES-");
        adestradorServices.crearAdestrador("Ash Ketchum", new java.util.Date(1900-20-24));
        adestradorServices.crearAdestrador("Misty", new Date(1900-20-23));
         */

        /*
        System.out.println("-INSERTAMOS 12 POKEMONS ASIGNANDOLES ENTRENADOR Y POKEDEX-");
        pokemonServices.crearPokemon("Sapopeta", new Date(2020-01-01), adestradorServices.leerAdestrador(1L), pokedexServices.leerPokedex(1L));
        pokemonServices.crearPokemon("Gordito", new Date(2020-02-01), adestradorServices.leerAdestrador(1L), pokedexServices.leerPokedex(2L));
        pokemonServices.crearPokemon("Obesito", new Date(2020-03-01), adestradorServices.leerAdestrador(1L), pokedexServices.leerPokedex(3L));
        pokemonServices.crearPokemon("Lagartija", new Date(2020-04-01), adestradorServices.leerAdestrador(1L), pokedexServices.leerPokedex(4L));
        pokemonServices.crearPokemon("Tuqueque", new Date(2020-05-01), adestradorServices.leerAdestrador(1L), pokedexServices.leerPokedex(5L));
        pokemonServices.crearPokemon("Dragonsin", new Date(2020-06-01), adestradorServices.leerAdestrador(1L), pokedexServices.leerPokedex(6L));
        pokemonServices.crearPokemon("Tortu", new Date(2020-07-01), adestradorServices.leerAdestrador(2L), pokedexServices.leerPokedex(7L));
        pokemonServices.crearPokemon("Orejas", new Date(2020-10-01), adestradorServices.leerAdestrador(2L), pokedexServices.leerPokedex(8L));
        pokemonServices.crearPokemon("Cañones", new Date(2020-05-01), adestradorServices.leerAdestrador(2L), pokedexServices.leerPokedex(9L));
        pokemonServices.crearPokemon("Gusanito", new Date(2020-10-01), adestradorServices.leerAdestrador(2L), pokedexServices.leerPokedex(10L));
        pokemonServices.crearPokemon("Vinosin", new Date(2020-11-01), adestradorServices.leerAdestrador(2L), pokedexServices.leerPokedex(3L));
        pokemonServices.crearPokemon("Charmessi", new Date(2020-12-01), adestradorServices.leerAdestrador(2L), pokedexServices.leerPokedex(5L));
        */

        System.out.println("-LISTAMOS LOS POKEMONES EN LA POKEDEX-");
        listPokedex = pokedexServices.listarPokedex();
        for (Pokedexes p : listPokedex) {
            System.out.println(p.toString());
        }

        System.out.println("-LISTAR LOS ENTRENADORES Y SUS POKEMONS-");
        List<Adestrador> entrenadores = adestradorServices.listarAdestradores();
        for (Adestrador a : entrenadores) {
            System.out.println("Entrenador: " + a.getNome());
            for (model.Pokemon p : a.getPokemons()) {
                System.out.println(" - Pokemon: " + p.getNome() + ", Pokedex: " + p.getPokedex().getNome());
            }
        }

        System.out.println("-LISTAMOS POKEMONES EN LA TABLA POKEMON-");
        List<Pokemon> pokemons = pokemonServices.listarPokemons();
        for (Pokemon p : pokemons) {
            System.out.println(p.getNome()+", Entrenador: " + p.getAdestrador().getNome() + ", Pokedex: " + p.getPokedex().getNome());
        }

        System.out.println("-EXPORTAR A UN ARCHIVO DOS ENTRADAS DE LA POKEDEX SERIALIZADAS-");
        List<Pokedexes> pokedexToSerialize = new ArrayList<>();
        pokedexToSerialize.add(pokedexServices.leerPokedexPorID(2L));
        pokedexToSerialize.add(pokedexServices.leerPokedexPorID(4L));
        serializarService.SerializarPokedex(pokedexToSerialize);

        System.out.println("-EXPORTAR EN XML LOS ENTRENADORES-");
        List<Adestrador> adestradoresToXML = adestradorServices.listarAdestradores();
        xmlService.crearXMLAdestrador(adestradoresToXML);

        System.out.println("-MODIFICAR DOS ENTRADAS EN LA POKEDEX(LAS MISMAS QUE SE SERIALIZARON)-");
        List<Pokedexes> pokedexToUpdate = new ArrayList<>();
        pokedexToUpdate.add(pokedexServices.leerPokedexPorID(2L));
        pokedexToUpdate.add(pokedexServices.leerPokedexPorID(4L));
        for (Pokedexes p : pokedexToUpdate) {
            System.out.println("Modificando peso de " + p.getNome());
            p.setPeso(p.getPeso() + 15.0);
            pokedexServices.actualizarPokedex(p);
            System.out.println("Pokemon actualizado");
        }

        System.out.println("-MODIFICAR DOS ENTRENADORES(LOS MISMOS QUE SE EXPORTARON A XML)-");
        for (Adestrador a : adestradoresToXML) {
            System.out.println("Modificando año de nacimiento de: " + a.getNome());
            a.setNacemente(new Date(a.getNacemente().getYear() - 5, a.getNacemente().getMonth(), a.getNacemente().getDate()));
            adestradorServices.actualizarAdestrador(a);
            System.out.println("Entrenador actualizado");
        }

        /*System.out.println("-LISTAMOS LOS POKEMONS-");
        listPokedex = pokedexServices.listarPokedex();
        System.out.println(listPokedex.get(0).toString());
        System.out.println(listPokedex.get(1).toString());
        System.out.println(listPokedex.get(2).toString());
        System.out.println(listPokedex.get(3).toString());
        System.out.println(listPokedex.get(4).toString());
        System.out.println(listPokedex.get(5).toString());
        System.out.println(listPokedex.get(6).toString());
        System.out.println(listPokedex.get(7).toString());
        System.out.println(listPokedex.get(8).toString());
        System.out.println(listPokedex.get(9).toString());

        System.out.println("-MODIFICAMOS 2 ENTRADAS DE LA POKEDEX-");
        actualizarPokemon.add(pokedexServices.leerPokedexPorID(1L));
        actualizarPokemon.add(pokedexServices.leerPokedexPorID(3L));
        
        for (Pokedexes p: actualizarPokemon){
            System.out.println("-Engordamos 20Kg a " + p.getNome() + "-");
            p.setPeso(p.getPeso() + 20.0);
            pokedexServices.actualizarPokedex(p);
            System.out.println("Pokemon actualizado");
        }

        System.out.println("-LISTAMOS DENUEVO-");
        System.out.println(listPokedex.get(0).toString());
        System.out.println(listPokedex.get(1).toString());
        System.out.println(listPokedex.get(2).toString());
        System.out.println(listPokedex.get(3).toString());
        System.out.println(listPokedex.get(4).toString());
        System.out.println(listPokedex.get(5).toString());
        System.out.println(listPokedex.get(6).toString());
        System.out.println(listPokedex.get(7).toString());
        System.out.println(listPokedex.get(8).toString());
        System.out.println(listPokedex.get(9).toString());

        System.out.println("-ELIMINAMOS TODA LA POKEDEX-");
        listPokedex = pokedexServices.listarPokedex();
        for (Pokedexes p: listPokedex) {
            pokedexServices.eliminarPokedex(p.getId());
        }*/


    }
}
