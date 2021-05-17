package EncryptionDecryption;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Controller {

    /**
     * Parse input file and return as properly formatted string.
     * @return Contents of input file as a String
     */
    public String parseFile(Path path) throws IOException {
        return Files.readString(path);
    }


    /**
     * Send file for encryption or decryption.
     * @param operation encryption or decryption
     */
    public String executeOperation(String operation, String contents){
        // E: Encrypt
        String contentsToReturn = null;
        if(operation.equals("E")){
            try {
                FileWriter myWriter = new FileWriter("src/encrypted_data.txt");
                Encryption encryption = new Encryption(contents);
                String encryptedContents = encryption.encrypt();
                myWriter.write(encryptedContents);
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
                contentsToReturn = encryptedContents;
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
        // D: Decrypt
        else if(operation.equals("D")){
            try {
                FileWriter myWriter = new FileWriter("src/decrypted_data.txt");
                String decryptedContents = new Decryption(contents).decrypt();
                myWriter.write(decryptedContents);
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
                contentsToReturn = decryptedContents;
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
        return contentsToReturn;
    }


    public static void main(String[] args) throws IOException {
//        System.out.println(parseFile(Paths.get("src/test.txt")));
        Controller c = new Controller();
        //c.executeOperation("E", c.parseFile(Paths.get("src/test.txt")));
        c.executeOperation("D", c.parseFile(Paths.get("src/encrypted_data.txt")));
    }
}
