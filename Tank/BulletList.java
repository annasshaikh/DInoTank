package Tank;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import Dino.Dinosaur;
import MainPackage.Frame;

public class BulletList {
    DoubleLink<Bullet> bullets;
    Frame frame;
    Image buImage;
    static BulletList bulletList;
    private BulletList(Frame frame){
        this.frame = frame;
        bullets = new DoubleLink<Bullet>();
        inistizeAssets();
    }

    public static BulletList getInstance(Frame frame){
        if (bulletList == null)
            bulletList = new BulletList(frame);
        return bulletList;
    }
    private void inistizeAssets(){
        buImage = new ImageIcon("Data\\Bullet.jpg").getImage();
    }

    public void moveup(){
        for (Object x: bullets.toArray()){
            ((Bullet)x).moveup();
        }
    }
    public void shoot(int x){
        bullets.add(new Bullet(x, this));
    }

    public boolean isTouching(Dinosaur dinosaur){
        for (Object x: bullets.toArray()){
            Bullet c = (Bullet)x;
            if (Math.abs(c.getX() - dinosaur.getX()) < 35 && Math.abs(c.getY() - dinosaur.getY()) < 15){
                this.delete(c);
                return true;
            }
        }
        return false;
    }
    public void delete(Bullet bullet){
        bullets.delete(bullet);
    }
    public void paint(Graphics g){
        for (Object x: bullets.toArray()){
            Bullet c = (Bullet)x;
            g.drawImage(buImage, c.getX(), c.getY(), frame);
        }
    }

}
