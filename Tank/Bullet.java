package Tank;

import java.awt.Point;

import Dino.Dinosaur;
import MainPackage.Constants;

public class Bullet {
    Point p;
    int Y;
    BulletList bulletList;
    public Bullet(int x, BulletList bulletList){
        Y = Constants.BASE - 50;
        p = new Point(x, Y);
        this.bulletList = bulletList;
    }
    public int getX(){
        return (int)p.getX();
    }
    public int getY(){
        return (int)p.getY();
    }
    public void moveup(){
        p = new Point((int)p.getX(), (int)p.getY() - 10);
        if ( p.getY() < 0)
            bulletList.delete(this);
    }

    public boolean isTouching(Dinosaur dino){
        return (Math.abs(dino.getX() - p.getX()) < 50 &&  Math.abs(dino.getY() - p.getY()) < 15 );
    }
}
