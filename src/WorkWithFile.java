import java.io.*;
import java.util.TreeMap;

/**
 * Class for counting English letters in the file and outputting these counts to another file
 * @author Julia Komarova
 */
public class WorkWithFile {
    private static String file_for_input;
    private static String file_for_output;
    /**
     * Dictionary for counting English letters in the file
     */
    private final static TreeMap<Character,Integer> dict = new TreeMap<>();
    WorkWithFile(String filename_for_input, String filename_for_output) {
        SetInputFile(filename_for_input);
        SetOutputFile(filename_for_output);
    }
    public static void SetInputFile(String file) {
        file_for_input = file;
    }
    public static void SetOutputFile(String file) {
        file_for_output = file;
    }
    public static String GetInputFile() {
        return file_for_input;
    }
    public static String GetOutputFile() {
        return file_for_output;
    }
    public static TreeMap<Character,Integer> GetDictionary() {
        return dict;
    }
    public static boolean ReadFile() {
        try (FileReader reader = new FileReader(file_for_input)) {
            int symb = reader.read();
            while (symb > 0) {
                char symbol = (char)symb;
                if ((symb >= 'A' && symb <= 'Z') || (symb >= 'a' && symb <= 'z')) {
                    if (dict.containsKey(symbol)) {
                        int value = dict.get(symbol);
                        value += 1;
                        dict.put(symbol, value);
                    } else {
                        dict.put(symbol, 1);
                    }
                }
                symb = reader.read();
            }
            reader.close();
            System.out.println("The file was read successfully");
        } catch (IOException ex) {
            System.out.println(ex.getMessage() + "\nTry again");
            return false;
        }
        return true;
    }
    public static void WriteToFile() {
        try (FileWriter writer = new FileWriter(file_for_output)) {
            for (char key: dict.keySet()) {
                writer.write("'"+key+"': "+dict.get(key)+"\n");
            }
            writer.flush();
            System.out.println("The data was written successfully");
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
