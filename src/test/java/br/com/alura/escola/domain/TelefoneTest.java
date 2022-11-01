package br.com.alura.escola.domain;

import br.com.alura.escola.domain.aluno.Telefone;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TelefoneTest {

    @Test
    void naoDeveriaCadastrarTelefoneInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new Telefone("00", "00"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("", ""));
        assertThrows(IllegalArgumentException.class, () -> new Telefone(null, null));
    }

    @Test
    void deveriaCadastrarTelefoneValido() {
        Telefone telefone = new Telefone("(61)", "98114-0062");
        assertEquals("(61)", telefone.getDdd());
        assertEquals("98114-0062", telefone.getNumero());


    }

}