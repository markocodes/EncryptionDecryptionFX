package EncryptionDecryption;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class Encryption {
    private String contents;
    private int key;
    private HashMap<Character, Character> equivalencies;


    /**
     * Encryption constructor.
     * @param contents to be in encrypted.
     */
    public Encryption(String contents){
        this.contents = contents;

        Random rand = new Random();

        key = rand.nextInt(5);
        key += 1;

        equivalencies = new HashMap<>();

        Character[] keyboardCharacters = new Character[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
                'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '`', '~',
                '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '=', '+', '|', '\\',
                ']', '}', '[', '{', '\'', '"', ';', ':', '/', '?', '.', '>', ',', '<', '1', '2',
                '3', '4', '5', '6', '7', '8', '9', ' ', '\n'};

        // Set equivalencies as symmetrically opposite character in keyboardCharacters array.
        for(Character c: keyboardCharacters){
            equivalencies.put(c, keyboardCharacters[keyboardCharacters.length - Arrays.asList(keyboardCharacters).indexOf(c) - 1]);
        }
    }

    public String encrypt(){
        StringBuilder encryptedContents = new StringBuilder();
        int keyCount = 1;
        for(int i = 0; i < contents.length(); i++){
            keyCount++;
            // get the equivalent character of the character at the current index and append it to the return string.
            encryptedContents.append(equivalencies.get(contents.charAt(i)));

            if(keyCount == key){
                encryptedContents.append('X');
                encryptedContents.append('a');
                encryptedContents.append('X');
                keyCount = 1;
            }

        }
        return encryptedContents.toString();
    }

    /**
     * Setter for testing purposes.
     */
    public void setContents(String contents) {
        this.contents = contents;
    }

    /**
     * Getter for testing purposes.
     */
    public HashMap<Character, Character> getEquivalencies() {
        return equivalencies;
    }

    public static void main(String[] args) {
        // Test that equivalencies are initialized as intended.
        (new Encryption(null)).getEquivalencies().forEach((key, value) -> System.out.println(key + " " + value));
        Encryption test = new Encryption("Hello\nworld!");
        System.out.println(test.encrypt());
    }

}
