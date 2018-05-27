package com.niu.utils;

import java.io.IOException;
import java.io.InputStream;

public class IoUtils {
	public static byte[] readBytes(InputStream in) throws IOException {  
	    //读取字节的缓冲
	    byte[] buffer = new byte[1024];
	    //最终的数据
	    byte[] result = new byte[0];
	    int size = 0;  
	    while ((size = in.read(buffer)) != -1) {  
	        int oldLen = result.length;
	        byte[] tmp = new byte[oldLen + size];
	        if (oldLen > 0) {//copy 旧字节
	            System.arraycopy(result, 0, tmp, 0, oldLen);
	        }
	        //copy 新字节
	        System.arraycopy(buffer, 0, tmp, oldLen, size);
	        
	        result = tmp;
	    }  
	    return result;
	} 
}
