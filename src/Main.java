import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String filename;
        boolean is_input_successful = false;
        while (!is_input_successful){
            System.out.print("Enter the name of the file to be parsed: ");
            filename = sc.nextLine();
            is_input_successful = WorkWithFile.ReadFile(filename);
        }
        System.out.print("Enter the name of the file you want to write the result to: ");
        filename = sc.nextLine();
        WorkWithFile.WriteToFile(filename);
    }
}