package task8.observer;

public class SecondObserver extends Observer{

    public SecondObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Second Observer got info");
    }
}
