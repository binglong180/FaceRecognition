package com.niu.utils;

import java.io.IOException;
import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.face.AipFace;
import com.baidu.aip.util.Base64Util;

public class Sample {
	 //设置APPID/AK/SK
    public static final String APP_ID = "11292282";
    public static final String API_KEY = "gXQTI6fWT5jmf22NbAg76acE";
    public static final String SECRET_KEY = "eoFUPDmi1NhyxC4hCZj1wm6TCbCeg5xy";


    public static void main(String[] args) {
        // 初始化一个AipFace
        AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
        //client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
        //client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");
        // 调用接口
        byte[] bytes=null;
		try {
			bytes = FileUtil.readFileByBytes("D:/test.jpg");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String image = Base64Util.encode(bytes);
        JSONObject res = client.detect(image,"BASE64", new HashMap<String, String>());
        System.out.println(res.toString(2));
        
    }
}
