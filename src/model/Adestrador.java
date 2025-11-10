package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "adestrador")
public class Adestrador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "nacemente")
    @Temporal(TemporalType.DATE)
    private Date nacemente;

    @OneToMany(mappedBy = "")

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

    public Date getNacemente() {
        return nacemente;
    }

    public void setNacemente(Date nacemente) {
        this.nacemente = nacemente;
    }

    @Override
    public String toString() {
        return "Adestrador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nacemente=" + nacemente +
                '}';
    }


}
