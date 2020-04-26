package Beans;


import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pepe
 */
public class Valor {
    
    private String name;
    private double plazo;
    private double taza;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPlazo() {
        return plazo;
    }

    public void setPlazo(double plazo) {
        this.plazo = plazo;
    }

    public double getTaza() {
        return taza;
    }

    public void setTaza(double taza) {
        this.taza = taza;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.name);
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.plazo) ^ (Double.doubleToLongBits(this.plazo) >>> 32));
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.taza) ^ (Double.doubleToLongBits(this.taza) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Valor other = (Valor) obj;
        if (Double.doubleToLongBits(this.plazo) != Double.doubleToLongBits(other.plazo)) {
            return false;
        }
        if (Double.doubleToLongBits(this.taza) != Double.doubleToLongBits(other.taza)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Valor{" + "name=" + name + ", rendimiento=" + plazo + ", tiempo_de_inversion=" + taza + '}';
    }
    
}
