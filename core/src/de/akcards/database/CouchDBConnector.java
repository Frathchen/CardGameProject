package de.akcards.database;

import org.lightcouch.CouchDbClient;

/**
 * Created by Frath on 30.12.2015.
 */
public class CouchDBConnector {

    private static final String DEFAULT_PROPERTIES = "couchdb.properties";
    private static final CouchDBConnector DB_CONNECTOR = new CouchDBConnector();
    private CouchDbClient dbClient;

    public CouchDbClient getDbClient() {
        return dbClient;
    }

    public void setDbClient(CouchDbClient dbClient) {
        this.dbClient = dbClient;
    }

    private CouchDBConnector() {}

    public static CouchDBConnector getInstance() {
        return DB_CONNECTOR;
    }

    public void init(String propertiesFile) {
        if (propertiesFile == null || propertiesFile.isEmpty()) {
            setDbClient(new CouchDbClient(DEFAULT_PROPERTIES));
        } else {
            setDbClient(new CouchDbClient(propertiesFile));
        }
    }

    public void cleanUp() {
        getDbClient().shutdown();
    }



}
