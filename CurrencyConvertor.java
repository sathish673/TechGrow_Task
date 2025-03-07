package Currency;
import java.util.*;

public class CurrencyConvertor 
{
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double usdToInr = 83.00;   // USD to Indian Rupees
        double usdToEur = 0.92;    // USD to Euro
        double usdToGbp = 0.79;    // USD to British Pound
        double usdToJpy = 150.00;  // USD to Japanese Yen

        System.out.println("Welcome to Currency Converter!");
        System.out.println("1. USD to INR (Indian Rupees)");
        System.out.println("2. USD to EUR (Euro)");
        System.out.println("3. USD to GBP (British Pound)");
        System.out.println("4. USD to JPY (Japanese Yen)");
        System.out.print("Choose an option (1-4): ");

        int choice = scanner.nextInt();
        System.out.print("Enter amount in USD: ");
        double amount = scanner.nextDouble();
        double convertedAmount = 0;

        switch (choice) {
            case 1:
                convertedAmount = amount * usdToInr;
                System.out.println(amount + " USD = " + convertedAmount + " INR");
                break;
            case 2:
                convertedAmount = amount * usdToEur;
                System.out.println(amount + " USD = " + convertedAmount + " EUR");
                break;
            case 3:
                convertedAmount = amount * usdToGbp;
                System.out.println(amount + " USD = " + convertedAmount + " GBP");
                break;
            case 4:
                convertedAmount = amount * usdToJpy;
                System.out.println(amount + " USD = " + convertedAmount + " JPY");
                break;
            default:
                System.out.println("Invalid choice! Please restart and select a valid option.");
                break;
        }

        scanner.close();
    }
}
