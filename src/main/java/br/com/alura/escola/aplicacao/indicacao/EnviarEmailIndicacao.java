package br.com.alura.escola.aplicacao.indicacao;

import br.com.alura.escola.domain.aluno.Aluno;

public interface EnviarEmailIndicacao {

    void enviarPara(Aluno indicado);

}
