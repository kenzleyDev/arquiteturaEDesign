package br.com.alura.escola.infra.aluno.jdbc;


import br.com.alura.escola.domain.aluno.Aluno;
import br.com.alura.escola.domain.aluno.Cpf;
import br.com.alura.escola.domain.aluno.Email;
import br.com.alura.escola.domain.aluno.Telefone;
import br.com.alura.escola.exceptions.AlunoNaoEncontrado;
import br.com.alura.escola.repository.AlunoRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RepositorioDeAlunosComJDBC implements AlunoRepository {

    private final Connection connection;

    public RepositorioDeAlunosComJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void matricular(Aluno aluno) {

        try {
            String sql = "INSERT INTO ALUNO(?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, aluno.getCpf());
            ps.setString(2, aluno.getNome());
            ps.setString(1, aluno.getEmail());
            ps.execute();

            sql = "INSERT INTO TELEFONE VALUES(?,?)";
            ps = connection.prepareStatement(sql);

            for(Telefone telefone : aluno.getTelefones()) {
            ps.setString(1, telefone.getDdd());
            ps.setString(2, telefone.getNumero());
            ps.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public Aluno buscarAlunoPorCPF(Cpf cpf) {
        String sql = "SELECT id,nome,email FROM ALUNO WHERE CPF = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cpf.getCpf());
            ResultSet rs = ps.executeQuery();

            boolean encontrou = rs.next();

            if(!encontrou) {
                throw new AlunoNaoEncontrado(cpf);
            }

            String nome = rs.getString("nome");
            Email email = new Email(rs.getString("email"));
            Aluno encontrado = new Aluno(cpf, nome, email);

            Long id = rs.getLong("id");

            sql = "SELECT ddd, numero FROM TELEFONE where aluno.id = ?";
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();

            while(rs.next()) {
                String numero = rs.getString("numero");
                String ddd = rs.getString("ddd");
                encontrado.adicionarTelefone(ddd, numero);
            }

            return encontrado;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Aluno> listarTodosAlunosMatriculados() {
        return null;
    }
}
