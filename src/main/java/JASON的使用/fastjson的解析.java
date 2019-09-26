package JASON的使用;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 使用fastjson api
 *
 * public static final Object parse(String text); // 把JSON文本parse为JSONObject或者JSONArray 
 * public static final JSONObject parseObject(String text)； // 把JSON文本parse成JSONObject    
 * public static final <T> T parseObject(String text, Class<T> clazz); // 把JSON文本parse为JavaBean 
 * public static final JSONArray parseArray(String text); // 把JSON文本parse成JSONArray 
 * public static final <T> List<T> parseArray(String text, Class<T> clazz); //把JSON文本parse成JavaBean集合 
 * public static final String toJSONString(Object object); // 将JavaBean序列化为JSON文本 
 * public static final String toJSONString(Object object, boolean prettyFormat); // 将JavaBean序列化为带格式的JSON文本 
 * public static final Object toJSON(Object javaObject); 将JavaBean转换为JSONObject或者JSONArray。
 *
 *
 * 解析json
 */
public class fastjson的解析 {

    static String jsonStr = "{\"sites\":[{\"name\":\"蚂蚁课堂\",\"url\":\"www.itmayiedu.com\"},{\"name\":\"每特教育\",\"url\":\"http://meiteedu.com/\"}]}";

    public static void main(String[] args) {

        //解析json
        JSONObject jsObject = new JSONObject();
        // 将json字符串转为jsonbject
        JSONObject jsonStrObject = jsObject.parseObject(jsonStr);
        JSONArray jsonArray = jsonStrObject.getJSONArray("sites");
        for (Object object : jsonArray) {
            JSONObject stObject = (JSONObject) object;
            String name = stObject.getString("name");
            String url = stObject.getString("url");
            System.out.println(name + "---" + url);
        }


        //组装json
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray1 = new JSONArray();
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("name", "蚂蚁课堂");
        jsonObject1.put("url", "http://www.itmayiedu.com");
        jsonArray1.add(jsonArray1);
        jsonObject.put("sites",jsonObject1);
        System.out.println("组装的json "+jsonObject.toString());

    }
}
