package br.ufc.TrabalhoFBD.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.ufc.TrabalhoFBD.DAO.TelefoneDAO;
import br.ufc.TrabalhoFBD.connection.FabricaDeConexao;
import br.ufc.TrabalhoFBD.model.Telefone;

public class TelefoneDAOImpl implements TelefoneDAO {

	@Override
	public void inserir(Telefone telefone) {
		// TODO Auto-generated method stub
		
		Connection conn = FabricaDeConexao.retornarConexao();
		String sql = "insert into telefone (usuario_id,telefone)values(?,?)";	
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, telefone.getUsuario().getIdUsuario());
			stmt.setString(2, telefone.getTelefone());
			
			stmt.execute();
			stmt.close();
			conn.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void alterar(Telefone telefone) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Telefone recuperarByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Telefone recuperarById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void apagar(Telefone telefone) {
		// TODO Auto-generated method stub
		
	}

}
