/*
 * To change this template file, choose Settings | Editor | File and Code Templates
 * and change the template in the editor.
 */

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 * @author Ahmed Abuwarda, 20/11/2019.
 */
public class MD5_Hash {

    /**
     * @param args the command line arguments.
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here.

        try {
            System.out.println("Loading...");
            Scanner scanner = new Scanner(new File("data.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("out.txt",true));
            while (scanner.hasNext()) {
                writer.write("\n" + getMd5(scanner.nextLine()));
            }
            writer.close();
            System.out.println("Done.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * @param input any input.
     * @return return.
     */
    private static String getMd5(String input) {
        try {

            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            // of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        // Specifying wrong message.
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}