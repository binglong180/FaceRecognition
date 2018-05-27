package com.niu.test;

import com.baidu.aip.face.AipFace;
import com.niu.core.FaceCore;
import com.niu.utils.AipFaceSingleInstance;

public class Mytest {
	 public static void main(String[] args) {
		 AipFace client1 = (AipFace) AipFaceSingleInstance.client;
		 AipFace client2 = AipFaceSingleInstance.getAipFace();
		 System.out.println(client1==client2);
	    }
}
