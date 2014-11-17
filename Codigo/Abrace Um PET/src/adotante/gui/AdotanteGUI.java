package adotante.gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdotanteGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdotanteGUI frame = new AdotanteGUI();
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
	public AdotanteGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroAdotante ca = new CadastroAdotante();
				ca.setVisible(true);
				dispose();
			}
		});
		btnCadastrar.setBounds(51, 124, 167, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(51, 179, 167, 23);
		contentPane.add(btnEditar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(51, 242, 167, 23);
		contentPane.add(btnConsultar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(51, 298, 167, 23);
		contentPane.add(btnExcluir);
		
		JLabel lblAdotante = new JLabel("Adotante");
		lblAdotante.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblAdotante.setBounds(51, 45, 95, 14);
		contentPane.add(lblAdotante);
	}
}
