// Decompiled by DJ v3.9.9.91 Copyright 2005 Atanas Neshkov  Date: 2005-11-26 11:41:29
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 

import java.util.TimerTask;

class GameTimer extends TimerTask
{

    public GameTimer(GameCanvas gamecanvas)
    {
        canvas = gamecanvas;
    }

    public final void run()
    {
        canvas.repaint();
    }

    private GameCanvas canvas;
}