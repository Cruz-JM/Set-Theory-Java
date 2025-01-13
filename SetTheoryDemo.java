import java.util.*;

public class SetTheoryDemo {

    public static Set<String> inputSet(Scanner scanner, String setName) {
        Set<String> set = new HashSet<>();
        System.out.println("Enter elements of Set " + setName + " separated by spaces: ");
        String input = scanner.nextLine();
        
        String[] elements = input.split(" ");
        for (String element : elements) {
            String trimmedElement = element.trim();
            if (!trimmedElement.isEmpty() && set.add(trimmedElement)) {
                // Element added successfully
            } else {
                System.out.println("Invalid input or duplicate element: " + trimmedElement);
            }
        }
        return set;
    }

    public static void displayResults(Set<String> setA, Set<String> setB, int choice) {
        switch (choice) {
            case 1: // Union
                Set<String> union = new HashSet<>(setA);
                union.addAll(setB);
                System.out.println("Union (A ∪ B): " + union);
                break;

            case 2: // Intersection
                Set<String> intersection = new HashSet<>(setA);
                intersection.retainAll(setB);
                System.out.println("Intersection (A ∩ B): " + intersection);
                break;

            case 3: // Difference
                Set<String> differenceAB = new HashSet<>(setA);
                differenceAB.removeAll(setB);
                Set<String> differenceBA = new HashSet<>(setB);
                differenceBA.removeAll(setA);
                System.out.println("Difference (A − B): " + differenceAB);
                System.out.println("Difference (B − A): " + differenceBA);
                break;

            case 4: // Subset Check
                boolean isSubsetAB = setA.containsAll(setB);
                boolean isSubsetBA = setB.containsAll(setA);
                System.out.println("Is A a subset of B (A ⊆ B): " + isSubsetAB);
                System.out.println("Is B a subset of A (B ⊆ A): " + isSubsetBA);
                break;

            case 5: // Exit
                System.out.println("Exiting the program.");
                break;

            default:
                System.out.println("Invalid choice. Please choose a valid operation.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Set Theory Demonstration Program!");

        Set<String> setA = inputSet(scanner, "A");
        Set<String> setB = inputSet(scanner, "B");

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Union (A ∪ B)");
            System.out.println("2. Intersection (A ∩ B)");
            System.out.println("3. Difference (A − B) and (B − A)");
            System.out.println("4. Subset Check (A ⊆ B) and (B ⊆ A)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            if (choice == 5) {
                displayResults(setA, setB, choice);
                break;
            }

            displayResults(setA, setB, choice);
        }

        scanner.close();
    }
}
