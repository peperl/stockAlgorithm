/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author pepe
 */
public class JavaConnectorMySQL {

    public Connection proceso() throws ClassNotFoundException, SQLException{ 
        Class.forName("com.mysql.jdbc.Driver");  
        Connection con = (Connection) DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/DB_TTR","root","1859681449");
        return con;        
    }

            /*
            //here sonoo is database name, root is username and password  
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("select * from emp");  
            while(rs.next())  
            System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
            con.close();  
            */    
}
