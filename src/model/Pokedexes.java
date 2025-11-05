package model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "pokedex")
public class Pokedexes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "peso", precision = 10, scale = 2)
    private Double peso;

    @Column(name = "misc")
    private String Misc;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getMisc() {
        return Misc;
    }

    public void setMisc(String misc) {
        Misc = misc;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", peso=" + peso +
                ", Misc='" + Misc + '\'';
    }
}
