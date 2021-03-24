package br.com.sevencomm.nerdevs.application.services;

import br.com.sevencomm.nerdevs.application.dto.QuestionDTO;
import br.com.sevencomm.nerdevs.application.dto.VagaDTO;
import br.com.sevencomm.nerdevs.domain.models.Answer;
import br.com.sevencomm.nerdevs.domain.models.Question;
import br.com.sevencomm.nerdevs.domain.models.Vaga;

import java.util.List;
import java.util.Optional;

public interface VagaService {

    List<VagaDTO> listVagas();

    Optional<VagaDTO> getVagaById(Long vagaId);

    Vaga insertVaga(Vaga vaga);

    Question insertQuestion(Question question);

    List<QuestionDTO> getQuestion(Long vagaId);

    Answer insertAnswer(Answer answer, Long userId, Long questionId);

    String verifyApply(Long vagaId, Long userId);

}
