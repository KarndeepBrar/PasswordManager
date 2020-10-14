package persistence;

import model.CombinationList;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

//Writes combination list to a file
public class Write {
    //REQUIRES: a combination list
    //EFFECTS: saves the combination list to a file, and the file name to another file
    public static void write(CombinationList comboList, String fileName) throws IOException {
        String filePath = "./data/" + fileName;
        FileOutputStream fileOutput = new FileOutputStream(filePath);
        ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);

        objectOutput.writeObject(comboList);

        fileOutput.close();
        objectOutput.close();

        PrintWriter out = new PrintWriter("./data/lastComboUsed.txt");
        out.println(fileName);
        out.close();
    }
}
