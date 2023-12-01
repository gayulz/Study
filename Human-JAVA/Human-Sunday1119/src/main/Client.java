package main;
import factory.BattleShipFactory;
import factory.ContainerShipFactory;
import factory.OilTankerShipFactory;
import ship.Ship;

public class Client {
    public static void main(String[] args) throws IllegalAccessException {
        Ship containerShip = ContainerShipFactory.getInstance().orderShip("gayul@kakao.com");
        System.out.println(containerShip);

        Ship oilTankership = OilTankerShipFactory.getInstance().orderShip("gayulz@kakao.com");
        System.out.println(oilTankership);

        Ship battleShip = BattleShipFactory.getInstance().orderShip("yaho@naver.com");
        System.out.println(battleShip );
    }
}
