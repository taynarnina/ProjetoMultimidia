package Projeto;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
 
public class GZip {
 
    public void doGzip(String Saida, String Entrada){
         
        FileOutputStream fos = null;
        GZIPOutputStream gos = null;
        FileInputStream fis = null;
        try {
            fos = new FileOutputStream(Saida);
            gos = new GZIPOutputStream(fos);
            fis = new FileInputStream(Entrada);
            byte[] tmp = new byte[4*1024];
            int size = 0;
            while ((size = fis.read(tmp)) != -1) {
                gos.write(tmp, 0, size);
            }
            gos.finish();
            System.out.println("Done with GZip...");
        } catch (IOException e) {
             
        } finally{
            try{
                if(fis != null) fis.close();
                if(gos != null) gos.close();
            } catch(Exception ex){}
        }
    }
}