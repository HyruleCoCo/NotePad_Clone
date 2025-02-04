import java.awt.event.*;

public class KeyHandler implements KeyListener{
    GUI gui;
    int menuSelect = 0;

    public KeyHandler(GUI gui){
        this.gui = gui;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // unused
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S){// save
            gui.functionFile.saveFile();
        }

        if(e.isControlDown() && e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_S){// save as
            gui.functionFile.saveAsFile();
        }

        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_N){// new
            gui.functionFile.newFile();
        }

        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_N){// open
            gui.functionFile.openFile();
        }

        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Z){// undo
            gui.functionEdit.undo();
        }
        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Y){// redo
            gui.functionEdit.redo();
        }
        if(e.isAltDown() && e.getKeyCode() == KeyEvent.VK_F){// open file menu
            gui.fileM.doClick();
        }
        if(e.isAltDown() && e.getKeyCode() == KeyEvent.VK_E){// open edit menu
            gui.edit.doClick();
        }
        if(e.isAltDown() && e.getKeyCode() == KeyEvent.VK_C){// open file menu
            gui.color.doClick();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // unused
    }
    
}
