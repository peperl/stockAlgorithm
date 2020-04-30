/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.JavaConnectorMySQL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pepe
 */
public class ConsultasDAO {

    private static String consulta = "SELECT Historico.fecha, Valores.nombre, Historico.tasa, Historico.plazo from Historico INNER JOIN Valores ON Historico.idValores = Valores.idValores;";
    
    public void consulta() throws ClassNotFoundException, SQLException {
        
        
        JavaConnectorMySQL connector = new JavaConnectorMySQL();
        Connection conn = connector.proceso();
        PreparedStatement stmt = conn.prepareStatement(consulta);  
        
        ResultSet rs = stmt.executeQuery();  
        while(rs.next()) {
            System.out.println(rs.getDate(1) + " " + rs.getString(2));
            System.out.println(rs.getInt(3) + " " + rs.getInt(4));
            System.out.println();
        }
        
    }
}
