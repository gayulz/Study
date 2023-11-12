package resource;

import java.sql.Connection;

public enum Resource {

    CLOSE_ALL(Resource_Close_ALL.getCloseAll()),
    DB_DRIVER(Oracle_Driver.load_Driver()),
    CONNECTION(Oracle_Connection.getConnection());


    }
}
