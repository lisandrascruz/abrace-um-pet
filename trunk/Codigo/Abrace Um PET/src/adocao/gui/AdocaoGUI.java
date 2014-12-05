package adocao.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;

import adocao.dominio.Adocao;
import adocao.service.AdocaoService;
import adotante.dominio.Adotante;
import adotante.dominio.PessoaFisica;
import animal.dominio.Animal;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdocaoGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblMostrarNome;
	private JLabel lblMostrarAnimal;
	private JTextField textRga;
	private JFormattedTextField formattedTextField;
	private Animal animal;
	private PessoaFisica pessoaFisica;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdocaoGUI frame = new AdocaoGUI();
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
	public AdocaoGUI() {
		setTitle("Ado\u00E7\u00E3o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CPF:");
		lblNewLabel.setBounds(10, 63, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("RGA:");
		lblNewLabel_1.setBounds(10, 145, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(66, 60, 193, 20);
		contentPane.add(formattedTextField);
		
		textRga = new JTextField();
		textRga.setBounds(68, 142, 191, 20);
		contentPane.add(textRga);
		textRga.setColumns(10);
		
		JButton btnConsultarCpf = new JButton("Consultar");
		btnConsultarCpf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pessoaFisica = new PessoaFisica();
				AdocaoService adocaoService = new AdocaoService();
				pessoaFisica = adocaoService.consultarRepresentante(formattedTextField.getText());
				lblMostrarNome.setText(pessoaFisica.getPessoa().getNome());
			}
		});
		btnConsultarCpf.setBounds(275, 59, 89, 23);
		contentPane.add(btnConsultarCpf);
		
		JButton btnConsultarRga = new JButton("Consultar");
		btnConsultarRga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				animal = new Animal();
				AdocaoService adocaoService = new AdocaoService();
				animal = adocaoService.consultarAnimal(textRga.getText());
				lblMostrarAnimal.setText(animal.getNome());
			}
		});
		btnConsultarRga.setBounds(275, 141, 89, 23);
		contentPane.add(btnConsultarRga);
		
		JButton btnAdotar = new JButton("Adotar");
		btnAdotar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdocaoService adocaoService = new AdocaoService();
				Adocao adocao = new Adocao();
				Adotante adotante = new Adotante();
				adotante = adocaoService.consultarAdotante(pessoaFisica.getPessoa());
				adocao.setAnimal(animal);
				adocao.setAdotante(adotante);
				adocaoService.adicionarAdocaoService(adocao);
			}
		});
		btnAdotar.setBounds(10, 216, 89, 23);
		contentPane.add(btnAdotar);
		
		lblMostrarNome = new JLabel("");
		lblMostrarNome.setBounds(66, 92, 193, 14);
		contentPane.add(lblMostrarNome);
		
		lblMostrarAnimal = new JLabel("");
		lblMostrarAnimal.setBounds(66, 188, 193, 14);
		contentPane.add(lblMostrarAnimal);
	}
}
