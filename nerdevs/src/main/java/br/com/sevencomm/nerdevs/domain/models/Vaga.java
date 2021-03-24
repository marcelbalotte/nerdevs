package br.com.sevencomm.nerdevs.domain.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vagaId;

    private String titulo;
    private String description;
    private int minimumScore;

    @OneToMany(mappedBy = "vaga")
    private List<Question> questions;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vaga_user",
            joinColumns = @JoinColumn(name = "vaga_id", referencedColumnName = "vagaId"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private List<User> users;

    public Vaga() {}

    public Vaga(Long id, String titulo, String description) {
        this.vagaId = id;
        this.titulo = titulo;
        this.description = description;
    }

    public Long getVagaId() { return vagaId; }

    public void setVagaId(Long vagaId) { this.vagaId = vagaId; }

    public String getTitulo() { return titulo; }

    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public int getMinimumScore() { return minimumScore; }

    public void setMinimumScore(int minimumScore) { this.minimumScore = minimumScore; }

    public List<Question> getQuestions() { return questions; }

    public void setQuestions(List<Question> questions) { this.questions = questions; }

    public List<User> getUsers() { return users; }

    public void setUsers(List<User> users) { this.users = users; }

}
