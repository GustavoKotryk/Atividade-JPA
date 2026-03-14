package senai.weg.entidade.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import senai.weg.entidade.dto.request.ConsultorioRequestDto;
import senai.weg.entidade.dto.response.ConsultorioResponseDto;
import senai.weg.entidade.entity.Consultorio;
import senai.weg.entidade.mapper.ConsultorioMapper;
import senai.weg.entidade.repository.ConsultorioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultorioService {

    @Autowired
    private ConsultorioRepository repository;

    @Autowired
    private ConsultorioMapper mapper;

    public ConsultorioResponseDto salvar(ConsultorioRequestDto dto){
        Consultorio consultorio = mapper.toEntity(dto);

        if(repository.existsByCnpj(consultorio.getCnpj())){
            throw new RuntimeException("Já existe um consultório com esse cnpj registrado!");
        }

        Consultorio salvo = repository.save(consultorio);

        return mapper.toResponseDto(salvo);
    }

    public List<ConsultorioResponseDto> listarTodos(){
        List<Consultorio> consultorios = repository.findAll();

        return mapper.toResponseDtoList(consultorios);
    }

    public ConsultorioResponseDto buscarPorId(Long id) {
        Optional<Consultorio> consultorioOpt = repository.findById(id);

        if(consultorioOpt.isPresent()){
            return mapper.toResponseDto(consultorioOpt.get());
        } else {
            throw new RuntimeException("Nenhum consultorio encontrado");
        }
    }

    public List<ConsultorioResponseDto> buscarPorNome(String nome){
        List<Consultorio> consultorios = repository.findByNomeContainingIgnoreCase(nome);

        return mapper.toResponseDtoList(consultorios);
    }

    public ConsultorioResponseDto atualizar(Long id, ConsultorioRequestDto dto){
        if(id == null){
            throw new RuntimeException("ID não pode ser nulo para realizar o UPDATE");
        }

        Consultorio consutorioExistente = repository.findById(id)
                        .orElseThrow(()-> new RuntimeException("Consultorio não encontrado"));

        mapper.updateEntityFromDto(dto, consutorioExistente);

        Consultorio atualizado = repository.save(consutorioExistente);

        return mapper.toResponseDto(atualizado);
    }

    public void deletar(Long id){
        if(!repository.existsById(id)){
            throw new RuntimeException("Consultorio não encontrao!");
        }
        repository.deleteById(id);
    }
}
