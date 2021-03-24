package br.com.sevencomm.nerdevs.domain.models;

import javax.persistence.*;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String question;
    private int answer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vaga_id")
    private Vaga vaga;

    public Question() {}

    public Question(Long id, String question, int answer, Vaga vaga) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.vaga = vaga;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getQuestion() { return question; }

    public void setQuestion(String question) { this.question = question; }

    public int getAnswer() { return answer; }

    public void setAnswer(int answer) { this.answer = answer; }

    public Vaga getVaga() { return vaga; }

    public void setVaga(Vaga vaga) { this.vaga = vaga; }

}
