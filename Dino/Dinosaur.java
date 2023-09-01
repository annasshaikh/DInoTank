package Dino;

import java.awt.Image;
import java.awt.Point;

import MainPackage.Constants;

public abstract class Dinosaur {
    Point p;
    int health;
    Image image;
    int speed;
    public abstract float gethealth();
    public Dinosaur(int x){
        p = new Point(x, 10);
    }
    public boolean movedown(){
        p = new Point((int)p.getX(),(int)p.getY() + speed);
        return (p.getY() > Constants.HEIGHT);

    } 

    public void hit(){
        if (health == 1){
            Dinolist.getinstance(null).kill(this);
            Constants.Score++;
        }
        health--;
    }
    public Image getImage(){
        return image;
    }
    
    public int getX(){
        return (int)p.getX();
    }
    public int getY(){
        return (int)p.getY();
    }
    
}
