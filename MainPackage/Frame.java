package MainPackage;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Dino.Dinolist;
import Tank.BulletList;
import Tank.TankList;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Frame extends JPanel implements KeyListener , ActionListener  {
    TankList bar;
    BulletList bulletList;
    boolean end;
    public Frame() {
        bar = new TankList(this);
        Dinolist.getinstance(this);
        bulletList = BulletList.getInstance(this);
        addKeyListener(this);
        setFocusable(true);
        end = false;
    }

    public void end(){
        end = true;
    }
    public boolean isend(){
        return end;
    }
    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE)
            bar.shoot();    
    }

    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        if (end){
            endScreen(g);
            return;
        }
        Image board = new ImageIcon("Data\\Board.jpeg").getImage();
        g.drawImage(board, 0,0, this);
        g.setColor(Color.BLACK);

        bar.paint(g);
        Dinolist.getinstance(this).paint(g);
        bulletList.paint(g);
        checklist();
        paintPanel(g);
    }

    private void paintPanel(Graphics g){
        int x = Constants.WIDTH + 60;
        Font font = new Font("serif", Font.BOLD, 18);
        g.setColor(Color.WHITE);
        g.setFont(font);
        g.drawString("Score: " +  Constants.Score, x, 300);
        g.drawString("Level: " +  Constants.level, x, 350);
        g.drawString("Speed: " +  Constants.Speed , x, 400);
    }
    private void checklist(){
        check();
        bar.ishit(Dinolist.getinstance(this));
    }
    private void endScreen(Graphics g){
        Image enImage = new ImageIcon("Data\\END SCREEN.jpeg").getImage();
        g.drawImage(enImage,0 , 0, this);
        g.setColor(new Color(204, 173, 21));
        g.drawString("" + Constants.Score , 400,180);
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP)
            bar.rigth();
        else if(e.getKeyCode() == KeyEvent.VK_DOWN)
            bar.left();
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
            bar.moveright();
        else if(e.getKeyCode() == KeyEvent.VK_LEFT)
            bar.moveleft();
        else if(e.getKeyCode() == KeyEvent.VK_SPACE)
            bar.shoot();
        repaint();
    }

    public void check(){
        Dinolist.getinstance(this).isTouching(bulletList);
    }
    @Override
    public void keyReleased(KeyEvent e) {
        paint(getGraphics());
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        paintComponent(getGraphics());
        repaint();
    }
}
