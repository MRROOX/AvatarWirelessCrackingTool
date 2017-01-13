package principal;

import avatarwirelesscrackingtool.Shell;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Root {

    public Root() throws IOException {

    }

    public static void crearArchivo(String clave) {
        // comando para guardar la passwd root dentro del archivo
        try {
            Shell shell = new Shell();

            String dir = "/tmp/.AWCTool/AdminData/frodo";

            String cmd = "echo \"" + clave + "\" > " + dir;
            shell.ExcSavePasswd(clave, cmd);
        } catch (IOException ex) {
            Logger.getLogger(Root.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
