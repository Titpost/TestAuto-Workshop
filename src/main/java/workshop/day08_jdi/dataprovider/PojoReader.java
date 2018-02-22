package workshop.day08_jdi.dataprovider;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PojoReader {

    public static List<Pojo> readWithGson(String jsonString) {

        return new Gson()
                .fromJson(jsonString, new TypeToken<ArrayList<Pojo>>(){}.getType() );
    }

    public static String readData() {
        return new BufferedReader(
                new InputStreamReader(
                        PojoReader.class
                                .getResourceAsStream("/data/ex8_jdi_metalsColorsDataSet.json")))
                .lines()
                .collect(Collectors.joining());
    }
}
