import model.Pokedexes;
import services.AdestradorServices;
import services.PokedexServices;
import services.PokemonServices;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Pokedexes> listPokedex = new ArrayList<>();
        PokedexServices pokedexServices = new PokedexServices();
        PokemonServices pokemonServices = new PokemonServices();
        AdestradorServices adestradorServices = new AdestradorServices();
        List<Pokedexes> actualizarPokemon = new ArrayList<>();

        System.out.println("-INSERTAMOS 10 POKEMONS-");
        /*pokedexServices.crearPokedex("Bulbasaur", 6.9,"Tras nacer, crece alimentandose de los nutrientes de su vulvo");
        pokedexServices.crearPokedex("Ivysaur", 13.0,"Cuanta más luz solar recibe, más aumenta su fuerza y más se desarrolla el capullo que tiene en el lomo");
        pokedexServices.crearPokedex("Venusaur", 100.0,"Puede convertir la luz del sol en energía. Por esa razón, es más poderoso en verano.");
        pokedexServices.crearPokedex("Charmander", 8.5,"La llama de su cola indica su fuerza vital. Si está débil, la llama arderá más tenue.");
        pokedexServices.crearPokedex("Charmeleon", 19.0,"Al agitar su ardiente cola, eleva poco a poco la temperatura a su alrededor para sofocar a sus rivales.");
        pokedexServices.crearPokedex("Charizard", 90.5,"Cuando se enfurece de verdad, la llama de la punta de su cola se vuelve de color azul claro.");
        pokedexServices.crearPokedex("Squirtle", 9.0,"Tras nacer, se le hincha el lomo y se le forma un caparazón. Escupe poderosa espuma por la boca.");
        pokedexServices.crearPokedex("Wartortle", 22.5,"Tiene una cola larga y peluda que simboliza la longevidad y lo hace popular entre los mayores.");
        pokedexServices.crearPokedex("Blastoise", 85.5,"Aumenta de peso deliberadamente para contrarrestar la fuerza de los chorros de agua que dispara.");
        pokedexServices.crearPokedex("Caterpie", 2.9,"Para protegerse, despide un hedor horrible por las antenas con el que repele a sus enemigos.");
         */
        System.out.println("-LISTAMOS LOS POKEMONS-");
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
        
        /*for (Pokedexes p: actualizarPokemon){
            System.out.println("-Engordamos 20Kg a " + p.getNome() + "-");
            p.setPeso(p.getPeso() + 20.0);
            pokedexServices.actualizarPokedex(p);
            System.out.println("Pokemon actualizado");
        }*/

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

        /*System.out.println("-ELIMINAMOS TODA LA POKEDEX-");
        listPokedex = pokedexServices.listarPokedex();
        for (Pokedexes p: listPokedex) {
            pokedexServices.eliminarPokedex(p.getId());
        }*/
    }
}
