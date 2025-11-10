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
}
