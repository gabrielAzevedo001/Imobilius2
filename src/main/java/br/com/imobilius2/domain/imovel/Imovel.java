package br.com.imobilius2.domain.imovel;

import br.com.imobilius2.domain.endereco.Endereco;
import br.com.imobilius2.domain.estrutura.Estrutura;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "imoveis")
@Entity(name = "Imovel")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Imovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo_imovel")
    @Enumerated(EnumType.STRING)
    private TipoImovel tipoImovel;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Embedded
    private Endereco endereco;

    @Embedded
    private Estrutura estrutura;

    private Float valor;
    private Float condominio;
    private Float iptu;

    @Column(name = "tipo_aquisicao")
    private TipoAquisicao tipoAquisicao;

    @Column(name = "status_imovel")
    @Enumerated(EnumType.STRING)
    private StatusImovel status;

    private Boolean ativo;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @Column(name = "descricao_opcional")
    private String descricaoOpcional;

    @Column(name = "documentacao_ok")
    private Boolean documentacaoOK;

    public Imovel(DadosCadastroImovel dados) {
        this.ativo = true;
        this.tipoImovel = dados.tipoImovel();
        this.categoria = dados.categoria();
        this.endereco = new Endereco(dados.endereco());
        this.estrutura = new Estrutura(dados.estrutura());
        this.valor = dados.valor();
        this.condominio = dados.condominio();
        this.iptu = dados.iptu();
        this.tipoAquisicao = dados.tipoAquisicao();
        this.status = StatusImovel.DISPONIVEL;
        this.dataCriacao = LocalDateTime.now();
        this.descricaoOpcional = dados.descricaoOpcional();
        this.documentacaoOK = dados.documentacaoOK();
    }


    public void atualizarInformacoes(DadosAtualizacaoImovel dados) {
        if(dados.tipoImovel() != null) {
            this.tipoImovel = dados.tipoImovel();
        }
        if(dados.categoria() != null) {
            this.categoria = dados.categoria();
        }
        if(dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }
        if(dados.estrutura() != null) {
            this.estrutura.atualizarInformacoes(dados.estrutura());
        }
        if(dados.valor() != null) {
            this.valor = dados.valor();
        }
        if(dados.condominio() != null) {
            this.condominio = dados.condominio();
        }
        if(dados.iptu() != null) {
            this.iptu = dados.iptu();
        }
        if(dados.tipoAquisicao() != null) {
            this.tipoAquisicao = dados.tipoAquisicao();
        }
        if(dados.status() != null) {
            this.status = dados.status();
        }
        if(dados.descricaoOpcional() != null) {
            this.descricaoOpcional = dados.descricaoOpcional();
        }
        if(dados.documentacaoOK() != null) {
            this.documentacaoOK = dados.documentacaoOK();
        }

    }

    public void excluir(Long id) {
        this.ativo = false;
    }

}
