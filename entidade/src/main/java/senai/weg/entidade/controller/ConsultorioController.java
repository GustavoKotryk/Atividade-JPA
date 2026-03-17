package senai.weg.entidade.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Consultórios", description = "Endpoints para gerenciamento de consultórios")
public class ConsultorioController {

    @Autowired
    private ConsultorioService service;

    @PostMapping
    @Operation(summary = "Cadastrar um novo consultório", description = "Cria um novo consultório no sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Consultório criado com sucesso",
                    content = @Content(schema = @Schema(implementation = ConsultorioResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos ou CNPJ já existente")
    })
    public ResponseEntity<ConsultorioResponseDto> salvar(@RequestBody ConsultorioRequestDto dto){
        ConsultorioResponseDto response = service.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    @Operation(summary = "Listar todos os consultórios", description = "Retorna uma lista com todos os consultórios cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista de consultórios retornada com sucesso")
    public ResponseEntity<List<ConsultorioResponseDto>> listarTodos(){
        List<ConsultorioResponseDto> response = service.listarTodos();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar consultório por ID", description = "Retorna um consultório específico baseado no ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consultório encontrado"),
            @ApiResponse(responseCode = "404", description = "Consultório não encontrado")
    })
    public ResponseEntity<ConsultorioResponseDto> buscarPorId(
            @Parameter(description = "ID do consultório a ser buscado", required = true)
            @PathVariable Long id){
        ConsultorioResponseDto response = service.buscarPorId(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/busca")
    @Operation(summary = "Buscar consultórios por nome", description = "Retorna consultórios cujo nome contenha o termo buscado (ignorando maiúsculas/minúsculas)")
    @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso")
    public ResponseEntity<List<ConsultorioResponseDto>> buscarPorNome(
            @RequestParam String nome){
        List<ConsultorioResponseDto> response = service.buscarPorNome(nome);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um consultório", description = "Atualiza os dados de um consultório existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consultório atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Consultório não encontrado")
    })
    public ResponseEntity<ConsultorioResponseDto> atualizar(
            @PathVariable Long id,
            @RequestBody ConsultorioRequestDto dto){
        ConsultorioResponseDto response = service.atualizar(id, dto);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(
            @Parameter(description = "ID do consultório a ser deletado", required = true)
            @PathVariable Long id){
        service.deletar(id);

        return ResponseEntity.noContent().build();
    }
}
