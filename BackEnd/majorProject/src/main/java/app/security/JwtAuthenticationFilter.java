package app.security;

import app.entity.user.BusinessAdmin;
import app.entity.user.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

import static app.security.SecurityContants.HEADER_STRING;
import static app.security.SecurityContants.TOKEN_PREFIX;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private CustomerDetailsService customerDetailsService;

    @Autowired
    private BusinessAdminDetailsService businessAdminDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {

        try {
            String jwt = getJWTFromRequest(httpServletRequest);
            if(StringUtils.hasText(jwt)&& tokenProvider.validateToken(jwt)){
                Long userId = tokenProvider.getUserIdFromJWT(jwt);
                Customer customerDetails = customerDetailsService.loadCustomerById(userId);
                UsernamePasswordAuthenticationToken authentication = new
                            UsernamePasswordAuthenticationToken(customerDetails, null, Collections.emptyList());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            try{
                String jwt2 = getJWTFromRequest(httpServletRequest);
                if(StringUtils.hasText(jwt2)&& tokenProvider.validateToken(jwt2)) {
                    Long userId = tokenProvider.getUserIdFromJWT(jwt2);
                    BusinessAdmin businessAdmin = businessAdminDetailsService.loadAdminById(userId);
                    UsernamePasswordAuthenticationToken authentication = new
                            UsernamePasswordAuthenticationToken(businessAdmin, null, Collections.emptyList());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            } catch (Exception ex2){

            }
        }catch (Exception ex1){
            logger.error("Could not set user authentication in security context", ex1);
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }



    private String getJWTFromRequest(HttpServletRequest request){
        String bearerToken = request.getHeader(HEADER_STRING);

        if(StringUtils.hasText(bearerToken)&&bearerToken.startsWith(TOKEN_PREFIX)){
            return bearerToken.substring(7, bearerToken.length());
        }

        return null;
    }
}
