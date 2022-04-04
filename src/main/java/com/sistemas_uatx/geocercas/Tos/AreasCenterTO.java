/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemas_uatx.geocercas.Tos;

/**
 *
 * @author Dell
 */
public class AreasCenterTO {
    private String idArea;
    private String dsArea;
    private Double lat;
    private Double lon;        

    public AreasCenterTO(String idArea, String dsArea,
                        Double lat,Double lon) {
        this.idArea = idArea;
        this.dsArea = dsArea;
        this.lat = lat;
        this.lon = lon;
    }

    public String getIdArea() {
        return idArea;
    }

    public void setIdBienPatrimonial(String idArea) {
        this.idArea = idArea;
    }

    public String getDsArea() {
        return dsArea;
    }

    public void setDsBienPatrimonial(String dsBienPatrimonial) {
        this.dsArea = dsArea;
    }

    public Double getLat() {
        return lat;
    }

    public void setlat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

}
