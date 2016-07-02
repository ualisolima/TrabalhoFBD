package br.ufc.TrabalhoFBD.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.ufc.TrabalhoFBD.DAO.GrupoDAO;
import br.ufc.TrabalhoFBD.connection.FabricaDeConexao;
import br.ufc.TrabalhoFBD.model.Grupo;

public class GrupoDAOImpl implements GrupoDAO {

	@Override
	public void inserir(Grupo grupo) {
		// TODO Auto-generated method stub
		
		Connection conn = FabricaDeConexao.retornarConexao();
		String sql = "insert into grupo (dt_criacao,adm_id,nome)values(?,?,?)";	
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setDate(1, grupo.getDtCriacao());
			stmt.setLong(2, grupo.getIdAdm());
			stmt.setString(3,grupo.getNomeGrupo());
			
			stmt.execute();
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void alterar(Grupo grupo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Grupo recuperarByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Grupo recuperarById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void apagar(Grupo grupo) {
		// TODO Auto-generated method stub
		
	}

}
