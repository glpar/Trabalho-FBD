
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import pojo.Cliente;
import jdbc.ConnectionFactory;



public class CllienteDAO {
    private Connection connection;
	
	
	
	@SuppressWarnings("finally")
                            public boolean adicionarUsuario(Cliente cliente) {
		String sql = "INSERT INTO usuario (NOME, CPF) VALUES (?, ?)";
		this.connection = new ConnectionFactory().getConnection();
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, cliente.getnome());
			stmt.setString(2, cliente.getcpf());
			
			
			int rowsAffected = stmt.executeUpdate();
			stmt.close();
			if(rowsAffected > 0)
				return true;
			
			return false;
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		}
		
		finally {
			try {
				this.connection.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public ArrayList<Cliente> listarclientes(){
		String sql = "SELECT * FROM cliente";
		ArrayList<Cliente> clientes = new ArrayList<>();
		this.connection = new ConnectionFactory().getConnection();
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				//int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String cpf = rs.getString("cpf");
				
				
				Cliente cliente = new Cliente(nome , cpf);
				
				clientes.add(cliente);
				
			}
			
			stmt.close();
		} catch(SQLException e) {
			System.err.println(e.getMessage());
		}
		
		finally {
			try {
				this.connection.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return clientes;
	}
	
	public boolean excluirUsuario(int cpf) {
		String sql = "DELETE FROM cliente WHERE id = ?";
		this.connection = new ConnectionFactory().getConnection();
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			//Setar valores
			stmt.setInt(1, cpf);
			
			int affectedRows = stmt.executeUpdate();
			stmt.close();
			
			if(affectedRows > 0) {
				return true;
			}
			return false;
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		}finally {
			try {
				this.connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public Cliente getUserById(int cpf) {
		String sql = "SELECT * FROM cliente WHERE id = ?";
		this.connection = new ConnectionFactory().getConnection();
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, cpf);
			
			ResultSet rs = stmt.executeQuery();
			rs.next();
			
			Cliente cliente = new Cliente(cpf, rs.getString("NOME"), rs.getString("CPF") );
			stmt.close();
			
			return cliente;
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
