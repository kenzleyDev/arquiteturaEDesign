package br.com.alura.escola.aplicacao.matricular;

import br.com.alura.escola.domain.aluno.Aluno;
import br.com.alura.escola.domain.aluno.Cpf;
import br.com.alura.escola.infra.aluno.memoria.RepositorioDeAlunosEmMemoria;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatricularAlunoTest {

    @Test
    void alunoDeveriaSerPersistido() {

        RepositorioDeAlunosEmMemoria repositorio = new RepositorioDeAlunosEmMemoria();
        MatricularAluno useCase = new MatricularAluno(repositorio);

        MatricularAlunoDTO dados = new MatricularAlunoDTO("Fulano", "123.456.789-00", "fulano@gmail.com");
        useCase.matricular(dados);

        Aluno encontrado =   repositorio.buscarAlunoPorCPF(new Cpf("123.456.789-00"));

        assertEquals("Fulano", encontrado.getNome());
        assertEquals("123.456.789-00", encontrado.getCpf());
        assertEquals("fulano@gmail.com", encontrado.getEmail());
    }


}