package br.sp.senai.jandira.arquivo.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.sp.senai.jandira.arquivo.Arquivo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameTeste extends JFrame {

	private JPanel contentPane;
	private Arquivo objArquivo;
	private String caminho;

	public FrameTeste() {
		objArquivo = new Arquivo();
		caminho = "C:\\Users\\21276327\\Desktop\\Teste\\aula.txt";
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 258, 288);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Manipula\u00E7\u00E3o de Arquivo");
		lblTitulo.setBounds(65, 11, 127, 14);
		contentPane.add(lblTitulo);
		
		JLabel lblTexto = new JLabel("Texto");
		lblTexto.setBounds(20, 36, 37, 14);
		contentPane.add(lblTexto);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(20, 61, 198, 130);
		contentPane.add(textPane);
		
		JButton btnGravar = new JButton("Gravar");
		btnGravar.setBounds(20, 212, 89, 23);
		contentPane.add(btnGravar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(129, 212, 89, 23);
		contentPane.add(btnSair);
		
		//Listeners
		btnGravar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String textoArquivo = objArquivo.ler(caminho);
				String texto = textoArquivo + textPane.getText();
				
				if(objArquivo.escrever(caminho, texto)) {
					JOptionPane.showMessageDialog(null, "Dado gravado com sucesso! :)", "Sucessoo", JOptionPane.INFORMATION_MESSAGE);
					textPane.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "Não foi possível realizar a gravação! :(", "Erroo", JOptionPane.ERROR_MESSAGE);
					textPane.setText("");
				}
				
				textPane.setText("");
			}
		});
		
		btnSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
