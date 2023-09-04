package br.com.imobilius2.domain.imovel;

import br.com.imobilius2.domain.endereco.Endereco;

public record DadosListagemImovel(
        Long id,
        TipoImovel tipoImovel,
        Categoria categoria,
        TipoAquisicao tipoAquisicao,
        StatusImovel status,
        String logradouro,
        String numero,
        String bairro,
        Zona zona,
//        Endereco endereco,
        Float valor) {

    public DadosListagemImovel(Imovel imovel) {
        this(imovel.getId(), imovel.getTipoImovel(), imovel.getCategoria(), imovel.getTipoAquisicao(), imovel.getStatus(), imovel.getEndereco().getLogradouro(), imovel.getEndereco().getNumero(),
                imovel.getEndereco().getBairro(), imovel.getEndereco().getZona(), imovel.getValor());
    }

//    public DadosListagemImovel(Imovel imovel) {
//        this(imovel.getId(), imovel.getTipoImovel(), imovel.getCategoria(), imovel.getTipoAquisicao(), imovel.getStatus(),
//                imovel.getEndereco(), imovel.getValor());
//    }


}
