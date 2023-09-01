package Dino;
import javax.swing.ImageIcon;

import MainPackage.Constants;

public class Hulk extends Dinosaur {

    
    public Hulk(int x) {
        super(x);
        super.health = 2;
        super.speed = 3 + Constants.Speed;
        inistizeAssets();
    }
    public float gethealth(){
        return super.health/5;
    }
    private void inistizeAssets(){
        super.image = new ImageIcon("Data\\D2.jpeg").getImage();
    }
}
