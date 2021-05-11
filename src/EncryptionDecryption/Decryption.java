package EncryptionDecryption;

import java.util.Arrays;
import java.util.HashMap;

public class Decryption {
    private String contents;
    private HashMap<Character, Character> equivalencies;


    /**
     * Decryption constructor.
     * @param contents to be decrypted.
     */
    public Decryption(String contents){
        this.contents = contents;
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

    /**
     * Iterate through encrypted contents and convert the characters to their original equivalents.
     * @return String of decrypted contents
     */
    public String decrypt(){
        StringBuilder decryptedContents = new StringBuilder();
        String cleanContents = contents.replaceAll("XaX", "");
        for(int i = 0; i < cleanContents.length(); i++){
            // get the equivalent character of the character at the current index and append it to the return string.
            decryptedContents.append(equivalencies.get(cleanContents.charAt(i)));
        }
        return decryptedContents.toString();
    }

    public static void main(String[] args) {
        Decryption decryption = new Decryption("4-$XaX$!AXaXu!zXaX$_oXaX");
        System.out.println(decryption.decrypt());
    }
}
