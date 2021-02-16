package task8.observer;

public class FirstObserver extends Observer{

    public FirstObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("First Observer got info");
    }
}
