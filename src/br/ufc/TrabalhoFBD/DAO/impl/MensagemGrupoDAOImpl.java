package br.ufc.TrabalhoFBD.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufc.TrabalhoFBD.DAO.MensagemGrupoDAO;
import br.ufc.TrabalhoFBD.connection.FabricaDeConexao;
import br.ufc.TrabalhoFBD.model.Grupo;
import br.ufc.TrabalhoFBD.model.MensagemGrupo;
import br.ufc.TrabalhoFBD.model.Usuario;

public class MensagemGrupoDAOImpl implements MensagemGrupoDAO{

	@Override
	public void inserir(MensagemGrupo mensagemGrupo) {
		// TODO Auto-generated method stub
		
		Connection conn = FabricaDeConexao.retornarConexao();
		String sql = "insert into mensagem_grupo (remetente,destinatario,data_hora_envio,corpo)values(?,?,?,?)";	
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, mensagemGrupo.getRemetente().getIdUsuario());
			stmt.setLong(2, mensagemGrupo.getDestinatario().getIdGrupo());
			stmt.setTimestamp(3, mensagemGrupo.getDataHoraEnvio());
			stmt.setString(4, mensagemGrupo.getCorpo());
		
			
			stmt.execute();
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public MensagemGrupo recuperarById(Long id) {
		Connection conn = FabricaDeConexao.retornarConexao();
		String sql = "SELECT * from mensagem_grupo where mensagem_id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			List<MensagemGrupo> mensagens = new ArrayList<MensagemGrupo>();
			while(rs.next()){
				MensagemGrupo m = new MensagemGrupo();
				m.setIdMensagem(rs.getLong("mensaem_id"));
				m.setRemetente(getRemetente(m.getIdMensagem()));
				m.setCorpo(rs.getString("corpo"));
				m.setDataHoraEnvio(rs.getTimestamp("data_hora_envio"));
				mensagens.add(m);
			}
			stmt.close();
			conn.close();
			return mensagens.get(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Usuario getRemetente(Long idMensagem) {
		Connection conn = FabricaDeConexao.retornarConexao();
		String sql = "SELECT usuario_id, pNome, mNome, uNome, login FROM FROM usuario as u, mensagem_grupo as g  "
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
	public List<MensagemGrupo> getMensagensGrupo(Grupo grupo) {
		Connection conn = FabricaDeConexao.retornarConexao();
		String sql = "select * from mensagem_grupo where destinatario = ?";
		PreparedStatement stmt;
		List<MensagemGrupo> mensagens = new ArrayList<MensagemGrupo>();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, grupo.getIdGrupo());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				MensagemGrupo m = recuperarById(rs.getLong("mensagem_id"));
				m.setDestinatario(grupo);
				mensagens.add(m);
				
			}
			return mensagens;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
