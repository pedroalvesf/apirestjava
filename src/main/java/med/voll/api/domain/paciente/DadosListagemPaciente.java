package med.voll.api.domain.paciente;

import med.voll.api.domain.endereco.Endereco;

public record DadosListagemPaciente(String nome, String email, String cpf, String telefone,
        Endereco endereco) {
    public DadosListagemPaciente(Paciente paciente) {
        this(paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getTelefone(),
                paciente.getEndereco());
    }
}
