/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corealgorithm;


import Beans.CoreAlgorithm;
import Beans.Portfolio;
import Beans.ValoresActivos;
import BeansDB.Historico;
import BeansDB.Valor;
import DAO.ConsultasDAO;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.BinaryOperations;

/**
 *
 * @author pepe
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //CoreAlgorithm ca = new CoreAlgorithm(5, 50000, 511, 3);
        
        //pruebas con DB
        ConsultasDAO dao = new ConsultasDAO();
        try {
            dao.consulta(Date.valueOf("2020-04-24"));
            
            List<Historico> a =dao.getHistoricos();
            List<Valor> b = dao.getValores();
            
            //Prueba con 2000 días
            int valorPorUsuario = 365;
            ValoresActivos va = new ValoresActivos();
            
            int cont = 0;
            for (Historico historico : a) {
                if (historico.getPlazo() <= valorPorUsuario) {
                    va.setVariable(cont);
                }
                cont++;
            }
            CoreAlgorithm ca = new CoreAlgorithm(valorPorUsuario, 5000, va, 1,a,b);
            for (Portfolio portfolio : ca.getPortfolios()) {
                System.out.println("aptitud: " + portfolio.getAptitud());
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
