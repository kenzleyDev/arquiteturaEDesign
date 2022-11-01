package br.com.alura.escola.exceptions;

import br.com.alura.escola.domain.aluno.Cpf;

public class AlunoNaoEncontrado  extends  RuntimeException{

    public static final long serialVersionUID = 1L;

    public AlunoNaoEncontrado(Cpf cpf) {
        super("Aluno não encontrado com CPF: " + cpf.getCpf());
    }

}
