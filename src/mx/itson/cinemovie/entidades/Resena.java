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
import javax.swing.table.DefaultTableModel;
import mx.itson.cinemovie.persistencia.Conexion;

/**
 *
 * @author Emmanuel
 */
public class Resena{
    
    private int id;
    private int idPelicula;
    private String usuario;
    private String descripcion;
    private float calificacion;
    
    public static List<Resena> obtenerTodosPorId(int id){
        
        // Lista que almacenara las reseñas
        List<Resena> resenas = new ArrayList<>();
        try{
            // Realiza la conexion con la base de datos
            Connection conexion = Conexion.obtener();
            Statement statement = conexion.createStatement();
            
            ResultSet resultSet = statement.executeQuery("SELECT idresena, idpelicula, usuario, descripcion, calificacion FROM resena WHERE idpelicula=" + id);
            
            // Mientras exista un valor en el siguiente campo ejecutar codigo
            while (resultSet.next()){
                Resena resena = new Resena();
                resena.setId(resultSet.getInt(1));
                resena.setIdPelicula(resultSet.getInt(2));
                resena.setUsuario(resultSet.getString(3));
                resena.setDescripcion(resultSet.getString(4));
                resena.setCalificacion(resultSet.getFloat(5));
                
                // Agrega la reseña a la lista de reseñas
                resenas.add(resena);
            }
            
        } catch (Exception ex){
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return resenas;
    }
    
    public static boolean guardar(int idpelicula, String usuario, String descripcion, float calificacion){
        boolean resultado = false;
        try {
            Connection conexion = Conexion.obtener();
            String consulta = "INSERT INTO resena (idpelicula, usuario, descripcion, calificacion) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1, idpelicula);
            statement.setString(2, usuario);
            statement.setString(3, descripcion);
            statement.setFloat(4, calificacion);
            statement.execute();
            resultado = statement.getUpdateCount() == 1;
            conexion.close();
        } catch(Exception ex){
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return resultado;
    }
    
    public static boolean editar(int id, int idpelicula, String usuario, String descripcion, float calificacion){
        boolean resultado = false;
        try {
            Connection conexion = Conexion.obtener();
            String consulta = "REPLACE INTO resena (idresena, idpelicula, usuario, descripcion, calificacion) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1, id);
            statement.setInt(2, idpelicula);
            statement.setString(3, usuario);
            statement.setString(4, descripcion);
            statement.setFloat(5, calificacion);
            statement.execute();
            resultado = statement.executeUpdate()== 1;
            conexion.close();
        } catch(Exception ex){
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return resultado;
    }
    
    public static boolean eliminar(int[] ids){
        boolean resultado = false;
        try {
            Connection conexion = Conexion.obtener();
            String consulta = "DELETE FROM resena WHERE idresena = ?";
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
    
    public static void cargarTabla(DefaultTableModel modelo, javax.swing.JTable tabla){
        if (tabla.getSelectedRowCount() != 0){
            List<Resena> resenas = Resena.obtenerTodosPorId(Integer.parseInt(tabla.getModel().getValueAt(tabla.getSelectedRow(), 0).toString()));
            // Borrar los contenidos de la tabla
            modelo.setRowCount(0);
        
            // Por cada reseña que exista en reseñas se agregara la misma a la tabla
            for(Resena r : resenas){
                modelo.addRow(new Object[] {
                r.getId(),
                r.getUsuario(),
                r.getDescripcion(),
                r.getCalificacion(),
                });
            }  
        } else {
            modelo.setRowCount(0);
        }
        
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
     * @return the idPelicula
     */
    public int getIdpelicula() {
        return idPelicula;
    }

    /**
     * @param idpelicula the idPelicula to set
     */
    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

    /**
     * @return the calificacion
     */
    public float getCalificacion() {
        return calificacion;
    }

    /**
     * @param calificacion the calificacion to set
     */
    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }
}
