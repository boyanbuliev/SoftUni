package CollectionHierarchy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");

        Addable addCollection = new AddCollection();
        AddRemovable addRemoveCollection = new AddRemoveCollection();
        MyList myListCollection = new MyListImpl();

        for (String token : tokens) {
                System.out.print(addCollection.add(token) + " ");
        }
        System.out.println();
        for (String token : tokens) {
            System.out.print(addRemoveCollection.add(token) + " ");
        }
        System.out.println();
        for (String token : tokens) {
            System.out.print(myListCollection.add(token) + " ");
        }
        System.out.println();
        int n = Integer.parseInt(scanner.nextLine());
        int m = n;
        while (n-- > 0) {
            System.out.print(addRemoveCollection.remove() + " ");
        }
        System.out.println();
        while (m-- > 0) {
            System.out.print(myListCollection.remove() + " ");
        }
        System.out.println();
    }
}
