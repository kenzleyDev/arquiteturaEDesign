package br.com.alura.escola.aplicacao.matricular;

import br.com.alura.escola.domain.aluno.Aluno;
import br.com.alura.escola.domain.aluno.Cpf;
import br.com.alura.escola.domain.aluno.Email;

public class MatricularAlunoDTO {

    private String nomeAluno;
    private String cpfAluno;
    private String emailAluno;

    public MatricularAlunoDTO(String nomeAluno, String cpfAluno, String emailAluno) {
        this.nomeAluno = nomeAluno;
        this.cpfAluno = cpfAluno;
        this.emailAluno = emailAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public String getCpfAluno() {
        return cpfAluno;
    }

    public String getEmailAluno() {
        return emailAluno;
    }

    public Aluno criarAluno() {
        return new Aluno(new Cpf(cpfAluno),nomeAluno,new Email(emailAluno));
    }
}
