// Decompiled by DJ v3.9.9.91 Copyright 2005 Atanas Neshkov  Date: 2005-11-26 11:41:41
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 

import java.io.*;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;

public class keySettings
{

    private keySettings()
    {
    }

    static void initialize()
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        DataOutputStream dataoutputstream = new DataOutputStream(bytearrayoutputstream);
        try
        {
            byte abyte0[];
            try
            {
                dataoutputstream.writeShort(0);
                abyte0 = bytearrayoutputstream.toByteArray();
                dataoutputstream.close();
            }
            catch(IOException ioexception)
            {
                throw new RecordStoreException();
            }
            for(int i = 0; i < 9; i++)
                myStore.addRecord(abyte0, 0, abyte0.length);

        }
        catch(Exception exception)
        {
            closeKeySettings();
        }
    }

    static void openKeySettings()
    {
        try
        {
            myStore = RecordStore.openRecordStore("IlluminatorKeySettings", true);
            if(keySettingsHaveBeenInit)
                return;
            if(myStore.getNumRecords() == 0)
            {
                initialize();
            } else
            {
                for(int i = 0; i < 9; i++)
                {
                    byte abyte0[] = myStore.getRecord(i + 1);
                    if(abyte0 != null)
                        try
                        {
                            ByteArrayInputStream bytearrayinputstream = new ByteArrayInputStream(abyte0);
                            DataInputStream datainputstream = new DataInputStream(bytearrayinputstream);
                            keyCodes[i] = datainputstream.readShort();
                            actions[i] = datainputstream.readUTF();
                            datainputstream.close();
                        }
                        catch(IOException ioexception) { }
                }

            }
            keySettingsHaveBeenInit = true;
        }
        catch(RecordStoreException recordstoreexception) { }
    }

    static void closeKeySettings()
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

    static void setKeySettings(String s, int i)
    {
        int j = 0;
        int k = 0;
        boolean flag = false;
        for(int l = 0; l < 9; l++)
        {
            if(!s.equals(actions[l]))
                continue;
            if(keyCodes[l] != i)
                flag = true;
            j = l;
            break;
        }

        for(int i1 = 0; i1 < 9; i1++)
        {
            if(i1 == j || keyCodes[i1] != i || i == 0 || !flag)
                continue;
            keyCodes[i1] = 0;
            k = i1;
            break;
        }

        try
        {
            byte abyte0[];
            try
            {
                ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
                DataOutputStream dataoutputstream = new DataOutputStream(bytearrayoutputstream);
                dataoutputstream.writeShort(0);
                abyte0 = bytearrayoutputstream.toByteArray();
                dataoutputstream.close();
            }
            catch(IOException ioexception)
            {
                System.out.println("1---" + ioexception);
                throw new RecordStoreException();
            }
            if(myStore == null)
            {
                openKeySettings();
                myStore.setRecord(k + 1, abyte0, 0, abyte0.length);
                closeKeySettings();
            } else
            {
                myStore.setRecord(k + 1, abyte0, 0, abyte0.length);
            }
        }
        catch(RecordStoreException recordstoreexception)
        {
            System.out.println("2-r--" + recordstoreexception + "*");
        }
        if(flag)
            flag = false;
        try
        {
            byte abyte1[];
            try
            {
                ByteArrayOutputStream bytearrayoutputstream1 = new ByteArrayOutputStream();
                DataOutputStream dataoutputstream1 = new DataOutputStream(bytearrayoutputstream1);
                dataoutputstream1.writeShort((short)i);
                abyte1 = bytearrayoutputstream1.toByteArray();
                dataoutputstream1.close();
            }
            catch(IOException ioexception1)
            {
                System.out.println("1---" + ioexception1);
                throw new RecordStoreException();
            }
            if(myStore == null)
            {
                openKeySettings();
                myStore.setRecord(j + 1, abyte1, 0, abyte1.length);
                closeKeySettings();
            } else
            {
                myStore.setRecord(j + 1, abyte1, 0, abyte1.length);
            }
        }
        catch(RecordStoreException recordstoreexception1)
        {
            System.out.println("2-p-" + recordstoreexception1 + "*");
        }
        keyCodes[j] = (short)i;
    }

    static int getSettings(String s)
    {
        int i = 0;
        try
        {
            for(int j = 0; j < 9; j++)
            {
                if(!s.equals(actions[j]))
                    continue;
                i = j;
                break;
            }

            if(!keySettingsHaveBeenInit)
            {
                openKeySettings();
                closeKeySettings();
            }
        }
        catch(Exception exception)
        {
            System.out.println(exception);
        }
        return keyCodes[i];
    }

    public static int keyCodes[] = {
        -100, 2, 5, 8, 1, 6, 57, 49, 55
    };
    private static String actions[] = {
        "keyPause", "keyLeft", "keyRight", "keyFire", "keyUp", "keyDown", "keyWeapon", "keyKick", "keyBlock"
    };
    private static RecordStore myStore;
    private static boolean keySettingsHaveBeenInit;

}