package de.akcards.database;

/**
 * Created by Frath on 30.12.2015.
 */
public class CardCreator {

    private static final String GERMAN_CARDS_PROPERTIES = "couchdb.properties";

    private CouchDBConnector dbConnector;

    public CouchDBConnector getDbConnector() {
        return dbConnector;
    }

    public void setDbConnector(CouchDBConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    public CardCreator() {
        setDbConnector(CouchDBConnector.getInstance());
        getDbConnector().init(GERMAN_CARDS_PROPERTIES);
    }
}
