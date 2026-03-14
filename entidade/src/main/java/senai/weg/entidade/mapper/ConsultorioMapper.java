package senai.weg.entidade.mapper;


import org.springframework.stereotype.Component;
import senai.weg.entidade.dto.ConsultorioRequestDto;
import senai.weg.entidade.dto.ConsultorioResponseDto;
import senai.weg.entidade.entity.Consultorio;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ConsultorioMapper {
    public Consultorio toEntity(ConsultorioRequestDto dto){
        if (dto == null){
            return null;
        }

        Consultorio consultorio = new Consultorio();
        consultorio.setNome(dto.getNome());
        consultorio.setEndereco(dto.getEndereco());
        consultorio.setTelefone(dto.getTelefone());
        consultorio.setEmail(dto.getEmail());
        consultorio.setCnpj(dto.getCnpj());

        return consultorio;
    }

    public ConsultorioResponseDto toResponseDto(Consultorio consultorio){
        if(consultorio == null){
            return null;
        }

        ConsultorioResponseDto dto = new ConsultorioResponseDto();
        dto.setId(consultorio.getId());
        dto.setNome(consultorio.getNome());
        dto.setEndereco(consultorio.getEndereco());
        dto.setTelefone(consultorio.getTelefone());
        dto.setEmail(consultorio.getEmail());
        dto.setCnpj(consultorio.getCnpj());

        return dto;
    }

    public List<ConsultorioResponseDto> toResponseDtoList(List<Consultorio> consultorios){
        if(consultorios == null){
            return null;
        }

        return consultorios.stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    public void updateEntityFromDto(ConsultorioRequestDto dto, Consultorio consultorio){
        if(dto == null || consultorio == null){
            return;
        }

        if(dto.getNome() != null){
            consultorio.setNome(dto.getNome());
        }
        if (dto.getEndereco() != null) {
            consultorio.setEndereco(dto.getEndereco());
        }
        if( dto.getTelefone() != null){
            consultorio.setTelefone((dto.getTelefone()));
        }
        if(dto.getEmail() != null){
            consultorio.setEmail(dto.getEmail());
        }
    }
}
