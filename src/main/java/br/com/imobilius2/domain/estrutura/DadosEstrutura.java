package br.com.imobilius2.domain.estrutura;

import jakarta.validation.constraints.NotNull;

public record DadosEstrutura(
        @NotNull
        Integer quartos,
        @NotNull
        Integer banheiros,
        Integer suites,
        @NotNull
        Integer vagasGaragem,
        @NotNull
        Float areaTotal,
        Float areaUtil,
        @NotNull
        Integer andares,
        Integer anoConstrucao) {

}
