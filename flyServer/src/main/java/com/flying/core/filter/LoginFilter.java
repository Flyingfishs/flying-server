package com.flying.core.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by giles on 2016/1/10.
 *
 */
@WebFilter(filterName="LoginFilter",urlPatterns={"*.html","*.json"},asyncSupported=true
,initParams={
    /*@WebInitParam(name ="EXCLUDED_PAGES" , value = "")*/
})
public class LoginFilter extends OncePerRequestFilter {

    private static Logger log = LoggerFactory.getLogger(LoginFilter.class);


    /**
     * 例外页面;
     */
    List<String> EXCLUDED_PAGES = Arrays.asList(new String[]{});

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse resp, FilterChain fc) throws ServletException, IOException {
        try{
            log.debug("in doFilterInternal");
            resp.addHeader("Pragma", "no-cache");
            resp.addHeader("Cache-Control", "no-cache");
            //resp.addHeader("Expires", "Thu,01 Jan 1970 00:00:01 GMT");
            String reqUrl = req.getRequestURI();
            req.setAttribute("reqUrl",reqUrl);
            String refererUrl=req.getHeader("referer");
            req.setAttribute("refererUrl",refererUrl);
            log.debug("reqURL =" + reqUrl + " ,refererUrl =" + refererUrl);

            if (!(req instanceof HttpServletRequest)) {
                fc.doFilter(req, resp);
                return;
            }
            //--例外;
            for(String u : EXCLUDED_PAGES){
                if(reqUrl.indexOf(u)>-1){
                    fc.doFilter(req, resp);
                    //log.info("reqUrl is exclued:{}",reqUrl);
                    return;
                }
            }

            // clear session if session id in URL
            if (req.isRequestedSessionIdFromURL()) {
                HttpSession session = req.getSession();
                if (session != null) session.invalidate();
            }

            //wrap response to remove URL encoding
            HttpServletResponseWrapper wrappedResponse = new HttpServletResponseWrapper(resp) {
                @Override
                public String encodeRedirectURL(String url) {
                    return url;
                }

                @Override
                public String encodeURL(String url) {
                    return url;
                }
            };

            fc.doFilter(req, resp);
        }catch (Exception e){
            log.error("LoginFilter error:",e);
        }
    }

}
