/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import utils.BinaryOperations;

/**
 *
 * @author pepe
 */
public class ValoresActivos {
    
    private Long variable;
    BinaryOperations bo;

    public ValoresActivos() {
        variable = new Long(0);
        bo = new BinaryOperations();
    }
    
    public Long getVariable(long part) {
        return bo.getValoresActivos(variable, part);
    }

    public Long getVariable() {
        return variable;
    }

    public void setVariable(int activePosition) {
        variable += new Double(Math.pow(2, activePosition)).longValue();
    }
    
}
