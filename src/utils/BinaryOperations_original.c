 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//gcc -o BinaryOperations.so BinaryOperations.c -shared -I/usr/local/java/jdk1.8.0_161/include -I/usr/local/java/jdk1.8.0_161/include/linux -fPIC

#include <stdio.h>
#include <stdlib.h>

//long elements = 7;

long getPercentage(long id, long position) {
    long aux;
    aux = id << 15 + (7 * (7 - position) );
    aux = id >> 15 + (7 * (7 - 1) );
    return aux;
}

long setPercentage(long id, long position, long newValue) {
    
    id -= getPercentage(id, position);
    newValue = getPercentage(newValue, 1);
    newValue = newValue << (position-1);
    id += newValue;
    return id;
}

long initialize(long id, long inversionsOn) {
        
    long aux, aux2;
    
    for(int i = 1; i <= 7; i++) {
        
        aux = inversionsOn << (8*8 - i);
        aux = aux >> (8*8 - 1);    
        
        if(aux == 0) {
            aux2 = getPercentage(id,i);
            inversionsOn -= aux2;
        }
    }
    return inversionsOn;
}

long aquote(long id) {
    
    long aux[7];
    long totalPercentage = 0;
    
    for(int i = 0; i < 7; i++) {
        aux[i] = getPercentage(id, i);
        totalPercentage+=aux[i];
    }
    
    if(totalPercentage > 100) {
        
        while(totalPercentage > 100) {
            for(int i = 0; i < 7; i++) {
                if(aux[i] > 1 & totalPercentage > 100) {
                    aux[i]-=1;
                    totalPercentage-=1;
                }
            }
        }
        
    } else if (totalPercentage < 100) {
        
        while(totalPercentage < 100) {
            for(int i = 0; i < 7; i++) {
                if(aux[i] < 100 & totalPercentage < 100) {
                    aux[i]+=1;
                    totalPercentage+=1;
                }
            }
        }
    }
    
    //create the new number con la variable aux[]
    id = 0;
    for(int i = 1; i <= 7; i++) {
        id = setPercentage(id,i,aux[i-1]);
    }
    return id;
}

long setId(long id, long inversionsOn) {
    id = initialize(id, inversionsOn);
    id = aquote(id);
    return id;
}

long cross(long id1, long id2) {
    
    long aux, aux2;
    aux = id1 << 15;
    aux = id1 >> 15 + (7 * (7 - 3) );
    aux = id1 << 7 * (7 - 3);
    
    aux2 = id2 << 15 + (7 * (7 - 4 ) );
    aux2 = id2 >> 15 + (7 * (7 - 4 ) );
    
    return aux + aux2;
}

long mutation(long id) {
    
    time_t t;
    srand((unsigned) time(&t));
    
    long position1 = rand() % 7;
    long position2 = rand() % 7;
    long aux = getPercentage(id, position1);
    long aux2 = getPercentage(id, position2);
    
    aux += 1;
    aux2 += 1;
    
    id = setPercentage(id, position1, aux);
    id = setPercentage(id, position2, aux2);
    return id;
(long) }
    

