package sanity;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.Verifications;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.util.Timeout;
import org.apache.http.params.CoreConnectionPNames;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.APIFlows;

import java.util.concurrent.TimeUnit;

public class GrafanaAPI extends CommonOps {
    @Test(description = "Test 01:Get Team From Grafana")
    @Description ("This Test Verify Team Property ")
    public void test01_verifyTeam(){
        Verifications.VerifyText(APIFlows.getTeamProperty("teams[0].name"),"kuku");
    }

    @Test(description = "Test 02:add Team And verify")
    @Description ("This Test Adds a Team to Grafana and Verify it")
    public void test02_addTeamAndVerify(){
        APIFlows.postTeam("AvivitTeam","Avivit@team.com");
        Verifications.VerifyText(APIFlows.getTeamProperty("teams[1].name"),"AvivitTeam");


    }

    @Test(description = "Test 03:Update  Team And verify")
    @Description ("This Test Updates a Team to Grafana and Verify it")
    public void test03_updateTeamAndVerify(){
        String id = APIFlows.getTeamProperty("teams[1].id");
        APIFlows.updateTeam("AvivitTeam","Avivit@kuku.com",id);
        Verifications.VerifyText(APIFlows.getTeamProperty("teams[1].email"),"Avivit@kuku.com");
    }

    @Test(description = "Test 04:Delete  Team And verify")
    @Description ("This Test Deletes a Team to Grafana and Verify it")
    public void test04_deleteTeamAndVerify(){
        String id = APIFlows.getTeamProperty("teams[1].id");
        APIFlows.deleteTeam(id);
        Verifications.VerifyText(APIFlows.getTeamProperty("totalCount"),"1");
    }


}
