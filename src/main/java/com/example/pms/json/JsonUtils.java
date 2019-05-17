package com.example.pms.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ResourceUtils;

import java.io.*;

public class JsonUtils {
    private static ResourceLoader resourceLoader = new DefaultResourceLoader();

    public static String readFile() {
        BufferedReader reader = null;
        String laststr = "";
        try {
            Resource resource = resourceLoader.getResource("classpath:fields.json");
            InputStreamReader inputStreamReader = new InputStreamReader(resource.getInputStream(), "UTF-8");
            reader = new BufferedReader(inputStreamReader);
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                laststr += tempString;
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return laststr;
    }

    public static JSONObject stringToJSONObject(String jsonString, String entity) {
        if (jsonString == null || entity == null)
            return new JSONObject();
        JSONObject jsonObject = JSON.parseObject(jsonString);
        return jsonObject.getJSONObject(entity);
    }

}
