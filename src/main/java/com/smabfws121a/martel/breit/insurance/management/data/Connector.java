package com.smabfws121a.martel.breit.insurance.management.data;

import org.yaml.snakeyaml.Yaml;
import java.io.*;
import java.util.Map;

// will serve as a negotiater between the frontend and the backend
public class Connector {

    private String jdbcdriver;
    private String dburl;
    private String dbname;
    private String dbuser;
    private String dbpass;

    public Connector() throws FileNotFoundException {

        // read database connection details from YAML file
        InputStream inputStream = new FileInputStream("config" + File.separator + "dbconfig.yaml");
        Yaml yaml = new Yaml();
        Map<String, String> data = yaml.load(inputStream);

        // map YAML variables to object
        this.jdbcdriver = data.get("DBDRIVER");
        this.dburl = data.get("DBURL");
        this.dbname = data.get("DBNAME");
        this.dbuser = data.get("DBUSER");
        this.dbpass = data.get("DBPASS");
    }

    protected String getJDBCdriver() {
        return this.jdbcdriver;
    }

    protected String getDBurl() {
        return this.dburl;
    }

    protected String getDBname() {
        return this.dbname;
    }

    protected String getDBuser() {
        return this.dbuser;
    }

    protected String getDBpass() {
        return this.dbpass;
    }
}
