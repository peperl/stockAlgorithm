/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corealgorithm;

import Beans.CoreAlgorithm;
import DAO.ConsultasDAO;
import java.sql.SQLException;
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
        //CoreAlgorithm ca = new CoreAlgorithm(5, 50000, 127, 1000);
        ConsultasDAO dao = new ConsultasDAO();
        try {
            dao.consulta();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
