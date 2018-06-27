package Projeto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Painel extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Compactador comp = new Compactador();
	
	JLabel labelEntrada = new JLabel("Entrada");
	JTextField inputEndrada = new JTextField(20);
	JButton botaoEntrada = new JButton("Procurar");
	JPanel painelArquivosEntrada = new JPanel();
	JLabel labelSaida = new JLabel("Saida");
	JTextField inputSaida = new JTextField(20);
	JButton botaoSaida = new JButton("Procurar");
	JPanel painelArquivosSaida = new JPanel();
	JRadioButton Gzip = new JRadioButton("Java");
	JRadioButton Zip = new JRadioButton("Zip");
	JRadioButton Deflate = new JRadioButton("Deflate");
	JPanel painelFormatos= new JPanel();
	JButton botaoLimpar = new JButton("Limpar");
	JButton botaoCompactar = new JButton("Compactar");
	JPanel painelBotoes = new JPanel();
	JPanel painel = new JPanel();
	public Painel() {
		
		setTitle("Compactar");
		setSize(400,200);
		setLocationRelativeTo(null);
		
		painelArquivosEntrada.add(labelEntrada);
		painelArquivosEntrada.add(inputEndrada);
		painelArquivosEntrada.add(botaoEntrada);
		painelArquivosSaida.add(labelSaida);
		painelArquivosSaida.add(inputSaida);
		painelArquivosSaida.add(botaoSaida);
		painelFormatos.add(Gzip);
		painelFormatos.add(Zip);
		painelFormatos.add(Deflate);
		painelBotoes.add(botaoLimpar);
		painelBotoes.add(botaoCompactar);
		painel.add(painelArquivosEntrada);
		painel.add(painelArquivosSaida);
		painel.add(painelFormatos);
		painel.add(painelBotoes);
		add(painel);
		
		setVisible(true);

		botaoEntrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser(); 
				int returnVal = chooser.showOpenDialog(null);
				if(returnVal == JFileChooser.APPROVE_OPTION) {   
					File arq = chooser.getSelectedFile().getAbsoluteFile();  
			        String caminho = arq.getPath();  
			        inputEndrada.setText(caminho);
			    }
			}
		});
		botaoSaida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser arquivo = new JFileChooser();
		        arquivo.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		        int res = arquivo.showOpenDialog(null);
		        if(res == JFileChooser.APPROVE_OPTION) {   
		        	File diretorio = arquivo.getSelectedFile(); 
		        	String caminho = diretorio.getPath();
			        inputSaida.setText(caminho+"\\zipado.zip");
			    }
			}
		});
		botaoLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputEndrada.setText("");
				inputSaida.setText("");
			}
		});
		botaoCompactar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Zip.isSelected()) {
				try {
					Compactador.compactarParaZip(inputSaida.getText(), inputEndrada.getText());
					JOptionPane.showMessageDialog(null, "Compactado com sucesso");
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Erro ao Compactar");
					e1.printStackTrace();
				} finally {
					System.exit(0);
				}
			}			
				JOptionPane.showMessageDialog(null, "Erro ao Compactar");

			}
		});

	}

	public static void main(String[] args) {
		Painel pa = new Painel();
		pa.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
