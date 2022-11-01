package br.com.alura.escola.repository;

import br.com.alura.escola.domain.aluno.Aluno;
import br.com.alura.escola.domain.aluno.Cpf;

import java.util.List;

public interface AlunoRepository {

    void matricular(Aluno aluno);

    Aluno buscarAlunoPorCPF(Cpf cpf);

    List<Aluno> listarTodosAlunosMatriculados();

}
