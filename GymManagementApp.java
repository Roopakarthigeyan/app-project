import java.util.InputMismatchException;
import java.util.Scanner;

public class GymManagementApp {
    public static void main(String[] args) {
        MemberManager memberManager = new MemberManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nGym Management System:");
            System.out.println("1. Add Member");
            System.out.println("2. Update Member");
            System.out.println("3. Delete Member");
            System.out.println("4. View All Members");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            try {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter name: ");
                        String name = scanner.next();
                        System.out.print("Enter age: ");
                        int age = scanner.nextInt();
                        System.out.print("Enter email: ");
                        String email = scanner.next();
                        System.out.print("Enter phone: ");
                        String phone = scanner.next();
                        System.out.print("Enter membership type: ");
                        String membershipType = scanner.next();

                        memberManager.addMember(name, age, email, phone, membershipType);
                        break;
                    case 2:
                        System.out.print("Enter member ID to update: ");
                        int idToUpdate = scanner.nextInt();
                        System.out.print("Enter new name: ");
                        name = scanner.next();
                        System.out.print("Enter new age: ");
                        age = scanner.nextInt();
                        System.out.print("Enter new email: ");
                        email = scanner.next();
                        System.out.print("Enter new phone: ");
                        phone = scanner.next();
                        System.out.print("Enter new membership type: ");
                        membershipType = scanner.next();

                        memberManager.updateMember(idToUpdate, name, age, email, phone, membershipType);
                        break;
                    case 3:
                        System.out.print("Enter member ID to delete: ");
                        int idToDelete = scanner.nextInt();
                        memberManager.deleteMember(idToDelete);
                        break;
                    case 4:
                        memberManager.viewMembers();
                        break;
                    case 5:
                        running = false;
                        System.out.println("Exiting Gym Management System. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input from the scanner
            }
        }

        scanner.close();
    }
}
