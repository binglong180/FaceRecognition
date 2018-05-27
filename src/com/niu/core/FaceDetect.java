package com.niu.core;

import java.util.HashMap;
import java.util.Map;

import com.baidu.aip.util.Base64Util;
import com.niu.utils.FileUtil;
import com.niu.utils.GsonUtils;
import com.niu.utils.HttpUtil;


public class FaceDetect {
	/**
	    * 重要提示代码中所需工具类
	    * FileUtil,Base64Util,HttpUtil,GsonUtils请从
	    * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
	    * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
	    * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
	    * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
	    * 下载
	    */
	    public static String detect() {
	        // 请求url
	        String url = "https://aip.baidubce.com/rest/2.0/face/v3/detect";
	        try {
	            Map<String, Object> map = new HashMap<>();
	            byte[] bytes = FileUtil.readFileByBytes("D:/test.jpg");
	            String image = Base64Util.encode(bytes);
				map.put("image",image);
	            map.put("face_field", "faceshape,facetype");
	            map.put("image_type", "BASE64");

	            String param = GsonUtils.toJson(map);

	            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
	            String accessToken = "24.c471d948d48110e589f576335a241342.2592000.1529745160.282335-11292282";

	            String result = HttpUtil.post(url, accessToken, "application/json", param);
	            System.out.println(result);
	            return result;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

	  
}
