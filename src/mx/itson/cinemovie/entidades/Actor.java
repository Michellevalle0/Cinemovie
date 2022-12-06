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
import mx.itson.cinemovie.negocio.Operacion;


/**
 * Contiene los objetos de la clase actor
 * Contiene CRUD de actor
 * @author Michelle
 * @author Emmanuel
 * @author Alexis
 */
public class Actor {
    
    private int id; // Id para identificar al actor 
    private String nombre = new String(); // Nombre del actor
    private Date fechaNacimiento; // Fecha de nacimiento del actor
    private String nacionalidad = new String(); // Nacionalidad del actor
    
    /**
     * Obtiene toda la lista de actores que hay registrados.
     * @return Lista de actores registrados en la base de datos
     */ 
     public static List<Actor> obtenerTodos() {
        List<Actor> actores = new ArrayList<>();
        try{
           
           Connection conexion = Conexion.obtener();
           Statement statement = conexion.createStatement();
           ResultSet resultSet = statement.executeQuery("SELECT id, nombre, fechaNacimiento, nacionalidad FROM actor");
           
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
       * Se encarga de guardar la información en la base de datos.
       * @param nombre actor
       * @param fechaNacimiento del actor en string
       * @param nacionalidad del actor
       * @return Indica si se realizo o no el guardado.
       */
     public static boolean guardar(String nombre, String fechaNacimiento, String nacionalidad){
        boolean resultado = false;
        
        try {
            Connection conexion = Conexion.obtener();
            String consulta = "INSERT INTO actor (nombre, fechaNacimiento, nacionalidad) VALUES (?, ?, ?)";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, nombre);
            statement.setDate(2, Operacion.convertirFecha(fechaNacimiento));
            statement.setString(3, nacionalidad);
            statement.execute();
            resultado = statement.getUpdateCount() == 1;
            conexion.close();
        } catch(Exception ex){
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return resultado;
    }
     
     /**
      * Obtiene la información de un actor con su id
      * @param id para identificar al actor
      * @return Información del actor
      */
       public static Actor obtenerPorId(int id) {
        Actor actor = new Actor();
        try {
            Connection conexion = Conexion.obtener();
            PreparedStatement statement = conexion.prepareStatement("SELECT id, nombre, fechaNacimiento, nacionalidad FROM actor WHERE id = ?");
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
        * Actualiza y modifica la información del registro de actores que ya habia.
        * @param id del actor existente
        * @param nombre del actor
        * @param fechaNacimiento del actor
        * @param nacionalidad del actor
        * @return Indica si se realizo o no la edición.
        */
     public static boolean editar(int id, String nombre, String fechaNacimiento, String nacionalidad) {
        boolean resultado = false;
        try {
            Connection conexion = Conexion.obtener();
            String consulta = "UPDATE actor SET nombre = ?, fechaNacimiento = ?, nacionalidad = ? WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, nombre);
            statement.setDate(2, Operacion.convertirFecha(fechaNacimiento));
            statement.setString(3, nacionalidad);
            statement.setInt(4, id);
            
            statement.execute();
            
            resultado = statement.getUpdateCount() == 1;
            conexion.close();
        } catch (Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return resultado;
    }
    
        /**
         * Nos da la posibilidad de hacer una eliminación permanente de los registros. 
         * @param ids id de los registros a eliminar.
         * @return Indica si se realizo la eliminacion o no.
         */
      public static boolean eliminar(int[] ids) {
        boolean resultado = false;

        try {
            Connection con = Conexion.obtener();
            String consulta = "DELETE FROM actor WHERE (id = ?); ";
            PreparedStatement st = con.prepareStatement(consulta);
            for (int i = 0; (ids.length)>i; i++){
                st.setInt(1, ids[i]);
                st.execute();
                resultado = st.getUpdateCount()== 1;
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return resultado;
    }

     
        

    /**
     * @return get : indica que podemos tomar algún valor de un atributo.
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     *  Set : podemos guardar algún valor sobre un atributo.
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
