// Decompiled by DJ v3.9.9.91 Copyright 2005 Atanas Neshkov  Date: 2005-11-26 11:41:54
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 

import javax.microedition.media.Manager;
import javax.microedition.media.Player;
import javax.microedition.media.control.TempoControl;

public class MidPlayer
{

    public MidPlayer()
    {
        try
        {
            java.io.InputStream inputstream = getClass().getResourceAsStream("/bg.mid");
            String s = "audio/midi";
            p1 = Manager.createPlayer(inputstream, s);
            p1.realize();
            TempoControl tempocontrol = (TempoControl)p1.getControl("TempoControl");
            tempocontrol.setTempo(0x1d4c0);
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public void playMid()
    {
        try
        {
            p1.start();
        }
        catch(Exception exception) { }
    }

    public void stopMid()
    {
        try
        {
            p1.stop();
            p1.close();
        }
        catch(Exception exception) { }
    }

    public void setDiffSounds(String s)
    {
        String s1 = "audio/midi";
    }

    public void play(String s)
    {
    }

    public void stop(String s)
    {
    }

    Player p1;
}