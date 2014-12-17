package adotante.gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import adotante.gui.cadastroGUI.CadastroPessoaGUI;
import adotante.gui.consultaGUI.ConsultarAdotanteFisicoCPFGUI;
import adotante.gui.consultaGUI.ConsultarPessoaGUI;
import usuario.gui.TelaInicialGUI;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PessoaGUI extends JFrame {

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
					PessoaGUI frame = new PessoaGUI();
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
	public PessoaGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroPessoaGUI ca = new CadastroPessoaGUI();
				ca.setVisible(true);
				dispose();
			}
		});
		btnCadastrar.setBounds(227, 121, 167, 23);
		contentPane.add(btnCadastrar);

		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(227, 184, 167, 23);
		contentPane.add(btnEditar);

		JLabel lblAdotante = new JLabel("Adotante");
		lblAdotante.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblAdotante.setBounds(51, 45, 95, 14);
		contentPane.add(lblAdotante);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarPessoaGUI consultarPessoa = new ConsultarPessoaGUI();
				consultarPessoa.setVisible(true);
				dispose();
				
			}
		});
		btnConsultar.setBounds(227, 249, 167, 23);
		contentPane.add(btnConsultar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(227, 316, 167, 23);
		contentPane.add(btnExcluir);


		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setBounds(341, 382, 89, 23);
		contentPane.add(btnSair);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicialGUI ti = new TelaInicialGUI();
				ti.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(168, 382, 89, 23);
		contentPane.add(btnVoltar);
	}
}
