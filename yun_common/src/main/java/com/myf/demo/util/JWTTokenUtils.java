package com.myf.demo.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.Map;

/**
 * @ClassName com.myf.demo.util JWTTokenUtils
 * @Description jwt工具类
 * @Author Afengis
 * @Date 2021/4/21 16:32
 * @Version V1.0
 **/
public class JWTTokenUtils {

    static SignatureAlgorithm sa = SignatureAlgorithm.HS256;//使用hs256算法

    //获取key
    private static Key generatorKey() {
        byte[] bin = DatatypeConverter.parseBase64Binary("2521afcf18c749c1a8a7615c03d15e43");
        Key key = new SecretKeySpec(bin, sa.getJcaName());
        return key;
    }

    /**
     * 将传过来的信息按照 Header，Payload，Signature 的方式组装一个字符串
     *
     * @param payLoad    可以存放用户信息
     * @param expireTime 过期时间
     * @return
     */
    public static String generatorToken(Map<String, Object> payLoad, Date expireTime) {

        ObjectMapper objectMapper = new ObjectMapper();
 
        try {

            String jwt = Jwts.builder()
                    .setPayload(objectMapper.writeValueAsString(payLoad))
                    .signWith(sa, generatorKey())
                    .setExpiration(expireTime)
                    .compact();
            return jwt;

        } catch (JsonProcessingException e) {

            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 将token解析，得到Payload内容
     *
     * @param token
     * @return
     */
    public static Claims phaseToken(String token) {
        //将token解析成claims
        Jws<Claims> jws = Jwts.parser().setSigningKey(generatorKey()).parseClaimsJws(token);

//        jws.getHeader();    Header
//        jws.getBody();      Payload
//        jws.getSignature(); Signature

        return jws.getBody();
    }
}
