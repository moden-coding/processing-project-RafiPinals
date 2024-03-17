import processing.core.*;

public class Asteroid {
    PApplet canvas;
    int x;
    int y;
    boolean missed;
    Boolean missedNoCount;
    int size;
    int dx;
    int dy;
    
// creates asteroid in class with random size speed and direction
    public Asteroid(PApplet p, int x, int y) {
        this.x = x;
        this.y = y;
        canvas = p;
        size = (int) canvas.random(110) + 50;
        dx = (int)canvas.random(10)- 5;
        dy = (int)canvas.random(5) + 5;
    }
//creates circle in main canvas
    public void display() {
        canvas.ellipse(x, y, size, size);
    
    }

//x and y of rocket change by speed dx and dy
    public void move(){
        x += dx;
        y += dy;
    }
//creates range of values of the rocket and checks if an asteroid is colliding
    public boolean isHittingPlayer(int rocketx) {
        float minX = rocketx - 25;
        float maxX = rocketx + 25;
        float minY = 535;
        float maxY = 655;
        if (x >= minX && x <= maxX && y >= minY && y <= maxY) {
            return true;
        }
        
        return false;
    }
    //takes radius of asteroid and uses distance function to check if a bullet is colliding
    public boolean isTouchingBullet(Bullet b){
        if((float)canvas.dist(b.x, b.y, this.x, this.y)<=(size/2+2)){
            return true;
        }
        else{
            return false;
        }
        

    }
//checks if an asteroid is missed in the window, if its outside of the window count doesnt go up
    public void isOffScreenCheck(){
        if (this.y > 700) {
            if (this.x < 0 || this.x > 800) {
                missedNoCount = true;
            } else {
                missed = true;
            }
        } else {
            missed = false;
            missedNoCount = false;
        }
    }
//returns values of last method to app class
    public boolean isOffScreenMissable(){
        return missed;
    }
    public boolean isOffScreenNotMissable(){
        return missedNoCount;
    }

}
