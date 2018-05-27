package com.niu.core;

import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.baidu.aip.face.AipFace;
import com.baidu.aip.util.Base64Util;
import com.niu.utils.AipFaceSingleInstance;
import com.niu.utils.FileUtil;

public class FaceCore {
	static Logger  logger=Logger.getLogger(AipFaceSingleInstance.class);
	/*人脸检测**/
	public static void faceDetect(AipFace client) {
	    // 传入可选参数调用接口
	    HashMap<String, String> options = new HashMap<String, String>();
	    options.put("face_field", "age");
	    options.put("max_face_num", "2");
	    options.put("face_type", "LIVE");
	    byte[] bytes=null;
		try {
			bytes = FileUtil.readFileByBytes("D:/test.jpg");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String image = Base64Util.encode(bytes);
	    String imageType = "BASE64";
	    
	    // 人脸检测
	    JSONObject res = client.detect(image, imageType, options);
	    logger.info(res.toString(2));
	}
}
