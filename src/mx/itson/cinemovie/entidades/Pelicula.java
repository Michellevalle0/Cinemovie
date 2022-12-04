/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.cinemovie.entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mx.itson.cinemovie.persistencia.Conexion;

/**
 * @param id ID para identificar la pelicula
 * @param titulo Titulo de la pelicula
 * @param duracion Duracion total en minutos de la pelicula
 * @param genero Genero de la pelicula
 * 
 * @author Michelle
 * @author Emmanuel
 */
public class Pelicula {
    
    private int id;
    private String titulo = new String();
    private double duracion;
    private String genero;

    /**
     * Metodo para obtener desde la base de datos todos los datos de la tabla pelicula
     * @return Lista con todas las peliculas que existen en la base de datos
     */
    public static List<Pelicula> obtenerTodos(){
        
        // Lista que almacenara las peliculas
        List<Pelicula> peliculas = new ArrayList<>();
        try{
            // Realiza la conexion con la base de datos
            Connection conexion = Conexion.obtener();
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id, titulo, duracion, genero FROM pelicula");
            
            // Mientras exista un valor en el siguiente campo ejecutar codigo
            while (resultSet.next()){
                Pelicula pelicula = new Pelicula();
                pelicula.setId(resultSet.getInt(1));
                pelicula.setTitulo(resultSet.getString(2));
                pelicula.setDuracion(resultSet.getDouble(3));
                pelicula.setGenero(resultSet.getString(4));
                
                //Agrega la pelicula a la lista de peliculas
                peliculas.add(pelicula);
            }
            
        } catch (Exception ex){
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return peliculas;
    }
    
    /**
     * Metodo para guardar en la base de datos los datos de una pelicula
     * @param titulo Titulo de la pelicula
     * @param duracion Duracion en minutos de la pelicula
     * @param genero Genero de la pelicula
     * @return Indica si se guardó o no el registro.
     */
    public static boolean guardar(String titulo, double duracion, String genero){
        boolean resultado = false;
        try {
            Connection conexion = Conexion.obtener();
            String consulta = "INSERT INTO pelicula (titulo, duracion, genero) VALUES (?, ?, ?)";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, titulo);
            statement.setDouble(2, duracion);
            statement.setString(3, genero);
            statement.execute();
            resultado = statement.getUpdateCount() == 1;
            conexion.close();
        } catch(Exception ex){
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return resultado;
    }
    
    /**
     * Metodo para editar en la base de datos los datos de la pelicula
     * @param id Id de la pelicula a editar
     * @param titulo Titulo a editar de la pelicula
     * @param duracion Duracion a editar de la pelicula
     * @param genero Genero a editar de la pelicula
     * @return Indica si se realizo o no el cambio.
     */
    public static boolean editar(int id, String titulo, double duracion, String genero){
        boolean resultado = false;
        try {
            Connection conexion = Conexion.obtener();
            String consulta = "REPLACE INTO pelicula (id, titulo, duracion, genero) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1, id);
            statement.setString(2, titulo);
            statement.setDouble(3, duracion);
            statement.setString(4, genero);
            statement.execute();
            resultado = statement.executeUpdate()== 1;
            conexion.close();
        } catch(Exception ex){
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return resultado;
    }
    
    /**
     * Metodo para eliminar una pelicula
     * @param id Id de la pelicula a eliminar
     * @return Indica si se realizo o no la eliminación.
     */
    public static boolean eliminar(int[] ids){
        boolean resultado = false;
        try {
            Connection conexion = Conexion.obtener();
            String consulta = "DELETE FROM pelicula WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            // Ejecutar un statement diferente por cada id que exista en ids
            for (int i = 0; (ids.length)>i; i++){
                statement.setInt(1, ids[i]);
                statement.execute();
                resultado = statement.getUpdateCount()== 1;
            }
            conexion.close();
        } catch(Exception ex){
            System.err.println("Ocurrió un error: " + ex.getMessage());
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
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the duracion
     */
    public double getDuracion() {
        return duracion;
    }

    /**
     * @param duracion the duracion to set
     */
    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }
    
   
    
}
