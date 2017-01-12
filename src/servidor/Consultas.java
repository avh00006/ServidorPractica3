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
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class Consultas 
{
    
   public static LinkedList<Hombro> getHombro()
   {
      
      LinkedList<Hombro> listaHombro=new LinkedList<Hombro>();
      try
      {
       
         ConexionBD conn=ConexionBD.getInstancia();
         ResultSet rs= conn.ejecutarConsulta("SELECT * FROM hombro");
         
         while (rs.next())
         {
            Hombro rutina = new Hombro();
            rutina.setId(rs.getInt("ID"));
            rutina.setSerie(rs.getString("serie"));
            rutina.setRepeticion(rs.getString("repeticion"));
            rutina.setNombre(rs.getString("nombre"));
            listaHombro.add(rutina);
         }
         rs.close();
         conn.cerrarconexion();
         
      }
      catch (Exception e)
      {
         JOptionPane.showMessageDialog(null, "Incorrecto :( " + e);
      }
      return listaHombro;
   }
   
   public static LinkedList<Piernas> getPiernas()
   {
      LinkedList<Piernas> listaPiernas=new LinkedList<Piernas>();
      try
      {
         ConexionBD conn=ConexionBD.getInstancia();
         ResultSet rs= conn.ejecutarConsulta("SELECT * FROM piernas");
         while (rs.next())
         {
            Piernas rutina = new Piernas();
            rutina.setId(rs.getInt("ID"));
            rutina.setSerie(rs.getString("serie"));
            rutina.setRepeticion(rs.getString("repeticion"));
            rutina.setNombre(rs.getString("nombre"));
            listaPiernas.add(rutina);
         }
         rs.close();
         conn.cerrarconexion();
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      return listaPiernas;
   }
   
   public static LinkedList<Espalda> getEspalda()
   {
      LinkedList<Espalda> listaEspalda=new LinkedList<Espalda>();
      try
      {
         ConexionBD conn=ConexionBD.getInstancia();
         ResultSet rs= conn.ejecutarConsulta("SELECT * FROM espalda");
         while (rs.next())
         {
            Espalda rutina = new Espalda();
            rutina.setId(rs.getInt("ID"));
            rutina.setSerie(rs.getString("serie"));
            rutina.setRepeticion(rs.getString("repeticion"));
            rutina.setNombre(rs.getString("nombre"));
            listaEspalda.add(rutina);
         }
         rs.close();
         conn.cerrarconexion();
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      return listaEspalda;
   }
} 