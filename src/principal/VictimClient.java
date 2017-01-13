
package avatar.wireless.testing.principal;

/**
 *
 * @author mrroox
 */
public class VictimClient {

    public String getVictimClient() {
        return VictimClient;
    }

    public void setVictimClient(String VictimClient) {
        this.VictimClient = VictimClient;
    }

    public String getStation() {
        return Station;
    }

    public void setStation(String Station) {
        this.Station = Station;
    }
    public VictimClient(){}

private String VictimClient;
private String Station;
VictimClient(String VictimClient,String Station){
    setVictimClient(VictimClient);
    setStation(Station);
}

}





    

