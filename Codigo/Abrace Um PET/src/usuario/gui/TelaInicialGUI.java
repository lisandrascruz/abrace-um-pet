package usuario.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;

import adotante.gui.AdotanteGUI;

public class TelaInicialGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel telaInicialGUI;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicialGUI frame = new TelaInicialGUI();
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
	public TelaInicialGUI() {
		setTitle("Abrace um PET");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 455);
		telaInicialGUI = new JPanel();
		telaInicialGUI.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(telaInicialGUI);
		telaInicialGUI.setLayout(null);
		
		JButton btnLogin = new JButton("Adotante");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdotanteGUI a = new AdotanteGUI();
				a.setVisible(true);
				dispose();
			}
		});
		btnLogin.setBounds(195, 359, 89, 23);
		telaInicialGUI.add(btnLogin);
		
		JButton btnAnimal = new JButton("Animal");
		btnAnimal.setBounds(37, 359, 89, 23);
		telaInicialGUI.add(btnAnimal);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI l = new LoginGUI();
				l.setVisible(true);
				dispose();
			}
		});
		btnSair.setBounds(503, 359, 89, 23);
		telaInicialGUI.add(btnSair);
		
		JButton btnSobre = new JButton("Sobre");
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SobreGUI sobre = new SobreGUI();
				sobre.setVisible(true);
				dispose();
			}
		});
		btnSobre.setBounds(345, 359, 89, 23);
		telaInicialGUI.add(btnSobre);
		
		JButton button = new JButton("");
		button.setVerticalAlignment(SwingConstants.BOTTOM);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\Lisandra Cruz\\Desktop\\abrace-um-pet\\Codigo\\Abrace Um PET\\imagens\\cadastro.png"));
		button.setBounds(37, 73, 555, 275);
		telaInicialGUI.add(button);
	}
}
