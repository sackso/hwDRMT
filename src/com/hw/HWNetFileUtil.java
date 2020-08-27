package com.hw;

import java.io.FileOutputStream;
import java.io.Serializable;

public class HWNetFileUtil implements Serializable {

	/**
	 * ������ �޾� ������
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
				fout.write(retInfo[i].getFiledata()); // Ŭ���̾�Ʈ���� ������ ���ϵ�����(byte[])�� �������� ��ũ�� ����Ѵ�.
				fout.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return retInfo;
	}
	
	public static HWNetFile[] makeDecryptDRM(String dirName,HWNetFile[] retInfo) {
		HWNetFile[] nInfos =  recvFileToMake(dirName,retInfo);
		
		//DRM ���� ó��
		return nInfos;
	}
}
