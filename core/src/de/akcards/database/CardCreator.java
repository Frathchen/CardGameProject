package de.akcards.database;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import de.akcards.utils.CSV_To_JSON;

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
        JsonObject jsonObject = new JsonObject();

        JsonParser parser = new JsonParser();
        JsonObject object = parser.parse(CSV_To_JSON.loadCSV().getWriter().getWriter().toString()).getAsJsonObject();
        getDbConnector().getDbClient().batch(object);

        //getDbConnector().getDbClient().save()
    }
}
