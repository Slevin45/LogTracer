package pro.smartum.app.business.security;

import java.util.HashMap;

/**
 * Created by eldar.s on 22.04.2016.
 */
public class SecurityContextHolder {
    private static final String USER_ID_PARAM = "USER_ID PARAM";
    private static final String TOKEN_PARAM = "TOKEN_PARAM";

    private static final ThreadLocal<HashMap<String, String>> threadLocal = new ThreadLocal<>();

    private static SecurityContextHolder securityContextHolder;

    private SecurityContextHolder() {

    }

    public static SecurityContextHolder getInstance() {
        synchronized (SecurityContextHolder.class) {
            if (securityContextHolder == null) {
                securityContextHolder = new SecurityContextHolder();
            }
            return securityContextHolder;
        }
    }

    public void putToken(String token) {
        HashMap<String, String> map = extractMap();
        map.put(TOKEN_PARAM, token);
        threadLocal.set(map);
    }

    public String getToken() {
        HashMap<String, String> map = extractMap();
        String token = map.get(TOKEN_PARAM);
        return token;
    }

    public int putUserId(int userId) {
        HashMap<String, String> map = extractMap();
        map.put(USER_ID_PARAM, String.valueOf(userId));
        threadLocal.set(map);
        return userId;
    }

    public Integer getUserId() {
        HashMap<String, String> map = extractMap();
        String userId = map.get(USER_ID_PARAM);
        if (userId == null)
            return null;
        else
            return Integer.parseInt(userId);
    }

    private HashMap<String, String> extractMap() {
        HashMap<String, String> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<>();
        }
        return map;
    }
}
