package task8.memento;

public class Editor {
    private Originator text;
    private Memento save;

    public Editor(Originator text) {
        this.text = text;
    }

    public void write(String text){
        this.text.addText(text);
    }

    public void print(){
        System.out.println(text.getCurrentText());
    }

    public void hitSave(){
        save = text.save();
    }

    public void hitUndo(){
        text.restore(save);
    }
}
