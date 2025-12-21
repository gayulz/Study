package internet;

public class SKnet implements ispInf{

    int nowConnect = 0;

    @Override
    public void connectInternet() {
        System.out.println("SK internet");
    }

    @Override
    public boolean connectWifi() {
        if (ispInf.Max_Count > nowConnect) System.out.println("SK wifi");
        return false;
    }
}
