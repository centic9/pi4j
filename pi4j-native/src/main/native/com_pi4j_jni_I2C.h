/*
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: JNI Native Library
 * FILENAME      :  com_pi4j_jni_I2C.h
 * 
 * This file is part of the Pi4J project. More information about
 * this project can be found here:  http://www.pi4j.com/
 * **********************************************************************
 * %%
 * Copyright (C) 2012 - 2016 Pi4J
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */
/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_pi4j_jni_I2C */

#ifndef _Included_com_pi4j_jni_I2C
#define _Included_com_pi4j_jni_I2C
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_pi4j_jni_I2C
 * Method:    i2cOpen
 * Signature: (Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_com_pi4j_jni_I2C_i2cOpen
  (JNIEnv *, jclass, jstring);

/*
 * Class:     com_pi4j_jni_I2C
 * Method:    i2cClose
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_com_pi4j_jni_I2C_i2cClose
  (JNIEnv *, jclass, jint);

/*
 * Class:     com_pi4j_jni_I2C
 * Method:    i2cWriteByteDirect
 * Signature: (IIB)I
 */
JNIEXPORT jint JNICALL Java_com_pi4j_jni_I2C_i2cWriteByteDirect
  (JNIEnv *, jclass, jint, jint, jbyte);

/*
 * Class:     com_pi4j_jni_I2C
 * Method:    i2cWriteBytesDirect
 * Signature: (IIII[B)I
 */
JNIEXPORT jint JNICALL Java_com_pi4j_jni_I2C_i2cWriteBytesDirect
  (JNIEnv *, jclass, jint, jint, jint, jint, jbyteArray);

/*
 * Class:     com_pi4j_jni_I2C
 * Method:    i2cWriteByte
 * Signature: (IIIB)I
 */
JNIEXPORT jint JNICALL Java_com_pi4j_jni_I2C_i2cWriteByte
  (JNIEnv *, jclass, jint, jint, jint, jbyte);

/*
 * Class:     com_pi4j_jni_I2C
 * Method:    i2cWriteBytes
 * Signature: (IIIII[B)I
 */
JNIEXPORT jint JNICALL Java_com_pi4j_jni_I2C_i2cWriteBytes
  (JNIEnv *, jclass, jint, jint, jint, jint, jint, jbyteArray);

/*
 * Class:     com_pi4j_jni_I2C
 * Method:    i2cReadByteDirect
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_com_pi4j_jni_I2C_i2cReadByteDirect
  (JNIEnv *, jclass, jint, jint);

/*
 * Class:     com_pi4j_jni_I2C
 * Method:    i2cReadBytesDirect
 * Signature: (IIII[B)I
 */
JNIEXPORT jint JNICALL Java_com_pi4j_jni_I2C_i2cReadBytesDirect
  (JNIEnv *, jclass, jint, jint, jint, jint, jbyteArray);

/*
 * Class:     com_pi4j_jni_I2C
 * Method:    i2cReadByte
 * Signature: (III)I
 */
JNIEXPORT jint JNICALL Java_com_pi4j_jni_I2C_i2cReadByte
  (JNIEnv *, jclass, jint, jint, jint);

/*
 * Class:     com_pi4j_jni_I2C
 * Method:    i2cReadBytes
 * Signature: (IIIII[B)I
 */
JNIEXPORT jint JNICALL Java_com_pi4j_jni_I2C_i2cReadBytes
  (JNIEnv *, jclass, jint, jint, jint, jint, jint, jbyteArray);

/*
 * Class:     com_pi4j_jni_I2C
 * Method:    i2cWriteAndReadBytes
 * Signature: (IIII[BII[B)I
 */
JNIEXPORT jint JNICALL Java_com_pi4j_jni_I2C_i2cWriteAndReadBytes
  (JNIEnv *, jclass, jint, jint, jint, jint, jbyteArray, jint, jint, jbyteArray);

#ifdef __cplusplus
}
#endif
#endif
