/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import BeansDB.Historico;
import BeansDB.Valor;
import Connection.JavaConnectorMySQL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pepe
 */
public class ConsultasDAO {

    private static String consulta = "SELECT Historico.fecha, Valores.nombre, Historico.tasa, Historico.plazo, Valores.plazo_completo from Historico INNER JOIN Valores ON Historico.idValores = Valores.idValores where Historico.fecha = ?;";
    
    List<Valor> valores;
    List <Historico> historicos;

    public ConsultasDAO() {
        valores = new ArrayList<>();
        historicos = new ArrayList<>();
    }
    
    

    public void consulta(Date fecha) throws ClassNotFoundException, SQLException {
        
        
        JavaConnectorMySQL connector = new JavaConnectorMySQL();
        Connection conn = connector.proceso();
        PreparedStatement stmt = conn.prepareStatement(consulta);  
        stmt.setDate(1, fecha);
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()) {
            
            Valor valor = new Valor();
            Historico historico = new Historico();
                        
            historico.setFecha(rs.getDate(1).toLocalDate());
            valor.setNombre(rs.getString(2));
            historico.setTasa(rs.getInt(3));
            historico.setPlazo(rs.getInt(4));
            valor.setPlazo_completo(rs.getInt(5));
            
            valores.add(valor);
            historicos.add(historico);
        }
    }

    public List<Valor> getValores() {
        return valores;
    }

    public void setValores(List<Valor> valores) {
        this.valores = valores;
    }

    public List<Historico> getHistoricos() {
        return historicos;
    }

    public void setHistoricos(List<Historico> historicos) {
        this.historicos = historicos;
    }
    
    
}
