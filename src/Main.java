import java.util.Scanner;

/**
 * @author Julia Komarova
 */
public class Main {
    /**
     * Method of getting file names for input and output
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name of the file to be parsed: ");
        String filename_for_input = sc.nextLine();
        System.out.print("Enter the name of the file you want to write the result to: ");
        String filename_for_output = sc.nextLine();
        WorkWithFile work = new WorkWithFile(filename_for_input, filename_for_output);
        boolean is_input_successful = work.ReadFile();
        while (!is_input_successful) {
            System.out.print("Enter the name of the file to be parsed: ");
            filename_for_input = sc.nextLine();
            work.SetInputFile(filename_for_input);
            is_input_successful = work.ReadFile();
        }
        work.WriteToFile();
    }
}