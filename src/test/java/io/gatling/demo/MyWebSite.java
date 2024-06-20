package io.gatling.demo;

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
    .inferHtmlResources(AllowList(), DenyList(".*\\.js", ".*\\.css", ".*\\.gif", ".*\\.jpeg", ".*\\.jpg", ".*\\.ico", ".*\\.woff", ".*\\.woff2", ".*\\.(t|o)tf", ".*\\.png", ".*\\.svg", ".*detectportal\\.firefox\\.com.*"))
    .doNotTrackHeader("1")
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36");
  
  private Map<CharSequence, String> headers_0 = Map.ofEntries(
    Map.entry("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7"),
    Map.entry("accept-encoding", "gzip, deflate, br, zstd"),
    Map.entry("accept-language", "en-US,en;q=0.9,uk;q=0.8,ru;q=0.7,fr-FR;q=0.6,fr;q=0.5"),
    Map.entry("priority", "u=0, i"),
    Map.entry("sec-ch-ua", "Not/A)Brand\";v=\"8\", \"Chromium\";v=\"126\", \"Google Chrome\";v=\"126"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows"),
    Map.entry("sec-fetch-dest", "document"),
    Map.entry("sec-fetch-mode", "navigate"),
    Map.entry("sec-fetch-site", "cross-site"),
    Map.entry("sec-fetch-user", "?1"),
    Map.entry("upgrade-insecure-requests", "1")
  );
  
  private Map<CharSequence, String> headers_1 = Map.ofEntries(
    Map.entry("sec-ch-ua", "Not/A)Brand\";v=\"8\", \"Chromium\";v=\"126\", \"Google Chrome\";v=\"126"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows")
  );
  
  private Map<CharSequence, String> headers_2 = Map.ofEntries(
    Map.entry("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7"),
    Map.entry("accept-encoding", "gzip, deflate, br, zstd"),
    Map.entry("accept-language", "en-US,en;q=0.9,uk;q=0.8,ru;q=0.7,fr-FR;q=0.6,fr;q=0.5"),
    Map.entry("priority", "u=0, i"),
    Map.entry("sec-ch-ua", "Not/A)Brand\";v=\"8\", \"Chromium\";v=\"126\", \"Google Chrome\";v=\"126"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows"),
    Map.entry("sec-fetch-dest", "document"),
    Map.entry("sec-fetch-mode", "navigate"),
    Map.entry("sec-fetch-site", "same-origin"),
    Map.entry("sec-fetch-user", "?1"),
    Map.entry("upgrade-insecure-requests", "1")
  );
  
  private String uri2 = "https://fonts.googleapis.com/css2";

  private ScenarioBuilder scn = scenario("MyWebSite")
    .exec(
      http("request_0")
        .get("/")
        .headers(headers_0)
        .resources(
          http("request_1")
            .get(uri2 + "?family=Albert+Sans:ital,wght@0,100..900;1,100..900&display=swap")
            .headers(headers_1)
        ),
      pause(57),
      http("request_2")
        .get("/about")
        .headers(headers_2)
        .resources(
          http("request_3")
            .get(uri2 + "?family=Albert+Sans:ital,wght@0,100..900;1,100..900&display=swap")
            .headers(headers_1)
        ),
      pause(2),
      http("request_4")
        .get("/")
        .headers(headers_2)
        .resources(
          http("request_5")
            .get(uri2 + "?family=Albert+Sans:ital,wght@0,100..900;1,100..900&display=swap")
            .headers(headers_1)
        ),
      pause(1),
      http("request_6")
        .get("/about")
        .headers(headers_2)
        .resources(
          http("request_7")
            .get(uri2 + "?family=Albert+Sans:ital,wght@0,100..900;1,100..900&display=swap")
            .headers(headers_1)
        )
    );

  {
	  setUp(scn.injectOpen(atOnceUsers(1))).protocols(httpProtocol);
  }
}
