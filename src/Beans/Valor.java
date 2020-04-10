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
    private double rendimiento;
    private double tiempo_de_inversion;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRendimiento() {
        return rendimiento;
    }

    public void setRendimiento(double rendimiento) {
        this.rendimiento = rendimiento;
    }

    public double getTiempo_de_inversion() {
        return tiempo_de_inversion;
    }

    public void setTiempo_de_inversion(double tiempo_de_inversion) {
        this.tiempo_de_inversion = tiempo_de_inversion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.name);
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.rendimiento) ^ (Double.doubleToLongBits(this.rendimiento) >>> 32));
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.tiempo_de_inversion) ^ (Double.doubleToLongBits(this.tiempo_de_inversion) >>> 32));
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
        if (Double.doubleToLongBits(this.rendimiento) != Double.doubleToLongBits(other.rendimiento)) {
            return false;
        }
        if (Double.doubleToLongBits(this.tiempo_de_inversion) != Double.doubleToLongBits(other.tiempo_de_inversion)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Valor{" + "name=" + name + ", rendimiento=" + rendimiento + ", tiempo_de_inversion=" + tiempo_de_inversion + '}';
    }
    
}
