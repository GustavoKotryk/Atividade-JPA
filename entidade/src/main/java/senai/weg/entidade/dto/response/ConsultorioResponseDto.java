package senai.weg.entidade.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dados de retorno de um consultório")
public class ConsultorioResponseDto {

    @Schema(
            description = "ID único do consultório (gerado automaticamente)",
            example = "1",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long id;

    @Schema(
            description = "Nome do consultório",
            example = "Clínica São Lucas"
    )
    private String nome;

    @Schema(
            description = "Endereço completo do consultório",
            example = "Rua das Flores, 123 - Centro, São Paulo - SP"
    )
    private String endereco;

    @Schema(
            description = "Telefone para contato",
            example = "(11) 3456-7890"
    )
    private String telefone;

    @Schema(
            description = "E-mail de contato",
            example = "contato@clinicasaolucas.com.br"
    )
    private String email;

    @Schema(
            description = "CNPJ do consultório",
            example = "12.345.678/0001-90"
    )
    private String cnpj;
}