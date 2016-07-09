package br.ufc.TrabalhoFBD.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	public Endereco recuperarById(String cep, String pais) {
		Connection conn = FabricaDeConexao.retornarConexao();
		String sql = "select * from endereco where cep = ? and pais = ?";
		PreparedStatement stmt;
		List<Endereco> enderecos = new ArrayList<Endereco>();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, cep);
			stmt.setString(2, pais);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Endereco e = new Endereco();
				e.setCep(cep);
				e.setPais(pais);
				e.setCidade(rs.getString("cidade"));
				e.setEstado(rs.getString("estado"));
				e.setRua(rs.getString("rua"));
				enderecos.add(e);
				
			}
			return enderecos.get(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	@Override
	public boolean apagar(Endereco endereco) {
		Connection conn = FabricaDeConexao.retornarConexao();
		String sql = "DELETE FROM endereco WHERE cep=? and pais=?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, endereco.getCep());
			stmt.setString(2, endereco.getPais());
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
