import com.google.gson.Gson;
import com.google.gson.*;
import jdk.nashorn.internal.parser.JSONParser;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by deadlock on 5/7/16.
 */
public class CommonWrappers {

    public static void printError() {

    }

    public static void printSuccess() {

    }

    public static Config getConfig() throws IOException {
        String json = FileUtils.readFileToString(new File("../common/conf.json"));
        JsonObject conf = new JsonParser().parse(json).getAsJsonObject();
        Config config = new Config();
        config.APP_KEY = conf.get("APP_KEY").getAsString();
        config.APP_SECRET = conf.get("APP_SECRET").getAsString();
        config.FACEBOOK_TOKEN = conf.get("SERVICE_TOKENS").getAsJsonObject().get("FACEBOOK").getAsString();
        config.TWITTER_TOKEN = conf.get("SERVICE_TOKENS").getAsJsonObject().get("TWITTER").getAsString();
        return config;
    }
}
