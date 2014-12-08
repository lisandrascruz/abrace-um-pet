package animal.gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import usuario.gui.LoginGUI;
import usuario.gui.TelaInicialGUI;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AnimalGUI extends JFrame {
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	private JPanel	contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnimalGUI frame = new AnimalGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public AnimalGUI(){
		setTitle("Animal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAnimal = new JLabel("Animal");
		lblAnimal.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblAnimal.setBounds(29, 57, 129, 14);
		contentPane.add(lblAnimal);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroAnimalGUI cadastroAnimalGUI = new CadastroAnimalGUI();
				cadastroAnimalGUI.setVisible(true);
				dispose();
			}
		});
		btnCadastrar.setBounds(220, 123,167, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(220, 259, 167, 23);
		contentPane.add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(220, 325,167, 23);
		contentPane.add(btnExcluir);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(220, 190, 167, 23);
		contentPane.add(btnConsultar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI loginGUI = new LoginGUI();
				loginGUI.setVisible(true);
				dispose();
			}
		});
		btnSair.setBounds(327, 382, 89, 23);
		contentPane.add(btnSair);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicialGUI telaInicialGUI = new TelaInicialGUI();
				telaInicialGUI.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(181, 382, 89, 23);
		contentPane.add(btnVoltar);
	}
}
