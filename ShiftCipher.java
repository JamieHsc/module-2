package module25;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShiftCipher {
    private final int shift;

    public ShiftCipher(int shift) {
        if (shift < 1 || shift > 25) {
            throw new IllegalArgumentException("Shift must be between 1 and 25");
        }
        this.shift = shift;
    }

    public String encrypt(String message) {
        Map<Character, Character> charMap = createCharMap(shift);
        StringBuilder encryptedMessage = new StringBuilder();
        for (char c : message.toCharArray()) {
            encryptedMessage.append(charMap.getOrDefault(c, c));
        }
        return encryptedMessage.toString();
    }

    public String decrypt(String message) {
        Map<Character, Character> charMap = createCharMap(26 - shift);
        StringBuilder decryptedMessage = new StringBuilder();
        for (char c : message.toCharArray()) {
            decryptedMessage.append(charMap.getOrDefault(c, c));
        }
        return decryptedMessage.toString();
    }

    private Map<Character, Character> createCharMap(int shift) {
        Map<Character, Character> charMap = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            charMap.put(c, (char) ('a' + (c - 'a' + shift) % 26));
            charMap.put(Character.toUpperCase(c), Character.toUpperCase(charMap.get(c)));
        }
        for (char c = '0'; c <= '9'; c++) {
            charMap.put(c, (char) ('0' + (c - '0' + shift) % 10));
        }
        return charMap;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter shift (1-25): ");
        int shift = scanner.nextInt();
        scanner.nextLine();
        ShiftCipher cipher = new ShiftCipher(shift);
        System.out.print("Enter message: ");
        String message = scanner.nextLine();
        String encryptedMessage = cipher.encrypt(message);
        String decryptedMessage = cipher.decrypt(encryptedMessage);
        System.out.println("Encrypted message: " + encryptedMessage);
        System.out.println("Decrypted message: " + decryptedMessage);
    }
}