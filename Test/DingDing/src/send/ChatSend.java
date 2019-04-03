package send;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class ChatSend {
    public static String WEBHOOK_TOKEN = "https://oapi.dingtalk.com/robot/send?access_token=718c2f5cc5e7911ff4ab149c6e0ae524912fcc42cc98ed37f794c73b25be831b";

    public static void main(String args[]) throws Exception{

        HttpClient httpclient = HttpClients.createDefault();

        HttpPost httppost = new HttpPost(WEBHOOK_TOKEN);
        httppost.addHeader("Content-Type", "application/json; charset=utf-8");


        String msg = "主人们，吃饭咯";
        String textMsg = "{ \"msgtype\": \"text\", \"text\": {\"content\": \"" + msg + "\"},\"at\":{\"isAtAll\":true} }";

        StringEntity se = new StringEntity(textMsg, "utf-8");
        httppost.setEntity(se);

        HttpResponse response = httpclient.execute(httppost);
        if (response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
            String result= EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println(result);
        }
    }
}
