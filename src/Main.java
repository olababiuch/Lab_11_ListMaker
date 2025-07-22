import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ArrayList<String> myArrList = new ArrayList<>();
        boolean done = false;

        do {
            displayList(myArrList);
            displayMenu();
            String menu = SafeInput.getRegExString(in, "Enter menu choice [A,D,I,P,Q]", "^[AaDdIiPpQq]$");
            switch (menu.toUpperCase()) {
                case "A":
                    addItem(myArrList, in);
                    break;
                case "D":
                    deleteItem(myArrList, in);
                    break;
                case "I":
                    insertItem(myArrList, in);
                    break;
                case "P":
                    displayList(myArrList);
                    break;
                case "Q":
                    done = SafeInput.getYNConfirm(in, "Are you sure you want to quit?");
                    break;
            }
        } while (!done);
        System.out.println("Thank you for using this program.");
    }


    private static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("A - add an item to the list");
        System.out.println("D - delete an item from the list");
        System.out.println("I - insert an item into the list");
        System.out.println("P - print the list");
        System.out.println("Q - quit");
        return;
    }

    private static void displayList(ArrayList<String> myArrList) {
        System.out.println("List: ");
        if (myArrList.isEmpty()) {
            System.out.println("List is empty");
        } else {
            for (int i = 0; i < myArrList.size(); i++) {
                System.out.printf("%d. %s\n", i + 1, myArrList.get(i));
            }
        }
        return;
    }

    private static void addItem(ArrayList<String> myArrList, Scanner in) {
        String item = SafeInput.getNonZeroLenString(in, "Enter the item to be added");
        myArrList.add(item);
    }

    private static void deleteItem(ArrayList<String> myArrList, Scanner in) {
        if (myArrList.isEmpty()) {
            System.out.println("List is empty. There is nothing to delete");
            return;
        } else {
            displayList(myArrList);
            int index = SafeInput.getRangedInt(in, "Enter index to delete", 1, myArrList.size());
            myArrList.remove(index - 1);
        }
    }

    private static void insertItem(ArrayList<String> myArrList, Scanner in) {
        String item = SafeInput.getNonZeroLenString(in, "Enter the item to insert");
        int userIndex = SafeInput.getRangedInt(in, "Enter position to insert at (1 to " + (myArrList.size() + 1) + ")", 1, myArrList.size() + 1);
        myArrList.add(userIndex - 1, item);  // Adjust for zero-based index
    }

}