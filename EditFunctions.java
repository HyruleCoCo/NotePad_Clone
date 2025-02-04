
public class EditFunctions {
    GUI gui;

    public EditFunctions(GUI gui){
        this.gui = gui;
    }

    public void undo(){
        gui.um.undo();
    }

    public void redo(){
        gui.um.redo();
    }
}
