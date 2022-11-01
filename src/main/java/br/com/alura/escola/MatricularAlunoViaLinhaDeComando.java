package br.com.alura.escola;

import br.com.alura.escola.aplicacao.matricular.MatricularAluno;
import br.com.alura.escola.aplicacao.matricular.MatricularAlunoDTO;
import br.com.alura.escola.infra.aluno.memoria.RepositorioDeAlunosEmMemoria;

//Use case

public class MatricularAlunoViaLinhaDeComando {

    public static void main(String[] args) {
        String nome = "Fulano da Silva";
        String cpf = "123.456.789-00";
        String email = "fulano@gmail.com";

        MatricularAluno matricularAluno = new MatricularAluno(new RepositorioDeAlunosEmMemoria());
        matricularAluno.matricular(new MatricularAlunoDTO(nome,cpf,email));
    }

}
