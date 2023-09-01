package Dino;

import java.awt.Graphics;

import MainPackage.Constants;
import MainPackage.Frame;
import Tank.BulletList;
import Tank.Tank;

public class Dinolist {
    DinoNode head;
    Frame frame;
    private static Dinolist dinolist;
    private Dinolist(Frame frame){
        this.frame = frame;
    }
    public static Dinolist getinstance(Frame frame){
        if (dinolist == null)
            dinolist = new Dinolist(frame);
        return dinolist;
    }
    private void spawn(Dinosaur dinosaur){
        if (head == null){
            head = new DinoNode(dinosaur);
        }else if (head.next == null){
            head.next = new DinoNode(dinosaur);
        }else{
            DinoNode current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = new DinoNode(dinosaur);
        }
    }

    public void randomSpawn(){
        int r = (int)(Math.random() * 10);
        int x = (int)(Math.random() * Constants.WIDTH) - 25;
        if (r < 2)
            this.spawn(new Trex(x));
        else if (r < 6)
            this.spawn(new Hulk(x));
        else
            this.spawn(new Gaint(x));
    }
    public void kill(Dinosaur dinosaur){
        if (head.dinosaur == dinosaur){
            head = head.next;
        }else{
            DinoNode current = head;
            while (current.next != null){
                if (current.next.dinosaur == dinosaur){
                    if (current.next.next == null){
                        current.next = null;
                    }else{
                        current.next = current.next.next;
                    }
                    break;
                }
                current = current.next;
            }
        }
    }

    public void isTouching(BulletList bulletList){
        if (head == null)
            return;
        DinoNode current = head;
        while(current != null){
            if (bulletList.isTouching(current.dinosaur))
                current.dinosaur.hit();
            current = current.next;
        }
    }

    public boolean isTouching(Tank tank){
        if (head == null)
            return false;
        DinoNode current = head;
        while(current != null){
            if (Math.abs(tank.getX() - current.dinosaur.getX()) < 35 && Math.abs(tank.getY() - current.dinosaur.getY()) < 5){
                this.kill(current.dinosaur);
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public void movedown(){
        if (head == null)
            return;
        DinoNode current = head;
        while(current != null){
            if (current.dinosaur.movedown())
                frame.end();
            current = current.next;
        }
    }

    
    public void paint(Graphics g){
        DinoNode curDinoNode = head;
        while(curDinoNode != null){
            Dinosaur c = curDinoNode.dinosaur;
            g.drawImage(c.getImage(), c.getX(), c.getY(), frame);
            curDinoNode = curDinoNode.next;
        }
    }
    
}
