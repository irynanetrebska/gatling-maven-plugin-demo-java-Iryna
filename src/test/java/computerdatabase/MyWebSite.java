package computerdatabase;

import java.time.Duration;
import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

public class MyWebSite extends Simulation {

    private HttpProtocolBuilder httpProtocol = http
            .baseUrl("https://poetic-zabaione-7f8495.netlify.app")
            .disableFollowRedirect()
            .inferHtmlResources(AllowList(), DenyList(".*\\.js", ".*\\.css", ".*\\.gif", ".*\\.jpeg", ".*\\.jpg", ".*\\.ico", ".*\\.woff", ".*\\.woff2", ".*\\.(t|o)tf", ".*\\.png", ".*\\.svg", ".*detectportal\\.firefox\\.com.*"))
            .doNotTrackHeader("1")
            .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36");

    ChainBuilder myInfo =
            exec(
            http("GetHomePage1")
                    .get("/"),
                    pause(2),
            http("AboutMe")
                    .get("/about"),
                    pause(2),
            http("ContactInfo")
                    .get("/"),
                    pause(1),
            http("GetHomePage2")
                    .get("/about")
            );

    private ScenarioBuilder admins = scenario("Admins")
            .exec(myInfo);


    {
        setUp(
                admins.injectOpen(atOnceUsers(1000))).protocols(httpProtocol);
    }
}
