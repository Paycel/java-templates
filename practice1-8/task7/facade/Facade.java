package task7.facade;

public class Facade {
    Shape shape;

    public Facade() {
    }

    public void draw(ShapeType type){
        switch (type) {
            case Circle: shape = new Circle();
            case Rectangle: shape = new Rectangle();
            case Square: shape = new Square();
        }
        shape.draw();
    }
}
