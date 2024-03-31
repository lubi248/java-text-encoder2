import java.util.Scanner;

public class encoderer {

    public static void main(String[] args) { //user input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 0 to encode or 1 to decode: ");
        int a = sc.nextInt();
        sc.nextLine(); 

        if (a == 1) { // string reverser
            String str;
            StringBuilder reversedText = new StringBuilder();
            System.out.print("Enter the encrypted text : ");
            str = sc.nextLine(); 
            String[] words = str.split(" ");
            for (int i = words.length - 1; i >= 0; i--) {
                reversedText.append(words[i]);
                reversedText.append(" ");
            }
            String encryptedText = encrypt(reversedText.toString().trim(), 3);
            System.out.println("Encrypted Text: " + encryptedText);
        } else if (a == 0) {
            System.out.print("Enter the unencrypted text: ");
            String encryptedText = sc.nextLine();
            String decryptedText = decrypt(encryptedText, 3);
            System.out.println("Decrypted Text: " + decryptedText);
        } else {
            System.out.println("Invalid option selected. Please enter either 0 or 1.");
        }

        sc.close(); 
    }

    public static String encrypt(String text, int shift) { //this is the caesar cipher
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isLetter(ch)) {
                char shiftedChar = (char) (ch + shift);

                if (Character.isUpperCase(ch)) {
                    if (shiftedChar > 'Z') {
                        shiftedChar = (char) ('A' + (shiftedChar - 'Z' - 1));
                    }
                } else {
                    if (shiftedChar > 'z') {
                        shiftedChar = (char) ('a' + (shiftedChar - 'z' - 1));
                    }
                }

                result.append(shiftedChar);
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static String decrypt(String text, int shift) { //this is the decryption logic
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isLetter(ch)) {
                char shiftedChar = (char) (ch - shift);

                if (Character.isUpperCase(ch)) {
                    if (shiftedChar < 'A') {
                        shiftedChar = (char) ('Z' - ('A' - shiftedChar - 1));
                    }
                } else {
                    if (shiftedChar < 'a') {
                        shiftedChar = (char) ('z' - ('a' - shiftedChar - 1));
                    }
                }

                result.append(shiftedChar);
            } else {
                result.append(ch);
            }
        }

        String[] words = result.toString().split(" "); 
    StringBuilder reversedText = new StringBuilder();
    for (int i = words.length - 1; i >= 0; i--) {
        reversedText.append(words[i]);
        reversedText.append(" ");
    }

    return reversedText.toString().trim();

    }
}

// this can now encode and decode a further patch will increase legibility and overall optimise the code and after that i plan to create a simple GUI with react