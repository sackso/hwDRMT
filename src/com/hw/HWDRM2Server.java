package com.hw;

import java.io.FileOutputStream;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class HWDRM2Server implements HWDRM2IF {
	public HWDRM2Server() {
	}

	public void go(HWDRM2Server obj) {
		this.startServer(obj);
	}

	private void startServer(HWDRM2Server obj) {
		try {
			HWDRM2IF stub = (HWDRM2IF) UnicastRemoteObject.exportObject(obj, 0);

			Registry registry = LocateRegistry.getRegistry();
			registry.bind("HWDRM2IF", stub);
			System.out.println("Server ready");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		HWDRM2Server obj = new HWDRM2Server();

		obj.go(obj);
	}

	@Override
	public void setFiles(HWNetFileUtil[] info) throws RemoteException { // 클라이언트가 호출할 서버측의 메소드
		FileOutputStream fout = null;
		String dir = "C:/tempdata/";
		for (int i = 0; i < info.length; i++) {
			try {
				fout = new FileOutputStream(dir + info[i].getFilename());
				fout.write(info[i].getFiledata()); // 클라이언트에서 전달한 파일데이터(byte[])를 서버측의 디스크에 기록한다.
				fout.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//기록한 파일을 DRM 해제
		
		
	}

}