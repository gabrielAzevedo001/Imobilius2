package br.com.imobilius2.domain.endereco;

import br.com.imobilius2.domain.imovel.Zona;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(
        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String cep,
        @NotBlank
        String logradouro,
        @NotBlank
        String numero,
        String complemento,
        @NotBlank
        String bairro,
        Zona zona) {

}
