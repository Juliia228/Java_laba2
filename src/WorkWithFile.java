import java.io.*;
import java.util.TreeMap;

/**
 * Class for counting English letters in the file and outputting these counts to another file
 * @author Julia Komarova
 */
public class WorkWithFile {
    /**
     * Name of the file to parse
     */
    private String file_for_input;
    /**
     * Name of the file to output the result
     */
    private String file_for_output;
    /**
     * Dictionary for counting English letters in the file
     */
    private final TreeMap<Character,Integer> dict = new TreeMap<>();

    /**
     * Constructor declaring files for input and output
     * @param filename_for_input - name of the file to parse
     * @param filename_for_output - name of the file to output the result
     */
    WorkWithFile(String filename_for_input, String filename_for_output) {
        SetInputFile(filename_for_input);
        SetOutputFile(filename_for_output);
    }

    /**
     * Setter for the file to parse
     * @param file - value for the file to parse
     */
    public void SetInputFile(String file) {
        file_for_input = file;
    }

    /**
     * Setter for the file to output
     * @param file - value for the file to output the result
     */
    public void SetOutputFile(String file) {
        file_for_output = file;
    }

    /**
     * Getter for the file to parse
     * @return value of the file to parse
     */
    public String GetInputFile() {
        return file_for_input;
    }

    /**
     * Getter for the file to output
     * @return value of the file to output the result
     */
    public String GetOutputFile() {
        return file_for_output;
    }

    /**
     * Getter for dictionary with the number of English letters of the file to input
     * @return dictionary
     */
    public TreeMap<Character,Integer> GetDictionary() {
        return dict;
    }

    /**
     * Method for reading the file and filling in dictionary
     * @return true - reading is successful, false - reading is unsuccessful
     */
    public boolean ReadFile() {
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

    /**
     * Method for writing data from dictionary to the file
     */
    public void WriteToFile() {
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
