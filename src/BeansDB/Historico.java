/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeansDB;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author pepe
 */
public class Historico {
    
    private int idHistorico;
    private LocalDate fecha;
    private int idValores;
    private float tasa;
    private int plazo;

    public int getIdHistorico() {
        return idHistorico;
    }

    public void setIdHistorico(int idHistorico) {
        this.idHistorico = idHistorico;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getIdValores() {
        return idValores;
    }

    public void setIdValores(int idValores) {
        this.idValores = idValores;
    }

    public float getTasa() {
        return tasa;
    }

    public void setTasa(float tasa) {
        this.tasa = tasa;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.idHistorico;
        hash = 79 * hash + Objects.hashCode(this.fecha);
        hash = 79 * hash + this.idValores;
        hash = 79 * hash + Float.floatToIntBits(this.tasa);
        hash = 79 * hash + this.plazo;
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
        final Historico other = (Historico) obj;
        if (this.idHistorico != other.idHistorico) {
            return false;
        }
        if (this.idValores != other.idValores) {
            return false;
        }
        if (Float.floatToIntBits(this.tasa) != Float.floatToIntBits(other.tasa)) {
            return false;
        }
        if (this.plazo != other.plazo) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Historico{" + "idHistorico=" + idHistorico + ", fecha=" + fecha + ", idValores=" + idValores + ", tasa=" + tasa + ", plazo=" + plazo + '}';
    }
    
    
}
