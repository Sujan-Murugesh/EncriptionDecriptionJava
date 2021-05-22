/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encriptiondecriptionjava;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.Signature;
import javax.crypto.Cipher;

/**
 *
 * @author Sujan
 */
public class EncriptionDecriptionJava {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
   public static void main(String args[]) throws Exception{
	   //Creating a Signature object
      Signature sign = Signature.getInstance("SHA256withRSA");
      
      //Creating KeyPair generator object
      KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
      
      //Initializing the key pair generator
      keyPairGen.initialize(2048);
      
      //Generate the pair of keys
      KeyPair pair = keyPairGen.generateKeyPair();   
      
      //Getting the public key from the key pair
      PublicKey publicKey = pair.getPublic();  

      //Creating a Cipher object
      Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

      //Initializing a Cipher object
      cipher.init(Cipher.ENCRYPT_MODE, publicKey);
	  
      //Add data to the cipher
      byte[] input = "Hello Friends I'm Sujan".getBytes();	  
      cipher.update(input);
	  
      //encrypting the data
      byte[] cipherText = cipher.doFinal();	 
      System.out.println("Encrypted Text:");
      System.out.println( new String(cipherText, "UTF8"));
       System.out.println("\n");
      //Initializing the same cipher for decryption
      cipher.init(Cipher.DECRYPT_MODE, pair.getPrivate());
      
      //Decrypting the text
      byte[] decipheredText = cipher.doFinal(cipherText);
      System.out.println("Decrypted Text:");
      System.out.println(new String(decipheredText));
   }
    
}
