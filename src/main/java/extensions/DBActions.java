package extensions;

import io.qameta.allure.Step;
import utilities.CommonOps;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBActions extends CommonOps {
    @Step("Det Credentials From Database")
    public static List<String> getCredentials(String query){
        List<String> credentials = new ArrayList<>();
        try {
            rs = stmt.executeQuery(query);
            rs.next();
            credentials.add(rs.getString(1));
            credentials.add(rs.getString(2));
        } catch (Exception e) {
            System.out.println("Error Occurred while printing table data , See Details:" + e);
        }

        return credentials;
    }
}
