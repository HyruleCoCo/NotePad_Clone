import java.awt.*;
import java.io.*;

public class FileFunctions {
    GUI gui;
    String fileName, fileAddress;

    public FileFunctions(GUI gui){
        this.gui = gui;
    }

    public void newFile(){
        gui.textArea.setText("");
        gui.window.setTitle("New File");
        fileName = null;
        fileAddress = null;
    }

    public void openFile(){
        FileDialog fd = new FileDialog(gui.window, "Open", FileDialog.LOAD);
        fd.setVisible(true);

        if(fd.getFile() != null){
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.window.setTitle(fileName);

        }
        System.out.println("File address and name " + fileAddress + fileName);

        try{
            BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName));// you need the address of a file to read it

            gui.textArea.setText("");

            String line = null;

            while((line = br.readLine()) != null){
                gui.textArea.append(line + "\n");
            }
            br.close();
        }
        catch(Exception e){
            System.out.println("FILE NOT OPEND");
        }
    }

    public void saveFile(){
        if(fileName == null){
            saveAsFile();
        }
        else{
            try {
                FileWriter fw = new FileWriter(fileAddress + fileName + ".txt");
                fw.write(gui.textArea.getText());
                gui.window.setTitle(fileName);
                fw.close();
            } 
            catch (Exception e) {
                System.out.println("ERROR");
            }
        }

    }

    public void saveAsFile(){
        FileDialog fd = new FileDialog(gui.window, "Save As", FileDialog.SAVE);
        fd.setVisible(true);

        if(fd.getFile() != null){
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.window.setTitle(fileName);
        }

        try{
            FileWriter fw = new FileWriter(fileAddress + fileName + ".txt");
            fw.write(gui.textArea.getText());
            fw.close();
        }
        catch(Exception e){
            System.out.println("ERROR");
        }
    }

    public void exitFile(){
        saveFile();
        System.exit(0);
    }
}
