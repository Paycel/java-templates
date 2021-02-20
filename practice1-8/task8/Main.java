package task8;

import task8.memento.Editor;
import task8.memento.Originator;
import task8.observer.FirstObserver;
import task8.observer.SecondObserver;
import task8.observer.Subject;
import task8.observer.ThirdObserver;

public class Main {
    /*
    Паттерны Снимок, Наблюдатель.
     */
    public static void main(String[] args) {
        Editor editor = new Editor(new Originator());
        editor.write("Hello, World!");
        editor.write("\n123");
        editor.hitSave();
        editor.write("This will be deleted");
        editor.hitUndo();
        editor.print();

        Subject subject = new Subject();
        new FirstObserver(subject);
        new SecondObserver(subject);
        new ThirdObserver(subject);
        System.out.println("Let's make a change");
        subject.setState(1);
        System.out.println("One more");
        subject.setState(2);
    }
}
