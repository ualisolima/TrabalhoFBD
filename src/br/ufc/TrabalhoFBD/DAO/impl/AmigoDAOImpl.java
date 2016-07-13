package br.ufc.TrabalhoFBD.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufc.TrabalhoFBD.DAO.AmigoDAO;
import br.ufc.TrabalhoFBD.connection.FabricaDeConexao;
import br.ufc.TrabalhoFBD.model.Amigo;
import br.ufc.TrabalhoFBD.model.Usuario;

public class AmigoDAOImpl implements AmigoDAO{

	@Override
	public void inserir(Amigo amigo) {
		// TODO Auto-generated method stub
		
		Connection conn = FabricaDeConexao.retornarConexao();
		String sql = "insert into amigos (usuario_id1,usuario_id2,desde)values(?,?,?)";	
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, amigo.getUsuario1().getIdUsuario());
			stmt.setLong(2, amigo.getUsuario2().getIdUsuario());
			stmt.setDate(3, amigo.getDesde());
			stmt.execute();
			stmt.close();
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, amigo.getUsuario2().getIdUsuario());
			stmt.setLong(2, amigo.getUsuario1().getIdUsuario());
			stmt.setDate(3, amigo.getDesde());
			
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public boolean apagar(Amigo amigo) {
		// TODO Auto-generated method stub
		Connection conn = FabricaDeConexao.retornarConexao();
		String sql = "DELETE FROM amigos WHERE usuario_id1=? and usuario_id2=?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, amigo.getUsuario1().getIdUsuario());
			stmt.setLong(2, amigo.getUsuario2().getIdUsuario());
			stmt.execute();
			stmt.close();
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, amigo.getUsuario2().getIdUsuario());
			stmt.setLong(2, amigo.getUsuario1().getIdUsuario());
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
	public List<Usuario> getAmigos(Usuario usuario) {
		Connection conn = FabricaDeConexao.retornarConexao();
		String sql = "select * from amigos as a where a.usuario_id1 = ?";
		PreparedStatement stmt;
		List<Usuario> amigos = new ArrayList<Usuario>();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, usuario.getIdUsuario());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Usuario u = new Usuario();
				u = new UsuarioDAOImpl().recuperarById(rs.getLong("usuario_id2"));
				amigos.add(u);
				
			}
			return amigos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
