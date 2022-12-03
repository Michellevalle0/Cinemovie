/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.cinemovie.entidades;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mx.itson.cinemovie.persistencia.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;


/**
 *
 * @author michelle
 */
public class Actor {
    
    private int id;
    private String nombre = new String();
    private Date fechaNacimiento;
    private String nacionalidad = new String();
    
    /**
     * 
     * @return 
     */
     
     public static List<Actor> obtenerTodos() {
        List<Actor> actores = new ArrayList<>();
        try{
           
           Connection conexion = Conexion.obtener();
           Statement statement = conexion.createStatement();
           ResultSet resultSet = statement.executeQuery("SELECT id, nombre, apellidos, fechaNacimiento, nacionalidad FROM actor");
           
           while(resultSet.next()){
               Actor actor = new Actor();
               actor.setId(resultSet.getInt(1));
               actor.setNombre(resultSet.getString(2));
               actor.setFechaNacimiento(resultSet.getDate(3));
               actor.setNacionalidad(resultSet.getString(4));
               
               actores.add(actor);
               
           }
        } catch (Exception ex){
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return actores;
     }
     
    
     
      /**
       * 
       * @param nombre
       * @param fechaNacimiento
       * @param nacionalidad
       * @return 
       */
     public static boolean guardar(String nombre, Date fechaNacimiento, String nacionalidad){
        boolean resultado = false;
        try {
            Connection conexion = Conexion.obtener();
            String consulta = "INSERT INTO actor (nombre, nacionalidad) VALUES (?, ?)";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, nombre);
            statement.setString(2, nacionalidad);
            statement.execute();
            resultado = statement.getUpdateCount() == 1;
            conexion.close();
        } catch(Exception ex){
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return resultado;
    }
     
     /**
      * 
      * @param id
      * @return 
      */
       public static Actor obtenerPorId(int id) {
        Actor actor = new Actor();
        try {
            Connection conexion = Conexion.obtener();
            PreparedStatement statement = conexion.prepareStatement("SELECT id, nombre, fechaNacimiento, nacionalidad FROM actor WHERe id = ?");
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                actor.setId(resultSet.getInt(1));
                actor.setNombre(resultSet.getString(2));
                actor.setFechaNacimiento(resultSet.getDate(3));
                actor.setNacionalidad(resultSet.getString(4));

                
            }

        } catch (Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return actor;
    }
      
       /**
        * 
        * @param id
        * @param nombre
        * @param fechaNacimiento
        * @param nacionalidad
        * @return 
        */
     public static boolean editar(int id, String nombre, Date fechaNacimiento, String nacionalidad) {
        boolean resultado = false;
        try {
            Connection conexion = Conexion.obtener();
            String consulta = "UPDATE actor SET nombre = ?, nacionalidad = ? WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, nombre);
            statement.setString(2, nacionalidad);
            statement.setInt(3, id);
            
            statement.execute();
            
            resultado = statement.getUpdateCount() == 1;
            conexion.close();
        } catch (Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return resultado;
    }
    
        /**
         * 
         * @param id
         * @return 
         */
      public static boolean eliminar(int id) {
        boolean resultado = false;

        try {
            Connection con = Conexion.obtener();
            String consulta = "DELETE FROM actor WHERE (id = ?); ";
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
     * @return the fechaNacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @return the nacionalidad
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * @param nacionalidad the nacionalidad to set
     */
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    
    
    
}
