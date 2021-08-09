package workflows;

import extensions.APIActions;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utilities.CommonOps;

public class APIFlows extends CommonOps {
    //Get location
    @Step("Business Flow : Get Team Property")
    public static String getTeamProperty(String JPath){
        response = APIActions.get("/api/teams/search");
        return  APIActions.extractFromJSON(response,JPath);
    }

    @Step("Business Flow : New Team in Grafana")
    public static void postTeam(String name,String email){
        params.put("name",name);
        params.put("email",email);
        APIActions.post(params,"/api/teams");
    }

    @Step("Business Flow : Update Existing Team  in Grafana")
    public static void updateTeam(String name,String email,String id){
        params.put("name",name);
        params.put("email",email);
        APIActions.put(params,"/api/teams/" + id);
    }

    @Step("Business Flow : Delete Existing Team  in Grafana")
    public static void deleteTeam(String id){
        APIActions.delete(id);
    }
}
