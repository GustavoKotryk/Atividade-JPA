package senai.weg.entidade.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import senai.weg.entidade.dto.request.ConsultorioRequestDto;
import senai.weg.entidade.dto.response.ConsultorioResponseDto;
import senai.weg.entidade.service.ConsultorioService;

import java.util.List;

@RestController
@RequestMapping("/consultorio")
public class ConsultorioController {

    @Autowired
    private ConsultorioService service;

    @PostMapping
    public ResponseEntity<ConsultorioResponseDto> salvar(@RequestBody ConsultorioRequestDto dto){
        ConsultorioResponseDto response = service.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ConsultorioResponseDto>> listarTodos(){
        List<ConsultorioResponseDto> response = service.listarTodos();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultorioResponseDto> buscarPorId(@PathVariable Long id){
        ConsultorioResponseDto response = service.buscarPorId(id);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/busca")
    public ResponseEntity<List<ConsultorioResponseDto>> buscarPorNome(@RequestParam String nome){
        List<ConsultorioResponseDto> response = service.buscarPorNome(nome);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultorioResponseDto> atualizar(
            @PathVariable Long id,
            @RequestBody ConsultorioRequestDto dto){
        ConsultorioResponseDto response = service.atualizar(id, dto);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);

        return ResponseEntity.noContent().build();
    }
}
