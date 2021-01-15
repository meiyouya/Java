package com.lawliet.secure;

import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class RSACrypt {

    /**
     * 生成密钥对
     * @param keyLength
     * @return
     */
    public static KeyPair genKeyPair(int keyLength) throws Exception {
        KeyPairGenerator rsaGenerator = KeyPairGenerator.getInstance("RSA");
        rsaGenerator.initialize(1024);
        return rsaGenerator.generateKeyPair();
    }

    /**
     * 使用公钥加密
     * @param content
     * @param publicKey
     * @return
     * @throws Exception
     */
    public static byte[] encrypt(byte[] content, PublicKey publicKey) throws Exception{
        Cipher rsaCipher = Cipher.getInstance("RSA");
        rsaCipher.init(Cipher.ENCRYPT_MODE,publicKey);
        return rsaCipher.doFinal(content);
    }

    /**
     * 使用私钥解密
     * @param content
     * @param privateKey
     * @return
     * @throws Exception
     */
    public static byte[] decrypt(byte[] content, PrivateKey privateKey) throws Exception {
        Cipher rsaCipher = Cipher.getInstance("RSA");
        rsaCipher.init(Cipher.DECRYPT_MODE,privateKey);
        return rsaCipher.doFinal(content);
    }

    public static void main(String[] args) throws Exception {
        String data = "hello";
        KeyPair keyPair = RSACrypt.genKeyPair(1024);

        PublicKey publicKey = keyPair.getPublic();
        System.out.println("公钥的base64结果：" + new String(Base64.getEncoder().encode(publicKey.getEncoded())));

        PrivateKey privateKey = keyPair.getPrivate();
        System.out.println("私钥的base64结果：" + new String(Base64.getEncoder().encode(privateKey.getEncoded())));

        byte[] encryptResult = RSACrypt.encrypt(data.getBytes(), publicKey);
        System.out.println("使用公钥加密后的数据：" + new String(encryptResult));

        byte[] decrypt = RSACrypt.decrypt(encryptResult, privateKey);
        System.out.println("使用私钥解密之后的数据：" + new String(decrypt));
    }
}
