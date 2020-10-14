package persistence;

import model.CombinationList;

import java.io.*;
import java.util.Scanner;

//Reads combination list from a file
public class Read {
    //EFFECTS: reads the combos file and returns the list of combinations, and stores the file name that was loaded
    // in another file
    public static CombinationList read(String fileName) throws Exception {
        String filePath = "./data/" + fileName;
        FileInputStream fileInput = new FileInputStream(filePath);
        ObjectInputStream objectInput = new ObjectInputStream(fileInput);
        CombinationList comboList = (CombinationList) objectInput.readObject();

        fileInput.close();
        objectInput.close();

        PrintWriter out = new PrintWriter("./data/lastComboUsed.txt");
        out.println(fileName);
        out.close();

        return comboList;
    }

    // EFFECTS: loads the last item that was loaded
    public static CombinationList readLastFile(String filePath) throws Exception {
        Scanner scanner = new Scanner(new File("./data/" + filePath));
        String lastFileName = scanner.nextLine();
        scanner.close();

        return read(lastFileName);
    }
}
