/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author pepe
 */
public class Portfolio {
    
    private long id_part1, id_part2;
    private float aptitud;

    public Portfolio() {
    }

    Portfolio(long id_part1, long id_part2) {
            this.id_part1 = id_part1;
            this.id_part2 = id_part1;
    }

    public long getId_part1() {
        return id_part1;
    }

    public void setId_part1(long id_part1) {
        this.id_part1 = id_part1;
    }

    public long getId_part2() {
        return id_part2;
    }

    public void setId_part2(long id_part2) {
        this.id_part2 = id_part2;
    }

    public float getAptitud() {
        return aptitud;
    }

    public void setAptitud(float aptitud) {
        this.aptitud = aptitud;
    }

    @Override
    public String toString() {
        return "Portfolio{" + "id_part1=" + id_part1 + ", id_part2=" + id_part2 + ", aptitud=" + aptitud + '}';
    }
    
    
}
