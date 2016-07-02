package br.ufc.TrabalhoFBD.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.ufc.TrabalhoFBD.DAO.LogDAO;
import br.ufc.TrabalhoFBD.connection.FabricaDeConexao;
import br.ufc.TrabalhoFBD.model.Log;

public class logDAOImpl implements LogDAO {

	@Override
	public void inserir(Log log) {
		// TODO Auto-generated method stub
		

		Connection conn = FabricaDeConexao.retornarConexao();
		String sql = "insert into grupo (usuario_id,data_horario)values(?,?)";	
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, log.getUsuario().getIdUsuario());
			stmt.setTimestamp(2, log.getDataHorario());
			
			stmt.execute();
			stmt.close();
			conn.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void alterar(Log log) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Log recuperarByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Log recuperarById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void apagar(Log log) {
		// TODO Auto-generated method stub
		
	}

}
