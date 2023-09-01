package Tank;

import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

import MainPackage.Constants;

public class Tank {
    Image good;
    Image bad;
    Point p;
    int Y;
    boolean live;
    public Tank(int x){
        Y = Constants.BASE;
        p =  new Point(x, Y);
        good = new ImageIcon("Data\\Tank.jpeg").getImage();
        bad = new ImageIcon("Data\\TankDes.jpg").getImage();
        live = true;
    }
    public int getX(){
        return (int)p.getX();
    }
    public int getY(){
        return (int)p.getY();
    }
    public void moveleft(){
        if (p.getX() > 0)
            p =  new Point((int)p.getX() - 10, Y);
    }
    public void moveright(){
        if (p.getX() < Constants.WIDTH - 50)
            p =  new Point((int)p.getX() +10, Y);
    }
    public void destory(){
        live = false;
    }
    public Image getImage(){
        return (live) ? good : bad;
    }

}
