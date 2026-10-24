import java.util.Scanner;

class Main {
    private static final int MAX_COUNT = 10;
    private static int[] grades = new int[MAX_COUNT]; // Stores the grades
    private static int count = 0; // Keeps track of the number of grades
    
    public static void main(String[] args) {
        // If no args provided, display basic help message
        if (args.length == 0) {
            System.out.println("No arguments provided.");
            System.out.println("\tUse -s or --specs to display the project specifications.");
            System.out.println("\tUse -i or --input to enter grades.");
        }

        for (String arg : args) {
            // Look for -s or --specs to display the project specs
            if (arg.equals("-s") || arg.equals("--specs")) {
                printProgrammingSpecs();
                return;
            }

            // Option -i or --input for entering grades. Ends when user enters 999 or after 10 grades.
            if (arg.equals("-i") || arg.equals("--input")) {
                getGradesFromInput();
                printGrades();
                computeAverageGrade();
                return;
            }
        }
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
     * Uses a loop to allow the user to enter grades one after the other. Exits on value "999".
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

            // Try to get the grade input from the user. If the value is anything else than an integer, ignore and go to the next input.
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

            // If grade is valid, add it to the array and increment the counter
            if (grade >= 0 && grade <= 100) {
                grades[count] = grade;
                count++;
            } else {
                System.err.println("Invalid grade: " + grade + ". Ignored.");
            }

            // If the the user has entered the maximum amount of grades, exit.
            if (count >= MAX_COUNT) {
                System.err.println("Maximum number of grades entered. Exit.");
                break;
            }
        }

        input.close();
    }
    
    /**
     * Prints all grades in the array.
     */
    private static void printGrades() {
        System.out.println("Summary of the list of grades:");

        // Cycle through the array of grades and print them one by one.
        for (int grade : grades) {
            System.out.println(grade);
        }
    }

    /**
     * Computes the average quiz grade.
     */
    private static void computeAverageGrade() {
        int sum = 0;

        // Cumulates the sum of the grades
        for (int grade : grades) {
            sum += grade;
        }

        // Calculate the average
        float average = (float) sum / count;

        System.out.println("Average quiz grade: " + average);
    }
}