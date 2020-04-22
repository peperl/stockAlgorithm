#include <jni.h>
#include <stdio.h>      // C Standard IO Header
#include <stdlib.h>
#include "utils_BinaryOperations.h"   // Generated

//terminal
// gcc -fPIC -shared -I/usr/local/jdk1.8.0_111/include -I/usr/local/jdk1.8.0_111/include/linux utils_BinaryOperations.c

long getPercentage(long id, long position) {
    return 0x7F & (id >> 7 * position);
}

void showId(long id) {
	for (int i = 0; i < 7; i++)
	{
		printf(" %lu ", getPercentage(id,i));
	}
	printf("\n");
}

long setPercentage(long id, long position, long newValue) {

    id -= (getPercentage(id, position) << (position * 7));
    newValue = getPercentage(newValue, 0);
    newValue = newValue << (position * 7);
    id += newValue;
    return id;
}

long initialize(long id, long inversionsOn) {

    long aux, aux2;

    for(int i = 1; i <= 7; i++) {

        aux = inversionsOn & (1 << (i - 1));

        if(aux == 0) {
            aux2 = getPercentage(id, i - 1 );
            id -= (aux2 << (7 * (i - 1)));
        }
    }
    return id;
}

long aquote(long id) {

    long aux[7];
    long totalPercentage = 0;

    for(int i = 0; i < 7; i++) {
        aux[i] = getPercentage(id, i);
        totalPercentage += aux[i];
    }

    if(totalPercentage > 100) {

        while(totalPercentage > 100) {

            for(int i = 0; i < 7; i++) {
                if(aux[i] > 1 & totalPercentage > 100 & (aux[i] != 0)) {
                    aux[i] -= 1;
                    totalPercentage -= 1;
                }
            }
        }

    } else if (totalPercentage < 100) {

        while(totalPercentage < 100) {
            for(int i = 0; i < 7; i++) {
                if( aux[i] < 100 & totalPercentage < 100 & (aux[i] != 0)) {
                    aux[i] += 1;
                    totalPercentage += 1;
                }
            }
        }
    }
    //create the new number con la variable aux[]
    id = 0;
    for(int i = 0; i < 7; i++) {
        id += aux[i] << 7 * i;
    }
    return id;
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
 * Method:    initialize
 * Signature: (JJ)J
 */
JNIEXPORT jlong JNICALL Java_utils_BinaryOperations_initialize
  (JNIEnv * env, jobject obj, jlong id_, jlong inversionsOn_) {

  	long id = (long) id_;
  	long inversionsOn = (long) inversionsOn_;
    long aux, aux2;

    for(int i = 1; i <= 7; i++) {

        aux = inversionsOn << (8*8 - i);
        aux = aux >> (8*8 - 1);

        if(aux == 0) {
            aux2 = getPercentage(id,i-1);
            id -= (aux2 << (7 * (i - 1)));
        }
    }
    return id;
}

/*
 * Class:     utils_BinaryOperations
 * Method:    aquote
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_utils_BinaryOperations_aquote
  (JNIEnv * env, jobject obj, jlong id_) {

    long id = (long) id_;
    long aux[7];
    long totalPercentage = 0;

    for(int i = 0; i < 7; i++) {
        aux[i] = getPercentage(id, i);
        totalPercentage+=aux[i];
    }

    if(totalPercentage > 100) {

        while(totalPercentage > 100) {
            for(int i = 0; i < 7; i++) {
                if(aux[i] > 1 & totalPercentage > 100 & (aux[i] != 0 ) ) {
                    aux[i]-=1;
                    totalPercentage-=1;
                }
            }
        }

    } else if (totalPercentage < 100) {

        while(totalPercentage < 100) {
            for(int i = 0; i < 7; i++) {
                if(aux[i] < 100 & totalPercentage < 100 & (aux[i] != 0 )) {
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

/*
 * Class:     utils_BinaryOperations
 * Method:    setId
 * Signature: (JJ)J
 */
JNIEXPORT jlong JNICALL Java_utils_BinaryOperations_setId
  (JNIEnv * env, jobject obj, jlong id_, jlong inversionsOn_) {

    long id = (long) id_;
    long inversionsOn = inversionsOn_;
    id = initialize(id, inversionsOn);
    id = aquote(id);
    //showId(id);
    return id;
}

/*
 * Class:     utils_BinaryOperations
 * Method:    cross
 * Signature: (JJ)J
 */
JNIEXPORT jlong JNICALL Java_utils_BinaryOperations_cross
  (JNIEnv * env, jobject obj, jlong id1_, jlong id2_) {

	long id1 = (long) id1_;
	long id2 = (long) id2_;
    long aux, aux2;

    aux = id1 << 15;
    aux = id1 >> 15 + (7 * (7 - 3) );
    aux = id1 << 7 * (7 - 3);

    aux2 = id2 << 15 + (7 * (7 - 4 ) );
    aux2 = id2 >> 15 + (7 * (7 - 4 ) );

    return aux + aux2;
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
