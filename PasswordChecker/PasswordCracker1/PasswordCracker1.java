package PasswordCracker1;
//import javax.management.RuntimeErrorException;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;
//import java.io.IOException;
import java.security.MessageDigest;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
 

class HashUtils {   //text to SHA - 256 converter

    public static  String sha256Hash(String input) {
        String hex = null;
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            //change this to UTF - 16 if needed
            md.update(input.getBytes(StandardCharsets.UTF_8));
            byte[] digest = md.digest();

            hex = String.format("%064x", new BigInteger(1, digest));

        }catch(NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return hex;
    }
} 

 class input {
    String inhash;

    public String gethash(String s) {
    
     
        HashUtils converter = new HashUtils();
        inhash = converter.sha256Hash(s);  
        return inhash;
      
    }
}

 public class PasswordCracker1 extends input {
    public int runner(String str) {
        int flag = 0;
        String hash;
        input obj=new input();
        hash = obj.gethash(str);
        Scanner s = null;
        try {
            s = new Scanner(new File("F:\\nmims\\sem 3\\java\\PasswordChecker\\rockyou_short.txt"));
                while(s.hasNextLine()){
                    String word = s.nextLine();
                    String h = HashUtils.sha256Hash(word);

                    if(hash.equals(h)) {
                        flag =1;
                    }
                }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return flag;
    }
}
