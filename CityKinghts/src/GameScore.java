// Decompiled by DJ v3.9.9.91 Copyright 2005 Atanas Neshkov  Date: 2005-11-26 11:41:18
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 

import java.io.*;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;

public class GameScore
{

    private GameScore()
    {
    }

    private static void initializeScores()
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        DataOutputStream dataoutputstream = new DataOutputStream(bytearrayoutputstream);
        try
        {
            byte abyte0[];
            try
            {
                dataoutputstream.writeInt(0);
                dataoutputstream.writeUTF("XXX");
                abyte0 = bytearrayoutputstream.toByteArray();
                dataoutputstream.close();
            }
            catch(IOException ioexception)
            {
                throw new RecordStoreException();
            }
            for(int i = 0; i < 10; i++)
                myStore.addRecord(abyte0, 0, abyte0.length);

            System.out.println("here is the initialization");
        }
        catch(RecordStoreException recordstoreexception)
        {
            closeHighScores();
        }
    }

    static void openHighScores()
    {
        try
        {
            myStore = RecordStore.openRecordStore("IlluminatorHighScores", true);
            if(highScoresHaveBeenInit)
                return;
            if(myStore.getNumRecords() == 0)
            {
                initializeScores();
            } else
            {
                for(int i = 0; i < 10; i++)
                {
                    byte abyte0[] = myStore.getRecord(i + 1);
                    if(abyte0 != null)
                        try
                        {
                            ByteArrayInputStream bytearrayinputstream = new ByteArrayInputStream(abyte0);
                            DataInputStream datainputstream = new DataInputStream(bytearrayinputstream);
                            highScore[i] = datainputstream.readInt();
                            highScoreName[i] = datainputstream.readUTF();
                            datainputstream.close();
                        }
                        catch(IOException ioexception) { }
                }

            }
            highScoresHaveBeenInit = true;
        }
        catch(RecordStoreException recordstoreexception) { }
    }

    static void closeHighScores()
    {
        if(myStore != null)
        {
            try
            {
                myStore.closeRecordStore();
            }
            catch(RecordStoreException recordstoreexception) { }
            myStore = null;
        }
    }

    static boolean compareScore(int i)
    {
        try
        {
            for(int j = 0; j < 10; j++)
                if(i >= highScore[j])
                    return true;

        }
        catch(Exception exception)
        {
            System.out.println("ihejrhewjrh  " + exception);
        }
        return false;
    }

    static void setHighScore(int i, String s)
    {
        int j = i;
        String s1 = s;
        int k = -1;
        boolean flag = false;
        for(byte byte0 = 0; byte0 < 10; byte0++)
        {
            if(highScore[byte0] != 0)
                continue;
            k = byte0;
            break;
        }

        if(k == -1)
        {
            highScore[9] = (short)i;
            highScoreName[9] = s;
            k = 9;
        } else
        {
            highScore[k] = (short)i;
            highScoreName[k] = s;
        }
        if(k != 0)
        {
            for(byte byte1 = 0; byte1 <= k - 1; byte1++)
            {
                String s2 = "";
                boolean flag1 = false;
                for(byte byte3 = (byte)(byte1 + 1); byte3 <= k; byte3++)
                    if(highScore[byte1] < highScore[byte3])
                    {
                        String s3 = highScoreName[byte1];
                        int l = highScore[byte1];
                        highScore[byte1] = highScore[byte3];
                        highScoreName[byte1] = highScoreName[byte3];
                        highScore[byte3] = l;
                        highScoreName[byte3] = s3;
                    }

            }

        }
        for(byte byte2 = 0; byte2 < 10; byte2++)
            try
            {
                if(myStore == null)
                    openHighScores();
                try
                {
                    ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
                    DataOutputStream dataoutputstream = new DataOutputStream(bytearrayoutputstream);
                    dataoutputstream.writeInt(highScore[byte2]);
                    if(highScore[byte2] == 0 && highScoreName[byte2] == null)
                        dataoutputstream.writeUTF("XXX");
                    else
                        dataoutputstream.writeUTF(highScoreName[byte2]);
                    byte abyte0[] = bytearrayoutputstream.toByteArray();
                    dataoutputstream.close();
                    if(myStore == null)
                    {
                        openHighScores();
                        myStore.setRecord(byte2 + 1, abyte0, 0, abyte0.length);
                        closeHighScores();
                    } else
                    {
                        myStore.setRecord(byte2 + 1, abyte0, 0, abyte0.length);
                        closeHighScores();
                    }
                }
                catch(IOException ioexception)
                {
                    System.out.println("pkc 1---" + ioexception);
                    throw new RecordStoreException();
                }
            }
            catch(RecordStoreException recordstoreexception)
            {
                System.out.println("pkc 2---" + recordstoreexception);
            }

        closeHighScores();
    }

    static int getHighScore(int i)
    {
        if(!highScoresHaveBeenInit)
        {
            openHighScores();
            closeHighScores();
        }
        return highScore[i];
    }

    static String getHighScoreName(int i)
    {
        if(!highScoresHaveBeenInit)
        {
            openHighScores();
            closeHighScores();
        }
        if(highScoreName[i] == null)
            highScoreName[i] = "XXX";
        return highScoreName[i];
    }

    private static int highScore[] = new int[11];
    private static String highScoreName[] = new String[11];
    private static RecordStore myStore;
    private static boolean highScoresHaveBeenInit;

}