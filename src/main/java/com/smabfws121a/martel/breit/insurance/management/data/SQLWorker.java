package com.smabfws121a.martel.breit.insurance.management.data;

import com.smabfws121a.martel.breit.insurance.management.classes.Benutzer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
//@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class SQLWorker {

    public SQLWorker() {}

    //@Autowired
    private JdbcTemplate jdbcTemplate;
    //Benutzer user = new Benutzer("Max Mustermann", "passwort", "Kunde");

//    public void writeUser(Benutzer user) {
//        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS abc_user(abc_user VARCHAR(100) PRIMARY KEY," +
//                                                                    "abc_password VARCHAR(100)," +
//                                                                    "abc_salt VARCHAR(100)," +
//                                                                    "abc_role VARCHAR(100))");
//        jdbcTemplate.execute("INSERT INTO abc_user(abc_user, abc_password, abc_role) values (" + user.getUsername() + "," +
//                                                                                                user.getPasswort() + "," +
//                                                                                                user.getRole());
//    }


}
