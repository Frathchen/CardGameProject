package de.akcards.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonWriter;

import java.io.*;


/**
 * Created by Frath on 30.12.2015.
 */
public class CSV_To_JSON {

    private static final String DEFAULT_CSV_FILENAME = "AK_Charaktere.csv";
    private static final String CSV_SEPARATOR = ",";
    private static final String INNERFIELD_SEPARATOR = "#";
    private static final String AND_SEPARATOR = "&";
    private static final String OR_SEPARATOR = "|";



    public static Json loadCSV(String fileName) {
        if ((fileName == null) || (fileName.isEmpty())) {
            fileName = DEFAULT_CSV_FILENAME;
        }

        FileHandle csvHandle = Gdx.files.internal(fileName);

        if (csvHandle.exists()) {
            InputStream fileStream = csvHandle.read();
            InputStreamReader isr = new InputStreamReader(fileStream);
            BufferedReader br = new BufferedReader(isr);
            String line;
            Json json = new Json();
            String[] headerFields;

            try {
                String header;
                /*Name,S,V,Ang,I,M,Aus,H,Typ,Tempo,Koop,Kooppartei,Effektart,Trigger,Aktion*/

                header = br.readLine();
                headerFields = header.split(CSV_SEPARATOR);
                String[] fields;
                String[] innerFields;
                JsonWriter writer = new JsonWriter(new StringWriter());
                json.setWriter(writer);
                json.writeArrayStart();
                while((line = br.readLine()) != null){
                    fields = line.split(CSV_SEPARATOR);
                    json.writeObjectStart();
                    for (int i = 0; i < fields.length; i++) {
                        if (fields[i].contains(INNERFIELD_SEPARATOR)) {
                            innerFields = fields[i].split(INNERFIELD_SEPARATOR);
                            json.writeArrayStart(headerFields[i]);
                            for (int j = 0; j < innerFields.length; j++) {
                                json.writeValue(innerFields[j]);
                            }
                            json.writeArrayEnd();
                        }
                        else {
                            json.writeValue(headerFields[i], fields[i]);
                        }
                    }
                    json.writeObjectEnd();
                }
                json.writeArrayEnd();
                return json;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
