package br.com.sevencomm.nerdevs.domain.servicesImpl;

import br.com.sevencomm.nerdevs.application.dto.QuestionDTO;
import br.com.sevencomm.nerdevs.application.dto.VagaDTO;
import br.com.sevencomm.nerdevs.application.services.VagaService;
import br.com.sevencomm.nerdevs.data.repositories.AnswerRepository;
import br.com.sevencomm.nerdevs.data.repositories.QuestionRepository;
import br.com.sevencomm.nerdevs.data.repositories.UserRepository;
import br.com.sevencomm.nerdevs.data.repositories.VagaRepository;
import br.com.sevencomm.nerdevs.domain.models.Answer;
import br.com.sevencomm.nerdevs.domain.models.Question;
import br.com.sevencomm.nerdevs.domain.models.User;
import br.com.sevencomm.nerdevs.domain.models.Vaga;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VagaServiceImpl implements VagaService {

    private VagaRepository vagaRepository;
    private QuestionRepository questionRepository;
    private UserRepository userRepository;
    private AnswerRepository answerRepository;

    public VagaServiceImpl(VagaRepository vagaRepository, QuestionRepository questionRepository, UserRepository userRepository, AnswerRepository answerRepository) {
        this.vagaRepository = vagaRepository;
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
        this.answerRepository = answerRepository;
    }

    @Override
    public List<VagaDTO> listVagas() {

        return vagaRepository.findAll().stream().map(VagaDTO::toDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<VagaDTO> getVagaById(Long vagaId) {

        return vagaRepository.findById(vagaId).map(VagaDTO::toDTO);
    }

    @Override
    public Vaga insertVaga(Vaga vaga) {
        Assert.isNull(vaga.getVagaId(), "Não foi possível inserir o registro");

        return vagaRepository.save(vaga);
    }

    @Override
    public Question insertQuestion(Question question) {
        Assert.isNull(question.getId(), "Não foi possível inserir o registro");

        return questionRepository.save(question);
    }

    @Override
    public List<QuestionDTO> getQuestion(Long vagaId) {
        Vaga vaga = vagaRepository.findById(vagaId).get();

        return vaga.getQuestions().stream().map(QuestionDTO::toDTO).collect(Collectors.toList());
    }

    @Override
    public Answer insertAnswer(Answer answer, Long userId, Long questionId) {
        User user = userRepository.findById(userId).get();
        Question question = questionRepository.findById(questionId).get();

        answer.setUser(user);
        answer.setQuestion(question);

        return answerRepository.save(answer);
    }

    public String verifyApply(Long vagaId, Long userId) {
        User user = userRepository.findById(userId).get();
        List<Answer> answers = answerRepository.findByUser(user);

        int acmNota = 0;

        for (int i = 0; i < answers.size(); i++) {
            if (answers.get(i).getQuestion().getVaga().getVagaId() == vagaId) {
                int respostaDoUsuario = answers.get(i).getAnswer();
                int respostaCorreta = answers.get(i).getQuestion().getAnswer();

                if (respostaDoUsuario == respostaCorreta) {
                    acmNota++;
                }
            }
        }

        Vaga vaga = vagaRepository.findById(vagaId).get();

        if (acmNota >= vaga.getMinimumScore()) {
            vaga.getUsers().add(user);
            vagaRepository.save(vaga);

            return "Parabéns, você se candidatou para a vaga!";
        }

        return "Infelizmente você não atingiu o score mínimo para a vaga";
    }

}