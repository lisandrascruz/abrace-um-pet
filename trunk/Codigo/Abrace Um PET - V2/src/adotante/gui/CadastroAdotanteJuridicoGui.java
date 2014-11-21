package adotante.gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField;

import adotante.dominio.Adotante;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import dao.Conexao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("unused")
public class CadastroAdotanteJuridicoGui extends JFrame {

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
	private JTextField textResponsavel;
	private JTextField textTelefoneSecundario;
	private JTextField textTelefonePrincipal;
	private JTextField textEmail;



	/**
	 * Create the frame.
	 */
	public CadastroAdotanteJuridicoGui() {
		setTitle("Cadastro de Pessoa Juridica - Abrace um PET");
		setBounds(100, 100, 645, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDeUsurioJuridico = new JLabel("Cadastro de Usu\u00E1rio Jur\u00EDdico");
		lblCadastroDeUsurioJuridico.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblCadastroDeUsurioJuridico.setBounds(9, 16, 225, 14);
		contentPane.add(lblCadastroDeUsurioJuridico);
		
		JLabel lblNomeJuridico = new JLabel("Nome Juridico: ");
		lblNomeJuridico.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		lblNomeJuridico.setBounds(51, 82, 118, 14);
		contentPane.add(lblNomeJuridico);
		
		textNomeJuridico = new JTextField();
		textNomeJuridico.setBounds(173, 80, 395, 20);
		contentPane.add(textNomeJuridico);
		textNomeJuridico.setColumns(10);
		
		JLabel lblEnderecoEmpresarial = new JLabel("Endere\u00E7o Juridico: ");
		lblEnderecoEmpresarial.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblEnderecoEmpresarial.setBounds(33, 223, 114, 14);
		contentPane.add(lblEnderecoEmpresarial);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblRua.setBounds(53, 251, 46, 14);
		contentPane.add(lblRua);
		
		JLabel lblDadosEmpresariais = new JLabel("Dados Juridicos: ");
		lblDadosEmpresariais.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
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
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		
		textResponsavel = new JTextField();
		textResponsavel.setBounds(173, 182, 171, 20);
		contentPane.add(textResponsavel);
		textResponsavel.setColumns(10);
		
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
				textResponsavel.setText("");
				textRua.setText("");
				textTelefonePrincipal.setText("");
				textTelefoneSecundario.setText("");
				textNomeJuridico.requestFocus();
			}
		});
		btnLimparCampos.setBounds(129, 382, 134, 23);
		contentPane.add(btnLimparCampos);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancelar.setBounds(492, 382, 89, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblTelefoneJuridico2 = new JLabel("Celular:");
		lblTelefoneJuridico2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblTelefoneJuridico2.setBounds(364, 118, 65, 14);
		contentPane.add(lblTelefoneJuridico2);
		
		textTelefoneSecundario = new JTextField();
		textTelefoneSecundario.setBounds(420, 116, 161, 20);
		contentPane.add(textTelefoneSecundario);
		textTelefoneSecundario.setColumns(10);
		
		JLabel lblTelefoneFixo = new JLabel("Telefone Fixo:");
		lblTelefoneFixo.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblTelefoneFixo.setBounds(51, 118, 122, 14);
		contentPane.add(lblTelefoneFixo);
		
		textTelefonePrincipal = new JTextField();
		textTelefonePrincipal.setBounds(173, 116, 171, 20);
		contentPane.add(textTelefonePrincipal);
		textTelefonePrincipal.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblEmail.setBounds(301, 149, 46, 14);
		contentPane.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(364, 147, 217, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroAdotante c = new CadastroAdotante();
				c.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(393, 382, 89, 23);
		contentPane.add(btnVoltar);
	}
}
