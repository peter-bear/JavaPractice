// Decompiled by DJ v3.9.9.91 Copyright 2005 Atanas Neshkov  Date: 2005-11-26 11:42:05
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 

import java.io.*;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;

public class SaveGame
{

    private SaveGame()
    {
    }

    private static void initialize()
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        DataOutputStream dataoutputstream = new DataOutputStream(bytearrayoutputstream);
        try
        {
            byte abyte0[];
            try
            {
                dataoutputstream.writeUTF("");
                abyte0 = bytearrayoutputstream.toByteArray();
                dataoutputstream.close();
            }
            catch(IOException ioexception)
            {
                System.out.println(ioexception);
                throw new RecordStoreException();
            }
            myGame.addRecord(abyte0, 0, abyte0.length);
        }
        catch(RecordStoreException recordstoreexception)
        {
            close();
            System.out.println(recordstoreexception);
        }
    }

    static void open()
    {
        try
        {
            myGame = RecordStore.openRecordStore("SavedGame", true);
            if(gameHaveBeenInit)
                return;
            if(myGame.getNumRecords() == 0)
            {
                initialize();
            } else
            {
                byte abyte0[] = myGame.getRecord(1);
                if(abyte0 != null)
                    try
                    {
                        ByteArrayInputStream bytearrayinputstream = new ByteArrayInputStream(abyte0);
                        DataInputStream datainputstream = new DataInputStream(bytearrayinputstream);
                        gameData = datainputstream.readUTF();
                        datainputstream.close();
                        if(gameData.equals(""))
                        {
                            gameData = "";
                            saveGame(gameData);
                        }
                    }
                    catch(IOException ioexception) { }
            }
            gameHaveBeenInit = true;
        }
        catch(RecordStoreException recordstoreexception)
        {
            System.out.println(recordstoreexception);
        }
    }

    static void close()
    {
        if(myGame != null)
        {
            try
            {
                myGame.closeRecordStore();
            }
            catch(RecordStoreException recordstoreexception) { }
            myGame = null;
        }
    }

    static void saveGame(String s)
    {
        try
        {
            byte abyte0[];
            try
            {
                ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
                DataOutputStream dataoutputstream = new DataOutputStream(bytearrayoutputstream);
                dataoutputstream.writeUTF(s);
                abyte0 = bytearrayoutputstream.toByteArray();
                dataoutputstream.close();
            }
            catch(IOException ioexception)
            {
                throw new RecordStoreException();
            }
            if(myGame == null)
            {
                open();
                myGame.setRecord(1, abyte0, 0, abyte0.length);
                close();
            } else
            {
                myGame.setRecord(1, abyte0, 0, abyte0.length);
            }
        }
        catch(RecordStoreException recordstoreexception) { }
        gameData = s;
    }

    static String getGameData()
    {
        if(!gameHaveBeenInit)
        {
            open();
            close();
        }
        return gameData;
    }

    static RecordStore myGame;
    static boolean gameHaveBeenInit = false;
    static String gameData;

}