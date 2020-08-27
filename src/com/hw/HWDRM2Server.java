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
	public HWNetFile[] setFiles(HWNetFile[] infos) throws RemoteException { // 클라이언트가 호출할 서버측의 메소드
		HWNetFile[] nInfos = HWNetFileUtil.recvFileToMake("C:/tempdata/server/",infos);
		
		return nInfos;
		
	}

}