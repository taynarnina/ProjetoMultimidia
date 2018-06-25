package projeto;

import java.io.IOException;

public class CompactaArquivo {

	public static void main(String args[]){
	       try {
	           Compactador.compactarParaZip("C:\\Users\\Taynar Sousa\\Desktop\\zipado.zip", "C:\\Users\\Taynar Sousa\\Desktop\\ArquivoASerZipado.txt");
	       } catch (IOException e) {
	           // TODO Auto-generated catch block
	           e.printStackTrace();
	       }
	   }
	
}