package br.ETS.Feedback.model.aprendiz;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AprendizRepository extends JpaRepository<Aprendiz, Integer> {

    List<Aprendiz> findAllByAtivoTrue();
}
