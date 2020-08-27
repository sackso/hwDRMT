package com.hw;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HWDRM2Client {

	private HWDRM2Client() {

	}

	public void go() {
		HWDRM2IF stub = this.getRegistry();
		
		try {
			File[] f = new File[1];
			f[0] = new File("C:\\Project\\workspace\\20200824_ws.code-workspace");

			HWNetFile[] finfo = new HWNetFile[1];
			for (int i = 0; i < f.length; i++) { // 1���� ������ �о byte[]�� ��Ƽ� ������ �޼ҵ忡 �����ϸ� �ȴ�.
				int len = (int) f[i].length();
				FileInputStream fin = new FileInputStream(f[i]);
				byte[] data = new byte[len];
				fin.read(data);
				finfo[i] = new HWNetFile();
				finfo[i].setFilename(f[i].getName());
				finfo[i].setFiledata(data);
			}

			//DRM ������ ������ ���Ϲ���
			HWNetFile[] retInfo =  stub.setFiles(finfo);
			
			

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

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
