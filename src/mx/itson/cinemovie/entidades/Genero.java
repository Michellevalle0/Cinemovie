/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.cinemovie.entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import mx.itson.cinemovie.persistencia.Conexion;

/**
 *
 * @author michelle
 */
public class Genero {
    
    private int id;
    private String nombre = new String();
    private String descripcion = new String();

    
    
     public static boolean guardar(String nombre, String descripcion){
        boolean resultado = false;
        try {
            Connection conexion = Conexion.obtener();
            String consulta = "INSERT INTO genero (nombre, descripcion) VALUES (?, ?)";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, nombre);
            statement.setString(2, descripcion);
            statement.execute();
            resultado = statement.getUpdateCount() == 1;
            conexion.close();
        } catch(Exception ex){
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return resultado;
    }
    
     public static boolean editar(int id, String nombre,String descripcion) {
        boolean resultado = false;
        try {
            Connection conexion = Conexion.obtener();
            String consulta = "UPDATE genero SET nombre = ?, descripcion = ? WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, nombre);
            statement.setString(2, descripcion);
            statement.setInt(3, id);
            
            statement.execute();
            
            resultado = statement.getUpdateCount() == 1;
            conexion.close();
        } catch (Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return resultado;
    }
     
      public static boolean eliminar(int id) {
        boolean resultado = false;

        try {
            Connection con = Conexion.obtener();
            String consulta = "DELETE FROM genero WHERE (id = ?); ";
            PreparedStatement st = con.prepareStatement(consulta);
            st.setInt(1,id);
            resultado = st.execute();

        } catch (Exception e) {
            System.out.println(e);
        }

        return resultado;
    }
      
      
      
      
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
