/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeansDB;

import java.util.Objects;

/**
 *
 * @author pepe
 */
public class Valor {
    
    private int idValores;
    private String instrumento;
    private String nombre;
    private int plazo_completo;

    public int getIdValores() {
        return idValores;
    }

    public void setIdValores(int idValores) {
        this.idValores = idValores;
    }

    public String getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(String instrumento) {
        this.instrumento = instrumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPlazo_completo() {
        return plazo_completo;
    }

    public void setPlazo_completo(int plazo_completo) {
        this.plazo_completo = plazo_completo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.idValores;
        hash = 41 * hash + Objects.hashCode(this.instrumento);
        hash = 41 * hash + Objects.hashCode(this.nombre);
        hash = 41 * hash + this.plazo_completo;
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
        if (this.idValores != other.idValores) {
            return false;
        }
        if (this.plazo_completo != other.plazo_completo) {
            return false;
        }
        if (!Objects.equals(this.instrumento, other.instrumento)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Valor{" + "idValores=" + idValores + ", instrumento=" + instrumento + ", nombre=" + nombre + ", plazo_completo=" + plazo_completo + '}';
    }
    
    
}
