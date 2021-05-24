

package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
        
                public Connection getConexao( ) {
                    try {
                        return DriveManager.getConnection("jdbc:mysql://localhost/clinicaveterinaria " , "root", "456161");
                    }
                } 
                    catch (Exception erro){
                        throw new RuntimeException("Erro 1" + erro);
}

}
