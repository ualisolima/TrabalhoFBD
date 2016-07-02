package br.ufc.TrabalhoFBD.model.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.tomcat.util.codec.EncoderException;

import br.ufc.TrabalhoFBD.DAO.UsuarioDAO;
import br.ufc.TrabalhoFBD.connection.FabricaDeConexao;
import br.ufc.TrabalhoFBD.model.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO{

	@Override
	public void inserir(Usuario usuario) {
		//Falta implementar a inserção do endereço caso ele não exista
		Connection conn = FabricaDeConexao.retornarConexao();
		String sql = "insert into usuario (pNome,mNome,uNome,login,senha, cep , pais, numero_casa)values(?,?,?,?,?,?,?,?)";	
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, usuario.getpNome());
			stmt.setString(2, usuario.getmNome());
			stmt.setString(3, usuario.getuNome());
			stmt.setString(4, usuario.getLogin());
			stmt.setString(5, usuario.getSenha());
			stmt.setString(6, usuario.getEndereco().getCep());
			stmt.setString(7, usuario.getEndereco().getPais());
			stmt.setString(8, usuario.getnCasa());
			
			stmt.execute();
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void alterar(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario recuperarByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario recuperarById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void apagar(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	
}
