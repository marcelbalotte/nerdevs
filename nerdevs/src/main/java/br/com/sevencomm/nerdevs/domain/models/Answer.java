package br.com.sevencomm.nerdevs.domain.models;

import javax.persistence.*;

@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int answer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "question_id")
    private Question question;

    public Answer() {}

    public Answer(Long id, int answer, User user, Question question) {
        this.id = id;
        this.answer = answer;
        this.user = user;
        this.question = question;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public int getAnswer() { return answer; }

    public void setAnswer(int answer) { this.answer = answer; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Question getQuestion() { return question; }

    public void setQuestion(Question question) { this.question = question; }

}