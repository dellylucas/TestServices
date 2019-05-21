package com.example.testservicesdev.data.RSAEncryption

import android.content.Context

import javax.crypto.Cipher
import java.io.InputStream
import java.io.ObjectInputStream
import java.security.PrivateKey
import java.security.PublicKey

/**
 * Created by Usuario on 11/02/2015.
 */
class EncryptionUtil {

     lateinit var publicKey: PublicKey
    lateinit var privateLicenseKey: PrivateKey

    constructor(c: Context) {
        try {
            // 1. Copiar archivo a almacenamiento interno
            val am = c.assets
            // 2. Buscar cuál llave de encripción se va a usar
            /* Settings mySettings = new Settings(c);
            String webServiceUrl = mySettings.loadStringSetting(AppConstants.PREF_IPAT_QUIPUX_WS_ENDPOINT);
*/
            val pkIs: InputStream
            // Normalmente se hace esto, pero para los diferentes endpoints se utilizará diferentes
            // llaves, por ejemplo la llave de encripción usada por Quipux y la llave usada por cali
            //InputStream pkIs = am.open(PUBLIC_KEY_FILE);
            /*
            if (webServiceUrl.equals(AppConstants.PREF_IPAT_WEBSERVICE_URL_CALI)) {
                pkIs = am.open(PUBLIC_KEY_FILE_CALI);
            } else if (webServiceUrl.equals(AppConstants.PREF_IPAT_WEBSERVICE_URL_DEFAULT)) {
                pkIs = am.open(PUBLIC_KEY_FILE);
            } else {
                pkIs = am.open(PUBLIC_KEY_FILE);
            }*/
            pkIs = am.open(PUBLIC_KEY_FILE)

            val `is` = ObjectInputStream(pkIs)
            publicKey = `is`.readObject() as PublicKey
            val plkis = am.open(PRIVATE_LICENSE_KEY)
            val lis = ObjectInputStream(plkis)
            privateLicenseKey = lis.readObject() as PrivateKey
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }


    companion object {
        val ALGORITHM = "RSA/ECB/PKCS1Padding"
        val ALGORITHM_TRACES = "RSA"
        val PUBLIC_KEY_FILE = "pk"
        val PUBLIC_KEY_FILE_CALI = "pk_cali"
        val PRIVATE_LICENSE_KEY = "lpk"
        val TRACES_PUBLIC_KEY = "tpk"


        fun encrypt(text: String, key: PublicKey): ByteArray? {
            var cipherText: ByteArray? = null
            try {
                val cipher = Cipher.getInstance(ALGORITHM)
                cipher.init(Cipher.ENCRYPT_MODE, key)
                cipherText = cipher.doFinal(text.toByteArray())

            } catch (e: Exception) {
                e.printStackTrace()
            }

            return cipherText
        }

/*
        fun decryptForLicense(encryptedBytes: ByteArray, key: PrivateKey): ByteArray? {
            var decryptedBytes: ByteArray? = null
            try {
                val cipher = Cipher.getInstance(ALGORITHM)
                cipher.init(Cipher.DECRYPT_MODE, key)
                decryptedBytes = cipher.doFinal(encryptedBytes)
                //decryptedBytes = cipher.doFinal(stringToBytes(encryptedText));
                return decryptedBytes
            } catch (e: Exception) {
                e.printStackTrace()
            }

            return decryptedBytes
        }*/
    }

    /*
    private File copyFile(String filename, Context c) {
        AssetManager assetManager = c.getAssets();
        String packageName = c.getPackageName();
        InputStream in = null;
        OutputStream out = null;
        try {
            in = assetManager.open(filename);
            String newFileName = "/data/data/" + packageName + "/" + filename;
            out = new FileOutputStream(newFileName);

            byte[] buffer = new byte[1024];
            int read;
            while ((read = in.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            }
            in.close();
            in = null;
            out.flush();
            out.close();
            out = null;
            return  new File(newFileName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }*/
}
