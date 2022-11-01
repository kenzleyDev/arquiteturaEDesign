package br.com.alura.escola.infra.service.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// para fins de estudo, utilizei padrao MD5
public class CifradorDeSenhaImpl implements CifradorDeSenha {

    @Override
    public String cifrarSenha(String senha) {

        try {
            MessageDigest   md = MessageDigest.getInstance("MD5");
            md.update(senha.getBytes());
            byte[] bytes = md.digest();

            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(16));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean validarSenhaCifrada(String senhaCifrada, String senha) {
        return senhaCifrada.equals(cifrarSenha(senha));
    }
}
