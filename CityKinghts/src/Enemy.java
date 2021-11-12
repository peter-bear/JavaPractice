// Decompiled by DJ v3.9.9.91 Copyright 2005 Atanas Neshkov  Date: 2005-11-26 11:40:38
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 

import java.util.*;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

class Enemy
    implements Constants
{

    public Enemy(short word0, short word1, byte byte0, Game game1)
    {
        action = 13;
        isWeapon = false;
        ehit = false;
        ebackAttack = false;
        emoving = false;
        emaxY = 176;
        ehitCtr = 0;
        ecrouchCtr = 0;
        eweaponPicked = false;
        ecrouchHit = false;
        playerHit = false;
        jpCtr = 0;
        e_lag = System.currentTimeMillis();
        echainJumpCtr = 0;
        eaxeJumpCtr = 0;
        delayCtr = 0;
        x = word0;
        y = word1;
        game = game1;
        weapon = byte0;
        health = 60;
        action = 13;
        face = 26;
        if(byte0 != 34 && byte0 != 35 && byte0 != 33)
            isWeapon = true;
        else
            isWeapon = false;
    }

    public void updateAI()
    {
        Dist = (short)Math.abs(x - game.me.x);
        if(y == emaxY && !isWeapon)
            if(x - game.me.x < 0)
                face = 27;
            else
                face = 26;
        enemyCtr++;
        if(enemyCtr == 50)
            enemyCtr = 0;
        if(y < emaxY)
        {
            if(!isWeapon)
                switch(jpCtr)
                {
                case 0: // '\0'
                    y -= 25;
                    jpCtr++;
                    break;

                case 1: // '\001'
                    y -= 20;
                    jpCtr++;
                    break;

                case 2: // '\002'
                    y -= 7;
                    jpCtr++;
                    break;

                case 3: // '\003'
                    y -= 5;
                    jpCtr++;
                    break;

                case 4: // '\004'
                    y -= 2;
                    jpCtr++;
                    break;

                case 5: // '\005'
                    y += 2;
                    jpCtr++;
                    break;

                case 6: // '\006'
                    y += 5;
                    jpCtr++;
                    break;

                case 7: // '\007'
                    y += 7;
                    jpCtr++;
                    break;

                case 8: // '\b'
                    y += 20;
                    jpCtr++;
                    break;

                case 9: // '\t'
                    y += 25;
                    jpCtr = 0;
                    action = 13;
                    break;
                }
            if(weapon == 39 && (action == 16 || action == 13))
                switch(eaxeJumpCtr)
                {
                case 0: // '\0'
                    y -= 25;
                    eaxeJumpCtr++;
                    break;

                case 1: // '\001'
                    y -= 20;
                    eaxeJumpCtr++;
                    break;

                case 2: // '\002'
                    y -= 7;
                    eaxeJumpCtr++;
                    break;

                case 3: // '\003'
                    y -= 5;
                    eaxeJumpCtr++;
                    break;

                case 4: // '\004'
                    y -= 2;
                    eaxeJumpCtr++;
                    break;

                case 5: // '\005'
                    y += 2;
                    eaxeJumpCtr++;
                    break;

                case 6: // '\006'
                    y += 5;
                    eaxeJumpCtr++;
                    break;

                case 7: // '\007'
                    y += 7;
                    eaxeJumpCtr++;
                    break;

                case 8: // '\b'
                    y += 20;
                    eaxeJumpCtr++;
                    break;

                case 9: // '\t'
                    y += 25;
                    eaxeJumpCtr = 0;
                    action = 13;
                    break;
                }
            if(weapon == 41 && action == 16)
                switch(echainJumpCtr)
                {
                case 0: // '\0'
                    y -= 15;
                    echainJumpCtr++;
                    break;

                case 1: // '\001'
                    y -= 10;
                    echainJumpCtr++;
                    break;

                case 2: // '\002'
                    y -= 3;
                    echainJumpCtr++;
                    break;

                case 3: // '\003'
                    y -= 2;
                    echainJumpCtr++;
                    break;

                case 4: // '\004'
                    y--;
                    echainJumpCtr++;
                    break;

                case 5: // '\005'
                    y++;
                    echainJumpCtr++;
                    break;

                case 6: // '\006'
                    y += 2;
                    echainJumpCtr++;
                    break;

                case 7: // '\007'
                    y += 3;
                    echainJumpCtr++;
                    break;

                case 8: // '\b'
                    y += 10;
                    echainJumpCtr++;
                    break;

                case 9: // '\t'
                    y += 15;
                    echainJumpCtr = 0;
                    action = 13;
                    break;
                }
        }
        if(action == 19)
        {
            fr++;
            if(fr > 5 || fr > 4)
                fr = 0;
        } else
        if(action == 13 && jpCtr == 0)
        {
            y = emaxY;
            if(!ebackAttack)
                fr = 0;
        } else
        if(action == 16)
        {
            if(jpCtr == 0 && y >= emaxY && !isWeapon)
            {
                y -= 25;
                jpCtr = 1;
                action = 13;
            }
            if(eaxeJumpCtr == 0 && y >= emaxY && weapon == 39)
            {
                y -= 25;
                eaxeJumpCtr = 1;
            }
            if(echainJumpCtr == 0 && y >= emaxY && weapon == 41)
            {
                y -= 15;
                echainJumpCtr = 1;
            }
        } else
        if(action == 14)
        {
            if(!isWeapon)
            {
                if(face == 26)
                    x -= 5;
                else
                    x += 5;
                fr++;
                if(fr > 1)
                {
                    fr = 0;
                    action = 13;
                }
            }
            if(weapon == 41)
            {
                if(face == 26)
                    x -= 5;
                else
                    x += 5;
                fr++;
                if(fr > 1)
                {
                    fr = 0;
                    action = 13;
                }
            }
            if(weapon == 39)
            {
                if(face == 26)
                    x -= 5;
                else
                    x += 5;
                fr++;
                if(fr > 1)
                {
                    fr = 0;
                    action = 13;
                }
            }
        } else
        if(action == 15)
        {
            y = emaxY;
            if(!isWeapon)
            {
                switch((game.rnd.nextInt() >> 1) % 3)
                {
                case 0: // '\0'
                    weapon = 34;
                    break;

                case 1: // '\001'
                    weapon = 35;
                    break;

                case 2: // '\002'
                    weapon = 33;
                    break;
                }
                isWeapon = false;
            }
            if(!isWeapon)
            {
                if(weapon == 35)
                {
                    if(System.currentTimeMillis() % 3L == 0L)
                    {
                        if(face == 26)
                            x -= 5;
                        else
                            x += 5;
                        action = 13;
                    }
                } else
                if(weapon == 34)
                {
                    if(System.currentTimeMillis() % 3L == 0L)
                    {
                        fr++;
                        if(face == 26)
                            x -= 5;
                        else
                            x += 5;
                    }
                    if(fr > 1)
                    {
                        fr = 0;
                        action = 13;
                    }
                } else
                if(weapon == 33 && System.currentTimeMillis() % 7L == 0L)
                    action = 13;
            } else
            {
                if(weapon == 41)
                {
                    if(enemyCtr % 2 == 0)
                        fr++;
                    if(fr > 4)
                    {
                        fr = 0;
                        action = 13;
                    }
                } else
                if(weapon == 39)
                {
                    if(enemyCtr % 3 == 0)
                        fr++;
                    if(fr > 2)
                    {
                        fr = 0;
                        action = 13;
                    }
                }
                if(weapon != 34 && weapon != 35 && weapon != 33)
                    isWeapon = true;
            }
        } else
        if(action == 17)
        {
            if(!isWeapon)
                action = 13;
            if(weapon == 41)
            {
                if(enemyCtr % 3 == 0)
                {
                    if(face == 26)
                        x += 4;
                    else
                        x -= 4;
                    fr++;
                }
                if(fr > 1)
                {
                    fr = 0;
                    action = 13;
                }
            } else
            if(weapon == 39)
            {
                if(enemyCtr % 3 == 0)
                {
                    if(face == 26)
                        x += 5;
                    else
                        x -= 5;
                    fr++;
                }
                if(fr > 2)
                {
                    fr = 0;
                    action = 13;
                }
            }
        }
        for(Enumeration enumeration = game.RoadArms.elements(); enumeration.hasMoreElements();)
        {
            Arms arms = (Arms)enumeration.nextElement();
            if(!eweaponPicked && !isWeapon && game.weapon2 != 127 && game.weapon2 != 35 && x + 5 >= arms.x && x - 5 <= arms.x && y == emaxY)
            {
                eweaponPicked = true;
                weapon = game.weapon2;
                action = 13;
                isWeapon = true;
                game.weapon2 = 127;
                game.RoadArms.removeElement(arms);
            }
        }

        if((ebackAttack || ehit && System.currentTimeMillis() % 5L == 0L) && eweaponPicked && isWeapon)
        {
            if(x > 50 && x <= 400)
                if(face == 26)
                    game.RoadArms.addElement(new Arms(weapon, (short)(x - 5), (short)192));
                else
                    game.RoadArms.addElement(new Arms(weapon, (short)(x + 5), (short)192));
            eweaponPicked = false;
            isWeapon = false;
            game.weapon2 = weapon;
            action = 13;
            weapon = 35;
            fr = 0;
        }
        if(game.enemyMan.size() == 1)
        {
            if(!isWeapon)
            {
                if((Dist > 60 || Dist >= 35) && action != 19)
                {
                    if(System.currentTimeMillis() % 7L == 0L)
                        action = 16;
                    else
                        action = 14;
                } else
                if(Dist <= 35 && Dist >= 20 && action != 15 && action != 19)
                    action = 13;
                if((action == 13 || action == 16) && enemyCtr % 5 == 0 && !game.me.backAttack)
                    action = 15;
                if(jpCtr > 0 && y < emaxY && action != 19 && System.currentTimeMillis() % 3L == 0L)
                {
                    action = 19;
                    fr = 0;
                }
                if(Dist < 11 && y >= emaxY && game.me.y == game.me.maxY)
                    if(face == 26)
                        x -= 30;
                    else
                        x += 30;
            } else
            if(weapon == 41 || weapon == 39)
            {
                if(Dist > 20 && !ebackAttack)
                    if(x - game.me.x < 0)
                        face = 27;
                    else
                        face = 26;
                if(y >= emaxY)
                {
                    echainJumpCtr = 0;
                    eaxeJumpCtr = 0;
                }
                if(delayCtr == 0 && !ehit && !ebackAttack)
                {
                    if((Dist > 60 || Dist >= 35) && System.currentTimeMillis() % 2L == 0L)
                        action = 16;
                    if(Dist >= 20 && Dist <= 35)
                        action = 14;
                    if(Dist < 20)
                        if(game.me.action == 15 && System.currentTimeMillis() % 3L == 0L)
                            action = 17;
                        else
                        if(game.me.y >= emaxY && !game.me.backAttack)
                            action = 15;
                }
                if(action == 13)
                    delayCtr++;
                if(Dist < 11 && y >= emaxY && game.me.y >= game.me.maxY)
                    if(face == 26)
                        x -= 40;
                    else
                        x += 40;
                if(delayCtr == 12)
                    delayCtr = 0;
            }
        } else
        if(!isWeapon)
        {
            if((Dist > 60 || Dist >= 35) && action != 19)
            {
                if(System.currentTimeMillis() % 7L == 0L)
                    action = 16;
                else
                    action = 14;
            } else
            if(Dist <= 35 && Dist >= 20 && action != 15 && action != 19)
                action = 13;
            if((action == 13 || action == 16) && action != 15 && enemyCtr % 7 == 0 && !game.me.backAttack)
                action = 15;
            if(jpCtr > 0 && y < emaxY && action != 19 && System.currentTimeMillis() % 3L == 0L)
            {
                action = 19;
                fr = 0;
            }
            if(Dist < 11 && y >= emaxY && game.me.y == game.me.maxY)
                if(face == 26)
                    x -= 30;
                else
                    x += 30;
        } else
        {
            if(Dist > 20 && !ebackAttack)
                if(x - game.me.x < 0)
                    face = 27;
                else
                    face = 26;
            if(y >= emaxY)
            {
                echainJumpCtr = 0;
                eaxeJumpCtr = 0;
            }
            if(delayCtr == 0 && !ehit && !ebackAttack)
            {
                if((Dist > 60 || Dist >= 35) && System.currentTimeMillis() % 2L == 0L)
                    action = 16;
                if(Dist >= 20 && Dist <= 35)
                    action = 14;
                if(Dist < 20)
                    if(game.me.action == 15 && System.currentTimeMillis() % 3L == 0L)
                        action = 17;
                    else
                    if(game.me.y >= emaxY && !game.me.backAttack && action != 15)
                        action = 15;
            }
            if(action == 13)
                delayCtr++;
            if(Dist < 11 && y >= emaxY && game.me.y >= game.me.maxY)
                if(face == 26)
                    x -= 40;
                else
                    x += 40;
            if(delayCtr == 12)
                delayCtr = 0;
        }
        if(face != game.me.face)
            if(Dist <= 35 && game.enemyMan.size() == 1 || Dist <= 35 && game.enemyMan.size() > 1 && game.index == game.enemyMan.indexOf(this))
            {
                if(game.me.weapon == 35 && game.me.action == 15 && y == game.me.y)
                {
                    if(!isWeapon && action != 17)
                    {
                        health -= 2;
                        ehit = true;
                        game.gameEffects("punch");
                        game.score += 20;
                    }
                } else
                if(game.me.weapon == 34 && game.me.action == 15 && game.me.fr == 1 && Math.abs(game.me.y - y) <= 5)
                {
                    health -= 4;
                    ehit = true;
                    game.gameEffects("hit");
                    game.score += 40;
                } else
                if(game.me.weapon == 41 && game.me.action == 15 && game.me.fr == 1 && y >= game.me.y - 5 && action != 17)
                {
                    health -= 4;
                    ehit = true;
                    game.gameEffects("hit");
                    if(face == game.me.face)
                        ebackAttack = true;
                    game.score += 30;
                } else
                if(game.me.weapon == 39 && game.me.action == 15 && game.me.fr == 1 && y >= game.me.y - 5 && action != 17)
                {
                    health -= 5;
                    ehit = true;
                    game.gameEffects("hit");
                    if(face == game.me.face)
                        ebackAttack = true;
                    game.score += 50;
                }
            } else
            if(Dist <= 26 && game.me.weapon == 33 && y >= game.me.y - 5 && face != game.me.face)
            {
                ehit = true;
                game.gameEffects("hit");
            }
        if(ehit && !ebackAttack)
            ehitCtr++;
        else
            ehitCtr = 0;
        if(ehitCtr != 0)
            if(face == 26)
            {
                x += 10;
                if(x > 400)
                    ehit = false;
            } else
            {
                x -= 10;
                if(x < 50)
                    ehit = false;
            }
        checkBound();
    }

    public void checkBound()
    {
        if(x < 50)
        {
            x = 50;
            face = 27;
        } else
        if(x > 400)
        {
            x = 400;
            face = 26;
        }
    }

    public void drawEnemy(Graphics g)
    {
        if(!ehit)
            switch(action)
            {
            case 18: // '\022'
            default:
                break;

            case 13: // '\r'
                drawEnemyStand(g);
                break;

            case 14: // '\016'
                if(weapon == 41)
                {
                    enemyChainWalk(g);
                    break;
                }
                if(weapon == 39)
                    enemyAxeWalk(g);
                else
                    drawEnemyWalk(g);
                break;

            case 16: // '\020'
                if(weapon == 41)
                {
                    enemyChainJump(g);
                    break;
                }
                if(weapon == 39)
                    enemyAxeJump(g);
                else
                    drawEnemyJump(g);
                break;

            case 15: // '\017'
                switch(weapon)
                {
                case 34: // '"'
                    drawEnemyKick(g);
                    break;

                case 35: // '#'
                    drawEnemyPunch(g);
                    break;

                case 33: // '!'
                    drawEnemyKick(g);
                    break;

                case 39: // '\''
                    drawAxeFight(g);
                    break;

                case 41: // ')'
                    drawChainFight(g);
                    break;
                }
                break;

            case 17: // '\021'
                switch(weapon)
                {
                case 41: // ')'
                    drawChainFight(g);
                    break;

                case 39: // '\''
                    drawAxeFight(g);
                    break;
                }
                break;

            case 19: // '\023'
                drawEnemySumersalt(g);
                break;
            }
        if(game.me.health <= 0)
            action = 13;
        else
            updateAI();
    }

    public void eattackedAnimation(Graphics g)
    {
        int i = y - 10;
        if(ehit)
        {
            g.setClip((x - 11) + game.x1, i - 9, 22, 19);
            g.clipRect((x - 11) + game.x1, i - 9, 22, 19);
            g.drawImage(game.fighterHit, (((x + game.x1) - 11) + game.fighterHit.getWidth() / 2) - 22, (i - 9) + game.fighterHit.getHeight() / 2, 1 | 2);
        }
        g.setClip(0, 0, game.WIDTH, game.HEIGHT);
    }

    public void drawEnemySumersalt(Graphics g)
    {
        switch(face)
        {
        default:
            break;

        case 26: // '\032'
            switch(fr)
            {
            case 4: // '\004'
            case 5: // '\005'
                g.setClip((x - 31) + game.x1, y - 31, 62, 62);
                g.clipRect((x - 31) + game.x1, y - 31, 62, 62);
                g.drawRegion(game.playerIm, 120, 60, 60, 60, 5, (x - 31) + game.x1, y - 31, 0x10 | 4);
                action = 13;
                break;

            case 2: // '\002'
            case 3: // '\003'
                g.setClip((x - 31) + game.x1, y - 31, 62, 62);
                g.clipRect((x - 31) + game.x1, y - 31, 62, 62);
                g.drawRegion(game.playerIm, 120, 60, 60, 60, 3, (x - 31) + game.x1, y - 31, 0x10 | 4);
                x -= 10;
                break;

            case 0: // '\0'
            case 1: // '\001'
                g.setClip((x - 31) + game.x1, y - 31, 62, 62);
                g.clipRect((x - 31) + game.x1, y - 31, 62, 62);
                g.drawRegion(game.playerIm, 120, 60, 60, 60, 6, (x - 31) + game.x1, y - 31, 0x10 | 4);
                x -= 10;
                break;
            }
            break;

        case 27: // '\033'
            switch(fr)
            {
            case 0: // '\0'
            case 1: // '\001'
                g.setClip((x - 31) + game.x1, y - 31, 62, 62);
                g.clipRect((x - 31) + game.x1, y - 31, 62, 62);
                g.drawRegion(game.playerIm, 120, 60, 60, 60, 5, (x - 31) + game.x1, y - 31, 0x10 | 4);
                x += 10;
                break;

            case 2: // '\002'
            case 3: // '\003'
                g.setClip((x - 31) + game.x1, y - 31, 62, 62);
                g.clipRect((x - 31) + game.x1, y - 31, 62, 62);
                g.drawRegion(game.playerIm, 120, 60, 60, 60, 3, (x - 31) + game.x1, y - 31, 0x10 | 4);
                x += 10;
                break;

            case 4: // '\004'
            case 5: // '\005'
                g.setClip((x - 31) + game.x1, y - 31, 62, 62);
                g.clipRect((x - 31) + game.x1, y - 31, 62, 62);
                g.drawRegion(game.playerIm, 120, 60, 60, 60, 6, (x - 31) + game.x1, y - 31, 0x10 | 4);
                action = 13;
                break;
            }
            break;
        }
        checkBound();
        g.setClip(0, 0, game.WIDTH, game.HEIGHT);
    }

    public void drawEnemyPunch(Graphics g)
    {
        switch(face)
        {
        case 26: // '\032'
            g.setClip((x - 30) + game.x1, y - 30, 60, 60);
            g.clipRect((x - 30) + game.x1, y - 30, 60, 60);
            g.drawImage(game.playerIm, (x + game.x1 + game.playerIm.getWidth() / 2) - 30 - 180, (y + game.playerIm.getHeight() / 2) - 30 - 60, 1 | 2);
            break;

        case 27: // '\033'
            g.setClip((x - 30) + game.x1, y - 30, 60, 60);
            g.clipRect((x - 30) + game.x1, y - 30, 60, 60);
            g.drawRegion(game.playerIm, 180, 60, 60, 60, 2, (x - 30) + game.x1, y - 30, 0x10 | 4);
            break;
        }
        g.setClip(0, 0, game.WIDTH, game.HEIGHT);
    }

    public void drawEnemyKick(Graphics g)
    {
        if(weapon == 34)
            switch(face)
            {
            case 26: // '\032'
                switch(fr)
                {
                case 0: // '\0'
                    g.setClip((x - 30) + game.x1, y - 30, 60, 60);
                    g.clipRect((x - 30) + game.x1, y - 30, 60, 60);
                    g.drawImage(game.playerIm, (x + game.x1 + game.playerIm.getWidth() / 2) - 30 - 240, (y + game.playerIm.getHeight() / 2) - 30 - 60, 1 | 2);
                    break;

                case 1: // '\001'
                    g.setClip((x - 30) + game.x1, y - 30, 60, 60);
                    g.clipRect((x - 30) + game.x1, y - 30, 60, 60);
                    g.drawImage(game.playerIm, (x + game.x1 + game.playerIm.getWidth() / 2) - 30 - 300, (y + game.playerIm.getHeight() / 2) - 30 - 60, 1 | 2);
                    break;
                }
                g.setClip(0, 0, game.WIDTH, game.HEIGHT);
                break;

            case 27: // '\033'
                switch(fr)
                {
                case 0: // '\0'
                    g.setClip((x - 30) + game.x1, y - 30, 60, 60);
                    g.clipRect((x - 30) + game.x1, y - 30, 60, 60);
                    g.drawRegion(game.playerIm, 240, 60, 60, 60, 2, (x - 30) + game.x1, y - 30, 0x10 | 4);
                    break;

                case 1: // '\001'
                    g.setClip((x - 30) + game.x1, y - 30, 60, 60);
                    g.clipRect((x - 30) + game.x1, y - 30, 60, 60);
                    g.drawRegion(game.playerIm, 300, 60, 60, 60, 2, (x - 30) + game.x1, y - 30, 0x10 | 4);
                    break;
                }
                g.setClip(0, 0, game.WIDTH, game.HEIGHT);
                break;
            }
        else
        if(weapon == 33)
        {
            switch(face)
            {
            case 26: // '\032'
                g.setClip((x - 30) + game.x1, y - 30, 60, 60);
                g.clipRect((x - 30) + game.x1, y - 30, 60, 60);
                g.drawImage(game.playerIm, (x + game.x1 + game.playerIm.getWidth() / 2) - 30 - 360, (y + game.playerIm.getHeight() / 2) - 30 - 60, 1 | 2);
                break;

            case 27: // '\033'
                g.setClip((x - 30) + game.x1, y - 30, 60, 60);
                g.clipRect((x - 30) + game.x1, y - 30, 60, 60);
                g.drawRegion(game.playerIm, 360, 60, 60, 60, 2, (x - 30) + game.x1, y - 30, 0x10 | 4);
                break;
            }
            g.setClip(0, 0, game.WIDTH, game.HEIGHT);
            if(System.currentTimeMillis() % 5L == 0L)
                ehit = false;
        }
    }

    public void drawEnemyJump(Graphics g)
    {
        switch(face)
        {
        case 26: // '\032'
            g.setClip((x - 30) + game.x1, y - 30, 60, 60);
            g.clipRect((x - 30) + game.x1, y - 30, 60, 60);
            g.drawImage(game.playerIm, (x + game.x1 + game.playerIm.getWidth() / 2) - 30 - 120, (y + game.playerIm.getHeight() / 2) - 30 - 60, 1 | 2);
            break;

        case 27: // '\033'
            g.setClip((x - 30) + game.x1, y - 30, 60, 60);
            g.clipRect((x - 30) + game.x1, y - 30, 60, 60);
            g.drawRegion(game.playerIm, 120, 60, 60, 60, 2, (x - 30) + game.x1, y - 30, 0x10 | 4);
            break;
        }
        g.setClip(0, 0, game.WIDTH, game.HEIGHT);
    }

    public void drawEnemyStand(Graphics g)
    {
        if(!isWeapon)
        {
            switch(face)
            {
            case 26: // '\032'
                g.setClip((x - 30) + game.x1, y - 30, 60, 60);
                g.clipRect((x - 30) + game.x1, y - 30, 60, 60);
                g.drawImage(game.playerIm, (x + game.x1 + game.playerIm.getWidth() / 2) - 30 - 120, (y + game.playerIm.getHeight() / 2) - 30 - 60, 1 | 2);
                break;

            case 27: // '\033'
                g.setClip((x - 30) + game.x1, y - 30, 60, 60);
                g.clipRect((x - 30) + game.x1, y - 30, 60, 60);
                g.drawRegion(game.playerIm, 120, 60, 60, 60, 2, (x - 30) + game.x1, y - 30, 0x10 | 4);
                break;
            }
            g.setClip(0, 0, game.WIDTH, game.HEIGHT);
        } else
        {
            switch(weapon)
            {
            default:
                break;

            case 39: // '\''
                switch(face)
                {
                case 26: // '\032'
                    g.setClip((x - 32) + game.x1, y - 36, 64, 72);
                    g.clipRect((x - 32) + game.x1, y - 36, 64, 72);
                    g.drawRegion(game.axeIm, 256, 72, 64, 72, 2, (x - 32) + game.x1, y - 36, 0x10 | 4);
                    break;

                case 27: // '\033'
                    g.setClip((x - 32) + game.x1, y - 36, 64, 72);
                    g.clipRect((x - 32) + game.x1, y - 36, 64, 72);
                    g.drawImage(game.axeIm, (((x + game.x1) - 32) + game.axeIm.getWidth() / 2) - 256, ((y - 36) + game.axeIm.getHeight() / 2) - 72, 1 | 2);
                    break;
                }
                g.setClip(0, 0, game.WIDTH, game.HEIGHT);
                break;

            case 41: // ')'
                switch(face)
                {
                case 27: // '\033'
                    g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                    g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                    g.drawRegion(game.chainIm, 272, 64, 68, 64, 2, (x - 34) + game.x1, y - 32, 0x10 | 4);
                    break;

                case 26: // '\032'
                    g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                    g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                    g.drawImage(game.chainIm, (((x + game.x1) - 34) + game.chainIm.getWidth() / 2) - 272, ((y - 32) + game.chainIm.getHeight() / 2) - 64, 1 | 2);
                    break;
                }
                g.setClip(0, 0, game.WIDTH, game.HEIGHT);
                break;
            }
        }
    }

    public void drawEnemyWalk(Graphics g)
    {
        switch(fr)
        {
        default:
            break;

        case 0: // '\0'
            switch(face)
            {
            case 26: // '\032'
                g.setClip((x - 30) + game.x1, y - 30, 60, 60);
                g.clipRect((x - 30) + game.x1, y - 30, 60, 60);
                g.drawImage(game.playerIm, (x + game.x1 + game.playerIm.getWidth() / 2) - 30, (y + game.playerIm.getHeight() / 2) - 30 - 60, 1 | 2);
                break;

            case 27: // '\033'
                g.setClip((x - 30) + game.x1, y - 30, 60, 60);
                g.clipRect((x - 30) + game.x1, y - 30, 60, 60);
                g.drawRegion(game.playerIm, 0, 60, 60, 60, 2, (x - 30) + game.x1, y - 30, 0x10 | 4);
                break;
            }
            g.setClip(0, 0, game.WIDTH, game.HEIGHT);
            break;

        case 1: // '\001'
            switch(face)
            {
            case 26: // '\032'
                g.setClip((x - 30) + game.x1, y - 30, 60, 60);
                g.clipRect((x - 30) + game.x1, y - 30, 60, 60);
                g.drawImage(game.playerIm, (x + game.x1 + game.playerIm.getWidth() / 2) - 30 - 60, (y + game.playerIm.getHeight() / 2) - 30 - 60, 1 | 2);
                break;

            case 27: // '\033'
                g.setClip((x - 30) + game.x1, y - 30, 60, 60);
                g.clipRect((x - 30) + game.x1, y - 30, 60, 60);
                g.drawRegion(game.playerIm, 60, 60, 60, 60, 2, (x - 30) + game.x1, y - 30, 0x10 | 4);
                break;
            }
            g.setClip(0, 0, game.WIDTH, game.HEIGHT);
            break;
        }
    }

    public void enemyAxeJump(Graphics g)
    {
        switch(face)
        {
        case 26: // '\032'
            x -= 2;
            g.setClip((x - 32) + game.x1, y - 36, 64, 72);
            g.clipRect((x - 32) + game.x1, y - 36, 64, 72);
            g.drawRegion(game.axeIm, 0, 72, 64, 72, 2, (x - 32) + game.x1, y - 36, 0x10 | 4);
            break;

        case 27: // '\033'
            x += 2;
            g.setClip((x - 32) + game.x1, y - 36, 64, 72);
            g.clipRect((x - 32) + game.x1, y - 36, 64, 72);
            g.drawImage(game.axeIm, (((x + game.x1) - 32) + game.axeIm.getWidth() / 2) - 0, ((y - 36) + game.axeIm.getHeight() / 2) - 72, 1 | 2);
            break;
        }
        g.setClip(0, 0, game.WIDTH, game.HEIGHT);
    }

    public void enemyAxeWalk(Graphics g)
    {
        switch(face)
        {
        default:
            break;

        case 26: // '\032'
            switch(fr)
            {
            case 1: // '\001'
                g.setClip((x - 32) + game.x1, y - 36, 64, 72);
                g.clipRect((x - 32) + game.x1, y - 36, 64, 72);
                g.drawRegion(game.axeIm, 0, 72, 64, 72, 2, (x - 32) + game.x1, y - 36, 0x10 | 4);
                break;

            case 0: // '\0'
                g.setClip((x - 32) + game.x1, y - 36, 64, 72);
                g.clipRect((x - 32) + game.x1, y - 36, 64, 72);
                g.drawRegion(game.axeIm, 256, 72, 64, 72, 2, (x - 32) + game.x1, y - 36, 0x10 | 4);
                break;
            }
            break;

        case 27: // '\033'
            switch(fr)
            {
            case 1: // '\001'
                g.setClip((x - 32) + game.x1, y - 36, 64, 72);
                g.clipRect((x - 32) + game.x1, y - 36, 64, 72);
                g.drawImage(game.axeIm, (((x + game.x1) - 32) + game.axeIm.getWidth() / 2) - 0, ((y - 36) + game.axeIm.getHeight() / 2) - 72, 1 | 2);
                break;

            case 0: // '\0'
                g.setClip((x - 32) + game.x1, y - 36, 64, 72);
                g.clipRect((x - 32) + game.x1, y - 36, 64, 72);
                g.drawImage(game.axeIm, (((x + game.x1) - 32) + game.axeIm.getWidth() / 2) - 256, ((y - 36) + game.axeIm.getHeight() / 2) - 72, 1 | 2);
                break;
            }
            break;
        }
        g.setClip(0, 0, game.WIDTH, game.HEIGHT);
    }

    public void drawAxeFight(Graphics g)
    {
        if(weapon == 39)
            if(action == 15)
                switch(face)
                {
                case 27: // '\033'
                    switch(fr)
                    {
                    case 0: // '\0'
                        g.setClip((x - 32) + game.x1, y - 36, 64, 72);
                        g.clipRect((x - 32) + game.x1, y - 36, 64, 72);
                        g.drawImage(game.axeIm, (((x + game.x1) - 32) + game.axeIm.getWidth() / 2) - 64, ((y - 36) + game.axeIm.getHeight() / 2) - 72, 1 | 2);
                        break;

                    case 1: // '\001'
                        g.setClip((x - 32) + game.x1, y - 36, 64, 72);
                        g.clipRect((x - 32) + game.x1, y - 36, 64, 72);
                        g.drawImage(game.axeIm, (((x + game.x1) - 32) + game.axeIm.getWidth() / 2) - 128, ((y - 36) + game.axeIm.getHeight() / 2) - 72, 1 | 2);
                        break;

                    case 2: // '\002'
                        g.setClip((x - 32) + game.x1, y - 36, 64, 72);
                        g.clipRect((x - 32) + game.x1, y - 36, 64, 72);
                        g.drawImage(game.axeIm, (((x + game.x1) - 32) + game.axeIm.getWidth() / 2) - 192, ((y - 36) + game.axeIm.getHeight() / 2) - 72, 1 | 2);
                        break;
                    }
                    g.setClip(0, 0, game.WIDTH, game.HEIGHT);
                    break;

                case 26: // '\032'
                    switch(fr)
                    {
                    case 0: // '\0'
                        g.setClip((x - 32) + game.x1, y - 36, 64, 72);
                        g.clipRect((x - 32) + game.x1, y - 36, 64, 72);
                        g.drawRegion(game.axeIm, 64, 72, 64, 72, 2, (x - 32) + game.x1, y - 36, 0x10 | 4);
                        break;

                    case 1: // '\001'
                        g.setClip((x - 32) + game.x1, y - 36, 64, 72);
                        g.clipRect((x - 32) + game.x1, y - 36, 64, 72);
                        g.drawRegion(game.axeIm, 128, 72, 64, 72, 2, (x - 32) + game.x1, y - 36, 0x10 | 4);
                        break;

                    case 2: // '\002'
                        g.setClip((x - 32) + game.x1, y - 36, 64, 72);
                        g.clipRect((x - 32) + game.x1, y - 36, 64, 72);
                        g.drawRegion(game.axeIm, 192, 72, 64, 72, 2, (x - 32) + game.x1, y - 36, 0x10 | 4);
                        break;
                    }
                    g.setClip(0, 0, game.WIDTH, game.HEIGHT);
                    break;
                }
            else
            if(action == 17)
                switch(face)
                {
                default:
                    break;

                case 26: // '\032'
                    switch(fr)
                    {
                    case 0: // '\0'
                        g.setClip((x - 32) + game.x1, y - 36, 64, 72);
                        g.clipRect((x - 32) + game.x1, y - 36, 64, 72);
                        g.drawRegion(game.axeIm, 0, 72, 64, 72, 2, (x - 32) + game.x1, y - 36, 0x10 | 4);
                        break;

                    case 1: // '\001'
                        g.setClip((x - 32) + game.x1, y - 36, 64, 72);
                        g.clipRect((x - 32) + game.x1, y - 36, 64, 72);
                        g.drawRegion(game.axeIm, 192, 72, 64, 72, 2, (x - 32) + game.x1, y - 36, 0x10 | 4);
                        break;

                    case 2: // '\002'
                        g.setClip((x - 32) + game.x1, y - 36, 64, 72);
                        g.clipRect((x - 32) + game.x1, y - 36, 64, 72);
                        g.drawRegion(game.axeIm, 256, 72, 64, 72, 2, (x - 32) + game.x1, y - 36, 0x10 | 4);
                        break;
                    }
                    g.setClip(0, 0, game.WIDTH, game.HEIGHT);
                    break;

                case 27: // '\033'
                    switch(fr)
                    {
                    case 0: // '\0'
                        g.setClip((x - 32) + game.x1, y - 36, 64, 72);
                        g.clipRect((x - 32) + game.x1, y - 36, 64, 72);
                        g.drawImage(game.axeIm, (((x + game.x1) - 32) + game.axeIm.getWidth() / 2) - 0, ((y - 36) + game.axeIm.getHeight() / 2) - 72, 1 | 2);
                        break;

                    case 1: // '\001'
                        g.setClip((x - 32) + game.x1, y - 36, 64, 72);
                        g.clipRect((x - 32) + game.x1, y - 36, 64, 72);
                        g.drawImage(game.axeIm, (((x + game.x1) - 32) + game.axeIm.getWidth() / 2) - 192, ((y - 36) + game.axeIm.getHeight() / 2) - 72, 1 | 2);
                        break;

                    case 2: // '\002'
                        g.setClip((x - 32) + game.x1, y - 36, 64, 72);
                        g.clipRect((x - 32) + game.x1, y - 36, 64, 72);
                        g.drawImage(game.axeIm, (((x + game.x1) - 32) + game.axeIm.getWidth() / 2) - 256, ((y - 36) + game.axeIm.getHeight() / 2) - 72, 1 | 2);
                        break;
                    }
                    g.setClip(0, 0, game.WIDTH, game.HEIGHT);
                    break;
                }
    }

    public void enemyDieSequence(Graphics g)
    {
        switch(face)
        {
        default:
            break;

        case 27: // '\033'
            switch(fr)
            {
            case 2: // '\002'
                y = 190;
                g.setClip((x - 28) + game.x1, y - 24, 56, 48);
                g.clipRect((x - 28) + game.x1, y - 24, 56, 48);
                g.drawImage(game.dieIm, (x + game.x1 + game.dieIm.getWidth() / 2) - 28, (y + game.dieIm.getHeight() / 2) - 24 - 48, 1 | 2);
                break;

            case 1: // '\001'
                g.setClip((x - 28) + game.x1, y - 24, 56, 48);
                g.clipRect((x - 28) + game.x1, y - 24, 56, 48);
                g.drawImage(game.dieIm, (x + game.x1 + game.dieIm.getWidth() / 2) - 28 - 56, (y + game.dieIm.getHeight() / 2) - 24 - 48, 1 | 2);
                fr++;
                break;

            case 0: // '\0'
                g.setClip((x - 28) + game.x1, y - 24, 56, 48);
                g.clipRect((x - 28) + game.x1, y - 24, 56, 48);
                g.drawImage(game.dieIm, (x + game.x1 + game.dieIm.getWidth() / 2) - 28 - 112, (y + game.dieIm.getHeight() / 2) - 24 - 48, 1 | 2);
                fr++;
                break;
            }
            g.setClip(0, 0, game.WIDTH, game.HEIGHT);
            break;

        case 26: // '\032'
            switch(fr)
            {
            case 0: // '\0'
                g.setClip((x - 28) + game.x1, y - 24, 56, 48);
                g.clipRect((x - 28) + game.x1, y - 24, 56, 48);
                g.drawRegion(game.dieIm, 112, 48, 56, 48, 2, (x - 28) + game.x1, y - 24, 0x10 | 4);
                fr++;
                break;

            case 1: // '\001'
                g.setClip((x - 28) + game.x1, y - 24, 56, 48);
                g.clipRect((x - 28) + game.x1, y - 24, 56, 48);
                g.drawRegion(game.dieIm, 56, 48, 56, 48, 2, (x - 28) + game.x1, y - 24, 0x10 | 4);
                fr++;
                break;

            case 2: // '\002'
                y = 190;
                g.setClip((x - 28) + game.x1, y - 24, 56, 48);
                g.clipRect((x - 28) + game.x1, y - 24, 56, 48);
                g.drawRegion(game.dieIm, 0, 48, 56, 48, 2, (x - 28) + game.x1, y - 24, 0x10 | 4);
                break;
            }
            g.setClip(0, 0, game.WIDTH, game.HEIGHT);
            break;
        }
    }

    public void enemyFall(Graphics g)
    {
        if(ehit && ebackAttack)
label0:
            switch(face)
            {
            default:
                break;

            case 27: // '\033'
                switch(fr)
                {
                case 0: // '\0'
                    g.setClip((x - 28) + game.x1, y - 24, 56, 48);
                    g.clipRect((x - 28) + game.x1, y - 24, 56, 48);
                    g.drawImage(game.dieIm, (x + game.x1 + game.dieIm.getWidth() / 2) - 28 - 112, (y + game.dieIm.getHeight() / 2) - 24 - 48, 1 | 2);
                    fr++;
                    break;

                case 1: // '\001'
                    y = 176;
                    g.setClip((x - 28) + game.x1, y - 24, 56, 48);
                    g.clipRect((x - 28) + game.x1, y - 24, 56, 48);
                    g.drawImage(game.dieIm, (x + game.x1 + game.dieIm.getWidth() / 2) - 28 - 56, (y + game.dieIm.getHeight() / 2) - 24 - 48, 1 | 2);
                    fr++;
                    break;

                case 2: // '\002'
                    char c = '\310';
                    g.setClip((x - 28) + game.x1, c - 24, 56, 48);
                    g.clipRect((x - 28) + game.x1, c - 24, 56, 48);
                    g.drawImage(game.dieIm, (x + game.x1 + game.dieIm.getWidth() / 2) - 28, (c + game.dieIm.getHeight() / 2) - 24 - 48, 1 | 2);
                    if(System.currentTimeMillis() % 5L == 0L)
                    {
                        fr = 0;
                        ebackAttack = false;
                        ehit = false;
                        face = 26;
                    }
                    break;
                }
                break;

            case 26: // '\032'
                switch(fr)
                {
                default:
                    break label0;

                case 0: // '\0'
                    g.setClip((x - 28) + game.x1, y - 24, 56, 48);
                    g.clipRect((x - 28) + game.x1, y - 24, 56, 48);
                    g.drawRegion(game.dieIm, 112, 48, 56, 48, 2, (x - 28) + game.x1, y - 24, 0x10 | 4);
                    fr++;
                    break label0;

                case 1: // '\001'
                    y = 176;
                    g.setClip((x - 28) + game.x1, y - 24, 56, 48);
                    g.clipRect((x - 28) + game.x1, y - 24, 56, 48);
                    g.drawRegion(game.dieIm, 56, 48, 56, 48, 2, (x - 28) + game.x1, y - 24, 0x10 | 4);
                    fr++;
                    break label0;

                case 2: // '\002'
                    char c1 = '\310';
                    g.setClip((x - 28) + game.x1, c1 - 24, 56, 48);
                    g.clipRect((x - 28) + game.x1, c1 - 24, 56, 48);
                    g.drawRegion(game.dieIm, 56, 48, 56, 48, 2, (x - 28) + game.x1, c1 - 24, 0x10 | 4);
                    break;
                }
                if(System.currentTimeMillis() % 5L == 0L)
                {
                    fr = 0;
                    ebackAttack = false;
                    ehit = false;
                    face = 27;
                }
                break;
            }
    }

    public void enemyHitted(Graphics g)
    {
        if(ehit)
            if(!isWeapon)
                switch(face)
                {
                case 26: // '\032'
                    g.setClip((x - 28) + game.x1, y - 24, 56, 48);
                    g.clipRect((x - 28) + game.x1, y - 24, 56, 48);
                    g.drawRegion(game.dieIm, 112, 48, 56, 48, 2, (x - 28) + game.x1, y - 24, 0x10 | 4);
                    break;

                case 27: // '\033'
                    g.setClip((x - 28) + game.x1, y - 24, 56, 48);
                    g.clipRect((x - 28) + game.x1, y - 24, 56, 48);
                    g.drawImage(game.dieIm, (x + game.x1 + game.dieIm.getWidth() / 2) - 28 - 112, (y + game.dieIm.getHeight() / 2) - 24 - 48, 1 | 2);
                    break;
                }
            else
            if(weapon == 41)
                switch(face)
                {
                case 27: // '\033'
                    g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                    g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                    g.drawRegion(game.chainIm, 204, 64, 68, 64, 2, (x - 34) + game.x1, y - 32, 0x10 | 4);
                    break;

                case 26: // '\032'
                    g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                    g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                    g.drawImage(game.chainIm, (((x + game.x1) - 34) + game.chainIm.getWidth() / 2) - 204, ((y - 32) + game.chainIm.getHeight() / 2) - 64, 1 | 2);
                    break;
                }
            else
            if(weapon == 39)
                switch(face)
                {
                case 26: // '\032'
                    g.setClip((x - 32) + game.x1, y - 36, 64, 72);
                    g.clipRect((x - 32) + game.x1, y - 36, 64, 72);
                    g.drawRegion(game.axeIm, 128, 72, 64, 72, 2, (x - 32) + game.x1, y - 36, 0x10 | 4);
                    break;

                case 27: // '\033'
                    g.setClip((x - 32) + game.x1, y - 36, 64, 72);
                    g.clipRect((x - 32) + game.x1, y - 36, 64, 72);
                    g.drawImage(game.axeIm, (((x + game.x1) - 32) + game.axeIm.getWidth() / 2) - 128, ((y - 36) + game.axeIm.getHeight() / 2) - 72, 1 | 2);
                    break;
                }
        g.setClip(0, 0, game.WIDTH, game.HEIGHT);
        if(enemyCtr % 5 == 0)
            ehit = false;
    }

    public void enemyChainWalk(Graphics g)
    {
        switch(face)
        {
        default:
            break;

        case 26: // '\032'
            switch(fr)
            {
            case 0: // '\0'
                if(System.currentTimeMillis() - e_lag >= 2000L && y < emaxY - 15 - 2)
                    y -= 10;
                g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                g.drawImage(game.chainIm, (((x + game.x1) - 34) + game.chainIm.getWidth() / 2) - 272, ((y - 32) + game.chainIm.getHeight() / 2) - 64, 1 | 2);
                break;

            case 1: // '\001'
                g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                g.drawImage(game.chainIm, (((x + game.x1) - 34) + game.chainIm.getWidth() / 2) - 340, ((y - 32) + game.chainIm.getHeight() / 2) - 64, 1 | 2);
                break;
            }
            break;

        case 27: // '\033'
            switch(fr)
            {
            default:
                break;

            case 0: // '\0'
                if(System.currentTimeMillis() - e_lag >= 2000L && y < emaxY - 15 - 2)
                    y -= 10;
                g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                g.drawRegion(game.chainIm, 272, 64, 68, 64, 2, (x - 34) + game.x1, y - 32, 0x10 | 4);
                break;

            case 1: // '\001'
                g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                g.drawRegion(game.chainIm, 340, 64, 68, 64, 2, (x - 34) + game.x1, y - 32, 0x10 | 4);
                break;
            }
            break;
        }
        g.setClip(0, 0, game.WIDTH, game.HEIGHT);
    }

    public void enemyChainJump(Graphics g)
    {
        switch(face)
        {
        default:
            break;

        case 27: // '\033'
            switch(echainJumpCtr)
            {
            case 0: // '\0'
            case 1: // '\001'
                x += 3;
                g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                g.drawRegion(game.chainIm, 204, 64, 68, 64, 2, (x - 34) + game.x1, y - 32, 0x10 | 4);
                break;

            case 2: // '\002'
            case 3: // '\003'
            case 4: // '\004'
                x += 4;
                g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                g.drawRegion(game.chainIm, 204, 64, 68, 64, 2, (x - 34) + game.x1, y - 32, 0x10 | 4);
                break;

            case 5: // '\005'
            case 6: // '\006'
                x += 3;
                g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                g.drawRegion(game.chainIm, 340, 64, 68, 64, 2, (x - 34) + game.x1, y - 32, 0x10 | 4);
                break;

            case 7: // '\007'
            case 8: // '\b'
            case 9: // '\t'
                x += 4;
                g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                g.drawRegion(game.chainIm, 340, 64, 68, 64, 2, (x - 34) + game.x1, y - 32, 0x10 | 4);
                break;
            }
            break;

        case 26: // '\032'
            switch(echainJumpCtr)
            {
            case 0: // '\0'
            case 1: // '\001'
                x -= 3;
                g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                g.drawImage(game.chainIm, (((x + game.x1) - 34) + game.chainIm.getWidth() / 2) - 204, ((y - 32) + game.chainIm.getHeight() / 2) - 64, 1 | 2);
                break;

            case 2: // '\002'
            case 3: // '\003'
            case 4: // '\004'
                x -= 4;
                g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                g.drawImage(game.chainIm, (((x + game.x1) - 34) + game.chainIm.getWidth() / 2) - 204, ((y - 32) + game.chainIm.getHeight() / 2) - 64, 1 | 2);
                break;

            case 5: // '\005'
            case 6: // '\006'
                x -= 3;
                g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                g.drawImage(game.chainIm, (((x + game.x1) - 34) + game.chainIm.getWidth() / 2) - 340, ((y - 32) + game.chainIm.getHeight() / 2) - 64, 1 | 2);
                break;

            case 7: // '\007'
            case 8: // '\b'
            case 9: // '\t'
                x -= 4;
                g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                g.drawImage(game.chainIm, (((x + game.x1) - 34) + game.chainIm.getWidth() / 2) - 340, ((y - 32) + game.chainIm.getHeight() / 2) - 64, 1 | 2);
                break;
            }
            break;
        }
        g.setClip(0, 0, game.WIDTH, game.HEIGHT);
    }

    public void drawChainFight(Graphics g)
    {
        if(weapon == 41)
            if(action == 15)
                switch(face)
                {
                case 26: // '\032'
                    switch(fr)
                    {
                    case 0: // '\0'
                        g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                        g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                        g.drawImage(game.chainIm, ((x + game.x1) - 34) + game.chainIm.getWidth() / 2, ((y - 32) + game.chainIm.getHeight() / 2) - 64, 1 | 2);
                        break;

                    case 1: // '\001'
                        g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                        g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                        g.drawImage(game.chainIm, (((x + game.x1) - 34) + game.chainIm.getWidth() / 2) - 136, ((y - 32) + game.chainIm.getHeight() / 2) - 64, 1 | 2);
                        break;

                    case 2: // '\002'
                        g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                        g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                        g.drawImage(game.chainIm, (((x + game.x1) - 34) + game.chainIm.getWidth() / 2) - 204, ((y - 32) + game.chainIm.getHeight() / 2) - 64, 1 | 2);
                        break;

                    case 3: // '\003'
                        g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                        g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                        g.drawImage(game.chainIm, (((x + game.x1) - 34) + game.chainIm.getWidth() / 2) - 272, ((y - 32) + game.chainIm.getHeight() / 2) - 64, 1 | 2);
                        break;

                    case 4: // '\004'
                        g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                        g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                        g.drawImage(game.chainIm, (((x + game.x1) - 34) + game.chainIm.getWidth() / 2) - 340, ((y - 32) + game.chainIm.getHeight() / 2) - 64, 1 | 2);
                        break;
                    }
                    g.setClip(0, 0, game.WIDTH, game.HEIGHT);
                    break;

                case 27: // '\033'
                    switch(fr)
                    {
                    case 0: // '\0'
                        g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                        g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                        g.drawRegion(game.chainIm, 0, 64, 68, 64, 2, (x - 34) + game.x1, y - 32, 0x10 | 4);
                        break;

                    case 1: // '\001'
                        g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                        g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                        g.drawRegion(game.chainIm, 136, 64, 68, 64, 2, (x - 34) + game.x1, y - 32, 0x10 | 4);
                        break;

                    case 2: // '\002'
                        g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                        g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                        g.drawRegion(game.chainIm, 204, 64, 68, 64, 2, (x - 34) + game.x1, y - 32, 0x10 | 4);
                        break;

                    case 3: // '\003'
                        g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                        g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                        g.drawRegion(game.chainIm, 272, 64, 68, 64, 2, (x - 34) + game.x1, y - 32, 0x10 | 4);
                        break;

                    case 4: // '\004'
                        g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                        g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                        g.drawRegion(game.chainIm, 340, 64, 68, 64, 2, (x - 34) + game.x1, y - 32, 0x10 | 4);
                        break;
                    }
                    g.setClip(0, 0, game.WIDTH, game.HEIGHT);
                    break;
                }
            else
            if(action == 17)
                switch(face)
                {
                default:
                    break;

                case 26: // '\032'
                    switch(fr)
                    {
                    case 0: // '\0'
                        g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                        g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                        g.drawImage(game.chainIm, ((x + game.x1) - 34) + game.chainIm.getWidth() / 2, ((y - 32) + game.chainIm.getHeight() / 2) - 64, 1 | 2);
                        break;

                    case 1: // '\001'
                        g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                        g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                        g.drawRegion(game.chainIm, 204, 64, 68, 64, 2, (x - 34) + game.x1, y - 32, 0x10 | 4);
                        break;
                    }
                    g.setClip(0, 0, game.WIDTH, game.HEIGHT);
                    break;

                case 27: // '\033'
                    switch(fr)
                    {
                    case 0: // '\0'
                        g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                        g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                        g.drawRegion(game.chainIm, 0, 64, 68, 64, 2, (x - 34) + game.x1, y - 32, 0x10 | 4);
                        break;

                    case 1: // '\001'
                        g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                        g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                        g.drawImage(game.chainIm, (((x + game.x1) - 34) + game.chainIm.getWidth() / 2) - 204, ((y - 32) + game.chainIm.getHeight() / 2) - 64, 1 | 2);
                        break;
                    }
                    g.setClip(0, 0, game.WIDTH, game.HEIGHT);
                    break;
                }
    }

    short x;
    short y;
    byte face;
    byte fr;
    short health;
    byte action;
    boolean isWeapon;
    boolean ehit;
    boolean ebackAttack;
    boolean emoving;
    Game game;
    byte weapon;
    short Dist;
    short emaxY;
    short enemyCtr;
    short ehitCtr;
    short ecrouchCtr;
    boolean eweaponPicked;
    boolean ecrouchHit;
    boolean playerHit;
    byte jpCtr;
    long e_lag;
    byte echainJumpCtr;
    byte eaxeJumpCtr;
    byte delayCtr;
}