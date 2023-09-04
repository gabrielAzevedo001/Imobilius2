package br.com.imobilius2.domain.imovel;

import br.com.imobilius2.domain.endereco.DadosEndereco;
import br.com.imobilius2.domain.estrutura.DadosEstrutura;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoImovel(
        @NotNull
        Long id,
        TipoImovel tipoImovel,
        Categoria categoria,
        DadosEndereco endereco,
        DadosEstrutura estrutura,
        Float valor,
        Float condominio,
        Float iptu,
        TipoAquisicao tipoAquisicao,
        StatusImovel status,
        String descricaoOpcional,
        Boolean documentacaoOK) {
}
