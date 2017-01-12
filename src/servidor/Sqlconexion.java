/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
 
/**
 *
 * @author ANGEL
 */
public class Sqlconexion {
    //Configuracion de los datos de la BD
    private String usuario = "root";
    private String pass = "";
    private String host = "localhost";
    private String nombre_BD = "rutinas";
 
    private Connection con = null;
 
    public Sqlconexion() {
    }
   
    
    public Connection getConexionMYSQL(){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance( );
            String servidor = "jdbc:mysql://"+host+"/"+nombre_BD;
            con = DriverManager.getConnection(servidor,usuario,pass);
            return con;
        }catch(Exception e){
            e.printStackTrace();
            return con;
        }
        
    }
    
    public void getTable(){
        try{
            
            Sqlconexion conexion = new Sqlconexion();
            Connection con = conexion.getConexionMYSQL();
         
            String query = "SELECT * FROM hombro";
        
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
         
 
            DefaultTableModel modelo = new DefaultTableModel();
            JTable tabla = new JTable (modelo);
      
            modelo.addColumn("ID");
            modelo.addColumn("Serie");
            modelo.addColumn("Repeticion");
            modelo.addColumn("Nombre");
   
            while(rs.next()){
               Object row [] = new Object[4]; 
                for (int i = 0; i < 4; i++) {
                    row[i] = rs.getObject(i+1); 
                }
             
                modelo.addRow(row);
            }
 
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    
}
