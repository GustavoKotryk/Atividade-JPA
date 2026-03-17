package senai.weg.entidade.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dados para cadastro ou atualização de um consultório")
public class ConsultorioRequestDto {

    @Schema(
            description = "Nome do consultório",
            example = "Clínica São Lucas",
            requiredMode = Schema.RequiredMode.REQUIRED,
            minLength = 3,
            maxLength = 100
    )
    private String nome;

    @Schema(
            description = "Endereço completo do consultório",
            example = "Rua das Flores, 123 - Centro, São Paulo - SP",
            requiredMode = Schema.RequiredMode.REQUIRED,
            minLength = 5,
            maxLength = 200
    )
    private String endereco;

    @Schema(
            description = "Telefone para contato",
            example = "(11) 3456-7890",
            pattern = "^\\(?[1-9]{2}\\)? ?(?:[2-8]|9[1-9])[0-9]{3}\\-?[0-9]{4}$"
    )
    private String telefone;

    @Schema(
            description = "E-mail de contato",
            example = "contato@clinicasaolucas.com.br",
            pattern = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$"
    )
    private String email;

    @Schema(
            description = "CNPJ do consultório (com ou sem pontuação)",
            example = "12.345.678/0001-90",
            requiredMode = Schema.RequiredMode.REQUIRED,
            pattern = "^\\d{2}\\.?\\d{3}\\.?\\d{3}\\/?\\d{4}\\-?\\d{2}$"
    )
    private String cnpj;
}