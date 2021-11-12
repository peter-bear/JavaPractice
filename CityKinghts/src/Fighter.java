// Decompiled by DJ v3.9.9.91 Copyright 2005 Atanas Neshkov  Date: 2005-11-26 11:40:50
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 

import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

class Fighter
    implements Constants
{

    public Fighter(short word0, short word1, Game game1)
    {
        action = 13;
        face = 26;
        isWeapon = false;
        Armor = new byte[1];
        ArmorCount = 0;
        ArmsCount = 0;
        hit = false;
        backAttack = false;
        fighterCtr = 0;
        hitCtr = 0;
        weaponPicked = false;
        maxY = 176;
        sumerSaltPerformed = false;
        f_lag = System.currentTimeMillis();
        jt = 0;
        axeJumpCtr = 0;
        chainJumpCtr = 0;
        x = word0;
        y = word1;
        health = 120;
        action = 13;
        game = game1;
        for(byte byte0 = 0; byte0 < 1; byte0++)
            Armor[byte0] = 127;

    }

    public void axeJump(Graphics g)
    {
        switch(face)
        {
        case 26: // '\032'
            g.setClip((x - 32) + game.x1, y - 36, 64, 72);
            g.clipRect((x - 32) + game.x1, y - 36, 64, 72);
            g.drawRegion(game.axeIm, 0, 0, 64, 72, 2, (x - 32) + game.x1, y - 36, 0x10 | 4);
            break;

        case 27: // '\033'
            g.setClip((x - 32) + game.x1, y - 36, 64, 72);
            g.clipRect((x - 32) + game.x1, y - 36, 64, 72);
            g.drawImage(game.axeIm, (((x + game.x1) - 32) + game.axeIm.getWidth() / 2) - 0, (y - 36) + game.axeIm.getHeight() / 2, 1 | 2);
            break;
        }
        g.setClip(0, 0, game.WIDTH, game.HEIGHT);
    }

    public void axeWalk(Graphics g)
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
                g.drawRegion(game.axeIm, 0, 0, 64, 72, 2, (x - 32) + game.x1, y - 36, 0x10 | 4);
                break;

            case 0: // '\0'
                g.setClip((x - 32) + game.x1, y - 36, 64, 72);
                g.clipRect((x - 32) + game.x1, y - 36, 64, 72);
                g.drawRegion(game.axeIm, 256, 0, 64, 72, 2, (x - 32) + game.x1, y - 36, 0x10 | 4);
                break;
            }
            break;

        case 27: // '\033'
            switch(fr)
            {
            case 1: // '\001'
                g.setClip((x - 32) + game.x1, y - 36, 64, 72);
                g.clipRect((x - 32) + game.x1, y - 36, 64, 72);
                g.drawImage(game.axeIm, (((x + game.x1) - 32) + game.axeIm.getWidth() / 2) - 0, (y - 36) + game.axeIm.getHeight() / 2, 1 | 2);
                break;

            case 0: // '\0'
                g.setClip((x - 32) + game.x1, y - 36, 64, 72);
                g.clipRect((x - 32) + game.x1, y - 36, 64, 72);
                g.drawImage(game.axeIm, (((x + game.x1) - 32) + game.axeIm.getWidth() / 2) - 256, (y - 36) + game.axeIm.getHeight() / 2, 1 | 2);
                break;
            }
            break;
        }
        g.setClip(0, 0, game.WIDTH, game.HEIGHT);
    }

    public void axeAttack(Graphics g)
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
                        g.drawImage(game.axeIm, (((x + game.x1) - 32) + game.axeIm.getWidth() / 2) - 64, (y - 36) + game.axeIm.getHeight() / 2, 1 | 2);
                        break;

                    case 1: // '\001'
                        g.setClip((x - 32) + game.x1, y - 36, 64, 72);
                        g.clipRect((x - 32) + game.x1, y - 36, 64, 72);
                        g.drawImage(game.axeIm, (((x + game.x1) - 32) + game.axeIm.getWidth() / 2) - 128, (y - 36) + game.axeIm.getHeight() / 2, 1 | 2);
                        break;

                    case 2: // '\002'
                        g.setClip((x - 32) + game.x1, y - 36, 64, 72);
                        g.clipRect((x - 32) + game.x1, y - 36, 64, 72);
                        g.drawImage(game.axeIm, (((x + game.x1) - 32) + game.axeIm.getWidth() / 2) - 192, (y - 36) + game.axeIm.getHeight() / 2, 1 | 2);
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
                        g.drawRegion(game.axeIm, 64, 0, 64, 72, 2, (x - 32) + game.x1, y - 36, 0x10 | 4);
                        break;

                    case 1: // '\001'
                        g.setClip((x - 32) + game.x1, y - 36, 64, 72);
                        g.clipRect((x - 32) + game.x1, y - 36, 64, 72);
                        g.drawRegion(game.axeIm, 128, 0, 64, 72, 2, (x - 32) + game.x1, y - 36, 0x10 | 4);
                        break;

                    case 2: // '\002'
                        g.setClip((x - 32) + game.x1, y - 36, 64, 72);
                        g.clipRect((x - 32) + game.x1, y - 36, 64, 72);
                        g.drawRegion(game.axeIm, 192, 0, 64, 72, 2, (x - 32) + game.x1, y - 36, 0x10 | 4);
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
                        g.drawRegion(game.axeIm, 0, 0, 64, 72, 2, (x - 32) + game.x1, y - 36, 0x10 | 4);
                        break;

                    case 1: // '\001'
                        g.setClip((x - 32) + game.x1, y - 36, 64, 72);
                        g.clipRect((x - 32) + game.x1, y - 36, 64, 72);
                        g.drawRegion(game.axeIm, 192, 0, 64, 72, 2, (x - 32) + game.x1, y - 36, 0x10 | 4);
                        break;

                    case 2: // '\002'
                        g.setClip((x - 32) + game.x1, y - 36, 64, 72);
                        g.clipRect((x - 32) + game.x1, y - 36, 64, 72);
                        g.drawRegion(game.axeIm, 256, 0, 64, 72, 2, (x - 32) + game.x1, y - 36, 0x10 | 4);
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
                        g.drawImage(game.axeIm, (((x + game.x1) - 32) + game.axeIm.getWidth() / 2) - 0, (y - 36) + game.axeIm.getHeight() / 2, 1 | 2);
                        break;

                    case 1: // '\001'
                        g.setClip((x - 32) + game.x1, y - 36, 64, 72);
                        g.clipRect((x - 32) + game.x1, y - 36, 64, 72);
                        g.drawImage(game.axeIm, (((x + game.x1) - 32) + game.axeIm.getWidth() / 2) - 192, (y - 36) + game.axeIm.getHeight() / 2, 1 | 2);
                        break;

                    case 2: // '\002'
                        g.setClip((x - 32) + game.x1, y - 36, 64, 72);
                        g.clipRect((x - 32) + game.x1, y - 36, 64, 72);
                        g.drawImage(game.axeIm, (((x + game.x1) - 32) + game.axeIm.getWidth() / 2) - 256, (y - 36) + game.axeIm.getHeight() / 2, 1 | 2);
                        break;
                    }
                    g.setClip(0, 0, game.WIDTH, game.HEIGHT);
                    break;
                }
    }

    public void chainWalk(Graphics g)
    {
        switch(face)
        {
        default:
            break;

        case 26: // '\032'
            switch(fr)
            {
            case 0: // '\0'
                if(System.currentTimeMillis() - f_lag >= 2000L && y < maxY - 15 - 2)
                    y -= 15;
                g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                g.drawImage(game.chainIm, (((x + game.x1) - 34) + game.chainIm.getWidth() / 2) - 272, (y - 32) + game.chainIm.getHeight() / 2, 1 | 2);
                break;

            case 1: // '\001'
                g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                g.drawImage(game.chainIm, (((x + game.x1) - 34) + game.chainIm.getWidth() / 2) - 340, (y - 32) + game.chainIm.getHeight() / 2, 1 | 2);
                break;
            }
            break;

        case 27: // '\033'
            switch(fr)
            {
            default:
                break;

            case 0: // '\0'
                if(System.currentTimeMillis() - f_lag >= 2000L && y < maxY - 15 - 2)
                    y -= 15;
                g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                g.drawRegion(game.chainIm, 272, 0, 68, 64, 2, (x - 34) + game.x1, y - 32, 0x10 | 4);
                break;

            case 1: // '\001'
                g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                g.drawRegion(game.chainIm, 340, 0, 68, 64, 2, (x - 34) + game.x1, y - 32, 0x10 | 4);
                break;
            }
            break;
        }
        g.setClip(0, 0, game.WIDTH, game.HEIGHT);
    }

    public void chainJump(Graphics g)
    {
        switch(face)
        {
        default:
            break;

        case 27: // '\033'
            switch(chainJumpCtr)
            {
            case 0: // '\0'
            case 1: // '\001'
                x += 3;
                g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                g.drawRegion(game.chainIm, 136, 0, 68, 64, 2, (x - 34) + game.x1, y - 32, 0x10 | 4);
                break;

            case 2: // '\002'
            case 3: // '\003'
            case 4: // '\004'
                x += 4;
                g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                g.drawRegion(game.chainIm, 136, 0, 68, 64, 2, (x - 34) + game.x1, y - 32, 0x10 | 4);
                break;

            case 5: // '\005'
            case 6: // '\006'
                x += 3;
                g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                g.drawRegion(game.chainIm, 272, 0, 68, 64, 2, (x - 34) + game.x1, y - 32, 0x10 | 4);
                break;

            case 7: // '\007'
            case 8: // '\b'
            case 9: // '\t'
                x += 4;
                g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                g.drawRegion(game.chainIm, 272, 0, 68, 64, 2, (x - 34) + game.x1, y - 32, 0x10 | 4);
                break;
            }
            break;

        case 26: // '\032'
            switch(chainJumpCtr)
            {
            case 0: // '\0'
            case 1: // '\001'
                x -= 3;
                g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                g.drawImage(game.chainIm, (((x + game.x1) - 34) + game.chainIm.getWidth() / 2) - 204, (y - 32) + game.chainIm.getHeight() / 2, 1 | 2);
                break;

            case 2: // '\002'
            case 3: // '\003'
            case 4: // '\004'
                x -= 4;
                g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                g.drawImage(game.chainIm, (((x + game.x1) - 34) + game.chainIm.getWidth() / 2) - 204, (y - 32) + game.chainIm.getHeight() / 2, 1 | 2);
                break;

            case 5: // '\005'
            case 6: // '\006'
                x -= 3;
                g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                g.drawImage(game.chainIm, (((x + game.x1) - 34) + game.chainIm.getWidth() / 2) - 340, (y - 32) + game.chainIm.getHeight() / 2, 1 | 2);
                break;

            case 7: // '\007'
            case 8: // '\b'
            case 9: // '\t'
                x -= 4;
                g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                g.drawImage(game.chainIm, (((x + game.x1) - 34) + game.chainIm.getWidth() / 2) - 340, (y - 32) + game.chainIm.getHeight() / 2, 1 | 2);
                break;
            }
            break;
        }
        g.setClip(0, 0, game.WIDTH, game.HEIGHT);
    }

    public void chainAttack(Graphics g)
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
                        g.drawImage(game.chainIm, ((x + game.x1) - 34) + game.chainIm.getWidth() / 2, (y - 32) + game.chainIm.getHeight() / 2, 1 | 2);
                        break;

                    case 1: // '\001'
                        g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                        g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                        g.drawImage(game.chainIm, (((x + game.x1) - 34) + game.chainIm.getWidth() / 2) - 136, (y - 32) + game.chainIm.getHeight() / 2, 1 | 2);
                        break;

                    case 2: // '\002'
                        g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                        g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                        g.drawImage(game.chainIm, (((x + game.x1) - 34) + game.chainIm.getWidth() / 2) - 204, (y - 32) + game.chainIm.getHeight() / 2, 1 | 2);
                        break;

                    case 3: // '\003'
                        g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                        g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                        g.drawImage(game.chainIm, (((x + game.x1) - 34) + game.chainIm.getWidth() / 2) - 272, (y - 32) + game.chainIm.getHeight() / 2, 1 | 2);
                        break;

                    case 4: // '\004'
                        g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                        g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                        g.drawImage(game.chainIm, (((x + game.x1) - 34) + game.chainIm.getWidth() / 2) - 340, (y - 32) + game.chainIm.getHeight() / 2, 1 | 2);
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
                        g.drawRegion(game.chainIm, 0, 0, 68, 64, 2, (x - 34) + game.x1, y - 32, 0x10 | 4);
                        break;

                    case 1: // '\001'
                        g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                        g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                        g.drawRegion(game.chainIm, 68, 0, 68, 64, 2, (x - 34) + game.x1, y - 32, 0x10 | 4);
                        break;

                    case 2: // '\002'
                        g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                        g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                        g.drawRegion(game.chainIm, 136, 0, 68, 64, 2, (x - 34) + game.x1, y - 32, 0x10 | 4);
                        break;

                    case 3: // '\003'
                        g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                        g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                        g.drawRegion(game.chainIm, 204, 0, 68, 64, 2, (x - 34) + game.x1, y - 32, 0x10 | 4);
                        break;

                    case 4: // '\004'
                        g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                        g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                        g.drawRegion(game.chainIm, 272, 0, 68, 64, 2, (x - 34) + game.x1, y - 32, 0x10 | 4);
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
                        g.drawImage(game.chainIm, ((x + game.x1) - 34) + game.chainIm.getWidth() / 2, (y - 32) + game.chainIm.getHeight() / 2, 1 | 2);
                        break;

                    case 1: // '\001'
                        g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                        g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                        g.drawRegion(game.chainIm, 204, 0, 68, 64, 2, (x - 34) + game.x1, y - 32, 0x10 | 4);
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
                        g.drawRegion(game.chainIm, 0, 0, 68, 64, 2, (x - 34) + game.x1, y - 32, 0x10 | 4);
                        break;

                    case 1: // '\001'
                        g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                        g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                        g.drawImage(game.chainIm, (((x + game.x1) - 34) + game.chainIm.getWidth() / 2) - 204, (y - 32) + game.chainIm.getHeight() / 2, 1 | 2);
                        break;
                    }
                    g.setClip(0, 0, game.WIDTH, game.HEIGHT);
                    break;
                }
    }

    public void drawStand(Graphics g)
    {
        if(!isWeapon)
        {
            switch(face)
            {
            case 26: // '\032'
                g.setClip((x - 30) + game.x1, y - 30, 60, 60);
                g.clipRect((x - 30) + game.x1, y - 30, 60, 60);
                g.drawImage(game.playerIm, (x + game.x1 + game.playerIm.getWidth() / 2) - 30 - 120, (y + game.playerIm.getHeight() / 2) - 30, 1 | 2);
                break;

            case 27: // '\033'
                g.setClip((x - 30) + game.x1, y - 30, 60, 60);
                g.clipRect((x - 30) + game.x1, y - 30, 60, 60);
                g.drawRegion(game.playerIm, 120, 0, 60, 60, 2, (x - 30) + game.x1, y - 30, 0x10 | 4);
                break;
            }
            g.setClip(0, 0, game.WIDTH, game.HEIGHT);
        } else
        {
            switch(Armor[ArmorCount])
            {
            default:
                break;

            case 39: // '\''
                switch(face)
                {
                case 26: // '\032'
                    g.setClip((x - 32) + game.x1, y - 36, 64, 72);
                    g.clipRect((x - 32) + game.x1, y - 36, 64, 72);
                    g.drawRegion(game.axeIm, 256, 0, 64, 72, 2, (x - 32) + game.x1, y - 36, 0x10 | 4);
                    break;

                case 27: // '\033'
                    g.setClip((x - 32) + game.x1, y - 36, 64, 72);
                    g.clipRect((x - 32) + game.x1, y - 36, 64, 72);
                    g.drawImage(game.axeIm, (((x + game.x1) - 32) + game.axeIm.getWidth() / 2) - 256, (y - 36) + game.axeIm.getHeight() / 2, 1 | 2);
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
                    g.drawRegion(game.chainIm, 272, 0, 68, 64, 2, (x - 34) + game.x1, y - 32, 0x10 | 4);
                    break;

                case 26: // '\032'
                    g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                    g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                    g.drawImage(game.chainIm, (((x + game.x1) - 34) + game.chainIm.getWidth() / 2) - 272, (y - 32) + game.chainIm.getHeight() / 2, 1 | 2);
                    break;
                }
                g.setClip(0, 0, game.WIDTH, game.HEIGHT);
                break;
            }
        }
    }

    public void drawJump(Graphics g)
    {
        switch(face)
        {
        case 26: // '\032'
            g.setClip((x - 30) + game.x1, y - 30, 60, 60);
            g.clipRect((x - 30) + game.x1, y - 30, 60, 60);
            g.drawImage(game.playerIm, (x + game.x1 + game.playerIm.getWidth() / 2) - 30 - 180, (y + game.playerIm.getHeight() / 2) - 30, 1 | 2);
            break;

        case 27: // '\033'
            g.setClip((x - 30) + game.x1, y - 30, 60, 60);
            g.clipRect((x - 30) + game.x1, y - 30, 60, 60);
            g.drawRegion(game.playerIm, 120, 0, 60, 60, 2, (x - 30) + game.x1, y - 30, 0x10 | 4);
            break;
        }
        g.setClip(0, 0, game.WIDTH, game.HEIGHT);
    }

    public void kickAttack(Graphics g)
    {
        switch(face)
        {
        default:
            break;

        case 26: // '\032'
            switch(fr)
            {
            case 0: // '\0'
                g.setClip((x - 30) + game.x1, y - 30, 60, 60);
                g.clipRect((x - 30) + game.x1, y - 30, 60, 60);
                g.drawImage(game.playerIm, (x + game.x1 + game.playerIm.getWidth() / 2) - 30 - 240, (y + game.playerIm.getHeight() / 2) - 30, 1 | 2);
                break;

            case 1: // '\001'
                g.setClip((x - 30) + game.x1, y - 30, 60, 60);
                g.clipRect((x - 30) + game.x1, y - 30, 60, 60);
                g.drawImage(game.playerIm, (x + game.x1 + game.playerIm.getWidth() / 2) - 30 - 300, (y + game.playerIm.getHeight() / 2) - 30, 1 | 2);
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
                g.drawRegion(game.playerIm, 240, 0, 60, 60, 2, (x - 30) + game.x1, y - 30, 0x10 | 4);
                break;

            case 1: // '\001'
                g.setClip((x - 30) + game.x1, y - 30, 60, 60);
                g.clipRect((x - 30) + game.x1, y - 30, 60, 60);
                g.drawRegion(game.playerIm, 300, 0, 60, 60, 2, (x - 30) + game.x1, y - 30, 0x10 | 4);
                break;
            }
            g.setClip(0, 0, game.WIDTH, game.HEIGHT);
            break;
        }
        g.setClip(0, 0, game.WIDTH, game.HEIGHT);
    }

    public void crouchAttack(Graphics g)
    {
        switch(face)
        {
        case 26: // '\032'
            g.setClip((x - 30) + game.x1, y - 30, 60, 60);
            g.clipRect((x - 30) + game.x1, y - 30, 60, 60);
            g.drawImage(game.playerIm, (x + game.x1 + game.playerIm.getWidth() / 2) - 30 - 360, (y + game.playerIm.getHeight() / 2) - 30, 1 | 2);
            break;

        case 27: // '\033'
            g.setClip((x - 30) + game.x1, y - 30, 60, 60);
            g.clipRect((x - 30) + game.x1, y - 30, 60, 60);
            g.drawRegion(game.playerIm, 360, 0, 60, 60, 2, (x - 30) + game.x1, y - 30, 0x10 | 4);
            break;
        }
        weapon = 35;
        g.setClip(0, 0, game.WIDTH, game.HEIGHT);
    }

    public void Attack(Graphics g)
    {
        switch(face)
        {
        case 26: // '\032'
            g.setClip((x - 30) + game.x1, y - 30, 60, 60);
            g.clipRect((x - 30) + game.x1, y - 30, 60, 60);
            g.drawImage(game.playerIm, (x + game.x1 + game.playerIm.getWidth() / 2) - 30 - 180, (y + game.playerIm.getHeight() / 2) - 30, 1 | 2);
            break;

        case 27: // '\033'
            g.setClip((x - 30) + game.x1, y - 30, 60, 60);
            g.clipRect((x - 30) + game.x1, y - 30, 60, 60);
            g.drawRegion(game.playerIm, 180, 0, 60, 60, 2, (x - 30) + game.x1, y - 30, 0x10 | 4);
            break;
        }
        g.setClip(0, 0, game.WIDTH, game.HEIGHT);
    }

    public void drawWalk(Graphics g)
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
                g.drawImage(game.playerIm, (x + game.x1 + game.playerIm.getWidth() / 2) - 30, (y + game.playerIm.getHeight() / 2) - 30, 1 | 2);
                break;

            case 27: // '\033'
                g.setClip((x - 30) + game.x1, y - 30, 60, 60);
                g.clipRect((x - 30) + game.x1, y - 30, 60, 60);
                g.drawRegion(game.playerIm, 0, 0, 60, 60, 2, (x - 30) + game.x1, y - 30, 0x10 | 4);
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
                g.drawImage(game.playerIm, (x + game.x1 + game.playerIm.getWidth() / 2) - 30 - 60, (y + game.playerIm.getHeight() / 2) - 30, 1 | 2);
                break;

            case 27: // '\033'
                g.setClip((x - 30) + game.x1, y - 30, 60, 60);
                g.clipRect((x - 30) + game.x1, y - 30, 60, 60);
                g.drawRegion(game.playerIm, 60, 0, 60, 60, 2, (x - 30) + game.x1, y - 30, 0x10 | 4);
                break;
            }
            g.setClip(0, 0, game.WIDTH, game.HEIGHT);
            break;
        }
    }

    public void attackedAnimation(Graphics g)
    {
        int i = y - 10;
        if(hit)
        {
            g.setClip((x - 11) + game.x1, i - 9, 22, 19);
            g.clipRect((x - 11) + game.x1, i - 9, 22, 19);
            g.drawImage(game.fighterHit, ((x + game.x1) - 11) + game.fighterHit.getWidth() / 2, (i - 9) + game.fighterHit.getHeight() / 2, 1 | 2);
        }
        g.setClip(0, 0, game.WIDTH, game.HEIGHT);
    }

    public void dieSequence(Graphics g)
    {
        switch(face)
        {
        default:
            break;

        case 26: // '\032'
            switch(fr)
            {
            case 0: // '\0'
                g.setClip((x - 28) + game.x1, y - 24, 56, 48);
                g.clipRect((x - 28) + game.x1, y - 24, 56, 48);
                g.drawRegion(game.dieIm, 112, 0, 56, 48, 2, (x - 28) + game.x1, y - 24, 0x10 | 4);
                fr++;
                y++;
                break;

            case 1: // '\001'
                g.setClip((x - 28) + game.x1, y - 24, 56, 48);
                g.clipRect((x - 28) + game.x1, y - 24, 56, 48);
                g.drawRegion(game.dieIm, 56, 0, 56, 48, 2, (x - 28) + game.x1, y - 24, 0x10 | 4);
                fr++;
                y += 3;
                break;

            case 2: // '\002'
                y = 190;
                g.setClip((x - 28) + game.x1, y - 24, 56, 48);
                g.clipRect((x - 28) + game.x1, y - 24, 56, 48);
                g.drawRegion(game.dieIm, 0, 0, 56, 48, 2, (x - 28) + game.x1, y - 24, 0x10 | 4);
                break;
            }
            g.setClip(0, 0, game.WIDTH, game.HEIGHT);
            break;

        case 27: // '\033'
            switch(fr)
            {
            case 0: // '\0'
                g.setClip((x - 28) + game.x1, y - 24, 56, 48);
                g.clipRect((x - 28) + game.x1, y - 24, 56, 48);
                g.drawImage(game.dieIm, (x + game.x1 + game.dieIm.getWidth() / 2) - 28 - 112, (y + game.dieIm.getHeight() / 2) - 24, 1 | 2);
                fr++;
                y++;
                break;

            case 1: // '\001'
                g.setClip((x - 28) + game.x1, y - 24, 56, 48);
                g.clipRect((x - 28) + game.x1, y - 24, 56, 48);
                g.drawImage(game.dieIm, (x + game.x1 + game.dieIm.getWidth() / 2) - 28 - 56, (y + game.dieIm.getHeight() / 2) - 24, 1 | 2);
                fr++;
                y++;
                break;

            case 2: // '\002'
                y = 190;
                g.setClip((x - 28) + game.x1, y - 24, 56, 48);
                g.clipRect((x - 28) + game.x1, y - 24, 56, 48);
                g.drawImage(game.dieIm, (x + game.x1 + game.dieIm.getWidth() / 2) - 28, (y + game.dieIm.getHeight() / 2) - 24, 1 | 2);
                break;
            }
            g.setClip(0, 0, game.WIDTH, game.HEIGHT);
            break;
        }
    }

    public void drawHitted(Graphics g)
    {
        if(hit)
            if(!isWeapon)
                switch(face)
                {
                case 26: // '\032'
                    g.setClip((x - 28) + game.x1, y - 24, 56, 48);
                    g.clipRect((x - 28) + game.x1, y - 24, 56, 48);
                    g.drawRegion(game.dieIm, 112, 0, 56, 48, 2, (x - 28) + game.x1, y - 24, 0x10 | 4);
                    break;

                case 27: // '\033'
                    g.setClip((x - 28) + game.x1, y - 24, 56, 48);
                    g.clipRect((x - 28) + game.x1, y - 24, 56, 48);
                    g.drawImage(game.dieIm, (x + game.x1 + game.dieIm.getWidth() / 2) - 28 - 112, (y + game.dieIm.getHeight() / 2) - 24, 1 | 2);
                    break;
                }
            else
            if(weapon == 41)
                switch(face)
                {
                case 27: // '\033'
                    g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                    g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                    g.drawRegion(game.chainIm, 204, 0, 68, 64, 2, (x - 34) + game.x1, y - 32, 0x10 | 4);
                    break;

                case 26: // '\032'
                    g.setClip((x - 34) + game.x1, y - 32, 68, 64);
                    g.clipRect((x - 34) + game.x1, y - 32, 68, 64);
                    g.drawImage(game.chainIm, (((x + game.x1) - 34) + game.chainIm.getWidth() / 2) - 204, (y - 32) + game.chainIm.getHeight() / 2, 1 | 2);
                    break;
                }
            else
            if(weapon == 39)
                switch(face)
                {
                case 26: // '\032'
                    g.setClip((x - 32) + game.x1, y - 36, 64, 72);
                    g.clipRect((x - 32) + game.x1, y - 36, 64, 72);
                    g.drawRegion(game.axeIm, 128, 0, 64, 72, 2, (x - 32) + game.x1, y - 36, 0x10 | 4);
                    break;

                case 27: // '\033'
                    g.setClip((x - 32) + game.x1, y - 36, 64, 72);
                    g.clipRect((x - 32) + game.x1, y - 36, 64, 72);
                    g.drawImage(game.axeIm, (((x + game.x1) - 32) + game.axeIm.getWidth() / 2) - 128, (y - 36) + game.axeIm.getHeight() / 2, 1 | 2);
                    break;
                }
        g.setClip(0, 0, game.WIDTH, game.HEIGHT);
        if(System.currentTimeMillis() % 3L == 0L)
            hit = false;
    }

    public void drawFall(Graphics g)
    {
        if(hit && backAttack)
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
                    g.drawImage(game.dieIm, (x + game.x1 + game.dieIm.getWidth() / 2) - 28 - 112, (y + game.dieIm.getHeight() / 2) - 24, 1 | 2);
                    fr++;
                    break;

                case 1: // '\001'
                    y = 176;
                    g.setClip((x - 28) + game.x1, y - 24, 56, 48);
                    g.clipRect((x - 28) + game.x1, y - 24, 56, 48);
                    g.drawImage(game.dieIm, (x + game.x1 + game.dieIm.getWidth() / 2) - 28 - 56, (y + game.dieIm.getHeight() / 2) - 24, 1 | 2);
                    fr++;
                    break;

                case 2: // '\002'
                    char c = '\310';
                    g.setClip((x - 28) + game.x1, c - 24, 56, 48);
                    g.clipRect((x - 28) + game.x1, c - 24, 56, 48);
                    g.drawImage(game.dieIm, (x + game.x1 + game.dieIm.getWidth() / 2) - 28, (c + game.dieIm.getHeight() / 2) - 24, 1 | 2);
                    if(System.currentTimeMillis() % 5L == 0L)
                    {
                        fr = 0;
                        backAttack = false;
                        hit = false;
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
                    g.drawRegion(game.dieIm, 112, 0, 56, 48, 2, (x - 28) + game.x1, y - 24, 0x10 | 4);
                    fr++;
                    break label0;

                case 1: // '\001'
                    y = 176;
                    g.setClip((x - 28) + game.x1, y - 24, 56, 48);
                    g.clipRect((x - 28) + game.x1, y - 24, 56, 48);
                    g.drawRegion(game.dieIm, 56, 0, 56, 48, 2, (x - 28) + game.x1, y - 24, 0x10 | 4);
                    fr++;
                    break label0;

                case 2: // '\002'
                    char c1 = '\310';
                    g.setClip((x - 28) + game.x1, c1 - 24, 56, 48);
                    g.clipRect((x - 28) + game.x1, c1 - 24, 56, 48);
                    g.drawRegion(game.dieIm, 0, 0, 56, 48, 2, (x - 28) + game.x1, c1 - 24, 0x10 | 4);
                    break;
                }
                if(System.currentTimeMillis() % 5L == 0L)
                {
                    fr = 0;
                    backAttack = false;
                    hit = false;
                    face = 27;
                }
                break;
            }
        g.setClip(0, 0, game.WIDTH, game.HEIGHT);
    }

    public int enemyFighting()
    {
        for(Enumeration enumeration = game.enemyMan.elements(); enumeration.hasMoreElements();)
        {
            Enemy enemy = (Enemy)enumeration.nextElement();
            if(enemy.Dist <= 35 || enemy.Dist <= 20 || enemy.isWeapon && enemy.Dist <= 20)
                return game.enemyMan.indexOf(enemy);
        }

        return -1;
    }

    public void reduceHealth()
    {
        int i = enemyFighting();
        if(i != -1)
        {
            Enemy enemy = (Enemy)game.enemyMan.elementAt(i);
            if(enemy.health > 0 && enemy.Dist <= 20)
                if(enemy.weapon == 35 && enemy.action == 15 && action != 17 && y == enemy.y)
                {
                    health -= 2;
                    hit = true;
                    game.gameEffects("punch");
                    if(face == enemy.face)
                        backAttack = true;
                } else
                if(enemy.weapon == 34 && enemy.action == 15 && y >= enemy.y - 5)
                {
                    health -= 3;
                    hit = true;
                    game.gameEffects("hit");
                    if(face == enemy.face)
                        backAttack = true;
                } else
                if(enemy.weapon == 33 && enemy.action == 15 && y >= enemy.y - 5)
                {
                    hit = true;
                    game.gameEffects("hit");
                    if(face == enemy.face)
                        backAttack = true;
                }
            if(enemy.health > 0 && enemy.Dist <= 35 && enemy.isWeapon)
                if(enemy.weapon == 41 && enemy.action == 15 && enemy.fr == 1 && y >= enemy.y - 5 && action != 17)
                {
                    health -= 3;
                    hit = true;
                    game.gameEffects("hit");
                    if(face == enemy.face)
                        backAttack = true;
                } else
                if(enemy.weapon == 39 && enemy.action == 15 && enemy.fr == 1 && y >= enemy.y - 5 && action != 17)
                {
                    health -= 5;
                    hit = true;
                    game.gameEffects("hit");
                    if(face == enemy.face)
                        backAttack = true;
                }
        }
    }

    public void drawSumersalt(Graphics g)
    {
        switch(face)
        {
        default:
            break;

        case 26: // '\032'
            switch(fr)
            {
            case 2: // '\002'
                g.setClip((x - 31) + game.x1, y - 31, 62, 62);
                g.clipRect((x - 31) + game.x1, y - 31, 62, 62);
                g.drawRegion(game.playerIm, 120, 0, 60, 60, 5, (x - 31) + game.x1, y - 31, 0x10 | 4);
                face = 27;
                action = 13;
                break;

            case 1: // '\001'
                g.setClip((x - 31) + game.x1, y - 31, 62, 62);
                g.clipRect((x - 31) + game.x1, y - 31, 62, 62);
                g.drawRegion(game.playerIm, 120, 0, 60, 60, 3, (x - 31) + game.x1, y - 31, 0x10 | 4);
                x -= 15;
                break;

            case 0: // '\0'
                g.setClip((x - 31) + game.x1, y - 31, 62, 62);
                g.clipRect((x - 31) + game.x1, y - 31, 62, 62);
                g.drawRegion(game.playerIm, 120, 0, 60, 60, 6, (x - 31) + game.x1, y - 31, 0x10 | 4);
                x -= 15;
                break;
            }
            break;

        case 27: // '\033'
            switch(fr)
            {
            case 0: // '\0'
                g.setClip((x - 31) + game.x1, y - 31, 62, 62);
                g.clipRect((x - 31) + game.x1, y - 31, 62, 62);
                g.drawRegion(game.playerIm, 120, 0, 60, 60, 5, (x - 31) + game.x1, y - 31, 0x10 | 4);
                x += 15;
                break;

            case 1: // '\001'
                g.setClip((x - 31) + game.x1, y - 31, 62, 62);
                g.clipRect((x - 31) + game.x1, y - 31, 62, 62);
                g.drawRegion(game.playerIm, 120, 0, 60, 60, 3, (x - 31) + game.x1, y - 31, 0x10 | 4);
                x += 15;
                break;

            case 2: // '\002'
                g.setClip((x - 31) + game.x1, y - 31, 62, 62);
                g.clipRect((x - 31) + game.x1, y - 31, 62, 62);
                g.drawRegion(game.playerIm, 120, 0, 60, 60, 6, (x - 31) + game.x1, y - 31, 0x10 | 4);
                face = 26;
                action = 13;
                break;
            }
            break;
        }
        g.setClip(0, 0, game.WIDTH, game.HEIGHT);
    }

    public void update()
    {
        if(y < maxY)
        {
            if(!isWeapon && (action == 13 || action == 16 || action == 15 || action == 14))
                switch(jt)
                {
                case 0: // '\0'
                    y -= 25;
                    jt++;
                    break;

                case 1: // '\001'
                    y -= 20;
                    jt++;
                    break;

                case 2: // '\002'
                    jt++;
                    break;

                case 3: // '\003'
                    y -= 7;
                    jt++;
                    break;

                case 4: // '\004'
                    jt++;
                    break;

                case 5: // '\005'
                    y -= 5;
                    jt++;
                    break;

                case 6: // '\006'
                    jt++;
                    break;

                case 7: // '\007'
                    y -= 2;
                    jt++;
                    break;

                case 8: // '\b'
                    jt++;
                    break;

                case 9: // '\t'
                    y += 2;
                    jt++;
                    break;

                case 10: // '\n'
                    jt++;
                    break;

                case 11: // '\013'
                    y += 5;
                    jt++;
                    break;

                case 12: // '\f'
                    jt++;
                    break;

                case 13: // '\r'
                    y += 7;
                    jt++;
                    break;

                case 14: // '\016'
                    y += 20;
                    jt++;
                    break;

                case 15: // '\017'
                    y += 25;
                    jt = 0;
                    action = 13;
                    break;
                }
            if(weapon == 39 && isWeapon && (action == 16 || action == 13 || action == 15))
                switch(axeJumpCtr)
                {
                case 0: // '\0'
                    y -= 25;
                    axeJumpCtr++;
                    break;

                case 1: // '\001'
                    y -= 20;
                    axeJumpCtr++;
                    break;

                case 2: // '\002'
                    y -= 7;
                    axeJumpCtr++;
                    break;

                case 3: // '\003'
                    y -= 5;
                    axeJumpCtr++;
                    break;

                case 4: // '\004'
                    y -= 2;
                    axeJumpCtr++;
                    break;

                case 5: // '\005'
                    y += 2;
                    axeJumpCtr++;
                    break;

                case 6: // '\006'
                    y += 5;
                    axeJumpCtr++;
                    break;

                case 7: // '\007'
                    y += 7;
                    axeJumpCtr++;
                    break;

                case 8: // '\b'
                    y += 20;
                    axeJumpCtr++;
                    break;

                case 9: // '\t'
                    y += 25;
                    axeJumpCtr = 0;
                    action = 13;
                    break;
                }
            if(weapon == 41 && isWeapon && (action == 16 || action == 13 || action == 15))
                switch(chainJumpCtr)
                {
                case 0: // '\0'
                    y -= 25;
                    chainJumpCtr++;
                    break;

                case 1: // '\001'
                    y -= 20;
                    chainJumpCtr++;
                    break;

                case 2: // '\002'
                    y -= 7;
                    chainJumpCtr++;
                    break;

                case 3: // '\003'
                    y -= 5;
                    chainJumpCtr++;
                    break;

                case 4: // '\004'
                    y -= 2;
                    chainJumpCtr++;
                    break;

                case 5: // '\005'
                    y += 2;
                    chainJumpCtr++;
                    break;

                case 6: // '\006'
                    y += 5;
                    chainJumpCtr++;
                    break;

                case 7: // '\007'
                    y += 7;
                    chainJumpCtr++;
                    break;

                case 8: // '\b'
                    y += 20;
                    chainJumpCtr++;
                    break;

                case 9: // '\t'
                    y += 25;
                    chainJumpCtr = 0;
                    action = 13;
                    break;
                }
        }
        fighterCtr++;
        if(fighterCtr == 50)
            fighterCtr = 0;
        if(y >= maxY)
        {
            sumerSaltPerformed = false;
            jt = 0;
        }
        if(action == 19)
            fr++;
        if(action == 13 && jt == 0)
        {
            y = maxY;
            if(!backAttack)
                fr = 0;
        } else
        if(action == 16)
        {
            if(jt == 0 && y >= maxY && !isWeapon)
            {
                y -= 25;
                jt = 1;
                action = 13;
            }
            if(axeJumpCtr == 0 && y >= maxY && weapon == 39)
            {
                y -= 25;
                axeJumpCtr = 1;
            }
            if(chainJumpCtr == 0 && y >= maxY && weapon == 41)
            {
                y -= 25;
                chainJumpCtr = 1;
            }
        } else
        if(action == 14)
        {
            if(System.currentTimeMillis() - f_lag >= 2000L)
                fr++;
            if(fr > 1)
            {
                fr = 0;
                action = 13;
                y = maxY;
            }
        } else
        if(action == 15)
        {
            if((isWeapon || !isWeapon) && weapon == 34)
            {
                fr++;
                if(face == 26)
                    x -= 2;
                else
                    x += 2;
                if(fr > 1)
                {
                    fr = 0;
                    if(isWeapon)
                        weapon = Armor[ArmorCount];
                    action = 13;
                }
            }
            if(!isWeapon)
            {
                if(weapon == 35)
                {
                    fr = 0;
                    if(fighterCtr % 2 == 0)
                    {
                        action = 13;
                        if(face == 26)
                            x -= 2;
                        else
                            x += 2;
                    }
                } else
                if(weapon == 33)
                {
                    fr = 0;
                    if(fighterCtr % 3 == 0)
                        action = 13;
                }
            } else
            if(weapon == 39)
            {
                fr++;
                if(fr > 2)
                {
                    fr = 0;
                    action = 13;
                }
            } else
            if(weapon == 41)
            {
                if(fighterCtr % 3 == 0)
                    fr++;
                if(fr > 4)
                {
                    fr = 0;
                    action = 13;
                }
            }
            if(weapon != 35 && weapon != 33)
            {
                isWeapon = true;
                if(y == maxY)
                    jt = 0;
            }
            if(weapon == 34)
                if(weaponPicked)
                {
                    isWeapon = true;
                    if(Armor[ArmorCount] == 127)
                        isWeapon = false;
                } else
                {
                    isWeapon = false;
                }
        } else
        if(action == 17)
            if(!isWeapon)
            {
                if(fighterCtr % 5 == 0)
                    action = 13;
            } else
            if(weapon == 39 && isWeapon)
            {
                if(fighterCtr % 3 == 0)
                {
                    fr++;
                    if(face == 26)
                        x += 2;
                    else
                        x -= 2;
                }
                if(fr > 2)
                {
                    fr = 0;
                    action = 13;
                }
            } else
            if(weapon == 41 && isWeapon)
            {
                if(fighterCtr % 3 == 0)
                    fr++;
                if(fr > 1)
                {
                    fr = 0;
                    action = 13;
                }
            }
        reduceHealth();
        try
        {
            if(backAttack && weaponPicked)
            {
                if(x > 50 && x <= 400)
                    if(face == 26)
                        game.RoadArms.addElement(new Arms(weapon, (short)(x - 5), (short)192));
                    else
                        game.RoadArms.addElement(new Arms(weapon, (short)(x + 5), (short)192));
                weaponPicked = false;
                isWeapon = false;
                game.weapon2 = weapon;
                Armor[0] = 127;
                weapon = 35;
                action = 13;
                fr = 0;
            }
        }
        catch(Exception exception)
        {
            System.out.println("--------------hey here is exception-----------" + exception);
        }
        if(hit)
        {
            hitCtr++;
            if(weapon == 34 && isWeapon)
                weapon = Armor[ArmorCount];
        } else
        {
            hitCtr = 0;
        }
        if(!backAttack && hitCtr != 0)
            if(face == 26)
            {
                x += 5;
                if(x > 400)
                    hit = false;
            } else
            {
                x -= 5;
                if(x < 50)
                    hit = false;
            }
        checkBound();
    }

    public void pickUpWeapon()
    {
        try
        {
            for(Enumeration enumeration = game.RoadArms.elements(); enumeration.hasMoreElements();)
            {
                Arms arms = (Arms)enumeration.nextElement();
                if(!weaponPicked && game.weapon2 != 35 && game.weapon2 != 127)
                {
                    switch(game.weapon2)
                    {
                    case 41: // ')'
                        armLyingDist = 40;
                        break;

                    case 39: // '\''
                        armLyingDist = 55;
                        break;
                    }
                    if(Math.abs(x - arms.x) <= 12 && y == maxY)
                    {
                        weaponPicked = true;
                        Armor[ArmorCount] = game.weapon2;
                        weapon = Armor[ArmorCount];
                        action = 13;
                        isWeapon = true;
                        game.weapon2 = 127;
                        game.RoadArms.removeElement(arms);
                    }
                }
            }

        }
        catch(Exception exception)
        {
            System.out.println("@@@@@@@@@@----weapon picking exception-----@@@@@@" + exception);
        }
    }

    public void dropWeapon()
    {
        try
        {
            if(weaponPicked)
            {
                if(x > 50 && x <= 400)
                    if(face == 26)
                        game.RoadArms.addElement(new Arms(weapon, (short)(x - 5), (short)192));
                    else
                        game.RoadArms.addElement(new Arms(weapon, (short)(x + 5), (short)192));
                weaponPicked = false;
                isWeapon = false;
                game.weapon2 = weapon;
                Armor[0] = 127;
                weapon = 35;
                action = 13;
                fr = 0;
            }
        }
        catch(Exception exception)
        {
            System.out.println("--------------hey here is exception-----------" + exception);
        }
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

    public void DoAction(Graphics g)
    {
        if(!hit)
            switch(action)
            {
            case 18: // '\022'
            default:
                break;

            case 13: // '\r'
                drawStand(g);
                break;

            case 14: // '\016'
                if(!isWeapon)
                {
                    drawWalk(g);
                    break;
                }
                if(weapon == 39)
                {
                    axeWalk(g);
                    break;
                }
                if(weapon == 41)
                    chainWalk(g);
                break;

            case 15: // '\017'
                if(weapon == 34 && (isWeapon || !isWeapon))
                {
                    kickAttack(g);
                    break;
                }
                if(!isWeapon)
                {
                    switch(weapon)
                    {
                    case 35: // '#'
                        Attack(g);
                        break;

                    case 33: // '!'
                        crouchAttack(g);
                        break;
                    }
                    break;
                }
                switch(weapon)
                {
                case 39: // '\''
                    axeAttack(g);
                    break;

                case 41: // ')'
                    chainAttack(g);
                    break;
                }
                break;

            case 16: // '\020'
                if(isWeapon)
                {
                    if(weapon == 39)
                    {
                        axeJump(g);
                        break;
                    }
                    if(weapon == 41)
                        chainJump(g);
                } else
                {
                    drawJump(g);
                }
                break;

            case 17: // '\021'
                switch(weapon)
                {
                case 39: // '\''
                    axeAttack(g);
                    break;

                case 41: // ')'
                    chainAttack(g);
                    break;
                }
                break;

            case 19: // '\023'
                drawSumersalt(g);
                break;
            }
        update();
    }

    public void getMotion(byte byte0)
    {
        switch(byte0)
        {
        case 18: // '\022'
        case 19: // '\023'
        case 20: // '\024'
        case 21: // '\025'
        case 24: // '\030'
        case 29: // '\035'
        case 30: // '\036'
        case 31: // '\037'
        case 32: // ' '
        case 33: // '!'
        default:
            break;

        case 22: // '\026'
            if(hit || backAttack)
                break;
            if(y >= maxY)
                jt = 0;
            if(y >= maxY)
            {
                axeJumpCtr = 0;
                chainJumpCtr = 0;
            }
            if(jt == 0 && !isWeapon)
                action = 16;
            else
            if(weapon == 39 && axeJumpCtr == 0)
                action = 16;
            if(weapon == 41 && chainJumpCtr == 0)
                action = 16;
            break;

        case 23: // '\027'
            if(!hit && !backAttack && !isWeapon)
            {
                weapon = 33;
                action = 15;
            }
            break;

        case 25: // '\031'
            if(y != maxY)
                break;
            if(!weaponPicked)
                pickUpWeapon();
            else
                dropWeapon();
            weapon = Armor[ArmorCount];
            if(weapon != 127)
            {
                isWeapon = true;
                break;
            }
            if(weapon == 127)
            {
                isWeapon = false;
                weapon = 35;
            }
            break;

        case 27: // '\033'
            if(hit || backAttack)
                break;
            x += 5;
            checkBound();
            if(jt > 0 && y < maxY && !isWeapon && !sumerSaltPerformed)
            {
                action = 19;
                fr = 0;
                sumerSaltPerformed = true;
            } else
            if(y >= maxY)
                action = 14;
            else
            if(sumerSaltPerformed)
                jt = 13;
            face = 27;
            break;

        case 26: // '\032'
            if(hit || backAttack)
                break;
            x -= 5;
            checkBound();
            if(jt > 0 && y < maxY && !isWeapon && !sumerSaltPerformed)
            {
                action = 19;
                fr = 0;
                sumerSaltPerformed = true;
            } else
            if(y >= maxY)
                action = 14;
            else
            if(sumerSaltPerformed)
                jt = 13;
            face = 26;
            break;

        case 28: // '\034'
            if(hit || backAttack)
                break;
            if(!isWeapon)
                weapon = 35;
            if(isWeapon)
                weapon = Armor[ArmorCount];
            action = 15;
            break;

        case 34: // '"'
            if(hit || backAttack || isWeapon && !isWeapon)
                break;
            weapon = 34;
            if(face == 27)
                x++;
            else
            if(face == 26)
                x--;
            action = 15;
            break;

        case 17: // '\021'
            if(isWeapon)
                action = 17;
            break;
        }
    }

    short x;
    short y;
    byte fr;
    byte action;
    short health;
    byte face;
    boolean isWeapon;
    byte weapon;
    byte Armor[];
    byte ArmorCount;
    byte ArmsCount;
    boolean hit;
    boolean backAttack;
    Game game;
    short fighterCtr;
    short hitCtr;
    boolean weaponPicked;
    short maxY;
    boolean sumerSaltPerformed;
    long f_lag;
    byte jt;
    byte axeJumpCtr;
    byte chainJumpCtr;
    byte armLyingDist;
}