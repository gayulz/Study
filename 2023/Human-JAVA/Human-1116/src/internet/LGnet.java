package internet;

public class LGnet implements ispInf{
    @Override
    public void connectInternet() {
        System.out.println("LG internet");
    }

    @Override
    public boolean connectWifi() {
        System.out.println("LG wifi");
        return false;
    }
}
