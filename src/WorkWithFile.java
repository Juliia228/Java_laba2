import java.io.*;
import java.util.TreeMap;
public class WorkWithFile {
    static TreeMap<Character,Integer> dict = new TreeMap<>();
    public static boolean ReadFile(String filename) {
        try (FileReader reader = new FileReader(filename)) {
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
    public static void WriteToFile(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (char key: dict.keySet()) {
                writer.write("'"+key+"': "+dict.get(key)+"\n");
            }
//            for (char key = 'A'; key <= 'z'; key++) {
//                if (key > 'Z' && key < 'a') {
//                    continue;
//                }
//                if (dict.containsKey(key)) {
//                    writer.write("'"+key+"': "+dict.get(key)+"\n");
//                } else {
//                    writer.write("'"+key+"': 0\n");
//                }
//            }
            writer.flush();
            System.out.println("The data was written successfully");
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
