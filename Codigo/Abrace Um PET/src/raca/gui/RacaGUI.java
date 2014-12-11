package raca.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import usuario.gui.TelaInicialGUI;

public class RacaGUI extends JFrame {
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	private JPanel	contentPane;

	
	/**
	 * Create the frame.
	 */
	public RacaGUI(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRaas = new JLabel("Cadastro de Ra\u00E7as");
		lblRaas.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblRaas.setBounds(34, 32, 250, 22);
		contentPane.add(lblRaas);
		
		JButton btnGato = new JButton("Gato");
		btnGato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarRacaGatoGUI cadastroRacaGatoGUI = new CadastrarRacaGatoGUI();
				cadastroRacaGatoGUI.setVisible(true);
				dispose();
			}
		});
		btnGato.setBounds(34, 239, 279, 39);
		contentPane.add(btnGato);
		
		JButton btnCachorro = new JButton("Cachorro");
		btnCachorro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarRacaCachorroGUI cadastrarRacaCachorro = new CadastrarRacaCachorroGUI();
				cadastrarRacaCachorro.setVisible(true);
				dispose();
			}
		});
		btnCachorro.setBounds(34, 147, 279, 39);
		contentPane.add(btnCachorro);
		
		JButton btnVolta = new JButton("Voltar");
		btnVolta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicialGUI telaInicial = new TelaInicialGUI();
				telaInicial.setVisible(true);
				dispose();
				
			}
		});
		btnVolta.setBounds(224, 382, 89, 23);
		contentPane.add(btnVolta);
	}
}
