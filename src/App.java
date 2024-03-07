import processing.core.*;

public class App extends PApplet {
    public static void main(String[] args) {
        PApplet.main("App");
    }

    private int rocketx = 50;
    private float bullet1_y = 565;
    private float bullet2_y = 565;
    private float bullet3_y = 565;
    private float bullet4_y = 565;
    private float bullet5_y = 565;
    private float bullet6_y = 565;
    private float bullet7_y = 565;
    private float bullet1_x = rocketx;
    private float bullet2_x = rocketx;
    private float bullet3_x = rocketx;
    private float bullet4_x = rocketx;
    private float bullet5_x = rocketx;
    private float bullet6_x = rocketx;
    private float bullet7_x = rocketx;
    private boolean bullet_fired_1;
    private boolean bullet_fired_2;
    private boolean bullet_fired_3;
    private boolean bullet_fired_4;
    private boolean bullet_fired_5;
    private boolean bullet_fired_6;
    private boolean bullet_fired_7;
    private boolean left_key = false;
    private boolean right_key = false;
    private float asteroidx_1 = random(0, 800);
    private float asteroidx_2 = random(0, 800);
    private float asteroidx_3 = random(0, 800);
    private float asteroidx_4 = random(0, 800);
    private float asteroidx_5 = random(0, 800);
    private float asteroidy_1;
    private float asteroidy_2;
    private float asteroidy_3;
    private float asteroidy_4;
    private float asteroidy_5;
    private float rand_asteroid_size_1 = random(40, 150);
    private float randX_asteroid_speed_1 = random(-5, 5);
    private float randY_asteroid_speed_1 = random(0, 7);
    private float rand_asteroid_size_2 = random(40, 150);
    private float randX_asteroid_speed_2 = random(-5, 5);
    private float randY_asteroid_speed_2 = random(0, 7);
    private float rand_asteroid_size_3 = random(40, 150);
    private float randX_asteroid_speed_3 = random(-5, 5);
    private float randY_asteroid_speed_3 = random(0, 7);
    private float rand_asteroid_size_4 = random(40, 150);
    private float randX_asteroid_speed_4 = random(-5, 5);
    private float randY_asteroid_speed_4 = random(0, 7);
    private float rand_asteroid_size_5 = random(40, 150);
    private float randX_asteroid_speed_5 = random(-5, 5);
    private float randY_asteroid_speed_5 = random(0, 7);
    private int score = 0;
    private int missed = 0;
    boolean AstMissed1 = false;
    boolean AstMissed2 = false;
    boolean AstMissed3 = false;
    boolean AstMissed4 = false;
    boolean AstMissed5 = false;

    private boolean running = true;

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

    public void drawDeathline() {
        stroke(200, 0, 0);
        strokeWeight(5);
        line(0, 700, 800, 700);
    }

    public void drawTriangle() {
        stroke(255, 255, 255);
        strokeWeight(5);
        fill(0, 0, 0);
        triangle(rocketx, 555, (rocketx - 20), 635, (rocketx + 20), 635);
    }

    public void keyPressed() {
        if (keyCode == RIGHT) {
            right_key = true;
        }
        if (keyCode == LEFT) {
            left_key = true;
        }

        if (keyCode == ' ') {
            releasebullet();
            System.out.println("bullet");

        }

        // If it hits sides, it bounces off (make speed negative) if it hits bottom
        // add power ups

        if (key == 'r' && !running) {
            running = true;
            score = 0;
            missed = 0;
            asteroidx_1 = random(0, 800);
            asteroidy_1 = -150;
            randX_asteroid_speed_1 = random(-5, 5);
            randY_asteroid_speed_1 = random(0, 7);
            rand_asteroid_size_1 = random(40, 150);
            asteroidx_2 = random(0, 800);
            asteroidy_2 = -150;
            randX_asteroid_speed_2 = random(-5, 5);
            randY_asteroid_speed_2 = random(0, 7);
            rand_asteroid_size_2 = random(40, 150);
            asteroidx_3 = random(0, 800);
            asteroidy_3 = -150;
            randX_asteroid_speed_3 = random(-5, 5);
            randY_asteroid_speed_3 = random(0, 7);
            rand_asteroid_size_3 = random(40, 150);
            asteroidx_4 = random(0, 800);
            asteroidy_4 = -150;
            randX_asteroid_speed_4 = random(-5, 5);
            randY_asteroid_speed_4 = random(0, 7);
            rand_asteroid_size_4 = random(40, 150);
            asteroidx_5 = random(0, 800);
            asteroidy_5 = -150;
            randX_asteroid_speed_5 = random(-5, 5);
            randY_asteroid_speed_5 = random(0, 7);
            rand_asteroid_size_5 = random(40, 150);
            bullet1_y = 565;
            bullet_fired_1 = false;
            bullet2_y = 565;
            bullet_fired_2 = false;
            bullet3_y = 565;
            bullet_fired_4 = false;
            bullet5_y = 565;
            bullet_fired_5 = false;
            bullet6_y = 565;
            bullet_fired_6 = false;
            bullet7_y = 565;
            bullet_fired_7 = false;
        }
    }

    public void keyReleased() {
        if (keyCode == RIGHT) {
            right_key = false;
        }
        if (keyCode == LEFT) {
            left_key = false;
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

    public void releasebullet() {
        if (bullet1_y == 565) {
            bullet_fired_1 = true;
            drawbullet1();
        } else if (bullet2_y == 565) {
            bullet_fired_2 = true;
            drawbullet2();
        } else if (bullet3_y == 565) {
            bullet_fired_3 = true;
            drawbullet3();
        } else if (bullet4_y == 565) {
            bullet_fired_4 = true;
            drawbullet4();
        } else if (bullet5_y == 565) {
            bullet_fired_5 = true;
            drawbullet5();
        } else if (bullet6_y == 565) {
            bullet_fired_6 = true;
            drawbullet6();
        } else if (bullet7_y == 565) {
            bullet_fired_7 = true;
            drawbullet7();
        }
    }

    public void drawbullet1() {
        stroke(0, 255, 255);
        fill(0, 255, 255);
        ellipse((bullet1_x), bullet1_y, 3, 3);
        bullet1_y = bullet1_y - 7;
        if (bullet1_y < 2) {
            bullet1_y = 565;
            bullet_fired_1 = false;
        }
    }

    public void drawbullet2() {
        stroke(0, 255, 255);
        fill(0, 255, 255);
        ellipse((bullet2_x), bullet2_y, 3, 3);
        bullet2_y = bullet2_y - 7;
        if (bullet2_y < 2) {
            bullet2_y = 565;
            bullet_fired_2 = false;
        }
    }

    public void drawbullet3() {
        stroke(0, 255, 255);
        fill(0, 255, 255);
        ellipse((bullet3_x), bullet3_y, 3, 3);
        bullet3_y = bullet3_y - 7;
        if (bullet3_y < 2) {
            bullet3_y = 565;
            bullet_fired_3 = false;
        }
    }

    public void drawbullet4() {
        stroke(0, 255, 255);
        fill(0, 255, 255);
        ellipse((bullet4_x), bullet4_y, 3, 3);
        bullet4_y = bullet4_y - 7;
        if (bullet4_y < 2) {
            bullet4_y = 565;
            bullet_fired_4 = false;
        }
    }

    public void drawbullet5() {
        stroke(0, 255, 255);
        fill(0, 255, 255);
        ellipse((bullet5_x), bullet5_y, 3, 3);
        bullet5_y = bullet5_y - 7;
        if (bullet5_y < 2) {
            bullet5_y = 565;
            bullet_fired_5 = false;
        }
    }

    public void drawbullet6() {
        stroke(0, 255, 255);
        fill(0, 255, 255);
        ellipse((bullet6_x), bullet6_y, 3, 3);
        bullet6_y = bullet6_y - 7;
        if (bullet6_y < 2) {
            bullet6_y = 565;
            bullet_fired_6 = false;
        }
    }

    public void drawbullet7() {
        stroke(0, 255, 255);
        fill(0, 255, 255);
        ellipse((bullet7_x), bullet7_y, 3, 3);
        bullet7_y = bullet7_y - 7;
        if (bullet7_y < 2) {
            bullet7_y = 565;
            bullet_fired_7 = false;
        }
    }

    public void drawAsteroid_1() {
        stroke(255);
        fill(0);
        strokeWeight(2);
        ellipse(asteroidx_1, asteroidy_1, rand_asteroid_size_1, rand_asteroid_size_1);
        asteroidx_1 = asteroidx_1 + randX_asteroid_speed_1;
        asteroidy_1 = asteroidy_1 + randY_asteroid_speed_1;
    
        
        if (asteroidx_1 < -150) {
            asteroidx_1 = 950;
        }
        if (asteroidx_1 > 950) {
            asteroidx_1 = -150;
        }
        if (asteroidy_1 > 850) {
            if(asteroidx_1 > 0 && asteroidx_1 < 800){
                missed++;
            }
            asteroidx_1 = random(0, 800);
            asteroidy_1 = -150;
            randX_asteroid_speed_1 = random(-5, 5);
            randY_asteroid_speed_1 = random(0, 7);
            rand_asteroid_size_1 = random(40, 150);
        }

    }

    

    public void drawAsteroid_2() {
        stroke(255);
        fill(0);
        strokeWeight(2);
        ellipse(asteroidx_2, asteroidy_2, rand_asteroid_size_2, rand_asteroid_size_2);
        asteroidx_2 = asteroidx_2 + randX_asteroid_speed_2;
        asteroidy_2 = asteroidy_2 + randY_asteroid_speed_2;
        
        if (asteroidx_2 < -150) {
            asteroidx_2 = 950;
        }
        if (asteroidx_2 > 950) {
            asteroidx_2 = -150;
        }
        if (asteroidy_2 > 850) {
            if(asteroidx_2 > 0 && asteroidx_2 < 800){
                missed++;
            }
            asteroidx_2 = random(0, 800);
            asteroidy_2 = -150;
            randX_asteroid_speed_2 = random(-5, 5);
            randY_asteroid_speed_2 = random(0, 7);
            rand_asteroid_size_2 = random(40, 150);
        }
    }

    public void drawAsteroid_3() {
        stroke(255);
        fill(0);
        strokeWeight(2);
        ellipse(asteroidx_3, asteroidy_3, rand_asteroid_size_3, rand_asteroid_size_3);
        asteroidx_3 = asteroidx_3 + randX_asteroid_speed_3;
        asteroidy_3 = asteroidy_3 + randY_asteroid_speed_3;
        if (asteroidx_3 < -150) {
            asteroidx_3 = 950;
        }
        if (asteroidx_3 > 950) {
            asteroidx_3 = -150;
        }
        if (asteroidy_3 > 850) {
            if(asteroidx_3 > 0 && asteroidx_3 < 800){
                missed++;
            }
            asteroidx_3 = random(0, 800);
            asteroidy_3 = -150;
            randX_asteroid_speed_3 = random(-5, 5);
            randY_asteroid_speed_3 = random(0, 7);
            rand_asteroid_size_3 = random(40, 150);
        }

    }

    public void drawAsteroid_4() {
        stroke(255);
        fill(0);
        strokeWeight(2);
        ellipse(asteroidx_4, asteroidy_4, rand_asteroid_size_4, rand_asteroid_size_4);
        asteroidx_4 = asteroidx_4 + randX_asteroid_speed_4;
        asteroidy_4 = asteroidy_4 + randY_asteroid_speed_4;
        
        if (asteroidx_4 < -150) {
            asteroidx_4 = 950;
        }
        if (asteroidx_4 > 950) {
            asteroidx_4 = -150;
        }
        if (asteroidy_4 > 850) {
            if(asteroidx_4 > 0 && asteroidx_4 < 800){
                missed++;
            }
            asteroidx_4 = random(0, 800);
            asteroidy_4 = -150;
            randX_asteroid_speed_4 = random(-5, 5);
            randY_asteroid_speed_4 = random(0, 7);
            rand_asteroid_size_4 = random(40, 150);
        }

    }

    public void drawAsteroid_5() {
        stroke(255);
        fill(0);
        strokeWeight(2);
        ellipse(asteroidx_5, asteroidy_5, rand_asteroid_size_5, rand_asteroid_size_5);
        asteroidx_5 = asteroidx_5 + randX_asteroid_speed_5;
        asteroidy_5 = asteroidy_5 + randY_asteroid_speed_5;
        
        if (asteroidx_5 < -150) {
            asteroidx_5 = 950;
        }
        if (asteroidx_5 > 950) {
            asteroidx_5 = -150;
        }
        if (asteroidy_5 > 850) {
            if(asteroidx_5 > 0 && asteroidx_1 < 800){
                missed++;
            }
            asteroidx_5 = random(0, 800);
            asteroidy_5 = -150;
            randX_asteroid_speed_5 = random(-5, 5);
            randY_asteroid_speed_5 = random(0, 7);
            rand_asteroid_size_5 = random(40, 150);
        }

    }

    // in variable names, first number is asteroid number, second is bullet number
    // (i.e. distance_15 is distance between asteroid 1 and bullet 5)
    public boolean distance_1_b() {
        float distance_11 = dist(asteroidx_1, asteroidy_1, bullet1_x, bullet1_y);
        float distance_12 = dist(asteroidx_1, asteroidy_1, bullet2_x, bullet2_y);
        float distance_13 = dist(asteroidx_1, asteroidy_1, bullet3_x, bullet3_y);
        float distance_14 = dist(asteroidx_1, asteroidy_1, bullet4_x, bullet4_y);
        float distance_15 = dist(asteroidx_1, asteroidy_1, bullet5_x, bullet5_y);
        float distance_16 = dist(asteroidx_1, asteroidy_1, bullet6_x, bullet6_y);
        float distance_17 = dist(asteroidx_1, asteroidy_1, bullet7_x, bullet7_y);
        if (distance_11 <= (rand_asteroid_size_1 / 2 + 2)) {
            bullet1_y = 565;
            bullet_fired_1 = false;
            return true;
        }
        if (distance_12 <= (rand_asteroid_size_1 / 2 + 2)) {
            bullet2_y = 565;
            bullet_fired_2 = false;
            return true;
        }
        if (distance_13 <= (rand_asteroid_size_1 / 2 + 2)) {
            bullet3_y = 565;
            bullet_fired_3 = false;
            return true;
        }
        if (distance_14 <= (rand_asteroid_size_1 / 2 + 2)) {
            bullet4_y = 565;
            bullet_fired_4 = false;
            return true;
        }
        if (distance_15 <= (rand_asteroid_size_1 / 2 + 2)) {
            bullet5_y = 565;
            bullet_fired_5 = false;
            return true;
        }
        if (distance_16 <= (rand_asteroid_size_1 / 2 + 2)) {
            bullet6_y = 565;
            bullet_fired_6 = false;
            return true;
        }
        if (distance_17 <= (rand_asteroid_size_1 / 2 + 2)) {
            bullet7_y = 565;
            bullet_fired_7 = false;
            return true;
        }

        else {
            return false;
        }
    }

    public boolean distance_2_b() {
        float distance_21 = dist(asteroidx_2, asteroidy_2, bullet1_x, bullet1_y);
        float distance_22 = dist(asteroidx_2, asteroidy_2, bullet2_x, bullet2_y);
        float distance_23 = dist(asteroidx_2, asteroidy_2, bullet3_x, bullet3_y);
        float distance_24 = dist(asteroidx_2, asteroidy_2, bullet4_x, bullet4_y);
        float distance_25 = dist(asteroidx_2, asteroidy_2, bullet5_x, bullet5_y);
        float distance_26 = dist(asteroidx_2, asteroidy_2, bullet6_x, bullet6_y);
        float distance_27 = dist(asteroidx_2, asteroidy_2, bullet7_x, bullet7_y);
        if (distance_21 <= (rand_asteroid_size_2 / 2 + 2)) {
            bullet1_y = 565;
            bullet_fired_1 = false;
            return true;
        }
        if (distance_22 <= (rand_asteroid_size_2 / 2 + 2)) {
            bullet2_y = 565;
            bullet_fired_2 = false;
            return true;
        }
        if (distance_23 <= (rand_asteroid_size_2 / 2 + 2)) {
            bullet3_y = 565;
            bullet_fired_3 = false;
            return true;
        }
        if (distance_24 <= (rand_asteroid_size_2 / 2 + 2)) {
            bullet4_y = 565;
            bullet_fired_4 = false;
            return true;
        }
        if (distance_25 <= (rand_asteroid_size_2 / 2 + 2)) {
            bullet5_y = 565;
            bullet_fired_5 = false;
            return true;
        }
        if (distance_26 <= (rand_asteroid_size_2 / 2 + 2)) {
            bullet6_y = 565;
            bullet_fired_6 = false;
            return true;
        }
        if (distance_27 <= (rand_asteroid_size_2 / 2 + 2)) {
            bullet7_y = 565;
            bullet_fired_7 = false;
            return true;
        }

        else {
            return false;
        }
    }

    public boolean distance_3_b() {
        float distance_31 = dist(asteroidx_3, asteroidy_3, bullet1_x, bullet1_y);
        float distance_32 = dist(asteroidx_3, asteroidy_3, bullet2_x, bullet2_y);
        float distance_33 = dist(asteroidx_3, asteroidy_3, bullet3_x, bullet3_y);
        float distance_34 = dist(asteroidx_3, asteroidy_3, bullet4_x, bullet4_y);
        float distance_35 = dist(asteroidx_3, asteroidy_3, bullet5_x, bullet5_y);
        float distance_36 = dist(asteroidx_3, asteroidy_3, bullet6_x, bullet6_y);
        float distance_37 = dist(asteroidx_3, asteroidy_3, bullet7_x, bullet7_y);
        if (distance_31 <= (rand_asteroid_size_3 / 2 + 2)) {
            bullet1_y = 565;
            bullet_fired_1 = false;
            return true;
        }
        if (distance_32 <= (rand_asteroid_size_3 / 2 + 2)) {
            bullet2_y = 565;
            bullet_fired_2 = false;
            return true;
        }
        if (distance_33 <= (rand_asteroid_size_3 / 2 + 2)) {
            bullet3_y = 565;
            bullet_fired_3 = false;
            return true;
        }
        if (distance_34 <= (rand_asteroid_size_3 / 2 + 2)) {
            bullet4_y = 565;
            bullet_fired_4 = false;
            return true;
        }
        if (distance_35 <= (rand_asteroid_size_3 / 2 + 2)) {
            bullet5_y = 565;
            bullet_fired_5 = false;
            return true;
        }
        if (distance_36 <= (rand_asteroid_size_3 / 2 + 2)) {
            bullet6_y = 565;
            bullet_fired_6 = false;
            return true;
        }
        if (distance_37 <= (rand_asteroid_size_3 / 2 + 2)) {
            bullet7_y = 565;
            bullet_fired_7 = false;
            return true;
        }

        else {
            return false;
        }
    }

    public boolean distance_4_b() {
        float distance_41 = dist(asteroidx_4, asteroidy_4, bullet1_x, bullet1_y);
        float distance_42 = dist(asteroidx_4, asteroidy_4, bullet2_x, bullet2_y);
        float distance_43 = dist(asteroidx_4, asteroidy_4, bullet3_x, bullet3_y);
        float distance_44 = dist(asteroidx_4, asteroidy_4, bullet4_x, bullet4_y);
        float distance_45 = dist(asteroidx_4, asteroidy_4, bullet5_x, bullet5_y);
        float distance_46 = dist(asteroidx_4, asteroidy_4, bullet6_x, bullet6_y);
        float distance_47 = dist(asteroidx_4, asteroidy_4, bullet7_x, bullet7_y);
        if (distance_41 <= (rand_asteroid_size_4 / 2 + 2)) {
            bullet1_y = 565;
            bullet_fired_1 = false;
            return true;
        }
        if (distance_42 <= (rand_asteroid_size_4 / 2 + 2)) {
            bullet2_y = 565;
            bullet_fired_2 = false;
            return true;
        }
        if (distance_43 <= (rand_asteroid_size_4 / 2 + 2)) {
            bullet3_y = 565;
            bullet_fired_3 = false;
            return true;
        }
        if (distance_44 <= (rand_asteroid_size_4 / 2 + 2)) {
            bullet4_y = 565;
            bullet_fired_4 = false;
            return true;
        }
        if (distance_45 <= (rand_asteroid_size_4 / 2 + 2)) {
            bullet5_y = 565;
            bullet_fired_5 = false;
            return true;
        }
        if (distance_46 <= (rand_asteroid_size_4 / 2 + 2)) {
            bullet6_y = 565;
            bullet_fired_6 = false;
            return true;
        }
        if (distance_47 <= (rand_asteroid_size_4 / 2 + 2)) {
            bullet7_y = 565;
            bullet_fired_7 = false;
            return true;
        }

        else {
            return false;
        }
    }

    public boolean distance_5_b() {
        float distance_51 = dist(asteroidx_5, asteroidy_5, bullet1_x, bullet1_y);
        float distance_52 = dist(asteroidx_5, asteroidy_5, bullet2_x, bullet2_y);
        float distance_53 = dist(asteroidx_5, asteroidy_5, bullet3_x, bullet3_y);
        float distance_54 = dist(asteroidx_5, asteroidy_5, bullet4_x, bullet4_y);
        float distance_55 = dist(asteroidx_5, asteroidy_5, bullet5_x, bullet5_y);
        float distance_56 = dist(asteroidx_5, asteroidy_5, bullet6_x, bullet6_y);
        float distance_57 = dist(asteroidx_5, asteroidy_5, bullet7_x, bullet7_y);
        if (distance_51 <= (rand_asteroid_size_5 / 2 + 2)) {
            bullet1_y = 565;
            bullet_fired_1 = false;
            return true;
        }
        if (distance_52 <= (rand_asteroid_size_5 / 2 + 2)) {
            bullet2_y = 565;
            bullet_fired_2 = false;
            return true;
        }
        if (distance_53 <= (rand_asteroid_size_5 / 2 + 2)) {
            bullet3_y = 565;
            bullet_fired_3 = false;
            return true;
        }
        if (distance_54 <= (rand_asteroid_size_5 / 2 + 2)) {
            bullet4_y = 565;
            bullet_fired_4 = false;
            return true;
        }
        if (distance_55 <= (rand_asteroid_size_5 / 2 + 2)) {
            bullet5_y = 565;
            bullet_fired_5 = false;
            return true;
        }
        if (distance_56 <= (rand_asteroid_size_5 / 2 + 2)) {
            bullet6_y = 565;
            bullet_fired_6 = false;
            return true;
        }
        if (distance_57 <= (rand_asteroid_size_5 / 2 + 2)) {
            bullet7_y = 565;
            bullet_fired_7 = false;
            return true;
        }

        else {
            return false;
        }
    }

    public boolean gameOverCollision() {
        // for asteroid 1:
        if (dist(asteroidx_1, asteroidy_1, rocketx, 555) <= rand_asteroid_size_1 / 2) {
            return true;
        }
        if (dist(asteroidx_1, asteroidy_1, rocketx + 10, 595) <= rand_asteroid_size_1 / 2) {
            return true;
        }
        if (dist(asteroidx_1, asteroidy_1, rocketx + 20, 635) <= rand_asteroid_size_1 / 2) {
            return true;
        }
        if (dist(asteroidx_1, asteroidy_1, rocketx, 635) <= rand_asteroid_size_1 / 2) {
            return true;
        }
        if (dist(asteroidx_1, asteroidy_1, rocketx - 20, 635) <= rand_asteroid_size_1 / 2) {
            return true;
        }
        if (dist(asteroidx_1, asteroidy_1, rocketx - 10, 595) <= rand_asteroid_size_1 / 2) {
            return true;
        }
        // for asteroid 2:
        if (dist(asteroidx_2, asteroidy_2, rocketx, 555) <= rand_asteroid_size_2 / 2) {
            return true;
        }
        if (dist(asteroidx_2, asteroidy_2, rocketx + 10, 595) <= rand_asteroid_size_2 / 2) {
            return true;
        }
        if (dist(asteroidx_2, asteroidy_2, rocketx + 20, 635) <= rand_asteroid_size_2 / 2) {
            return true;
        }
        if (dist(asteroidx_2, asteroidy_2, rocketx, 635) <= rand_asteroid_size_2 / 2) {
            return true;
        }
        if (dist(asteroidx_2, asteroidy_2, rocketx - 20, 635) <= rand_asteroid_size_2 / 2) {
            return true;
        }
        if (dist(asteroidx_2, asteroidy_2, rocketx - 10, 595) <= rand_asteroid_size_2 / 2) {
            return true;
        }
        // for asteroid 3:
        if (dist(asteroidx_3, asteroidy_3, rocketx, 555) <= rand_asteroid_size_3 / 2) {
            return true;
        }
        if (dist(asteroidx_3, asteroidy_3, rocketx + 10, 595) <= rand_asteroid_size_3 / 2) {
            return true;
        }
        if (dist(asteroidx_3, asteroidy_3, rocketx + 20, 635) <= rand_asteroid_size_3 / 2) {
            return true;
        }
        if (dist(asteroidx_3, asteroidy_3, rocketx, 635) <= rand_asteroid_size_3 / 2) {
            return true;
        }
        if (dist(asteroidx_3, asteroidy_3, rocketx - 20, 635) <= rand_asteroid_size_3 / 2) {
            return true;
        }
        if (dist(asteroidx_3, asteroidy_3, rocketx - 10, 595) <= rand_asteroid_size_3 / 2) {
            return true;
        }
        // for asteroid 4:
        if (dist(asteroidx_4, asteroidy_4, rocketx, 555) <= rand_asteroid_size_4 / 2) {
            return true;
        }
        if (dist(asteroidx_4, asteroidy_4, rocketx + 10, 595) <= rand_asteroid_size_4 / 2) {
            return true;
        }
        if (dist(asteroidx_4, asteroidy_4, rocketx + 20, 635) <= rand_asteroid_size_4 / 2) {
            return true;
        }
        if (dist(asteroidx_4, asteroidy_4, rocketx, 635) <= rand_asteroid_size_4 / 2) {
            return true;
        }
        if (dist(asteroidx_4, asteroidy_4, rocketx - 20, 635) <= rand_asteroid_size_4 / 2) {
            return true;
        }
        if (dist(asteroidx_4, asteroidy_4, rocketx - 10, 595) <= rand_asteroid_size_4 / 2) {
            return true;
        }
        // for asteroid 5:
        if (dist(asteroidx_5, asteroidy_5, rocketx, 555) <= rand_asteroid_size_5 / 2) {
            return true;
        }
        if (dist(asteroidx_5, asteroidy_5, rocketx + 10, 595) <= rand_asteroid_size_5 / 2) {
            return true;
        }
        if (dist(asteroidx_5, asteroidy_5, rocketx + 20, 635) <= rand_asteroid_size_5 / 2) {
            return true;
        }
        if (dist(asteroidx_5, asteroidy_5, rocketx, 635) <= rand_asteroid_size_5 / 2) {
            return true;
        }
        if (dist(asteroidx_5, asteroidy_5, rocketx - 20, 635) <= rand_asteroid_size_5 / 2) {
            return true;
        }
        if (dist(asteroidx_5, asteroidy_5, rocketx - 10, 595) <= rand_asteroid_size_5 / 2) {
            return true;
        }
        return false;
    }

    public void score() {
        fill(0, 255, 0);
        textSize(32);
        textAlign(LEFT);
        text("Asteroids hit: " + score, 35, 45);
    }

    public void missed() {
        fill(255, 0, 0);
        textSize(32);
        textAlign(RIGHT);
        text("Asteroids missed: " + missed, 760, 45);
    }

    public void gameOver_screen() {
        fill(255);
        textSize(100);
        textAlign(CENTER);
        text("GAME OVER", 400, 300);
    }

    public void gameOver_Hitscore() {
        fill(0, 255, 0);
        textSize(25);
        textAlign(CENTER);
        text("Asteroids Hit: " + score, 400, 340);
    }

    public void gameOver_missed() {
        fill(255, 0, 0);
        textSize(25);
        textAlign(CENTER);
        text("Asteroids Missed: " + missed, 400, 375);
    }

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
        if (!running) {
            gameOver_screen();
            gameOver_Hitscore();
            gameOver_missed();
            gameOver_ScoreOverall();
            gameOver_reset();
        } else {
            score();
            missed();
            if (gameOverCollision()) {
                running = false;
            }
            // draw or hide bullets
            if (bullet_fired_1 == false)
                bullet1_x = rocketx;
            else {
                drawbullet1();
            }
            if (bullet_fired_2 == false)
                bullet2_x = rocketx;
            else {
                drawbullet2();
            }
            if (bullet_fired_3 == false)
                bullet3_x = rocketx;
            else {
                drawbullet3();
            }
            if (bullet_fired_4 == false)
                bullet4_x = rocketx;
            else {
                drawbullet4();
            }
            if (bullet_fired_5 == false)
                bullet5_x = rocketx;
            else {
                drawbullet5();
            }
            if (bullet_fired_6 == false)
                bullet6_x = rocketx;
            else {
                drawbullet6();
            }
            if (bullet_fired_7 == false)
                bullet7_x = rocketx;
            else {
                drawbullet7();
            }

            drawtrack();
            drawDeathline();
            drawTriangle();
            if (right_key == true) {
                rocketMove(7);
            }
            if (left_key == true) {
                rocketMove(-7);
            }

            drawAsteroid_1();
            drawAsteroid_2();
            drawAsteroid_3();
            drawAsteroid_4();
            drawAsteroid_5();
            

            if (distance_1_b()) {
                score++;
                asteroidx_1 = random(0, 800);
                asteroidy_1 = -150;
                randX_asteroid_speed_1 = random(-5, 5);
                randY_asteroid_speed_1 = random(0, 10);
                rand_asteroid_size_1 = random(40, 150);

            }
            if (distance_2_b()) {
                score++;
                asteroidx_2 = random(0, 800);
                asteroidy_2 = -150;
                randX_asteroid_speed_2 = random(-5, 5);
                randY_asteroid_speed_2 = random(0, 10);
                rand_asteroid_size_2 = random(40, 150);

            }
            if (distance_3_b()) {
                score++;
                asteroidx_3 = random(0, 800);
                asteroidy_3 = -150;
                randX_asteroid_speed_3 = random(-5, 5);
                randY_asteroid_speed_3 = random(0, 10);
                rand_asteroid_size_3 = random(40, 150);

            }
            if (distance_4_b()) {
                score++;
                asteroidx_4 = random(0, 800);
                asteroidy_4 = -150;
                randX_asteroid_speed_4 = random(-5, 5);
                randY_asteroid_speed_4 = random(0, 10);
                rand_asteroid_size_4 = random(40, 150);

            }
            if (distance_5_b()) {
                score++;
                asteroidx_5 = random(0, 800);
                asteroidy_5 = -150;
                randX_asteroid_speed_5 = random(-5, 5);
                randY_asteroid_speed_5 = random(0, 10);
                rand_asteroid_size_5 = random(40, 150);

            }
        }
    }
}
