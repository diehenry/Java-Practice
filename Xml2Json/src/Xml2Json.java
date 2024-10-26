import org.json.* ;

import java.io.*;

public class Xml2Json {

    private String xml = "<note name=\"noteName\">\n" +
            "  <to>Tove</to>\n" +
            "  <from>Jani</from>\n" +
            "  <heading>Reminder</heading>\n" +
            "  <body>Don't forget me this weekend!</body>\n" +
            "</note>";

    public void xml2Json(){
        try {
            ObjectInputStream os = new ObjectInputStream(
                    new FileInputStream(new File("")));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject xmlJSONObj = XML.toJSONObject(xml);
        //設定縮排(空4格)
        String jsonPrettyPrintString = xmlJSONObj.toString(4);
        //輸出格式化後的json
        System.out.println(jsonPrettyPrintString);
    }
}
