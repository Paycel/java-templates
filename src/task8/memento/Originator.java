package task8.memento;

public class Originator {
    private StringBuilder currentText;

    public Originator() {
        currentText = new StringBuilder();
    }

    public String getCurrentText() {
        return currentText.toString();
    }

    public void addText(String text){
        currentText.append(text);
    }

    public Memento save(){
        return new Memento(currentText.toString());
    }

    public void restore(Memento save){
        currentText = new StringBuilder(save.getText());
    }
}
