package Tank;

import java.awt.Graphics;

import Dino.Dinolist;
import MainPackage.Constants;
import MainPackage.Frame;

public class TankList {
    DoubleLink<Tank> tanks;
    Frame frame;
    public TankList(Frame frame2){
        this.frame = frame2;
        tanks = new DoubleLink<Tank>();  
        inistizeAssets();
    }   

    private void inistizeAssets(){
        for (int i = 0; i < Constants.NOOFTANK; i++)
            tanks.add(new Tank((Constants.WIDTH/Constants.NOOFTANK)* i));
    }
    public void left(){
        tanks.up();
    }
    public void moveleft(){
        tanks.get().moveleft();
    }
    public void moveright(){
        tanks.get().moveright();
    }
    public void delete(){
        tanks.delete();
    }
    public void rigth(){
        tanks.down();
    }

    public void ishit(Dinolist dinolist){
        for (Object x: tanks.toArray()){
            Tank c = (Tank)x;
            if (dinolist.isTouching(c)){
                if (c.live){
                    c.destory();
                }else{
                    tanks.delete(c);
                    if (tanks.getsize() == 0)
                        frame.end();
                }
            }
        }
    }
    public void shoot(){
        if (!tanks.get().live)
            return;
        int x = tanks.get().getX();
        BulletList.getInstance(frame).shoot(x);
    }

    public void paint(Graphics g){
        for (Object x: tanks.toArray()){
            Tank c = (Tank)x;
            g.drawImage(c.getImage(), c.getX(), c.getY(), frame);
        }
        Tank c = tanks.get();
        g.fillRect(c.getX(), c.getY() + 50, 50, 5);
    }
        
}
