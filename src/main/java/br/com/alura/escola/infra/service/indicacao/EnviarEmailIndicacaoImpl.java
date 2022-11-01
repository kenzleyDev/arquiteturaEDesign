package br.com.alura.escola.infra.service.indicacao;

import br.com.alura.escola.aplicacao.indicacao.EnviarEmailIndicacao;
import br.com.alura.escola.domain.aluno.Aluno;

public class EnviarEmailIndicacaoImpl implements EnviarEmailIndicacao {

    @Override
    public void enviarPara(Aluno indicado) {
        // logica de envio de emails
    }
}
