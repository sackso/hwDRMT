package com.hw;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HWDRM2Client {

	String[] upFileNames;

	private HWDRM2Client() {
		
	}

	public void go() {
		HWDRM2IF stub = this.getRegistry();

		try {
			upFileNames = new String[] { "C:\\tempdata\\makeWatermarkPDF.py" };
			HWNetFile[] finfo = this.makeFileInfos();
			// DRM ������ ������ ���Ϲ���
			HWNetFile[] retInfo = stub.setFiles(finfo);

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	/**
	 * ���ϵ��� inputstream �� ��� ����
	 * @return
	 */
	private HWNetFile[] makeFileInfos() {
		System.out.println("HWDRM2Client.makeFileInfos()");
		HWNetFile[] finfo = null;

		try {
			File[] files = new File[upFileNames.length];
			for (int i = 0; i < files.length; i++) {
				files[i] = new File(upFileNames[i]);
			}

			finfo = new HWNetFile[upFileNames.length];
			for (int i = 0; i < files.length; i++) { // 1���� ������ �о byte[]�� ��Ƽ� ������ �޼ҵ忡 �����ϸ� �ȴ�.
				int len = (int) files[i].length();
				FileInputStream fin = new FileInputStream(files[i]);
				byte[] data = new byte[len];
				fin.read(data);
				finfo[i] = new HWNetFile();
				finfo[i].setFilename(files[i].getName());
				finfo[i].setFiledata(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return finfo;
	}

	/**
	 * �����κ��� class �� ����
	 * 
	 * @return
	 */
	private HWDRM2IF getRegistry() {

		HWDRM2IF stub = null;
		try {

			String host = null;
			System.out.println("host = " + host);
			Registry registry = LocateRegistry.getRegistry(host);

			stub = (HWDRM2IF) registry.lookup("HWDRM2IF");
			// call Hello.sayHello()
			// String response = stub.sayHello();
			// System.out.println("response: " + response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return stub;
	}

	public static void main(String[] args) throws Exception {
		String host = (args.length < 1) ? null : args[0];

		HWDRM2Client cli = new HWDRM2Client();
		cli.go();

	}
}
