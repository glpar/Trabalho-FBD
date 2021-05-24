
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import pojo.Venda;
import pojo.Cliente;
import pojo.Animal;
import pojo.Serviço;
import jdbc.ConnectionFactory;


public class VendaDAO {
    private Connection connection;
    private int idAni;
            
//    private String nomea;
//	private String idCli;
//	private String idSer;
//	private int venID;
//        
        
                    public boolean Vender (String nomea, String idSer, int vendID) {
		String sql = "INSERT INTO vender(nome_animal, id_serviço, id_vend) VALUES (?, ?, ?)";
		this.connection = new ConnectionFactory().getConnection();
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
		//	stmt.setString(1, nomea.idani());
		//	stmt.setString(2, idSer.getidSer());
			
			int affectedRows = stmt.executeUpdate();
			
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
	
	public ArrayList<Venda> getListVenda(String cpf){
		String sql = "SELECT * FROM VENDA";
		ArrayList<Venda> vendas= new ArrayList<Venda>();
		this.connection = new ConnectionFactory().getConnection();
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				int idUsuario = Integer.parseInt(rs.getString("id_usuario"));
				CllienteDAO clienteDAO = new CllienteDAO();
			//	Clliente cliente = clienteDAO.getUserById(idUsuario);
				
				int idLivro = Integer.parseInt(rs.getString("id_livro"));
				AnimalDAO animalDAO = new AnimalDAO();
				Animal animal = Animal.getAnimalById(idAni);
				
				Serviço aloc = new Serviço(cpf,idAni);
				
				Serviço.add(aloc);
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
		return vendas;
	}


}
        





