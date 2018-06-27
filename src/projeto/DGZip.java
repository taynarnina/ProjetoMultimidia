package Projeto;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class DGZip {

	public void doUnGzipFile(String Entrada, String Saida) {
		 
        GZIPInputStream gis = null;
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(Entrada);
            gis = new GZIPInputStream(fis);
            fos = new FileOutputStream(Saida+"\\arqui.txt");
            byte[] tmp = new byte[4*1024];
            int size = 0;
            while ((size = gis.read(tmp)) > 0) {
                fos.write(tmp, 0, size);
            }
            fos.flush();
            System.out.println("Done with uncompressng GZip file.");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try{
                if(gis != null) gis.close();
                if(fos != null) fos.close();
            } catch(Exception ex){}
        }
    }
}
