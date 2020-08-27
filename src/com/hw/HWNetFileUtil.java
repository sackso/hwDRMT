package com.hw;

import java.io.FileOutputStream;
import java.io.Serializable;

public class HWNetFileUtil implements Serializable {

	/**
	 * 파일을 받아 생성함
	 * @param dirName
	 * @param retInfo
	 * @return 
	 */
	public static HWNetFile[] recvFileToMake(String dirName,HWNetFile[] retInfo) {
		System.out.println("HWNetFileUtil.recvFileToMake()");
		FileOutputStream fout = null;
		String dir = "C:/tempdata/client/";
		for (int i = 0; i < retInfo.length; i++) {
			try {
				fout = new FileOutputStream(dir + retInfo[i].getFilename());
				fout.write(retInfo[i].getFiledata()); // 클라이언트에서 전달한 파일데이터(byte[])를 서버측의 디스크에 기록한다.
				fout.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return retInfo;
	}
	
	public static HWNetFile[] makeDecryptDRM(String dirName,HWNetFile[] retInfo) {
		HWNetFile[] nInfos =  recvFileToMake(dirName,retInfo);
		
		//DRM 해제 처리
		return nInfos;
	}
}
