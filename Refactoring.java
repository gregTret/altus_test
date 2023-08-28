import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Refactoring {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Feed Child With Ice Cream, Salad or Milk To See Child's Face Reaction : ");
        String food = reader.readLine();

        // // Original Approach
        if (food.equalsIgnoreCase("Ice Cream")) {
            System.out.println("Happy" + " " + "Face");
        } else if (food.equalsIgnoreCase("Salad")) {
            System.out.println("Angry" + " " + "Face");
        } else if (food.equalsIgnoreCase("Milk")) {
            System.out.println("Normal" + " " + "Face");
        } else {
            System.out.println("Error" + " " + "Face");
        }

        /*
         * Pro:
         *  Easy to implement, adjustable : can pass "food reactions" in as a parameter.
         * 
         * Con:
         *  When you get to very large numbers of faces the for loop which checks for
         *  which food was given and which reaction to return grows as well (O(n) time
         *  worst case)
         */

        // Alternate Approach #1: Arrays
        String[][] foodReactions = {{"ice cream","Happy Face"},{"salad","Angry Face"},{"milk","Normal Face"}};
        boolean found = false;
        for (int i = 0; i < foodReactions.length; i++) {
            if (food.equalsIgnoreCase(foodReactions[i][0])) {
                found = true;
                System.out.println(foodReactions[i][1]);
                break;
            }
        }
        if (found == false) {
            System.out.println("Error" + " " + "Face");
        }

        /*
         * Pro:
         *  Very easy to read and understand, can be easily modified.
         * 
         * Con:
         *  Codebase will be ugly and difficult to work with if you need to develop a few
         *  million faces and reactions for foods. -> Extremely impractical to scale
         */

        //Alternate Approach #2: Switch Statements
        food = food.toLowerCase();
        switch (food) {
            case "ice cream":
                System.out.println("Happy" + " " + "Face");
                break;
            case "salad":
                System.out.println("Angry" + " " + "Face");
                break;
            case "milk":
                System.out.println("Normal" + " " + "Face");
                break;
            default:
                System.out.println("Error" + " " + "Face");
                break;
        }


        /*
         * Pro:
         *  Scales well with additional faces/reactions (time complexity for finding )
         *  Including additional faces can be automated and/or passed in as parameters
         * 
         * Con:
         *  Overkill for the current level of difficulty required for this problem.
         */
        // Alternate Approach #3: Hash Maps
        Map<String, String> foodReactionsMap = new HashMap<String, String>();
        food = food.toLowerCase();

        foodReactionsMap.put("ice cream", "Happy Face");
        foodReactionsMap.put("salad", "Angry Face");
        foodReactionsMap.put("milk", "Normal Face");

        String reaction = foodReactionsMap.get(food);

        if (reaction == null) {
            System.out.println("Error" + " " + "Face");
        } else {
            System.out.println(reaction);
        }
    }
}