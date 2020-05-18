#include <jni.h>
#include <stdio.h>      // C Standard IO Header
#include <stdlib.h>
#include "utils_BinaryOperations.h"   // Generated

//terminal
// gcc -fPIC -shared -I/usr/local/jdk1.8.0_111/include -I/usr/local/jdk1.8.0_111/include/linux utils_BinaryOperations.c -o utils_BinaryOperations.so


//CHECK 5-5-2020
long getPercentage(long id_part1, long position) {
    return 0x7F & (id_part1 >> 7 * position);
}

//CHECK 5-5-2020
void showId(long id) {
	for (int i = 0; i < 9; i++)
	{
		printf(" %lu ", getPercentage(id,i));
	}
	printf("\n");
}

//CHECK 5-5-2020
long setPercentage(long id, long position, long newValue) {

    id -= (getPercentage(id, position) << (position * 7));
    newValue = getPercentage(newValue, 0);
    newValue = newValue << (position * 7);
    id += newValue;
    return id;
}

long initialize(long id, long inversionsOn) {

    long aux, aux2;

    for(int i = 1; i <= 9; i++) {

        aux = inversionsOn & (1 << (i - 1));

        if(aux == 0) {
            aux2 = getPercentage(id, i - 1 );
            id -= (aux2 << (7 * (i - 1)));
        }
    }
    return id;
}

long aquote(long id, long id_part2) {

    long aux[9], aux_part2[9];
    long totalPercentage = 0;

    for(int i = 0; i < 9; i++) {
        aux[i] = getPercentage(id, i);
        aux_part2[i] = getPercentage(id_part2, i);
        totalPercentage += aux[i];
        totalPercentage += aux_part2[i];
    }


    if(totalPercentage > 100) {

        while(totalPercentage > 100) {

            for(int i = 0; i < 9; i++) {
                if(aux[i] > 1 & totalPercentage > 100 & (aux[i] != 0)) {
                    aux[i] -= 1;
                    totalPercentage -= 1;
                }
            }
            for(int i = 0; i < 9; i++) {
                if(aux_part2[i] > 1 & totalPercentage > 100 & (aux_part2[i] != 0)) {
                    aux_part2[i] -= 1;
                    totalPercentage -= 1;
                }
            }            
        }

    } else if (totalPercentage < 100) {

        while(totalPercentage < 100) {
            for(int i = 0; i < 9; i++) {
                if( aux[i] < 100 & totalPercentage < 100 & (aux[i] != 0)) {
                    aux[i] += 1;
                    totalPercentage += 1;
                }
            }
            for(int i = 0; i < 9; i++) {
                if( aux_part2[i] < 100 & totalPercentage < 100 & (aux_part2[i] != 0)) {
                    aux_part2[i] += 1;
                    totalPercentage += 1;
                }
            }            
        }
    }
    //create the new number con la variable aux[]

    id = 0;
    for(int i = 0; i < 9; i++) {
        id += aux[i] << 7 * i;
    }
    return id;
}

long getValoresActivos(long valoresActivos, long part) {
    if (part == 0)
    {
        return valoresActivos & 0x01FF;
    } else {
        return (valoresActivos>>9) & 0x1FF;
    }
}

/*
 * Class:     utils_BinaryOperations
 * Method:    getPercentage
 * Signature: (JJ)J
 */
JNIEXPORT jlong JNICALL Java_utils_BinaryOperations_getPercentage
  (JNIEnv * env, jobject obj, jlong id_, jlong position_) {

    long id = (long) id_;
    long position = (long) position_;
	return 0x7F & (id >> 7 * position);
}

/*
 * Class:     utils_BinaryOperations
 * Method:    setPercentage
 * Signature: (JJJ)J
 */
JNIEXPORT jlong JNICALL Java_utils_BinaryOperations_setPercentage
  (JNIEnv * env, jobject obj, jlong id_, jlong position_, jlong newValue_) {

    long id = (long) id_;
    long position = (long) position_;
    long newValue = (long) newValue_;

    id -= (getPercentage(id, position) << (position * 7));
    newValue = getPercentage(newValue, 0);
    newValue = newValue << (position * 7);
    id += newValue;
    return id;
}


/*
 * Class:     utils_BinaryOperations
 * Method:    aquote_part2
 * Signature: (JJJ)J
 */
JNIEXPORT jlong JNICALL Java_utils_BinaryOperations_aquote_1part2
  (JNIEnv * env, jobject obj, jlong id_, jlong percentage_, jlong inversionsOn_) {

    long id = id_;
    long percentage = percentage_;
    long inversionsOn = inversionsOn_;

    id = initialize(id, inversionsOn);

    long aux[9];
    long totalPercentage = 0;

    for(int i = 0; i < 9; i++) {
        aux[i] = getPercentage(id, i);
        totalPercentage += aux[i];
    }


    if(totalPercentage > percentage) {

        while(totalPercentage > percentage) {

            for(int i = 0; i < 9; i++) {
                if(aux[i] > 1 & totalPercentage > percentage & (aux[i] != 0)) {
                    aux[i] -= 1;
                    totalPercentage -= 1;
                }
            }
        }

    } else if (totalPercentage < percentage) {

        while(totalPercentage < percentage) {
            for(int i = 0; i < 9; i++) {
                if( aux[i] < percentage & totalPercentage < percentage & (aux[i] != 0)) {
                    aux[i] += 1;
                    totalPercentage += 1;
                }
            }
        }
    }
    //create the new number con la variable aux[]

    id = 0;
    for(int i = 0; i < 9; i++) {
        id += aux[i] << 7 * i;
    }
    return id;
}

/*
 * Class:     utils_BinaryOperations
 * Method:    getValoresActivos
 * Signature: (JJ)J
 */
JNIEXPORT jlong JNICALL Java_utils_BinaryOperations_getValoresActivos
  (JNIEnv * env, jobject obj, jlong valoresActivos_, jlong part_) {

    long part = part_;
    long valoresActivos = valoresActivos_;

    if (part == 0)
    {
        return valoresActivos & 0x01FF;
    } else {
        return (valoresActivos>>9) & 0x1FF;
    }
}

/*
 * Class:     utils_BinaryOperations
 * Method:    setId
 * Signature: (JJ)J
 */
JNIEXPORT jlong JNICALL Java_utils_BinaryOperations_setId
  (JNIEnv * env, jobject obj, jlong id_part1_, jlong id_part2_, jlong inversionsOn_) {

    long id_part1 = (long) id_part1_;
    long id_part2 = (long) id_part2_;
    long inversionsOn = inversionsOn_;

    id_part1 = initialize(id_part1, inversionsOn);
    id_part2 = initialize(id_part2, getValoresActivos(inversionsOn, 1));

    id_part1 = aquote(id_part1, id_part2);


    return id_part1;
}


/*
 * Class:     utils_BinaryOperations
 * Method:    mutation
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_utils_BinaryOperations_mutation
  (JNIEnv * env, jobject obj, jlong id_) {

  	long id = (long) id_;

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
}
