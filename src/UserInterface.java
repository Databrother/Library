import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {

    public static void displayOptions() {
        GenericCatalog<LibraryItem> gn = new GenericCatalog<>();
        Scanner scanner = new Scanner(System.in);
        int userChoice = 0;

        while (userChoice != 4) {
            System.out.println("Welcome to the Library Management System");
            System.out.println("Press 1 to add an item");
            System.out.println("Press 2 to remove an item");
            System.out.println("Press 3 to display details of an item");
            System.out.println("Press 4 to exit");

            try {
                userChoice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Enter a valid number");
                scanner.nextLine();
                continue;
            }

            switch (userChoice) {
                case 1:
                    addItem(gn, scanner);
                    break;
                case 2:
                    removeItem(gn, scanner);
                    break;
                case 3:
                    displayItemInfo(gn, scanner);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addItem(GenericCatalog<LibraryItem> gn, Scanner scanner) {
        System.out.println("Enter the title of the item:");
        String title = scanner.nextLine();
        System.out.println("Enter the author of the item:");
        String author = scanner.nextLine();
        LibraryItem newItem = new LibraryItem(title, author);
        gn.addItem(newItem);
        System.out.println("Item added successfully.");
    }

    private static void removeItem(GenericCatalog<LibraryItem> gn, Scanner scanner) {
        System.out.println("Enter the title of the item to remove:");
        String title = scanner.nextLine();
        System.out.println("Enter the author of the item to remove:");
        String author = scanner.nextLine();
        LibraryItem itemToRemove = new LibraryItem(title, author);

        boolean itemFound = false;
        for (LibraryItem item : gn.getCatalog()) {
            if (item.getTitle().equals(title) && item.getAuthor().equals(author)) {
                itemToRemove = item;
                itemFound = true;
                break;
            }
        }

        if (!itemFound) {
            System.out.println("Item not found in the catalog.");
        } else {
            gn.removeItem(itemToRemove);
        }
    }

    private static void displayItemInfo(GenericCatalog<LibraryItem> gn, Scanner scanner) {
        System.out.println("Enter the title of the item to display:");
        String title = scanner.nextLine();
        System.out.println("Enter the author of the item to display:");
        String author = scanner.nextLine();
        LibraryItem itemToDisplay = new LibraryItem(title, author);

        boolean itemFound = false;
        for (LibraryItem item : gn.getCatalog()) {
            if (item.getTitle().equals(title) && item.getAuthor().equals(author)) {
                itemToDisplay = item;
                itemFound = true;
                break;
            }
        }
        if (!itemFound) {
            System.out.println("Item not found in the catalog.");
        } else {
            gn.displayItemInfo(itemToDisplay);
        }
    }
}
