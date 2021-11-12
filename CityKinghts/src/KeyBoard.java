// Decompiled by DJ v3.9.9.91 Copyright 2005 Atanas Neshkov  Date: 2005-11-26 11:41:35
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 


public class KeyBoard
{

    public KeyBoard()
    {
        key = "right";
    }

    static boolean press(String s)
    {
        if(s.equals("right"))
        {
            posX += 16;
            if(posX >= 154)
                posX = 154;
        } else
        if(s.equals("left"))
        {
            posX -= 16;
            if(posX <= 10)
                posX = 10;
        } else
        if(s.equals("up"))
        {
            posY -= 16;
            if(posY <= 103)
                posY = 103;
        } else
        if(s.equals("down"))
        {
            posY += 16;
            if(posY >= 135)
                posY = 135;
        } else
        if(s.equals("select"))
        {
            String s1 = selectedKey();
            if(s1.equals("Enter"))
                return true;
            if(s1.equals("_"))
            {
                if(name.length() > 0)
                    name = name.substring(0, name.length() - 1);
            } else
            if(name.length() < 10)
                name = name + s1;
        }
        return false;
    }

    static String selectedKey()
    {
        int i = 10;
        int j = 103;
        for(int k = 0; k < 3; k++)
        {
            for(int l = 0; l < 10; l++)
            {
                gridX[k][l] = i;
                gridY[k][l] = j;
                i += 16;
            }

            i = 10;
            j += 16;
        }

        int i1 = 0;
        int j1 = 0;
        for(int k1 = 0; k1 < 3; k1++)
        {
            for(int l1 = 0; l1 < 10; l1++)
                if(posX == gridX[k1][l1] && posY == gridY[k1][l1])
                {
                    i1 = k1;
                    j1 = l1;
                }

        }

        String s = chars[i1][j1];
        return s;
    }

    static String name = "";
    String key;
    static int gridX[][] = new int[3][10];
    static int gridY[][] = new int[3][10];
    static String chars[][] = {
        {
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j"
        }, {
            "k", "l", "m", "n", "o", "p", "q", "r", "s", "t"
        }, {
            "u", "v", "w", "x", "y", "z", "@", ".", "_", "Enter"
        }
    };
    static int posX = 10;
    static int posY = 103;

}