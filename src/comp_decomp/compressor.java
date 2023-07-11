package comp_decomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class compressor {
    public static void method(File file) throws IOException {
        String fileDirectory = file.getParent();      //coz i want to save the o/p file in the same folder

        FileInputStream fis = new FileInputStream(file);               //help me to reading the data
        FileOutputStream fos = new FileOutputStream(fileDirectory +"/CompressedFile.gz");       //write a compress data
        GZIPOutputStream gzip = new GZIPOutputStream(fos);       //contain final output data,i.e compressed data

        byte[] buffer= new byte[1024];
        int len;

        while((len = fis.read(buffer)) != -1) {         // it read input file
            gzip.write(buffer, 0, len);
        }

        gzip.close();
        fos.close();
        fis.close();

    }

    public static void main(String[] args) throws IOException {
        File path = new File("");
        method(path);
    }
}
