package br.com.alura.escola.domain.aluno;

public class Telefone {

    private String ddd;
    private String numero;

    public Telefone(String ddd, String numero) {
        if(ddd == null || numero == null
                || !ddd.matches("^\\([1-9]{2}\\)$")
                || numero.matches("^\\([9]{0,1}[6-9]{1}[0-9]{3}\\-[0-9]{4}\\)$")) {
            throw new IllegalArgumentException("Telefone invalido");
        }
        this.ddd = ddd;
        this.numero = numero;
    }

    public String getDdd() {
        return ddd;
    }

    public String getNumero() {
        return numero;
    }
}
