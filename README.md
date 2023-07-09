# Password-Generator
Here the new feature added where the password includes the characters from the array of character given by the user.

#### Included part:

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
            for (int i = 0; i < num-m; i++) {
                pass += fromArray(characters, n);
            }
            return pass;
        } 
