package Dino;


import javax.swing.ImageIcon;

import MainPackage.Constants;

public class Trex extends Dinosaur{

    public Trex(int x) {
        super(x);
        super.speed = 5 + Constants.Speed;
        super.health = 1;
        inistizeAssets();
    }
    
    public float gethealth(){
        return super.health;
    }
    private void inistizeAssets(){
        super.image = new ImageIcon("Data\\D3.jpeg").getImage();
    }
}
