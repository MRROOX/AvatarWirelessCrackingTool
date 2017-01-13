package principal;

public class targetNetwork {

   
private String ESSID;
    private String BSSID;
    private String channel;
    private String Speed;
    private String Privacy;
    private String Cipher;
    private String Authentication;
    private String Power;
    private String Wps;

    public targetNetwork(String ESSID,String BSSID, String channel, String Speed,String Power, String Privacy, String Cipher, String Authentication,  String Wps) {
        setESSID(ESSID);
        setBSSID(BSSID);
        setChannel(channel);
        setSpeed(Speed);
        setPrivacy(Privacy);
        setCipher(Cipher);
        setAuthentication(Authentication);
        setPower(Power);
        setWps(Wps);

    }

    public String getBSSID() {
        return BSSID;
    }

    public void setBSSID(String BSSID) {
        this.BSSID = BSSID;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getSpeed() {
        return Speed;
    }

    public void setSpeed(String Speed) {
        this.Speed = Speed;
    }

    public String getPrivacy() {
        return Privacy;
    }

    public void setPrivacy(String Privacy) {
        this.Privacy = Privacy;
    }

    public String getCipher() {
        return Cipher;
    }

    public void setCipher(String Cipher) {
        this.Cipher = Cipher;
    }

    public String getAuthentication() {
        return Authentication;
    }

    public void setAuthentication(String Authentication) {
        this.Authentication = Authentication;
    }

    public String getPower() {
        return Power;
    }

    public void setPower(String Power) {
        this.Power = Power;
    }

    public String getESSID() {
        return ESSID;
    }

    public void setESSID(String ESSID) {
        this.ESSID = ESSID;
    }
     public String getWps() {
        return Wps;
    }

    public void setWps(String Wps) {
        this.Wps = Wps;
    }

}
