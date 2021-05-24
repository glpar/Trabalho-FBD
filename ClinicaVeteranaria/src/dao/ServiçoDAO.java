
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import pojo.Serviço;
import jdbc.ConnectionFactory;


public class ServiçoDAO {

    private Connection connection;
        
	
            public boolean adicionarServiço(Serviço serviço) {
		String sql = "INSERT INTO serviço (idSer,valor) VALUES (?, ?)";
		this.connection = new ConnectionFactory().getConnection();
		
		try {
			//Necessário para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			//Set values
			stmt.setString(1, serviço.getidSer());
			stmt.setInt(2, (int) serviço.getvalor());
			
			
			int affectedRows = stmt.executeUpdate();
			stmt.close();
			
			if(affectedRows > 0) {
				return true;
			}
			return false;
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		}finally{
			try {
				this.connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public ArrayList<Serviço> getListServiços(){
		String sql = "SELECT * FROM livro";
		ArrayList<Serviço> listserviços = new ArrayList<Serviço>();
		this.connection = new ConnectionFactory().getConnection();
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			/*ResultSet é uma interface utilizada pra guardar
			 * dados vindos de um banco de dados.
			*Basicamente, ela guarda o resultado de uma pesquisa
			*numa estrutura de dados que pode ser percorrida,
			*de forma que você possa ler os dados do banco. */
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
			//	int id = Integer.parseInt(rs.getString("id"));
				String idSer= rs.getString("idSer");
                                                                                      int valor = rs.getInt("serviço");
				
				
				Serviço ListServiços= new Serviço(idSer, valor);
				
				listserviços.add(ListServiços);
			}
			stmt.close();
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		}finally {
			try {
				this.connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return listserviços;
	}
	
	public Serviço getServiçoById(int valor) {
		String sql = "SELECT * FROM livro WHERE id = ?";
		
		this.connection = new ConnectionFactory().getConnection();
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, valor);
			
			ResultSet rs = stmt.executeQuery();
			rs.next();
			
			Serviço listserviços= new Serviço(valor, rs.getString("idSer"), rs.getInt(valor));
			
			stmt.close();
			
			return listserviços ;
                        
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		}finally {
			try {
				this.connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}




