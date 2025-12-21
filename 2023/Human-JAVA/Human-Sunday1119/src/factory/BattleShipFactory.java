package factory;

import ship.BattleShip;
import ship.Ship;

public class BattleShipFactory extends ShipFactory {
    private BattleShipFactory(){}
    private static class SingleInstanceHolder{
        private static final BattleShipFactory INSTANCE = new BattleShipFactory();
    }
    public static BattleShipFactory getInstance(){
        return SingleInstanceHolder.INSTANCE;
    }
    @Override
    protected Ship createShip() {
        return new BattleShip("BattleShip", "10t", "black");
    }
}
