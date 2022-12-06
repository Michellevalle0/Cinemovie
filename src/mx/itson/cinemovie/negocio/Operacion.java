/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.cinemovie.negocio;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import mx.itson.cinemovie.entidades.Resena;

/**
 *
 * @author Emmanuel
 */
public class Operacion {
    
    // Formato para redondear a 2 decimales
    private static final DecimalFormat df = new DecimalFormat("0.00");
    
    /**
     * Metodo que permite calcular el promedio de las calificaciones que hay en una lista de reseñas
     * @param resenas las reseñas de la pelicula
     * @return el promedio de todas las calificaciones en reseñas que tiene una pelicula 
     */
    public static String calcularCalificacion(List<Resena> resenas){
        
        float calificaciones[] = new float[resenas.size()];
        float total = 0;
        String promedioStr = "----";
        if(resenas.size() != 0){
            // Agregar las calificaciones al array creado anteriormente
            for(int i=0; resenas.size()>i; i++){
            calificaciones[i] = resenas.get(i).getCalificacion();
            }
            // Calcular el promedio mediante la suma y división de todas las calificaciones
            for (int i=0; calificaciones.length>i; i++){
            total = total+calificaciones[i];
            }
            float promedio = total/calificaciones.length;
            promedioStr = df.format(promedio);
        }
        
        return promedioStr;
    }
    
    /**
     * Metodo que permite convertir String a Date
     * @param fechaInicio fecha en string
     * @return fecha en formato para sql
     */
    public static java.sql.Date convertirFecha (String fechaInicio){
        // Fecha convertida a util.Date
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date fecha = sdf.parse(fechaInicio);
            java.sql.Date sqlFecha = new java.sql.Date(fecha.getTime());
            return sqlFecha;
        } catch (Exception ex){
            System.err.println("Ocurrió un error: " + ex.getMessage());
            return null;
        }

    }
    
}
