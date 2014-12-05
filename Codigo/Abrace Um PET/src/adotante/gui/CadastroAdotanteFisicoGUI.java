package adotante.gui;

import infraestrutura.service.ValidacaoService;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import adotante.dominio.Endereco;
import adotante.dominio.Pessoa;
import adotante.dominio.PessoaFisica;
import adotante.service.PessoaFisicaService;

import javax.swing.JFormattedTextField;

public class CadastroAdotanteFisicoGUI extends JFrame {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	private JPanel				contentPane;
	private JTextField			textNomeFisico;
	private JTextField			textRua;
	private JTextField			textBairro;
	private JTextField			textNumero;
	private JTextField			textCidade;
	private JTextField			textEstado;
	private JTextField			textComplemento;
	// private JTextField textTelefoneFixo;
	private JTextField			textEmail;
	private JTextField			textRG;
	private JComboBox<String>	comboGenero;

	/**
	 * Create the frame.
	 * 
	 * @return
	 */
	public CadastroAdotanteFisicoGUI(){
		setTitle("Cadastro de Pessoa Fisica - Abrace um PET");
		setBounds(100, 100, 647, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCadastroDeUsurioJuridico = new JLabel("Cadastro de Pessoa Fisica");
		lblCadastroDeUsurioJuridico.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblCadastroDeUsurioJuridico.setBounds(9, 16, 225, 14);
		contentPane.add(lblCadastroDeUsurioJuridico);

		JLabel lblNomeFisico = new JLabel("Nome Completo:");
		lblNomeFisico.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		lblNomeFisico.setBounds(51, 82, 118, 14);
		contentPane.add(lblNomeFisico);

		textNomeFisico = new JTextField();
		textNomeFisico.setBounds(173, 80, 289, 20);
		contentPane.add(textNomeFisico);
		textNomeFisico.setColumns(10);

		JLabel lblEnderecoEmpresarial = new JLabel("Endere\u00E7o:");
		lblEnderecoEmpresarial.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
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

		JFormattedTextField formattedTextFieldCPF = new JFormattedTextField();
		MaskFormatter mascaraCpf = null;
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
			mascaraCpf.setPlaceholderCharacter('_');

		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null, "Digite um CPF válido!" + e1.getMessage(), "ERROR", 0);
		}
		JFormattedTextField jFormattedTextCpf = new JFormattedTextField(mascaraCpf);
		jFormattedTextCpf.setBounds(150, 120, 100, 20);

		jFormattedTextCpf.setBounds(173, 147, 171, 20);
		contentPane.add(jFormattedTextCpf);

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

		MaskFormatter mascaraCep = null;
		// JFormattedTextField formattedTextFieldCEP = new
		// JFormattedTextField();
		try {
			mascaraCep = new MaskFormatter("##.###-###");
			mascaraCep.setPlaceholderCharacter('_');
		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null, "Digite um cpf válido!" + e1.getMessage(), "ERROR", 0);
		}
		JFormattedTextField jFormattedTextCep = new JFormattedTextField(mascaraCep);
		jFormattedTextCep.setBounds(150, 120, 100, 20);
		jFormattedTextCep.setBounds(167, 288, 187, 20);
		contentPane.add(jFormattedTextCep);

		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblCelular.setBounds(364, 118, 65, 14);
		contentPane.add(lblCelular);

		MaskFormatter mascaraTel = null;
		try {
			mascaraTel = new MaskFormatter("(##)####-####");
			mascaraTel.setPlaceholderCharacter('_');
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JFormattedTextField jFormattedTextTeljFormattedTextTel = new JFormattedTextField(mascaraTel);
		contentPane.add(jFormattedTextTeljFormattedTextTel);
		jFormattedTextTeljFormattedTextTel.setBounds(420, 116, 151, 20);

		JLabel lblTelefoneFixo = new JLabel("Telefone Fixo:");
		lblTelefoneFixo.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblTelefoneFixo.setBounds(51, 118, 122, 14);
		contentPane.add(lblTelefoneFixo);

		MaskFormatter mascaraTelFixo = null;
		try {
			mascaraTelFixo = new MaskFormatter("(##)####-####");
			mascaraTelFixo.setPlaceholderCharacter('_');
		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null, "Digite um telefone fixo válido!" + e1.getMessage(), "ERROR", 0);
		}

		JFormattedTextField formattedTextFieldTelefoneFixo = new JFormattedTextField(mascaraTelFixo);
		contentPane.add(formattedTextFieldTelefoneFixo);
		formattedTextFieldTelefoneFixo.setBounds(173, 111, 171, 20);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblEmail.setBounds(51, 180, 46, 14);
		contentPane.add(lblEmail);

		textEmail = new JTextField();
		textEmail.setBounds(173, 178, 249, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PessoaFisica pessoaFisica = new PessoaFisica();
				PessoaFisicaService pessoaFisicaService = new PessoaFisicaService();
				Endereco endereco = new Endereco();
				Pessoa adotante = new Pessoa();
				// endereco
				endereco.setBairro(textBairro.getText());
				endereco.setCep(jFormattedTextCep.getText());
				endereco.setCidade(textCidade.getText());
				endereco.setComplemento(textComplemento.getText());
				endereco.setEstado(textEstado.getText());
				endereco.setRua(textRua.getText());
				endereco.setNumero(textNumero.getText());
				// adotante

				adotante.setNome(textNomeFisico.getText());
				adotante.setEmail(textEmail.getText());
				adotante.setTelefoneFixo(formattedTextFieldTelefoneFixo.getText());
				adotante.setTelefoneCelular(jFormattedTextTeljFormattedTextTel.getText());
				adotante.setEndereco(endereco);

				// pessoa fisica
				pessoaFisica.setCpf(formattedTextFieldCPF.getText());
				pessoaFisica.setRg(textRG.getText());
				pessoaFisica.setGenero(comboGenero.getSelectedItem().toString());

				pessoaFisica.setPessoa(adotante);

				String nome = pessoaFisica.getPessoa().getNome();
				String email = pessoaFisica.getPessoa().getEmail();
				String telefoneFixo = pessoaFisica.getPessoa().getTelefoneFixo();
				String telefoneCelular = pessoaFisica.getPessoa().getTelefoneCelular();
				String cpf = pessoaFisica.getCpf();
				String rg = pessoaFisica.getRg();
				String genero = pessoaFisica.getGenero();

				String numero = endereco.getNumero();
				String rua = endereco.getRua();
				String cep = endereco.getCep();
				String bairro = endereco.getBairro();
				String cidade = endereco.getCidade();
				String estado = endereco.getEstado();

				if ((validacaoDadosPF(nome, genero, telefoneFixo, telefoneCelular, cpf, rg, email) && (validacaoDadosEndereco(rua, numero, cep,
						bairro, cidade, estado)))) {
					if (pessoaFisicaService.adicionarPessoaFisicaService(pessoaFisica)) {
						JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso");
						CadastroPessoaGUI cadastroAdotante = new CadastroPessoaGUI();
						cadastroAdotante.setVisible(true);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "O cadastro não pode ser realizado, tente novamente!", "ERROR", 0);

					}
				}

			}

			// /**
			// * SETA OS DADOS PASSADOS PELO USUARIO
			// */
			// public void setarDadosAdotanteFisico() {
			// PessoaFisica pessoaFisica = new PessoaFisica();
			// PessoaFisicaService pessoaFisicaService = new
			// PessoaFisicaService();
			// Endereco endereco = new Endereco();
			// pessoaFisica.setCpf(textCPF.getText());
			// pessoaFisica.setRg(textRG.getText());
			// pessoaFisica.setGenero(comboGenero.getSelectedItem().toString());
			//
			// endereco.setBairro(textBairro.getText());
			// endereco.setCep(textCEP.getText());
			// endereco.setCidade(textCidade.getText());
			// endereco.setComplemento(textComplemento.getText());
			// endereco.setEstado(textEstado.getText());
			// endereco.setRua(textRua.getText());
			// endereco.setNumero(textNumero.getText());
			//
			// pessoaFisica.getAdotante().setNome(textNomeFisico.getText());
			// pessoaFisica.getAdotante().setEmail(textEmail.getText());
			// pessoaFisica.getAdotante().setTelefoneFixo(textTelefoneFixo.getText());
			// pessoaFisica.getAdotante().setTelefoneCelular(textCelular.getText());
			// pessoaFisica.getAdotante().setEndereco(endereco);
			//
			// pessoaFisicaService.adicionarPessoaFisicaService(pessoaFisica);
			// }

			/**
			 * VALIDAR DADOS DA PESSOA FISICA
			 * 
			 * @param validar
			 * @param nome
			 * @param genero
			 * @param telefoneFixo
			 * @param telefoneCelular
			 * @param cpf
			 * @param rg
			 * @param email
			 * @return
			 */
			public boolean validacaoDadosPF(String nome, String genero, String telefoneFixo, String telefoneCelular, String cpf, String rg,
					String email) {
				ValidacaoService validar = new ValidacaoService();
				boolean valido = false;

				if (validar.validarCadastroPf(cpf)) {
					if (validar.validarNome(nome)) {
						if (validar.validarSexoPessoaFisica(genero)) {
							if (validar.validarRg(rg)) {
								if (validar.validarEmail(email)) {
									valido = true;
								} else {
									JOptionPane.showMessageDialog(null, "Por favor, digite um email válido, usar formato - exemplo@exemplo.com",
											"ERROR", 0);
									valido = false;
								}
							} else {
								JOptionPane.showMessageDialog(null, "Por favor, digite um RG válido.", "ERROR", 0);
								valido = false;
							}
						} else {
							JOptionPane.showMessageDialog(null, "Por favor, selecione um gênero.", "ERROR", 0);
							valido = false;
						}
					} else {
						JOptionPane.showMessageDialog(null, "Por favor, digite o nome", "ERROR", 0);
						valido = false;
					}

				} else {
					JOptionPane.showMessageDialog(null, "Pessoa já cadastrada! Tente outro.", "ERROR", 0);
					textNomeFisico.setText("");
					textBairro.setText("");
					jFormattedTextCep.setText("");
					textCidade.setText("");
					jFormattedTextCpf.setText("");
					textComplemento.setText("");
					textEmail.setText("");
					textEstado.setText("");
					textNumero.setText("");
					textRua.setText("");
					formattedTextFieldTelefoneFixo.setText("");
					jFormattedTextTeljFormattedTextTel.setText("");
					textRG.setText("");

					textNomeFisico.requestFocus();
					valido = false;

				}
				return valido;
			}

			public boolean validacaoDadosEndereco(String rua, String numero, String cep, String bairro, String cidade, String estado) {
				ValidacaoService validar = new ValidacaoService();
				boolean valido;

				if (validar.validarRua(rua)) {
					if (validar.validarNumero(numero)) {
						if (validar.validarBairro(bairro)) {
							if (validar.validarCidade(cidade)) {
								if (validar.validarEstado(estado)) {
									valido = true;
								} else {
									JOptionPane.showMessageDialog(null, "Por favor, digite um estado válido.", "ERROR", 0);
									valido = false;
								}
							} else {
								JOptionPane.showMessageDialog(null, "Por favor, digite uma cidade válida.", "ERROR", 0);
								valido = false;
							}
						} else {
							JOptionPane.showMessageDialog(null, "Por favor, digite um bairro válido.", "ERROR", 0);
							valido = false;
						}

					} else {
						JOptionPane.showMessageDialog(null, "Por favor, digite um número válido.", "ERROR", 0);
						valido = false;
					}
				} else {
					JOptionPane.showMessageDialog(null, "Por favor, digite uma rua válida.", "ERROR", 0);
					valido = false;
				}
				return valido;
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
				jFormattedTextCep.setText("");
				textCidade.setText("");
				jFormattedTextCpf.setText("");
				textComplemento.setText("");
				textEmail.setText("");
				textEstado.setText("");
				textNumero.setText("");
				textRua.setText("");
				formattedTextFieldTelefoneFixo.setText("");
				jFormattedTextTeljFormattedTextTel.setText("");
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

		JButton btnVoltar = new JButton("Cancelar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroPessoaGUI c = new CadastroPessoaGUI();
				c.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(335, 382, 113, 23);
		contentPane.add(btnVoltar);

		JLabel lblRg = new JLabel("RG: ");
		lblRg.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblRg.setBounds(364, 149, 46, 14);
		contentPane.add(lblRg);

		textRG = new JTextField();
		textRG.setBounds(420, 147, 154, 20);
		contentPane.add(textRG);
		textRG.setColumns(10);

		JLabel lblGenero = new JLabel("Sexo:");
		lblGenero.setBounds(479, 83, 46, 14);
		contentPane.add(lblGenero);

		comboGenero = new JComboBox<String>();
		comboGenero.setModel(new DefaultComboBoxModel<String>(new String[] { " ", "M", "F" }));
		comboGenero.setBounds(518, 80, 53, 20);
		contentPane.add(comboGenero);
	}
}
