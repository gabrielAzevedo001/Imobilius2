package br.com.imobilius2.domain.imovel;

import br.com.imobilius2.domain.endereco.DadosEndereco;
import br.com.imobilius2.domain.estrutura.DadosEstrutura;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

public record DadosCadastroImovel(
        @NotNull
        TipoImovel tipoImovel,
        @NotNull
        Categoria categoria,
        @NotNull
        @Valid
        DadosEndereco endereco,
        @NotNull
        @Valid
        DadosEstrutura estrutura,
        @NotNull
        TipoAquisicao tipoAquisicao,
        @NotNull
        Float valor,
        Float condominio,
        Float iptu,
        @CreationTimestamp
        LocalDateTime dataCriacao,
        String descricaoOpcional,
        Boolean documentacaoOK) {
}
