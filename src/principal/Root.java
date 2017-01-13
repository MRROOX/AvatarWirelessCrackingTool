package avatar.wireless.testing.principal;
import avatar.wireless.testing.Shell;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Root {

    public Root() throws IOException {

    }

    public static void crearArchivo(String clave) {
        try {
            Shell shell = new Shell();

            String dir = "/tmp/.AWTesting/AdminData/rootpasswd.txt";

            String cmd = "echo \"" + clave + "\" > " + dir; // comando para guardar la passwd root dentro del archivo
            shell.ExcSavePasswd(clave, cmd);
        } catch (IOException ex) {
            Logger.getLogger(Root.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
