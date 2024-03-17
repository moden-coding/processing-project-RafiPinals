import processing.core.*;

public class Bullet {
    float x;
    float y;
    PApplet canvas;
    boolean fired;
    int size;
//creates bullet with set size and variables for position
    public Bullet(PApplet p, float x, float y) {
        this.x = x;
        this.y = y;
        canvas = p;
        size = 2;
    }
    //shows asteroid on canvas
    public void display(){
        canvas.ellipse(x, y, size, size);
    }
    //moves asteroid up 7 pixels a frame x does not move 
    public void move(){
        y -= 7;
    }
}
