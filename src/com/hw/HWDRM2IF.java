package com.hw;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HWDRM2IF extends Remote{
    

	HWNetFileUtil[] setFiles(HWNetFileUtil[] info) throws RemoteException;

}