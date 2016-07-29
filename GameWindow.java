import models.Bullet;
import models.Enemy_plane;
import models.Plane;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Image;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;
import java.util.Vector;

/**
 * Created by GGG8 on 7/24/2016.
 */
public class GameWindow extends Frame implements Runnable{
    Image background;
    Image planeImage;
    Image plane2Image;
    Image bulletImage;
    Image enemyplaneImage;

    Plane plane1;
    Plane plane2;

    int plane2Width;
    int plane2Height;
    int planeEWidth;
    int planeEHeight;

    BufferedImage bufferedImage;
    Graphics bufferImageGraphic;

    Vector<Bullet> bulletVector;
    Vector<Enemy_plane> enemy_planeVector;


    Thread thread;

    public GameWindow() {
        System.out.println("Game window constructor");
        this.setVisible(true);
        this.setSize(700, 700);
        this.setLocation(0, 0);
        plane1 = new Plane(100, 100);
        plane2 = new Plane(200, 200);

        bulletVector = new Vector<Bullet>();
        enemy_planeVector= new Vector<Enemy_plane>();

        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("windowOpened");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("windowClosing");
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("windowClosed");
            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        try {
            background = ImageIO.read(new File("resources/background.png"));
            planeImage = ImageIO.read(new File("resources/plane4.png"));
            plane2Image = ImageIO.read(new File("resources/plane3.png"));
            bulletImage = ImageIO.read(new File("resources/bullet.png"));
            enemyplaneImage=ImageIO.read(new File("resources/enemy_plane_white_1.png"));
            this.plane2Width = plane2Image.getWidth(null);
            this.plane2Height = plane2Image.getHeight(null);
            this.planeEWidth = enemyplaneImage.getWidth(null);
            this.planeEHeight = enemyplaneImage.getHeight(null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_SPACE:
                        Bullet bullet = new Bullet();
                        bullet.moveTo(plane2.x+plane2Height/2, plane2.y);
                        bulletVector.add(bullet);
                        break;
                    case KeyEvent.VK_LEFT:
                        plane2.x -= 10;
                        break;
                    case KeyEvent.VK_RIGHT:
                        plane2.x += 10;
                        break;
                    case KeyEvent.VK_UP:
                        plane2.y -= 10;
                        break;
                    case KeyEvent.VK_DOWN:
                        plane2.y += 10;
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                plane2.moveTo(e.getX() - plane2Width / 2,
                        e.getY() - plane2Height / 2);

            }

        });

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                Bullet bullet = new Bullet();
                bullet.moveTo(e.getX(), e.getY() );
                bulletVector.add(bullet);
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        this.bufferedImage = new BufferedImage(600,800,BufferedImage.TYPE_INT_ARGB);
        this.bufferImageGraphic = bufferedImage.getGraphics();
        thread = new Thread(this);
        thread.start();
 //        for (int i=0;i<100;i++){
//            Random rd = new Random();
//            Enemy_plane enemy_plane=new Enemy_plane();
//            enemy_plane.moveTo(rd.nextInt(700),rd.nextInt(100));
//            enemy_planeVector.add(enemy_plane);
//        }
        Thread enemyPlane = new Thread() {
            @Override
            public void run() {
                while(true){
                    try {
                        Random rd =new Random();
                        Enemy_plane enemy_plane = new Enemy_plane();
                        enemy_plane.moveTo(rd.nextInt(700), rd.nextInt(100));
                        enemy_planeVector.add(enemy_plane);
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        enemyPlane.start();
    }

    @Override
    public void update(Graphics g) {

        bufferImageGraphic.drawImage(background, 0, 0, null);
        bufferImageGraphic.drawImage(planeImage, plane1.x, plane1.y, null);
        bufferImageGraphic.drawImage(plane2Image, plane2.x, plane2.y, null);
        for (Bullet bullet : bulletVector) {
            bufferImageGraphic.drawImage(bulletImage, bullet.x, bullet.y, null);
        }
        for (Enemy_plane enemy_plane : enemy_planeVector) {
            bufferImageGraphic.drawImage(enemyplaneImage, enemy_plane.x, enemy_plane.y, null);
        }
        g.drawImage(bufferedImage, 0, 0, null);
        System.out.println("Paint");
    }

    @Override
    public void run() {
        System.out.println(planeEHeight);
        while (true) {
            try {
                Thread.sleep(27);
                Iterator<Enemy_plane> enemy_planeIterator = enemy_planeVector.iterator();
                Iterator<Bullet> bulletIterator = bulletVector.iterator();
                while (enemy_planeIterator.hasNext()) {
                    Enemy_plane enemy_plane = enemy_planeIterator.next();
                    enemy_plane.y += 5;
                    if (enemy_plane.y > 600) {
                        enemy_planeIterator.remove();
                        break;
                    }
                    Rectangle rectangleEnemyPlane = new Rectangle(enemy_plane.x, enemy_plane.y,
                            enemyplaneImage.getWidth(null), enemyplaneImage.getHeight(null));
                    while (bulletIterator.hasNext()) {
                        Bullet bullet = bulletIterator.next();
                        bullet.y -= 5;
                        Rectangle rectangleBullet = new Rectangle(bullet.x, bullet.y, bulletImage.getWidth(null),
                                bulletImage.getHeight(null));
                        if (rectangleBullet.intersects(rectangleEnemyPlane)) {
                            bulletIterator.remove();
                            enemy_planeIterator.remove();
                            break;
                        }
                    }
                }
                Iterator<Bullet> bulletIterator1 = bulletVector.iterator();
                while (bulletIterator1.hasNext()) {
                    Bullet bullet = bulletIterator1.next();
                    bullet.y -= 5;
                    if (bullet.y < 50) {
                        bulletIterator1.remove();
                    }
                }


//                for (Iterator<Enemy_plane> enemy_planeIterator1 : enemy_planeVector.iterator(){
//                    for (Enemy_plane enemy_plane: enemy_planeVector){
//                        if (bullet.x >= enemy_plane.x + planeEHeight
//                                && bullet.x <= enemy_plane.x + planeEHeight
//                                && bullet.y >= enemy_plane.y + plane2Height
//                                && bullet.y <= enemy_plane.y+planeEHeight)
//
//                    }
//                }
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
