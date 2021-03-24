package br.com.sevencomm.nerdevs.data.repositories;

import br.com.sevencomm.nerdevs.domain.models.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VagaRepository extends JpaRepository<Vaga, Long> {

    List<Vaga> findByTitulo(String titulo);

}
