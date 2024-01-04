import java.util.*;

public class Sayasat_Sabit_230103164_ { // main class
    public static Scanner input = new Scanner(System.in); //It is general scanner that can be used in each method

    public static void main(String[] args) { //main method
        System.out.print("Enter username: "); // giving username
        String username = input.next();
        System.out.print("Enter password: "); // giving password
        String password = input.next();
        boolean check = true; // create variable that consist true for the main loop
        String admin = "Sayasat";
        String sign = "Sabit07";
        if (username.equals(admin) && password.equals(sign)) { // Check if username and password are correct

            while (check) { //create infinite loop

                System.out.println("Main Menu");
                System.out.println("1.Add Student");
                System.out.println("2.Manage Records");
                System.out.println("3.Calculate Grades");
                System.out.println("4.View Statistics");
                System.out.println("5.Generate Reports");
                System.out.println("6.Delete Student");
                System.out.println("7.Logout and exit");
                System.out.print("Enter your choice: ");

                if (input.hasNextInt()) { // check that entered data is only integer number
                    int num = input.nextInt();

                    switch (num) {
                        case 1:
                            add_student();
                            break;
                        case 2:
                            manage_records();
                            break;
                        case 3:
                            calculate_grades();
                            break;
                        case 4:
                            view_statistics();
                            break;
                        case 5:
                            generate_reports();
                            break;
                        case 6:
                            delete_student();
                            break;
                        case 7:
                            check = false;
                            System.exit(1);
                            break;
                        default:
                            System.out.println("Select should consist the numbers between 1 and 7");
                            break;
                    }
                }
                else{
                    System.out.println("Select should consist the numbers between 1 and 7");
                    input.next(); // removes incorrect values and moves on to the next values
                }
            }
        } else {
            System.out.println("Incorrect username");
        }
    }

    public static ArrayList<String> array_student_names = new ArrayList<String>(); // array that consist student names
    public static ArrayList<Integer> array_student_id = new ArrayList<Integer>(); // array that consist student id
    public static ArrayList<Integer> array_test_score = new ArrayList<Integer>(); // array that consist student score
    public static ArrayList<Character> array_grades = new ArrayList<Character>(); // array that consist student grade

    public static void add_student() {
        // Loop for entering student name until valid input is provided
        while(true) { // loop that allows you to repeat specified parameters until they are satisfied
            System.out.print("Enter student name: "); // enter student name
            String student_name = input.next();
            if (student_name.matches("[a-zA-Z]+")) { // check that entered data consist only letters
                array_student_names.add(student_name); // if yes, then add it to array
                break; // if condition is satisfied, then exit the loop
            } else {
                System.out.println("Student name should consist only letters");
            }
        }
        while(true){
            System.out.print("Enter student ID: ");
            if(input.hasNextInt()){ // check that entered data consist only integer numbers
                int student_id = input.nextInt(); // add the ID
                int index = array_student_id.indexOf(student_id); // Check if the student ID already exists
                // Check if the entered student ID is a positive integer
                if(student_id>0) {
                    // If the student ID doesn't already exist, add it to the IDs list
                    if (index == -1) {
                        array_student_id.add(student_id);
                        break; // Exit the loop as the condition is satisfied
                    } else {
                        System.out.println("Student with that ID is already exists");
                    }
                }
                else{
                    System.out.println("Invalid input. Enter the positive integers");
                }
            }
            else {
                System.out.println("Error. Input an Integer");
                input.next(); // Removes incorrect values and moves on to the next values
            }
        }
        // Loop for entering the test score until valid input is provided
        System.out.print("Enter test score: ");
        while(true){
            if(input.hasNextInt()){
                int test_score = input.nextInt(); // enter the test score
                // Check that test_score between 0 and 100
                if (test_score >= 0 && test_score <= 100) {
                    array_test_score.add(test_score); // Add the valid test score to the scores list
                    System.out.println("Student add successfully");
                    break; // Exit the loop as the condition is satisfied
                } else{
                    System.out.println("Test score should be between 0 and 100");
                    System.out.print("Enter test score: ");
                }
            }
            else{
                System.out.println("Error. Enter an integer between 0 and 100");
                input.next(); // Removes incorrect values and moves on to the next values
                System.out.print("Enter test score: ");
            }
        }
    }

    public static void manage_records() {

        // Check if the list of students is empty, and if so, inform the admin
        if(array_student_id.isEmpty()){
            System.out.println("There is no student at the list");
        }
        else{
            while(true){
                // Start an indefinite loop to repeatedly ask for student ID and new test score
                System.out.print("Enter student ID to edit: ");
                if(input.hasNextInt()){
                    // Check if the input is an integer (student ID)

                    int student_ID = input.nextInt();
                    if(student_ID>0) {
                        // Check if the entered student ID is a positive integer

                        System.out.print("Enter new test score: ");
                        if (input.hasNextInt()) {
                            // Check if the input is another integer (new test score)

                            int new_test_score = input.nextInt();
                            if (new_test_score >= 0 && new_test_score <= 100) {
                                // Check if the new_test_score between 0 and 100

                                int index_of_ID = array_student_id.indexOf(student_ID);
                                if (index_of_ID != -1) {
                                    // Check if the entered student ID exists in the list

                                    // Update the test score for the student at the specified index
                                    array_test_score.set(index_of_ID, new_test_score);
                                    System.out.println("Student record updated successfully");
                                    break;
                                } else {
                                    // If the student with the entered ID is not found, inform the admin
                                    System.out.println("A student with that ID not found. Enter the student which in the list");
                                }
                            } else {
                                // If the entered test score is out of range, inform the admin
                                System.out.println("Error input. Test score should be between 0 and 100");
                            }
                        } else {
                            // If the entered new test score is not an integer, inform the admin
                            System.out.println("Error input. Enter an integer");
                            input.next();
                        }
                    }
                    else{
                        // If the entered student ID is not a positive integer, inform the admin
                        System.out.println("Invalid input. ID should consist only positive integers");
                    }
                }
                else{
                    // If the entered student ID is not an integer, inform the admin
                    System.out.println("Error input. Enter a valid student ID");
                    input.next(); // Removes incorrect values and moves on to the next values
                }
            }
        }
    }

    public static void calculate_grades() {

        if(array_test_score.isEmpty()){
            // Check if the list of students is empty, and if so, inform the admin
            System.out.println("There is no score at the list. Add the student");
        }
        else{
            for (int i = 0; i < array_test_score.size(); i++) {
                // Loop that check each score in the list
                int score = array_test_score.get(i);
                // Get the value for the current student
                if (score >= 90 && score <= 100) {
                    array_grades.add('A');
                }
                if (score >= 80 && score <= 89) {
                    array_grades.add('B');
                }
                if (score >= 70 && score <= 79) {
                    array_grades.add('C');
                }
                if (score >= 60 && score <= 69) {
                    array_grades.add('D');
                }
                if (score >= 40 && score <= 59) {
                    array_grades.add('F');
                }
                if (score >= 0 && score <= 39) {
                    array_grades.add('E');
                }
            }
            // Inform the admin that the grades have been calculated and added
            System.out.println("Grades calculated");
            System.out.println("Grades Details added");
        }
    }

    public static void view_statistics() {

        if(array_student_id.isEmpty()){
            // Check if the list of students is empty, and if so, inform the admin
            System.out.println("There is no student at the list. Add the student");
        }
        else{
            System.out.println("Statistics:");

            System.out.println("Total students: " + array_student_id.size());
            // Calculate and display the total number of students in the list

            double sumOfScores = 0;
            for (int i = 0; i < array_test_score.size(); i++) {
                sumOfScores += array_test_score.get(i);
                // Loop through test scores and calculate the sum of all scores
            }
            System.out.println("Average score: " + (sumOfScores / array_test_score.size()));
            // Calculate and display the average test score for all students

            double maxOfScores = 0;
            for (int i = 0; i < array_test_score.size(); i++) {
                int score = array_test_score.get(i);
                if (score > maxOfScores) {
                    maxOfScores = score;
                    // Loop through test scores and find the highest score
                }
            }
            System.out.println("Highest score: " + maxOfScores);
            // Display the highest test score in the list

            double minOfScores = 999;
            for (int i = 0; i < array_test_score.size(); i++) {
                int score = array_test_score.get(i);
                if (score < minOfScores) {
                    minOfScores = score;
                    // Loop through test scores and find the lowest score
                }
            }
            System.out.println("Lowest score: " + minOfScores);
            // Display the lowest test score in the list
        }
    }

public static void generate_reports() {

        if (array_student_id.isEmpty()) {
            // Check if the list of student IDs is empty and inform the admin that no report can be generated
            System.out.println("There is no student at list to give the report");
            }
        if (array_grades.isEmpty()) {
            // Check if the list of grades is empty and inform the admin that grades have not been calculated
            System.out.println("Grade of that student(s) was not calculated");
        } else {
            System.out.print("Enter student ID to generate a report: ");
            int ID_in_array = -1;
            if(input.hasNextInt()) {
                // Check if input value an integer number
                int student_ID = input.nextInt();
                if (student_ID > 0) {
                    // Check if the entered student ID is a positive integer
                    for (int i = 0; i < array_student_id.size(); i++) {
                        if (student_ID == array_student_id.get(i)) {
                            // If the entered ID matches a student in the list, generate a report
                            ID_in_array = i; // If the condition is satisfied, then variable get the index of elem in array
                            System.out.println("Generating report for student with ID: " + student_ID);
                            System.out.println("Student Report");
                            System.out.println("Name: " + array_student_names.get(i));
                            System.out.println("Student ID: " + array_student_id.get(i));
                            System.out.println("Test score: " + (double) array_test_score.get(i));
                            System.out.println("Final Grade: " + array_grades.get(i));
                            break; // if all conditions satisfied, then exit the loop
                        }
                    }
                } else {
                    System.out.println("Invalid input. ID must consist only positive integers");
                    // Inform the admin of invalid input if the entered student ID is not a positive integer
                }
            }
            else{
                System.out.println("Student ID must have only integer numbers");
            }
            if (ID_in_array == -1) {
                System.out.println("Student not found");
                // Inform the admin that the entered student ID does not match any student in the list
            }
        }
    }

    public static void delete_student(){

        if(array_student_id.isEmpty()){
            // Check if the list of student IDs is empty and inform the admin that there are no students to delete
            System.out.println("There is no student to delete. Please add the student");
        }
        else{
            System.out.print("Enter student ID to delete: ");
            int student_ID = input.nextInt();

            int idToDelete = array_student_id.indexOf(student_ID);
            if(student_ID>0) {
                // Check if the entered student ID is a positive integer
                if (idToDelete != -1) {
                    // Check if the entered student ID exists in the list
                    for (int i = 0; i < array_student_id.size(); i++) {
                        idToDelete = array_student_id.get(i);
                        if (student_ID == idToDelete) {
                            // If the entered ID matches a student in the list, delete that student's records
                            array_student_id.remove(i);
                            array_student_names.remove(i);
                            array_test_score.remove(i);
                            if (!array_grades.isEmpty()) {
                                array_grades.remove(i);
                            }
                            System.out.println("Student deleted successfully");
                            break;
                        }
                    }
                } else {
                    System.out.println("Student not found");
                    // Inform the admin that the entered student ID does not match any student in the list
                }
            }
            else{
                System.out.println("Invalid input. ID must consist only positive integers");
                // Inform the admin of invalid input if the entered student ID is not a positive integer
            }
        }
    }
}