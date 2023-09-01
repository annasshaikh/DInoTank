package Dino;

import javax.swing.ImageIcon;

import MainPackage.Constants;

public class Gaint extends Dinosaur {

    public Gaint(int x) {
        super(x);
        super.speed = 1 + Constants.Speed;
        super.health = 3;
        inistizeAssets();
    }

    public float gethealth(){
        return super.health/3;
    }
    private void inistizeAssets(){
        super.image = new ImageIcon("Data\\D1.jpg").getImage();
    }
    
    
}
