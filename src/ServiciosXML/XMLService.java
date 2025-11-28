package ServiciosXML;

import model.Pokedexes;
import model.Adestrador;
import model.Pokemon;

import javax.xml.parsers.SAXParser;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLService {
    private static final String XML_FILE_POKEDEX = "pokedexes.xml";
    private static final String XML_FILE_POKEMON = "pokemons.xml";
    private static final String XML_FILE_ADESTRADOR = "adestrador.xml";

    public static SAXParser crearXMLPokedex(List<Pokedexes> pokedexes) {
        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        try {
            XMLStreamWriter writer = factory.createXMLStreamWriter((new FileWriter(XML_FILE_POKEDEX)));

            writer.writeStartDocument("1.0");
            writer.writeStartElement("pokedexes");

            for (Pokedexes pdex : pokedexes) {
                writer.writeStartElement("pokedex");
                writer.writeAttribute("id", String.valueOf(pdex.getId()));
                writer.writeStartElement("nombre");
                writer.writeCharacters(pdex.getNome());
                writer.writeEndElement();
                writer.writeStartElement("peso");
                writer.writeCharacters(pdex.getPeso().toString());
                writer.writeEndElement();
                writer.writeStartElement("misc");
                writer.writeCharacters(pdex.getMisc());
                writer.writeEndElement();
                writer.writeEndElement();
            }
            writer.writeEndElement();
            writer.writeEndDocument();
            writer.flush();
            writer.close();
            System.out.println("Archivo 'pokedexes.xml' creado con exito.");

        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static SAXParser crearXMLAdestrador(List<Adestrador> adestradores) {
        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        try {
            XMLStreamWriter writer = factory.createXMLStreamWriter((new FileWriter(XML_FILE_ADESTRADOR)));

            writer.writeStartDocument("1.0");
            writer.writeStartElement("adestradores");

            for (Adestrador adest : adestradores) {
                writer.writeStartElement("adestrador");
                writer.writeAttribute("id", String.valueOf(adest.getId()));
                writer.writeStartElement("nombre");
                writer.writeCharacters(adest.getNome());
                writer.writeEndElement();
                writer.writeStartElement("nacimiento");
                writer.writeCharacters(String.valueOf(adest.getNacemente()));
                writer.writeEndElement();
                for (Pokemon pkm : adest.getPokemons()) {
                    writer.writeStartElement("pokemon");
                    writer.writeCharacters(pkm.getNome());
                    writer.writeEndElement();
                }
                writer.writeEndElement();
            }
            writer.writeEndElement();
            writer.writeEndDocument();
            writer.flush();
            writer.close();
            System.out.println("Archivo 'adestrador.xml' creado con exito.");

        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static SAXParser crearXMLPokemon(List<Pokemon> pokemons) {
        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        try {
            XMLStreamWriter writer = factory.createXMLStreamWriter((new FileWriter(XML_FILE_POKEMON)));

            writer.writeStartDocument("1.0");
            writer.writeStartElement("pokemons");

            for (Pokemon pkm : pokemons) {
                writer.writeStartElement("pokemon");
                writer.writeAttribute("id", String.valueOf(pkm.getId()));
                writer.writeStartElement("nombre");
                writer.writeCharacters(pkm.getNome());
                writer.writeEndElement();
                writer.writeStartElement("nacimiento");
                writer.writeCharacters(String.valueOf(pkm.getNacemento()));
                writer.writeEndElement();
                writer.writeStartElement("adestrador");
                writer.writeCharacters(pkm.getAdestrador().getNome());
                writer.writeEndElement();
                writer.writeStartElement("pokedex");
                writer.writeCharacters(pkm.getPokedex().getNome());
                writer.writeEndElement();
                writer.writeEndElement();
            }
            writer.writeEndElement();
            writer.writeEndDocument();
            writer.flush();
            writer.close();
            System.out.println("Archivo 'pokemons.xml' creado con exito.");

        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    /*public static SAXParser crearXMLTienda(List<InventarioTienda> inventarios) {
        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        try {
            XMLStreamWriter writer = factory.createXMLStreamWriter((new FileWriter(XML_FILE_TIENDAS)));

            writer.writeStartDocument("1.0");
            writer.writeStartElement("inventarios");

            for (InventarioTienda v : inventarios) {
                writer.writeStartElement("inventario");
                writer.writeAttribute("id", String.valueOf(v.getId()));
                writer.writeStartElement("id_vehiculo");
                writer.writeCharacters(String.valueOf(v.getid_vehiculo()));
                writer.writeEndElement();
                writer.writeStartElement("precio_mayorista");
                writer.writeCharacters(String.valueOf(v.getprezo_mayorista()));
                writer.writeEndElement();
                writer.writeStartElement("precio_venta");
                writer.writeCharacters(String.valueOf(v.getprezo_venta()));
                writer.writeEndElement();
                writer.writeStartElement("porcentaje_oferta");
                writer.writeCharacters(String.valueOf(v.getPorcentaxe_oferta()));
                writer.writeEndElement();
                writer.writeEndElement();
            }
            writer.writeEndElement();
            writer.writeEndDocument();
            writer.flush();
            writer.close();
            System.out.println("Archivo 'tiendas.xml' creado con exito.");

        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }*/
}