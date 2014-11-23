package adotante.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import adotante.dominio.Adotante;
import adotante.dominio.Endereco;
import adotante.dominio.PessoaFisica;
import adotante.service.PessoaFisicaService;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;



public class CadastroAdotanteFisicoGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNomeFisico;
	private JTextField textCPF;
	private JTextField textRua;
	private JTextField textBairro;
	private JTextField textNumero;
	private JTextField textCidade;
	private JTextField textEstado;
	private JTextField textCEP;
	private JTextField textComplemento;
	private JTextField textCelular;
	private JTextField textTelefoneFixo;
	private JTextField textEmail;
	private JTextField textRG;

	/**
	 * Create the frame.
	 */
	public CadastroAdotanteFisicoGUI() {
		setTitle("Cadastro de Pessoa Fisica - Abrace um PET");
		setBounds(100, 100, 645, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCadastroDeUsurioJuridico = new JLabel(
				"Cadastro de Pessoa Fisica");
		lblCadastroDeUsurioJuridico.setFont(new Font("Microsoft YaHei",
				Font.BOLD, 14));
		lblCadastroDeUsurioJuridico.setBounds(9, 16, 225, 14);
		contentPane.add(lblCadastroDeUsurioJuridico);

		JLabel lblNomeFisico = new JLabel("Nome Completo:");
		lblNomeFisico.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		lblNomeFisico.setBounds(51, 82, 118, 14);
		contentPane.add(lblNomeFisico);

		textNomeFisico = new JTextField();
		textNomeFisico.setBounds(173, 80, 401, 20);
		contentPane.add(textNomeFisico);
		textNomeFisico.setColumns(10);
		
		textCPF = new JTextField();
		textCPF.setBounds(173, 147, 118, 20);
		contentPane.add(textCPF);
		textCPF.setColumns(10);

		JLabel lblEnderecoEmpresarial = new JLabel("Endere\u00E7o:");
		lblEnderecoEmpresarial.setFont(new Font("Microsoft YaHei", Font.PLAIN,
				12));
		lblEnderecoEmpresarial.setBounds(25, 236, 114, 14);
		contentPane.add(lblEnderecoEmpresarial);

		JLabel lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblRua.setBounds(45, 261, 46, 14);
		contentPane.add(lblRua);

		JLabel lblDadosFisicos = new JLabel("Dados: ");
		lblDadosFisicos.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblDadosFisicos.setBounds(25, 54, 132, 14);
		contentPane.add(lblDadosFisicos);

		JLabel lblCpf = new JLabel("CPF: ");
		lblCpf.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblCpf.setBounds(51, 149, 46, 14);
		contentPane.add(lblCpf);

		textRua = new JTextField();
		textRua.setBounds(167, 259, 275, 20);
		contentPane.add(textRua);
		textRua.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblBairro.setBounds(376, 290, 46, 14);
		contentPane.add(lblBairro);

		textBairro = new JTextField();
		textBairro.setBounds(432, 293, 142, 20);
		contentPane.add(textBairro);
		textBairro.setColumns(10);

		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblNumero.setBounds(449, 261, 65, 14);
		contentPane.add(lblNumero);

		textNumero = new JTextField();
		textNumero.setBounds(509, 259, 65, 20);
		contentPane.add(textNumero);
		textNumero.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblCidade.setBounds(45, 322, 46, 14);
		contentPane.add(lblCidade);

		textCidade = new JTextField();
		textCidade.setBounds(167, 320, 187, 20);
		contentPane.add(textCidade);
		textCidade.setColumns(10);

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblEstado.setBounds(376, 324, 46, 14);
		contentPane.add(lblEstado);

		textEstado = new JTextField();
		textEstado.setBounds(432, 320, 142, 20);
		contentPane.add(textEstado);
		textEstado.setColumns(10);

		JLabel lblCep = new JLabel("CEP: ");
		lblCep.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblCep.setBounds(45, 295, 46, 14);
		contentPane.add(lblCep);

		textCEP = new JTextField();
		textCEP.setBounds(167, 290, 187, 20);
		contentPane.add(textCEP);
		textCEP.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PessoaFisica pessoaFisica = new PessoaFisica();
				Endereco endereco = new Endereco();
				Adotante adotante = new Adotante();
				PessoaFisicaService pessoaFisicaService = new PessoaFisicaService();
				
				
				
				pessoaFisica.setCpf(textCPF.getText());
				pessoaFisica.setRg(textRG.getText());
				endereco.setBairro(textBairro.getText());
				endereco.setCep(textCEP.getText());
				endereco.setCidade(textCidade.getText());
				endereco.setComplemento(textComplemento.getText());
				endereco.setBairro(textEstado.getText());
				endereco.setEstado(textNumero.getText());
				endereco.setRua(textRua.getText());
				adotante.setNome(textNomeFisico.getText());
				adotante.setEmail(textEmail.getText());
				adotante.setTelefoneFixo(textTelefoneFixo.getText());
				adotante.setTelefoneCelular(textCelular.getText());
				
			
				adotante.setEndereco(endereco);
				pessoaFisica.setAdotante(adotante);

				
				pessoaFisicaService.adicionarPessoaFisicaService(pessoaFisica);

				
			}
		});
		
		btnCadastrar.setBounds(194, 382, 118, 23);
		contentPane.add(btnCadastrar);

		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblComplemento.setBounds(45, 351, 89, 14);
		contentPane.add(lblComplemento);

		textComplemento = new JTextField();
		textComplemento.setBounds(167, 351, 407, 20);
		contentPane.add(textComplemento);
		textComplemento.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBounds(11, 217, 563, 14);
		contentPane.add(separator);

		JButton btnLimparCampos = new JButton("Limpar Campos");
		btnLimparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textNomeFisico.setText("");
				textBairro.setText("");
				textCEP.setText("");
				textCidade.setText("");
				textCPF.setText("");
				textComplemento.setText("");
				textEmail.setText("");
				textEstado.setText("");
				textNumero.setText("");
				textRua.setText("");
				textTelefoneFixo.setText("");
				textCelular.setText("");
				textRG.setText("");

				textNomeFisico.requestFocus();
			}
		});
		btnLimparCampos.setBounds(45, 382, 128, 23);
		contentPane.add(btnLimparCampos);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setBounds(472, 382, 102, 23);
		contentPane.add(btnSair);

		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblCelular.setBounds(364, 118, 65, 14);
		contentPane.add(lblCelular);

		textCelular = new JTextField();
		textCelular.setBounds(420, 116, 154, 20);
		contentPane.add(textCelular);
		textCelular.setColumns(10);

		JLabel lblTelefoneFixo = new JLabel("Telefone Fixo:");
		lblTelefoneFixo.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblTelefoneFixo.setBounds(51, 118, 122, 14);
		contentPane.add(lblTelefoneFixo);

		textTelefoneFixo = new JTextField();
		textTelefoneFixo.setBounds(173, 116, 171, 20);
		contentPane.add(textTelefoneFixo);
		textTelefoneFixo.setColumns(10);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblEmail.setBounds(308, 149, 46, 14);
		contentPane.add(lblEmail);

		textEmail = new JTextField();
		textEmail.setBounds(364, 147, 210, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);

		JButton btnVoltar = new JButton("Cancelar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroAdotante c = new CadastroAdotante();
				c.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(335, 382, 113, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblRg = new JLabel("RG: ");
		lblRg.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblRg.setBounds(51, 174, 46, 14);
		contentPane.add(lblRg);
		
		textRG = new JTextField();
		textRG.setBounds(173, 178, 118, 20);
		contentPane.add(textRG);
		textRG.setColumns(10);
		
		JComboBox<String> comboOrgEmissor = new JComboBox<String>();
		comboOrgEmissor.setModel(new DefaultComboBoxModel<String>(new String[] {"", "SSP", "SDS", "OUTROS"}));
		comboOrgEmissor.setSelectedIndex(0);
		comboOrgEmissor.setBounds(393, 178, 58, 20);
		contentPane.add(comboOrgEmissor);
		
		JComboBox<String> comboEstado = new JComboBox<String>();
		comboEstado.setModel(new DefaultComboBoxModel<String>(new String[] {" ", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		comboEstado.setBounds(509, 178, 65, 20);
		contentPane.add(comboEstado);
		
		JLabel lblEs = new JLabel("Estado:");
		lblEs.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblEs.setBounds(461, 180, 53, 14);
		contentPane.add(lblEs);
		
		JLabel lblOrgemissor = new JLabel("Org.Emissor:");
		lblOrgemissor.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblOrgemissor.setBounds(308, 174, 89, 28);
		contentPane.add(lblOrgemissor);
	}
}
