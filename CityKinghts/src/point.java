// Decompiled by DJ v3.9.9.91 Copyright 2005 Atanas Neshkov  Date: 2005-11-26 11:41:59
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 


class point
{

    point(short word0, short word1)
    {
        occupy = false;
        x = word0;
        y = word1;
    }

    short x;
    short y;
    boolean occupy;
}