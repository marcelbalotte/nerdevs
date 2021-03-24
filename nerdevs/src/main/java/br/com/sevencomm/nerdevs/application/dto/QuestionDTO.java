package br.com.sevencomm.nerdevs.application.dto;

import br.com.sevencomm.nerdevs.domain.models.Question;
import org.modelmapper.ModelMapper;

public class QuestionDTO {

    private Long id;
    private String question;

    public QuestionDTO() {}

    public QuestionDTO(Long id, String question) {
        this.id = id;
        this.question = question;
    }

    public static QuestionDTO toDTO (Question question) {
        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(question, QuestionDTO.class);
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getQuestion() { return question; }

    public void setQuestion(String question) { this.question = question; }

}
