package com.online.videostreaming.classrooms.onlineclassrooms.captcha.exception;

import java.util.Calendar;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.security.core.AuthenticationException;
import org.springframework.util.CollectionUtils;

public class CaptchaAuthenticationException extends AuthenticationException {

	private final static String jsonPayload = "{\"message\" : \"%s\", \"timestamp\" : \"%s\" }";
	
	private static final long serialVersionUID = 1L;
	private static EnumMap<Type, String> msgTypes = new EnumMap<Type, String>(Stream.of(Type.values())
            .collect(Collectors.toMap(e -> e, Type::name)));

    public enum Type {
        WRONG_CAPTCHA
    }

    public static void setMsgTypes(Map<Type, String> map) {
        if (CollectionUtils.isEmpty(map) ||
                !Stream.of(Type.values()).allMatch(e -> map.keySet().contains(e))) {
            throw new IllegalArgumentException("illegal map " + map);
        }
        msgTypes = new EnumMap<>(map);
    }

    public static String typeMsg(Type type) {
        return msgTypes.get(type);
    }

    public CaptchaAuthenticationException(Type type) {
        super(String.format(jsonPayload, typeMsg(type), Calendar.getInstance().getTime()) );
    }

    public CaptchaAuthenticationException(String message) {
        super(String.format(jsonPayload, message, Calendar.getInstance().getTime()));
    }
}
