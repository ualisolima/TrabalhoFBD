package br.ufc.TrabalhoFBD.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.ufc.TrabalhoFBD.DAO.EnderecoDAO;
import br.ufc.TrabalhoFBD.connection.FabricaDeConexao;
import br.ufc.TrabalhoFBD.model.Endereco;

public class EnderecoDAOImpl implements EnderecoDAO{

	@Override
	public void inserir(Endereco endereco) {
		// TODO Auto-generated method stub
		
		Connection conn = FabricaDeConexao.retornarConexao();
		String sql = "insert into endereco (cep,pais,estado,cidade,rua)values(?,?,?,?,?)";	
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, endereco.getCep());
			stmt.setString(2, endereco.getPais());
			stmt.setString(3, endereco.getEstado());
			stmt.setString(4, endereco.getCidade());
			stmt.setString(5, endereco.getRua());
		
			
			
			stmt.execute();
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void alterar(Endereco endereco) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Endereco recuperarByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Endereco recuperarById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void apagar(Endereco endereco) {
		// TODO Auto-generated method stub
		
	}

}
