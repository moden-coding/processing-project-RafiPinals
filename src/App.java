import java.util.ArrayList;

import processing.core.*;

public class App extends PApplet {
    public static void main(String[] args) {
        PApplet.main("App");
    }

    private int rocketx = 50;
    private boolean left_key = false;
    private boolean right_key = false;
    private int score = 0;
    private int missed = 0;
    ArrayList<Bullet> bullets;
    ArrayList<Asteroid> asteroids;
    private boolean running = true;

    public void setup() {
        bullets = new ArrayList<>();
        asteroids = new ArrayList<>();
    }

    public void settings() {
        size(800, 700);
    }

    // Line that rocket moves along
    public void drawtrack() {
        stroke(200);
        strokeWeight(1);
        line(0, 600, 800, 600);
    }

    // Line that shows where asteroids are missed
    public void drawDeathline() {
        stroke(200, 0, 0);
        strokeWeight(5);
        line(0, 700, 800, 700);
    }

    // rocket
    public void drawTriangle() {
        stroke(255, 255, 255);
        strokeWeight(5);
        fill(0, 0, 0);
        triangle(rocketx, 555, (rocketx - 20), 635, (rocketx + 20), 635);
    }

    // detects key pressed and sets boolean
    public void keyPressed() {
        if (keyCode == RIGHT) {
            right_key = true;
        }
        if (keyCode == LEFT) {
            left_key = true;
        }

        if (keyCode == ' ') {
            Bullet b = new Bullet(this, rocketx, 555);
            bullets.add(b);
        }

        if (key == 'r' && !running) {
            running = true;
            score = 0;
            missed = 0;
        }
    }

    // detects key released and sets boolean opposite of keyPressed
    public void keyReleased() {
        if (keyCode == RIGHT) {
            right_key = false;
        }
        if (keyCode == LEFT) {
            left_key = false;
        }
    }

    // How the Rocket moves and how it appears on other side of the screen if you go
    // through edge of window
    public void rocketMove(int moveAmount) {
        rocketx += moveAmount;

        if (rocketx > 800) {
            rocketx = 5;
        }
        if (rocketx < 0) {
            rocketx = 795;
        }
    }

    // score displayed while playing
    public void score() {
        fill(0, 255, 0);
        textSize(32);
        textAlign(LEFT);
        text("Asteroids hit: " + score, 35, 45);
    }

    // missed-score displayed while playing
    public void missed() {
        fill(255, 0, 0);
        textSize(32);
        textAlign(RIGHT);
        text("Asteroids missed: " + missed, 760, 45);
    }

    // text saying you lost
    public void gameOver_screen() {
        fill(255);
        textSize(100);
        textAlign(CENTER);
        text("GAME OVER", 400, 300);
    }

    // score that displays when you lose
    public void gameOver_Hitscore() {
        fill(0, 255, 0);
        textSize(25);
        textAlign(CENTER);
        text("Asteroids Hit: " + score, 400, 340);
    }

    // missed-score that displays when you lose
    public void gameOver_missed() {
        fill(255, 0, 0);
        textSize(25);
        textAlign(CENTER);
        text("Asteroids Missed: " + missed, 400, 375);
    }

    // overall score that displays when you lose, color dependent on sign of number
    public void gameOver_ScoreOverall() {
        int PassingR;
        int PassingG;
        int PassingB;
        if ((score - missed) < 0) {
            PassingR = 255;
            PassingG = 0;
            PassingB = 0;
        } else if (score - missed == 0) {
            PassingR = 255;
            PassingG = 255;
            PassingB = 255;
        } else {
            PassingR = 0;
            PassingG = 255;
            PassingB = 0;
        }
        fill(PassingR, PassingG, PassingB);
        textSize(50);
        textAlign(CENTER);
        text("Overall Score: " + (score - missed), 400, 425);
    }

    // text that instructs to press r to reset
    public void gameOver_reset() {
        fill(255, 0, 0);
        textSize(25);
        textAlign(CENTER);
        text("Hit 'r' to reset", 400, 650);
    }

    @Override
    // MAIN DRAW FUNCTION
    public void draw() {
        background(0);
        // What is happening if the game is not running (all the lose screen methods)
        if (!running) {
            asteroids.clear();
            bullets.clear();
            gameOver_screen();
            gameOver_Hitscore();
            gameOver_missed();
            gameOver_ScoreOverall();
            gameOver_reset();
            // if the game is running,
        } else {
            drawtrack();
            drawDeathline();
            drawTriangle();
            // uses keyPressed and keyReleased booleans and sets moveAmount used above
            if (right_key == true) {
                rocketMove(7);
            }
            if (left_key == true) {
                rocketMove(-7);
            }
            // generates a random number between 1 and 100 and if its below 6 it'll produce
            // an asteroid (5% of the time)
            if (random(100) < 6) {
                Asteroid a = new Asteroid(this, (int) random(0, 800), -50);
                asteroids.add(a);
            }
            // updates bullet positions and displays from the array
            for (int i = 0; i < bullets.size(); i++) {
                Bullet b = bullets.get(i);
                b.display();
                b.move();
                // checks to see if asteroid and bullet are colliding and changes score
                // accordingly
                for (int ind = 0; ind < asteroids.size(); ind++) {
                    Asteroid a = asteroids.get(ind);
                    if (a.isTouchingBullet(b)) {
                        asteroids.remove(a);
                        bullets.remove(b);
                        score++;
                    }

                }
            }
            // displays asteroids from array list,
            for (int ind = 0; ind < asteroids.size(); ind++) {
                Asteroid a = asteroids.get(ind);
                a.move();
                a.display();
                a.isOffScreenCheck();
                // checks if asteroid is missed
                if (a.isOffScreenMissable()) {
                    asteroids.remove(a);
                    missed++;
                } else if (a.isOffScreenNotMissable()) {
                    asteroids.remove(ind);
                }
            }
            // checks rocket-asteroid collisions, and updates game running boolean
            for (int i = 0; i < asteroids.size(); i++) {
                Asteroid a = asteroids.get(i);

                if (a.isHittingPlayer(rocketx)) {
                    running = false;
                }

            }
        }

        // displays in game scores
        score();
        missed();

    }
}
