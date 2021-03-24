package br.com.sevencomm.nerdevs.application.dto;

import br.com.sevencomm.nerdevs.domain.models.Question;
import br.com.sevencomm.nerdevs.domain.models.Vaga;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class VagaDTO {

    private Long vagaId;
    private String titulo;
    private String description;
    private List<String> questions;

    public VagaDTO() {}

    public VagaDTO(Long vagaId, String titulo, String description, List<String> questions) {
        this.vagaId = vagaId;
        this.titulo = titulo;
        this.description = description;
        this.questions = questions;
    }

    public static VagaDTO toDTO (Vaga vaga) {
        ModelMapper modelMapper = new ModelMapper();
        VagaDTO vagaDTO = modelMapper.map(vaga, VagaDTO.class);

        if (vaga.getQuestions() != null) vagaDTO.questions = vaga.getQuestions().stream().map(Question::getQuestion).collect(Collectors.toList());

        return vagaDTO;
    }

    public Long getVagaId() { return vagaId; }

    public void setVagaId(Long vagaId) { this.vagaId = vagaId; }

    public String getTitulo() { return titulo; }

    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public List<String> getQuestions() { return questions; }

    public void setQuestions(List<String> questions) { this.questions = questions; }

}
