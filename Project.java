import java.util.Scanner;

class Main {
    private static final int MAX_COUNT = 10;
    private static int[] grades = new int[MAX_COUNT]; // Stores the grades
    private static int count = 0; // Keeps track of the number of grades
    private static int sum = 0; // Stores the sum of the grades
    private static float average = 0; // Stores the average grade

    public static void main(String[] args) {
        // If no args provided, run the happy flow
        if (args.length == 0) {
            getGradesFromInput();
            printGrades();
            computeAverageGrade();
            parseLetterGrade();
        }

        for (String arg : args) {
            // Look for -s or --specs to display the project specs
            if (arg.equals("-s") || arg.equals("--specs")) {
                printProgrammingSpecs();
            }
        }

        return;
    }

    /**
     * Prints the programming specifications for the project.
     */
    public static void printProgrammingSpecs() {
        String specs = "Create a Java project in IDE and begin the Project Program by developing a Java Method to print the programming specifications for the project.\r\n"
                + //
                "Expand the Project Program and create Java code to input from the console (keyboard) the first quiz grade. Use a loop to allow the user to continue to enter grades as long as they don't enter 999 to quit.\r\n"
                + //
                "Expand the Project Program and create Java code to populate the array of the student's quiz grades. The grade is added to a running total, and the count of grades entered is incremented. The loop ends after 10 grades are entered. When the loop ends, count holds the number of grades entered.\r\n"
                + //
                "Expand the Project Program and create Java code use another loop to print all grades in the array.\r\n"
                + //
                "Expand the Project Program and create Java code to compute the average quiz grade.\r\n"
                + //
                "Expand the Project Program and create Java code to use decision logic to find out the letter grade of the average based on the following grading scale and print to the console.\r\n"
                + //
                "A = 90-100\r\n" + //
                "B = 80-89\r\n" + //
                "C = 70-79\r\n" + //
                "D = 60-69\r\n" + //
                "F = 0-59";

        System.out.println(specs);
    }

    /**
     * Uses a loop to allow the user to enter grades one after the other. Exits on
     * value "999".
     */
    private static void getGradesFromInput() {
        grades = new int[MAX_COUNT];
        count = 0;

        Scanner input = new java.util.Scanner(System.in);

        // Instruct the user to enter grades
        System.out
                .println(
                        "Enter a grade value between 0 and 100 and then press enter to add a new one. Enter the value \"999\" to exit");

        while (input.hasNext()) {
            int grade;

            // Try to get the grade input from the user. If the value is anything else than
            // an integer, ignore and go to the next input.
            try {
                grade = input.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.err.println("Invalid input: " + input.next() + ". Ignored.");
                continue;
            }

            // Exit door
            if (grade == 999) {
                break;
            }

            // If grade is valid, add it to the array and increment the counter. Also update
            // the grades sum for later average calculation.
            if (grade >= 0 && grade <= 100) {
                grades[count] = grade;
                sum += grade;
                count++;
            } else {
                System.err.println("Invalid grade: " + grade + ". Ignored.");
            }

            // If the the user has entered the maximum amount of grades, exit.
            if (count >= MAX_COUNT) {
                System.err.println("Maximum number of grades entered.");
                break;
            }
        }

        input.close();
    }

    /**
     * Prints all grades in the array.
     */
    private static void printGrades() {
        if (count > 0) {
            System.out.println("Summary of the list of grades:");

            // Cycle through the array of grades and print them one by one.
            for (int i = 0; i < count; i++) {
                System.out.println(grades[i]);
            }
        }
    }

    /**
     * Computes the average quiz grade.
     */
    private static void computeAverageGrade() {
        if (count > 0) {
            // Calculate the average
            average = (float) sum / count;

            System.out.println("Average quiz grade: " + average);
        }
    }

    /**
     * Find out the letter grade of the average based on grading scale.
     */
    private static void parseLetterGrade() {
        if (count > 0) {
            char letterGrade;

            // Finds the appropriate letter for the average grade.
            if (average >= 90) {
                letterGrade = 'A';
            } else if (average >= 80) {
                letterGrade = 'B';
            } else if (average >= 70) {
                letterGrade = 'C';
            } else if (average >= 60) {
                letterGrade = 'D';
            } else {
                letterGrade = 'F';
            }

            System.out.println("Letter grade: " + letterGrade);
        }
    }
}