package adotante.gui;

import infraestrutura.service.ValidacaoService;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
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
import adotante.dominio.PessoaJuridica;
import adotante.service.PessoaJuridicaService;

import javax.swing.JFormattedTextField;

public class CadastroAdotanteJuridicoGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNomeJuridico;
	private JTextField textCNPJ;
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
	private JFormattedTextField jFormattedTextCpf;
	private JLabel lblMostraNomeResponsavel;
	private PessoaFisica pessoaFisica;

	/**
	 * Create the frame.
	 */
	public CadastroAdotanteJuridicoGUI() {
		setTitle("Cadastro de Pessoa Juridica - Abrace um PET");
		setBounds(100, 100, 645, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCadastroDeUsurioJuridico = new JLabel(
				"Cadastro de Usu\u00E1rio Jur\u00EDdico");
		lblCadastroDeUsurioJuridico.setFont(new Font("Microsoft YaHei",
				Font.BOLD, 14));
		lblCadastroDeUsurioJuridico.setBounds(9, 16, 225, 14);
		contentPane.add(lblCadastroDeUsurioJuridico);

		JLabel lblNomeJuridico = new JLabel("Nome Juridico: ");
		lblNomeJuridico.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		lblNomeJuridico.setBounds(51, 82, 118, 14);
		contentPane.add(lblNomeJuridico);

		textNomeJuridico = new JTextField();
		textNomeJuridico.setBounds(173, 80, 409, 20);
		contentPane.add(textNomeJuridico);
		textNomeJuridico.setColumns(10);
		
		JLabel lblEnderecoEmpresarial = new JLabel("Endere\u00E7o Juridico: ");
		lblEnderecoEmpresarial.setFont(new Font("Microsoft YaHei", Font.PLAIN,
				12));
		lblEnderecoEmpresarial.setBounds(33, 223, 114, 14);
		contentPane.add(lblEnderecoEmpresarial);

		JLabel lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblRua.setBounds(53, 251, 46, 14);
		contentPane.add(lblRua);

		JLabel lblDadosEmpresariais = new JLabel("Dados Juridicos: ");
		lblDadosEmpresariais
				.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblDadosEmpresariais.setBounds(25, 54, 132, 14);
		contentPane.add(lblDadosEmpresariais);
		
		JLabel lblCpf = new JLabel("CNPJ: ");
		lblCpf.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblCpf.setBounds(51, 149, 46, 14);
		contentPane.add(lblCpf);

		textCNPJ = new JTextField();
		textCNPJ.setBounds(173, 147, 118, 20);
		contentPane.add(textCNPJ);
		textCNPJ.setColumns(10);

		textRua = new JTextField();
		textRua.setBounds(175, 249, 275, 20);
		contentPane.add(textRua);
		textRua.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblBairro.setBounds(384, 280, 46, 14);
		contentPane.add(lblBairro);

		textBairro = new JTextField();
		textBairro.setBounds(440, 283, 142, 20);
		contentPane.add(textBairro);
		textBairro.setColumns(10);

		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblNumero.setBounds(457, 251, 65, 14);
		contentPane.add(lblNumero);

		textNumero = new JTextField();
		textNumero.setBounds(518, 249, 65, 20);
		contentPane.add(textNumero);
		textNumero.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblCidade.setBounds(53, 312, 46, 14);
		contentPane.add(lblCidade);

		textCidade = new JTextField();
		textCidade.setBounds(175, 310, 187, 20);
		contentPane.add(textCidade);
		textCidade.setColumns(10);

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblEstado.setBounds(384, 314, 46, 14);
		contentPane.add(lblEstado);

		textEstado = new JTextField();
		textEstado.setBounds(440, 310, 143, 20);
		contentPane.add(textEstado);
		textEstado.setColumns(10);

		JLabel lblCep = new JLabel("CEP: ");
		lblCep.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblCep.setBounds(53, 285, 46, 14);
		contentPane.add(lblCep);

		textCEP = new JTextField();
		textCEP.setBounds(175, 280, 187, 20);
		contentPane.add(textCEP);
		textCEP.setColumns(10);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ValidacaoService validar = new ValidacaoService();
				pessoaFisica = new PessoaFisica();
				PessoaJuridicaService pessoaJuridicaService = new PessoaJuridicaService();
				pessoaFisica = pessoaJuridicaService.consultarRepresentante(jFormattedTextCpf.getText());
				
				if((validar.validarCpfResponsavelJuridico(pessoaFisica.getCpf()))){
					lblMostraNomeResponsavel.setText(pessoaFisica.getPessoa().getNome());
				}
				else{
					lblMostraNomeResponsavel.setText("");
				}
			}
		});
		btnConsultar.setBounds(507, 181, 112, 23);
		contentPane.add(btnConsultar);
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PessoaJuridica pessoaJuridica = new PessoaJuridica();
				PessoaJuridicaService pessoaJuridicaService = new PessoaJuridicaService();
				
				Endereco endereco = new Endereco();
				Pessoa pessoa = new Pessoa();
				
				endereco.setRua(textRua.getText());
				endereco.setNumero(textNumero.getText());
				endereco.setBairro(textBairro.getText());
				endereco.setCep(textCEP.getText());
				endereco.setCidade(textCidade.getText());
				endereco.setEstado(textEstado.getText());
				endereco.setComplemento(textComplemento.getText());
				
				pessoa.setNome(textNomeJuridico.getText());
				pessoa.setEmail(textEmail.getText());
				pessoa.setTelefoneFixo(textTelefoneFixo.getText());
				pessoa.setTelefoneCelular(textCelular.getText());
				pessoa.setEndereco(endereco);

				pessoaJuridica.setCnpj(textCNPJ.getText());
				pessoaJuridica.setResponsavel(pessoaFisica);
				pessoaJuridica.setPessoa(pessoa);
				System.out.println(pessoaJuridica.getResponsavel().getId());
				String numero = endereco.getNumero();
				String rua = endereco.getRua();
				String cep = endereco.getCep();
				String bairro = endereco.getBairro();
				String cidade = endereco.getCidade();
				String estado = endereco.getEstado();
				
				String nome = pessoaJuridica.getPessoa().getNome();
				String email = pessoaJuridica.getPessoa().getEmail();
				String telefoneFixo = pessoaJuridica.getPessoa().getTelefoneFixo();
				String telefoneCelular = pessoaJuridica.getPessoa().getTelefoneCelular();
				String cnpj = pessoaJuridica.getCnpj();
				
				if((validarPessoaJuridica(pessoaJuridica, pessoaJuridicaService, numero, rua, cep, bairro, cidade, estado, nome, telefoneFixo, telefoneCelular, cnpj, email))
						&&	(validarEndereco(numero, rua, cep, bairro, cidade, estado))){
					if (pessoaJuridicaService.adicionarPessoaJuridicaService(pessoaJuridica)) {
						JOptionPane.showMessageDialog(null, "Adotante juridico cadastrado com sucesso");
						CadastroPessoaGUI cadastroAdotante = new CadastroPessoaGUI();
						cadastroAdotante.setVisible(true);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "O cadastro do adotante juridico n�o pode ser realizado, tente novamente!", "ERROR", 0);
					}
				}
			}

			/**
			 * @param pessoaJuridica
			 * @param pessoaJuridicaService
			 * @param numero
			 * @param rua
			 * @param cep
			 * @param bairro
			 * @param cidade
			 * @param estado
			 * @param nome
			 * @param telefoneFixo
			 * @param telefoneCelular
			 * @param cnpj
			 */
			public boolean validarPessoaJuridica(PessoaJuridica pessoaJuridica, PessoaJuridicaService pessoaJuridicaService, String numero, String rua, String cep, String bairro,
					String cidade, String estado, String nome, String telefoneFixo, String telefoneCelular, String cnpj, String email) {
				ValidacaoService validar = new ValidacaoService();
				boolean valido = false;
				
				if(validar.validarNome(nome)){
					if((validar.validarTelefoneFixo(telefoneFixo))){
						if(validar.validarCelular(telefoneCelular)){
							if(validar.validarCnpj(cnpj)){
								if(validar.validarEmail(email)){
									valido = true;
								}else{
									JOptionPane.showMessageDialog(null, "Por favor, digite um email v�lido, usar formato - exemplo@exemplo.com", "ERROR", 0);
									valido = false;
								}
							}else{
								JOptionPane.showMessageDialog(null, "Por favor, digite um CNPJ v�lido.", "ERROR", 0);
								valido = false;
							}
						}else{
							JOptionPane.showMessageDialog(null, "Por favor, digite um n�mero de celular v�lido.", "ERROR", 0);
							valido = false;
						}
					}else{
						JOptionPane.showMessageDialog(null, "Por favor, digite um n�mero de telefone fixo v�lido.", "ERROR", 0);
						valido = false;
					}
				}else{
					JOptionPane.showMessageDialog(null, "Por favor, digite o nome", "ERROR", 0);
					valido = false;
				}return valido;
				
			}


			/**
			 * @param pessoaJuridica
			 * @param pessoaJuridicaService
			 * @param numero
			 * @param rua
			 * @param cep
			 * @param bairro
			 * @param cidade
			 * @param estado
			 * @return 
			 */
			public boolean validarEndereco(String numero, String rua, String cep, String bairro,
					String cidade, String estado) {
				
				ValidacaoService validar = new ValidacaoService();
				boolean valido;
				
					if (validar.validarRua(rua)) {
						if (validar.validarNumero(numero)) {
							if (validar.validarCep(cep)) {
								if (validar.validarBairro(bairro)) {
									if (validar.validarCidade(cidade)) {
										if (validar.validarEstado(estado)) {
											valido = true;
										} else {
											JOptionPane.showMessageDialog(null, "Por favor, digite um estado v�lido.", "ERROR", 0);
											valido = false;
										}
									} else {
										JOptionPane.showMessageDialog(null, "Por favor, digite uma cidade v�lida.", "ERROR", 0);
										valido = false;
									}
								} else {
									JOptionPane.showMessageDialog(null, "Por favor, digite um bairro v�lido.", "ERROR", 0);
									valido = false;
								}
							} else {
								JOptionPane.showMessageDialog(null, "Por favor, digite um cep v�lido. - Por exemplo: 00000000.", "ERROR", 0);
								valido = false;
							}
						} else {
							JOptionPane.showMessageDialog(null, "Por favor, digite um n�mero v�lido.", "ERROR", 0);
							valido = false;
						}
					} else {
						JOptionPane.showMessageDialog(null, "Por favor, digite uma rua v�lida.", "ERROR", 0);
						valido = false;
					}return valido;
				}

		});
		btnCadastrar.setBounds(273, 382, 110, 23);
		contentPane.add(btnCadastrar);

		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblComplemento.setBounds(53, 341, 89, 14);
		contentPane.add(lblComplemento);

		textComplemento = new JTextField();
		textComplemento.setBounds(175, 341, 407, 20);
		contentPane.add(textComplemento);
		textComplemento.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBounds(33, 209, 563, 14);
		contentPane.add(separator);

		JLabel lblResponsavel = new JLabel("Responsavel(CPF):");
		lblResponsavel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblResponsavel.setBounds(51, 184, 118, 14);
		contentPane.add(lblResponsavel);
		
		MaskFormatter mascaraCpf = null;
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
		} catch (ParseException e1) {
			System.err.println("Erro na formata��o: " + e1.getMessage());
            System.exit(-1);
		}
		jFormattedTextCpf = new JFormattedTextField(mascaraCpf);
		jFormattedTextCpf.setBounds(173, 182, 118, 20);
		contentPane.add(jFormattedTextCpf);
		
		JButton btnLimparCampos = new JButton("Limpar Campos");
		btnLimparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textNomeJuridico.setText("");
				textBairro.setText("");
				textCEP.setText("");
				textCidade.setText("");
				textCNPJ.setText("");
				textComplemento.setText("");
				textEmail.setText("");
				textEstado.setText("");
				textNumero.setText("");
				jFormattedTextCpf.setText("");
				textRua.setText("");
				textTelefoneFixo.setText("");
				textCelular.setText("");
				textNomeJuridico.requestFocus();
			}
		});
		btnLimparCampos.setBounds(129, 382, 134, 23);
		contentPane.add(btnLimparCampos);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setBounds(492, 382, 89, 23);
		contentPane.add(btnSair);

		JLabel lblTelefoneJuridico2 = new JLabel("Celular:");
		lblTelefoneJuridico2
				.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblTelefoneJuridico2.setBounds(364, 118, 65, 14);
		contentPane.add(lblTelefoneJuridico2);

		textCelular = new JTextField();
		textCelular.setBounds(420, 116, 161, 20);
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
		lblEmail.setBounds(301, 149, 46, 14);
		contentPane.add(lblEmail);

		textEmail = new JTextField();
		textEmail.setBounds(364, 147, 217, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroPessoaGUI c = new CadastroPessoaGUI();
				c.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBounds(393, 382, 89, 23);
		contentPane.add(btnCancelar);
		
		lblMostraNomeResponsavel = new JLabel("");
		lblMostraNomeResponsavel.setBounds(308, 185, 187, 14);
		contentPane.add(lblMostraNomeResponsavel);
	}
}
