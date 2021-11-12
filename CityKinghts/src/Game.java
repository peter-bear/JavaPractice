// Decompiled by DJ v3.9.9.91 Copyright 2005 Atanas Neshkov  Date: 2005-11-26 11:41:02
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 

import java.io.IOException;
import java.io.PrintStream;
import java.util.*;
import javax.microedition.lcdui.*;
import javax.microedition.media.*;

class Game
    implements Constants
{

    public Game(GameCanvas gamecanvas)
    {
        GameStart = false;
        GameOver = false;
        GamePaused = false;
        score = 0;
        lvl = 127;
        level = 1;
        isSoundOn = true;
        isVibratorOn = true;
        lastscore = 0;
        lastlevel = 1;
        rnd = new Random();
        temp = "";
        gameOverCtr = 0;
        resetCtr = 0;
        enemyRemoveCtr = 0;
        RoadArms = new Vector();
        enemyMan = new Vector();
        ptr = new Vector();
        waitCtr = 0;
        cheatL = 0;
        scorpioCtr = 1;
        y2 = 0;
        vanishFlag = false;
        prevtime = 0L;
        hitting = false;
        index = -1;
        bonus = 0;
        x1 = 0;
        levelWeapon = 127;
        strypg = 0;
        msglp = -30;
        lag = 0L;
        m = 10;
        p = 0;
        q = 0;
        search = false;
        Gc = gamecanvas;
        WIDTH = 176;
        HEIGHT = 220;
        lvl = 127;
        mp = new MidPlayer();
        makeSound();
    }

    public void addPoints()
    {
        ptr.addElement(new point((short)(me.x + 60), (short)176));
        ptr.addElement(new point((short)(me.x + 70), (short)176));
        ptr.addElement(new point((short)(me.x + 80), (short)176));
        ptr.addElement(new point((short)(me.x + 50), (short)176));
        ptr.addElement(new point((short)(me.x + 90), (short)176));
    }

    public void addEnemy()
    {
        byte byte0 = 0;
        if(lvl == 1)
            byte0 = 0;
        else
        if(lvl == 2)
            byte0 = 1;
        else
        if(lvl == 3)
            byte0 = 2;
        boolean flag = false;
        point point1 = null;
        for(byte byte1 = 0; byte1 <= byte0; byte1++)
        {
            for(byte byte2 = 0; byte2 < 5; byte2++)
            {
                int j = (rnd.nextInt() >>> 1) % 5;
                point1 = (point)ptr.elementAt(j);
                if(point1.occupy)
                    continue;
                int i = j;
                ptr.removeElement(point1);
                break;
            }

            byte byte3 = 35;
            if(level > 7)
                byte3 = weapon2;
            Enemy enemy;
            if(byte0 == 0)
                enemy = new Enemy((short)(me.x + 40), (short)176, byte3, this);
            else
                enemy = new Enemy(point1.x, point1.y, byte3, this);
            enemy.jpCtr = 0;
            enemy.echainJumpCtr = 0;
            enemy.eaxeJumpCtr = 0;
            enemy.delayCtr = 0;
            enemyMan.addElement(enemy);
            if(point1 != null)
            {
                point1.occupy = true;
                ptr.addElement(point1);
            }
        }

    }

    public void drawWeaponLyingOnStreet(Graphics g)
    {
        for(Enumeration enumeration = RoadArms.elements(); enumeration.hasMoreElements();)
        {
            Arms arms = (Arms)enumeration.nextElement();
            switch(arms.id)
            {
            case 41: // ')'
                g.setClip(arms.x + x1, arms.y, 37, 10);
                g.clipRect(arms.x + x1, arms.y, 37, 10);
                g.drawImage(armsIm, arms.x + x1, arms.y, 0x10 | 4);
                break;

            case 39: // '\''
                g.setClip(arms.x + x1, arms.y, 52, 6);
                g.clipRect(arms.x + x1, arms.y, 52, 6);
                g.drawImage(armsIm, (arms.x + x1) - 37, arms.y - 3, 0x10 | 4);
                break;
            }
        }

        g.setClip(0, 0, WIDTH, HEIGHT);
    }

    public void weaponSelection()
    {
        boolean flag = false;
        if(lvl == 1)
        {
            byte abyte0[] = {
                41, 39
            };
            int i = (rnd.nextInt() >>> 1) % 2;
            weapon2 = abyte0[i];
        } else
        if(lvl == 2)
        {
            byte abyte1[] = {
                39, 41
            };
            int j = (rnd.nextInt() >>> 1) % 2;
            weapon2 = abyte1[j];
        } else
        if(lvl == 3)
        {
            byte abyte2[] = {
                41, 39
            };
            int k = (rnd.nextInt() >>> 1) % 2;
            weapon2 = abyte2[k];
        }
        Arms arms = new Arms(weapon2, (short)270, (short)192);
        RoadArms.addElement(arms);
    }

    public void enemyDieAnimation(Graphics g, Enemy enemy)
    {
        if(scorpioCtr == 1)
            y2 = enemy.y;
        switch(scorpioCtr)
        {
        default:
            break;

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
            g.setClip((enemy.x - 8) + x1, y2 - 7, 16, 15);
            g.clipRect((enemy.x - 8) + x1, y2 - 7, 16, 15);
            g.drawImage(vanish, ((enemy.x + x1) - 8) + vanish.getWidth() / 2, (y2 - 7) + vanish.getHeight() / 2, 1 | 2);
            scorpioCtr++;
            y2 -= 5;
            break;

        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
            g.setClip((enemy.x - 8) + x1, y2 - 7, 16, 15);
            g.clipRect((enemy.x - 8) + x1, y2 - 7, 16, 15);
            g.drawImage(vanish, ((enemy.x + x1) - 8 - 16) + vanish.getWidth() / 2, (y2 - 7) + vanish.getHeight() / 2, 1 | 2);
            scorpioCtr++;
            y2 -= 10;
            break;

        case 9: // '\t'
        case 10: // '\n'
        case 11: // '\013'
        case 12: // '\f'
            g.setClip((enemy.x - 8) + x1, y2 - 7, 16, 15);
            g.clipRect((enemy.x - 8) + x1, y2 - 7, 16, 15);
            g.drawImage(vanish, (((enemy.x - 8) + x1) - 32) + vanish.getWidth() / 2, (y2 - 7) + vanish.getHeight() / 2, 1 | 2);
            scorpioCtr++;
            y2 -= 15;
            if(scorpioCtr > 12)
            {
                scorpioCtr = 1;
                vanishFlag = true;
            }
            break;
        }
    }

    public void Draw(Graphics g)
    {
        if(me == null)
            me = new Fighter((short)108, (short)176, this);
        drawBg1(g);
        drawPanel(g);
        if(me.health > 0 && enemyMan.isEmpty() && level <= 20)
        {
            if(resetCtr == 0 && level <= 20)
            {
                level++;
                if(cheatL > level)
                    level = cheatL;
                if(level > 4)
                {
                    RoadArms.removeAllElements();
                    weaponSelection();
                }
                if(level <= 20)
                {
                    Gc.loadCtr1 = 0;
                    Gc.page = 110;
                }
            }
            lastscore = score;
            resetCtr++;
            searchAnimation(g);
            if(Gc.loadCtr1 == 2)
            {
                g.setColor(255, 255, 0);
                g.setFont(Font.getFont(0, 0, 8));
                g.drawString(Gc.strtScr.Translate("Congratulation"), WIDTH / 2, HEIGHT / 2 - 17, 1 | 0x10);
                g.drawString(Gc.strtScr.Translate("Level") + " = " + level, WIDTH / 2, HEIGHT / 2, 1 | 0x10);
                if(resetCtr == 3)
                {
                    bonus = (lastlevel * lvl * (me.health * 100)) / 120;
                    score += bonus;
                }
                g.drawString(Gc.strtScr.Translate("Bonus") + " = " + bonus, WIDTH / 2, HEIGHT / 2 + 17, 1 | 0x10);
            }
            if(resetCtr == 20)
            {
                resetLevel();
                resetCtr = 0;
                search = false;
            }
        } else
        if(me.health <= 0 || level > 20)
        {
            lastscore = score;
            if(gameOverCtr == 1)
                if(me.health > 0);
            if(gameOverCtr == 25)
            {
                GameOver = true;
                gameOverCtr = 0;
            }
            if(me.health <= 0)
                me.dieSequence(g);
            g.setColor(255, 255, 0);
            g.setFont(Font.getFont(0, 0, 8));
            if(level > 20)
                g.drawString(Gc.strtScr.Translate("Congratulation"), WIDTH / 2, HEIGHT / 2 - 15, 1 | 0x10);
            g.drawString(Gc.strtScr.Translate("Game Over"), WIDTH / 2, HEIGHT / 2, 1 | 0x10);
            gameOverCtr++;
        }
        try
        {
            if(weapon2 != 127 && !me.weaponPicked && !search)
                drawWeaponLyingOnStreet(g);
        }
        catch(Exception exception)
        {
            System.out.println("arms lying exception" + exception);
            exception.printStackTrace();
        }
        Enumeration enumeration;
        for(enumeration = enemyMan.elements(); enumeration.hasMoreElements() && enemyMan.size() == 1;)
        {
            Enemy enemy = (Enemy)enumeration.nextElement();
            if(enemy.health <= 0)
            {
                if(enemyRemoveCtr == 20)
                {
                    enemyMan.removeElement(enemy);
                    enemyRemoveCtr = 0;
                    vanishFlag = false;
                } else
                {
                    if(!vanishFlag)
                        enemyDieAnimation(g, enemy);
                    enemy.enemyDieSequence(g);
                    enemyRemoveCtr++;
                }
            } else
            {
                if(me.y >= me.maxY && !me.backAttack && enemyMan.size() == 1)
                    if(me.x - enemy.x < 0)
                        me.face = 27;
                    else
                        me.face = 26;
                if(me.health <= 0)
                {
                    enemy.action = 13;
                    enemy.y = enemy.emaxY;
                }
                enemy.drawEnemy(g);
                if(enemy.ebackAttack)
                    enemy.enemyFall(g);
                else
                if(enemy.ehit && !enemy.ebackAttack)
                {
                    enemy.enemyHitted(g);
                    enemy.eattackedAnimation(g);
                }
            }
        }

        while(enumeration.hasMoreElements() && enemyMan.size() >= 1) 
        {
            Enemy enemy1 = (Enemy)enumeration.nextElement();
            if(enemy1.health <= 0)
            {
                if(enemyRemoveCtr == 20)
                {
                    enemyMan.removeElement(enemy1);
                    enemyRemoveCtr = 0;
                    vanishFlag = false;
                } else
                {
                    if(!vanishFlag)
                        enemyDieAnimation(g, enemy1);
                    enemy1.enemyDieSequence(g);
                    enemyRemoveCtr++;
                }
            } else
            {
                if(enemy1.action == 15)
                {
                    State = 15;
                    index = enemyMan.indexOf(enemy1);
                }
                if(index != enemyMan.indexOf(enemy1))
                {
                    if(System.currentTimeMillis() % 7L == 0L)
                        enemy1.action = 13;
                    else
                    if(enemy1.Dist > 35)
                    {
                        enemy1.action = 16;
                        if(enemy1.jpCtr > 0 && enemy1.y < enemy1.emaxY && enemy1.action != 19 && !enemy1.isWeapon)
                            enemy1.action = 19;
                    }
                    if(hitting)
                        if(enemy1.Dist <= 35)
                            enemy1.action = 15;
                        else
                            enemy1.action = 14;
                }
                if(enemy1.ehit)
                    hitting = true;
                else
                if(me.hit)
                    hitting = false;
                else
                if(!enemy1.ehit)
                    hitting = false;
                if(me.health <= 0)
                {
                    enemy1.action = 13;
                    enemy1.y = enemy1.emaxY;
                }
                enemy1.drawEnemy(g);
                if(enemy1.ebackAttack)
                    enemy1.enemyFall(g);
                else
                if(enemy1.ehit && !enemy1.ebackAttack)
                {
                    enemy1.enemyHitted(g);
                    enemy1.eattackedAnimation(g);
                }
            }
        }
        if(me.health > 0 && !search)
        {
            if(me.backAttack)
                me.drawFall(g);
            else
            if(me.hit && !me.backAttack)
            {
                me.drawHitted(g);
                me.attackedAnimation(g);
            }
            me.DoAction(g);
        }
    }

    public void drawBg1(Graphics g)
    {
        int i = 0;
        if(!enemyMan.isEmpty())
            if(enemyMan.size() == 1)
            {
                Enemy enemy = (Enemy)enemyMan.firstElement();
                if((enemy.x + me.x) / 2 < WIDTH / 2)
                    x1 = 0;
                else
                if(bgWIDTH - (enemy.x + me.x) / 2 < WIDTH / 2)
                    x1 = -(bgWIDTH - WIDTH);
                else
                    x1 = -((enemy.x + me.x) / 2 - WIDTH / 2);
            } else
            if(enemyMan.size() > 1)
            {
                Enumeration enumeration = enemyMan.elements();
                int j;
                Enemy enemy1;
                for(j = 0; enumeration.hasMoreElements(); j += enemy1.x)
                    enemy1 = (Enemy)enumeration.nextElement();

                if((j / enemyMan.size() + me.x) / 2 < WIDTH / 2)
                    x1 = 0;
                else
                if(bgWIDTH - (j / enemyMan.size() + me.x) / 2 < WIDTH / 2)
                    x1 = -(bgWIDTH - WIDTH);
                else
                    x1 = -((j / enemyMan.size() + me.x) / 2 - WIDTH / 2);
            }
        g.setColor(0, 0, 0);
        g.fillRect(0, 0, 176, 180);
        g.setColor(60, 60, 60);
        g.fillRect(0, 173, 176, 8);
        g.setColor(81, 81, 81);
        g.fillRect(0, 181, 176, 40);
        g.setClip(0, 0, WIDTH, HEIGHT);
        g.setColor(255, 255, 255);
        g.fillArc(x1 + 140, i + 15, 40, 40, 0, 360);
        g.drawImage(building, x1 + 9, i + 70, 0x10 | 4);
        g.drawImage(building, x1 + 140, i + 70, 0x10 | 4);
        g.drawImage(building, x1 + 181, i + 70, 0x10 | 4);
        g.drawImage(building, x1 + 320, i + 70, 0x10 | 4);
        g.drawImage(wall, x1 + 420, (i + 168) - 48, 0x10 | 4);
        g.drawImage(wall, x1 + 376 + 1, (i + 168) - 48, 0x10 | 4);
        g.drawImage(wall, x1 + 332 + 2, (i + 168) - 48, 0x10 | 4);
        g.drawImage(wall, x1 + 288 + 3, (i + 168) - 48, 0x10 | 4);
        g.drawImage(wall, x1 + 244 + 4, (i + 168) - 48, 0x10 | 4);
        g.drawImage(wall, x1 + 200 + 5, (i + 168) - 48, 0x10 | 4);
        g.drawImage(wall, x1 + 156 + 6, (i + 168) - 48, 0x10 | 4);
        g.drawImage(wall, x1 + 112 + 7, (i + 168) - 48, 0x10 | 4);
        g.drawImage(wall, x1 + 68 + 8, (i + 168) - 48, 0x10 | 4);
        g.drawImage(wall, x1 + 24 + 9, (i + 168) - 48, 0x10 | 4);
        g.drawImage(wall, (x1 - 20) + 10, (i + 168) - 48, 0x10 | 4);
        g.setClip(0, 0, WIDTH, HEIGHT);
    }

    public void drawPanel(Graphics g)
    {
        if(me != null)
        {
            short word0 = me.health;
            g.setColor(255, 255, 0);
            g.setFont(Font.getFont(0, 0, 8));
            g.drawString("" + score, 10, 12, 4 | 0x10);
            if(word0 > 120)
                word0 = 120;
            g.setColor(255, 255, 0);
            g.fillRect(10, 6, 60, 4);
            g.setColor(255, 0, 0);
            g.fillRect(10, 6, word0 / 2, 4);
        }
        Enumeration enumeration = enemyMan.elements();
        if(lvl == 1)
        {
            g.setColor(255, 255, 0);
            g.fillRect(103, 6, 60, 4);
        } else
        if(lvl == 2)
        {
            g.setColor(255, 255, 0);
            g.fillRect(103, 6, 60, 4);
            g.setColor(255, 255, 0);
            g.fillRect(103, 12, 60, 4);
        } else
        if(lvl == 3)
        {
            g.setColor(255, 255, 0);
            g.fillRect(103, 6, 60, 4);
            g.setColor(255, 255, 0);
            g.fillRect(103, 12, 60, 4);
            g.setColor(255, 255, 0);
            g.fillRect(103, 18, 60, 4);
        }
        while(enumeration.hasMoreElements()) 
        {
            Enemy enemy = (Enemy)enumeration.nextElement();
            if(enemyMan.indexOf(enemy) == 0)
            {
                g.setColor(75, 176, 47);
                g.fillRect(103, 6, enemy.health, 4);
            } else
            if(enemyMan.indexOf(enemy) == 1)
            {
                g.setColor(75, 176, 47);
                g.fillRect(103, 12, enemy.health, 4);
            } else
            if(enemyMan.indexOf(enemy) == 2)
            {
                g.setColor(75, 176, 47);
                g.fillRect(103, 18, enemy.health, 4);
            }
        }
    }

    public void resetLevel()
    {
        lastlevel = level;
        lastscore = score;
        lasthealth = me.health;
        levelWeapon = weapon2;
        try
        {
            GameOver = false;
            if(level > 20)
                GameOver = true;
            if(me == null)
                me = new Fighter((short)108, (short)176, this);
            me.y = me.maxY;
            me.action = 13;
            me.isWeapon = false;
            me.weapon = 35;
            me.hit = false;
            me.backAttack = false;
            me.jt = 0;
            me.axeJumpCtr = 0;
            me.chainJumpCtr = 0;
            me.Armor[0] = 127;
            bonus = 0;
            me.weaponPicked = false;
            ptr.removeAllElements();
            enemyMan.removeAllElements();
            addPoints();
            addEnemy();
        }
        catch(Exception exception)
        {
            System.out.println("herer" + exception);
        }
    }

    public void restartGame()
    {
        try
        {
            GamePaused = false;
            GameOver = false;
            level = 1;
        }
        catch(Exception exception)
        {
            System.out.println("herer" + exception);
        }
        if(lvl == 127)
            lvl = 1;
        if(me == null)
            me = new Fighter((short)108, (short)176, this);
        cheatL = 0;
        me.fr = 0;
        me.health = 120;
        me.x = 108;
        me.y = me.maxY;
        me.action = 13;
        me.isWeapon = false;
        me.hit = false;
        me.backAttack = false;
        me.weaponPicked = false;
        me.jt = 0;
        me.axeJumpCtr = 0;
        me.chainJumpCtr = 0;
        strypg = 0;
        msglp = -30;
        lag = 0L;
        lightening = false;
        m = 10;
        p = 0;
        q = 0;
        search = false;
        score = 0;
        me.Armor[0] = 127;
        weapon2 = 127;
        bonus = 0;
        lastlevel = 1;
        lastscore = 0;
        lasthealth = 120;
        ptr.removeAllElements();
        enemyMan.removeAllElements();
        RoadArms.removeAllElements();
        addPoints();
        addEnemy();
    }

    public void restartGame(String s)
    {
        GamePaused = false;
        if(me == null)
            me = new Fighter((short)108, (short)176, this);
        try
        {
            lvl = Byte.parseByte(s.substring(0, s.indexOf(':')));
            level = Short.parseShort(s.substring(s.indexOf(':') + 1, s.indexOf('@')));
            score = Integer.parseInt(s.substring(s.indexOf('@') + 1, s.indexOf('*')));
            me.health = Short.parseShort(s.substring(s.indexOf('*') + 1, s.indexOf('#')));
            levelWeapon = Byte.parseByte(s.substring(s.indexOf('#') + 1));
        }
        catch(Exception exception)
        {
            System.out.println("Here is an exception in reading Game settings" + exception);
        }
        me.health = 120;
        me.x = 108;
        me.y = me.maxY;
        me.action = 13;
        me.isWeapon = false;
        me.hit = false;
        me.backAttack = false;
        cheatL = 0;
        me.weaponPicked = false;
        me.jt = 0;
        me.axeJumpCtr = 0;
        me.chainJumpCtr = 0;
        bonus = 0;
        lastlevel = level;
        if(level > 4)
        {
            RoadArms.removeAllElements();
            weapon2 = levelWeapon;
            RoadArms.addElement(new Arms(weapon2, (short)270, (short)192));
        }
        ptr.removeAllElements();
        enemyMan.removeAllElements();
        addPoints();
        addEnemy();
    }

    public void makeSound()
    {
        Class class1 = getClass();
        try
        {
            p1 = Manager.createPlayer(class1.getResourceAsStream("/Punch.wav"), "audio/wav");
            p1.realize();
            p1.prefetch();
        }
        catch(MediaException mediaexception)
        {
            System.out.println(" throwing media exception = " + mediaexception);
            mediaexception.printStackTrace();
        }
        catch(IOException ioexception)
        {
            System.out.println("1 testing sound " + ioexception);
        }
        catch(Exception exception)
        {
            System.out.println(" throwing exception = " + exception);
        }
    }

    public void gameEffects(String s)
    {
        if(isSoundOn)
            try
            {
                if(s.equals("punch") || s.equals("hit"))
                    p1.start();
            }
            catch(MediaException mediaexception)
            {
                System.out.println("game--effect--Media--exception = " + mediaexception);
                mediaexception.printStackTrace();
            }
            catch(Exception exception)
            {
                System.out.println("game effect exception = " + exception);
                exception.printStackTrace();
            }
    }

    public void searchAnimation(Graphics g)
    {
        search = true;
        switch(q)
        {
        case 0: // '\0'
            g.setClip((me.x - 30) + x1, 146, 60, 60);
            g.clipRect((me.x - 30) + x1, 146, 60, 60);
            g.drawRegion(playerIm, 0, 0, 60, 60, 2, (me.x - 30) + x1, 146, 0x10 | 4);
            q++;
            break;

        case 1: // '\001'
            g.setClip((me.x - 30) + x1, 146, 60, 60);
            g.clipRect((me.x - 30) + x1, 146, 60, 60);
            g.drawRegion(playerIm, 60, 0, 60, 60, 2, (me.x - 30) + x1, 146, 0x10 | 4);
            q = 0;
            break;
        }
        g.setClip(0, 0, WIDTH, HEIGHT);
        me.x += 3;
    }

    int WIDTH;
    int HEIGHT;
    int selRectPos;
    GameCanvas Gc;
    boolean GameStart;
    boolean GameOver;
    boolean GamePaused;
    int score;
    byte lvl;
    short level;
    boolean isSoundOn;
    boolean isVibratorOn;
    int lastscore;
    short lasthealth;
    short lastlevel;
    Image playerIm;
    Image dieIm;
    Image axeIm;
    Image chainIm;
    Image no;
    Image building;
    Image wall;
    Image vanish;
    Image fighterHit;
    Image armsIm;
    Random rnd;
    GameSettings gameSettings;
    String temp;
    short gameOverCtr;
    short resetCtr;
    short enemyRemoveCtr;
    Fighter me;
    Enemy you;
    Vector RoadArms;
    Vector enemyMan;
    Vector ptr;
    MidPlayer mp;
    Player p1;
    Player p2;
    public static int bgWIDTH = 450;
    short waitCtr;
    byte State;
    short cheatL;
    byte weapon2;
    short scorpioCtr;
    short y2;
    boolean vanishFlag;
    long prevtime;
    boolean hitting;
    int index;
    int bonus;
    int x1;
    byte levelWeapon;
    byte strypg;
    short msglp;
    long lag;
    boolean lightening;
    int m;
    int p;
    int q;
    boolean search;

}