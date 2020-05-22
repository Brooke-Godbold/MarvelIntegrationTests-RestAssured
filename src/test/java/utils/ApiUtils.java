package utils;

import org.apache.commons.codec.digest.DigestUtils;

public class ApiUtils {

    private static final String BASE_URI = "http://gateway.marvel.com";
    private static final String CHARACTERS_API = "/v1/public/characters";
    private static final String TIMESTAMP = "1";
    private static final String PUBLIC_API_KEY = "613c765803573ff01ea6ba18f88a013d";
    private static final String PRIVATE_API_KEY = "d21062d8458f43a5c50baa552f22178a3c4589d7";

    public static String getCharactersApi() {
        return BASE_URI + CHARACTERS_API;
    }

    public static String getTimestamp() {
        return TIMESTAMP;
    }

    public static String getKey() {
        return PUBLIC_API_KEY;
    }

    public static String getHash() {
        return generateHash();
    }

    private static String generateHash() {
        return DigestUtils.md5Hex(TIMESTAMP + PRIVATE_API_KEY + PUBLIC_API_KEY);
    }

}
