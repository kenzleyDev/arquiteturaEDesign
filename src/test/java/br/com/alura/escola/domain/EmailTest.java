package br.com.alura.escola.domain;


import br.com.alura.escola.domain.aluno.Email;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmailTest  {

    @Test
    void naoDeveriaCriarEmailsComEnderecosInvalidos() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Email(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Email("luankenzley"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Email(""));
    }

    @Test
    void deveriaCriarEmailValido() {
        Email email = new Email("luankenzley@hotmail.com");
        Assertions.assertEquals("luankenzley@hotmail.com",email.getEndereco());
    }
}