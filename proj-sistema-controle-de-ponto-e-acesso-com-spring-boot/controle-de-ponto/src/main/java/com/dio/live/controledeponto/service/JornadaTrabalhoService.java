package com.dio.live.controledeponto.service;

import com.dio.live.controledeponto.model.JornadaTrabalho;
import com.dio.live.controledeponto.repository.JornadaTrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JornadaTrabalhoService {

    @Autowired
    private JornadaTrabalhoRepository jornadaTrabalhoRepository;

    public JornadaTrabalho save(JornadaTrabalho jornadaTrabalho) {
        return jornadaTrabalhoRepository.save(jornadaTrabalho);
    }

    public JornadaTrabalho update(JornadaTrabalho jornadaTrabalho) {
        return save(jornadaTrabalho);
    }

    public void delete(Long idJornadaTrabalho) {
        JornadaTrabalho jornadaTrabalho = findById(idJornadaTrabalho);
        jornadaTrabalhoRepository.delete(jornadaTrabalho);
    }

    public List<JornadaTrabalho> listAll() {
        return jornadaTrabalhoRepository.findAll();
    }

    public JornadaTrabalho findById(Long idJornadaTrabalho) {
        return jornadaTrabalhoRepository.findById(idJornadaTrabalho)
                .orElseThrow(() -> new RuntimeException("Jornada de Trabalho não encontrada."));
    }
}
