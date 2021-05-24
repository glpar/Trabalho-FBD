
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import pojo.Animal;
import jdbc.ConnectionFactory;



public class AnimalDAO {
    private Connection connection;
    
//                public AnimalDAO(){
//                    new ConnectionFactory():
//                    connection = ConnectionFactory.getConection();
//                }


	
	@SuppressWarnings("finally")
                            public boolean adicionarAnimal(Animal animal) {
		String sql = "INSERT INTO animal (NOME, IDANI,ESPECIE,DONO) VALUES (?, ?, ?, ?)";
		this.connection = new ConnectionFactory().getConnection();
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, animal.getnomea());
			stmt.setString(2, animal.getidani());
                                                                stmt.setString(2, animal.getespecie());
                                                                stmt.setString(2, animal.getidono());
			
			
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
	
	public ArrayList<Animal> listaranimais(){
		String sql = "SELECT * FROM animal";
		ArrayList<Animal> animal = new ArrayList<>();
		this.connection = new ConnectionFactory().getConnection();
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				//int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String idani = rs.getString("idani");
                                                                                      String especie = rs.getString("especie");
				String dono= rs.getString("dono");
				
				Animal listarnanimais = new Animal( nome ,  idani, especie, dono);
				
				animal.add(listarnanimais);
				
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
		
		return animal;
	}
	
	public boolean excluirAnimal(String idani) {
		String sql = "DELETE FROM Animal WHERE id = ?";
		this.connection = new ConnectionFactory().getConnection();
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			//Setar valores
			stmt.setString(1, idani);
			
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
	
	public Animal getUserById(String idani) {
		String sql = "SELECT * FROM cliente WHERE id = ?";
		this.connection = new ConnectionFactory().getConnection();
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, idani);
			
			ResultSet rs = stmt.executeQuery();
			rs.next();
			
			Animal animal = new Animal(idani, rs.getString("NOME"), rs.getString("IDANI"), rs.getString("DONO"), rs.getString("ESPECIE") );
			stmt.close();
			
			return animal;
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
