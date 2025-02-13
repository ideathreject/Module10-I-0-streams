import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ValidNumber {
    public void readFile() {

        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\obuc\\Module10\\src\\main\\resources\\fileNumber.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {  //
                if (isValidPhoneNumber(line)) {
                    System.out.println(line);
                }

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() == 14 && phoneNumber.charAt(0) == '(' && phoneNumber.charAt(4) == ')' && phoneNumber.charAt(5) == ' ' && phoneNumber.charAt(9) == '-') {

            for (int i = 1; i <= 3; i++) {
                if (!Character.isDigit(phoneNumber.charAt(i))) return false;
            }
            for (int i = 6; i <= 8; i++) {
                if (!Character.isDigit(phoneNumber.charAt(i))) return false;
            }
            for (int i = 10; i <= 13; i++) {
                if (!Character.isDigit(phoneNumber.charAt(i))) return false;
            }

            return true;
        }


        if (phoneNumber.length() == 12 && phoneNumber.charAt(3) == '-' && phoneNumber.charAt(7) == '-') {


            for (int i = 0; i <= 2; i++) {
                if (!Character.isDigit(phoneNumber.charAt(i))) return false;
            }
            for (int i = 4; i <= 5; i++) {
                if (!Character.isDigit(phoneNumber.charAt(i))) return false;
            }
            for (int i = 8; i <= 11; i++) {
                if (!Character.isDigit(phoneNumber.charAt(i))) return false;
            }
            return true;
        }

        return false;
    }
}
