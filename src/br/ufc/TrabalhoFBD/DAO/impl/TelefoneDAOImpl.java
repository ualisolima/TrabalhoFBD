package br.ufc.TrabalhoFBD.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufc.TrabalhoFBD.DAO.TelefoneDAO;
import br.ufc.TrabalhoFBD.connection.FabricaDeConexao;
import br.ufc.TrabalhoFBD.model.Telefone;
import br.ufc.TrabalhoFBD.model.Usuario;

public class TelefoneDAOImpl implements TelefoneDAO {

	@Override
	public void inserir(Telefone telefone) {
		// TODO Auto-generated method stub
		
		Connection conn = FabricaDeConexao.retornarConexao();
		String sql = "insert into telefone (telefone_id,telefone)values(?,?)";	
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
	public boolean alterar(Telefone telefone) {
		// TODO Auto-generated method stub

			Connection conn = FabricaDeConexao.retornarConexao();
			String sql = "UPDATE telefone set telefone = ? "
					+ "WHERE usuario_id = ? and telefone_id = ?";
			
			PreparedStatement stmt;
			try {
				stmt = conn.prepareStatement(sql);
				
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, telefone.getTelefone());
				stmt.setLong(2, telefone.getUsuario().getIdUsuario());
				stmt.setLong(3, telefone.getIdTelefone());
				
				stmt.execute();
				stmt.close();
				conn.close();
				return true;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
			
		}

	@Override
	public Telefone recuperarById(Usuario usuario, String telefone) {
		Connection conn = FabricaDeConexao.retornarConexao();
		String sql = "select * from usuario_telefones where usuario_id = ?";
		PreparedStatement stmt;
		List<Telefone> telefones = new ArrayList<Telefone>();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, usuario.getIdUsuario());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Telefone t = new Telefone();
				t.setTelefone(telefone);
				t.setUsuario(usuario);
				telefones.add(t);
				
			}
			return telefones.get(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean apagar(Telefone telefone) {
		// TODO Auto-generated method stub
		Connection conn = FabricaDeConexao.retornarConexao();
		String sql = "DELETE FROM telefone WHERE telefone=? AND usuario_id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, telefone.getTelefone());
			stmt.setLong(2, telefone.getUsuario().getIdUsuario());
			stmt.execute();
			stmt.close();
			conn.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}

	public List<Telefone> getTelefones(Usuario usuario) {
		Connection conn = FabricaDeConexao.retornarConexao();
		String sql = "select * from telefone where usuario_id = ?";
		PreparedStatement stmt;
		List<Telefone> telefones = new ArrayList<Telefone>();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, usuario.getIdUsuario());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Telefone t = new Telefone();
				t.setUsuario(usuario);
				t.setTelefone(rs.getString("telefone"));
				telefones.add(t);
				
			}
			return telefones;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
