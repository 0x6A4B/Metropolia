package datasource;

import jakarta.persistence.*;
import org.hibernate.service.spi.ServiceException;

public class MariaDbJpaConnection {

    private static EntityManagerFactory eMFactory = null;
    private static EntityManager eManager = null;

    public static EntityManager getInstance() throws ServiceException {
        if (eManager == null) {
            if (eMFactory == null)
                eMFactory = Persistence.createEntityManagerFactory("CurrencyMariaDbUnit");
            eManager = eMFactory.createEntityManager();
        }

        return eManager;
    }
}
