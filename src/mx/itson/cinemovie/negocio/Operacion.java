/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.cinemovie.negocio;

import java.text.DecimalFormat;
import java.util.List;
import mx.itson.cinemovie.entidades.Resena;

/**
 *
 * @author Emmanuel
 */
public class Operacion {
    
    private static final DecimalFormat df = new DecimalFormat("0.00");
    
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
}
