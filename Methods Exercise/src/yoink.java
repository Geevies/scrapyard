
import javax.swing.JOptionPane;

public class yoink {

    public static void main(String[] args) {
        
        String userMessage = JOptionPane.showInputDialog("Insert your message.");
        String optionSelect = JOptionPane.showInputDialog(
                "1. Count and display the number of vowels in the message.\n"
                + "2. Count and display the number of words in the message.\n"
                + "3. Print a Word in reverse order.\n"
                + "4. Exit.");

        if (null != optionSelect) {
            switch (optionSelect) {
                case "1":
                    System.out.println("There are " + countDisplayVowels(userMessage) + " vowels in your message.");
                    break;
                case "2":
                    System.out.println("There are " + countDisplayWords(userMessage) + "words in your message");
                    break;
                case "3":
                    System.out.println("Your message backwards is: " + printReverseWord(userMessage));
                    break;
                case "4":
                    break;
                default:
                    break;
            }
        }

    }

    private static Integer countDisplayVowels(String message) {
        int vowels = 0;

        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == 'a' || message.charAt(i) == 'i' || message.charAt(i) == 'o' || message.charAt(i) == 'u' || message.charAt(i) == 'e'
             || message.charAt(i) == 'A' || message.charAt(i) == 'I' || message.charAt(i) == 'O' || message.charAt(i) == 'U' || message.charAt(i) == 'E') {
                vowels++;
            }
        }

        return vowels;
    }

    private static Integer countDisplayWords(String message) {
        String[] stringArr = message.split(" ");
        return stringArr.length;
    }

    private static String printReverseWord(String message) {
        String reversed = "";

        for (int i = (message.length() - 1); i > (message.length() - 1) - message.length(); i--) {
            reversed += message.charAt(i);
        }
        return reversed;
    }
}
