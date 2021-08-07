package com.dio.live.controledeponto.controller;

import com.dio.live.controledeponto.model.JornadaTrabalho;
import com.dio.live.controledeponto.service.JornadaTrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {

    @Autowired
    private JornadaTrabalhoService jornadaTrabalhoService;

    @GetMapping
    public List<JornadaTrabalho> listAll() {
        return jornadaTrabalhoService.listAll();
    }

    @GetMapping("/{idJornadaTrabalho}")
    public ResponseEntity<JornadaTrabalho> getById(@PathVariable("idJornadaTrabalho") Long idJornadaTrabalho) {
        return ResponseEntity.ok(jornadaTrabalhoService.findById(idJornadaTrabalho));
    }

    @PostMapping
    public ResponseEntity<JornadaTrabalho> createJornada(@RequestBody JornadaTrabalho jornadaTrabalho) {
        return ResponseEntity.ok(jornadaTrabalhoService.save(jornadaTrabalho));
    }

    @PutMapping
    public ResponseEntity<JornadaTrabalho> updateJornada(@RequestBody JornadaTrabalho jornadaTrabalho) {
        return ResponseEntity.ok(jornadaTrabalhoService.update(jornadaTrabalho));
    }

    @DeleteMapping("/{idJornadaTrabalho}")
    public void deleteJornada(@PathVariable("idJornadaTrabalho") Long idJornadaTrabalho) {
        jornadaTrabalhoService.delete(idJornadaTrabalho);
    }

}
