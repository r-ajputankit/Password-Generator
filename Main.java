import java.util.Scanner;
import java.util.Random;

class Main {
    Random random = new Random();
    Scanner sc = new Scanner(System.in);

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

    String charOfChoice(int m) {
        // m is the length of the string to be include.
        String pass = "";
        System.out.print("\nEnter the length of password: ");
        int num = sc.nextInt();

        System.out.print("do you want to give character choice(y/n): ");
        char ch = sc.next().charAt(0);
        if (ch == 'y' || ch == 'Y') {
            System.out.print("No of characters: ");
            int n = sc.nextInt();
            System.out.print("Enter the Array of characters: ");
            char[] characters = new char[n];
            // The array store the characters to be include in the password. Input by user.

            for (int i = 0; i < n; i++) {
                characters[i] = sc.next().charAt(0);
            }
            for (int i = 0; i < num - m; i++) {
                pass += fromArray(characters, n);
            }
            return pass;
        } else {
            return generatePassword(num, m);
            // num--> length of password
            // m ---> length of the string
        }
    }

    char fromArray(char[] arr, int n) {
        int i = random.nextInt(n);
        return arr[i];
    }

    String generatePassword(int n, int m) {
        String pass = "";
        for (int i = 0; i < n - m; i++) {
            int a = random.nextInt(3);
            if (a == 0) {
                pass += includeInt();
            } else if (a == 1) {
                pass += includeChar();
            } else {
                char[] arr = { '!', '@', '#', '$', '%', '^', '&', '*', '<', '(', ')', '+', '-', '_', '|', '/' };
                pass += fromArray(arr, arr.length);
            }
        }
        return pass;
    }

    public static void main(String[] args) throws InterruptedException {

        System.out.println("\n_______We are about to geberate a strong password_______\n");
        Scanner sc = new Scanner(System.in);

        Main ob = new Main();
        String password = "";

        System.out.println("--------------------------------------------------------");
        System.out.println("Including a string can be a Hint to recover password!!");
        System.out.println("--------------------------------------------------------");

        System.out.print("Do you want to include a String? (y/n): ");
        char choice = sc.next().charAt(0);
        System.out.println("-------------------------------------------");

        if (choice == 'y' || choice == 'Y') {
            System.out.print("\nEnter the string: ");
            String string = sc.next();
            int m = string.length();

            System.out.println("\n--------------------------");
            System.out.println("Include String --> ");
            System.out.println("--------------------------");
            System.out.println("1. Begin with String\n2. End with String\n3. Do not include");
            System.out.println("----------------------------------------------");

            System.out.print("Choice: ");
            int choic = sc.nextInt();

            switch (choic) {
                case 1:
                    password = string + ob.charOfChoice(m);
                    break;

                case 2:
                    password = ob.charOfChoice(m) + string;
                    break;

                case 3:
                    System.out.print("Enter the length of password: ");
                    int num = sc.nextInt();
                    password += ob.generatePassword(num, 0);
                    break;

                default:
                    System.out.println("Invalid Input !!! PROGRAM TERMINATED!!!!\n\n");
                    sc.close();
                    return;
            }
        } else {
            System.out.print("Enter the length of the password: ");
            int num = sc.nextInt();
            System.out.println("\nGenerating a Random Password........");
            Thread.sleep(1000);
            password += ob.includeChar();
            password += ob.generatePassword(num-1, 0);
        }
        sc.close();

        System.out.println("----------------------------------");
        System.out.println("password Gerenated---> " + password);
        System.out.println("----------------------------------");
    }
}
