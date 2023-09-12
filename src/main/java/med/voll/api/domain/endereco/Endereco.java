package med.voll.api.domain.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

        private String logradouro;
        private String bairro;
        private String cidade;
        private String cep;
        private String uf;
        private String complemento;
        private String numero;

        public Endereco(DadosEndereco dados) {
                this.logradouro = dados.logradouro();
                this.bairro = dados.bairro();
                this.cidade = dados.cidade();
                this.cep = dados.cep();
                this.uf = dados.uf();
                this.complemento = dados.complemento();
                this.numero = dados.numero();
        }

        public void atualizarInformacoes(DadosEndereco dados) {
                if(dados.logradouro() != null) {
                        this.logradouro = dados.logradouro();
                }
                if(dados.bairro() != null) {
                        this.bairro = dados.bairro();
                }
                if(dados.cidade() != null) {
                        this.cidade = dados.cidade();
                }
                if(dados.cep() != null) {
                        this.cep = dados.cep();
                }
                if(dados.uf() != null) {
                        this.uf = dados.uf();
                }
                if(dados.complemento() != null) {
                        this.complemento = dados.complemento();
                }
                if(dados.numero() != null) {
                        this.numero = dados.numero();
                }

        }
}
