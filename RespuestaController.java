package com.alura.foroapi.controller;

import com.alura.foroapi.entity.Respuesta;
import com.alura.foroapi.entity.Topico;
import com.alura.foroapi.repository.RespuestaRepository;
import com.alura.foroapi.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity<Respuesta> agregarRespuesta(@RequestParam Long topicoId, @RequestBody Respuesta respuesta) {
        return topicoRepository.findById(topicoId).map(topico -> {
            respuesta.setTopico(topico);
            Respuesta nuevaRespuesta = respuestaRepository.save(respuesta);
            return ResponseEntity.ok(nuevaRespuesta);
        }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Respuesta> obtenerRespuesta(@PathVariable Long id) {
        return respuestaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
