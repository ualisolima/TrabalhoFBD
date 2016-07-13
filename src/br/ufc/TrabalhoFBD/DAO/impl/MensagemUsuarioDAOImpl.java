package br.ufc.TrabalhoFBD.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufc.TrabalhoFBD.DAO.MensagemUsuarioDAO;
import br.ufc.TrabalhoFBD.connection.FabricaDeConexao;
import br.ufc.TrabalhoFBD.model.MensagemUsuario;
import br.ufc.TrabalhoFBD.model.Usuario;

public class MensagemUsuarioDAOImpl implements MensagemUsuarioDAO{

	@Override
	public void inserir(MensagemUsuario mensagemUsuario) {
		// TODO Auto-generated method stub
		
		Connection conn = FabricaDeConexao.retornarConexao();
		String sql = "insert into mensagem_usuario (remetente,destinatario,data_hora_envio,corpo)values(?,?,?,?)";	
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, mensagemUsuario.getRemetente().getIdUsuario());
			stmt.setLong(2, mensagemUsuario.getDestinatario().getIdUsuario());
			stmt.setTimestamp(3, mensagemUsuario.getDataHoraEnvio());
			stmt.setString(4, mensagemUsuario.getCorpo());
		
			
			stmt.execute();
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public MensagemUsuario recuperarById(Long id) {
		Connection conn = FabricaDeConexao.retornarConexao();
		String sql = "SELECT * from mensagem_usuario where mensagem_id = ? ORDER BY data_hora_envio DESC";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			List<MensagemUsuario> mensagens = new ArrayList<MensagemUsuario>();
			while(rs.next()){
				MensagemUsuario m = new MensagemUsuario();
				m.setIdMensagem(rs.getLong("mensagem_id"));
				m.setRemetente(getRemetente(m.getIdMensagem()));
				m.setDestinatario(getDestinatario(m.getIdMensagem()));
				m.setCorpo(rs.getString("corpo"));
				m.setDataHoraEnvio(rs.getTimestamp("data_hora_envio"));
				mensagens.add(m);
			}
			stmt.close();
			conn.close();
			if (mensagens.size() > 0)
				return mensagens.get(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<MensagemUsuario> getMensagensUsuario(Usuario usuario) {
		Connection conn = FabricaDeConexao.retornarConexao();
		String sql = "select * from mensagem_usuario where remetente = ? OR destinatario = ?";
		PreparedStatement stmt;
		List<MensagemUsuario> mensagens = new ArrayList<MensagemUsuario>();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, usuario.getIdUsuario());
			stmt.setLong(2, usuario.getIdUsuario());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				MensagemUsuario m = recuperarById(rs.getLong("mensagem_id"));
				mensagens.add(m);
				
			}
			return mensagens;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<MensagemUsuario> getConversa(Long idUsuario1, Long idUsuario2) {
		Connection conn = FabricaDeConexao.retornarConexao();
		String sql = "select * from mensagem_usuario where (remetente = ? AND destinatario = ?) OR (remetente = ? AND destinatario = ?)";
		PreparedStatement stmt;
		List<MensagemUsuario> mensagens = new ArrayList<MensagemUsuario>();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, idUsuario1);
			stmt.setLong(2, idUsuario2);
			stmt.setLong(4, idUsuario1);
			stmt.setLong(3, idUsuario2);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				MensagemUsuario m = recuperarById(rs.getLong("mensagem_id"));
				mensagens.add(m);
				
			}
			return mensagens;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Usuario getRemetente(Long idMensagem) {
		Connection conn = FabricaDeConexao.retornarConexao();
		String sql = "SELECT usuario_id, pNome, mNome, uNome, login FROM usuario as u, mensagem_usuario as g  "
				+ "WHERE g.mensagem_id=? "
				+ "AND g.remetente = u.usuario_id";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, idMensagem);
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
			return usuarios.get(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Usuario getDestinatario(Long idMensagem) {
		Connection conn = FabricaDeConexao.retornarConexao();
		String sql = "SELECT usuario_id, pNome, mNome, uNome, login FROM usuario as u, mensagem_usuario as g  "
				+ "WHERE g.mensagem_id=? "
				+ "AND g.destinatario = u.usuario_id";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, idMensagem);
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
			return usuarios.get(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
