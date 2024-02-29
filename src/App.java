import processing.core.*;

public class App extends PApplet {
    public static void main(String[] args) {
        PApplet.main("App");
    }

    private int rocketx = 50;
    private float bulletheight = 570;

    public void setup() {

    }

    public void settings() {
        size(800, 700);
    }

    public void drawtrack() {
        stroke(200);
        strokeWeight(1);
        line(0, 600, 800, 600);
    }

    public void drawTriangle() {
        stroke(255, 255, 255);
        strokeWeight(3);
        fill(0, 0, 0);
        triangle(rocketx, 570, (rocketx - 15), 620, (rocketx + 15), 620);

    }

    public void keyPressed() {
        if (keyCode == RIGHT) {
            rocketMove(7);
        }
        if (keyCode == LEFT) {
            rocketMove(-7);
        }
        if (keyCode == ' ') {
            drawbullet();
            System.out.println("bullet");
        }

    }

    public void drawbullet() {
        stroke(255);
        fill(255);
        ellipse((rocketx), bulletheight, 3, 3);
    }



    public void bulletheightmeth() {
        while (true) {
            bulletheight--;
            if (bulletheight < 50) {
                break;
            }
        }
    }

    public void rocketMove(int moveAmount) {
        rocketx += moveAmount;

        if (rocketx > 800) {
            rocketx = 5;
        }
        if (rocketx < 0) {
            rocketx = 795;
        }
    }

    @Override
    public void draw() {
        drawbullet();
        background(0);
        drawtrack();
        drawTriangle();

    }
}
