package com.sistemas_uatx.geocercas;
import com.sistemas_uatx.geocercas.Tos.AreasCenterTO;
import java.awt.geom.Path2D;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author Dell
 */
public class Coordenadas_dentro {
    public static void main(String[] args){        
        estaEnRectoria(19.47226,-97.92359);
    }
    public static void estaEnRectoria(Double lat, Double lon){
    ArrayList<AreasCenterTO> model = null;
            Path2D pat= new Path2D.Double();
                    pat.moveTo(19.47225,-97.9235);
                    pat.lineTo(19.47221,-97.92354);
                    pat.lineTo(19.47229,-97.92369);
                    pat.lineTo(19.47233,-97.92365);
                    pat.closePath();
            if(pat.contains(lat,lon)==true){
                ArrayList<Double> LatLong= new ArrayList<Double>(Arrays.asList(1.38, 2.56, 4.3));
                System.out.println(pat.contains(lat,lon)+" Los puntos "+lat+", "+lon+" si estan dentro de la geocerca");
                //Obtener JSON de coordenadas del centro de cada area
                //Obtener los puntos de cada area de rectoria para evaluar en que area esta
                ArrayList<AreasCenterTO> listaAreas = new ArrayList<>();
                Double lat2=0.0;
                Double lon2=0.0;
                listaAreas.add(new AreasCenterTO("01","Sistemas",19.47229,-97.92345));
                listaAreas.add(new AreasCenterTO("02","Soporte",19.47232,-97.92355));
                
                //comoparar lat & lon del usuario con lat1 &lon2 de cada area en el arraylist
                for(int i=0; i<=listaAreas.size();i++){
                //Double latitud = model.get(i).getLat();
                //Double longitud =model.get(i).getLon();
                System.out.println("Inicia getDistance");
                    getDistancia(lat,lon,19.47223,-97.92346);//getDistancia(lat,lon,latitud,longitud);
                }                
            }else{
                System.out.println(pat.contains(lat,lon)+" Los puntos "+lat+", "+lon+" no estan dentro de la geocerca");
            }
    }
    
    public static void enElArea(Double lat, Double lon){

    }
    public static double getDistancia (double lat1, double lon1, double lat2, double lon2) {
        double R = 6378.137; //Radio de la tierra en km
        double dLat = rad(lat2 - lat1);
        double dLong = rad(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos(rad(lat1)) * Math.cos(rad(lat2)) * Math.sin(dLong / 2) * Math.sin(dLong / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double d = R * c;//En kilometros
        d = d * 1000;//A metros
        formato(d);
        return d;
    }

    public static Double rad(Double d){
    return d*Math.PI/180.0;
    }
    static void formato(double d) {
        DecimalFormat df = new DecimalFormat("##.##");
        System.out.println("Distancia->> "+df.format(d)+" sin formato= "+ d);      
    }
}
