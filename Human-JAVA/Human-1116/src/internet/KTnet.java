package internet;

public class KTnet implements ispInf {
    public KTnet() {
    }

    int nowConnect = 0;

    @Override
    public void connectInternet() {
        System.out.println("KT internet");
    }

    @Override
    public boolean connectWifi() {
        if (ispInf.Max_Count > nowConnect) {
            System.out.println("KT wifi");
        }
        return false;
    }
}
