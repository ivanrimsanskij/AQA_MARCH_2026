package org.prog.session13;

import io.cucumber.java.en.When;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import static org.prog.session13.Selenium.*;

public class Db {

    @When("I store them to DB")
    public void storeIphonesToDb() throws SQLException {
        List<String> codes = (List<String>) DataManager.DATA.get("iphone_codes");
        List<String> names = (List<String>) DataManager.DATA.get("iphone_names");

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO iphones (Code, name) " +
                "VALUES (?, ?)");

        for (int i = 0; i < codes.size(); i++) {
            System.out.println("Writing to DB: Name = " + names.get(i) + ", Code = " + codes.get(i));
            preparedStatement.setString(1, codes.get(i));
            preparedStatement.setString(2, names.get(i));
            preparedStatement.execute();
        }
        System.out.println("WOW");
    }
}

