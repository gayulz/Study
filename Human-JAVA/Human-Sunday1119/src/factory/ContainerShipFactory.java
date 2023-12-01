package factory;

import ship.ContainerShip;
import ship.Ship;

public class ContainerShipFactory extends ShipFactory{
    private ContainerShipFactory(){}
    private static class SingleInstanceHolder{
        private static final ContainerShipFactory INSTANCE = new ContainerShipFactory();
    }
    public static ContainerShipFactory getInstance(){
        return SingleInstanceHolder.INSTANCE;
    }

    @Override
    protected Ship createShip() {
        return new ContainerShip("ContainerShip", "20t", "green");
    }
}
