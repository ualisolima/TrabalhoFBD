package br.ufc.TrabalhoFBD.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexao {
	public static Connection retornarConexao(){
		try {
			Connection conexao = DriverManager.getConnection(
					"jdbc:mysql://localhost/TrabalhoFBD",
					"root",
					"root");
			System.out.println("CONECTADO COM SUCESSO!");
			return conexao;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
