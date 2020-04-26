package Beans;


import Constantes.Constantes;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import utils.BinaryOperations;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pepe
 */
public class CoreAlgorithm {
    
    /**
     * 
     * @param time en dias
     * @param money en pesos mexicanos
     * @param interes en rendimiento anual
     */
    public CoreAlgorithm(int time, double money, long valoresActivos, int populationSize){
        
        List<Long> longValues = initialPopulation(populationSize, valoresActivos);
        
        
        //ETAPA 3
        //CRUZA
        longValues = cross(longValues);
        
        //ETAPA 4
        //MUTACIÓN
        
    }

    private List<Long> initialPopulation(long populationSize, long valoresActivos) {

        Random random = new Random();
        BinaryOperations bo = new BinaryOperations();
        List<Long> longValues = new ArrayList();

        //ETAPA 1 
        // CREAR UNA POBLACIÓN ALEATORIA
        for (int i = 0; i < populationSize; i++) {
            long aux = random.nextLong();
            if (aux < 0) {
                aux += -1;
            }
            longValues.add(aux);
        }
        
        
        //ETAPA 2
        //Adecuar cada individuo a los valores que estarán activos.
        
        for (Long longValue : longValues) {
            //Valores activos se usaran solamente sus primeros 7 bits como banderas
            //para conocer si ese valor estará activo o no.
            longValue = bo.setId(longValue, valoresActivos);
        }
        
        return longValues;
    }   

    private List<Long> cross(List<Long> longValues) {
        
        return null;
    }
    
}