import java.awt.*;

public class ColorFunctions {
    
    GUI gui;

    public ColorFunctions(GUI gui) {
        this.gui = gui;
    }

    public void setColor(String color){
        switch(color){
            case "White":
                gui.window.getContentPane().setBackground(Color.white);
                gui.textArea.setBackground(Color.white);
                gui.textArea.setForeground(Color.black);// font color
                gui.color1.setText("[✔] White");
                gui.color2.setText("[X] Black");
                gui.color3.setText("[X] Blue");
                break;
                case "Black":
                gui.window.getContentPane().setBackground(Color.black);
                gui.textArea.setBackground(Color.black);
                gui.textArea.setForeground(Color.white);// font color
                gui.color1.setText("[X] White");
                gui.color2.setText("[✔] Black");
                gui.color3.setText("[X] Blue");
                break;   
                case "Blue":
                gui.window.getContentPane().setBackground(Color.blue);// seting with rgb would look like new Color(28, 186, 186)
                gui.textArea.setBackground(Color.blue);
                gui.textArea.setForeground(Color.yellow);// font color
                gui.color1.setText("[X] White");
                gui.color2.setText("[X] Black");
                gui.color3.setText("[✔] Blue");
                break;           
        }
    }

}
