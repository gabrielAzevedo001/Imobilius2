package br.com.imobilius2.domain.estrutura;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Estrutura {
    private Integer quartos;
    private Integer suites;
    private Integer banheiros;
    @Column(name = "vagas_garagem")
    private Integer vagasGaragem;
    @Column(name = "area_total")
    private Float areaTotal;
    @Column(name = "area_util")
    private Float areaUtil;
    private Integer andares;
    @Column(name = "ano_construcao")
    private Integer anoConstrucao;

    public Estrutura(DadosEstrutura dados) {
        this.quartos = dados.quartos();
        this.banheiros = dados.banheiros();
        this.suites = dados.suites();
        this.vagasGaragem = dados.vagasGaragem();
        this.areaTotal = dados.areaTotal();
        this.areaUtil = dados.areaUtil();
        this.andares = dados.andares();
        this.anoConstrucao = dados.anoConstrucao();
    }

    public void atualizarInformacoes(DadosEstrutura dados) {
        if(dados.quartos() != null) {
            this.quartos = dados.quartos();
        }
        if(dados.banheiros() != null) {
            this.banheiros = dados.banheiros();
        }
        if(dados.suites() != null) {
            this.suites = dados.suites();
        }
        if(dados.vagasGaragem() != null) {
            this.vagasGaragem = dados.vagasGaragem();
        }
        if(dados.areaTotal() != null) {
            this.areaTotal = dados.areaTotal();
        }
        if(dados.areaUtil() != null) {
            this.areaUtil = dados.areaUtil();
        }
        if(dados.andares() != null) {
            this.andares = dados.andares();
        }
        if(dados.anoConstrucao() != null) {
            this.anoConstrucao = dados.anoConstrucao();
        }
    }

}
