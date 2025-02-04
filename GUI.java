import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

import java.awt.event.*;

public class GUI implements ActionListener{

    JFrame window;

    // text compentents
    JTextArea textArea;
    JScrollPane scrollPane;
    boolean wordWrapOn = false, arialOn = false, comicSansMsOn = false, timesNewRomanOn = false;
    boolean size8On = false, size12On = false, size16On = false, size20On = false, size24On = false, size28On = false;

    // menu bar components
    JMenuBar menuBar;
    JMenu fileM, edit, format, color;
    // file menu
    JMenuItem newFile, openFile, saveFile, saveAsFile, exitFile;
    // format menu
    JMenuItem wrap, arial, comicSansMS, timesNewRoman, size8, size12, size16, size20, size24, size28;
    JMenu fontM, fontSizeM;
    // color menu
    JMenuItem color1, color2, color3;
    // edit menu
    JMenuItem undo, redo;
    
    FileFunctions functionFile = new FileFunctions(this);
    FormatFunctions functionFormat = new FormatFunctions(this);
    EditFunctions functionEdit = new EditFunctions(this);
    ColorFunctions functionColor = new ColorFunctions(this);

    KeyHandler kh = new KeyHandler(this);

    UndoManager um = new UndoManager();


    public static void main(String[] args){
        new GUI();
    }

    public GUI(){
        createWindow();
        createTextArea();
        createMenuBar();

        functionFormat.setFont("Arial");
        functionFormat.createFont(16);
        functionFormat.wordWrap();
        functionColor.setColor("White");

        window.setVisible(true);
        
    }

    public void createWindow(){
        window = new JFrame("Notepad");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void createTextArea(){
        textArea = new JTextArea();
        textArea.addKeyListener(kh);
        textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
            public void undoableEditHappened(UndoableEditEvent e) {
                um.addEdit(e.getEdit());
            }
        });
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);
    }

    public void createMenuBar(){
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        fileM = new JMenu("File");
        menuBar.add(fileM);
        createFileMenu();

        edit = new JMenu("Edit");
        menuBar.add(edit);
        createEditMenu();

        format = new JMenu("Format");
        menuBar.add(format);
        createFormatMenu();

        color = new JMenu("Color");
        menuBar.add(color);
        createColorMenu();
    }

    public void createFileMenu(){
        newFile = new JMenuItem("New                  Ctrl + n");
        newFile.addActionListener(this);
        newFile.setActionCommand("New");
        fileM.add(newFile);

        openFile = new JMenuItem("Open                 Ctrl + o");
        openFile.addActionListener(this);
        openFile.setActionCommand("Open");
        fileM.add(openFile);

        saveFile = new JMenuItem("Save                 Ctrl + s");
        saveFile.addActionListener(this);
        saveFile.setActionCommand("Save");
        fileM.add(saveFile);

        saveAsFile = new JMenuItem("Save As              Ctrl + Shift + s");
        saveAsFile.addActionListener(this);
        saveAsFile.setActionCommand("Save As");
        fileM.add(saveAsFile);

        exitFile = new JMenuItem("Exit");
        exitFile.addActionListener(this);
        exitFile.setActionCommand("Exit");
        fileM.add(exitFile);
    }

    public void createEditMenu(){
        undo = new JMenuItem("Undo                 Ctrl + z");
        undo.addActionListener(this);
        undo.setActionCommand("Undo");
        edit.add(undo);

        redo = new JMenuItem("Redo                 Ctrl + y");
        redo.addActionListener(this);
        redo.setActionCommand("Redo");
        edit.add(redo);
    }

    public void createFormatMenu(){
        wrap = new JMenuItem("[X] Word Wrap");
        wrap.addActionListener(this);
        wrap.setActionCommand("Word Wrap");
        format.add(wrap);

        fontM = new JMenu("Font");
        format.add(fontM);

        arial = new JMenuItem("[✔] Arial");
        arial.addActionListener(this);
        arial.setActionCommand("Arial");
        fontM.add(arial);

        comicSansMS = new JMenuItem("[X] Comic Sans MS");
        comicSansMS.addActionListener(this);
        comicSansMS.setActionCommand("Comic Sans MS");
        fontM.add(comicSansMS);

        timesNewRoman = new JMenuItem("[X] Times New Roman");
        timesNewRoman.addActionListener(this);
        timesNewRoman.setActionCommand("Times New Roman");
        fontM.add(timesNewRoman);

        fontSizeM = new JMenu("Font Size");
        format.add(fontSizeM);
        // size8, size12, size16, size20, size24, size28;

        size8 = new JMenuItem("[✔] 8");
        size8.addActionListener(this);
        size8.setActionCommand("Size 8");
        fontSizeM.add(size8);

        size12 = new JMenuItem("[X] 12"); 
        size12.addActionListener(this);
        size12.setActionCommand("Size 12");
        fontSizeM.add(size12);

        size16 = new JMenuItem("[X] 16"); 
        size16.addActionListener(this);
        size16.setActionCommand("Size 16");
        fontSizeM.add(size16);

        size20 = new JMenuItem("[X] 20"); 
        size20.addActionListener(this);
        size20.setActionCommand("Size 20");
        fontSizeM.add(size20);

        size24 = new JMenuItem("[X] 24"); 
        size24.addActionListener(this);
        size24.setActionCommand("Size 24");
        fontSizeM.add(size24);

        size28 = new JMenuItem("[X] 28"); 
        size28.addActionListener(this);
        size28.setActionCommand("Size 28");
        fontSizeM.add(size28);
    }
    
    public void createColorMenu(){
        color1 = new JMenuItem("[✔] White");
        color1.addActionListener(this);
        color1.setActionCommand("White");
        color.add(color1);

        color2 = new JMenuItem("[X] Black");
        color2.addActionListener(this);
        color2.setActionCommand("Black");
        color.add(color2);

        color3 = new JMenuItem("[X] Blue");
        color3.addActionListener(this);
        color3.setActionCommand("Blue");
        color.add(color3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch(command){
            case "New":
                functionFile.newFile();
                break;
            case "Open":
                functionFile.openFile();
                break;
            case "Save":
                functionFile.saveFile();
                break;
            case "Save As":
                functionFile.saveAsFile();
                break;
            case "Exit":
                functionFile.exitFile();
                break;
            case "Word Wrap":
                functionFormat.wordWrap();
                break;
            case "Arial":
                functionFormat.setFont("Arial");
                break;
            case "Comic Sans MS":
                functionFormat.setFont("Comic Sans MS");
                break;
            case "Times New Roman":
                functionFormat.setFont("Times New Roman");
                break;
            case "Size 8":
                functionFormat.createFont(8);
                break;
            case "Size 12":
                functionFormat.createFont(12);
                break;
            case "Size 16":
                functionFormat.createFont(16);
                break;
            case "Size 20":
                functionFormat.createFont(20);
                break;
            case "Size 24":
                functionFormat.createFont(24);
                break;
            case "Size 28":
                functionFormat.createFont(28);
                break;
            case "White":
                functionColor.setColor("White");
                break;
            case "Black":
                functionColor.setColor("Black");
                break;
            case "Blue":
                functionColor.setColor("Blue");
                break;
            case "Undo":
                functionEdit.undo();
                break;
            case "Redo":
                functionEdit.redo();
        }
    }
}