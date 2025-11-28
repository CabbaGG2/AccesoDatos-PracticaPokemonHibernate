package ServiciosSerializar;

import model.Adestrador;
import model.Pokedexes;
import model.Pokemon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializarService {

    public void SerializarAdestrador (List<Adestrador> entrenadores){
        try(FileOutputStream fos = new FileOutputStream("serialAdestrador");
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(entrenadores);
            System.out.println("Lista guardada en 'serialAdestrador' con exito.");
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());;
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        }
    }

    public List<Adestrador> DeserializarAdestrador(String ruta) {
        List<Adestrador> entrenadores= new ArrayList<>();
        try(FileInputStream fis = new FileInputStream(ruta);
            ObjectInputStream ois = new ObjectInputStream(fis)) {

            entrenadores  = (List<Adestrador>) ois.readObject();
            System.out.println("Objeto cargado desde: " + ruta + " con exito");
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " +e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada: " + e.getMessage());;
        }
        return entrenadores;
    }

    public static void SerializarPokedex(List<Pokedexes> pokedexes){
        try(FileOutputStream fos = new FileOutputStream("serialPokedex");
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(pokedexes);
            System.out.println("Lista guardada en 'serialPokedex' con exito.");
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());;
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        }
    }

    public static List<Pokedexes> DeserializarPokedexes(String ruta) {
        List<Pokedexes> pokedexes= new ArrayList<>();
        try(FileInputStream fis = new FileInputStream(ruta);
            ObjectInputStream ois = new ObjectInputStream(fis)) {

            pokedexes  = (List<Pokedexes>) ois.readObject();
            System.out.println("Objeto cargado desde: " + ruta + " con exito");
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " +e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada: " + e.getMessage());;
        }
        return pokedexes;
    }

    public static void SerializarPokemon(List<Pokemon> pokemones){
        try(FileOutputStream fos = new FileOutputStream("serialPokedex");
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(pokemones);
            System.out.println("Lista guardada en 'serialPokedex' con exito.");
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());;
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        }
    }

    public static List<Pokemon> DeserializarPokemones(String ruta) {
        List<Pokemon> pokemones= new ArrayList<>();
        try(FileInputStream fis = new FileInputStream(ruta);
            ObjectInputStream ois = new ObjectInputStream(fis)) {

            pokemones  = (List<Pokemon>) ois.readObject();
            System.out.println("Objeto cargado desde: " + ruta + " con exito");
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " +e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada: " + e.getMessage());;
        }
        return pokemones;
    }

}