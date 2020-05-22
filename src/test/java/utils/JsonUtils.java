package utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import java.util.LinkedHashMap;
import java.util.List;

public class JsonUtils {

    public static JsonArray getJsonArrayFromList(List<LinkedHashMap> responseList) {
        JsonElement jsonElement = new Gson().toJsonTree(responseList, new TypeToken<List<LinkedHashMap>>() {}.getType());
        return jsonElement.getAsJsonArray();
    }
}
