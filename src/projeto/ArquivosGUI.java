/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author danilo
 */
public class ArquivosGUI extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Compactador comp = new Compactador();
	Zip zip = new Zip();
	GZip gzip = new GZip();
	
	Descompactador des = new Descompactador();
	DZip dzip = new DZip();
	DGZip dgzip = new DGZip();
	
	/**
     * Creates new form ArquivosGUI
     */
    public ArquivosGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton1.setSelected(true);
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton4.setSelected(true);
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Projeto Multimidia");

        jLabel1.setText("Procurar Arquivo:");

        jLabel2.setText("Salvar Arquivo:");

        jButton1.setText("Procurar");
        
        jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser(); 
				int returnVal = chooser.showOpenDialog(null);
				if(returnVal == JFileChooser.APPROVE_OPTION) {   
					File arq = chooser.getSelectedFile().getAbsoluteFile();  
			        String caminho = arq.getPath();  
			        jTextField1.setText(caminho);
			    }
			}
		});

        jButton2.setText("Procurar");
        
        jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser arquivo = new JFileChooser();
		        arquivo.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		        int res = arquivo.showOpenDialog(null);
		        if(res == JFileChooser.APPROVE_OPTION) {   
		        	File diretorio = arquivo.getSelectedFile(); 
		        	String caminho = diretorio.getPath();
		        	if(jRadioButton2.isSelected()){
		        		jTextField2.setText(caminho+"\\zipado.gzip");
		        	}
		        	else {
		        		jTextField2.setText(caminho+"\\zipado.zip");
		        	}
			        
			    }
			}
		});

        jRadioButton1.setText("Zip");
        
        jRadioButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});

        jRadioButton2.setText("Gzip");

        jRadioButton3.setText("Deflate");

        jButton3.setText("Compactar");
        
        jButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File f1 = new File (jTextField1.getText());
				File f2 = new File (jTextField2.getText());
				try {
					if(jRadioButton1.isSelected()){
						zip.zipFile(jTextField2.getText(), jTextField1.getText());
						long tamanhoorig = f1.length();
						long tamanhosaid = f2.length();
						JOptionPane.showMessageDialog(null, "Compactado com sucesso!!!"+
								"\nTamanho do arquivo original: "+ tamanhoorig+" bytes"+
										"\n Tamanho do arquivo compactado: "+ tamanhosaid+" bytes"
										+"\n Taxa de bits:");
					}
					else if(jRadioButton2.isSelected()){
						gzip.doGzip(jTextField2.getText(), jTextField1.getText());
						long tamanhoorig = f1.length();
						long tamanhosaid = f2.length();
						JOptionPane.showMessageDialog(null, "Compactado com sucesso!!!"+
								"\nTamanho do arquivo original: "+ tamanhoorig+" bits"+
										"\n Tamanho do arquivo compactado: "+ tamanhosaid+" bits"
										+"\n Taxa de bits:");
					}
					else {
						Compactador.compactarParaZip(jTextField2.getText(), jTextField1.getText());
						long tamanhoorig = f1.length();
						long tamanhosaid = f2.length();
						JOptionPane.showMessageDialog(null, "Compactado com sucesso!!!"+
								"\nTamanho do arquivo original: "+ tamanhoorig+" bytes"+
										"\n Tamanho do arquivo compactado: "+ tamanhosaid+" bytes"
										+"\n Taxa de bits:");
					}
					
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Erro ao Compactar");
					e1.printStackTrace();
				} finally {
					jTextField1.setText("");
					jTextField2.setText("");
				}
			}
		});

        jButton4.setText("Limpar");
        
        jButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jTextField1.setText("");
				jTextField2.setText("");
			}
		});
        
        buttonGroup1.add(jRadioButton1);
        buttonGroup1.add(jRadioButton2);
        buttonGroup1.add(jRadioButton3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE))
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(200, Short.MAX_VALUE)
                .addComponent(jRadioButton1)
                .addGap(87, 87, 87)
                .addComponent(jRadioButton2)
                .addGap(83, 83, 83)
                .addComponent(jRadioButton3)
                .addGap(212, 212, 212))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Compactacao", jPanel1);

        jLabel3.setText("Procurar Arquivo:");

        jLabel4.setText("Salvar Arquivo:");

        jButton5.setText("Procurar");
        
        jButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser(); 
				int returnVal = chooser.showOpenDialog(null);
				if(returnVal == JFileChooser.APPROVE_OPTION) {   
					File arq = chooser.getSelectedFile().getAbsoluteFile();  
			        String caminho = arq.getPath();  
			        jTextField3.setText(caminho);
			    }
			}
		});

        jButton6.setText("Procurar");
        
        jButton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser arquivo = new JFileChooser();
		        arquivo.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		        int res = arquivo.showOpenDialog(null);
		        if(res == JFileChooser.APPROVE_OPTION) {   
		        	File diretorio = arquivo.getSelectedFile(); 
		        	String caminho = diretorio.getPath();
		        	jTextField4.setText(caminho);  
			    }
			}
		});

        jRadioButton4.setText("Zip");

        jRadioButton5.setText("Gzip");

        jRadioButton6.setText("Deflate");

        jButton7.setText("Descompactar");
        
        jButton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File f3 = new File (jTextField3.getText());
				File f4 = new File (jTextField4.getText());
				try {
					if(jRadioButton4.isSelected()){
						dzip.unzipFile(jTextField3.getText(), jTextField4.getText());
						long tamanhoorig = f3.length();
						long tamanhosaid = f4.length();
						JOptionPane.showMessageDialog(null, "Descompactado com sucesso!!!"+
								"\nTamanho do arquivo original: "+ tamanhoorig+" bytes"+
										"\n Tamanho do arquivo descompactado: "+ tamanhosaid+" bytes"
										+"\n Taxa de bytes:");
					}
					else if(jRadioButton5.isSelected()){
						dgzip.doUnGzipFile(jTextField3.getText(), jTextField4.getText());
						long tamanhoorig = f3.length();
						long tamanhosaid = f4.length();
						JOptionPane.showMessageDialog(null, "Descompactadoo com sucesso!!!"+
								"\nTamanho do arquivo original: "+ tamanhoorig+" bytes"+
										"\n Tamanho do arquivo descompactado: "+ tamanhosaid+" bytes"
										+"\n Taxa de bytes:");
					}
					else {
						des.unzipFile(jTextField3.getText(), jTextField4.getText());
						long tamanhoorig = f3.length();
						long tamanhosaid = f4.length();
						JOptionPane.showMessageDialog(null, "Descompactado com sucesso!!!"+
								"\nTamanho do arquivo original: "+ tamanhoorig+" bytes"+
										"\n Tamanho do arquivo descompactado: "+ tamanhosaid+" bytes"
										+"\n Taxa de bytes:");
					}
					
				} finally {
					jTextField3.setText("");
					jTextField4.setText("");
				}
			}
		});

        jButton8.setText("Limpar");
        
        jButton8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jTextField3.setText("");
				jTextField4.setText("");
			}
		});
        
        buttonGroup2.add(jRadioButton4);
        buttonGroup2.add(jRadioButton5);
        buttonGroup2.add(jRadioButton6);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField3)
                            .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE))
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton7)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(200, Short.MAX_VALUE)
                .addComponent(jRadioButton4)
                .addGap(87, 87, 87)
                .addComponent(jRadioButton5)
                .addGap(83, 83, 83)
                .addComponent(jRadioButton6)
                .addGap(212, 212, 212))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton4)
                    .addComponent(jRadioButton5)
                    .addComponent(jRadioButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton8))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Descompactacao", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ArquivosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ArquivosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ArquivosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ArquivosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ArquivosGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
