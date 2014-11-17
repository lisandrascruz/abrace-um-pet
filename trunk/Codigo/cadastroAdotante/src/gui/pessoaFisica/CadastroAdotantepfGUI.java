package gui.pessoaFisica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JEditorPane;
import javax.swing.JTree;
import javax.swing.JTable;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JList;
import java.awt.Font;
import java.awt.Color;
import java.awt.TextField;

public class CadastroAdotantepfGUI extends JFrame {

	private JPanel contentPane_cidade;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroAdotantepfGUI frame = new CadastroAdotantepfGUI();
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
	public CadastroAdotantepfGUI() {
		setTitle("Cadastrar Adotante > Pessoa F\u00EDsica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 401, 641);
		contentPane_cidade = new JPanel();
		contentPane_cidade.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane_cidade);
		contentPane_cidade.setLayout(null);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(270, 566, 89, 23);
		contentPane_cidade.add(btnOk);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(161, 272, 81, -54);
		contentPane_cidade.add(separator);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(71, 67, 261, 20);
		contentPane_cidade.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		txtEx_rg = new JTextField();
		txtEx_rg.setText("Ex. 1234567");
		txtEx_rg.setToolTipText("");
		txtEx_rg.setBounds(71, 98, 261, 20);
		contentPane_cidade.add(txtEx_rg);
		txtEx_rg.setColumns(10);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(369, 11, 17, 671);
		contentPane_cidade.add(scrollBar);
		
		txtEx_cpf = new JTextField();
		txtEx_cpf.setText("Ex. 01234567890");
		txtEx_cpf.setBounds(71, 129, 261, 20);
		contentPane_cidade.add(txtEx_cpf);
		txtEx_cpf.setColumns(10);
		
		txtEx_telFixo = new JTextField();
		txtEx_telFixo.setText("Ex. 08133333333");
		txtEx_telFixo.setBounds(129, 160, 203, 20);
		contentPane_cidade.add(txtEx_telFixo);
		txtEx_telFixo.setColumns(10);
		
		txtEx_cel = new JTextField();
		txtEx_cel.setText("Ex. 08199999999");
		txtEx_cel.setBounds(84, 191, 248, 20);
		contentPane_cidade.add(txtEx_cel);
		txtEx_cel.setColumns(10);
		
		txtEx_email = new JTextField();
		txtEx_email.setText("Ex. jose@email.com");
		txtEx_email.setBounds(84, 224, 248, 20);
		contentPane_cidade.add(txtEx_email);
		txtEx_email.setColumns(10);
		
		txt_rua = new JTextField();
		txt_rua.setText("Ex. Rua do Para\u00EDso");
		txt_rua.setBounds(104, 250, 228, 20);
		contentPane_cidade.add(txt_rua);
		txt_rua.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNome.setBounds(27, 67, 63, 17);
		contentPane_cidade.add(lblNome);
		
		JLabel lblRg = new JLabel("RG");
		lblRg.setFont(new Font("Dialog", Font.BOLD, 14));
		lblRg.setBounds(27, 101, 63, 17);
		contentPane_cidade.add(lblRg);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCpf.setBounds(27, 132, 63, 17);
		contentPane_cidade.add(lblCpf);
		
		JLabel lblTelefoneFixo = new JLabel("Telefone Fixo");
		lblTelefoneFixo.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTelefoneFixo.setBounds(27, 163, 108, 17);
		contentPane_cidade.add(lblTelefoneFixo);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCelular.setBounds(27, 191, 63, 17);
		contentPane_cidade.add(lblCelular);
		
		JLabel lblPorFavorPreencha = new JLabel("Por favor, preencha os dados abaixo");
		lblPorFavorPreencha.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPorFavorPreencha.setBounds(27, 11, 285, 28);
		contentPane_cidade.add(lblPorFavorPreencha);
		
		JLabel lbldadosObrigatrios = new JLabel("*Dados n\u00E3o-obrigat\u00F3rios");
		lbldadosObrigatrios.setForeground(Color.RED);
		lbldadosObrigatrios.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbldadosObrigatrios.setBounds(27, 36, 148, 14);
		contentPane_cidade.add(lbldadosObrigatrios);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEmail.setBounds(27, 222, 63, 17);
		contentPane_cidade.add(lblEmail);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEndereo.setBounds(27, 250, 89, 17);
		contentPane_cidade.add(lblEndereo);
		
		JLabel lblCep = new JLabel("Cep");
		lblCep.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCep.setBounds(196, 286, 63, 17);
		contentPane_cidade.add(lblCep);
		
		txtEx_cep = new JTextField();
		txtEx_cep.setText("Ex. 098764-53");
		txtEx_cep.setBounds(232, 285, 100, 23);
		contentPane_cidade.add(txtEx_cep);
		txtEx_cep.setColumns(10);
		
		JLabel lblNmero = new JLabel("N\u00FAmero");
		lblNmero.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNmero.setBounds(27, 286, 63, 17);
		contentPane_cidade.add(lblNmero);
		
		textField_numero = new JTextField();
		textField_numero.setBounds(92, 288, 94, 17);
		contentPane_cidade.add(textField_numero);
		textField_numero.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCidade.setBounds(27, 314, 63, 17);
		contentPane_cidade.add(lblCidade);
		
		textField_cidade = new JTextField();
		textField_cidade.setBounds(85, 314, 101, 17);
		contentPane_cidade.add(textField_cidade);
		textField_cidade.setColumns(10);
		
		JLabel lbl_estado = new JLabel("Estado");
		lbl_estado.setFont(new Font("Dialog", Font.BOLD, 14));
		lbl_estado.setBounds(196, 314, 63, 17);
		contentPane_cidade.add(lbl_estado);
		
		textField_estado = new JTextField();
		textField_estado.setBounds(252, 314, 80, 20);
		contentPane_cidade.add(textField_estado);
		textField_estado.setColumns(10);
		
		JLabel lblImpedimento = new JLabel("Impedimento");
		lblImpedimento.setFont(new Font("Dialog", Font.BOLD, 14));
		lblImpedimento.setBounds(27, 348, 108, 17);
		contentPane_cidade.add(lblImpedimento);
		
		JLabel lblMotivoDeImpedimento = new JLabel("Motivo de Impedimento");
		lblMotivoDeImpedimento.setFont(new Font("Dialog", Font.BOLD, 14));
		lblMotivoDeImpedimento.setBounds(26, 376, 179, 23);
		contentPane_cidade.add(lblMotivoDeImpedimento);
		
		JLabel label = new JLabel("*");
		label.setForeground(Color.RED);
		label.setFont(new Font("Dialog", Font.BOLD, 14));
		label.setBounds(196, 377, 12, 20);
		contentPane_cidade.add(label);
		
		JCheckBox chckbxPF_sim = new JCheckBox("Sim");
		chckbxPF_sim.setFont(new Font("Dialog", Font.BOLD, 11));
		chckbxPF_sim.setBounds(127, 347, 59, 23);
		contentPane_cidade.add(chckbxPF_sim);
		
		JCheckBox chckbxPF_nao = new JCheckBox("N\u00E3o");
		chckbxPF_nao.setFont(new Font("Dialog", Font.BOLD, 11));
		chckbxPF_nao.setBounds(187, 347, 97, 23);
		contentPane_cidade.add(chckbxPF_nao);
		
		TextField textFieldMot_Impedimento = new TextField();
		textFieldMot_Impedimento.setBounds(22, 405, 310, 140);
		contentPane_cidade.add(textFieldMot_Impedimento);
	}
}
