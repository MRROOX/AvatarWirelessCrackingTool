package principal;

import avatarwirelesscrackingtool.Shell;
import com.csvreader.CsvReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ColeccionTargetNetwork {
    private final String directorioTemporal="/tmp/.AWCTool/AircrackTemp/";
    ///tmp/.AWTesting/AircrackTemporal/
   private Shell shell = new Shell();

    public ColeccionTargetNetwork() {

    }

    public ArrayList<targetNetwork> scanTargets(String monInterface, String time, String channel) throws IOException {
        ArrayList<targetNetwork> TargetNet = new ArrayList<>();

        String command = "";
        String cmd = "";
        //Comando de busqueda Personalizado de airodump-ng

        if ("ALL".equals(channel)) {
            //Comando de busqueda standar.
            command = "timeout " + time + " airodump-ng --output-format csv --write "+directorioTemporal+"AWCTool-scan " + monInterface;
            cmd = "gnome-terminal -e '" + command+"'" ;
        } else {
            //comando de busqueda con un canal especifico.
            command = "timeout " + time + " airodump-ng --output-format csv --write "+directorioTemporal+"AWCTool-scan  --channel " + channel + "  " + monInterface ;
            cmd = "gnome-terminal -e '" + command+"'" ;
        }
        shell.ExecuteCommandString(cmd);

        try {
            long l = Long.parseLong(time + "000");
            //sleep 10 seconds
            Thread.sleep(l);

            TargetNet = OrdenarTargetNetwork();

        } catch (InterruptedException e) {
        }

        return TargetNet;
    }

    private ArrayList<targetNetwork> OrdenarTargetNetwork() {
        ArrayList<targetNetwork> TargetNet = new ArrayList<>();
        String dirArchivo = directorioTemporal+"AWTesting-scan-01.csv";
        String BSSID;
        String channel;
        String Speed;
        String Privacy;
        String Cipher;
        String Authentication;
        String Power;
        String ESSID;
        String Wps;//no se registran valores wps

        try {
            ArrayList<targetNetwork> TN = new ArrayList<>();

            CsvReader targetNetwork_import = new CsvReader(dirArchivo);
            targetNetwork_import.readHeaders();

            do {
                BSSID = targetNetwork_import.get("BSSID");
                channel = targetNetwork_import.get("channel");
                Speed = targetNetwork_import.get("Speed");
                Privacy = targetNetwork_import.get("Privacy");
                Cipher = targetNetwork_import.get("Cipher");
                Authentication = targetNetwork_import.get("Authentication");
                Power = targetNetwork_import.get("Power");
                ESSID = targetNetwork_import.get("ESSID");
                Wps = null;//no se registran valores wps

                TN.add(new targetNetwork(ESSID, BSSID, channel, Speed, Power, Privacy, Cipher, Authentication, Wps));

                TargetNet = TN;

            } while (targetNetwork_import.readRecord() && !"Station MAC".equals(BSSID));

            targetNetwork_import.close();
            removerArchTEMP();

        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
        TargetNet.remove(TargetNet.size() - 1);
        TargetNet.remove(0);
        return TargetNet;

    }

    public ArrayList<VictimClient> OrdenarVictimClienMac() {

        ArrayList<VictimClient> VictimClient = new ArrayList<>();
        String Directory = directorioTemporal+"sniff_dump-01.csv";
        String VictimC;
        String Station;

        try {
            ArrayList<VictimClient> VC = new ArrayList<>();

            CsvReader targetNetwork_import = new CsvReader(Directory);
            targetNetwork_import.readHeaders();

            do {
                VictimC = targetNetwork_import.get("BSSID");
                Station = targetNetwork_import.get("Privacy");

                VC.add(new VictimClient(VictimC, Station));

                VictimClient = VC;

            } while (targetNetwork_import.readRecord());

            targetNetwork_import.close();

        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
        for (int j = 0; j < 3; j++) {
            VictimClient.remove(0);
        }
        return VictimClient;
    }

    public ArrayList<WpsTargetNetwork> scanWPS(String time, String monitor) throws IOException {
        ArrayList<WpsTargetNetwork> TargetNet = new ArrayList<>();
        String cmd[] = new String[4];
        String cmd0 = "";
        String command = "";
        String directorio0 = directorioTemporal+"wash-scan.csv";
        String directorio1 = directorioTemporal+"wash-scan.txt";
        cmd0 = "airmon-ng " + directorio0;
        shell.ExecuteCommandString(cmd0);
        command = "timeout " + time + " wash -i " + monitor + " -C -o " + directorio1;
        String cmd1 = "gnome-terminal -e '"+command+"'";
        shell.ExecuteCommandString(cmd1);

        try {
            long l = Long.parseLong(time + "000");
            //sleep 10 seconds
            Thread.sleep(l);
            cmd[0] = "cp " + directorio1 + " " + directorio0;
            cmd[1] = "sed 's/[[:space:]] \\+/,/g' " + directorio0 + " > " + directorio0;
            cmd[2] = "rm " + directorio1;
            cmd[3] = "sed 's/ //g' " + directorio0 + "> " + directorio0;

            shell.ExecuteCommand(cmd);

            TargetNet = OrdenarTargetWPS();
            rmWashTemp();

        } catch (InterruptedException e) {
        }

        return TargetNet;

    }

    private ArrayList<WpsTargetNetwork> OrdenarTargetWPS() {

        ArrayList<WpsTargetNetwork> TNWPS = new ArrayList<>();
        //String directorio = "/tmp/.AWTesting/AircrackTemporal";
        String BSSID;
        String Channel;
        String WPSLocked;
        String RSSI;
        String WPSVersion;
        String ESSID;

        try {

            CsvReader targetNetwork_import = new CsvReader(directorioTemporal+"wash-scan.csv");
            targetNetwork_import.readHeaders();

            while (targetNetwork_import.readRecord()) {

                BSSID = targetNetwork_import.get("BSSID");
                Channel = targetNetwork_import.get("Channel");
                WPSLocked = targetNetwork_import.get("WPSLocked");
                WPSVersion = targetNetwork_import.get("WPSVersion");
                RSSI = targetNetwork_import.get("RSSI");
                ESSID = targetNetwork_import.get("ESSID");

                TNWPS.add(new WpsTargetNetwork(ESSID, BSSID, Channel, RSSI, WPSLocked, WPSVersion));

            }
            targetNetwork_import.close();

        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }

        return TNWPS;

    }

    private void removerArchTEMP() throws IOException {
        //String directorio = "/tmp/.AWTesting/AircrackTemporal/";
        String cmd = "rm "+directorioTemporal+"AWTesting-scan-0*";
        shell.ExecuteCommandString(cmd);

    }

    private void rmWashTemp() throws IOException {

        //String directorio = "/tmp/.AWTesting/AircrackTemporal/";
        String cmd = "rm "+directorioTemporal+"wash-scan*.csv";
        shell.ExecuteCommandString(cmd);

    }

}
