import java.util.Scanner;
import java.util.Random;

class Main {
    Random random = new Random();

    int includeInt() {
        int p = random.nextInt(10);
        return p;
    }

    char includeChar() {
        int n = random.nextInt(2);
        if (n == 0) {
            return (char) (random.nextInt(10) + 65);
        }
        return (char) (random.nextInt(10) + 97);
    }

    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);

        Random random = new Random();
        Main ob = new Main();
        String password = "";

        System.out.println();
        System.out.print("Enter the length of the password:(Suggested 10): ");
        int n = sc.nextInt();

        System.out.print("Do you want to include a starting String (y/n)");
        char choice = sc.next().charAt(0);
        if (choice == 'y' || choice == 'Y') {
            System.out.print("Enter the string: ");
            String string = sc.next();
            password = string;
            for (int i = 0; i < n - (string.length()); i++) {
                String s = Integer.toString(ob.includeInt());
                password += s;
            }
        } else {
            System.out.println("Generating a Random Password........");
            Thread.sleep(1000);
            password += ob.includeChar();
            for (int i = 0; i < n - 1; i++) {
                int m = random.nextInt(3);
                if (m == 0) {
                    password += ob.includeInt();
                } else {
                    password += ob.includeChar();
                }
            }
        }
        System.out.println("----------------------------------");
        System.out.println("Generated password---> " + password);
        System.out.println("----------------------------------");
    }
}
