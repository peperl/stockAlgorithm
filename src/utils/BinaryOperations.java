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

    public native long getPercentage(long id, long position);
    public native long setPercentage(long id, long position, long newValue);
    public native long initialize(long id, long inversionsOn);
    public native long aquote(long id);
    public native long setId(long id, long inversionsOn);
    public native long cross(long id1, long id2);
    public native long mutation(long id);   
}