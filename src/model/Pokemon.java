package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pokemon")
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "nacemento")
    @Temporal(TemporalType.DATE)
    private Date nacemento;

    @ManyToOne
    @JoinColumn(name = "adestrador") //FK para entrenador
    private Adestrador adestrador;

    @ManyToOne
    @JoinColumn(name = "pokedex") //FK para pokedex
    private Pokedexes pokedex;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Adestrador getAdestrador() {
        return adestrador;
    }

    public void setAdestrador(Adestrador adestrador) {
        this.adestrador = adestrador;
    }

    public Date getNacemento() {
        return nacemento;
    }

    public void setNacemento(Date nacemento) {
        this.nacemento = nacemento;
    }

    public Pokedexes getPokedex() {
        return pokedex;
    }

    public void setPokedex(Pokedexes pokedex) {
        this.pokedex = pokedex;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nacemento=" + nacemento +
                ", adestrador=" + adestrador +
                ", pokedex=" + pokedex +
                '}';
    }
}

