
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

import Dino.Dinolist;
import MainPackage.Constants;
import MainPackage.Frame;
import Tank.BulletList;

public class MAIN {
    static ScheduledExecutorService executor;
    public static void main(String[] args) {
        JFrame Jframe = new JFrame();
        Frame frame = new Frame();
        Jframe.add(frame);
        Jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Jframe.setSize(1000, 600);
        Jframe.setVisible(true);
        // Create a single-threaded executor service
        executor = Executors.newSingleThreadScheduledExecutor();
  
        // Create a runnable task that calls the function
        Runnable randomSpawn = new Runnable() {
            @Override
            public void run() {
                Dinolist dinolist = Dinolist.getinstance(frame);
                dinolist.randomSpawn();
            }
        };
        Runnable move = new Runnable() {
            @Override
            public void run() {
                if (frame.isend()){
                    executor.shutdown();
                    Jframe.setSize(600, 600);
                }
                Dinolist dinolist = Dinolist.getinstance(frame);
                dinolist.movedown();
                BulletList.getInstance(frame).moveup();
                frame.repaint();
            }
        };
        Runnable levelup = new Runnable() {
            @Override
            public void run() {
                Constants.LevelUp();
            }
        };
        executor.scheduleWithFixedDelay(levelup, Constants.LEVELTIME, Constants.LEVELTIME, TimeUnit.MILLISECONDS );
        executor.scheduleWithFixedDelay(move, 5,Constants.MOVETIME, TimeUnit.MILLISECONDS);
        executor.scheduleWithFixedDelay(randomSpawn, 5,Constants.SPAWNTIME, TimeUnit.MILLISECONDS);
    }

}

