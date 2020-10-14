package model;

import java.io.Serializable;
import java.util.LinkedList;

//Represents a combination list having a list of combinations
public class CombinationList implements Serializable {
    LinkedList<Combination> comboList;

    //EFFECTS: constructs an empty combination list
    public CombinationList() {
        comboList = new LinkedList<>();
    }

    //MODIFIES: this
    //EFFECTS: adds a combination to the combination list
    public void addCombination(Combination combo) {
        comboList.add(combo);
    }

    //EFFECTS: prints the entire combination list
    public String toString() {
        StringBuilder combinations = new StringBuilder();
        int index = 1;
        for (Combination combo : comboList) {
            combinations.append(index).append(". ").append(combo.toString()).append("\n");
            index++;
        }
        return combinations.toString();
    }

    //EFFECTS: searches the list for a given username and returns all matching combos in a string format
    public String searchByUser(String username) {
        StringBuilder matchedCombos = new StringBuilder();
        int index = 1;                  //using a 1-based index

        for (Combination combo : comboList) {
            if (combo.getUsername().equals(username)) {
                matchedCombos.append(index).append(". ").append(combo.toString()).append("\n");
            }
            index++;
        }

        return matchedCombos.toString();
    }

    //EFFECTS: searches the list for a given password and returns all matching combos in a string format
    public String searchByPassword(String password) {
        StringBuilder matchedCombos = new StringBuilder();
        int index = 1;                  //using a 1-based index

        for (Combination combo : comboList) {
            if (combo.getPassword().equals(password)) {
                matchedCombos.append(index).append(". ").append(combo.toString()).append("\n");
            }
            index++;
        }

        return matchedCombos.toString();
    }

    //EFFECTS: searches the list for a given password and returns all matching combos in a string format
    public String searchByWebsite(String website) {
        StringBuilder matchedCombos = new StringBuilder();
        int index = 1;                  //using a 1-based index

        for (Combination combo : comboList) {
            if (combo.getWebsite().equals(website)) {
                matchedCombos.append(index).append(". ").append(combo.toString()).append("\n");
            }
            index++;
        }

        return matchedCombos.toString();
    }

    //EFFECTS: returns the size of the combination list
    public int getSize() {
        return comboList.size();
    }

    //EFFECTS: returns a combination at the given index
    public Combination getCombo(int i) {
        return comboList.get(i);
    }

    public void changeComboUser(int i, String newUser) {
        comboList.get(i).setUsername(newUser);
    }

    public void changeComboPassword(int i, String newPassword) {
        comboList.get(i).setPassword(newPassword);
    }

    public void changeComboWebsite(int i, String newWebsite) {
        comboList.get(i).setWebsite(newWebsite);
    }

    public void removeCombo(int i) {
        comboList.remove(i);
    }
}
