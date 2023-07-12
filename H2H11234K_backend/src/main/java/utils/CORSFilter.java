package utils;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
///**
// * Servlet Filter implementation class CORSFilter
// */
//// Enable it for Servlet 3.x implementations
///* @ WebFilter(asyncSupported = true, urlPatterns = { "/*" }) */
//public class CORSFilter implements Filter {
//	/**
//	 * Default constructor.
//	 */
//	public CORSFilter() {
//		// TODO Auto-generated constructor stub
//	}
//	/**
//	 * @see Filter#destroy()
//	 */
//	public void destroy() {
//		// TODO Auto-generated method stub
//	}
//	/**
//	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
//	 */
//	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
//			throws IOException, ServletException {
//		
//		HttpServletRequest request = (HttpServletRequest) servletRequest;
//		System.out.println("CORSFilter HTTP Request: " + request.getMethod());
//		
//		// Authorize (allow) all domains to consume the content
//		
//		((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Origin", "*");
//		((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Methods","GET, OPTIONS, HEAD, PUT, POST");
//		HttpServletResponse resp = (HttpServletResponse) servletResponse;
//		
//		
//		// For HTTP OPTIONS verb/method reply with ACCEPTED status code -- per CORS handshake
//		if (request.getMethod().equals("OPTIONS")) {
//			resp.setStatus(HttpServletResponse.SC_ACCEPTED);
//			return;
//		}
//		// pass the request along the filter chain
//		chain.doFilter(request, servletResponse);
//	}
//	/**
//	 * @see Filter#init(FilterConfig)
//	 */
//	public void init(FilterConfig fConfig) throws ServletException {
//		// TODO Auto-generated method stub
//	}
//}





//@WebFilter(asyncSupported = true, urlPatterns = { "/*" })
public class CORSFilter implements Filter {

    private static final String[] allowedOrigins = {
            "http://localhost:3000", "http://localhost:5500", "http://localhost:5501",
            "http://127.0.0.1:3000", "http://127.0.0.1:5500", "http://127.0.0.1:5501"
    };

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

//        String requestOrigin = request.getHeader("Origin");
        
            // Authorize the origin, all headers, and all methods
            ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
            ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Headers", "*");
            ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Methods", "GET");
//                    "GET, OPTIONS, HEAD, PUT, POST, DELETE");

            HttpServletResponse resp = (HttpServletResponse) servletResponse;

            // CORS handshake (pre-flight request)
            if (request.getMethod().equals("OPTIONS")) {
                resp.setStatus(HttpServletResponse.SC_ACCEPTED);
                return;
            }
        
        // pass the request along the filter chain
        filterChain.doFilter(request, servletResponse);
    }
//
//    private boolean isAllowedOrigin(String origin){
//        for (String allowedOrigin : allowedOrigins) {
//            if(origin.equals(allowedOrigin)) return true;
//        }
//        return false;
//    }

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}