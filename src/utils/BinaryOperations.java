/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author pepe
 */

// javah -o BinaryOperation.h -classpath TTPRoyect/build/classes mx.ipn.www.finalproject.utils.BinaryOperation
// javah -o BinaryOperations.h -classpath CoreAlgorithm/build/classes utils.BinaryOperations

//javac -classpath /home/pepe/NetBeansProjects/CoreAlgorithm/build/classes/ -h /home/pepe/NetBeansProjects/CoreAlgorithm/src/utils/ CoreAlgorithm/src/utils/BinaryOperations.java

public class BinaryOperations {
    
    static {
         LoadLibrary.loadNativeLibrary();
     }    

    public native long getPercentage(long id_part1, long position);
    public native long setPercentage(long id_part, long position, long newValue);
    public native long getValoresActivos(long valoresActivos, long parts);
    public native long setId(long id_part, long id_part2, long inversionsOn);
    public native long aquote_part2(long id, long percentage, long inversionsOn);
    public native long mutation(long id_part);   
}
