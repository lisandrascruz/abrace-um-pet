package animal.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import usuario.gui.TelaInicialGUI;
import animal.gui.cadastrar.CadastroAnimalGUI;
import animal.gui.consultar.ConsultarAnimalRGAGUI;

public class AnimalGUI extends JFrame {
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	private JPanel				contentPane;
	
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
		lblAnimal.setBounds(49, 57, 129, 14);
		contentPane.add(lblAnimal);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroAnimalGUI cadastroAnimalGUI = null;
				try {
					try {
						cadastroAnimalGUI = new CadastroAnimalGUI();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1, "ERROR", 0);
					}
					cadastroAnimalGUI.setVisible(true);
					dispose();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1, "ERROR", 0);
				}
				
			}
		});
		btnCadastrar.setBounds(172, 168, 279, 39);
		contentPane.add(btnCadastrar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarAnimalRGAGUI consultar = new ConsultarAnimalRGAGUI();
				consultar.setVisible(true);
				dispose();
			}
		});
		btnConsultar.setBounds(172, 236, 279, 39);
		contentPane.add(btnConsultar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicialGUI telaInicialGUI = new TelaInicialGUI();
				telaInicialGUI.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(530, 382, 89, 23);
		contentPane.add(btnVoltar);
	}
}
