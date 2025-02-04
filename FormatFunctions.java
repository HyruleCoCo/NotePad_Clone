import java.awt.*;

public class FormatFunctions {
    GUI gui;
    Font arial, comicSansMS, timesNewRoman;
    String selectedFont = "";
    

    public FormatFunctions(GUI gui){
        this.gui = gui;
    }

    public void wordWrap() {
        if(!gui.wordWrapOn){
            gui.wordWrapOn = true;
            gui.textArea.setLineWrap(true);
            gui.textArea.setWrapStyleWord(true);
            gui.wrap.setText("[✔] WordWrap");
        }
        else if(gui.wordWrapOn){
            gui.wordWrapOn = false;
            gui.textArea.setLineWrap(false);
            gui.wrap.setText("[X] WordWrap");
        }
    }

    public void createFont(int fontSize){
        arial = new Font("Arial", Font.PLAIN, fontSize);
        comicSansMS = new Font("Comic Sans MS", Font.PLAIN, fontSize);
        timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);

        switch (fontSize) {
            case 8:
                gui.size8.setText("[✔] Size 8");
                gui.size12.setText("[X] Size 12");
                gui.size16.setText("[X] Size 16");
                gui.size20.setText("[X] Size 20");
                gui.size24.setText("[X] Size 24");
                gui.size28.setText("[X] Size 28");
                break;
            case 12:
                gui.size8.setText("[X] Size 8");
                gui.size12.setText("[✔] Size 12");
                gui.size16.setText("[X] Size 16");
                gui.size20.setText("[X] Size 20");
                gui.size24.setText("[X] Size 24");
                gui.size28.setText("[X] Size 28");
                break;
            case 16:
                gui.size8.setText("[X] Size 8");
                gui.size12.setText("[X] Size 12");
                gui.size16.setText("[✔] Size 16");
                gui.size20.setText("[X] Size 20");
                gui.size24.setText("[X] Size 24");
                gui.size28.setText("[X] Size 28");
                break;
            case 20:
                gui.size8.setText("[X] Size 8");
                gui.size12.setText("[X] Size 12");
                gui.size16.setText("[X] Size 16");
                gui.size20.setText("[✔] Size 20");
                gui.size24.setText("[X] Size 24");
                gui.size28.setText("[X] Size 28");
                break;
            case 24:
                gui.size8.setText("[X] Size 8");
                gui.size12.setText("[X] Size 12");
                gui.size16.setText("[X] Size 16");
                gui.size20.setText("[X] Size 20");
                gui.size24.setText("[✔] Size 24");
                gui.size28.setText("[X] Size 28");
                break;
            case 28:
                gui.size8.setText("[X] Size 8");
                gui.size12.setText("[X] Size 12");
                gui.size16.setText("[X] Size 16");
                gui.size20.setText("[X] Size 20");
                gui.size24.setText("[X] Size 24");
                gui.size28.setText("[✔] Size 28");
                break;
        }

        setFont(selectedFont);// makes sure the text reloads with the new size
    }

    public void setFont(String font){
        selectedFont = font;

        switch(selectedFont){
            case "Arial":
                gui.textArea.setFont(arial);
                gui.arial.setText("[✔] Arial");
                gui.comicSansMS.setText("[X] Comic Sans MS");
                gui.timesNewRoman.setText("[X] Times New Roman");
                break;
            case "Comic Sans MS":
                gui.textArea.setFont(comicSansMS);
                gui.arial.setText("[X] Arial");
                gui.comicSansMS.setText("[✔] Comic Sans MS");
                gui.timesNewRoman.setText("[X] Times New Roman");
                break;
            case "Times New Roman":
                gui.textArea.setFont(timesNewRoman);
                gui.arial.setText("[X] Arial");
                gui.comicSansMS.setText("[X] Comic Sans MS");
                gui.timesNewRoman.setText("[✔] Times New Roman");
                break;
        }
    }
}