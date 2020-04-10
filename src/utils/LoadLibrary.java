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
public class LoadLibrary {
    public static void loadNativeLibrary() {
        //System.loadLibrary("utils_BinaryOperations");
        System.load("/home/pepe/NetBeansProjects/CoreAlgorithm/src/utils/utils_BinaryOperations.so");
    }    
}
