// Decompiled by DJ v3.9.9.91 Copyright 2005 Atanas Neshkov  Date: 2005-11-26 11:41:24
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 

import java.io.*;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;

public class GameSettings
{

    private GameSettings()
    {
    }

    private static void initializeSettings()
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        DataOutputStream dataoutputstream = new DataOutputStream(bytearrayoutputstream);
        try
        {
            byte abyte0[];
            try
            {
                dataoutputstream.writeUTF("Easy*On:On");
                abyte0 = bytearrayoutputstream.toByteArray();
                dataoutputstream.close();
            }
            catch(IOException ioexception)
            {
                System.out.println(ioexception);
                throw new RecordStoreException();
            }
            mySettings.addRecord(abyte0, 0, abyte0.length);
        }
        catch(RecordStoreException recordstoreexception)
        {
            closeSettings();
            System.out.println(recordstoreexception);
        }
    }

    static void openSettings()
    {
        try
        {
            mySettings = RecordStore.openRecordStore("GameSettings", true);
            if(settingsHaveBeenInit)
                return;
            if(mySettings.getNumRecords() == 0)
            {
                initializeSettings();
            } else
            {
                byte abyte0[] = mySettings.getRecord(1);
                if(abyte0 != null)
                    try
                    {
                        ByteArrayInputStream bytearrayinputstream = new ByteArrayInputStream(abyte0);
                        DataInputStream datainputstream = new DataInputStream(bytearrayinputstream);
                        settings = datainputstream.readUTF();
                        datainputstream.close();
                        if(settings.equals(""))
                        {
                            settings = "Easy*On:On";
                            saveSettings(settings);
                        }
                    }
                    catch(IOException ioexception) { }
            }
            settingsHaveBeenInit = true;
        }
        catch(RecordStoreException recordstoreexception)
        {
            System.out.println(recordstoreexception);
        }
    }

    static void closeSettings()
    {
        if(mySettings != null)
        {
            try
            {
                mySettings.closeRecordStore();
            }
            catch(RecordStoreException recordstoreexception) { }
            mySettings = null;
        }
    }

    static void saveSettings(String s)
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
            if(mySettings == null)
            {
                openSettings();
                mySettings.setRecord(1, abyte0, 0, abyte0.length);
                closeSettings();
            } else
            {
                mySettings.setRecord(1, abyte0, 0, abyte0.length);
            }
        }
        catch(RecordStoreException recordstoreexception) { }
        settings = s;
    }

    static String getSettings()
    {
        if(!settingsHaveBeenInit)
        {
            openSettings();
            closeSettings();
        }
        return settings;
    }

    static RecordStore mySettings;
    static boolean settingsHaveBeenInit = false;
    static String settings;

}