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
        //Obtener coordenadas del usuario
        Double latUsuario=0.0;
        Double lonUsuario=0.0;
        estaEnRectoria(19.30297,-98.24133);//<--- (latUsuario,lonUsuario);
    }
    public static void estaEnRectoria(Double lat, Double lon){//Determina si el usuario esta en rectoria
            ArrayList<AreasCenterTO> model = null;//Arraylist tipo areas
            Path2D pat= new Path2D.Double();//Geocerca real de rectoria
                    pat.moveTo(19.30396,-98.24119);//19.30387,-98.24124);//LAS CHIDAS
                    
                    pat.lineTo(19.30313,-98.24244);//19.30306,-98.24234);
                    pat.lineTo(19.30256,-98.24363);//19.30247,-98.24357);
                    pat.lineTo(19.3022,-98.24442);//19.30211,-98.2444);
                    pat.lineTo(19.30023,-98.24409);//19.30023,-98.2439);
                    pat.lineTo(19.29976,-98.24407);//19.29977,-98.24391);
                    pat.lineTo(19.2989,-98.2439);//19.29905,-98.24396);
                    pat.lineTo(19.29889,-98.24135);//19.29881,-98.24156);
                    pat.closePath();
                    
            if(pat.contains(lat,lon)==true){//
                System.out.println(pat.contains(lat,lon)+" Las coordenadas "+lat+", "+lon+" si estan dentro de la geocerca");
                //Obtener JSON de coordenadas del centro de cada area
                
                //Obtener los puntos de cada area de rectoria para evaluar en que area esta
                ArrayList<AreasCenterTO> listaAreas = new ArrayList<>();              
                listaAreas.add(new AreasCenterTO("01","Sistemas",19.29914,-98.24202));
                listaAreas.add(new AreasCenterTO("02","Soporte",19.30215,-98.2429));
                
                for (int i = 0; i < listaAreas.size(); i++) {                        
                    //System.out.println("lat: "+listaAreas.get(i).getLat()+"lon: "+listaAreas.get(i).getLon());                   
                    Double latitud = listaAreas.get(i).getLat();
                    Double longitud =listaAreas.get(i).getLon();
                    System.out.println("Distancia entre los puntos:");
                    //lat & lon = ubicacion del usuario
                    //latitud & longitud = coordenadas del area obtenidas del servicio
                    getDistancia(lat,lon,latitud,longitud);
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
