package br.ufc.TrabalhoFBD.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufc.TrabalhoFBD.DAO.GrupoDAO;
import br.ufc.TrabalhoFBD.connection.FabricaDeConexao;
import br.ufc.TrabalhoFBD.model.Grupo;
import br.ufc.TrabalhoFBD.model.Usuario;

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
			stmt.setLong(2, grupo.getAmd().getIdUsuario());
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
	public boolean alterar(Grupo grupo) {
		// TODO Auto-generated method stub
		Connection conn = FabricaDeConexao.retornarConexao();
		String sql = "UPDATE grupo SET dt_criacao = ? adm_id = ? nome = ? "
				+ "WHERE grupo_id = ?";	
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setDate(1, grupo.getDtCriacao());
			stmt.setLong(2, grupo.getAmd().getIdUsuario());
			stmt.setString(3,grupo.getNomeGrupo());
			stmt.setLong(4, grupo.getIdGrupo());
			
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
	public Grupo recuperarById(Long id) {
		// TODO Auto-generated method stub
		Connection conn = FabricaDeConexao.retornarConexao();
		String sql = "select * from grupo WHERE grupo_id = ?";
		PreparedStatement stmt;
		List<Grupo> grupos = new ArrayList<Grupo>();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Grupo g = new Grupo();
				g.setIdGrupo((rs.getLong("grupo_id")));
				g.setNomeGrupo(rs.getString("nome"));
				g.setDtCriacao(rs.getDate("data_criacao"));
				g.setAmd(new UsuarioDAOImpl().recuperarById(rs.getLong("adm_id")));
				g.setUsuarios(getUsuarios(g.getIdGrupo()));
				g.setMensagensGrupo(new MensagemGrupoDAOImpl().getMensagensGrupo(g));
				grupos.add(g);	
				
			}
			return grupos.get(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

	public List<Usuario> getUsuarios(Long idGrupo) {
		Connection conn = FabricaDeConexao.retornarConexao();
		String sql = "SELECT u.usuario_id, pNome, mNome, uNome, login FROM usuario as u, grupo_has_usuario as g  "
				+ "WHERE g.grupo_id=? "
				+ "AND g.usuario_id = u.usuario_id";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, idGrupo);
			ResultSet rs = stmt.executeQuery();
			List<Usuario> usuarios = new ArrayList<Usuario>();
			while(rs.next()){
				Usuario u = new Usuario();
				u.setIdUsuario(rs.getLong("usuario_id"));
				u.setpNome(rs.getString("pNome"));
				u.setmNome(rs.getString("mNome"));
				u.setuNome(rs.getString("uNome"));
				u.setLogin(rs.getString("login"));
				usuarios.add(u);
			}
			stmt.close();
			conn.close();
			return usuarios;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean apagar(Grupo grupo) {
		Connection conn = FabricaDeConexao.retornarConexao();
		String sql = "DELETE FROM grupo WHERE grupo_id=?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, grupo.getIdGrupo());
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
	public List<Grupo> getGrupos(Usuario usuario) {
		// TODO Auto-generated method stub
		Connection conn = FabricaDeConexao.retornarConexao();
		String sql = "select * from grupo_has_usuario WHERE usuario_id = ?";
		PreparedStatement stmt;
		List<Grupo> grupos = new ArrayList<Grupo>();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, usuario.getIdUsuario());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Grupo g = new Grupo();
				g = recuperarById(rs.getLong("grupo_id"));
				grupos.add(g);
				
			}
			return grupos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Grupo> getGruposAdm(Usuario usuario) {
		// TODO Auto-generated method stub
		Connection conn = FabricaDeConexao.retornarConexao();
		String sql = "select * FROM grupo WHERE adm_id = ?";
		PreparedStatement stmt;
		List<Grupo> grupos = new ArrayList<Grupo>();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, usuario.getIdUsuario());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Grupo g = new Grupo();
				g = recuperarById(rs.getLong("grupo_id"));
				grupos.add(g);
				
			}
			return grupos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
