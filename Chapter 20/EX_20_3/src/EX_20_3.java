import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class EX_20_3 {

    public static void main(String[] args) {
        LinkedList<String[]> list = new LinkedList<>();

        Collections.addAll(list, stateCapital);

        Scanner input = new Scanner(System.in);
        int correctCount = 0;
        while (list.size() > 0) {
            Collections.shuffle(list);
            String[] s = list.pollFirst();
            System.out.print("What is the capital of " + s[0] +"? ");
            if (input.nextLine().equalsIgnoreCase(s[1])) {
                correctCount++;
                System.out.println("Your answer is correct!");
            } else {
                System.out.println("WRONG - The correct answer is " + s[1]);
            }
        }
        System.out.println("The correct count is " + correctCount);
    }

        public static String[][] stateCapital = {{"Alabama", "Montgomery"}, {"Alaska", "Juneau"}, {"Arizona", "Phoenix"},
                {"Arkansas", "Little Rock"}, {"California", "Sacramento"}, {"Colorado", "Denver"},
                {"Connecticut", "Hartford"}, {"Delaware", "Dover"}, {"Florida", "Tallahassee"},
                {"Georgia", "Atlanta"}, {"Hawaii", "Honolulu"}, {"Idaho", "Boise"}, {"Illinois", "Springfield"},
                {"Indiana", "Indianapolis"}, {"Iowa", "Des Moines"}, {"Kansas", "Topeka"}, {"Kentucky", "Frankfort"},
                {"Louisiana", "Baton Rouge"}, {"Maine", "Augusta"}, {"Maryland", "Annapolis"}, {"Massachusettes", "Boston"},
                {"Michigan", "Lansing"}, {"Minnesota", "Saint Paul"}, {"Mississippi", "Jackson"}, {"Missouri", "Jefferson City"},
                {"Montana", "Helena"}, {"Nebraska", "Lincoln"}, {"Nevada", "Carson City"}, {"New Hampshire", "Concord"},
                {"New Jersey", "Trenton"}, {"New York", "Albany"}, {"New Mexico", "Santa Fe"}, {"North Carolina", "Raleigh"},
                {"North Dakota", "Bismarck"}, {"Ohio", "Columbus"}, {"Oklahoma", "Oklahoma City"}, {"Oregon", "Salem"},
                {"Pennsylvania", "Harrisburg"}, {"Rhode Island", "Providence"}, {"South Carolina", "Columbia"},
                {"South Dakota", "Pierre"}, {"Tennessee", "Nashville"}, {"Texas", "Austin"}, {"Utah", "Salt Lake City"},
                {"Vermont", "Montpelier"}, {"Virginia", "Richmond"}, {"Washington", "Olympia"}, {"West Virginia", "Charleston"},
                {"Wisconsin", "Madison"}, {"Wyoming", "Cheyenne"}};

    }



