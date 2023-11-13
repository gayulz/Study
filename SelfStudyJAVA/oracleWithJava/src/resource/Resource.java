package resource;

import java.sql.Connection;

public enum Resource {
    DB_DRIVER, CONNECTION, CLOSE_ALL;

    private Resource_Close_ALL resourceCloseAll = null;
    private Oracle_Driver oracleDriver = null;
    private Connection oracleConnection = null;

    Resource() {
        this.oracleDriver = Oracle_Driver.load_Driver();
        this.oracleConnection = Oracle_Connection.getConnection();
        this.resourceCloseAll = Resource_Close_ALL.getCloseAll();
    }

    public static Oracle_Driver DB_DRIVER() { return Oracle_Driver.load_Driver(); }
    public static Connection CONNECTION() { return Oracle_Connection.getConnection(); }
    public static Resource_Close_ALL CLOSE_ALL() { return Resource_Close_ALL.getCloseAll(); }
}
