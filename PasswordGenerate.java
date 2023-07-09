import java.util.Scanner;
import java.util.Random;

class PasswordGenerate {
    Random random = new Random();
    Scanner sc = new Scanner(System.in);

    int includeInt() {
        int p = random.nextInt(10);
        return p;
    }

    void display(String str, String pass, int key){
        if(key==1){
            System.out.println(str+pass);
        }
        else if(key==2){
            System.out.println(pass+str);
        }
    }

    char includeChar() {
        int n = random.nextInt(2);
        if (n == 0) {
            return (char) (random.nextInt(10) + 65);
        }
        return (char) (random.nextInt(10) + 97);
    }


    void charOfChoice(String str, int nPass,int key) {
        // m is the length of the string to be include.
        int m = str.length();
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
            System.out.println("\npassword Generated: ");
            System.out.println("--------------------------------");
            for (int i = 0; i < nPass; i++) {
                for (int j = 0; j < num - m; j++) {
                    pass += fromArray(characters, n);
                }
                display(str, pass, key);
                pass = "";
            }
            System.out.println("--------------------------------\n\n");
        } else {
            System.out.println("password Generated: ");
            System.out.println("--------------------------------");
            for(int i=0; i<nPass; i++){
                display(str,generatePassword(num, m),key);
            }
            System.out.println("--------------------------------\n\n");
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
        Scanner sc = new Scanner(System.in);
        PasswordGenerate ob = new PasswordGenerate();

        System.out.println("\n_______We are about to geberate a strong password_______\n");

        System.out.print("Number of passwords to be generated: ");
        int n = sc.nextInt();

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
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    ob.charOfChoice(string, n, 1);
                    break;

                case 2:
                    ob.charOfChoice(string,n,2);
                    break;

                case 3:
                    System.out.print("Enter the length of password: ");
                    int num = sc.nextInt();
                    System.out.println("\nPasswords Generated: ");
                    System.out.println("--------------------------------");
                    for(int i=0; i<n; i++){
                        password += ob.generatePassword(num, 0);
                        System.out.println(password);
                        password="";
                    }
                    System.out.println("--------------------------------\n");
                    break;

                default:
                    System.out.println("Invalid Input !!! PROGRAM TERMINATED!!!!\n\n");
                    sc.close();
                    return;
            }
        } else {
            System.out.print("Enter the length of the password: ");
            int num = sc.nextInt();
            System.out.println("\nGenerating Random Password...");
            Thread.sleep(1000);
            System.out.println("\nPasswords Generated: ");
            System.out.println("--------------------------------");
            for(int i=0; i<n; i++){
                password += ob.includeChar();
                password += ob.generatePassword(num - 1, 0);
                System.out.println(password);
                password="";
            }
            System.out.println("--------------------------------\n\n");
        }
        sc.close();
    }
}
