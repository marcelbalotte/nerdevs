package br.com.sevencomm.nerdevs.application.dto;

import br.com.sevencomm.nerdevs.domain.models.Answer;
import org.modelmapper.ModelMapper;

public class AnswerDTO {

    private int answer;
    private String user;
    private String question;

    public AnswerDTO() {}

    public AnswerDTO(int answer, String user, String question) {
        this.answer = answer;
        this.user = user;
        this.question = question;
    }

    public static AnswerDTO toDTO (Answer answer) {
        ModelMapper modelMapper = new ModelMapper();
        AnswerDTO answerDTO = modelMapper.map(answer, AnswerDTO.class);

        answerDTO.setUser(answer.getUser().getUsername());
        answerDTO.setQuestion(answer.getQuestion().getQuestion());

        return answerDTO;
    }

    public int getAnswer() { return answer; }

    public void setAnswer(int answer) { this.answer = answer; }

    public String getUser() { return user; }

    public void setUser(String user) { this.user = user; }

    public String getQuestion() { return question; }

    public void setQuestion(String question) { this.question = question; }

}
