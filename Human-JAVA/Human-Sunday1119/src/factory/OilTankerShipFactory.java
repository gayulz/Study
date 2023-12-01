package factory;

import ship.OilTankerShip;
import ship.Ship;

public class OilTankerShipFactory extends ShipFactory {
    private OilTankerShipFactory(){}
    private static class SingleInstanceHolder{
        private static final OilTankerShipFactory INSTANCE = new OilTankerShipFactory();
    }
    public static OilTankerShipFactory getInstance(){
        return SingleInstanceHolder.INSTANCE;
    }

    @Override
    protected Ship createShip() {
        return new OilTankerShip("OilTankerShip", "15t", "blue");
    }
}
