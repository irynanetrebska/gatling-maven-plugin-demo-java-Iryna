package computerdatabase;

import java.time.Duration;
import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

public class MyComputerSimulation extends Simulation {

    private HttpProtocolBuilder httpProtocol = http
            .baseUrl("https://computer-database.gatling.io")
            .inferHtmlResources(AllowList(), DenyList(".*\\.js", ".*\\.css", ".*\\.gif", ".*\\.jpeg", ".*\\.jpg", ".*\\.ico", ".*\\.woff", ".*\\.woff2", ".*\\.(t|o)tf", ".*\\.png", ".*\\.svg", ".*detectportal\\.firefox\\.com.*", ".*\\.js", ".*\\.css", ".*\\.gif", ".*\\.jpeg", ".*\\.jpg", ".*\\.ico", ".*\\.woff", ".*\\.woff2", ".*\\.(t|o)tf", ".*\\.png", ".*\\.svg", ".*detectportal\\.firefox\\.com.*"))
            .disableAutoReferer()
            .doNotTrackHeader("1")
            .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36");

    ChainBuilder searchForComputer =
            exec(
                    http("LoadHomePage")
                            .get("/computers"),
                            pause(2),
                    //SEARCH FOR COMPUTER
                    http("SearchComputers")
                            .get("/computers?f=MacBook"),
                            pause(2),
                    //LOAD SPECIFIC COMPUTER
                    http("LoadComputerDetails")
                            .get("/computers/89"),
                            pause(2)
            );


    ChainBuilder browse =
            repeat(5, "n").on(
                    exec(http("Page #{n}")
                            .get("/computers?p=#{n}"))
                            .pause(2)
            );

    ChainBuilder createComputer =
            exec(
                    http("LoadCreateComputerPage")
                            .get("/computers/new"),
                    pause(2),
                    //CREATE NEW COMPUTER
                    http("CreateNewComputer")
                            .post("/computers")
                            .formParam("name", "Iryna")
                            .formParam("introduced", "2024-04-01")
                            .formParam("discontinued", "2024-05-02")
                            .formParam("company", "5")
            );

    private ScenarioBuilder admins = scenario("Admins")
            .exec(searchForComputer, browse, createComputer);

    private ScenarioBuilder users = scenario ("Users")
            .exec(searchForComputer, browse);

    {
        setUp(
                admins.injectOpen(atOnceUsers(1000)),
                users.injectOpen(atOnceUsers(1000))).protocols(httpProtocol);
    }
}

