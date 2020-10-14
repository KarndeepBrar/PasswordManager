package ui;

import persistence.Read;
import persistence.Write;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static ui.PasswordManager.updateTable;

// Creates the file menu on the menu bar
public class FileMenu extends JMenu {
    private JMenuItem saveFileItem;
    private JMenuItem loadFileItem;
    private JMenuItem exitFileItem;

    //instantiates the file menu
    public FileMenu() {
        super("File");
        setMnemonic(KeyEvent.VK_F);

        saveFileItem = createSaveFileItem();
        loadFileItem = createLoadFileItem();
        exitFileItem = createExitFileItem();

        add(saveFileItem);
        add(loadFileItem);
        add(exitFileItem);
    }

    // EFFECTS: creates the save file menu item
    private JMenuItem createSaveFileItem() {
        JMenuItem saveFileItem = new JMenuItem("Save");
        saveFileItem.addActionListener(new SaveFileItemHandler());

        return saveFileItem;
    }

    // EFFECTS: creates the load file menu item
    private JMenuItem createLoadFileItem() {
        JMenuItem loadFileItem = new JMenuItem("Load");
        loadFileItem.addActionListener(new LoadFileItemHandler());

        return loadFileItem;
    }

    // EFFECTS: creates the exit file menu item
    private JMenuItem createExitFileItem() {
        JMenuItem exitFileItem = new JMenuItem("Exit");
        exitFileItem.addActionListener(new ExitFileItemHandler());

        return exitFileItem;
    }

    private class SaveFileItemHandler implements ActionListener {

        //EFFECTS : saves the file to as the given name and stores the file name that it is saved as
        @Override
        public void actionPerformed(ActionEvent e) {
            String fileName = JOptionPane.showInputDialog(saveFileItem,
                    "Enter the file name", null);
            try {
                Write.write(PasswordManager.comboList, fileName);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(saveFileItem, "The file could not be saved.");
            }
        }
    }

    private class LoadFileItemHandler implements ActionListener {

        //EFFECTS : loads the file with the given name and plays a sound if it is loaded
        @Override
        public void actionPerformed(ActionEvent e) {
            String fileName = JOptionPane.showInputDialog(loadFileItem,
                    "Enter the file name", null);
            try {
                PasswordManager.comboList = Read.read(fileName);
                updateTable();

                // code for audio is taken from https://alvinalexander.com/java/java-audio-example-java-au-play-sound
                InputStream in = new FileInputStream("./data/lockopening.wav");
                AudioStream audioStream = new AudioStream(in);
                AudioPlayer.player.start(audioStream);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(loadFileItem, "The file could not be loaded.");
            }
        }

    }

    private class ExitFileItemHandler implements ActionListener {

        //EFFECTS : closes the program
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

}
