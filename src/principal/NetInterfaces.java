
package avatar.wireless.testing.principal;

/**
 *
 * @author mrroox
 */
public class NetInterfaces {

    public String getESSID() {
        return ESSID;
    }

    public void setESSID(String ESSID) {
        this.ESSID = ESSID;
    }

    public String getBSSID() {
        return BSSID;
    }

    public void setBSSID(String BSSID) {
        this.BSSID = BSSID;
    }

    public String getMode() {
        return Mode;
    }

    public void setMode(String Mode) {
        this.Mode = Mode;
    }

    public String getDriver() {
        return Driver;
    }

    public void setDriver(String Driver) {
        this.Driver = Driver;
    }

    public String getChipset() {
        return Chipset;
    }

    public void setChipset(String Chipset) {
        this.Chipset = Chipset;
    }
    private String ESSID;
    private String BSSID;
    private String Mode;
    private String Driver;
    private String Chipset;

    NetInterfaces(String ESSID, String BSSID, String Mode, String Driver, String Chipset) {
        setESSID(ESSID);
        setBSSID(BSSID);
        setMode(Mode);
        setDriver(Driver);
        setChipset(Chipset);

    }

}
