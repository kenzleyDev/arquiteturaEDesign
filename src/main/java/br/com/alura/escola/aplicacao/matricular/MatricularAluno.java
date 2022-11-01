package br.com.alura.escola.aplicacao.matricular;

import br.com.alura.escola.domain.aluno.Aluno;
import br.com.alura.escola.repository.AlunoRepository;

public class MatricularAluno {

    private final AlunoRepository repository;

    public MatricularAluno(AlunoRepository repository) {
        this.repository = repository;
    }

    public void matricular(MatricularAlunoDTO dados) {
        Aluno novo = dados.criarAluno();
        repository.matricular(novo);
    }
}
