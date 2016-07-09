package br.ufc.TrabalhoFBD.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufc.TrabalhoFBD.DAO.UsuarioDAO;
import br.ufc.TrabalhoFBD.connection.FabricaDeConexao;
import br.ufc.TrabalhoFBD.model.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO{

	@Override
	public void inserir(Usuario usuario) {
		//Falta implementar a inserção do endereço caso ele não exista
		try{
			new EnderecoDAOImpl().inserir(usuario.getEndereco());
		}
		catch(Exception e){
			
		}
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
	public boolean alterar(Usuario usuario) {
		Connection conn = FabricaDeConexao.retornarConexao();
		String sql = "UPDATE usuario  set pNome = ?,mNome = ?, uNome = ?,login = ?,senha = ?, cep = ? , pais = ?, numero_casa = ? "
				+ "WHERE usuario_id = ?";
		
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			
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
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}

	@Override
	public Usuario recuperarByLogin(String login) {
		Connection conn = FabricaDeConexao.retornarConexao();
		String sql = "SELECT * from usuario where login = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, login);
			ResultSet rs = stmt.executeQuery();
			List<Usuario> usuarios = new ArrayList<Usuario>();
			while(rs.next()){
				Usuario u = new Usuario();
				u.setIdUsuario(rs.getLong("usuario_id"));
				u.setpNome(rs.getString("pNome"));
				u.setmNome(rs.getString("mNome"));
				u.setuNome(rs.getString("uNome"));
				u.setLogin(rs.getString("login"));
				u.setSenha(rs.getString("senha"));
				u.setEndereco(new EnderecoDAOImpl().recuperarById(rs.getString("cep"), rs.getString("pais")));
				u.setTelefones(new TelefoneDAOImpl().getTelefones(u));
				u.setnCasa(rs.getString("numero_casa"));
				u.setAmigos(new AmigoDAOImpl().getAmigos(u));
				u.setMensagens(new MensagemUsuarioDAOImpl().getMensagensUsuario(u));
				u.setGrupoParticipa(new GrupoDAOImpl().getGrupos(u));
				u.setGruposAdm(new GrupoDAOImpl().getGruposAdm(u));
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
	public Usuario recuperarById(Long id) {
		Connection conn = FabricaDeConexao.retornarConexao();
		String sql = "SELECT * from usuario where usuario_id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			List<Usuario> usuarios = new ArrayList<Usuario>();
			while(rs.next()){
				Usuario u = new Usuario();
				u.setIdUsuario(rs.getLong("usuario_id"));
				u.setpNome(rs.getString("pNome"));
				u.setmNome(rs.getString("mNome"));
				u.setuNome(rs.getString("uNome"));
				u.setLogin(rs.getString("login"));
				u.setEndereco(new EnderecoDAOImpl().recuperarById(rs.getString("cep"), rs.getString("pais")));
				u.setTelefones(new TelefoneDAOImpl().getTelefones(u));
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
	public boolean apagar(Usuario usuario) {
		Connection conn = FabricaDeConexao.retornarConexao();
		String sql = "DELETE FROM usuario WHERE usuario_id=?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, usuario.getIdUsuario());
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
	
}
