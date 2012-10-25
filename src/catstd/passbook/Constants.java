package catstd.passbook;

import catstd.passbook.dao.DaoFactory;

public class Constants {
    
    public static final String EXTRA_USER = "catstd.passbook.user";
    
    private static DaoFactory factory;
    
    public static DaoFactory getFactory() {
        return factory;
    }
    
    public static void setFactory(DaoFactory instance) {
        factory = instance;
    }
    
}
