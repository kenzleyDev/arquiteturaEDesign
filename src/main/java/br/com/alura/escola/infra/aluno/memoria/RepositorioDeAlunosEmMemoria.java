package br.com.alura.escola.infra.aluno.memoria;

import br.com.alura.escola.domain.aluno.Aluno;
import br.com.alura.escola.domain.aluno.Cpf;
import br.com.alura.escola.exceptions.AlunoNaoEncontrado;
import br.com.alura.escola.repository.AlunoRepository;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDeAlunosEmMemoria implements AlunoRepository {


    private List<Aluno> matriculados = new ArrayList<>();

    @Override
    public void matricular(Aluno aluno) {
        this.matriculados.add(aluno);
    }

    @Override
    public Aluno buscarAlunoPorCPF(Cpf cpf) {
        return this.matriculados.stream()
                .filter(a -> a.getCpf().equals(cpf.getCpf()))
                .findFirst()
                .orElseThrow(() -> new AlunoNaoEncontrado(cpf));
    }

    @Override
    public List<Aluno> listarTodosAlunosMatriculados() {
        return this.matriculados;
    }
}
