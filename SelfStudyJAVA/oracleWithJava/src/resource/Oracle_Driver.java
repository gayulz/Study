package resource;

class Oracle_Driver {
    // local Host Oracle Driver road Class
    // Single Tone
    private Oracle_Driver() {}
    private static Oracle_Driver self = null;

    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Driver Load Success");
        } catch (Exception e) {
            System.out.println("Driver Load Fail");
        }
    }

    public static Oracle_Driver load_Driver(){
        if (self == null) self = new Oracle_Driver();
        return self;
    }
}
