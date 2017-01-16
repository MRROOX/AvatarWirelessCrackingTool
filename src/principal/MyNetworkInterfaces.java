package principal;

import avatarwirelesscrackingtool.Shell;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author mrroox
 */
public class MyNetworkInterfaces {

    Shell shell = new Shell();

    public MyNetworkInterfaces() {
    }

    public ArrayList<NetInterfaces> Interfaces() throws IOException {
          ArrayList<NetInterfaces> MyNetInterfaces = new ArrayList<>();

        String cmd0;
        String cmd1;
        String cmd2;
        String cmd3;
        String cmd4;
        String ESSID;
        String BSSID;
        String Mode;
        String Driver;
        String Chipset;
        int i=0;
        do{
            cmd0 = "airmon-ng | grep wlan" + i + " | awk ' { print $2 } '";
            ESSID = shell.ExecuteToString(cmd0);

            cmd1 = "iwconfig " + ESSID + " | tr ' ' '\\n' | grep -i 'Mode:' | tr ':' ' ' | awk '{print $2 }'";
            cmd3 = "airmon-ng | grep " + ESSID + " | awk ' { print $3 } '";
            cmd4 = "airmon-ng | grep " + ESSID + " | awk ' { print $4,$5,$6,$7,$8,$9,$10,$11,$12,$13,$14,$15,$16,$17,$18,$19,$20 } '";
            cmd2 = "ifconfig " + ESSID + "| grep direcciónHW | awk ' { print $5 } ' | tr '-' ':'";

            BSSID = shell.ExecuteToString(cmd2).substring(0, 17).replace('-', ':').toUpperCase();
            Mode = shell.ExecuteToString(cmd1);
            Driver = shell.ExecuteToString(cmd3);
            Chipset = shell.ExecuteToString(cmd4);

            
            MyNetInterfaces.add(new NetInterfaces(ESSID, BSSID, Mode, Driver, Chipset));
            i++;
        }while(!"".equals(ESSID));
        MyNetInterfaces.remove(MyNetInterfaces.size()-1);


        return MyNetInterfaces;
    }

}
