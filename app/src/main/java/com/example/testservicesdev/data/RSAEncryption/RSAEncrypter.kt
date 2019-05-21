package com.example.testservicesdev.data.RSAEncryption

import android.content.Context
import android.util.Base64
import android.util.Base64.DEFAULT
import com.example.testservicesdev.data.RSAEncryption.EncryptionUtil.Companion.encrypt

class RSAEncrypter {

    fun getEncryptedString(c: Context, s: String): String? {
        try {
            val encrypter = EncryptionUtil(c)
            val encryptionResult = encrypt(s, encrypter.publicKey)

            val base64Data = Base64.encode(encryptionResult,DEFAULT)
//            encodeBytesToBytes(encryptionResult)
            return String(base64Data, charset("UTF-8"))
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }

    }
/*

    fun getEncryptedStringForTracesSimit(c: Context, s: String): String? {
        try {
            val encrypter = EncryptionUtil(c, true)
            val encryptionResult = encrypt(s, encrypter.publicKey)
            /* Esquema de encripción para prueba de Qx
            char[] stringEcriptado = Hex.encodeHex(encryptionResult);  // Servicio Prueba QX (Ya no)
            //return new String(stringEcriptado);
            */
            // Encripción Cali el servicio Qx también lo pusieron así
            val base64Data = Base64.encodeBytesToBytes(encryptionResult)
            return String(base64Data, "UTF-8")
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }

    }


    /**
     * Ingresa una cadena codificada encriptada y codificada en base 64 y devuelve el valor de la cadena
     * sin encriptar
     *
     * @param c
     * @param s
     * @return
     */
    fun getDecryptedLicenseString(c: Context, s: String): String? {
        try {
            val encrypter = EncryptionUtil(c)
            val decriptedBytes = decryptForLicense(Base64.decode(s), encrypter.privateLicenseKey)
            return String(decriptedBytes, "UTF-8")
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }

    }*/
}
