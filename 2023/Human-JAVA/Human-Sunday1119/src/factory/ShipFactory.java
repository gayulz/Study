package factory;
import ship.Ship;

public abstract class ShipFactory {
    public final Ship orderShip(String email) throws IllegalAccessException {
        validate(email);
        Ship ship = createShip();
        sendEmailTo(email, ship);
        return ship;
    }

    abstract protected Ship createShip();

    private void validate(String email) throws IllegalAccessException {
        if (email == null) throw new IllegalAccessException("이메일을 남겨주세요");
    }

    private void sendEmailTo(String email, Ship ship){
        System.out.println(ship.name + "다 만들었다고 " + email + "로 메일을 보냈습니다");
    }
}
