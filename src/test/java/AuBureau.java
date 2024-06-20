
import java.time.Duration;
import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

public class AuBureau extends Simulation {

  private HttpProtocolBuilder httpProtocol = http
    .baseUrl("https://region1.analytics.google.com")
    .inferHtmlResources(AllowList(), DenyList(".*\\.js", ".*\\.css", ".*\\.gif", ".*\\.jpeg", ".*\\.jpg", ".*\\.ico", ".*\\.woff", ".*\\.woff2", ".*\\.(t|o)tf", ".*\\.png", ".*\\.svg", ".*detectportal\\.firefox\\.com.*"))
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36");
  
  private Map<CharSequence, String> headers_0 = Map.ofEntries(
    Map.entry("DNT", "1"),
    Map.entry("sec-ch-ua", "Not/A)Brand\";v=\"8\", \"Chromium\";v=\"126\", \"Google Chrome\";v=\"126"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows")
  );
  
  private Map<CharSequence, String> headers_27 = Map.ofEntries(
    Map.entry("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7"),
    Map.entry("Accept-Encoding", "gzip, deflate, br, zstd"),
    Map.entry("Accept-Language", "en-US,en;q=0.9,uk;q=0.8,ru;q=0.7,fr-FR;q=0.6,fr;q=0.5"),
    Map.entry("Cache-Control", "max-age=0"),
    Map.entry("DNT", "1"),
    Map.entry("Sec-Fetch-Dest", "document"),
    Map.entry("Sec-Fetch-Mode", "navigate"),
    Map.entry("Sec-Fetch-Site", "cross-site"),
    Map.entry("Sec-Fetch-User", "?1"),
    Map.entry("Upgrade-Insecure-Requests", "1"),
    Map.entry("sec-ch-ua", "Not/A)Brand\";v=\"8\", \"Chromium\";v=\"126\", \"Google Chrome\";v=\"126"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows")
  );
  
  private Map<CharSequence, String> headers_44 = Map.ofEntries(
    Map.entry("accept", "*/*"),
    Map.entry("accept-encoding", "gzip, deflate, br, zstd"),
    Map.entry("accept-language", "en-US,en;q=0.9,uk;q=0.8,ru;q=0.7,fr-FR;q=0.6,fr;q=0.5"),
    Map.entry("dnt", "1"),
    Map.entry("origin", "https://www.aubureau.fr"),
    Map.entry("priority", "u=4, i"),
    Map.entry("sec-ch-ua", "Not/A)Brand\";v=\"8\", \"Chromium\";v=\"126\", \"Google Chrome\";v=\"126"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows"),
    Map.entry("sec-fetch-dest", "empty"),
    Map.entry("sec-fetch-mode", "no-cors"),
    Map.entry("sec-fetch-site", "cross-site"),
    Map.entry("x-client-data", "CKi1yQEIjrbJAQiitskBCKmdygEIjJfLAQiSocsBCIWgzQEI8ZPOAQjBns4BCKaizgEY5dPNAQ==")
  );
  
  private Map<CharSequence, String> headers_45 = Map.ofEntries(
    Map.entry("accept", "*/*"),
    Map.entry("accept-encoding", "gzip, deflate, br, zstd"),
    Map.entry("accept-language", "en-US,en;q=0.9,uk;q=0.8,ru;q=0.7,fr-FR;q=0.6,fr;q=0.5"),
    Map.entry("content-type", "text/plain;charset=UTF-8"),
    Map.entry("dnt", "1"),
    Map.entry("origin", "https://www.aubureau.fr"),
    Map.entry("priority", "u=4, i"),
    Map.entry("sec-ch-ua", "Not/A)Brand\";v=\"8\", \"Chromium\";v=\"126\", \"Google Chrome\";v=\"126"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows"),
    Map.entry("sec-fetch-dest", "empty"),
    Map.entry("sec-fetch-mode", "no-cors"),
    Map.entry("sec-fetch-site", "cross-site")
  );
  
  private Map<CharSequence, String> headers_46 = Map.ofEntries(
    Map.entry("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7"),
    Map.entry("Accept-Encoding", "gzip, deflate, br, zstd"),
    Map.entry("Accept-Language", "en-US,en;q=0.9,uk;q=0.8,ru;q=0.7,fr-FR;q=0.6,fr;q=0.5"),
    Map.entry("DNT", "1"),
    Map.entry("Sec-Fetch-Dest", "document"),
    Map.entry("Sec-Fetch-Mode", "navigate"),
    Map.entry("Sec-Fetch-Site", "same-origin"),
    Map.entry("Sec-Fetch-User", "?1"),
    Map.entry("Upgrade-Insecure-Requests", "1"),
    Map.entry("sec-ch-ua", "Not/A)Brand\";v=\"8\", \"Chromium\";v=\"126\", \"Google Chrome\";v=\"126"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows")
  );
  
  private Map<CharSequence, String> headers_66 = Map.ofEntries(
    Map.entry("Accept", "text/css,*/*;q=0.1"),
    Map.entry("Accept-Encoding", "gzip, deflate, br, zstd"),
    Map.entry("Accept-Language", "en-US,en;q=0.9,uk;q=0.8,ru;q=0.7,fr-FR;q=0.6,fr;q=0.5"),
    Map.entry("DNT", "1"),
    Map.entry("Sec-Fetch-Dest", "style"),
    Map.entry("Sec-Fetch-Mode", "no-cors"),
    Map.entry("Sec-Fetch-Site", "same-origin"),
    Map.entry("sec-ch-ua", "Not/A)Brand\";v=\"8\", \"Chromium\";v=\"126\", \"Google Chrome\";v=\"126"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows")
  );
  
  private Map<CharSequence, String> headers_68 = Map.ofEntries(
    Map.entry("Accept", "*/*"),
    Map.entry("Accept-Encoding", "gzip, deflate, br, zstd"),
    Map.entry("Accept-Language", "en-US,en;q=0.9,uk;q=0.8,ru;q=0.7,fr-FR;q=0.6,fr;q=0.5"),
    Map.entry("DNT", "1"),
    Map.entry("Sec-Fetch-Dest", "script"),
    Map.entry("Sec-Fetch-Mode", "no-cors"),
    Map.entry("Sec-Fetch-Site", "same-origin"),
    Map.entry("sec-ch-ua", "Not/A)Brand\";v=\"8\", \"Chromium\";v=\"126\", \"Google Chrome\";v=\"126"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows")
  );
  
  private Map<CharSequence, String> headers_73 = Map.ofEntries(
    Map.entry("accept", "*/*"),
    Map.entry("accept-encoding", "gzip, deflate, br, zstd"),
    Map.entry("accept-language", "en-US,en;q=0.9,uk;q=0.8,ru;q=0.7,fr-FR;q=0.6,fr;q=0.5"),
    Map.entry("dnt", "1"),
    Map.entry("sec-ch-ua", "Not/A)Brand\";v=\"8\", \"Chromium\";v=\"126\", \"Google Chrome\";v=\"126"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows"),
    Map.entry("sec-fetch-dest", "script"),
    Map.entry("sec-fetch-mode", "no-cors"),
    Map.entry("sec-fetch-site", "cross-site"),
    Map.entry("x-client-data", "CKi1yQEIjrbJAQiitskBCKmdygEIjJfLAQiSocsBCIWgzQEI8ZPOAQjBns4BCKaizgEY5dPNAQ==")
  );
  
  private Map<CharSequence, String> headers_74 = Map.ofEntries(
    Map.entry("Accept", "*/*"),
    Map.entry("Accept-Encoding", "identity;q=1, *;q=0"),
    Map.entry("Accept-Language", "en-US,en;q=0.9,uk;q=0.8,ru;q=0.7,fr-FR;q=0.6,fr;q=0.5"),
    Map.entry("DNT", "1"),
    Map.entry("Range", "bytes=0-"),
    Map.entry("Sec-Fetch-Dest", "video"),
    Map.entry("Sec-Fetch-Mode", "no-cors"),
    Map.entry("Sec-Fetch-Site", "same-origin"),
    Map.entry("sec-ch-ua", "Not/A)Brand\";v=\"8\", \"Chromium\";v=\"126\", \"Google Chrome\";v=\"126"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows")
  );
  
  private Map<CharSequence, String> headers_78 = Map.ofEntries(
    Map.entry("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7"),
    Map.entry("accept-encoding", "gzip, deflate, br, zstd"),
    Map.entry("accept-language", "en-US,en;q=0.9,uk;q=0.8,ru;q=0.7,fr-FR;q=0.6,fr;q=0.5"),
    Map.entry("dnt", "1"),
    Map.entry("priority", "u=0, i"),
    Map.entry("sec-ch-ua", "Not/A)Brand\";v=\"8\", \"Chromium\";v=\"126\", \"Google Chrome\";v=\"126"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows"),
    Map.entry("sec-fetch-dest", "iframe"),
    Map.entry("sec-fetch-mode", "navigate"),
    Map.entry("sec-fetch-site", "cross-site"),
    Map.entry("sec-fetch-user", "?1"),
    Map.entry("upgrade-insecure-requests", "1"),
    Map.entry("x-client-data", "CKi1yQEIjrbJAQiitskBCKmdygEIjJfLAQiSocsBCIWgzQEI8ZPOAQjBns4BCKaizgEY5dPNAQ==")
  );
  
  private Map<CharSequence, String> headers_79 = Map.ofEntries(
    Map.entry("accept", "*/*"),
    Map.entry("accept-encoding", "gzip, deflate, br, zstd"),
    Map.entry("accept-language", "en-US,en;q=0.9,uk;q=0.8,ru;q=0.7,fr-FR;q=0.6,fr;q=0.5"),
    Map.entry("access-control-request-headers", "content-type,x-goog-api-key,x-user-agent"),
    Map.entry("access-control-request-method", "POST"),
    Map.entry("origin", "https://www.youtube.com"),
    Map.entry("priority", "u=1, i"),
    Map.entry("sec-fetch-dest", "empty"),
    Map.entry("sec-fetch-mode", "cors"),
    Map.entry("sec-fetch-site", "cross-site")
  );
  
  private Map<CharSequence, String> headers_80 = Map.ofEntries(
    Map.entry("accept", "*/*"),
    Map.entry("accept-encoding", "gzip, deflate, br, zstd"),
    Map.entry("accept-language", "en-US,en;q=0.9,uk;q=0.8,ru;q=0.7,fr-FR;q=0.6,fr;q=0.5"),
    Map.entry("content-type", "application/json+protobuf"),
    Map.entry("dnt", "1"),
    Map.entry("origin", "https://www.youtube.com"),
    Map.entry("priority", "u=1, i"),
    Map.entry("sec-ch-ua", "Not/A)Brand\";v=\"8\", \"Chromium\";v=\"126\", \"Google Chrome\";v=\"126"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows"),
    Map.entry("sec-fetch-dest", "empty"),
    Map.entry("sec-fetch-mode", "cors"),
    Map.entry("sec-fetch-site", "cross-site"),
    Map.entry("x-client-data", "CKi1yQEIjrbJAQiitskBCKmdygEIjJfLAQiSocsBCIWgzQEI8ZPOAQjBns4BCKaizgEY5dPNAQ=="),
    Map.entry("x-goog-api-key", "AIzaSyDyT5W0Jh49F30Pqqtyfdf7pDLFKLJoAnw"),
    Map.entry("x-user-agent", "grpc-web-javascript/0.1")
  );
  
  private Map<CharSequence, String> headers_81 = Map.ofEntries(
    Map.entry("accept", "image/avif,image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8"),
    Map.entry("accept-encoding", "gzip, deflate, br, zstd"),
    Map.entry("accept-language", "en-US,en;q=0.9,uk;q=0.8,ru;q=0.7,fr-FR;q=0.6,fr;q=0.5"),
    Map.entry("dnt", "1"),
    Map.entry("priority", "i"),
    Map.entry("sec-ch-ua", "Not/A)Brand\";v=\"8\", \"Chromium\";v=\"126\", \"Google Chrome\";v=\"126"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows"),
    Map.entry("sec-fetch-dest", "image"),
    Map.entry("sec-fetch-mode", "no-cors"),
    Map.entry("sec-fetch-site", "cross-site"),
    Map.entry("x-client-data", "CKi1yQEIjrbJAQiitskBCKmdygEIjJfLAQiSocsBCIWgzQEI8ZPOAQjBns4BCKaizgEY5dPNAQ==")
  );
  
  private Map<CharSequence, String> headers_82 = Map.ofEntries(
    Map.entry("accept", "image/avif,image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8"),
    Map.entry("accept-encoding", "gzip, deflate, br, zstd"),
    Map.entry("accept-language", "en-US,en;q=0.9,uk;q=0.8,ru;q=0.7,fr-FR;q=0.6,fr;q=0.5"),
    Map.entry("dnt", "1"),
    Map.entry("priority", "u=1, i"),
    Map.entry("sec-ch-ua", "Not/A)Brand\";v=\"8\", \"Chromium\";v=\"126\", \"Google Chrome\";v=\"126"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows"),
    Map.entry("sec-fetch-dest", "image"),
    Map.entry("sec-fetch-mode", "no-cors"),
    Map.entry("sec-fetch-site", "cross-site"),
    Map.entry("x-client-data", "CKi1yQEIjrbJAQiitskBCKmdygEIjJfLAQiSocsBCIWgzQEI8ZPOAQjBns4BCKaizgEY5dPNAQ==")
  );
  
  private Map<CharSequence, String> headers_85 = Map.ofEntries(
    Map.entry("accept", "*/*"),
    Map.entry("accept-encoding", "gzip, deflate, br, zstd"),
    Map.entry("accept-language", "en-US,en;q=0.9,uk;q=0.8,ru;q=0.7,fr-FR;q=0.6,fr;q=0.5"),
    Map.entry("access-control-request-headers", "authorization,x-goog-authuser"),
    Map.entry("access-control-request-method", "POST"),
    Map.entry("origin", "https://www.youtube.com"),
    Map.entry("priority", "u=1, i"),
    Map.entry("sec-fetch-dest", "empty"),
    Map.entry("sec-fetch-mode", "cors"),
    Map.entry("sec-fetch-site", "cross-site")
  );
  
  private Map<CharSequence, String> headers_87 = Map.ofEntries(
    Map.entry("accept", "image/avif,image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8"),
    Map.entry("accept-encoding", "gzip, deflate, br, zstd"),
    Map.entry("accept-language", "en-US,en;q=0.9,uk;q=0.8,ru;q=0.7,fr-FR;q=0.6,fr;q=0.5"),
    Map.entry("dnt", "1"),
    Map.entry("priority", "i"),
    Map.entry("sec-ch-ua", "Not/A)Brand\";v=\"8\", \"Chromium\";v=\"126\", \"Google Chrome\";v=\"126"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows"),
    Map.entry("sec-fetch-dest", "image"),
    Map.entry("sec-fetch-mode", "no-cors"),
    Map.entry("sec-fetch-site", "same-origin"),
    Map.entry("x-client-data", "CKi1yQEIjrbJAQiitskBCKmdygEIjJfLAQiSocsBCIWgzQEI8ZPOAQjBns4BCKaizgEY5dPNAQ==")
  );
  
  private Map<CharSequence, String> headers_88 = Map.ofEntries(
    Map.entry("accept", "*/*"),
    Map.entry("accept-encoding", "gzip, deflate, br, zstd"),
    Map.entry("accept-language", "en-US,en;q=0.9,uk;q=0.8,ru;q=0.7,fr-FR;q=0.6,fr;q=0.5"),
    Map.entry("authorization", "SAPISIDHASH 1ab6033e7caf0078198c50d21bf7273a981b3207"),
    Map.entry("content-type", "application/x-www-form-urlencoded;charset=UTF-8"),
    Map.entry("dnt", "1"),
    Map.entry("origin", "https://www.youtube.com"),
    Map.entry("priority", "u=1, i"),
    Map.entry("sec-ch-ua", "Not/A)Brand\";v=\"8\", \"Chromium\";v=\"126\", \"Google Chrome\";v=\"126"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows"),
    Map.entry("sec-fetch-dest", "empty"),
    Map.entry("sec-fetch-mode", "cors"),
    Map.entry("sec-fetch-site", "cross-site"),
    Map.entry("x-client-data", "CKi1yQEIjrbJAQiitskBCKmdygEIjJfLAQiSocsBCIWgzQEI8ZPOAQjBns4BCKaizgEY5dPNAQ=="),
    Map.entry("x-goog-authuser", "0")
  );
  
  private Map<CharSequence, String> headers_91 = Map.ofEntries(
    Map.entry("accept", "*/*"),
    Map.entry("accept-encoding", "gzip, deflate, br, zstd"),
    Map.entry("accept-language", "en-US,en;q=0.9,uk;q=0.8,ru;q=0.7,fr-FR;q=0.6,fr;q=0.5"),
    Map.entry("authorization", "SAPISIDHASH 1718880247_c29aa0c1fcd81fa56229e3f127242955cdc004f3"),
    Map.entry("content-type", "application/json"),
    Map.entry("dnt", "1"),
    Map.entry("origin", "https://www.youtube.com"),
    Map.entry("priority", "u=1, i"),
    Map.entry("sec-ch-ua", "Not/A)Brand\";v=\"8\", \"Chromium\";v=\"126\", \"Google Chrome\";v=\"126"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows"),
    Map.entry("sec-fetch-dest", "empty"),
    Map.entry("sec-fetch-mode", "cors"),
    Map.entry("sec-fetch-site", "same-origin"),
    Map.entry("x-client-data", "CKi1yQEIjrbJAQiitskBCKmdygEIjJfLAQiSocsBCIWgzQEI8ZPOAQjBns4BCKaizgEY5dPNAQ=="),
    Map.entry("x-goog-authuser", "0"),
    Map.entry("x-goog-event-time", "1718880247524"),
    Map.entry("x-goog-request-time", "1718880247524"),
    Map.entry("x-goog-visitor-id", "CgtlWHJ4N1V3eDdDZyj0j9CzBjIhCgJGUhIbEhcSFRMLFBUWFwwYGRobHB0eHw4PIBAREiAR"),
    Map.entry("x-origin", "https://www.youtube.com"),
    Map.entry("x-youtube-ad-signals", "dt=1718880245222&flash=0&frm=2&u_tz=120&u_his=2&u_h=1080&u_w=1920&u_ah=1032&u_aw=1920&u_cd=24&bc=31&bih=-12245933&biw=-12245933&brdim=3%2C3%2C3%2C3%2C1920%2C0%2C1914%2C1026%2C1522%2C856&vis=1&wgl=true&ca_type=image"),
    Map.entry("x-youtube-client-name", "56"),
    Map.entry("x-youtube-client-version", "1.20240616.00.00"),
    Map.entry("x-youtube-time-zone", "Europe/Paris"),
    Map.entry("x-youtube-utc-offset", "120")
  );
  
  private Map<CharSequence, String> headers_114 = Map.ofEntries(
    Map.entry("Accept", "image/avif,image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8"),
    Map.entry("Accept-Encoding", "gzip, deflate, br, zstd"),
    Map.entry("Accept-Language", "en-US,en;q=0.9,uk;q=0.8,ru;q=0.7,fr-FR;q=0.6,fr;q=0.5"),
    Map.entry("DNT", "1"),
    Map.entry("Sec-Fetch-Dest", "image"),
    Map.entry("Sec-Fetch-Mode", "no-cors"),
    Map.entry("Sec-Fetch-Site", "same-origin"),
    Map.entry("sec-ch-ua", "Not/A)Brand\";v=\"8\", \"Chromium\";v=\"126\", \"Google Chrome\";v=\"126"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows")
  );
  
  private Map<CharSequence, String> headers_120 = Map.ofEntries(
    Map.entry("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7"),
    Map.entry("accept-encoding", "gzip, deflate, br, zstd"),
    Map.entry("accept-language", "en-US,en;q=0.9,uk;q=0.8,ru;q=0.7,fr-FR;q=0.6,fr;q=0.5"),
    Map.entry("dnt", "1"),
    Map.entry("priority", "u=0, i"),
    Map.entry("sec-ch-ua", "Not/A)Brand\";v=\"8\", \"Chromium\";v=\"126\", \"Google Chrome\";v=\"126"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows"),
    Map.entry("sec-fetch-dest", "iframe"),
    Map.entry("sec-fetch-mode", "navigate"),
    Map.entry("sec-fetch-site", "cross-site"),
    Map.entry("upgrade-insecure-requests", "1"),
    Map.entry("x-client-data", "CKi1yQEIjrbJAQiitskBCKmdygEIjJfLAQiSocsBCIWgzQEI8ZPOAQjBns4BCKaizgEY5dPNAQ==")
  );
  
  private Map<CharSequence, String> headers_129 = Map.ofEntries(
    Map.entry("accept", "*/*"),
    Map.entry("accept-encoding", "gzip, deflate, br, zstd"),
    Map.entry("accept-language", "en-US,en;q=0.9,uk;q=0.8,ru;q=0.7,fr-FR;q=0.6,fr;q=0.5"),
    Map.entry("authorization", "SAPISIDHASH 1718880252_aeea434f4a76db71d4e4cc0329a9fe1eb99ad662"),
    Map.entry("content-type", "application/json"),
    Map.entry("dnt", "1"),
    Map.entry("origin", "https://www.youtube.com"),
    Map.entry("priority", "u=1, i"),
    Map.entry("sec-ch-ua", "Not/A)Brand\";v=\"8\", \"Chromium\";v=\"126\", \"Google Chrome\";v=\"126"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows"),
    Map.entry("sec-fetch-dest", "empty"),
    Map.entry("sec-fetch-mode", "cors"),
    Map.entry("sec-fetch-site", "same-origin"),
    Map.entry("x-client-data", "CKi1yQEIjrbJAQiitskBCKmdygEIjJfLAQiSocsBCIWgzQEI8ZPOAQjBns4BCKaizgEY5dPNAQ=="),
    Map.entry("x-goog-authuser", "0"),
    Map.entry("x-goog-event-time", "1718880252120"),
    Map.entry("x-goog-request-time", "1718880252121"),
    Map.entry("x-goog-visitor-id", "CgtlWHJ4N1V3eDdDZyj5j9CzBjIhCgJGUhIbEhcSFRMLFBUWFwwYGRobHB0eHw4PIBAREiAR"),
    Map.entry("x-origin", "https://www.youtube.com"),
    Map.entry("x-youtube-ad-signals", "dt=1718880249341&flash=0&frm=2&u_tz=120&u_his=3&u_h=1080&u_w=1920&u_ah=1032&u_aw=1920&u_cd=24&bc=31&bih=-12245933&biw=-12245933&brdim=3%2C3%2C3%2C3%2C1920%2C0%2C1914%2C1026%2C1522%2C856&vis=1&wgl=true&ca_type=image"),
    Map.entry("x-youtube-client-name", "56"),
    Map.entry("x-youtube-client-version", "1.20240616.00.00"),
    Map.entry("x-youtube-time-zone", "Europe/Paris"),
    Map.entry("x-youtube-utc-offset", "120")
  );
  
  private Map<CharSequence, String> headers_131 = Map.ofEntries(
    Map.entry("DNT", "1"),
    Map.entry("Upgrade-Insecure-Requests", "1"),
    Map.entry("sec-ch-ua", "Not/A)Brand\";v=\"8\", \"Chromium\";v=\"126\", \"Google Chrome\";v=\"126"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows")
  );
  
  private Map<CharSequence, String> headers_162 = Map.ofEntries(
    Map.entry("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7"),
    Map.entry("accept-encoding", "gzip, deflate, br, zstd"),
    Map.entry("accept-language", "en-US,en;q=0.9,uk;q=0.8,ru;q=0.7,fr-FR;q=0.6,fr;q=0.5"),
    Map.entry("dnt", "1"),
    Map.entry("priority", "u=0, i"),
    Map.entry("sec-ch-ua", "Not/A)Brand\";v=\"8\", \"Chromium\";v=\"126\", \"Google Chrome\";v=\"126"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows"),
    Map.entry("sec-fetch-dest", "document"),
    Map.entry("sec-fetch-mode", "navigate"),
    Map.entry("sec-fetch-site", "same-site"),
    Map.entry("sec-fetch-user", "?1"),
    Map.entry("upgrade-insecure-requests", "1")
  );
  
  private Map<CharSequence, String> headers_166 = Map.ofEntries(
    Map.entry("accept", "*/*"),
    Map.entry("accept-encoding", "gzip, deflate, br, zstd"),
    Map.entry("accept-language", "en-US,en;q=0.9,uk;q=0.8,ru;q=0.7,fr-FR;q=0.6,fr;q=0.5"),
    Map.entry("content-type", "text/plain"),
    Map.entry("dnt", "1"),
    Map.entry("origin", "https://restaurants.aubureau.fr"),
    Map.entry("priority", "u=1, i"),
    Map.entry("sec-ch-ua", "Not/A)Brand\";v=\"8\", \"Chromium\";v=\"126\", \"Google Chrome\";v=\"126"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows"),
    Map.entry("sec-fetch-dest", "empty"),
    Map.entry("sec-fetch-mode", "cors"),
    Map.entry("sec-fetch-site", "cross-site")
  );
  
  private Map<CharSequence, String> headers_168 = Map.ofEntries(
    Map.entry("accept", "*/*"),
    Map.entry("accept-encoding", "gzip, deflate, br, zstd"),
    Map.entry("accept-language", "en-US,en;q=0.9,uk;q=0.8,ru;q=0.7,fr-FR;q=0.6,fr;q=0.5"),
    Map.entry("content-type", "text/plain"),
    Map.entry("dnt", "1"),
    Map.entry("origin", "https://restaurants.aubureau.fr"),
    Map.entry("priority", "u=1, i"),
    Map.entry("sec-ch-ua", "Not/A)Brand\";v=\"8\", \"Chromium\";v=\"126\", \"Google Chrome\";v=\"126"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows"),
    Map.entry("sec-fetch-dest", "empty"),
    Map.entry("sec-fetch-mode", "cors"),
    Map.entry("sec-fetch-site", "cross-site"),
    Map.entry("x-client-data", "CKi1yQEIjrbJAQiitskBCKmdygEIjJfLAQiSocsBCIWgzQEI8ZPOAQjBns4BCKaizgEY5dPNAQ==")
  );
  
  private Map<CharSequence, String> headers_169 = Map.ofEntries(
    Map.entry("accept", "*/*"),
    Map.entry("accept-encoding", "gzip, deflate, br, zstd"),
    Map.entry("accept-language", "en-US,en;q=0.9,uk;q=0.8,ru;q=0.7,fr-FR;q=0.6,fr;q=0.5"),
    Map.entry("dnt", "1"),
    Map.entry("origin", "https://restaurants.aubureau.fr"),
    Map.entry("priority", "u=1, i"),
    Map.entry("sec-ch-ua", "Not/A)Brand\";v=\"8\", \"Chromium\";v=\"126\", \"Google Chrome\";v=\"126"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows"),
    Map.entry("sec-fetch-dest", "empty"),
    Map.entry("sec-fetch-mode", "cors"),
    Map.entry("sec-fetch-site", "cross-site"),
    Map.entry("x-client-data", "CKi1yQEIjrbJAQiitskBCKmdygEIjJfLAQiSocsBCIWgzQEI8ZPOAQjBns4BCKaizgEY5dPNAQ==")
  );
  
  private Map<CharSequence, String> headers_173 = Map.ofEntries(
    Map.entry("accept", "*/*"),
    Map.entry("accept-encoding", "gzip, deflate, br, zstd"),
    Map.entry("accept-language", "en-US,en;q=0.9,uk;q=0.8,ru;q=0.7,fr-FR;q=0.6,fr;q=0.5"),
    Map.entry("content-type", "application/json+protobuf"),
    Map.entry("dnt", "1"),
    Map.entry("origin", "https://restaurants.aubureau.fr"),
    Map.entry("priority", "u=1, i"),
    Map.entry("sec-ch-ua", "Not/A)Brand\";v=\"8\", \"Chromium\";v=\"126\", \"Google Chrome\";v=\"126"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows"),
    Map.entry("sec-fetch-dest", "empty"),
    Map.entry("sec-fetch-mode", "cors"),
    Map.entry("sec-fetch-site", "cross-site"),
    Map.entry("x-client-data", "CKi1yQEIjrbJAQiitskBCKmdygEIjJfLAQiSocsBCIWgzQEI8ZPOAQjBns4BCKaizgEY5dPNAQ=="),
    Map.entry("x-goog-api-key", "AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg"),
    Map.entry("x-goog-maps-api-salt", "Nih42K6qFa"),
    Map.entry("x-goog-maps-api-signature", "38048"),
    Map.entry("x-goog-maps-channel-id", ""),
    Map.entry("x-goog-maps-client-id", ""),
    Map.entry("x-user-agent", "grpc-web-javascript/0.1")
  );
  
  private Map<CharSequence, String> headers_174 = Map.ofEntries(
    Map.entry("accept", "image/avif,image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8"),
    Map.entry("accept-encoding", "gzip, deflate, br, zstd"),
    Map.entry("accept-language", "en-US,en;q=0.9,uk;q=0.8,ru;q=0.7,fr-FR;q=0.6,fr;q=0.5"),
    Map.entry("dnt", "1"),
    Map.entry("priority", "i"),
    Map.entry("sec-ch-ua", "Not/A)Brand\";v=\"8\", \"Chromium\";v=\"126\", \"Google Chrome\";v=\"126"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows"),
    Map.entry("sec-fetch-dest", "image"),
    Map.entry("sec-fetch-mode", "no-cors"),
    Map.entry("sec-fetch-site", "cross-site")
  );
  
  private Map<CharSequence, String> headers_199 = Map.ofEntries(
    Map.entry("accept", "*/*"),
    Map.entry("accept-encoding", "gzip, deflate, br, zstd"),
    Map.entry("accept-language", "en-US,en;q=0.9,uk;q=0.8,ru;q=0.7,fr-FR;q=0.6,fr;q=0.5"),
    Map.entry("dnt", "1"),
    Map.entry("origin", "https://restaurants.aubureau.fr"),
    Map.entry("priority", "u=1, i"),
    Map.entry("sec-ch-ua", "Not/A)Brand\";v=\"8\", \"Chromium\";v=\"126\", \"Google Chrome\";v=\"126"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows"),
    Map.entry("sec-fetch-dest", "empty"),
    Map.entry("sec-fetch-mode", "cors"),
    Map.entry("sec-fetch-site", "cross-site")
  );
  
  private Map<CharSequence, String> headers_200 = Map.ofEntries(
    Map.entry("accept", "*/*"),
    Map.entry("accept-encoding", "gzip, deflate, br, zstd"),
    Map.entry("accept-language", "en-US,en;q=0.9,uk;q=0.8,ru;q=0.7,fr-FR;q=0.6,fr;q=0.5"),
    Map.entry("dnt", "1"),
    Map.entry("origin", "https://restaurants.aubureau.fr"),
    Map.entry("priority", "u=4, i"),
    Map.entry("sec-ch-ua", "Not/A)Brand\";v=\"8\", \"Chromium\";v=\"126\", \"Google Chrome\";v=\"126"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows"),
    Map.entry("sec-fetch-dest", "empty"),
    Map.entry("sec-fetch-mode", "no-cors"),
    Map.entry("sec-fetch-site", "cross-site"),
    Map.entry("x-client-data", "CKi1yQEIjrbJAQiitskBCKmdygEIjJfLAQiSocsBCIWgzQEI8ZPOAQjBns4BCKaizgEY5dPNAQ==")
  );
  
  private Map<CharSequence, String> headers_208 = Map.ofEntries(
    Map.entry("accept", "*/*"),
    Map.entry("accept-encoding", "gzip, deflate, br, zstd"),
    Map.entry("accept-language", "en-US,en;q=0.9,uk;q=0.8,ru;q=0.7,fr-FR;q=0.6,fr;q=0.5"),
    Map.entry("dnt", "1"),
    Map.entry("origin", "https://restaurants.aubureau.fr"),
    Map.entry("priority", "u=1, i"),
    Map.entry("sec-ch-ua", "Not/A)Brand\";v=\"8\", \"Chromium\";v=\"126\", \"Google Chrome\";v=\"126"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows"),
    Map.entry("sec-fetch-dest", "empty"),
    Map.entry("sec-fetch-mode", "no-cors"),
    Map.entry("sec-fetch-site", "cross-site")
  );
  
  private Map<CharSequence, String> headers_235 = Map.ofEntries(
    Map.entry("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7"),
    Map.entry("accept-encoding", "gzip, deflate, br, zstd"),
    Map.entry("accept-language", "en-US,en;q=0.9,uk;q=0.8,ru;q=0.7,fr-FR;q=0.6,fr;q=0.5"),
    Map.entry("dnt", "1"),
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
  
  private Map<CharSequence, String> headers_239 = Map.ofEntries(
    Map.entry("accept", "*/*"),
    Map.entry("accept-encoding", "gzip, deflate, br, zstd"),
    Map.entry("accept-language", "en-US,en;q=0.9,uk;q=0.8,ru;q=0.7,fr-FR;q=0.6,fr;q=0.5"),
    Map.entry("access-control-request-headers", "bugsnag-api-key,bugsnag-payload-version,bugsnag-sent-at,content-type"),
    Map.entry("access-control-request-method", "POST"),
    Map.entry("origin", "https://bookings.zenchef.com"),
    Map.entry("priority", "u=1, i"),
    Map.entry("sec-fetch-dest", "empty"),
    Map.entry("sec-fetch-mode", "cors"),
    Map.entry("sec-fetch-site", "cross-site")
  );
  
  private Map<CharSequence, String> headers_241 = Map.ofEntries(
    Map.entry("accept", "*/*"),
    Map.entry("accept-encoding", "gzip, deflate, br, zstd"),
    Map.entry("accept-language", "en-US,en;q=0.9,uk;q=0.8,ru;q=0.7,fr-FR;q=0.6,fr;q=0.5"),
    Map.entry("dnt", "1"),
    Map.entry("priority", "u=1, i"),
    Map.entry("sec-ch-ua", "Not/A)Brand\";v=\"8\", \"Chromium\";v=\"126\", \"Google Chrome\";v=\"126"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows"),
    Map.entry("sec-fetch-dest", "empty"),
    Map.entry("sec-fetch-mode", "cors"),
    Map.entry("sec-fetch-site", "same-origin"),
    Map.entry("x-requested-with", "XMLHttpRequest")
  );
  
  private Map<CharSequence, String> headers_242 = Map.ofEntries(
    Map.entry("accept", "*/*"),
    Map.entry("accept-encoding", "gzip, deflate, br, zstd"),
    Map.entry("accept-language", "en-US,en;q=0.9,uk;q=0.8,ru;q=0.7,fr-FR;q=0.6,fr;q=0.5"),
    Map.entry("bugsnag-api-key", "cc2f5b0c48e3b1825b09dcdbc64da28e"),
    Map.entry("bugsnag-payload-version", "1"),
    Map.entry("bugsnag-sent-at", "2024-06-20T10:44:57.349Z"),
    Map.entry("content-type", "application/json"),
    Map.entry("dnt", "1"),
    Map.entry("origin", "https://bookings.zenchef.com"),
    Map.entry("priority", "u=1, i"),
    Map.entry("sec-ch-ua", "Not/A)Brand\";v=\"8\", \"Chromium\";v=\"126\", \"Google Chrome\";v=\"126"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows"),
    Map.entry("sec-fetch-dest", "empty"),
    Map.entry("sec-fetch-mode", "cors"),
    Map.entry("sec-fetch-site", "cross-site")
  );
  
  private Map<CharSequence, String> headers_243 = Map.ofEntries(
    Map.entry("accept", "*/*"),
    Map.entry("accept-encoding", "gzip, deflate, br, zstd"),
    Map.entry("accept-language", "en-US,en;q=0.9,uk;q=0.8,ru;q=0.7,fr-FR;q=0.6,fr;q=0.5"),
    Map.entry("bugsnag-api-key", "cc2f5b0c48e3b1825b09dcdbc64da28e"),
    Map.entry("bugsnag-payload-version", "1"),
    Map.entry("bugsnag-sent-at", "2024-06-20T10:44:57.395Z"),
    Map.entry("content-type", "application/json"),
    Map.entry("dnt", "1"),
    Map.entry("origin", "https://bookings.zenchef.com"),
    Map.entry("priority", "u=1, i"),
    Map.entry("sec-ch-ua", "Not/A)Brand\";v=\"8\", \"Chromium\";v=\"126\", \"Google Chrome\";v=\"126"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows"),
    Map.entry("sec-fetch-dest", "empty"),
    Map.entry("sec-fetch-mode", "cors"),
    Map.entry("sec-fetch-site", "cross-site")
  );
  
  private Map<CharSequence, String> headers_244 = Map.ofEntries(
    Map.entry("accept", "application/json, text/plain, */*"),
    Map.entry("accept-encoding", "gzip, deflate, br, zstd"),
    Map.entry("accept-language", "en-US,en;q=0.9,uk;q=0.8,ru;q=0.7,fr-FR;q=0.6,fr;q=0.5"),
    Map.entry("dnt", "1"),
    Map.entry("origin", "https://bookings.zenchef.com"),
    Map.entry("priority", "u=1, i"),
    Map.entry("sec-ch-ua", "Not/A)Brand\";v=\"8\", \"Chromium\";v=\"126\", \"Google Chrome\";v=\"126"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows"),
    Map.entry("sec-fetch-dest", "empty"),
    Map.entry("sec-fetch-mode", "cors"),
    Map.entry("sec-fetch-site", "same-site")
  );
  
  private Map<CharSequence, String> headers_249 = Map.ofEntries(
    Map.entry("accept", "*/*"),
    Map.entry("accept-encoding", "gzip, deflate, br, zstd"),
    Map.entry("accept-language", "en-US,en;q=0.9,uk;q=0.8,ru;q=0.7,fr-FR;q=0.6,fr;q=0.5"),
    Map.entry("content-type", "text/plain"),
    Map.entry("dnt", "1"),
    Map.entry("origin", "https://bookings.zenchef.com"),
    Map.entry("priority", "u=1, i"),
    Map.entry("sec-ch-ua", "Not/A)Brand\";v=\"8\", \"Chromium\";v=\"126\", \"Google Chrome\";v=\"126"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows"),
    Map.entry("sec-fetch-dest", "empty"),
    Map.entry("sec-fetch-mode", "cors"),
    Map.entry("sec-fetch-site", "cross-site")
  );
  
  private Map<CharSequence, String> headers_250 = Map.ofEntries(
    Map.entry("accept", "*/*"),
    Map.entry("accept-encoding", "gzip, deflate, br, zstd"),
    Map.entry("accept-language", "en-US,en;q=0.9,uk;q=0.8,ru;q=0.7,fr-FR;q=0.6,fr;q=0.5"),
    Map.entry("content-type", "text/plain"),
    Map.entry("dnt", "1"),
    Map.entry("origin", "https://bookings.zenchef.com"),
    Map.entry("priority", "u=1, i"),
    Map.entry("sec-ch-ua", "Not/A)Brand\";v=\"8\", \"Chromium\";v=\"126\", \"Google Chrome\";v=\"126"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows"),
    Map.entry("sec-fetch-dest", "empty"),
    Map.entry("sec-fetch-mode", "cors"),
    Map.entry("sec-fetch-site", "cross-site"),
    Map.entry("x-client-data", "CKi1yQEIjrbJAQiitskBCKmdygEIjJfLAQiSocsBCIWgzQEI8ZPOAQjBns4BCKaizgEY5dPNAQ==")
  );
  
  private Map<CharSequence, String> headers_251 = Map.ofEntries(
    Map.entry("accept", "*/*"),
    Map.entry("accept-encoding", "gzip, deflate, br, zstd"),
    Map.entry("accept-language", "en-US,en;q=0.9,uk;q=0.8,ru;q=0.7,fr-FR;q=0.6,fr;q=0.5"),
    Map.entry("dnt", "1"),
    Map.entry("origin", "https://bookings.zenchef.com"),
    Map.entry("priority", "u=4, i"),
    Map.entry("sec-ch-ua", "Not/A)Brand\";v=\"8\", \"Chromium\";v=\"126\", \"Google Chrome\";v=\"126"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows"),
    Map.entry("sec-fetch-dest", "empty"),
    Map.entry("sec-fetch-mode", "no-cors"),
    Map.entry("sec-fetch-site", "cross-site"),
    Map.entry("x-client-data", "CKi1yQEIjrbJAQiitskBCKmdygEIjJfLAQiSocsBCIWgzQEI8ZPOAQjBns4BCKaizgEY5dPNAQ==")
  );
  
  private Map<CharSequence, String> headers_261 = Map.ofEntries(
    Map.entry("accept", "*/*"),
    Map.entry("accept-encoding", "gzip, deflate, br, zstd"),
    Map.entry("accept-language", "en-US,en;q=0.9,uk;q=0.8,ru;q=0.7,fr-FR;q=0.6,fr;q=0.5"),
    Map.entry("bugsnag-api-key", "cc2f5b0c48e3b1825b09dcdbc64da28e"),
    Map.entry("bugsnag-payload-version", "1"),
    Map.entry("bugsnag-sent-at", "2024-06-20T10:45:04.322Z"),
    Map.entry("content-type", "application/json"),
    Map.entry("dnt", "1"),
    Map.entry("origin", "https://bookings.zenchef.com"),
    Map.entry("priority", "u=1, i"),
    Map.entry("sec-ch-ua", "Not/A)Brand\";v=\"8\", \"Chromium\";v=\"126\", \"Google Chrome\";v=\"126"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows"),
    Map.entry("sec-fetch-dest", "empty"),
    Map.entry("sec-fetch-mode", "cors"),
    Map.entry("sec-fetch-site", "cross-site")
  );
  
  private Map<CharSequence, String> headers_263 = Map.ofEntries(
    Map.entry("accept", "*/*"),
    Map.entry("accept-encoding", "gzip, deflate, br, zstd"),
    Map.entry("accept-language", "en-US,en;q=0.9,uk;q=0.8,ru;q=0.7,fr-FR;q=0.6,fr;q=0.5"),
    Map.entry("access-control-request-headers", "auth-token,content-type,timestamp"),
    Map.entry("access-control-request-method", "POST"),
    Map.entry("origin", "https://bookings.zenchef.com"),
    Map.entry("priority", "u=1, i"),
    Map.entry("sec-fetch-dest", "empty"),
    Map.entry("sec-fetch-mode", "cors"),
    Map.entry("sec-fetch-site", "same-site")
  );
  
  private Map<CharSequence, String> headers_264 = Map.ofEntries(
    Map.entry("accept", "application/json, text/plain, */*"),
    Map.entry("accept-encoding", "gzip, deflate, br, zstd"),
    Map.entry("accept-language", "en-US,en;q=0.9,uk;q=0.8,ru;q=0.7,fr-FR;q=0.6,fr;q=0.5"),
    Map.entry("auth-token", "399cbd7d2642c3bd43e758deeabe9bc6b93c01ad4ff12a3fc5d30b9ad709e28c"),
    Map.entry("content-type", "application/json"),
    Map.entry("dnt", "1"),
    Map.entry("origin", "https://bookings.zenchef.com"),
    Map.entry("priority", "u=1, i"),
    Map.entry("sec-ch-ua", "Not/A)Brand\";v=\"8\", \"Chromium\";v=\"126\", \"Google Chrome\";v=\"126"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows"),
    Map.entry("sec-fetch-dest", "empty"),
    Map.entry("sec-fetch-mode", "cors"),
    Map.entry("sec-fetch-site", "same-site"),
    Map.entry("timestamp", "1718880296505")
  );
  
  private Map<CharSequence, String> headers_273 = Map.ofEntries(
    Map.entry("accept", "*/*"),
    Map.entry("accept-encoding", "gzip, deflate, br, zstd"),
    Map.entry("accept-language", "en-US,en;q=0.9,uk;q=0.8,ru;q=0.7,fr-FR;q=0.6,fr;q=0.5"),
    Map.entry("bugsnag-api-key", "cc2f5b0c48e3b1825b09dcdbc64da28e"),
    Map.entry("bugsnag-payload-version", "1"),
    Map.entry("bugsnag-sent-at", "2024-06-20T10:46:31.108Z"),
    Map.entry("content-type", "application/json"),
    Map.entry("dnt", "1"),
    Map.entry("origin", "https://bookings.zenchef.com"),
    Map.entry("priority", "u=1, i"),
    Map.entry("sec-ch-ua", "Not/A)Brand\";v=\"8\", \"Chromium\";v=\"126\", \"Google Chrome\";v=\"126"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows"),
    Map.entry("sec-fetch-dest", "empty"),
    Map.entry("sec-fetch-mode", "cors"),
    Map.entry("sec-fetch-site", "cross-site")
  );
  
  private String uri01 = "https://www.aubureau.fr";
  
  private String uri02 = "https://bookings-middleware.zenchef.com";
  
  private String uri03 = "https://liveapi.yext.com/v2/accounts/me/entities/geosearch";
  
  private String uri04 = "https://www.youtube.com";
  
  private String uri05 = "https://stats.g.doubleclick.net/j/collect";
  
  private String uri06 = "https://yt3.ggpht.com/ytc/AIdro_n-vOfzRGuwHWt55m27Ez6qivFdFlO77dANdTNam9uOmA=s68-c-k-c0x00ffffff-no-rj";
  
  private String uri07 = "https://www.googletagmanager.com";
  
  private String uri08 = "https://www.google.com/ads/ga-audiences";
  
  private String uri10 = "https://maps.gstatic.com/mapfiles/openhand_8_8.cur";
  
  private String uri11 = "https://fonts.googleapis.com";
  
  private String uri12 = "https://www.google.fr/ads/ga-audiences";
  
  private String uri13 = "https://www.google-analytics.com";
  
  private String uri14 = "https://region1.google-analytics.com/g/collect";
  
  private String uri15 = "https://play.google.com/log";
  
  private String uri16 = "https://maps.googleapis.com";
  
  private String uri17 = "https://bookings.zenchef.com";
  
  private String uri18 = "https://jnn-pa.googleapis.com/$rpc/google.internal.waa.v1.Waa";
  
  private String uri19 = "https://api.axept.io/v1/analytics/evts";
  
  private String uri20 = "https://us.yextevents.com/store_pagespixel";
  
  private String uri21 = "https://client.axept.io/62c7431ef32c64cac3ca3a6e.json";
  
  private String uri22 = "https://sessions.bugsnag.com";
  
  private String uri23 = "https://i.ytimg.com/vi/gztV_CsM8Qs/maxresdefault.jpg";
  
  private String uri24 = "https://restaurants.aubureau.fr";

  private ScenarioBuilder scn = scenario("AuBureau")
    .exec(
      http("request_0")
        .get(uri01 + "/wp-content/plugins/dynamic-content-for-elementor/assets/css/animations.css?ver=2.7.7")
        .headers(headers_0)
        .resources(
          http("request_1")
            .get(uri01 + "/wp-includes/css/dist/block-library/style.min.css?ver=a8d769936a129767aa703e6409236c1f")
            .headers(headers_0),
          http("request_2")
            .get(uri01 + "/wp-content/plugins/post-slider-and-carousel/assets/css/owl.carousel.min.css?ver=3.2.4")
            .headers(headers_0),
          http("request_3")
            .get(uri01 + "/wp-content/plugins/post-slider-and-carousel/assets/css/psac-public.css?ver=3.2.4")
            .headers(headers_0),
          http("request_4")
            .get(uri01 + "/wp-content/plugins/wp-store-locator/css/styles.min.css?ver=2.2.241")
            .headers(headers_0),
          http("request_5")
            .get(uri11 + "/css?family=Open+Sans%3A400italic%2C700italic%2C400%2C700&subset=latin%2Clatin-ext&display=fallback")
            .headers(headers_0),
          http("request_6")
            .get(uri01 + "/wp-content/themes/aubureau/style.css?ver=20190507")
            .headers(headers_0),
          http("request_7")
            .get(uri01 + "/wp-content/themes/aubureau/css/blocks.css?ver=20190406")
            .headers(headers_0),
          http("request_8")
            .get(uri01 + "/wp-content/plugins/elementor/assets/lib/eicons/css/elementor-icons.min.css?ver=5.29.0")
            .headers(headers_0),
          http("request_9")
            .get(uri01 + "/wp-content/plugins/elementor/assets/css/frontend-lite.min.css?ver=3.21.8")
            .headers(headers_0),
          http("request_10")
            .get(uri01 + "/wp-content/plugins/elementor/assets/lib/swiper/v8/css/swiper.min.css?ver=8.4.5")
            .headers(headers_0),
          http("request_11")
            .get(uri01 + "/wp-content/uploads/elementor/css/post-7.css?ver=1718198156")
            .headers(headers_0),
          http("request_12")
            .get(uri01 + "/wp-content/plugins/dynamic-content-for-elementor/assets/css/style.min.css?ver=2.7.7")
            .headers(headers_0),
          http("request_13")
            .get(uri01 + "/wp-includes/css/dashicons.min.css?ver=a8d769936a129767aa703e6409236c1f")
            .headers(headers_0),
          http("request_14")
            .get(uri01 + "/wp-content/plugins/elementor-pro/assets/css/frontend-lite.min.css?ver=3.5.2")
            .headers(headers_0),
          http("request_15")
            .get(uri01 + "/wp-content/plugins/elementor/assets/lib/font-awesome/css/all.min.css?ver=3.21.8")
            .headers(headers_0),
          http("request_16")
            .get(uri01 + "/wp-content/plugins/elementor/assets/lib/font-awesome/css/v4-shims.min.css?ver=3.21.8")
            .headers(headers_0),
          http("request_17")
            .get(uri01 + "/wp-content/uploads/elementor/css/global.css?ver=1718198157")
            .headers(headers_0),
          http("request_18")
            .get(uri01 + "/wp-content/uploads/elementor/css/post-101.css?ver=1718198157")
            .headers(headers_0),
          http("request_19")
            .get(uri01 + "/wp-content/uploads/elementor/css/post-115.css?ver=1718198158")
            .headers(headers_0),
          http("request_20")
            .get(uri11 + "/css?family=Roboto%3A100%2C100italic%2C200%2C200italic%2C300%2C300italic%2C400%2C400italic%2C500%2C500italic%2C600%2C600italic%2C700%2C700italic%2C800%2C800italic%2C900%2C900italic%7CRoboto+Slab%3A100%2C100italic%2C200%2C200italic%2C300%2C300italic%2C400%2C400italic%2C500%2C500italic%2C600%2C600italic%2C700%2C700italic%2C800%2C800italic%2C900%2C900italic&display=auto&ver=a8d769936a129767aa703e6409236c1f")
            .headers(headers_0),
          http("request_21")
            .get(uri01 + "/wp-content/plugins/elementor/assets/lib/font-awesome/css/fontawesome.min.css?ver=5.15.3")
            .headers(headers_0),
          http("request_22")
            .get(uri01 + "/wp-content/plugins/elementor/assets/lib/font-awesome/css/solid.min.css?ver=5.15.3")
            .headers(headers_0),
          http("request_23")
            .get(uri01 + "/wp-includes/js/jquery/jquery.min.js?ver=3.7.1")
            .headers(headers_0),
          http("request_24")
            .get(uri01 + "/wp-includes/js/jquery/jquery-migrate.min.js?ver=3.4.1")
            .headers(headers_0),
          http("request_25")
            .get(uri01 + "/wp-content/themes/aubureau/js/main.js?ver=a8d769936a129767aa703e6409236c1f")
            .headers(headers_0),
          http("request_26")
            .get(uri01 + "/wp-content/plugins/elementor/assets/lib/font-awesome/js/v4-shims.min.js?ver=3.21.8")
            .headers(headers_0),
          http("request_27")
            .get(uri01 + "/restaurant/?ville=AB_Langon")
            .headers(headers_27),
          http("request_28")
            .get(uri01 + "/wp-content/plugins/dynamic-content-for-elementor/assets/css/dynamic-visibility.min.css?ver=2.7.7")
            .headers(headers_0),
          http("request_29")
            .get(uri01 + "/wp-content/plugins/elementor-pro/assets/js/webpack-pro.runtime.min.js?ver=3.5.2")
            .headers(headers_0),
          http("request_30")
            .get(uri01 + "/wp-content/plugins/elementor/assets/js/webpack.runtime.min.js?ver=3.21.8")
            .headers(headers_0),
          http("request_31")
            .get(uri01 + "/wp-content/plugins/elementor/assets/js/frontend-modules.min.js?ver=3.21.8")
            .headers(headers_0),
          http("request_32")
            .get(uri01 + "/wp-content/plugins/elementor-pro/assets/js/frontend.min.js?ver=3.5.2")
            .headers(headers_0),
          http("request_33")
            .get(uri01 + "/wp-content/plugins/elementor/assets/lib/waypoints/waypoints.min.js?ver=4.0.2")
            .headers(headers_0),
          http("request_34")
            .get(uri01 + "/wp-includes/js/jquery/ui/core.min.js?ver=1.13.2")
            .headers(headers_0),
          http("request_35")
            .get(uri01 + "/wp-content/plugins/elementor/assets/js/frontend.min.js?ver=3.21.8")
            .headers(headers_0),
          http("request_36")
            .get(uri01 + "/wp-content/plugins/elementor-pro/assets/js/elements-handlers.min.js?ver=3.5.2")
            .headers(headers_0),
          http("request_37")
            .get(uri01 + "/wp-content/plugins/dynamic-content-for-elementor/assets/js/settings.min.js?ver=2.7.7")
            .headers(headers_0),
          http("request_38")
            .get(uri01 + "/wp-content/plugins/dynamic-content-for-elementor/assets/js/fix-background-loop.min.js?ver=2.7.7")
            .headers(headers_0),
          http("request_39")
            .get(uri07 + "/gtm.js?id=GTM-T7NT423")
            .headers(headers_0),
          http("request_40")
            .get(uri01 + "/wp-includes/js/wp-emoji-release.min.js?ver=a8d769936a129767aa703e6409236c1f")
            .headers(headers_0),
          http("request_41")
            .get(uri07 + "/gtag/js?id=G-BPXJMGZQES&l=dataLayer&cx=c")
            .headers(headers_0),
          http("request_42")
            .get(uri21 + "?r=1")
            .headers(headers_0),
          http("request_43")
            .get(uri11 + "/css2?family=Albert+Sans:ital,wght@0,100..900;1,100..900&display=swap")
            .headers(headers_0)
        ),
      pause(4),
      http("request_44")
        .post("/g/collect?v=2&tid=G-BPXJMGZQES&gtm=45je46h0v889556561z8889136057za200zb889136057&_p=1718880224292&gcd=13l3l3l2l1&npa=1&dma_cps=sypham&dma=1&tag_exp=0&cid=432860143.1718879792&ul=en-us&sr=1920x1080&lps=1&uaa=x86&uab=64&uafvl=Not%252FA)Brand%3B8.0.0.0%7CChromium%3B126.0.6478.63%7CGoogle%2520Chrome%3B126.0.6478.63&uamb=0&uam=&uap=Windows&uapv=15.0.0&uaw=0&frm=0&pscdl=noapi&_s=1&sid=1718879792&sct=1&seg=1&dl=https%3A%2F%2Fwww.aubureau.fr%2Frestaurant%2F%3Fville%3DAB_Langon&dr=https%3A%2F%2Fwww.google.com%2F&dt=Au%20Bureau%20%7C%2033210%20%7C%20Langon%20%7C%20Pub%2C%20Brasserie%20et%20Restaurant&en=page_view&ep.anonymize_ip=true&ep.website_type=au%20bureau%20corpo&_et=1&tfd=6634&_z=sendBeacon")
        .headers(headers_44),
      pause(9),
      http("request_45")
        .post(uri19)
        .headers(headers_45)
        .body(RawFileBody("aubureau/0045_request.bin")),
      pause(3),
      http("request_46")
        .get(uri01 + "/notre-univers/")
        .headers(headers_46)
        .resources(
          http("request_47")
            .get(uri11 + "/css?family=Open+Sans%3A400italic%2C700italic%2C400%2C700&subset=latin%2Clatin-ext&display=fallback")
            .headers(headers_0),
          http("request_48")
            .get(uri01 + "/wp-content/uploads/elementor/css/post-7.css?ver=1718198156")
            .headers(headers_0),
          http("request_49")
            .get(uri01 + "/wp-content/uploads/elementor/css/post-101.css?ver=1718198157")
            .headers(headers_0),
          http("request_50")
            .get(uri01 + "/wp-content/uploads/elementor/css/post-115.css?ver=1718198158")
            .headers(headers_0),
          http("request_51")
            .get(uri11 + "/css?family=Roboto%3A100%2C100italic%2C200%2C200italic%2C300%2C300italic%2C400%2C400italic%2C500%2C500italic%2C600%2C600italic%2C700%2C700italic%2C800%2C800italic%2C900%2C900italic%7CRoboto+Slab%3A100%2C100italic%2C200%2C200italic%2C300%2C300italic%2C400%2C400italic%2C500%2C500italic%2C600%2C600italic%2C700%2C700italic%2C800%2C800italic%2C900%2C900italic&display=auto&ver=a8d769936a129767aa703e6409236c1f")
            .headers(headers_0),
          http("request_52")
            .get(uri01 + "/wp-includes/js/jquery/jquery.min.js?ver=3.7.1")
            .headers(headers_0),
          http("request_53")
            .get(uri01 + "/wp-includes/js/jquery/jquery-migrate.min.js?ver=3.4.1")
            .headers(headers_0),
          http("request_54")
            .get(uri01 + "/wp-content/themes/aubureau/js/main.js?ver=a8d769936a129767aa703e6409236c1f")
            .headers(headers_0),
          http("request_55")
            .get(uri01 + "/wp-content/plugins/elementor/assets/lib/font-awesome/js/v4-shims.min.js?ver=3.21.8")
            .headers(headers_0),
          http("request_56")
            .get(uri01 + "/wp-content/plugins/elementor-pro/assets/js/webpack-pro.runtime.min.js?ver=3.5.2")
            .headers(headers_0),
          http("request_57")
            .get(uri01 + "/wp-content/plugins/elementor/assets/js/webpack.runtime.min.js?ver=3.21.8")
            .headers(headers_0),
          http("request_58")
            .get(uri01 + "/wp-content/plugins/elementor/assets/js/frontend-modules.min.js?ver=3.21.8")
            .headers(headers_0),
          http("request_59")
            .get(uri01 + "/wp-content/plugins/elementor-pro/assets/js/frontend.min.js?ver=3.5.2")
            .headers(headers_0),
          http("request_60")
            .get(uri01 + "/wp-content/plugins/elementor/assets/lib/waypoints/waypoints.min.js?ver=4.0.2")
            .headers(headers_0),
          http("request_61")
            .get(uri01 + "/wp-includes/js/jquery/ui/core.min.js?ver=1.13.2")
            .headers(headers_0),
          http("request_62")
            .get(uri01 + "/wp-content/plugins/elementor/assets/js/frontend.min.js?ver=3.21.8")
            .headers(headers_0),
          http("request_63")
            .get(uri01 + "/wp-content/plugins/elementor-pro/assets/js/elements-handlers.min.js?ver=3.5.2")
            .headers(headers_0),
          http("request_64")
            .get(uri01 + "/wp-content/plugins/dynamic-content-for-elementor/assets/js/settings.min.js?ver=2.7.7")
            .headers(headers_0),
          http("request_65")
            .get(uri01 + "/wp-content/plugins/dynamic-content-for-elementor/assets/js/fix-background-loop.min.js?ver=2.7.7")
            .headers(headers_0),
          http("request_66")
            .get(uri01 + "/wp-content/uploads/elementor/css/post-8052.css?ver=1718198161")
            .headers(headers_66),
          http("request_67")
            .get(uri07 + "/gtm.js?id=GTM-T7NT423")
            .headers(headers_0),
          http("request_68")
            .get(uri01 + "/wp-includes/js/mediaelement/mediaelement-migrate.min.js?ver=a8d769936a129767aa703e6409236c1f")
            .headers(headers_68),
          http("request_69")
            .get(uri01 + "/wp-includes/js/mediaelement/wp-mediaelement.min.js?ver=a8d769936a129767aa703e6409236c1f")
            .headers(headers_68),
          http("request_70")
            .get(uri01 + "/wp-includes/js/mediaelement/mediaelement-and-player.min.js?ver=4.2.17")
            .headers(headers_68),
          http("request_71")
            .get(uri01 + "/wp-includes/js/mediaelement/renderers/vimeo.min.js?ver=4.2.17")
            .headers(headers_68),
          http("request_72")
            .get(uri01 + "/wp-includes/js/wp-emoji-release.min.js?ver=a8d769936a129767aa703e6409236c1f")
            .headers(headers_0),
          http("request_73")
            .get(uri04 + "/iframe_api")
            .headers(headers_73),
          http("request_74")
            .get(uri01 + "/wp-content/uploads/2022/05/Au-Bureau-MERCI-%EF%B8%8F%EF%B8%8F-1.mp4")
            .headers(headers_74),
          http("request_75")
            .get(uri07 + "/gtag/js?id=G-BPXJMGZQES&l=dataLayer&cx=c")
            .headers(headers_0),
          http("request_76")
            .get(uri21 + "?r=1")
            .headers(headers_0),
          http("request_77")
            .get(uri11 + "/css2?family=Albert+Sans:ital,wght@0,100..900;1,100..900&display=swap")
            .headers(headers_0),
          http("request_78")
            .get(uri04 + "/embed/gztV_CsM8Qs?controls=0&rel=0&playsinline=0&modestbranding=0&autoplay=0&enablejsapi=1&origin=https%3A%2F%2Fwww.aubureau.fr&widgetid=1")
            .headers(headers_78),
          http("request_79")
            .options(uri18 + "/Create")
            .headers(headers_79),
          http("request_80")
            .post(uri18 + "/Create")
            .headers(headers_80)
            .body(RawFileBody("aubureau/0080_request.dat")),
          http("request_81")
            .get(uri23 + "?sqp=-oaymwEmCIAKENAF8quKqQMa8AEB-AH-DoACuAiKAgwIABABGGUgUihIMA8=&rs=AOn4CLC7dcZ3LMvXW4wvBpo8sWUkrQEivQ")
            .headers(headers_81),
          http("request_82")
            .get(uri06)
            .headers(headers_82),
          http("request_83")
            .options(uri18 + "/GenerateIT")
            .headers(headers_79),
          http("request_84")
            .post(uri18 + "/GenerateIT")
            .headers(headers_80)
            .body(RawFileBody("aubureau/0084_request.dat")),
          http("request_85")
            .options(uri15 + "?format=json&hasfast=true&authuser=0")
            .headers(headers_85),
          http("request_86")
            .options(uri15 + "?format=json&hasfast=true&authuser=0")
            .headers(headers_85),
          http("request_87")
            .get(uri04 + "/generate_204?GDcqhg")
            .headers(headers_87),
          http("request_88")
            .post(uri15 + "?format=json&hasfast=true&authuser=0")
            .headers(headers_88)
            .formParam("[[1,null,null,null,null,null,null,null,null,null,[null,null,null,null,\"uk\",null,\"21\",null,[[[\"Not/A)Brand\",\"8\"],[\"Chromium\",\"126\"],[\"Google Chrome\",\"126\"]],0,\"Windows\",\"15.0.0\",\"x86\",\"\",\"126.0.6478.63\"],[1,0,0,0,0]]],1828,[[\"1718880246097\",null,null,null,null,null,null,\"[[[\\\"/client_streamz/bg/fsc\\\",null,[\\\"rk\\\",\\\"ke\\\"],[[[[\\\"dzS90e\\\"],[\\\"_\\\"]],[1]]]],[\\\"/client_streamz/bg/fsl\\\",null,[\\\"rk\\\",\\\"ke\\\"],[[[[\\\"dzS90e\\\"],[\\\"_\\\"]],[null,11.899999976158142]]]]]]\",null,null,null,null,null,null,-7200,null,null,null,null,null,2]],\"1718880246098\"]", ""),
          http("request_89")
            .post(uri15 + "?format=json&hasfast=true&authuser=0")
            .headers(headers_88)
            .formParam("[[1,null,null,null,null,null,null,null,null,null,[null,null,null,null,\"uk\",null,\"21\",null,null,[1,0,0,0,0]]],1828,[[\"1718880246080\",null,null,null,null,null,null,\"[[[\\\"/client_streamz/bg/fil\\\",null,[\\\"rk\\\",\\\"ke\\\"],[[[[\\\"dzS90e\\\"],[\\\"_\\\"]],[null,162.19999998807907]]]],[\\\"/client_streamz/bg/fic\\\",null,[\\\"ke\\\"],[[[[\\\"_\\\"]],[1]]]]]]\",null,null,null,null,null,null,-7200,null,null,null,null,null,1]],\"1718880246081\"]", ""),
          http("request_90")
            .post(uri15 + "?format=json&hasfast=true&authuser=0")
            .headers(headers_88)
            .formParam("[[1,null,null,null,null,null,null,null,null,null,[null,null,null,null,\"uk\",null,\"21\",null,null,[1,0,0,0,0]]],1828,[[\"1718880246520\",null,null,null,null,null,null,\"[[[\\\"/client_streamz/bg/fil\\\",null,[\\\"rk\\\",\\\"ke\\\"],[[[[\\\"dzS90e\\\"],[\\\"aGIf\\\"]],[null,211.4000000357628]]]],[\\\"/client_streamz/bg/fic\\\",null,[\\\"ke\\\"],[[[[\\\"aGIf\\\"]],[1]]]]]]\",null,null,null,null,null,null,-7200,null,null,null,null,null,1]],\"1718880246521\"]", ""),
          http("request_91")
            .post(uri04 + "/youtubei/v1/log_event?alt=json&key=AIzaSyAO_FJ2SlqU8Q4STEHLGCilw_Y9_11qcW8")
            .headers(headers_91)
            .body(RawFileBody("aubureau/0091_request.json")),
          http("request_92")
            .get(uri01 + "/nos-engagements/")
            .headers(headers_46),
          http("request_93")
            .get(uri11 + "/css?family=Open+Sans%3A400italic%2C700italic%2C400%2C700&subset=latin%2Clatin-ext&display=fallback")
            .headers(headers_0),
          http("request_94")
            .get(uri01 + "/wp-content/uploads/elementor/css/post-7.css?ver=1718198156")
            .headers(headers_0),
          http("request_95")
            .get(uri01 + "/wp-content/uploads/elementor/css/post-101.css?ver=1718198157")
            .headers(headers_0),
          http("request_96")
            .get(uri01 + "/wp-content/uploads/elementor/css/post-115.css?ver=1718198158")
            .headers(headers_0),
          http("request_97")
            .get(uri11 + "/css?family=Roboto%3A100%2C100italic%2C200%2C200italic%2C300%2C300italic%2C400%2C400italic%2C500%2C500italic%2C600%2C600italic%2C700%2C700italic%2C800%2C800italic%2C900%2C900italic%7CRoboto+Slab%3A100%2C100italic%2C200%2C200italic%2C300%2C300italic%2C400%2C400italic%2C500%2C500italic%2C600%2C600italic%2C700%2C700italic%2C800%2C800italic%2C900%2C900italic&display=auto&ver=a8d769936a129767aa703e6409236c1f")
            .headers(headers_0),
          http("request_98")
            .get(uri01 + "/wp-includes/js/jquery/jquery.min.js?ver=3.7.1")
            .headers(headers_0),
          http("request_99")
            .get(uri01 + "/wp-includes/js/jquery/jquery-migrate.min.js?ver=3.4.1")
            .headers(headers_0),
          http("request_100")
            .get(uri01 + "/wp-content/themes/aubureau/js/main.js?ver=a8d769936a129767aa703e6409236c1f")
            .headers(headers_0),
          http("request_101")
            .get(uri01 + "/wp-content/plugins/elementor/assets/lib/font-awesome/js/v4-shims.min.js?ver=3.21.8")
            .headers(headers_0),
          http("request_102")
            .get(uri01 + "/wp-content/plugins/elementor-pro/assets/js/webpack-pro.runtime.min.js?ver=3.5.2")
            .headers(headers_0),
          http("request_103")
            .get(uri01 + "/wp-content/plugins/elementor/assets/js/webpack.runtime.min.js?ver=3.21.8")
            .headers(headers_0),
          http("request_104")
            .get(uri01 + "/wp-content/plugins/elementor/assets/js/frontend-modules.min.js?ver=3.21.8")
            .headers(headers_0),
          http("request_105")
            .get(uri01 + "/wp-content/plugins/elementor-pro/assets/js/frontend.min.js?ver=3.5.2")
            .headers(headers_0),
          http("request_106")
            .get(uri01 + "/wp-content/plugins/elementor/assets/lib/waypoints/waypoints.min.js?ver=4.0.2")
            .headers(headers_0),
          http("request_107")
            .get(uri01 + "/wp-includes/js/jquery/ui/core.min.js?ver=1.13.2")
            .headers(headers_0),
          http("request_108")
            .get(uri01 + "/wp-content/plugins/elementor/assets/js/frontend.min.js?ver=3.21.8")
            .headers(headers_0),
          http("request_109")
            .get(uri01 + "/wp-content/plugins/elementor-pro/assets/js/elements-handlers.min.js?ver=3.5.2")
            .headers(headers_0),
          http("request_110")
            .get(uri01 + "/wp-content/plugins/dynamic-content-for-elementor/assets/js/settings.min.js?ver=2.7.7")
            .headers(headers_0),
          http("request_111")
            .get(uri01 + "/wp-content/plugins/dynamic-content-for-elementor/assets/js/fix-background-loop.min.js?ver=2.7.7")
            .headers(headers_0),
          http("request_112")
            .get(uri01 + "/wp-content/uploads/elementor/css/post-10639.css?ver=1718198470")
            .headers(headers_66),
          http("request_113")
            .get(uri07 + "/gtm.js?id=GTM-T7NT423")
            .headers(headers_0),
          http("request_114")
            .get(uri01 + "/wp-content/uploads/2023/04/343257076_230711402972772_770282049387021503_n-768x640.webp")
            .headers(headers_114),
          http("request_115")
            .get(uri01 + "/wp-includes/js/wp-emoji-release.min.js?ver=a8d769936a129767aa703e6409236c1f")
            .headers(headers_0),
          http("request_116")
            .get(uri04 + "/iframe_api")
            .headers(headers_73),
          http("request_117")
            .get(uri11 + "/css2?family=Albert+Sans:ital,wght@0,100..900;1,100..900&display=swap")
            .headers(headers_0),
          http("request_118")
            .get(uri07 + "/gtag/js?id=G-BPXJMGZQES&l=dataLayer&cx=c")
            .headers(headers_0),
          http("request_119")
            .get(uri21 + "?r=1")
            .headers(headers_0),
          http("request_120")
            .get(uri04 + "/embed/gztV_CsM8Qs?controls=0&rel=0&playsinline=0&modestbranding=0&autoplay=0&enablejsapi=1&origin=https%3A%2F%2Fwww.aubureau.fr&widgetid=1")
            .headers(headers_120),
          http("request_121")
            .get(uri23 + "?sqp=-oaymwEmCIAKENAF8quKqQMa8AEB-AH-DoACuAiKAgwIABABGGUgUihIMA8=&rs=AOn4CLC7dcZ3LMvXW4wvBpo8sWUkrQEivQ")
            .headers(headers_0),
          http("request_122")
            .get(uri06)
            .headers(headers_0),
          http("request_123")
            .post(uri18 + "/Create")
            .headers(headers_80)
            .body(RawFileBody("aubureau/0123_request.dat")),
          http("request_124")
            .post(uri15 + "?format=json&hasfast=true&authuser=0")
            .headers(headers_88)
            .formParam("[[1,null,null,null,null,null,null,null,null,null,[null,null,null,null,\"uk\",null,\"21\",null,null,[1,0,0,0,0]]],1828,[[\"1718880249829\",null,null,null,null,null,null,\"[[[\\\"/client_streamz/bg/fil\\\",null,[\\\"rk\\\",\\\"ke\\\"],[[[[\\\"dzS90e\\\"],[\\\"_\\\"]],[null,95.5]]]],[\\\"/client_streamz/bg/fic\\\",null,[\\\"ke\\\"],[[[[\\\"_\\\"]],[1]]]]]]\",null,null,null,null,null,null,-7200,null,null,null,null,null,1]],\"1718880249829\"]", ""),
          http("request_125")
            .post(uri15 + "?format=json&hasfast=true&authuser=0")
            .headers(headers_88)
            .formParam("[[1,null,null,null,null,null,null,null,null,null,[null,null,null,null,\"uk\",null,\"21\",null,[[[\"Not/A)Brand\",\"8\"],[\"Chromium\",\"126\"],[\"Google Chrome\",\"126\"]],0,\"Windows\",\"15.0.0\",\"x86\",\"\",\"126.0.6478.63\"],[1,0,0,0,0]]],1828,[[\"1718880249836\",null,null,null,null,null,null,\"[[[\\\"/client_streamz/bg/fsc\\\",null,[\\\"rk\\\",\\\"ke\\\"],[[[[\\\"dzS90e\\\"],[\\\"_\\\"]],[1]]]],[\\\"/client_streamz/bg/fsl\\\",null,[\\\"rk\\\",\\\"ke\\\"],[[[[\\\"dzS90e\\\"],[\\\"_\\\"]],[null,3.899999976158142]]]]]]\",null,null,null,null,null,null,-7200,null,null,null,null,null,2]],\"1718880249837\"]", ""),
          http("request_126")
            .post(uri18 + "/GenerateIT")
            .headers(headers_80)
            .body(RawFileBody("aubureau/0126_request.dat")),
          http("request_127")
            .get(uri04 + "/generate_204?1A3GvA")
            .headers(headers_87),
          http("request_128")
            .post(uri15 + "?format=json&hasfast=true&authuser=0")
            .headers(headers_88)
            .formParam("[[1,null,null,null,null,null,null,null,null,null,[null,null,null,null,\"uk\",null,\"21\",null,null,[1,0,0,0,0]]],1828,[[\"1718880249992\",null,null,null,null,null,null,\"[[[\\\"/client_streamz/bg/fil\\\",null,[\\\"rk\\\",\\\"ke\\\"],[[[[\\\"dzS90e\\\"],[\\\"aGIf\\\"]],[null,108.5]]]],[\\\"/client_streamz/bg/fic\\\",null,[\\\"ke\\\"],[[[[\\\"aGIf\\\"]],[1]]]]]]\",null,null,null,null,null,null,-7200,null,null,null,null,null,1]],\"1718880249992\"]", "")
        ),
      pause(2),
      http("request_129")
        .post(uri04 + "/youtubei/v1/log_event?alt=json&key=AIzaSyAO_FJ2SlqU8Q4STEHLGCilw_Y9_11qcW8")
        .headers(headers_129)
        .body(RawFileBody("aubureau/0129_request.json")),
      pause(1),
      http("request_130")
        .post("/g/collect?v=2&tid=G-BPXJMGZQES&gtm=45je46h0v889556561z8889136057za200zb889136057&_p=1718880247751&gcd=13l3l3l2l1&npa=1&dma_cps=sypham&dma=1&tag_exp=0&cid=432860143.1718879792&ul=en-us&sr=1920x1080&uaa=x86&uab=64&uafvl=Not%252FA)Brand%3B8.0.0.0%7CChromium%3B126.0.6478.63%7CGoogle%2520Chrome%3B126.0.6478.63&uamb=0&uam=&uap=Windows&uapv=15.0.0&uaw=0&frm=0&pscdl=noapi&_s=1&sid=1718879792&sct=1&seg=1&dl=https%3A%2F%2Fwww.aubureau.fr%2Fnos-engagements%2F&dr=https%3A%2F%2Fwww.aubureau.fr%2Fnotre-univers%2F&dt=Au%20Bureau%20s%27engage%20-%20Au%20Bureau&en=page_view&ep.anonymize_ip=true&ep.website_type=au%20bureau%20corpo&_et=1&tfd=6465&_z=sendBeacon")
        .headers(headers_44),
      pause(1),
      http("request_131")
        .get(uri01 + "/carte-des-plats/")
        .headers(headers_131)
        .resources(
          http("request_132")
            .get(uri11 + "/css?family=Open+Sans%3A400italic%2C700italic%2C400%2C700&subset=latin%2Clatin-ext&display=fallback")
            .headers(headers_0),
          http("request_133")
            .get(uri01 + "/wp-content/uploads/elementor/css/post-7.css?ver=1718198156")
            .headers(headers_0),
          http("request_134")
            .get(uri01 + "/wp-content/uploads/elementor/css/post-101.css?ver=1718198157")
            .headers(headers_0),
          http("request_135")
            .get(uri01 + "/wp-content/uploads/elementor/css/post-115.css?ver=1718198158")
            .headers(headers_0),
          http("request_136")
            .get(uri11 + "/css?family=Roboto%3A100%2C100italic%2C200%2C200italic%2C300%2C300italic%2C400%2C400italic%2C500%2C500italic%2C600%2C600italic%2C700%2C700italic%2C800%2C800italic%2C900%2C900italic%7CRoboto+Slab%3A100%2C100italic%2C200%2C200italic%2C300%2C300italic%2C400%2C400italic%2C500%2C500italic%2C600%2C600italic%2C700%2C700italic%2C800%2C800italic%2C900%2C900italic&display=auto&ver=a8d769936a129767aa703e6409236c1f")
            .headers(headers_0),
          http("request_137")
            .get(uri01 + "/wp-includes/js/jquery/jquery.min.js?ver=3.7.1")
            .headers(headers_0),
          http("request_138")
            .get(uri01 + "/wp-includes/js/jquery/jquery-migrate.min.js?ver=3.4.1")
            .headers(headers_0),
          http("request_139")
            .get(uri01 + "/wp-content/themes/aubureau/js/main.js?ver=a8d769936a129767aa703e6409236c1f")
            .headers(headers_0),
          http("request_140")
            .get(uri01 + "/wp-content/plugins/elementor/assets/lib/font-awesome/js/v4-shims.min.js?ver=3.21.8")
            .headers(headers_0),
          http("request_141")
            .get(uri01 + "/wp-content/plugins/elementor-pro/assets/js/webpack-pro.runtime.min.js?ver=3.5.2")
            .headers(headers_0),
          http("request_142")
            .get(uri01 + "/wp-content/plugins/elementor/assets/js/webpack.runtime.min.js?ver=3.21.8")
            .headers(headers_0),
          http("request_143")
            .get(uri01 + "/wp-content/plugins/elementor/assets/js/frontend-modules.min.js?ver=3.21.8")
            .headers(headers_0),
          http("request_144")
            .get(uri01 + "/wp-content/plugins/elementor-pro/assets/js/frontend.min.js?ver=3.5.2")
            .headers(headers_0),
          http("request_145")
            .get(uri01 + "/wp-content/plugins/elementor/assets/lib/waypoints/waypoints.min.js?ver=4.0.2")
            .headers(headers_0),
          http("request_146")
            .get(uri01 + "/wp-includes/js/jquery/ui/core.min.js?ver=1.13.2")
            .headers(headers_0),
          http("request_147")
            .get(uri01 + "/wp-content/plugins/elementor/assets/js/frontend.min.js?ver=3.21.8")
            .headers(headers_0),
          http("request_148")
            .get(uri01 + "/wp-content/plugins/elementor-pro/assets/js/elements-handlers.min.js?ver=3.5.2")
            .headers(headers_0),
          http("request_149")
            .get(uri01 + "/wp-content/plugins/dynamic-content-for-elementor/assets/js/settings.min.js?ver=2.7.7")
            .headers(headers_0),
          http("request_150")
            .get(uri01 + "/wp-content/plugins/dynamic-content-for-elementor/assets/js/fix-background-loop.min.js?ver=2.7.7")
            .headers(headers_0),
          http("request_151")
            .get(uri01 + "/wp-content/uploads/elementor/css/post-2281.css?ver=1718198157")
            .headers(headers_0),
          http("request_152")
            .get(uri01 + "/wp-content/uploads/elementor/css/post-7016.css?ver=1718198158")
            .headers(headers_0),
          http("request_153")
            .get(uri07 + "/gtm.js?id=GTM-T7NT423")
            .headers(headers_0),
          http("request_154")
            .get(uri01 + "/wp-includes/js/wp-emoji-release.min.js?ver=a8d769936a129767aa703e6409236c1f")
            .headers(headers_0),
          http("request_155")
            .get(uri07 + "/gtag/js?id=G-BPXJMGZQES&l=dataLayer&cx=c")
            .headers(headers_0),
          http("request_156")
            .get(uri21 + "?r=1")
            .headers(headers_0),
          http("request_157")
            .get(uri11 + "/css2?family=Albert+Sans:ital,wght@0,100..900;1,100..900&display=swap")
            .headers(headers_0)
        ),
      pause(5),
      http("request_158")
        .post("/g/collect?v=2&tid=G-BPXJMGZQES&gtm=45je46h0v889556561z8889136057za200zb889136057&_p=1718880255577&gcd=13l3l3l2l1&npa=1&dma_cps=sypham&dma=1&tag_exp=0&cid=432860143.1718879792&ul=en-us&sr=1920x1080&uaa=x86&uab=64&uafvl=Not%252FA)Brand%3B8.0.0.0%7CChromium%3B126.0.6478.63%7CGoogle%2520Chrome%3B126.0.6478.63&uamb=0&uam=&uap=Windows&uapv=15.0.0&uaw=0&frm=0&pscdl=noapi&_s=1&sid=1718879792&sct=1&seg=1&dl=https%3A%2F%2Fwww.aubureau.fr%2Fcarte-des-plats%2F&dr=https%3A%2F%2Fwww.aubureau.fr%2Fnos-engagements%2F&dt=La%20Carte%20-%20Au%20Bureau&en=page_view&ep.anonymize_ip=true&ep.website_type=au%20bureau%20corpo&_et=2&tfd=5975&_z=sendBeacon")
        .headers(headers_44),
      pause(9),
      http("request_159")
        .post(uri19)
        .headers(headers_45)
        .body(RawFileBody("aubureau/0159_request.bin")),
      pause(10),
      http("request_160")
        .post("/g/collect?v=2&tid=G-BPXJMGZQES&gtm=45je46h0v889556561z8889136057za200zb889136057&_p=1718880255577&_gaz=1&gcd=13l3l3l2l1&npa=1&dma_cps=sypham&dma=1&tag_exp=0&cid=432860143.1718879792&ul=en-us&sr=1920x1080&uaa=x86&uab=64&uafvl=Not%252FA)Brand%3B8.0.0.0%7CChromium%3B126.0.6478.63%7CGoogle%2520Chrome%3B126.0.6478.63&uamb=0&uam=&uap=Windows&uapv=15.0.0&uaw=0&frm=0&pscdl=noapi&_s=2&sid=1718879792&sct=1&seg=1&dl=https%3A%2F%2Fwww.aubureau.fr%2Fcarte-des-plats%2F&dr=https%3A%2F%2Fwww.aubureau.fr%2Fnos-engagements%2F&dt=La%20Carte%20-%20Au%20Bureau&en=click_button&ep.anonymize_ip=true&ep.website_type=au%20bureau%20corpo&ep.button_text=r%C3%A9server&ep.current_page=%2Fcarte-des-plats%2F&_et=25298&tfd=26271&_z=sendBeacon")
        .headers(headers_44)
        .resources(
          http("request_161")
            .get(uri12 + "?v=1&t=sr&slf_rd=1&_r=4&tid=G-BPXJMGZQES&cid=432860143.1718879792&gtm=45je46h0v889556561z8889136057za200zb889136057&aip=1&dma=1&dma_cps=sypham&gcd=13l3l3l2l1&npa=1&frm=0&z=2061872941")
            .headers(headers_81),
          http("request_162")
            .get(uri24 + "/?_gl=1*1u8bggm*_ga*NDMyODYwMTQzLjE3MTg4Nzk3OTI.*_ga_BPXJMGZQES*MTcxODg3OTc5Mi4xLjEuMTcxODg4MDI1Ni4xOC4wLjA.")
            .headers(headers_162),
          http("request_163")
            .get(uri11 + "/css?family=Barlow+Condensed:300,400,700")
            .headers(headers_0),
          http("request_164")
            .get(uri07 + "/gtm.js?id=GTM-T7NT423")
            .headers(headers_0),
          http("request_165")
            .get(uri16 + "/maps/api/js?key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&libraries=places&callback=initMaps")
            .headers(headers_0),
          http("request_166")
            .post(uri13 + "/j/collect?v=1&_v=j101&a=1166991683&t=pageview&_s=1&dl=https%3A%2F%2Frestaurants.aubureau.fr%2F%3F_gl%3D1*1u8bggm*_ga*NDMyODYwMTQzLjE3MTg4Nzk3OTI.*_ga_BPXJMGZQES*MTcxODg3OTc5Mi4xLjEuMTcxODg4MDI1Ni4xOC4wLjA.&dr=https%3A%2F%2Fwww.aubureau.fr%2F&ul=en-us&de=UTF-8&sd=24-bit&sr=1920x1080&vp=1903x577&je=0&_u=AACIAEABAAAAACAAI~&jid=133728681&gjid=219426207&cid=432860143.1718879792&tid=UA-118398602-7&_gid=563714959.1718879964&_r=1&_slc=1&z=1626768140")
            .headers(headers_166),
          http("request_167")
            .get(uri07 + "/gtag/js?id=G-JG9FJ7QNDB&cx=c&_slc=1")
            .headers(headers_0),
          http("request_168")
            .post(uri05 + "?t=dc&aip=1&_r=3&v=1&_v=j101&tid=UA-118398602-7&cid=432860143.1718879792&jid=133728681&gjid=219426207&_gid=563714959.1718879964&_u=AACIAEAAAAAAACAAI~&z=1850610888")
            .headers(headers_168),
          http("request_169")
            .get(uri16 + "/maps/api/mapsjs/gen_204?csp_test=true")
            .headers(headers_169),
          http("request_170")
            .get(uri10)
            .headers(headers_0),
          http("request_171")
            .get(uri12 + "?t=sr&aip=1&_r=4&slf_rd=1&v=1&_v=j101&tid=UA-118398602-7&cid=432860143.1718879792&jid=133728681&_u=AACIAEAAAAAAACAAI~&z=521954296")
            .headers(headers_81),
          http("request_172")
            .get(uri08 + "?t=sr&aip=1&_r=4&slf_rd=1&v=1&_v=j101&tid=UA-118398602-7&cid=432860143.1718879792&jid=133728681&_u=AACIAEAAAAAAACAAI~&z=521954296")
            .headers(headers_81),
          http("request_173")
            .post(uri16 + "/$rpc/google.internal.maps.mapsjs.v1.MapsJsInternalService/GetViewportInfo")
            .headers(headers_173)
            .body(RawFileBody("aubureau/0173_request.dat")),
          http("request_174")
            .get(uri20 + "?product=landingpages&businessids=2104716&siteId=7908&pagesReferrer=https://www.aubureau.fr/&pageurl=/&eventType=pageview&pageDomain=restaurants.aubureau.fr&queryParams=%7B%22_gl%22%3A%221*1u8bggm*_ga*NDMyODYwMTQzLjE3MTg4Nzk3OTI.*_ga_BPXJMGZQES*MTcxODg3OTc5Mi4xLjEuMTcxODg4MDI1Ni4xOC4wLjA.%22%7D&v=1718880283468")
            .headers(headers_174),
          http("request_175")
            .get(uri16 + "/maps/vt?pb=!1m5!1m4!1i5!2i16!3i11!4i256!2m3!1e0!2sm!3i696443457!3m17!2sen-US!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjMzfHMuZTpsfHAudjpvZmY!4e0&key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&token=78593")
            .headers(headers_0),
          http("request_176")
            .get(uri16 + "/maps/vt?pb=!1m5!1m4!1i5!2i15!3i11!4i256!2m3!1e0!2sm!3i696443457!3m17!2sen-US!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjMzfHMuZTpsfHAudjpvZmY!4e0&key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&token=57543")
            .headers(headers_0),
          http("request_177")
            .get(uri16 + "/maps/vt?pb=!1m5!1m4!1i5!2i15!3i10!4i256!2m3!1e0!2sm!3i696443457!3m17!2sen-US!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjMzfHMuZTpsfHAudjpvZmY!4e0&key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&token=45485")
            .headers(headers_0),
          http("request_178")
            .get(uri16 + "/maps/vt?pb=!1m5!1m4!1i5!2i16!3i10!4i256!2m3!1e0!2sm!3i696443457!3m17!2sen-US!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjMzfHMuZTpsfHAudjpvZmY!4e0&key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&token=66535")
            .headers(headers_0),
          http("request_179")
            .get(uri16 + "/maps/vt?pb=!1m5!1m4!1i5!2i17!3i10!4i256!2m3!1e0!2sm!3i696443445!3m17!2sen-US!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjMzfHMuZTpsfHAudjpvZmY!4e0&key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&token=11399")
            .headers(headers_0),
          http("request_180")
            .get(uri16 + "/maps/vt?pb=!1m5!1m4!1i5!2i17!3i11!4i256!2m3!1e0!2sm!3i696443457!3m17!2sen-US!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjMzfHMuZTpsfHAudjpvZmY!4e0&key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&token=99643")
            .headers(headers_0),
          http("request_181")
            .get(uri16 + "/maps/vt?pb=!1m5!1m4!1i5!2i17!3i12!4i256!2m3!1e0!2sm!3i696443457!3m17!2sen-US!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjMzfHMuZTpsfHAudjpvZmY!4e0&key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&token=111701")
            .headers(headers_0),
          http("request_182")
            .get(uri16 + "/maps/vt?pb=!1m5!1m4!1i5!2i16!3i12!4i256!2m3!1e0!2sm!3i696443457!3m17!2sen-US!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjMzfHMuZTpsfHAudjpvZmY!4e0&key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&token=90651")
            .headers(headers_0),
          http("request_183")
            .get(uri16 + "/maps/vt?pb=!1m5!1m4!1i5!2i15!3i12!4i256!2m3!1e0!2sm!3i696443457!3m17!2sen-US!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjMzfHMuZTpsfHAudjpvZmY!4e0&key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&token=69601")
            .headers(headers_0),
          http("request_184")
            .get(uri16 + "/maps/vt?pb=!1m5!1m4!1i5!2i14!3i12!4i256!2m3!1e0!2sm!3i696443457!3m17!2sen-US!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjMzfHMuZTpsfHAudjpvZmY!4e0&key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&token=48551")
            .headers(headers_0),
          http("request_185")
            .get(uri16 + "/maps/vt?pb=!1m5!1m4!1i5!2i14!3i11!4i256!2m3!1e0!2sm!3i696443457!3m17!2sen-US!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjMzfHMuZTpsfHAudjpvZmY!4e0&key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&token=36493")
            .headers(headers_0),
          http("request_186")
            .get(uri16 + "/maps/vt?pb=!1m5!1m4!1i5!2i14!3i10!4i256!2m3!1e0!2sm!3i696443457!3m17!2sen-US!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjMzfHMuZTpsfHAudjpvZmY!4e0&key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&token=24435")
            .headers(headers_0),
          http("request_187")
            .get(uri16 + "/maps/vt?pb=!1m5!1m4!1i5!2i18!3i10!4i256!2m3!1e0!2sm!3i696443457!3m17!2sen-US!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjMzfHMuZTpsfHAudjpvZmY!4e0&key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&token=108635")
            .headers(headers_0),
          http("request_188")
            .get(uri16 + "/maps/vt?pb=!1m5!1m4!1i5!2i18!3i11!4i256!2m3!1e0!2sm!3i696443457!3m17!2sen-US!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjMzfHMuZTpsfHAudjpvZmY!4e0&key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&token=120693")
            .headers(headers_0),
          http("request_189")
            .get(uri16 + "/maps/vt?pb=!1m5!1m4!1i5!2i18!3i12!4i256!2m3!1e0!2sm!3i696443397!3m17!2sen-US!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjMzfHMuZTpsfHAudjpvZmY!4e0&key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&token=3347")
            .headers(headers_0),
          http("request_190")
            .get(uri16 + "/maps/vt?pb=!1m5!1m4!1i5!2i13!3i12!4i256!2m3!1e0!2sm!3i696443181!3m17!2sen-US!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjMzfHMuZTpsfHAudjpvZmY!4e0&key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&token=65180")
            .headers(headers_0),
          http("request_191")
            .get(uri16 + "/maps/vt?pb=!1m5!1m4!1i5!2i13!3i11!4i256!2m3!1e0!2sm!3i696441549!3m17!2sen-US!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjMzfHMuZTpsfHAudjpvZmY!4e0&key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&token=96130")
            .headers(headers_0),
          http("request_192")
            .get(uri16 + "/maps/vt?pb=!1m5!1m4!1i5!2i13!3i10!4i256!2m3!1e0!2sm!3i696430149!3m17!2sen-US!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjMzfHMuZTpsfHAudjpvZmY!4e0&key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&token=50645")
            .headers(headers_0),
          http("request_193")
            .get(uri16 + "/maps/vt?pb=!1m5!1m4!1i5!2i19!3i10!4i256!2m3!1e0!2sm!3i696443457!3m17!2sen-US!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjMzfHMuZTpsfHAudjpvZmY!4e0&key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&token=129685")
            .headers(headers_0),
          http("request_194")
            .get(uri16 + "/maps/vt?pb=!1m5!1m4!1i5!2i19!3i11!4i256!2m3!1e0!2sm!3i696443457!3m17!2sen-US!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjMzfHMuZTpsfHAudjpvZmY!4e0&key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&token=10672")
            .headers(headers_0),
          http("request_195")
            .get(uri16 + "/maps/vt?pb=!1m5!1m4!1i5!2i19!3i12!4i256!2m3!1e0!2sm!3i696443361!3m17!2sen-US!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjMzfHMuZTpsfHAudjpvZmY!4e0&key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&token=57981")
            .headers(headers_0),
          http("request_196")
            .get(uri16 + "/maps/vt?pb=!1m4!1m3!1i5!2i13!3i10!1m4!1m3!1i5!2i13!3i11!1m4!1m3!1i5!2i14!3i10!1m4!1m3!1i5!2i14!3i11!1m4!1m3!1i5!2i15!3i10!1m4!1m3!1i5!2i15!3i11!1m4!1m3!1i5!2i13!3i12!1m4!1m3!1i5!2i14!3i12!1m4!1m3!1i5!2i15!3i12!1m4!1m3!1i5!2i16!3i10!1m4!1m3!1i5!2i16!3i11!1m4!1m3!1i5!2i17!3i10!1m4!1m3!1i5!2i17!3i11!1m4!1m3!1i5!2i18!3i10!1m4!1m3!1i5!2i18!3i11!1m4!1m3!1i5!2i19!3i10!1m4!1m3!1i5!2i19!3i11!1m4!1m3!1i5!2i16!3i12!1m4!1m3!1i5!2i17!3i12!1m4!1m3!1i5!2i18!3i12!1m4!1m3!1i5!2i19!3i12!2m3!1e0!2sm!3i696443457!3m17!2sen-US!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjMzfHMuZTpsfHAudjpvZmY!4e3!12m1!5b1&callback=_xdc_._ac6v0b&key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&token=7262")
            .headers(headers_0),
          http("request_197")
            .get(uri07 + "/gtag/js?id=G-BPXJMGZQES&l=dataLayer&cx=c")
            .headers(headers_0),
          http("request_198")
            .get(uri11 + "/css2?family=Albert+Sans:ital,wght@0,100..900;1,100..900&display=swap")
            .headers(headers_0),
          http("request_199")
            .get(uri21 + "?r=1")
            .headers(headers_199),
          http("request_200")
            .post("/g/collect?v=2&tid=G-BPXJMGZQES&gtm=45je46h0v889556561z8889136057za200zb889136057&_p=1718880282429&_gaz=1&gcd=13l3l3l2l1&npa=1&dma_cps=sypham&dma=1&tag_exp=0&cid=432860143.1718879792&ul=en-us&sr=1920x1080&uaa=x86&uab=64&uafvl=Not%252FA)Brand%3B8.0.0.0%7CChromium%3B126.0.6478.63%7CGoogle%2520Chrome%3B126.0.6478.63&uamb=0&uam=&uap=Windows&uapv=15.0.0&uaw=0&frm=0&pscdl=noapi&_s=1&sid=1718879792&sct=1&seg=1&dl=https%3A%2F%2Frestaurants.aubureau.fr%2F%3F_gl%3D1*1u8bggm*_ga*NDMyODYwMTQzLjE3MTg4Nzk3OTI.*_ga_BPXJMGZQES*MTcxODg3OTc5Mi4xLjEuMTcxODg4MDI1Ni4xOC4wLjA.&dr=https%3A%2F%2Fwww.aubureau.fr%2F&dt=&en=page_view&ep.anonymize_ip=true&ep.website_type=au%20bureau%20restaurants&_et=2&tfd=1341&_z=sendBeacon")
            .headers(headers_200),
          http("request_201")
            .get(uri12 + "?v=1&t=sr&slf_rd=1&_r=4&tid=G-BPXJMGZQES&cid=432860143.1718879792&gtm=45je46h0v889556561z8889136057za200zb889136057&aip=1&dma=1&dma_cps=sypham&gcd=13l3l3l2l1&npa=1&frm=0&z=295362927")
            .headers(headers_81),
          http("request_202")
            .get(uri11 + "/css?family=Google+Sans+Text:400&text=%E2%86%90%E2%86%92%E2%86%91%E2%86%93&lang=en")
            .headers(headers_0)
        ),
      pause(3),
      http("request_203")
        .get(uri16 + "/maps/api/js/AuthenticationService.Authenticate?1shttps%3A%2F%2Frestaurants.aubureau.fr%2F&4sAIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&8b0&callback=_xdc_._q0ntll&key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&token=31691")
        .headers(headers_73)
        .resources(
          http("request_204")
            .get(uri16 + "/maps/api/place/js/AutocompletionService.GetPredictions?1sl&4sen-US&9s(regions)&15e3&20s3BFA0C1E50CC4DEE89C383C9A5BC35A17x86&21m1&2e1&r_url=https%3A%2F%2Frestaurants.aubureau.fr%2F&callback=_xdc_._tphwj1&key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&token=8272")
            .headers(headers_73),
          http("request_205")
            .get(uri16 + "/maps/api/place/js/AutocompletionService.GetPredictions?1sla&4sen-US&9s(regions)&15e3&20s3BFA0C1E50CC4DEE89C383C9A5BC35A17x86&21m1&2e1&r_url=https%3A%2F%2Frestaurants.aubureau.fr%2F&callback=_xdc_._tjf8jx&key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&token=91735")
            .headers(headers_73),
          http("request_206")
            .get(uri16 + "/maps/api/place/js/AutocompletionService.GetPredictions?1slan&4sen-US&9s(regions)&15e3&20s3BFA0C1E50CC4DEE89C383C9A5BC35A17x86&21m1&2e1&r_url=https%3A%2F%2Frestaurants.aubureau.fr%2F&callback=_xdc_._wour5u&key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&token=14262")
            .headers(headers_73),
          http("request_207")
            .get(uri16 + "/maps/api/place/js/AutocompletionService.GetPredictions?1slang&4sen-US&9s(regions)&15e3&20s3BFA0C1E50CC4DEE89C383C9A5BC35A17x86&21m1&2e1&r_url=https%3A%2F%2Frestaurants.aubureau.fr%2F&callback=_xdc_._zevsrn&key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&token=22564")
            .headers(headers_73),
          http("request_208")
            .post(uri14 + "?v=2&tid=G-JG9FJ7QNDB&gtm=45je46h0v9111791085za200&_p=1718880282429&gcd=13l3l3l2l2&npa=0&dma_cps=sypham&dma=1&tag_exp=0&ul=en-us&sr=1920x1080&cid=432860143.1718879792&ir=1&uaa=x86&uab=64&uafvl=Not%252FA)Brand%3B8.0.0.0%7CChromium%3B126.0.6478.63%7CGoogle%2520Chrome%3B126.0.6478.63&uamb=0&uam=&uap=Windows&uapv=15.0.0&uaw=0&frm=0&pscdl=noapi&_eu=EBAI&_s=1&dl=https%3A%2F%2Frestaurants.aubureau.fr%2F%3F_gl%3D1*1u8bggm*_ga*NDMyODYwMTQzLjE3MTg4Nzk3OTI.*_ga_BPXJMGZQES*MTcxODg3OTc5Mi4xLjEuMTcxODg4MDI1Ni4xOC4wLjA.&dr=https%3A%2F%2Fwww.aubureau.fr%2F&sid=1718879963&sct=1&seg=1&en=page_view&_ee=1&tfd=6061&_z=fetch")
            .headers(headers_208),
          http("request_209")
            .get(uri16 + "/maps/api/place/js/AutocompletionService.GetPredictions?1slango&4sen-US&9s(regions)&15e3&20s3BFA0C1E50CC4DEE89C383C9A5BC35A17x86&21m1&2e1&r_url=https%3A%2F%2Frestaurants.aubureau.fr%2F&callback=_xdc_._7gryt0&key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&token=62391")
            .headers(headers_73),
          http("request_210")
            .get(uri16 + "/maps/api/place/js/AutocompletionService.GetPredictions?1slangon&4sen-US&9s(regions)&15e3&20s3BFA0C1E50CC4DEE89C383C9A5BC35A17x86&21m1&2e1&r_url=https%3A%2F%2Frestaurants.aubureau.fr%2F&callback=_xdc_._b6p1br&key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&token=101871")
            .headers(headers_73)
        ),
      pause(1),
      http("request_211")
        .get(uri16 + "/maps/api/place/js/PlaceService.GetPlaceDetails?2sen-US&10e3&14m1&1sChIJE_scyY5tVQ0R9adVnrHiyDY&15s3BFA0C1E50CC4DEE89C383C9A5BC35A17x86&17m1&2e1&r_url=https%3A%2F%2Frestaurants.aubureau.fr%2F&callback=_xdc_._3bhv27&key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&token=32805")
        .headers(headers_73)
        .resources(
          http("request_212")
            .get(uri03 + "?radius=100&location=Langon,%20France&limit=10&convertRichTextToHTML=true&convertMarkdownToHTML=true&api_key=40a841aaed11a6b9a760895d3c87b46f&v=20181201&resolvePlaceholders=true&languages=fr&entityTypes=location,restaurant&savedFilterIds=36929160")
            .headers(headers_199),
          http("request_213")
            .post(uri16 + "/$rpc/google.internal.maps.mapsjs.v1.MapsJsInternalService/GetViewportInfo")
            .headers(headers_173)
            .body(RawFileBody("aubureau/0213_request.dat")),
          http("request_214")
            .get(uri16 + "/maps/vt?pb=!1m5!1m4!1i7!2i64!3i46!4i256!2m3!1e0!2sm!3i696443457!3m17!2sen-US!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjMzfHMuZTpsfHAudjpvZmY!4e0&key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&token=106627")
            .headers(headers_0),
          http("request_215")
            .get(uri16 + "/maps/vt?pb=!1m5!1m4!1i7!2i63!3i46!4i256!2m3!1e0!2sm!3i696443457!3m17!2sen-US!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjMzfHMuZTpsfHAudjpvZmY!4e0&key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&token=85577")
            .headers(headers_0),
          http("request_216")
            .get(uri16 + "/maps/vt?pb=!1m5!1m4!1i7!2i63!3i45!4i256!2m3!1e0!2sm!3i696443457!3m17!2sen-US!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjMzfHMuZTpsfHAudjpvZmY!4e0&key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&token=73519")
            .headers(headers_0),
          http("request_217")
            .get(uri16 + "/maps/vt?pb=!1m5!1m4!1i7!2i64!3i45!4i256!2m3!1e0!2sm!3i696443445!3m17!2sen-US!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjMzfHMuZTpsfHAudjpvZmY!4e0&key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&token=18383")
            .headers(headers_0),
          http("request_218")
            .get(uri16 + "/maps/vt?pb=!1m5!1m4!1i7!2i65!3i45!4i256!2m3!1e0!2sm!3i696443457!3m17!2sen-US!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjMzfHMuZTpsfHAudjpvZmY!4e0&key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&token=115619")
            .headers(headers_0),
          http("request_219")
            .get(uri16 + "/maps/vt?pb=!1m5!1m4!1i7!2i65!3i46!4i256!2m3!1e0!2sm!3i696443457!3m17!2sen-US!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjMzfHMuZTpsfHAudjpvZmY!4e0&key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&token=127677")
            .headers(headers_0),
          http("request_220")
            .get(uri16 + "/maps/vt?pb=!1m5!1m4!1i7!2i65!3i47!4i256!2m3!1e0!2sm!3i696443457!3m17!2sen-US!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjMzfHMuZTpsfHAudjpvZmY!4e0&key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&token=8664")
            .headers(headers_0),
          http("request_221")
            .get(uri16 + "/maps/vt?pb=!1m5!1m4!1i7!2i64!3i47!4i256!2m3!1e0!2sm!3i696443457!3m17!2sen-US!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjMzfHMuZTpsfHAudjpvZmY!4e0&key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&token=118685")
            .headers(headers_0),
          http("request_222")
            .get(uri16 + "/maps/vt?pb=!1m5!1m4!1i7!2i63!3i47!4i256!2m3!1e0!2sm!3i696443457!3m17!2sen-US!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjMzfHMuZTpsfHAudjpvZmY!4e0&key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&token=97635")
            .headers(headers_0),
          http("request_223")
            .get(uri16 + "/maps/vt?pb=!1m5!1m4!1i7!2i62!3i47!4i256!2m3!1e0!2sm!3i696443457!3m17!2sen-US!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjMzfHMuZTpsfHAudjpvZmY!4e0&key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&token=76585")
            .headers(headers_0),
          http("request_224")
            .get(uri16 + "/maps/vt?pb=!1m5!1m4!1i7!2i62!3i46!4i256!2m3!1e0!2sm!3i696443457!3m17!2sen-US!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjMzfHMuZTpsfHAudjpvZmY!4e0&key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&token=64527")
            .headers(headers_0),
          http("request_225")
            .get(uri16 + "/maps/vt?pb=!1m5!1m4!1i7!2i62!3i45!4i256!2m3!1e0!2sm!3i696443457!3m17!2sen-US!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjMzfHMuZTpsfHAudjpvZmY!4e0&key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&token=52469")
            .headers(headers_0),
          http("request_226")
            .get(uri16 + "/maps/vt?pb=!1m5!1m4!1i7!2i66!3i45!4i256!2m3!1e0!2sm!3i696443457!3m17!2sen-US!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjMzfHMuZTpsfHAudjpvZmY!4e0&key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&token=5598")
            .headers(headers_0),
          http("request_227")
            .get(uri16 + "/maps/vt?pb=!1m5!1m4!1i7!2i66!3i46!4i256!2m3!1e0!2sm!3i696443445!3m17!2sen-US!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjMzfHMuZTpsfHAudjpvZmY!4e0&key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&token=72541")
            .headers(headers_0),
          http("request_228")
            .get(uri16 + "/maps/vt?pb=!1m5!1m4!1i7!2i66!3i47!4i256!2m3!1e0!2sm!3i696443445!3m17!2sen-US!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjMzfHMuZTpsfHAudjpvZmY!4e0&key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&token=84599")
            .headers(headers_0),
          http("request_229")
            .get(uri16 + "/maps/vt?pb=!1m5!1m4!1i7!2i61!3i47!4i256!2m3!1e0!2sm!3i696443457!3m17!2sen-US!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjMzfHMuZTpsfHAudjpvZmY!4e0&key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&token=55535")
            .headers(headers_0),
          http("request_230")
            .get(uri16 + "/maps/vt?pb=!1m5!1m4!1i7!2i61!3i46!4i256!2m3!1e0!2sm!3i696443457!3m17!2sen-US!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjMzfHMuZTpsfHAudjpvZmY!4e0&key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&token=43477")
            .headers(headers_0),
          http("request_231")
            .get(uri16 + "/maps/vt?pb=!1m5!1m4!1i7!2i61!3i45!4i256!2m3!1e0!2sm!3i696443457!3m17!2sen-US!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjMzfHMuZTpsfHAudjpvZmY!4e0&key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&token=31419")
            .headers(headers_0),
          http("request_232")
            .get(uri16 + "/maps/vt?pb=!1m4!1m3!1i7!2i61!3i45!1m4!1m3!1i7!2i61!3i46!1m4!1m3!1i7!2i61!3i47!1m4!1m3!1i7!2i62!3i45!1m4!1m3!1i7!2i63!3i45!1m4!1m3!1i7!2i62!3i46!1m4!1m3!1i7!2i62!3i47!1m4!1m3!1i7!2i63!3i46!1m4!1m3!1i7!2i63!3i47!1m4!1m3!1i7!2i64!3i45!1m4!1m3!1i7!2i65!3i45!1m4!1m3!1i7!2i64!3i46!1m4!1m3!1i7!2i64!3i47!1m4!1m3!1i7!2i65!3i46!1m4!1m3!1i7!2i65!3i47!1m4!1m3!1i7!2i66!3i45!1m4!1m3!1i7!2i66!3i46!1m4!1m3!1i7!2i66!3i47!2m3!1e0!2sm!3i696443457!3m17!2sen-US!3sUS!5e18!12m4!1e68!2m2!1sset!2sRoadmap!12m3!1e37!2m1!1ssmartmaps!12m4!1e26!2m2!1sstyles!2zcy50OjMzfHMuZTpsfHAudjpvZmY!4e3!12m1!5b1&callback=_xdc_._w2imiy&key=AIzaSyD07d-6xdhyP-kgE8hhTz4cYpzYIb4UNjg&token=118508")
            .headers(headers_0)
        ),
      pause(4),
      http("request_233")
        .post("/g/collect?v=2&tid=G-BPXJMGZQES&gtm=45je46h0v889556561z8889136057za200zb889136057&_p=1718880282429&gcd=13l3l3l2l1&npa=1&dma_cps=sypham&dma=1&tag_exp=0&cid=432860143.1718879792&ul=en-us&sr=1920x1080&uaa=x86&uab=64&uafvl=Not%252FA)Brand%3B8.0.0.0%7CChromium%3B126.0.6478.63%7CGoogle%2520Chrome%3B126.0.6478.63&uamb=0&uam=&uap=Windows&uapv=15.0.0&uaw=0&frm=0&pscdl=noapi&_s=2&sid=1718879792&sct=1&seg=1&dl=https%3A%2F%2Frestaurants.aubureau.fr%2F%3Fq%3DLangon%2C%2520France&dr=https%3A%2F%2Fwww.aubureau.fr%2F&dt=&en=restaurant_locator_search&ep.anonymize_ip=true&ep.website_type=au%20bureau%20restaurants&ep.restaurant_name=Langon%2C%20France&_et=7130&tfd=13491&_z=sendBeacon")
        .headers(headers_200),
      pause(1),
      http("request_234")
        .post("/g/collect?v=2&tid=G-BPXJMGZQES&gtm=45je46h0v889556561z8889136057za200zb889136057&_p=1718880282429&gcd=13l3l3l2l1&npa=1&dma_cps=sypham&dma=1&tag_exp=0&cid=432860143.1718879792&ul=en-us&sr=1920x1080&uaa=x86&uab=64&uafvl=Not%252FA)Brand%3B8.0.0.0%7CChromium%3B126.0.6478.63%7CGoogle%2520Chrome%3B126.0.6478.63&uamb=0&uam=&uap=Windows&uapv=15.0.0&uaw=0&frm=0&pscdl=noapi&_s=3&sid=1718879792&sct=1&seg=1&dl=https%3A%2F%2Frestaurants.aubureau.fr%2F%3Fq%3DLangon%2C%2520France&dr=https%3A%2F%2Fwww.aubureau.fr%2F&dt=&en=restaurant_locator_button&ep.anonymize_ip=true&ep.website_type=au%20bureau%20restaurants&ep.click_text=r%C3%A9server&ep.click_url=https%3A%2F%2Fbookings.zenchef.com%2Fresults%3Frid%3D355996%26pid%3D1001&ep.restaurant_name=Au%20Bureau%20Langon&_et=6109&tfd=14590&_z=sendBeacon")
        .headers(headers_200)
        .resources(
          http("request_235")
            .get(uri17 + "/results?rid=355996&pid=1001")
            .headers(headers_235),
          http("request_236")
            .get(uri11 + "/css2?family=DM+Mono:ital,wght@0,400;0,500;1,400;1,500&display=swap")
            .headers(headers_0),
          http("request_237")
            .get(uri11 + "/css2?family=DM+Sans:ital,opsz,wght@0,9..40,400;0,9..40,500;0,9..40,700;1,9..40,400;1,9..40,500;1,9..40,700&display=swap")
            .headers(headers_0),
          http("request_238")
            .get(uri07 + "/gtm.js?id=GTM-MZSVMRV")
            .headers(headers_0),
          http("request_239")
            .options(uri22 + "/")
            .headers(headers_239),
          http("request_240")
            .options(uri22 + "/")
            .headers(headers_239),
          http("request_241")
            .get(uri17 + "/locales/fr/translation.json")
            .headers(headers_241),
          http("request_242")
            .post(uri22 + "/")
            .headers(headers_242)
            .body(RawFileBody("aubureau/0242_request.json")),
          http("request_243")
            .post(uri22 + "/")
            .headers(headers_243)
            .body(RawFileBody("aubureau/0243_request.json")),
          http("request_244")
            .get(uri02 + "/getAvailabilitiesSummary?restaurantId=355996&date_begin=2024-06-01&date_end=2024-06-30")
            .headers(headers_244),
          http("request_245")
            .get(uri02 + "/getAvailabilitiesSummary?restaurantId=355996&date_begin=2024-07-01&date_end=2024-07-31")
            .headers(headers_244),
          http("request_246")
            .get(uri17 + "/locales/fr/validation.json")
            .headers(headers_241),
          http("request_247")
            .get(uri07 + "/gtag/js?id=G-PK649CS15L&l=dataLayer&cx=c")
            .headers(headers_0),
          http("request_248")
            .get(uri11 + "/css2?family=Albert+Sans:ital,wght@0,100..900;1,100..900&display=swap")
            .headers(headers_0),
          http("request_249")
            .post(uri13 + "/j/collect?v=1&_v=j101&a=728868600&t=pageview&_s=1&dl=https%3A%2F%2Fbookings.zenchef.com%2Fresults%3Frid%3D355996%26pid%3D1001&dr=https%3A%2F%2Frestaurants.aubureau.fr%2F&dp=bookingwidget%2F1%2Fresults&ul=en-us&de=UTF-8&dt=Au%20Bureau%20Langon%20-%20R%C3%A9servation%20en%20ligne&sd=24-bit&sr=1920x1080&vp=1903x577&je=0&_u=QACAAAABAAAAACAAIC~&jid=1623470747&gjid=1025559277&cid=479577671.1718879981&tid=UA-22861302-18&_gid=1700392084.1718879981&_r=1&_slc=1&cd1=355996&z=1645806945")
            .headers(headers_249),
          http("request_250")
            .post(uri05 + "?t=dc&aip=1&_r=3&v=1&_v=j101&tid=UA-22861302-18&cid=479577671.1718879981&jid=1623470747&gjid=1025559277&_gid=1700392084.1718879981&_u=QACAAAAAAAAAACAAIC~&z=19034810")
            .headers(headers_250),
          http("request_251")
            .post("/g/collect?v=2&tid=G-PK649CS15L&gtm=45je46h0v899082457z8899072103za200zb899072103&_p=1718880297268&_gaz=1&gcd=13l3lPl2l1&npa=1&dma_cps=sypham&dma=1&tag_exp=0&cid=479577671.1718879981&ul=en-us&sr=1920x1080&uaa=x86&uab=64&uafvl=Not%252FA)Brand%3B8.0.0.0%7CChromium%3B126.0.6478.63%7CGoogle%2520Chrome%3B126.0.6478.63&uamb=0&uam=&uap=Windows&uapv=15.0.0&uaw=0&frm=0&pscdl=noapi&_s=1&sid=1718879981&sct=1&seg=1&dl=https%3A%2F%2Fbookings.zenchef.com%2Fresults%3Frid%3D355996%26pid%3D1001&dr=https%3A%2F%2Frestaurants.aubureau.fr%2F&dt=Au%20Bureau%20Langon%20-%20R%C3%A9servation%20en%20ligne&en=page_view&tfd=2323&_z=sendBeacon")
            .headers(headers_251),
          http("request_252")
            .post("/g/collect?v=2&tid=G-PK649CS15L&gtm=45je46h0v899082457za200zb899072103&_p=1718880297268&gcd=13l3lPl2l1&npa=1&dma_cps=sypham&dma=1&tag_exp=0&cid=479577671.1718879981&ul=en-us&sr=1920x1080&uaa=x86&uab=64&uafvl=Not%252FA)Brand%3B8.0.0.0%7CChromium%3B126.0.6478.63%7CGoogle%2520Chrome%3B126.0.6478.63&uamb=0&uam=&uap=Windows&uapv=15.0.0&uaw=0&frm=0&pscdl=noapi&_eu=AEA&_s=2&sid=1718879981&sct=1&seg=1&dl=https%3A%2F%2Fbookings.zenchef.com%2Fresults%3Frid%3D355996%26pid%3D1001&dr=https%3A%2F%2Frestaurants.aubureau.fr%2F&dt=Au%20Bureau%20Langon%20-%20R%C3%A9servation%20en%20ligne&en=scroll&epn.percent_scrolled=90&_et=31&tfd=2652&_z=sendBeacon")
            .headers(headers_251),
          http("request_253")
            .get(uri12 + "?t=sr&aip=1&_r=4&slf_rd=1&v=1&_v=j101&tid=UA-22861302-18&cid=479577671.1718879981&jid=1623470747&_u=QACAAAAAAAAAACAAIC~&z=900563475")
            .headers(headers_81),
          http("request_254")
            .get(uri12 + "?v=1&t=sr&slf_rd=1&_r=4&tid=G-PK649CS15L&cid=479577671.1718879981&gtm=45je46h0v899082457z8899072103za200zb899072103&aip=1&dma=1&dma_cps=sypham&gcd=13l3lPl2l1&npa=1&frm=0&z=1296656958")
            .headers(headers_81),
          http("request_255")
            .get(uri08 + "?t=sr&aip=1&_r=4&slf_rd=1&v=1&_v=j101&tid=UA-22861302-18&cid=479577671.1718879981&jid=1623470747&_u=QACAAAAAAAAAACAAIC~&z=900563475")
            .headers(headers_81)
        ),
      pause(1),
      http("request_256")
        .get(uri02 + "/getAvailabilities?restaurantId=355996&date_begin=2024-06-28&date_end=2024-06-28")
        .headers(headers_244)
        .resources(
          http("request_257")
            .get(uri02 + "/getCommentSpecific?restaurantId=355996&date=2024-06-28")
            .headers(headers_244)
        ),
      pause(2),
      http("request_258")
        .post("/g/collect?v=2&tid=G-PK649CS15L&gtm=45je46h0v899082457z8899072103za200zb899072103&_p=1718880297268&gcd=13l3lPl2l1&npa=1&dma_cps=sypham&dma=1&tag_exp=0&cid=479577671.1718879981&ul=en-us&sr=1920x1080&uaa=x86&uab=64&uafvl=Not%252FA)Brand%3B8.0.0.0%7CChromium%3B126.0.6478.63%7CGoogle%2520Chrome%3B126.0.6478.63&uamb=0&uam=&uap=Windows&uapv=15.0.0&uaw=0&frm=0&pscdl=noapi&_s=3&sid=1718879981&sct=1&seg=1&dl=https%3A%2F%2Fbookings.zenchef.com%2Fresults%3Frid%3D355996%26pid%3D1001&dr=https%3A%2F%2Frestaurants.aubureau.fr%2F&dt=Au%20Bureau%20Langon%20-%20R%C3%A9servation%20en%20ligne&en=open_calendar&ep.restaurant_id=355996&epn.pax=2&ep.partner=1001&ep.date=2024-06-20&ep.booking_type=standard&_et=291&tfd=7663&_z=sendBeacon")
        .headers(headers_251)
        .resources(
          http("request_259")
            .get(uri13 + "/collect?v=1&_v=j101&a=728868600&t=pageview&_s=2&dl=https%3A%2F%2Fbookings.zenchef.com%2Fresults%3Frid%3D355996%26pid%3D1001&dr=https%3A%2F%2Frestaurants.aubureau.fr%2F&dp=bookingwidget%2F5%2Ffill_form&ul=en-us&de=UTF-8&dt=Au%20Bureau%20Langon%20-%20R%C3%A9servation%20en%20ligne&sd=24-bit&sr=1920x1080&vp=1903x577&je=0&_u=SACAAAABAAAAACAAIC~&jid=&gjid=&cid=479577671.1718879981&tid=UA-22861302-18&_gid=1700392084.1718879981&cd1=355996&z=1300436443")
            .headers(headers_174),
          http("request_260")
            .options(uri22 + "/")
            .headers(headers_239),
          http("request_261")
            .post(uri22 + "/")
            .headers(headers_261)
            .body(RawFileBody("aubureau/0261_request.json"))
        ),
      pause(5),
      http("request_262")
        .post("/g/collect?v=2&tid=G-PK649CS15L&gtm=45je46h0v899082457za200zb899072103&_p=1718880297268&gcd=13l3lPl2l1&npa=1&dma_cps=sypham&dma=1&tag_exp=0&cid=479577671.1718879981&ul=en-us&sr=1920x1080&uaa=x86&uab=64&uafvl=Not%252FA)Brand%3B8.0.0.0%7CChromium%3B126.0.6478.63%7CGoogle%2520Chrome%3B126.0.6478.63&uamb=0&uam=&uap=Windows&uapv=15.0.0&uaw=0&frm=0&pscdl=noapi&_eu=AEA&_s=4&dl=https%3A%2F%2Fbookings.zenchef.com%2Fform%3Frid%3D355996%26pid%3D1001&dr=https%3A%2F%2Fbookings.zenchef.com%2Fresults%3Frid%3D355996%26pid%3D1001&sid=1718879981&sct=1&seg=1&dt=Au%20Bureau%20Langon%20-%20R%C3%A9servation%20en%20ligne&en=page_view&_et=6362&tfd=14021&_z=sendBeacon")
        .headers(headers_251),
      pause(79),
      http("request_263")
        .options(uri02 + "/booking?restaurantId=355996")
        .headers(headers_263)
        .resources(
          http("request_264")
            .post(uri02 + "/booking?restaurantId=355996")
            .headers(headers_264)
            .body(RawFileBody("aubureau/0264_request.json")),
          http("request_265")
            .get(uri13 + "/collect?v=1&_v=j101&a=728868600&t=pageview&_s=4&dl=https%3A%2F%2Fbookings.zenchef.com%2Fresults%3Frid%3D355996%26pid%3D1001&dr=https%3A%2F%2Frestaurants.aubureau.fr%2F&dp=bookingwidget%2F7%2Fthank_you&ul=en-us&de=UTF-8&dt=Au%20Bureau%20Langon%20-%20R%C3%A9servation%20en%20ligne&sd=24-bit&sr=1920x1080&vp=1903x577&je=0&_u=SACAAAABAAAAACAAIC~&jid=&gjid=&cid=479577671.1718879981&tid=UA-22861302-18&_gid=1700392084.1718879981&cd1=355996&z=645025319")
            .headers(headers_174),
          http("request_266")
            .post(uri13 + "/j/collect?v=1&_v=j101&a=728868600&t=pageview&_s=3&dl=https%3A%2F%2Fbookings.zenchef.com%2Fresults%3Frid%3D355996%26pid%3D1001&dr=https%3A%2F%2Frestaurants.aubureau.fr%2F&dp=bookingwidget%2F6%2Fsubmit_form&ul=en-us&de=UTF-8&dt=Au%20Bureau%20Langon%20-%20R%C3%A9servation%20en%20ligne&sd=24-bit&sr=1920x1080&vp=1903x577&je=0&_u=SACAAAABAAAAACAAIC~&jid=1690229406&gjid=1439556791&cid=479577671.1718879981&tid=UA-22861302-18&_gid=1700392084.1718879981&_r=1&cd1=355996&z=1867653770")
            .headers(headers_249),
          http("request_267")
            .post("/g/collect?v=2&tid=G-PK649CS15L&gtm=45je46h0v899082457z8899072103za200zb899072103&_p=1718880297268&_gaz=1&gcd=13l3lPl2l1&npa=1&dma_cps=sypham&dma=1&tag_exp=0&cid=479577671.1718879981&ul=en-us&sr=1920x1080&uaa=x86&uab=64&uafvl=Not%252FA)Brand%3B8.0.0.0%7CChromium%3B126.0.6478.63%7CGoogle%2520Chrome%3B126.0.6478.63&uamb=0&uam=&uap=Windows&uapv=15.0.0&uaw=0&frm=0&pscdl=noapi&_s=5&sid=1718879981&sct=1&seg=1&dl=https%3A%2F%2Fbookings.zenchef.com%2Fform%3Frid%3D355996%26pid%3D1001&dr=https%3A%2F%2Fbookings.zenchef.com%2Fresults%3Frid%3D355996%26pid%3D1001&dt=Au%20Bureau%20Langon%20-%20R%C3%A9servation%20en%20ligne&en=booking_created&_c=1&epn.0=0&ep.restaurant_id=355996&epn.pax=2&ep.partner=1001&ep.hour=12%3A00&ep.date=2024-06-28&ep.booking_type=standard&_et=80044&tfd=94629&_z=sendBeacon")
            .headers(headers_251),
          http("request_268")
            .get(uri12 + "?v=1&t=sr&slf_rd=1&_r=4&tid=G-PK649CS15L&cid=479577671.1718879981&gtm=45je46h0v899082457z8899072103za200zb899072103&aip=1&dma=1&dma_cps=sypham&gcd=13l3lPl2l1&npa=1&frm=0&z=1934003453")
            .headers(headers_81),
          http("request_269")
            .post(uri05 + "?t=dc&aip=1&_r=3&v=1&_v=j101&tid=UA-22861302-18&cid=479577671.1718879981&jid=1690229406&gjid=1439556791&_gid=1700392084.1718879981&_u=SACAAAABAAAAACAAIC~&z=2025408403")
            .headers(headers_250),
          http("request_270")
            .get(uri08 + "?t=sr&aip=1&_r=4&slf_rd=1&v=1&_v=j101&tid=UA-22861302-18&cid=479577671.1718879981&jid=1690229406&_u=SACAAAABAAAAACAAIC~&z=1970633135")
            .headers(headers_81),
          http("request_271")
            .get(uri12 + "?t=sr&aip=1&_r=4&slf_rd=1&v=1&_v=j101&tid=UA-22861302-18&cid=479577671.1718879981&jid=1690229406&_u=SACAAAABAAAAACAAIC~&z=1970633135")
            .headers(headers_81),
          http("request_272")
            .options(uri22 + "/")
            .headers(headers_239),
          http("request_273")
            .post(uri22 + "/")
            .headers(headers_273)
            .body(RawFileBody("aubureau/0273_request.json"))
        ),
      pause(5),
      http("request_274")
        .post("/g/collect?v=2&tid=G-PK649CS15L&gtm=45je46h0v899082457za200zb899072103&_p=1718880297268&gcd=13l3lPl2l1&npa=1&dma_cps=sypham&dma=1&tag_exp=0&cid=479577671.1718879981&ul=en-us&sr=1920x1080&uaa=x86&uab=64&uafvl=Not%252FA)Brand%3B8.0.0.0%7CChromium%3B126.0.6478.63%7CGoogle%2520Chrome%3B126.0.6478.63&uamb=0&uam=&uap=Windows&uapv=15.0.0&uaw=0&frm=0&pscdl=noapi&_eu=AEA&_s=6&dl=https%3A%2F%2Fbookings.zenchef.com%2Fthank_you%3Frid%3D355996%26pid%3D1001&dr=https%3A%2F%2Fbookings.zenchef.com%2Fform%3Frid%3D355996%26pid%3D1001&sid=1718879981&sct=1&seg=1&dt=Au%20Bureau%20Langon%20-%20R%C3%A9servation%20en%20ligne&en=page_view&_et=1171&tfd=100811&_z=sendBeacon")
        .headers(headers_251)
    );

  {
	  setUp(scn.injectOpen(atOnceUsers(1))).protocols(httpProtocol);
  }
}
