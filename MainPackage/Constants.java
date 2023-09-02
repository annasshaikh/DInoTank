package MainPackage;
public class Constants {
    public static final int WIDTH = 1000;
    public static int HEIGHT = 600;
    public static int NOOFTANK = 3;
    public static int MOVETIME = 100;
    public static int SPAWNTIME = 2500;
    public static int BASE = 550;
    public static int LEVELTIME = 1000 * 30;
    public static int Score = 0;
    public static int level = 0;

    public static int Speed = 2;
    public static void LevelUp(){
        //SPAWNTIME = (int)(SPAWNTIME / 1.5);
        if(level > 0 && level % 3 == 0)
            Speed++;
        level++;
    }
}
