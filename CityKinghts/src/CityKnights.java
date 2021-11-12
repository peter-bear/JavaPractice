// Decompiled by Jad v1.5.7g. Copyright 2000 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/SiliconValley/Bridge/8617/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi 

import java.io.DataInputStream;
import java.io.PrintStream;
import java.util.Timer;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.MIDlet;

public class CityKnights extends MIDlet
{

    public Display display;
    public GameCanvas canvas;
    private Timer timer;
    private GameTimer task;

    public CityKnights()
    {
        display = Display.getDisplay(this);
        CreateGameCanvas();
        display.setCurrent(canvas);
    }

    public void CreateGameCanvas()
    {
        canvas = new GameCanvas(this);
        timer = new Timer();
        task = new GameTimer(canvas);
        timer.schedule(task, 0L, 100L);
        String s = LangSettings.getSettings();
        if(s == null)
        {
            String s1 = System.getProperty("microedition.locale");
            if(s1 == null)
            {
                s1 = System.getProperty("x-default-locale");
                if(s1 == null)
                {
                    if(canvas.strtScr.LangLabel[0] != null)
                    {
                        String s2 = canvas.strtScr.LangLabel[0];
                        canvas.strtScr.lang = s2.substring(s2.indexOf(44) + 1, s2.length());
                    } else
                    {
                        System.out.println("No Lang found");
                    }
                } else
                {
                    canvas.strtScr.lang = s1.substring(0, 2);
                }
            } else
            {
                canvas.strtScr.lang = s1.substring(0, 2);
                try
                {
                    Class class2 = getClass();
                    java.io.InputStream inputstream1 = class2.getResourceAsStream("/texts." + canvas.strtScr.lang + ".txt");
                    DataInputStream datainputstream1 = new DataInputStream(inputstream1);
                    byte abyte1[] = new byte[1000];
                    datainputstream1.readFully(abyte1);
                }
                catch(Exception exception1)
                {
                    if(canvas.strtScr.LangLabel[0] != null)
                    {
                        String s4 = canvas.strtScr.LangLabel[0];
                        canvas.strtScr.lang = s4.substring(s4.indexOf(44) + 1, s4.length());
                        System.out.println(s4);
                    } else
                    {
                        System.out.println("No Lang found");
                    }
                }
            }
        } else
        {
            canvas.strtScr.lang = s;
            try
            {
                Class class1 = getClass();
                java.io.InputStream inputstream = class1.getResourceAsStream("/texts." + canvas.strtScr.lang + ".txt");
                DataInputStream datainputstream = new DataInputStream(inputstream);
                byte abyte0[] = new byte[1000];
                datainputstream.readFully(abyte0);
            }
            catch(Exception exception)
            {
                if(canvas.strtScr.LangLabel[0] != null)
                {
                    String s3 = canvas.strtScr.LangLabel[0];
                    canvas.strtScr.lang = s3.substring(s3.indexOf(44) + 1, s3.length());
                    System.out.println(s3);
                } else
                {
                    System.out.println("No Lang found");
                }
            }
        }
        //canvas.strtScr.readDirectory();
    }

    protected void startApp()
    {
    }

    protected void pauseApp()
    {
    }

    protected void destroyApp(boolean flag)
    {
        String s = "";
        String s1 = "";
        if(canvas.game.isSoundOn)
            s = "On";
        else
            s = "Off";
        if(canvas.game.isVibratorOn)
            s1 = "On";
        else
            s1 = "Off";
        String s2 = "Easy*" + s + ":" + s1;
        GameSettings.saveSettings(s2);
        LangSettings.saveSettings(canvas.strtScr.lang);
        System.out.println("destroying");
        canvas.getKeys();
        canvas.setKeys();
        System.gc();
        display.setCurrent(null);
    }

    public void exitMIDlet()
    {
        destroyApp(true);
        notifyDestroyed();
    }

    public void commandAction(Command command, Displayable displayable)
    {
        if(command.getCommandType() == 7)
            destroyApp(true);
    }
}
