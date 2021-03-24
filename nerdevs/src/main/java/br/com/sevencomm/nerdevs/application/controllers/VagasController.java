package br.com.sevencomm.nerdevs.application.controllers;

import br.com.sevencomm.nerdevs.application.dto.AnswerDTO;
import br.com.sevencomm.nerdevs.application.services.VagaService;
import br.com.sevencomm.nerdevs.domain.models.Answer;
import br.com.sevencomm.nerdevs.domain.models.Question;
import br.com.sevencomm.nerdevs.domain.models.Vaga;
import br.com.sevencomm.nerdevs.application.dto.VagaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vagas")
public class VagasController {

    private VagaService vagaService;

    public VagasController(VagaService vagaService) { this.vagaService = vagaService; }

    //Funções das vagas
    @GetMapping("/list-vagas")
    public ResponseEntity listVagas() {
        try {

            return ResponseEntity.ok(vagaService.listVagas());
        } catch (Exception ex) {

            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/get-vaga-by-id")
    public ResponseEntity getVagaById(@RequestParam("vagaId") Long vagaId) {
        Optional<VagaDTO> vaga = vagaService.getVagaById(vagaId);

        if (vaga.isPresent()) {
            return ResponseEntity.ok(vaga.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Secured({ "ROLE_ADMIN" })
    @PostMapping("/insert-vaga")
    public ResponseEntity insertVaga(@RequestBody Vaga vaga) {
        try {

            return ResponseEntity.ok().body(VagaDTO.toDTO(vagaService.insertVaga(vaga)));
        } catch (Exception ex) {

            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    //Funções das questions
    @GetMapping("/list-questions-by-vaga")
    public ResponseEntity listQuestionsByVaga(@RequestParam("vagaId") Long vagaId) {
        try {

            return ResponseEntity.ok().body(vagaService.getQuestion(vagaId));
        } catch (Exception ex) {

            return ResponseEntity.badRequest().build();
        }
    }

    @Secured({ "ROLE_ADMIN" })
    @PostMapping("/insert-question")
    public ResponseEntity insertQuestion(@RequestBody Question question) {
        try {

            return ResponseEntity.ok().body(vagaService.insertQuestion(question));
        } catch (Exception ex) {

            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    //Funções das answers
    @PostMapping("/insert-answer")
    public ResponseEntity insertAnswer(@RequestBody Answer answer, @RequestParam("userId") Long userId, @RequestParam("questionId") Long questionId) {
        try {

            return ResponseEntity.ok().body(AnswerDTO.toDTO(vagaService.insertAnswer(answer, userId, questionId)));
        } catch (Exception ex) {

            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    //Funções para candidatar
    @PostMapping("/apply")
    public ResponseEntity apply(@RequestParam("vagaId") Long vagaId, @RequestParam("userId") Long userId) {
        try {

            return ResponseEntity.ok().body(vagaService.verifyApply(vagaId, userId));
        } catch (Exception ex){

            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

}
