// Decompiled by DJ v3.9.9.91 Copyright 2005 Atanas Neshkov  Date: 2005-11-26 11:37:47
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 

import java.io.*;
import javax.microedition.lcdui.*;

class startScreens
{

    public startScreens(GameCanvas gamecanvas)
    {
        scrlY = 53;
        count = 0;
        numLangs = 1;
        Directory = new String[320];
        showMessage = false;
        Gc = gamecanvas;
        WIDTH = 176;
        HEIGHT = 220;
        try
        {
            LangLabel = new String[8];
            readLangLabels();
        }
        catch(Exception exception)
        {
            System.out.println("got" + exception);
        }
        try
        {
            logo = Image.createImage("/logo.png");
        }
        catch(Exception exception1)
        {
            System.out.println("error in startScreens" + exception1);
        }
        try
        {
            dblogo = Image.createImage("/dblogo.png");
        }
        catch(Exception exception2)
        {
            dblogo = null;
        }
    }

    public void readLangLabels()
    {
        int i = 0;
        try
        {
            Class class1 = getClass();
            InputStream inputstream = class1.getResourceAsStream("/languages.txt");
            String s = "";
            for(byte abyte0[] = new byte[1]; inputstream.read(abyte0) != -1;)
                if((new String(abyte0)).equals("~"))
                {
                    LangLabel[i] = s;
                    s = "";
                    i++;
                    numLangs = (byte)i;
                } else
                {
                    s = s + new String(abyte0);
                }

            inputstream.close();
        }
        catch(IOException ioexception)
        {
            ioexception.printStackTrace();
            System.out.println("hererer" + ioexception);
        }
    }

    public void showLoader(Graphics g)
    {
        g.setColor(255, 255, 255);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setColor(255, 0, 0);
        g.setColor(255, 255, 255);
        g.fillRect(28, 170, 120, 10);
        g.setColor(229, 101, 0);
        g.fillRect(28, 170, (120 / Gc.totalgameData) * Gc.loadCtr, 10);
        if(dblogo != null)
            g.drawImage(dblogo, 22, 90, 4 | 0x10);
        else
            g.drawImage(logo, 22, 90, 4 | 0x10);
        g.setColor(252, 255, 0);
        g.drawRect(28, 170, 120, 10);
        g.setColor(0, 0, 255);
        g.drawRect(27, 169, 122, 12);
    }

    public void showLoader(Graphics g, int i)
    {
        g.setColor(66, 69, 66);
        g.fillRect(0, 0, 176, 220);
        g.setColor(207, 12, 0);
        g.drawRoundRect(10, 60, 157, 125, 10, 10);
        g.setColor(255, 255, 255);
        g.fillRect(28, 150, 120, 10);
        g.setColor(255, 204, 51);
        g.fillRect(28, 150, (120 / i) * Gc.loadCtr1, 10);
        g.setColor(252, 255, 0);
        g.drawRect(28, 150, 120, 10);
        g.setColor(0, 0, 255);
        g.drawRect(27, 149, 122, 12);
    }

    public void showSplashScr(Graphics g)
    {
        g.setColor(255, 255, 255);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.drawImage(logo, 22, 90, 4 | 0x10);
    }

    public void showTitle(Graphics g)
    {
        try
        {
            g.setColor(231, 156, 74);
            g.fillRect(0, 0, WIDTH, HEIGHT);
            g.drawImage(title, WIDTH / 2, HEIGHT / 2, 1 | 2);
            g.setColor(255, 255, 255);
            g.setFont(Font.getFont(0, 0, 8));
            g.drawString(Translate("Press Joystick"), WIDTH / 2, 6, 1 | 0x10);
        }
        catch(Exception exception)
        {
            System.out.println(" wedfwemnb " + exception);
        }
    }

    public void showMenu(Graphics g)
    {
        g.setColor(66, 69, 66);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setColor(255, 204, 0);
        g.fillRoundRect(0, 40, WIDTH, 17, 20, 20);
        g.setColor(200, 182, 236);
        g.drawRoundRect(0, 40, WIDTH, 17, 20, 20);
        g.setColor(0, 0, 0);
        g.setFont(Font.getFont(0, 0, 8));
        g.drawString(Translate("Main Menu"), WIDTH / 2, 41, 0x10 | 1);
        g.setColor(207, 12, 0);
        g.drawRoundRect(10, 60, 157, 138, 10, 10);
        g.setFont(Font.getFont(0, 0, 8));
        g.setColor(255, 253, 232);
        g.drawString(Translate("New Game"), WIDTH / 2, 65, 0x10 | 1);
        g.drawString(Translate("Resume Game"), WIDTH / 2, 83, 0x10 | 1);
        g.drawString(Translate("Help"), WIDTH / 2, 101, 0x10 | 1);
        g.drawString(Translate("High Scores"), WIDTH / 2, 119, 0x10 | 1);
        g.drawString(Translate("Game Options"), WIDTH / 2, 137, 0x10 | 1);
        g.drawString(Translate("About"), WIDTH / 2, 155, 0x10 | 1);
        g.drawString(Translate("Quit"), WIDTH / 2, 173, 0x10 | 1);
        switch(selRectPos)
        {
        case 0: // '\0'
            g.drawRoundRect(25, 64, 135, 18, 9, 9);
            g.setColor(255, 233, 0);
            g.drawString(Translate("New Game"), WIDTH / 2, 65, 0x10 | 1);
            break;

        case 1: // '\001'
            g.drawRoundRect(25, 82, 135, 18, 9, 9);
            g.setColor(255, 233, 0);
            g.drawString(Translate("Resume Game"), WIDTH / 2, 83, 0x10 | 1);
            break;

        case 2: // '\002'
            g.drawRoundRect(25, 100, 135, 18, 9, 9);
            g.setColor(255, 233, 0);
            g.drawString(Translate("Help"), WIDTH / 2, 101, 0x10 | 1);
            break;

        case 3: // '\003'
            g.drawRoundRect(25, 118, 135, 18, 9, 9);
            g.setColor(255, 233, 0);
            g.drawString(Translate("High Scores"), WIDTH / 2, 119, 0x10 | 1);
            break;

        case 4: // '\004'
            g.drawRoundRect(25, 136, 135, 18, 9, 9);
            g.setColor(255, 233, 0);
            g.drawString(Translate("Game Options"), WIDTH / 2, 137, 0x10 | 1);
            break;

        case 5: // '\005'
            g.drawRoundRect(25, 154, 135, 18, 9, 9);
            g.setColor(255, 233, 0);
            g.drawString(Translate("About"), WIDTH / 2, 155, 0x10 | 1);
            break;

        case 6: // '\006'
            g.drawRoundRect(25, 172, 135, 18, 9, 9);
            g.setColor(255, 233, 0);
            g.drawString(Translate("Quit"), WIDTH / 2, 173, 0x10 | 1);
            break;
        }
    }

    public void showAbout(Graphics g)
    {
        if(helpTextarr == null)
        {
            helpTextarr = new String[30];
            readHelp(lang);
        }
        g.setColor(66, 69, 66);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setFont(Font.getFont(0, 0, 8));
        g.setColor(255, 253, 232);
        int i = Font.getFont(0, 0, 8).getHeight();
        byte byte0 = 12;
        int j = 0;
        for(int k = 0; k < helpTextarr.length; k++)
        {
            if(helpTextarr[k] == null)
                break;
            g.drawString(helpTextarr[k], byte0, (scrlY + i * j) - 5, 0x10 | 4);
            j++;
        }

        g.setColor(217, 217, 217);
        g.fillRect(170, 65, 2, 163);
        g.setColor(255, 0, 0);
        g.fillRect(170, 45 + (53 - scrlY) + 9, 2, 8);
        g.setColor(66, 69, 66);
        g.fillRect(0, 0, WIDTH, 66);
        g.fillRect(0, 167, WIDTH, 60);
        g.setColor(255, 0, 0);
        g.setFont(Font.getFont(0, 0, 8));
        g.drawString(Translate("Press Joystick"), WIDTH / 2, HEIGHT - 36, 0x10 | 1);
        g.setColor(207, 12, 0);
        g.drawRoundRect(8, 45, 159, 127, 10, 10);
        g.setFont(Font.getFont(0, 0, 8));
        g.setColor(255, 204, 0);
        g.fillRoundRect(0, 42, WIDTH, 17, 20, 20);
        g.setColor(200, 182, 236);
        g.drawRoundRect(0, 42, WIDTH, 17, 20, 20);
        g.setColor(0, 0, 0);
        g.drawString(Translate("Help"), WIDTH / 2, 43, 0x10 | 1);
    }

    public void showCredits(Graphics g)
    {
        if(abutTextarr == null)
        {
            abutTextarr = new String[30];
            readAbut(lang);
        }
        g.setColor(66, 69, 66);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setFont(Font.getFont(0, 0, 8));
        g.setColor(255, 253, 232);
        int i = Font.getFont(0, 0, 8).getHeight();
        byte byte0 = 20;
        int j = 0;
        for(int k = 0; k < abutTextarr.length; k++)
        {
            if(abutTextarr[k] == null)
                break;
            g.drawString(abutTextarr[k], byte0, scrlY + i * j, 0x10 | 4);
            j++;
        }

        g.setColor(66, 69, 66);
        g.fillRect(0, 0, WIDTH, 65);
        g.setColor(255, 0, 0);
        g.setFont(Font.getFont(0, 0, 8));
        g.drawString(Translate("Press Joystick"), WIDTH / 2, HEIGHT - 36, 0x10 | 1);
        g.setColor(207, 12, 0);
        g.drawRoundRect(9, 60, 157, 117, 10, 10);
        g.setFont(Font.getFont(0, 0, 8));
        g.setColor(255, 204, 0);
        g.fillRoundRect(0, 42, WIDTH, 17, 20, 20);
        g.setColor(200, 182, 236);
        g.drawRoundRect(0, 42, WIDTH, 17, 20, 20);
        g.setColor(0, 0, 0);
        g.drawString(Translate("About"), WIDTH / 2, 43, 0x10 | 1);
    }

    public void showTopScores(Graphics g)
    {
        g.setColor(66, 69, 66);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        byte byte0 = 10;
        byte byte1 = 17;
        g.setFont(Font.getFont(0, 0, 8));
        g.setColor(255, 255, 255);
        int i = scrlY + 15;
        try
        {
            for(int j = 0; j < 10; j++)
            {
                String s = GameScore.getHighScoreName(j);
                int k = GameScore.getHighScore(j);
                int l = 14 + Font.getFont(0, 0, 8).stringWidth("10. ");
                g.drawString((j + 1) + ".", 14, i + 17 * j, 0x10 | 4);
                g.drawString(s, l, i + 17 * j, 0x10 | 4);
                g.drawString("" + k, WIDTH - l, i + 17 * j, 0x10 | 8);
            }

        }
        catch(Exception exception)
        {
            System.out.println("sas " + exception);
        }
        g.setColor(66, 69, 66);
        g.fillRect(0, 0, 176, 69);
        g.fillRect(0, HEIGHT - 34, WIDTH, 50);
        g.setColor(207, 12, 0);
        g.drawRoundRect(10, 63, 157, 122, 10, 10);
        g.setColor(255, 0, 0);
        g.setFont(Font.getFont(0, 0, 8));
        g.drawString(Translate("Press Joystick"), WIDTH / 2, HEIGHT - 36, 0x10 | 1);
        g.setFont(Font.getFont(0, 0, 8));
        g.setColor(255, 204, 0);
        g.fillRoundRect(0, 42, WIDTH, 17, 20, 20);
        g.setColor(200, 182, 236);
        g.drawRoundRect(0, 42, WIDTH, 17, 20, 20);
        g.setColor(0, 0, 0);
        g.drawString(Translate("High Scores"), WIDTH / 2, 43, 0x10 | 1);
    }

    public void showGameOptionsMenu(Graphics g)
    {
        g.setColor(66, 69, 66);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setColor(207, 12, 0);
        g.drawRoundRect(10, 65, 157, 130, 10, 10);
        g.setFont(Font.getFont(0, 0, 8));
        g.setColor(255, 204, 0);
        g.fillRoundRect(0, 42, WIDTH, 17, 20, 20);
        g.setColor(200, 182, 236);
        g.drawRoundRect(0, 42, WIDTH, 17, 20, 20);
        g.setColor(0, 0, 0);
        g.drawString(Translate("Game Options"), WIDTH / 2, 43, 0x10 | 1);
        String s = "";
        String s1 = "";
        if(Gc.game.isSoundOn)
            s = "On";
        else
            s = "Off";
        g.setFont(Font.getFont(0, 0, 8));
        g.setColor(255, 253, 232);
        g.drawString(Translate("Sound") + " " + Translate(s), WIDTH / 2, 70, 0x10 | 1);
        g.drawString(Translate("Language"), WIDTH / 2, 90, 0x10 | 1);
        g.drawString(Translate("Key Setup"), WIDTH / 2, 110, 0x10 | 1);
        g.drawString(Translate("Main Menu"), WIDTH / 2, 130, 0x10 | 1);
        switch(selRectPos)
        {
        case 0: // '\0'
            g.drawRoundRect(40, 69, 100, 18, 9, 9);
            g.setColor(255, 233, 0);
            g.drawString(Translate("Sound") + " " + Translate(s), WIDTH / 2, 70, 0x10 | 1);
            break;

        case 1: // '\001'
            g.drawRoundRect(40, 89, 100, 18, 9, 9);
            g.setColor(255, 233, 0);
            g.drawString(Translate("Language"), WIDTH / 2, 90, 0x10 | 1);
            break;

        case 2: // '\002'
            g.drawRoundRect(40, 109, 100, 18, 9, 9);
            g.setColor(255, 233, 0);
            g.drawString(Translate("Key Setup"), WIDTH / 2, 110, 0x10 | 1);
            break;

        case 3: // '\003'
            g.drawRoundRect(40, 129, 100, 18, 9, 9);
            g.setColor(255, 233, 0);
            g.drawString(Translate("Main Menu"), WIDTH / 2, 130, 0x10 | 1);
            break;
        }
    }

    public void gameOver(Graphics g)
    {
        g.fillRect(0, 0, WIDTH, HEIGHT);
    }

    public void showLevels(Graphics g)
    {
        g.setColor(66, 69, 66);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setColor(207, 12, 0);
        g.drawRoundRect(10, 45, 157, 150, 10, 10);
        g.setFont(Font.getFont(0, 0, 8));
        g.setColor(255, 204, 0);
        g.fillRoundRect(0, 42, WIDTH, 17, 20, 20);
        g.setColor(200, 182, 236);
        g.drawRoundRect(0, 42, WIDTH, 17, 20, 20);
        g.setColor(0, 0, 0);
        g.drawString(Translate("Level"), WIDTH / 2, 43, 0x10 | 1);
        g.setFont(Font.getFont(0, 0, 8));
        g.setColor(255, 253, 232);
        g.drawString(Translate("Level Easy"), WIDTH / 2, 70, 0x10 | 1);
        g.drawString(Translate("Level Medium"), WIDTH / 2, 90, 0x10 | 1);
        g.drawString(Translate("Level Hard"), WIDTH / 2, 110, 0x10 | 1);
        switch(selRectPos)
        {
        case 0: // '\0'
            g.drawRoundRect(40, 69, 100, 18, 9, 9);
            g.setColor(255, 233, 0);
            g.drawString(Translate("Level Easy"), WIDTH / 2, 70, 0x10 | 1);
            break;

        case 1: // '\001'
            g.drawRoundRect(40, 89, 100, 18, 9, 9);
            g.setColor(255, 233, 0);
            g.drawString(Translate("Level Medium"), WIDTH / 2, 90, 0x10 | 1);
            break;

        case 2: // '\002'
            g.drawRoundRect(40, 109, 100, 18, 9, 9);
            g.setColor(255, 233, 0);
            g.drawString(Translate("Level Hard"), WIDTH / 2, 110, 0x10 | 1);
            break;
        }
    }

    public void showSound(Graphics g)
    {
        g.setColor(66, 69, 66);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setColor(207, 12, 0);
        g.drawRoundRect(10, 65, 157, 130, 10, 10);
        g.setFont(Font.getFont(0, 0, 8));
        g.setColor(255, 204, 0);
        g.fillRoundRect(0, 42, WIDTH, 17, 20, 20);
        g.setColor(200, 182, 236);
        g.drawRoundRect(0, 42, WIDTH, 17, 20, 20);
        g.setColor(0, 0, 0);
        g.drawString(Translate("Sound"), WIDTH / 2, 43, 0x10 | 1);
        g.setFont(Font.getFont(0, 0, 8));
        g.setColor(255, 253, 232);
        g.drawString(Translate("Sound On"), WIDTH / 2, 90, 0x10 | 1);
        g.drawString(Translate("Sound Off"), WIDTH / 2, 110, 0x10 | 1);
        switch(selRectPos)
        {
        case 0: // '\0'
            g.drawRoundRect(40, 89, 100, 18, 9, 9);
            g.setColor(255, 233, 0);
            g.drawString(Translate("Sound On"), WIDTH / 2, 90, 0x10 | 1);
            break;

        case 1: // '\001'
            g.drawRoundRect(40, 109, 100, 18, 9, 9);
            g.setColor(255, 233, 0);
            g.drawString(Translate("Sound Off"), WIDTH / 2, 110, 0x10 | 1);
            break;
        }
    }

    public void showLang(Graphics g)
    {
        try
        {
            g.setColor(66, 69, 66);
            g.fillRect(0, 0, WIDTH, HEIGHT);
            g.setColor(207, 12, 0);
            g.drawRoundRect(10, 65, 157, 135, 10, 10);
            g.setFont(Font.getFont(0, 0, 8));
            g.setColor(255, 204, 0);
            g.fillRoundRect(0, 42, WIDTH, 17, 20, 20);
            g.setColor(200, 182, 236);
            g.drawRoundRect(0, 42, WIDTH, 17, 20, 20);
            g.setColor(0, 0, 0);
            g.drawString(Translate("Language"), WIDTH / 2, 43, 0x10 | 1);
            g.setFont(Font.getFont(0, 0, 8));
            g.setColor(255, 253, 232);
            int i = 77;
            for(byte byte0 = 0; byte0 < numLangs; byte0++)
            {
                g.drawString(LangLabel[byte0].substring(0, LangLabel[byte0].indexOf(',')), WIDTH / 2, i, 0x10 | 1);
                i += 20;
            }

            g.drawRoundRect(40, 76 + 20 * selRectPos, 100, 18, 9, 9);
            g.setColor(255, 233, 0);
            g.drawString(LangLabel[selRectPos].substring(0, LangLabel[selRectPos].indexOf(',')), WIDTH / 2, 77 + 20 * selRectPos, 0x10 | 1);
        }
        catch(Exception exception)
        {
            System.out.println("Lang Menu " + exception);
        }
    }

    public void showKeyboard(Graphics g)
    {
        g.setColor(66, 69, 66);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setColor(207, 12, 0);
        g.drawRoundRect(10, 45, 157, 153, 10, 10);
        g.setFont(Font.getFont(0, 0, 8));
        g.drawString(Translate("Enter Name"), 53, 51, 0x10 | 4);
        g.setFont(Font.getFont(0, 0, 8));
        g.setColor(255, 253, 232);
        g.setColor(255, 255, 255);
        g.fillRect(20, 70, 136, 17);
        g.setColor(0, 0, 0);
        g.drawString(KeyBoard.name, 21, 70, 0x10 | 4);
        g.drawImage(keyB, 6, 100, 4 | 0x10);
        g.setColor(255, 0, 0);
        g.drawRect(KeyBoard.posX, KeyBoard.posY, 13, 13);
        g.drawRect(KeyBoard.posX - 1, KeyBoard.posY - 1, 15, 15);
    }

    public void showMessage(Graphics g)
    {
        g.setColor(66, 69, 66);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setColor(207, 12, 0);
        g.drawRoundRect(10, 45, 157, HEIGHT - 40 - 45, 10, 10);
        g.setFont(Font.getFont(0, 0, 8));
        g.setColor(255, 253, 232);
        g.drawString(Translate("Sorry! there is no Game"), 24, 63, 0x10 | 4);
        g.drawString(Translate("saved which can be"), 24, 81, 0x10 | 4);
        g.drawString(Translate("resumed") + ".", 24, 99, 0x10 | 4);
        g.setColor(255, 0, 0);
        g.setFont(Font.getFont(0, 0, 8));
        g.drawString(Translate("Press Joystick"), WIDTH / 2, HEIGHT - 36, 0x10 | 1);
    }

    public void showKeySetup(Graphics g)
    {
        int i = 0;
        try
        {
            g.setColor(66, 69, 66);
            g.fillRect(0, 0, WIDTH, HEIGHT);
            g.setFont(Font.getFont(0, 0, 8));
            g.setColor(255, 253, 232);
            g.drawString(Translate("Left") + ": " + Gc.getDescription(Gc.keyLeft), 14, scrlY + 10 + 17 * (count + 0), 0x10 | 4);
            g.drawString(Translate("Right") + ": " + Gc.getDescription(Gc.keyRight), 14, scrlY + 10 + 17 * (count + 1), 0x10 | 4);
            g.drawString(Translate("Fire") + ": " + Gc.getDescription(Gc.keyFire), 14, scrlY + 10 + 17 * (count + 2), 0x10 | 4);
            g.drawString(Translate("Up") + ": " + Gc.getDescription(Gc.keyUp), 14, scrlY + 10 + 17 * (count + 3), 0x10 | 4);
            g.drawString(Translate("Down") + ": " + Gc.getDescription(Gc.keyDown), 14, scrlY + 10 + 17 * (count + 4), 0x10 | 4);
            g.drawString(Translate("Weapon") + ": " + Gc.getDescription(Gc.keyWeapon), 14, scrlY + 10 + 17 * (count + 5), 0x10 | 4);
            g.drawString(Translate("Kick") + ": " + Gc.getDescription(Gc.keyKick), 14, scrlY + 10 + 17 * (count + 6), 0x10 | 4);
            g.drawString(Translate("Block") + ": " + Gc.getDescription(Gc.keyBlock), 14, scrlY + 10 + 17 * (count + 7), 0x10 | 4);
            g.drawString(Translate("Game Options"), 14, scrlY + 10 + 17 * (count + 8), 0x10 | 4);
            g.setColor(66, 69, 66);
            g.fillRect(0, 181, WIDTH, 60);
            g.setFont(Font.getFont(0, 0, 8));
            switch(selRectPos)
            {
            default:
                break;

            case 0: // '\0'
                g.setColor(255, 233, 0);
                g.drawString(Translate("Left") + ": " + Gc.getDescription(Gc.keyLeft), 14, scrlY + 10 + 17 * (count + 0), 0x10 | 4);
                if(showMessage)
                {
                    g.setColor(255, 233, 0);
                    g.setFont(Font.getFont(0, 0, 8));
                    g.drawString(Translate("Press key for") + " " + Translate("Left"), 88, 182, 1 | 0x10);
                }
                break;

            case 1: // '\001'
                g.setColor(255, 233, 0);
                g.drawString(Translate("Right") + ": " + Gc.getDescription(Gc.keyRight), 14, scrlY + 10 + 17 * (count + 1), 0x10 | 4);
                if(showMessage)
                {
                    g.setColor(255, 233, 0);
                    g.setFont(Font.getFont(0, 0, 8));
                    g.drawString(Translate("Press key for") + " " + Translate("Right"), 88, 182, 1 | 0x10);
                }
                break;

            case 2: // '\002'
                g.setColor(255, 233, 0);
                g.drawString(Translate("Fire") + ": " + Gc.getDescription(Gc.keyFire), 14, scrlY + 10 + 17 * (count + 2), 0x10 | 4);
                if(showMessage)
                {
                    g.setColor(255, 233, 0);
                    g.setFont(Font.getFont(0, 0, 8));
                    g.drawString(Translate("Press key for") + " " + Translate("Fire"), 88, 182, 1 | 0x10);
                }
                break;

            case 3: // '\003'
                g.setColor(255, 233, 0);
                g.drawString(Translate("Up") + ": " + Gc.getDescription(Gc.keyUp), 14, scrlY + 10 + 17 * (count + 3), 0x10 | 4);
                if(showMessage)
                {
                    g.setColor(255, 233, 0);
                    g.setFont(Font.getFont(0, 0, 8));
                    g.drawString(Translate("Press key for") + " " + Translate("Up"), 88, 182, 1 | 0x10);
                }
                break;

            case 4: // '\004'
                g.setColor(255, 233, 0);
                g.drawString(Translate("Down") + ": " + Gc.getDescription(Gc.keyDown), 14, scrlY + 10 + 17 * (count + 4), 0x10 | 4);
                if(showMessage)
                {
                    g.setColor(255, 233, 0);
                    g.setFont(Font.getFont(0, 0, 8));
                    g.drawString(Translate("Press key for") + " " + Translate("Down"), 88, 182, 1 | 0x10);
                }
                break;

            case 5: // '\005'
                g.setColor(255, 233, 0);
                g.drawString(Translate("Weapon") + ": " + Gc.getDescription(Gc.keyWeapon), 14, scrlY + 10 + 17 * (count + 5), 0x10 | 4);
                if(showMessage)
                {
                    g.setColor(255, 233, 0);
                    g.setFont(Font.getFont(0, 0, 8));
                    g.drawString(Translate("Press key for") + " " + Translate("Weapon"), 88, 182, 1 | 0x10);
                }
                break;

            case 6: // '\006'
                g.setColor(255, 233, 0);
                g.drawString(Translate("Kick") + ": " + Gc.getDescription(Gc.keyKick), 14, scrlY + 10 + 17 * (count + 6), 0x10 | 4);
                if(showMessage)
                {
                    g.setColor(255, 233, 0);
                    g.setFont(Font.getFont(0, 0, 8));
                    g.drawString(Translate("Press key for") + " " + Translate("Kick"), 88, 182, 1 | 0x10);
                }
                break;

            case 7: // '\007'
                g.setColor(255, 233, 0);
                g.drawString(Translate("Block") + ": " + Gc.getDescription(Gc.keyBlock), 14, scrlY + 10 + 17 * (count + 7), 0x10 | 4);
                if(showMessage)
                {
                    g.setColor(255, 233, 0);
                    g.setFont(Font.getFont(0, 0, 8));
                    g.drawString(Translate("Press key for") + " " + Translate("Block"), 88, 182, 1 | 0x10);
                }
                break;

            case 8: // '\b'
                g.setColor(255, 233, 0);
                g.drawString(Translate("Game Options"), 14, scrlY + 10 + 17 * (count + 8), 0x10 | 4);
                if(showMessage)
                {
                    g.setColor(255, 233, 0);
                    g.setFont(Font.getFont(0, 0, 8));
                    g.drawString(Translate("One or More Keys Blank"), 88, 182, 1 | 0x10);
                }
                break;
            }
            g.setColor(66, 69, 66);
            g.fillRect(0, 0, WIDTH, 63);
            g.setColor(207, 12, 0);
            g.drawRoundRect(10, 62, 157, 138, 10, 10);
            g.setFont(Font.getFont(0, 0, 8));
            g.setColor(255, 204, 0);
            g.fillRoundRect(0, 42, WIDTH, 17, 20, 20);
            g.setColor(200, 182, 236);
            g.drawRoundRect(0, 42, WIDTH, 17, 20, 20);
            g.setColor(0, 0, 0);
            g.drawString(Translate("Key Setup"), WIDTH / 2, 43, 0x10 | 1);
        }
        catch(Exception exception)
        {
            System.out.println("in strtscr " + exception + "  " + i);
        }
    }

    public void readHelp(String s)
    {
        int i = 0;
        try
        {
            String s1 = "";
            Class class1 = getClass();
            InputStream inputstream = class1.getResourceAsStream("/help." + s + ".txt");
            DataInputStream datainputstream = new DataInputStream(inputstream);
            byte abyte0[] = new byte[700];
            try
            {
                datainputstream.read(abyte0);
            }
            catch(Exception exception)
            {
                System.out.println("2 " + exception);
            }
            if((char)abyte0[0] == 'A')
            {
                abyte0[0] = 32;
                s1 = new String(abyte0, "ISO8859_1");
            } else
            if((char)abyte0[0] == 'B')
            {
                abyte0[0] = 32;
                s1 = new String(abyte0, "UTF-8");
            }
            abyte0 = null;
            inputstream.close();
            datainputstream = null;
            try
            {
                helpTextarr[i] = "";
                for(int j = 1; j < s1.length(); j++)
                {
                    if(s1.charAt(j) == '|' && s1.charAt(j + 1) == '|' && s1.charAt(j + 2) == '|')
                        break;
                    if(s1.charAt(j) == '~')
                    {
                        i++;
                        helpTextarr[i] = "";
                    } else
                    {
                        helpTextarr[i] += s1.charAt(j);
                    }
                }

            }
            catch(Exception exception1)
            {
                System.out.println("1 " + exception1);
            }
        }
        catch(IOException ioexception)
        {
            ioexception.printStackTrace();
            System.out.println(ioexception);
        }
    }

    public void readAbut(String s)
    {
        int i = 0;
        try
        {
            String s1 = "";
            Class class1 = getClass();
            InputStream inputstream = class1.getResourceAsStream("/about." + s + ".txt");
            DataInputStream datainputstream = new DataInputStream(inputstream);
            byte abyte0[] = new byte[200];
            try
            {
                datainputstream.read(abyte0);
            }
            catch(Exception exception)
            {
                System.out.println("2 " + exception);
            }
            if((char)abyte0[0] == 'A')
            {
                abyte0[0] = 32;
                s1 = new String(abyte0, "ISO8859_1");
            } else
            if((char)abyte0[0] == 'B')
            {
                abyte0[0] = 32;
                s1 = new String(abyte0, "UTF-8");
            }
            abyte0 = null;
            inputstream.close();
            datainputstream = null;
            try
            {
                abutTextarr[i] = "";
                for(int j = 1; j < s1.length(); j++)
                {
                    if(s1.charAt(j) == '|' && s1.charAt(j + 1) == '|' && s1.charAt(j + 2) == '|')
                        break;
                    if(s1.charAt(j) == '~')
                    {
                        i++;
                        abutTextarr[i] = "";
                    } else
                    {
                        abutTextarr[i] += s1.charAt(j);
                    }
                }

            }
            catch(Exception exception1)
            {
                System.out.println("1 " + exception1);
            }
        }
        catch(IOException ioexception)
        {
            ioexception.printStackTrace();
            System.out.println(ioexception);
        }
    }

    public void readDirectory()
    {
        int i = 0;
        try
        {
            String s = "";
            Class class1 = getClass();
            InputStream inputstream = class1.getResourceAsStream("/texts." + lang + ".txt");
            DataInputStream datainputstream = new DataInputStream(inputstream);
            byte abyte0[] = new byte[2000];
            try
            {
                datainputstream.readFully(abyte0);
            }
            catch(Exception exception)
            {
                System.out.println("2 " + exception);
            }
            if((char)abyte0[0] == 'A')
            {
                abyte0[0] = 32;
                s = new String(abyte0, "ISO8859_1");
            } else
            if((char)abyte0[0] == 'B')
            {
                abyte0[0] = 32;
                s = new String(abyte0, "UTF-8");
            }
            abyte0 = null;
            inputstream.close();
            datainputstream = null;
            try
            {
                Directory[i] = "";
                for(int j = 1; j < s.length(); j++)
                {
                    if(s.charAt(j) == '|' && s.charAt(j + 1) == '|' && s.charAt(j + 2) == '|')
                        break;
                    if(s.charAt(j) == '~')
                    {
                        i++;
                        Directory[i] = "";
                    } else
                    {
                        Directory[i] += s.charAt(j);
                    }
                }

            }
            catch(Exception exception1)
            {
                System.out.println("1 " + exception1);
            }
        }
        catch(IOException ioexception)
        {
            ioexception.printStackTrace();
            System.out.println(ioexception);
        }
        directoryLength = (byte)i;
    }

    public String Translate(String s)
    {
        try
        {
            for(int i = 0; i < directoryLength; i++)
                if(s.equals(Directory[i].substring(0, Directory[i].indexOf('*'))))
                    return Directory[i].substring(Directory[i].indexOf('*') + 1, Directory[i].length());

        }
        catch(Exception exception)
        {
            System.out.println("herer" + exception);
        }
        return "";
    }

    private int WIDTH;
    private int HEIGHT;
    int selRectPos;
    GameCanvas Gc;
    Image logo;
    Image dblogo;
    Image title;
    Image title_sm;
    Image keyB;
    int scrlY;
    int count;
    String helpTextarr[];
    String abutTextarr[];
    String lang;
    String LangLabel[];
    byte numLangs;
    String Directory[];
    byte directoryLength;
    boolean showMessage;
}