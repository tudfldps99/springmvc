package hello.springmvc.basic.request;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@Slf4j
@RestController
public class RequestHeaderController {
    
    @RequestMapping("/headers")
    public String headers(HttpServletRequest request,
                          HttpServletResponse response,
                          HttpMethod httpMethod,            // HTTP 메서드를 조회 org.springframework.http.HttpMethod
                          Locale locale,                    // Locale 정보(언어 정보) 조회
                          @RequestHeader MultiValueMap<String, String> headerMap,   // 모든 HTTP 헤더를 MultiValueMap 형식으로 조회
                          @RequestHeader("host") String host,                       // 특정 HTTP 헤더를 조회
                          @CookieValue(value = "myCookie", required = false) String cookie) {       // 특정 쿠키를 조회
        
        // http://localhost:8080/headers
        log.info("request={}", request);            // request=org.apache.catalina.connector.RequestFacade@605242fd
        log.info("response={}", response);          // response=org.springframework.web.context.request.async.StandardServletAsyncWebRequest$LifecycleHttpServletResponse@48844fde
        log.info("httpMethod={}", httpMethod);      // httpMethod=GET
        log.info("locale={}", locale);              // locale=ko_KR
        log.info("headerMap={}", headerMap);        // headerMap={host=[localhost:8080], connection=[keep-alive], sec-ch-ua=["Not/~
        log.info("header host={}", host);           // header host=localhost:8080
        log.info("myCookie={}", cookie);            // myCookie=null

        return "ok";

        /* @Slf4j
            다음 코드를 자동으로 생성해서 로그를 선언해줌. 개발자는 편리하게 log 라고 사용하면 됨
             private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(RequestHeaderController.class);
         */

        /* MultiValueMap
            - Map과 유사한데, 하나의 키에 여러 값을 받을 수 있음
            - HTTP header, HTTP 쿼리 파라미터와 같이 하나의 키에 여러 값을 받을 때 사용한다.
         */
    }
}
