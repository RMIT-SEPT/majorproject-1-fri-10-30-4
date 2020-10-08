package app.security;

public class SecurityContants {
    public static final String SIGN_UP_URLS = "/customer/register";
    public static final String CUSTOMER_URLS = "/customer/**";
    public static final String TEST = "/debug/testData";
    public static final String WEBSITE ="/**";
    public static final String LOGIN_URL = "/login";
    public static final String H2_URL = "h2-console/**";
    public static final String SECRET ="SecretKeyToGenJWTs";
    public static final String TOKEN_PREFIX= "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final long EXPIRATION_TIME = 30_000; //30 seconds
}
