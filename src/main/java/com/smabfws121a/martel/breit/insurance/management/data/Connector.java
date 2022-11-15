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
        System.out.println(data);

        // map YAML variables to object
        this.jdbcdriver = data.get("DBDRIVER");
        this.dburl = data.get("DBURL");
        this.dbname = data.get("DBNAME");
        this.dbuser = data.get("DBUSER");
        this.dbpass = data.get("DBPASS");
    }

    protected String getJdbcdriver() {
        return this.jdbcdriver;
    }

    protected String getDburl() {
        return this.dburl;
    }

    protected String getDbname() {
        return this.dbname;
    }

    protected String getDbuser() {
        return this.dbuser;
    }

    protected String getDbpass() {
        return this.dbpass;
    }
}
