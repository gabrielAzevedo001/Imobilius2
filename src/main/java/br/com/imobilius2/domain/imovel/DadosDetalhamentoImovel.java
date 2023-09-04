package br.com.imobilius2.domain.imovel;

import br.com.imobilius2.domain.endereco.DadosEndereco;
import br.com.imobilius2.domain.endereco.Endereco;
import br.com.imobilius2.domain.estrutura.DadosEstrutura;
import br.com.imobilius2.domain.estrutura.Estrutura;

import java.time.LocalDateTime;

public record DadosDetalhamentoImovel(
        Long id,
        TipoImovel tipoImovel,
        Categoria categoria,
        Endereco endereco,
        Estrutura estrutura,
        TipoAquisicao tipoAquisicao,
        StatusImovel status,
        Float valor,
        Float condominio,
        Float iptu,
        LocalDateTime dataCriacao,
        String descricaoOpcional,
        Boolean documentacaoOK) {

    public DadosDetalhamentoImovel(Imovel imovel) {
        this(imovel.getId(), imovel.getTipoImovel(), imovel.getCategoria(), imovel.getEndereco(), imovel.getEstrutura(),
                imovel.getTipoAquisicao(), imovel.getStatus(), imovel.getValor(), imovel.getCondominio(), imovel.getIptu(),
                imovel.getDataCriacao(), imovel.getDescricaoOpcional(), imovel.getDocumentacaoOK());
    }
}
