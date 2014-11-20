package adotante.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Scrollbar;

public class CadastroAdotanteFisicoGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Component JScrollPane = null;
	private JPanel contentPane_PF;
	private JTextField textFieldNome;
	private JTextField txtEx_rg;
	private JTextField txtEx_cpf;
	private JTextField txtEx_telFixo;
	private JTextField txtEx_cel;
	private JTextField txtEx_email;
	private JTextField txt_rua;
	private JTextField txtEx_cep;
	private JTextField textField_numero;
	private JTextField textField_cidade;
	private JTextField textField_estado;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroAdotanteFisicoGUI frame = new CadastroAdotanteFisicoGUI();
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
	public CadastroAdotanteFisicoGUI() {
		setTitle("Cadastro de Pessoa F\u00EDsica - Abrace um PET");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 455);
		contentPane_PF = new JPanel();
		contentPane_PF.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane_PF);
		contentPane_PF.setLayout(null);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(270, 566, 89, 23);
		contentPane_PF.add(btnOk);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(161, 272, 81, -54);
		contentPane_PF.add(separator);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(128, 61, 474, 20);
		contentPane_PF.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		txtEx_rg = new JTextField();
		txtEx_rg.setToolTipText("");
		txtEx_rg.setBounds(128, 123, 177, 20);
		contentPane_PF.add(txtEx_rg);
		txtEx_rg.setColumns(10);
		
		txtEx_cpf = new JTextField();
		txtEx_cpf.setBounds(374, 123, 228, 20);
		contentPane_PF.add(txtEx_cpf);
		txtEx_cpf.setColumns(10);
		
		txtEx_telFixo = new JTextField();
		txtEx_telFixo.setBounds(128, 154, 178, 20);
		contentPane_PF.add(txtEx_telFixo);
		txtEx_telFixo.setColumns(10);
		
		txtEx_cel = new JTextField();
		txtEx_cel.setBounds(374, 154, 228, 20);
		contentPane_PF.add(txtEx_cel);
		txtEx_cel.setColumns(10);
		
		txtEx_email = new JTextField();
		txtEx_email.setBounds(128, 92, 474, 20);
		contentPane_PF.add(txtEx_email);
		txtEx_email.setColumns(10);
		
		txt_rua = new JTextField();
		txt_rua.setBounds(128, 185, 251, 20);
		contentPane_PF.add(txt_rua);
		txt_rua.setColumns(10);
		
		JLabel lblNomeFisico = new JLabel("Nome:");
		lblNomeFisico.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 14));
		lblNomeFisico.setBounds(27, 61, 63, 17);
		contentPane_PF.add(lblNomeFisico);
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 14));
		lblRg.setBounds(27, 123, 63, 17);
		contentPane_PF.add(lblRg);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 14));
		lblCpf.setBounds(316, 123, 63, 17);
		contentPane_PF.add(lblCpf);
		
		JLabel lblTelefoneFixo = new JLabel("Telefone Fixo:");
		lblTelefoneFixo.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 14));
		lblTelefoneFixo.setBounds(27, 154, 108, 17);
		contentPane_PF.add(lblTelefoneFixo);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 14));
		lblCelular.setBounds(316, 154, 63, 17);
		contentPane_PF.add(lblCelular);
		
		JLabel lblCadastroPF = new JLabel("Cadastro de Pessoa F\u00EDsica");
		lblCadastroPF.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCadastroPF.setBounds(27, 11, 285, 28);
		contentPane_PF.add(lblCadastroPF);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 14));
		lblEmail.setBounds(27, 92, 63, 17);
		contentPane_PF.add(lblEmail);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 14));
		lblEndereo.setBounds(27, 185, 89, 17);
		contentPane_PF.add(lblEndereo);
		
		JLabel lblCep = new JLabel("Cep:");
		lblCep.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 14));
		lblCep.setBounds(27, 216, 63, 17);
		contentPane_PF.add(lblCep);
		
		txtEx_cep = new JTextField();
		txtEx_cep.setBounds(128, 216, 177, 20);
		contentPane_PF.add(txtEx_cep);
		txtEx_cep.setColumns(10);
		
		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 14));
		lblNmero.setBounds(384, 185, 63, 17);
		contentPane_PF.add(lblNmero);
		
		textField_numero = new JTextField();
		textField_numero.setBounds(444, 185, 158, 20);
		contentPane_PF.add(textField_numero);
		textField_numero.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 14));
		lblCidade.setBounds(27, 244, 63, 17);
		contentPane_PF.add(lblCidade);
		
		textField_cidade = new JTextField();
		textField_cidade.setBounds(128, 244, 177, 20);
		contentPane_PF.add(textField_cidade);
		textField_cidade.setColumns(10);
		
		JLabel lbl_estado = new JLabel("Estado:");
		lbl_estado.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 14));
		lbl_estado.setBounds(315, 244, 63, 17);
		contentPane_PF.add(lbl_estado);
		
		textField_estado = new JTextField();
		textField_estado.setBounds(374, 244, 228, 20);
		contentPane_PF.add(textField_estado);
		textField_estado.setColumns(10);
		
		JLabel lblImpedimento = new JLabel("Impedimento:");
		lblImpedimento.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 14));
		lblImpedimento.setBounds(27, 272, 108, 17);
		contentPane_PF.add(lblImpedimento);
		
		JLabel lblMotivoDeImpedimento = new JLabel("Motivo de Impedimento");
		lblMotivoDeImpedimento.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 14));
		lblMotivoDeImpedimento.setBounds(27, 300, 179, 23);
		contentPane_PF.add(lblMotivoDeImpedimento);
		
		JCheckBox chckbxPF_sim = new JCheckBox("Sim");
		chckbxPF_sim.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 11));
		chckbxPF_sim.setBounds(138, 270, 59, 23);
		contentPane_PF.add(chckbxPF_sim);
		
		JCheckBox chckbxPF_nao = new JCheckBox("N\u00E3o");
		chckbxPF_nao.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 11));
		chckbxPF_nao.setBounds(196, 270, 97, 23);
		contentPane_PF.add(chckbxPF_nao);
		
		TextField textFieldMot_Impedimento = new TextField();
		textFieldMot_Impedimento.setBounds(27, 329, 575, 38);
		contentPane_PF.add(textFieldMot_Impedimento);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 14));
		lblBairro.setBounds(316, 219, 46, 14);
		contentPane_PF.add(lblBairro);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(374, 216, 228, 20);
		contentPane_PF.add(textField);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSalvar.setBounds(513, 383, 89, 23);
		contentPane_PF.add(btnSalvar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroAdotante c = new CadastroAdotante();
				c.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(403, 383, 89, 23);
		contentPane_PF.add(btnVoltar);
	}
}

