package com.wq.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * JWT工具类
 *
 * @author dengweiping
 * @date 2021/1/8 16:18
 */
public class JwtUtil {

    // token 签名秘钥
    private static final String SECRET_KEY = "secretKey:1deNgweIPiNg994IsCoOL2223";
    // token过期时间
    private static final long TOKEN_EXPIRE_TIME = 30 * 60 * 1000;

    public static final String LOGIN_URL = "/auth/login";

    /**
     * 生成jwt
     */
    public static String createJwt(String userName) {
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
        //设置头信息
        HashMap<String, Object> header = new HashMap<>(2);
        header.put("typ", "JWT");
        header.put("alg", "HS256");
        // 生成 token：头部+载荷+签名
        return JWT.create().withHeader(header)
                .withClaim("user", userName)
                .withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRE_TIME)).sign(algorithm);
    }

    public static boolean checkToken(String token){
        try {
            verifyToken(token);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 验证Token
     *
     * @param token
     * @return
     * @throws Exception
     */
    private static Map<String, Claim> verifyToken(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET_KEY)).build();
        DecodedJWT jwt = null;
        try {
            jwt = verifier.verify(token);
        } catch (Exception e) {
            throw new RuntimeException("令牌无效，请重新登录");
        }
        return jwt.getClaims();
    }

    /**
     * 解析Token
     *
     * @param token
     * @return
     */
    public static Map<String, Claim> parseToken(String token) {
        DecodedJWT decodedJWT = JWT.decode(token);
        return decodedJWT.getClaims();
    }


}
