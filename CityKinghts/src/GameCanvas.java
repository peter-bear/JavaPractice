// Decompiled by DJ v3.9.9.91 Copyright 2005 Atanas Neshkov  Date: 2005-11-26 11:41:10
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 

import java.io.IOException;
import java.io.PrintStream;
import java.util.Vector;
import javax.microedition.lcdui.*;

public class GameCanvas extends Canvas
{

    public GameCanvas(CityKnights cityknights)
    {
        cheatLevel = 0;
        page = -1;
        keyTemp = 0;
        loadCtr = 0;
        totalgameData = 7;
        timeCtr = 0;
        assignKey = false;
        waitforAssign = 0;
        cheat = "";
        loadCtr1 = 0;
        totalData = 2;
        cheatpos = 0;
        midlet = cityknights;
        WIDTH = getWidth();
        HEIGHT = getHeight();
        setFullScreenMode(true);
        fireKey = getKeyCode(8);
        leftKey = getKeyCode(2);
        rightKey = getKeyCode(5);
        upKey = getKeyCode(1);
        downKey = getKeyCode(6);
        Key1 = 49;
        Key2 = 50;
        Key3 = 51;
        Key4 = 52;
        Key5 = 53;
        Key6 = 54;
        Key7 = 55;
        Key8 = 56;
        Key9 = 57;
        Key0 = 48;
        KeyP = 35;
        KeyS = 42;
        strtScr = new startScreens(this);
        game = new Game(this);
        if(keySettings.getSettings("keyFire") == 8)
            if(getKeyCode(8) == -5)
                keySettings.setKeySettings("keyFire", -5);
            else
                keySettings.setKeySettings("keyFire", 20);
        if(keySettings.getSettings("keyLeft") == 2)
            if(getKeyCode(2) == -3)
                keySettings.setKeySettings("keyLeft", -3);
            else
                keySettings.setKeySettings("keyLeft", 2);
        if(keySettings.getSettings("keyRight") == 5)
            if(getKeyCode(5) == -4)
                keySettings.setKeySettings("keyRight", -4);
            else
                keySettings.setKeySettings("keyRight", 5);
        if(keySettings.getSettings("keyUp") == 1)
            if(getKeyCode(1) == -1)
                keySettings.setKeySettings("keyUp", -1);
            else
                keySettings.setKeySettings("keyUp", 1);
        if(keySettings.getSettings("keyDown") == 6)
            if(getKeyCode(6) == -2)
                keySettings.setKeySettings("keyDown", -2);
            else
                keySettings.setKeySettings("keyDown", 6);
        try
        {
            getKeys();
        }
        catch(Exception exception)
        {
            System.out.println("jkewhrkewjhr" + exception);
        }
        Gc = this;
    }

    public String getDescription(int i)
    {
        try
        {
            int j = Math.abs(i);
            if(i == 2 || i == -3)
                return Gc.strtScr.Translate("Left");
            if(i == 5 || i == -4)
                return Gc.strtScr.Translate("Right");
            if(i == 1 || i == -1)
                return Gc.strtScr.Translate("Up");
            if(i == 6 || i == -2)
                return Gc.strtScr.Translate("Down");
            if(i == 20 || i == -5)
                return strtScr.Translate("Fire");
            if(i == 49)
                return "1";
            if(i == 50)
                return "2";
            if(i == 51)
                return "3";
            if(i == 52)
                return "4";
            if(i == 53)
                return "5";
            if(i == 54)
                return "6";
            if(i == 55)
                return "7";
            if(i == 56)
                return "8";
            if(i == 57)
                return "9";
            if(i == 35)
                return "#";
            if(i == 42)
                return "*";
            if(i == 48 || i == Key0 || i == 48)
                return Gc.strtScr.Translate("Unassigned");
            if(i == 0)
                return Gc.strtScr.Translate("Unassigned");
            else
                return Gc.strtScr.Translate("Special Key") + " " + j;
        }
        catch(Exception exception)
        {
            System.out.println("asdgjh " + exception);
        }
        return "[ " + i + " ]";
    }

    public void getKeys()
    {
        keyLeft = keySettings.getSettings("keyLeft");
        keyRight = keySettings.getSettings("keyRight");
        keyFire = keySettings.getSettings("keyFire");
        keyUp = keySettings.getSettings("keyUp");
        keyDown = keySettings.getSettings("keyDown");
        keyWeapon = keySettings.getSettings("keyWeapon");
        keyKick = keySettings.getSettings("keyKick");
        keyBlock = keySettings.getSettings("keyBlock");
        if(keyWeapon == 0 && keyKick == 0 && keyBlock == 0)
        {
            keySettings.setKeySettings("keyWeapon", 57);
            keySettings.setKeySettings("keyKick", 49);
            keySettings.setKeySettings("keyBlock", 55);
            keyWeapon = 57;
            keyKick = 49;
            keyBlock = 55;
        }
    }

    public void setKeys()
    {
        keySettings.setKeySettings("keyLeft", keyLeft);
        keySettings.setKeySettings("keyRight", keyRight);
        keySettings.setKeySettings("keyFire", keyFire);
        keySettings.setKeySettings("keyUp", keyUp);
        keySettings.setKeySettings("keyDown", keyDown);
        keySettings.setKeySettings("keyWeapon", keyWeapon);
        keySettings.setKeySettings("keyKick", keyKick);
        keySettings.setKeySettings("keyBlock", keyBlock);
    }

    public void loadGamedata()
    {
        try
        {
            if(loadCtr == 0)
            {
                strtScr.title = Image.createImage("/title.png");
                if(strtScr.title != null)
                    loadCtr++;
            } else
            if(loadCtr == 1)
                loadCtr++;
            else
            if(loadCtr == 2)
            {
                game.playerIm = Image.createImage("/fight.png");
                if(game.playerIm != null)
                    loadCtr++;
            } else
            if(loadCtr == 3)
            {
                game.dieIm = Image.createImage("/die.png");
                if(game.dieIm != null)
                    loadCtr++;
            } else
            if(loadCtr == 4)
            {
                game.vanish = Image.createImage("/vanish.png");
                if(game.vanish != null)
                    loadCtr++;
            } else
            if(loadCtr == 5)
            {
                game.building = Image.createImage("/buiding1.png");
                game.fighterHit = Image.createImage("/bam.png");
                if(game.building != null && game.fighterHit != null)
                    loadCtr++;
            } else
            if(loadCtr == 6)
            {
                game.wall = Image.createImage("/wall.png");
                loadCtr++;
            }
            if(loadCtr >= totalgameData)
                page = 0;
        }
        catch(IOException ioexception)
        {
            System.out.println(ioexception + " ------- " + loadCtr);
        }
        catch(Exception exception)
        {
            System.out.println("here" + exception);
        }
    }

    public void loadLevelData()
    {
        try
        {
            if(loadCtr1 == 0)
                loadCtr1++;
            else
            if(loadCtr1 == 1)
            {
                if(game.axeIm != null)
                    game.axeIm = null;
                if(game.chainIm != null)
                    game.chainIm = null;
                if(game.weapon2 == 39)
                {
                    if(game.axeIm == null)
                    {
                        game.axeIm = Image.createImage("/axe-tile.png");
                        if(game.armsIm == null)
                            game.armsIm = Image.createImage("/weapons.png");
                    }
                } else
                if(game.weapon2 == 41 && game.chainIm == null)
                {
                    game.chainIm = Image.createImage("/chain-tile.png");
                    if(game.armsIm == null)
                        game.armsIm = Image.createImage("/weapons.png");
                }
                loadCtr1++;
            }
            if(loadCtr1 >= totalData)
                page = 10;
        }
        catch(Exception exception)
        {
            System.out.println("there =" + exception);
        }
    }

    public void paint(Graphics g)
    {
        try
        {
            System.gc();
            switch(page)
            {
            default:
                break;

            case -1: 
                loadGamedata();
                strtScr.showLoader(g);
                if(cheat.length() >= 1)
                    cheatLevel = Integer.parseInt(cheat.substring(0, 1));
                break;

            case 0: // '\0'
                if(strtScr.dblogo == null)
                {
                    page = 1;
                    break;
                }
                timeCtr++;
                if(timeCtr > 15)
                    page = 1;
                else
                    strtScr.showSplashScr(g);
                break;

            case 1: // '\001'
                if(game.isSoundOn)
                    game.mp.playMid();
                strtScr.showTitle(g);
                break;

            case 2: // '\002'
                if(strtScr.title != null)
                    strtScr.title = null;
                strtScr.logo = null;
                strtScr.dblogo = null;
                strtScr.showMenu(g);
                break;

            case 3: // '\003'
                strtScr.showAbout(g);
                break;

            case 4: // '\004'
                strtScr.showCredits(g);
                break;

            case 5: // '\005'
                strtScr.keyB = null;
                strtScr.showTopScores(g);
                break;

            case 10: // '\n'
                game.lightening = false;
                if(!game.GameOver)
                {
                    game.Draw(g);
                    break;
                }
                if(game.score == 0)
                {
                    page = 5;
                } else
                {
                    GameScore.openHighScores();
                    page = 100;
                }
                break;

            case 15: // '\017'
                strtScr.showGameOptionsMenu(g);
                break;

            case 16: // '\020'
                strtScr.showLevels(g);
                break;

            case 17: // '\021'
                strtScr.showSound(g);
                break;

            case 19: // '\023'
                strtScr.showLang(g);
                break;

            case 100: // 'd'
                if(strtScr.keyB == null)
                    strtScr.keyB = Image.createImage("/key.png");
                strtScr.showKeyboard(g);
                break;

            case 110: // 'n'
                loadLevelData();
                strtScr.showLoader(g, totalData);
                break;

            case 150: 
                strtScr.showMessage(g);
                break;

            case 200: 
                strtScr.showKeySetup(g);
                break;

            case 11: // '\013'
                strtScr.gameOver(g);
                page = 5;
                break;
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    protected void keyRepeated(int i)
    {
    }

    protected void keyPressed(int i)
    {
        if(i == cheats[cheatpos])
        {
            cheatpos++;
            if(cheatpos == 6)
            {
                cheatpos = 0;
                if(game.cheatL < game.level)
                    game.cheatL = game.level;
                game.cheatL++;
                game.enemyMan.removeAllElements();
            }
        } else
        {
            cheatpos = 0;
        }
        if(keyTemp == 0)
        {
            if(page == 10)
            {
                if(i == keyKick)
                    game.me.getMotion((byte)34);
                else
                if(i == keyFire)
                {
                    game.strypg = 11;
                    game.me.getMotion((byte)28);
                } else
                if(i == keyUp)
                    game.me.getMotion((byte)22);
                else
                if(i == keyDown)
                    game.me.getMotion((byte)23);
                else
                if(i == keyLeft)
                    game.me.getMotion((byte)26);
                else
                if(i == keyRight)
                    game.me.getMotion((byte)27);
                else
                if(i == keyBlock)
                    game.me.getMotion((byte)17);
                if(i == 48)
                {
                    strtScr.selRectPos = 0;
                    game.GamePaused = true;
                    String s = "" + game.lvl + ":" + game.lastlevel + "@" + game.lastscore + "*" + game.lasthealth + "#" + game.levelWeapon;
                    System.out.println("saving game temp" + s);
                    SaveGame.saveGame(s);
                    page = 2;
                }
                if(i == keyWeapon)
                    game.me.getMotion((byte)25);
            } else
            {
                if(i == leftKey || i == -3)
                    switch(page)
                    {
                    case 100: // 'd'
                        KeyBoard.press("left");
                        break;
                    }
                else
                if(i == rightKey || i == -4)
                    switch(page)
                    {
                    case 100: // 'd'
                        KeyBoard.press("right");
                        break;
                    }
                else
                if(i == upKey || i == 50 || i == 1 || i == -1)
                    switch(page)
                    {
                    case 3: // '\003'
                    case 5: // '\005'
                        strtScr.scrlY += 17;
                        if(strtScr.scrlY >= 53)
                            strtScr.scrlY = 53;
                        break;

                    case 2: // '\002'
                        if(strtScr.selRectPos > 0)
                            strtScr.selRectPos--;
                        else
                            strtScr.selRectPos = 6;
                        break;

                    case 15: // '\017'
                        if(strtScr.selRectPos > 0)
                            strtScr.selRectPos--;
                        else
                            strtScr.selRectPos = 3;
                        break;

                    case 16: // '\020'
                        if(strtScr.selRectPos > 0)
                            strtScr.selRectPos--;
                        else
                            strtScr.selRectPos = 2;
                        break;

                    case 17: // '\021'
                        if(strtScr.selRectPos > 0)
                            strtScr.selRectPos--;
                        else
                            strtScr.selRectPos = 1;
                        break;

                    case 18: // '\022'
                        if(strtScr.selRectPos > 0)
                            strtScr.selRectPos--;
                        else
                            strtScr.selRectPos = 1;
                        break;

                    case 19: // '\023'
                        if(strtScr.selRectPos > 0)
                            strtScr.selRectPos--;
                        else
                            strtScr.selRectPos = strtScr.numLangs - 1;
                        break;

                    case 100: // 'd'
                        KeyBoard.press("up");
                        break;

                    case 200: 
                        if(waitforAssign == 0)
                            if(strtScr.selRectPos > 0)
                            {
                                if(strtScr.selRectPos == 8)
                                    strtScr.showMessage = false;
                                strtScr.selRectPos--;
                                if(strtScr.selRectPos < 6 && strtScr.count < 0)
                                {
                                    strtScr.count++;
                                    if(strtScr.count > 0)
                                        strtScr.count = 0;
                                }
                            } else
                            {
                                strtScr.selRectPos = 8;
                                strtScr.scrlY = 53;
                                strtScr.count = -5;
                                strtScr.showMessage = false;
                            }
                        break;
                    }
                else
                if(i == downKey || i == 56 || i == 6 || i == -2)
                    switch(page)
                    {
                    case 3: // '\003'
                    case 5: // '\005'
                        strtScr.scrlY -= 17;
                        break;

                    case 2: // '\002'
                        if(strtScr.selRectPos < 6)
                            strtScr.selRectPos++;
                        else
                            strtScr.selRectPos = 0;
                        break;

                    case 15: // '\017'
                        if(strtScr.selRectPos < 3)
                            strtScr.selRectPos++;
                        else
                            strtScr.selRectPos = 0;
                        break;

                    case 16: // '\020'
                        if(strtScr.selRectPos < 2)
                            strtScr.selRectPos++;
                        else
                            strtScr.selRectPos = 0;
                        break;

                    case 17: // '\021'
                        if(strtScr.selRectPos < 1)
                            strtScr.selRectPos++;
                        else
                            strtScr.selRectPos = 0;
                        break;

                    case 18: // '\022'
                        if(strtScr.selRectPos < 1)
                            strtScr.selRectPos++;
                        else
                            strtScr.selRectPos = 0;
                        break;

                    case 19: // '\023'
                        if(strtScr.selRectPos < strtScr.numLangs - 1)
                            strtScr.selRectPos++;
                        else
                            strtScr.selRectPos = 0;
                        break;

                    case 100: // 'd'
                        KeyBoard.press("down");
                        break;

                    case 200: 
                        if(waitforAssign == 0)
                            if(strtScr.selRectPos < 8)
                            {
                                strtScr.selRectPos++;
                                if(strtScr.selRectPos == 8)
                                    strtScr.showMessage = false;
                                if(strtScr.selRectPos > 5)
                                {
                                    strtScr.count--;
                                    if(strtScr.count < -5)
                                        strtScr.count = -5;
                                }
                            } else
                            {
                                strtScr.selRectPos = 0;
                                strtScr.scrlY = 53;
                                strtScr.count = 0;
                                strtScr.showMessage = false;
                            }
                        break;
                    }
                else
                if(i == fireKey || i == 53 || i == -5 || i == 20)
label0:
                    switch(page)
                    {
                    default:
                        break;

                    case 1: // '\001'
                        game.mp.stopMid();
                        page = 2;
                        break;

                    case 2: // '\002'
                        switch(strtScr.selRectPos)
                        {
                        default:
                            break;

                        case 0: // '\0'
                            strtScr.selRectPos = 0;
                            loadCtr = 0;
                            page = 16;
                            break label0;

                        case 1: // '\001'
                            if(!game.GameOver && game.GamePaused)
                            {
                                SaveGame.saveGame("");
                                game.GamePaused = false;
                                page = 10;
                                break label0;
                            }
                            String s1 = "";
                            try
                            {
                                s1 = SaveGame.getGameData();
                            }
                            catch(Exception exception1)
                            {
                                page = 150;
                                System.out.println("* temp *" + s1 + " " + exception1);
                            }
                            if(s1 != null && !s1.equals("") && !game.GameOver)
                            {
                                loadCtr = 0;
                                game.restartGame(s1);
                                SaveGame.saveGame("");
                                page = 110;
                            } else
                            {
                                page = 150;
                            }
                            break label0;

                        case 2: // '\002'
                            strtScr.selRectPos = 0;
                            strtScr.scrlY = 53;
                            page = 3;
                            break label0;

                        case 3: // '\003'
                            strtScr.selRectPos = 0;
                            page = 5;
                            break label0;

                        case 4: // '\004'
                            strtScr.selRectPos = 0;
                            page = 15;
                            break label0;

                        case 5: // '\005'
                            strtScr.selRectPos = 0;
                            page = 4;
                            break label0;

                        case 6: // '\006'
                            try
                            {
                                midlet.exitMIDlet();
                                break label0;
                            }
                            catch(Exception exception)
                            {
                                System.out.println("exit midlet" + exception);
                                exception.printStackTrace();
                            }
                            break;
                        }
                        break;

                    case 3: // '\003'
                        strtScr.helpTextarr = null;
                        strtScr.scrlY = 53;
                        page = 2;
                        break;

                    case 4: // '\004'
                        strtScr.abutTextarr = null;
                        strtScr.scrlY = 53;
                        page = 2;
                        break;

                    case 5: // '\005'
                        page = 2;
                        strtScr.scrlY = 53;
                        KeyBoard.name = "";
                        KeyBoard.posX = 10;
                        KeyBoard.posY = 103;
                        break;

                    case 6: // '\006'
                        page = 2;
                        break;

                    case 15: // '\017'
                        switch(strtScr.selRectPos)
                        {
                        case 0: // '\0'
                            strtScr.selRectPos = 0;
                            page = 17;
                            break;

                        case 1: // '\001'
                            strtScr.selRectPos = 0;
                            page = 19;
                            break;

                        case 2: // '\002'
                            strtScr.selRectPos = 0;
                            page = 200;
                            break;

                        case 3: // '\003'
                            strtScr.selRectPos = 0;
                            page = 2;
                            break;
                        }
                        break;

                    case 16: // '\020'
                        switch(strtScr.selRectPos)
                        {
                        case 0: // '\0'
                            strtScr.selRectPos = 0;
                            game.lvl = 1;
                            game.restartGame();
                            page = 110;
                            break;

                        case 1: // '\001'
                            strtScr.selRectPos = 0;
                            game.lvl = 2;
                            game.restartGame();
                            page = 110;
                            break;

                        case 2: // '\002'
                            strtScr.selRectPos = 0;
                            game.lvl = 3;
                            game.restartGame();
                            page = 110;
                            break;
                        }
                        break;

                    case 17: // '\021'
                        switch(strtScr.selRectPos)
                        {
                        case 0: // '\0'
                            game.isSoundOn = true;
                            strtScr.selRectPos = 0;
                            page = 15;
                            break;

                        case 1: // '\001'
                            game.isSoundOn = false;
                            strtScr.selRectPos = 0;
                            page = 15;
                            break;
                        }
                        break;

                    case 18: // '\022'
                        switch(strtScr.selRectPos)
                        {
                        case 0: // '\0'
                            game.isVibratorOn = true;
                            strtScr.selRectPos = 0;
                            page = 15;
                            break;

                        case 1: // '\001'
                            game.isVibratorOn = false;
                            strtScr.selRectPos = 0;
                            page = 15;
                            break;
                        }
                        break;

                    case 19: // '\023'
                        String s2 = strtScr.LangLabel[strtScr.selRectPos];
                        strtScr.lang = s2.substring(s2.indexOf(',') + 1, s2.length());
                        strtScr.readDirectory();
                        page = 15;
                        break;

                    case 100: // 'd'
                        boolean flag = KeyBoard.press("select");
                        if(flag)
                        {
                            System.out.println("score = " + game.score + " name = " + KeyBoard.name);
                            GameScore.setHighScore(game.score, KeyBoard.name);
                            page = 5;
                        }
                        break;

                    case 150: 
                        page = 2;
                        strtScr.selRectPos = 0;
                        break;

                    case 200: 
                        switch(strtScr.selRectPos)
                        {
                        case 8: // '\b'
                            if(waitforAssign == 1)
                                break label0;
                            if(checkKey())
                            {
                                strtScr.showMessage = true;
                                page = 200;
                            } else
                            {
                                page = 15;
                                strtScr.scrlY = 53;
                                strtScr.count = 0;
                                getKeys();
                                strtScr.selRectPos = 0;
                            }
                            break;

                        default:
                            waitforAssign++;
                            strtScr.showMessage = true;
                            break;
                        }
                        break;
                    }
                if(page == 200 && waitforAssign > 0)
                    if(waitforAssign == 1 && (i == fireKey || i == 53 || i == 20 || i == -5))
                        waitforAssign++;
                    else
                    if(i != 0 && i != 48 && i != 48)
                    {
                        switch(strtScr.selRectPos)
                        {
                        case 0: // '\0'
                            keySettings.setKeySettings("keyLeft", i);
                            keyLeft = i;
                            break;

                        case 1: // '\001'
                            keySettings.setKeySettings("keyRight", i);
                            keyRight = i;
                            break;

                        case 2: // '\002'
                            keySettings.setKeySettings("keyFire", i);
                            keyFire = i;
                            break;

                        case 3: // '\003'
                            keySettings.setKeySettings("keyUp", i);
                            keyUp = i;
                            break;

                        case 4: // '\004'
                            keySettings.setKeySettings("keyDown", i);
                            keyDown = i;
                            break;

                        case 5: // '\005'
                            keySettings.setKeySettings("keyWeapon", i);
                            keyWeapon = i;
                            break;

                        case 6: // '\006'
                            keySettings.setKeySettings("keyKick", i);
                            keyKick = i;
                            break;

                        case 7: // '\007'
                            keySettings.setKeySettings("keyBlock", i);
                            keyBlock = i;
                            break;
                        }
                        assignKey = true;
                    }
            }
            keyTemp = 1;
        }
    }

    public boolean checkKey()
    {
        for(int i = 1; i < 9; i++)
            if(keySettings.keyCodes[i] == 0)
                return true;

        return false;
    }

    protected void keyReleased(int i)
    {
        if(keyTemp == 1)
            keyTemp = 0;
        if(assignKey)
        {
            waitforAssign = 0;
            strtScr.showMessage = false;
            getKeys();
            assignKey = false;
        }
    }

    public void hideNotify()
    {
        try
        {
            if(page == 10)
            {
                game.GamePaused = true;
                String s = "" + game.lvl + ":" + game.lastlevel + "@" + game.lastscore + "*" + game.lasthealth + "#" + game.levelWeapon;
                SaveGame.saveGame(s);
                page = 2;
            }
        }
        catch(Exception exception)
        {
            System.out.println("hideNotify" + exception);
        }
    }

    public byte getNumber(String s)
    {
        try
        {
            String s1 = "*ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
            char c = s.charAt(0);
            for(byte byte0 = 0; byte0 < s1.length(); byte0++)
                if(c == s1.charAt(byte0))
                    return byte0;

        }
        catch(Exception exception)
        {
            System.out.println(" num ber " + exception);
            return 0;
        }
        return 0;
    }

    int cheatLevel;
    int page;
    private Command cmdExit;
    private Command cmdClear;
    protected int fireKey;
    protected int leftKey;
    protected int rightKey;
    protected int upKey;
    protected int downKey;
    protected int Key1;
    protected int Key2;
    protected int Key3;
    protected int Key4;
    protected int Key5;
    protected int Key6;
    protected int Key7;
    protected int Key8;
    protected int Key9;
    protected int Key0;
    protected int KeyP;
    protected int KeyS;
    int WIDTH;
    int HEIGHT;
    startScreens strtScr;
    Game game;
    CityKnights midlet;
    int keyTemp;
    int loadCtr;
    int totalgameData;
    int timeCtr;
    GameCanvas Gc;
    int keyLeft;
    int keyRight;
    int keyFire;
    int keyUp;
    int keyDown;
    int keyWeapon;
    int keyKick;
    int keyBlock;
    boolean assignKey;
    byte waitforAssign;
    String cheat;
    int loadCtr1;
    int totalData;
    int cheats[] = {
        49, 57, 51, 55, 49, 57
    };
    int cheatpos;
}