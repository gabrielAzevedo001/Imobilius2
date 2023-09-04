package br.com.imobilius2.domain.endereco;

import br.com.imobilius2.domain.imovel.Zona;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    @Enumerated(EnumType.STRING)
    private Zona zona;

    public Endereco(DadosEndereco dados) {
        this.cep = dados.cep();
        this.logradouro = dados.logradouro();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
        this.bairro = dados.bairro();
        this.zona = dados.zona();
    }

    public void atualizarInformacoes(DadosEndereco dados) {
        if(dados.cep() != null) {
            this.cep = dados.cep();
        }
        if(dados.logradouro() != null) {
            this.logradouro = dados.logradouro();
        }
        if(dados.numero() != null) {
            this.numero = dados.numero();
        }
        if(dados.complemento() != null) {
            this.complemento = dados.complemento();
        }
        if(dados.bairro() != null) {
            this.bairro = dados.bairro();
        }
        if(dados.zona() != null) {
            this.zona = dados.zona();
        }
    }

}
