package com.hw;

import java.io.FileOutputStream;
import java.io.Serializable;

public class HWNetFile implements Serializable {

	private String filename;
	private byte[] filedata;

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public byte[] getFiledata() {
		return filedata;
	}

	public void setFiledata(byte[] filedata) {
		this.filedata = filedata;
	}
	
}
