
package avatar.wireless.testing.principal;

/**
 *
 * @author mrroox
 */
public class WpsTargetNetwork {

    public String getBSSID() {
        return BSSID;
    }

    public void setBSSID(String BSSID) {
        this.BSSID = BSSID;
    }

    public String getChannel() {
        return Channel;
    }

    public void setChannel(String Channel) {
        this.Channel = Channel;
    }

    public String getWPSLocked() {
        return WPSLocked;
    }

    public void setWPSLocked(String WPSLocked) {
        this.WPSLocked = WPSLocked;
    }

    public String getRSSI() {
        return RSSI;
    }

    public void setRSSI(String RSSI) {
        this.RSSI = RSSI;
    }

    public String getWPSVersion() {
        return WPSVersion;
    }

    public void setWPSVersion(String WPSVersion) {
        this.WPSVersion = WPSVersion;
    }

    public String getESSID() {
        return ESSID;
    }

    public void setESSID(String ESSID) {
        this.ESSID = ESSID;
    }
private String ESSID = "";
    private String BSSID = "";
    private String Channel = "";
    private String WPSLocked = "";
    private String RSSI = "";
    private String WPSVersion = "";
    

    WpsTargetNetwork(String ESSID,String BSSID,String Channel, String RSSI,String WPSLocked,String WPSVersion ) {
setESSID(ESSID);
setBSSID(BSSID);
setChannel(Channel);
setWPSLocked(WPSLocked);
setRSSI(RSSI);
setWPSVersion(WPSVersion);
        
    }

}
