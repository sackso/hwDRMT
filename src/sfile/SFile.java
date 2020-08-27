package sfile;

import java.io.File;


public class SFile{

    public SFile(){

    }

    public File getFileObject(String fileFullPath) throws Exception{
        File file = new File(fileFullPath);
        return file;
    }
}