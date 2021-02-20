package task8.observer;

public class ThirdObserver extends Observer{

    public ThirdObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Third Observer got info");
    }
}
