package animal.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import usuario.gui.LoginGUI;
import usuario.gui.TelaInicialGUI;
import animal.dao.RacaDAO;
import animal.dominio.Animal;
import animal.dominio.Raca;
import animal.service.AnimalService;

public class CadastroAnimalGUI extends JFrame {
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	private JPanel				contentPane;
	private JTextField			textFieldNome;
	private JLabel				lblTipo;
	private JTextField			textFieldRGA;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroAnimalGUI frame = new CadastroAnimalGUI();
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
	public CadastroAnimalGUI(){
		setTitle("Cadastro de Animal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDeAnimais = new JLabel("Cadastro de Animal\r\n");
		lblCadastroDeAnimais.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblCadastroDeAnimais.setBounds(10, 30, 179, 14);
		contentPane.add(lblCadastroDeAnimais);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblNome.setBounds(10, 79, 46, 14);
		contentPane.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(76, 77, 289, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		lblTipo = new JLabel("Tipo: ");
		lblTipo.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblTipo.setBounds(10, 121, 46, 14);
		contentPane.add(lblTipo);
		
		JLabel lblRga = new JLabel("RGA: ");
		lblRga.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblRga.setBounds(375, 79, 38, 14);
		contentPane.add(lblRga);
		
		textFieldRGA = new JTextField();
		textFieldRGA.setBounds(419, 77, 200, 20);
		contentPane.add(textFieldRGA);
		textFieldRGA.setColumns(10);
		
		JLabel lblRaa = new JLabel("Ra\u00E7a: ");
		lblRaa.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblRaa.setBounds(212, 121, 46, 14);
		contentPane.add(lblRaa);
		
		JComboBox<Raca> comboBoxRaca = new JComboBox<Raca>();
		comboBoxRaca.setBounds(281, 119, 149, 20);
		contentPane.add(comboBoxRaca);
		listaRacas(comboBoxRaca);
		
		JComboBox<String> comboBoxTipo = new JComboBox<String>();
		comboBoxTipo.setModel(new DefaultComboBoxModel<String>(new String[] { "", "Gato", "Cachorro" }));
		comboBoxTipo.setToolTipText("");
		comboBoxTipo.setBounds(76, 119, 110, 20);
		contentPane.add(comboBoxTipo);
		
		
		JLabel lblNewLabel = new JLabel("Data de Nascimento: ");
		lblNewLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblNewLabel.setBounds(212, 207, 126, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblGnero = new JLabel("G\u00EAnero: ");
		lblGnero.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblGnero.setBounds(463, 121, 55, 14);
		contentPane.add(lblGnero);
		
		JComboBox<String> comboBoxGenero = new JComboBox<String>();
		comboBoxGenero.setModel(new DefaultComboBoxModel<String>(new String[] { "", "Macho", "F\u00EAmea" }));
		comboBoxGenero.setBounds(541, 119, 78, 20);
		contentPane.add(comboBoxGenero);
		
		JLabel lblDeficiencia = new JLabel("Deficiencia: ");
		lblDeficiencia.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblDeficiencia.setBounds(212, 162, 69, 14);
		contentPane.add(lblDeficiencia);
		
		JComboBox<String> comboBoxDeficiencia = new JComboBox<String>();
		comboBoxDeficiencia.setModel(new DefaultComboBoxModel<String>(new String[] { "", "Nenhuma", "Auditiva", "Fisica", "Mental", "Visual" }));
		comboBoxDeficiencia.setBounds(281, 160, 149, 20);
		contentPane.add(comboBoxDeficiencia);
		
		JLabel lblVacinadoa = new JLabel("Vacinado(a):");
		lblVacinadoa.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblVacinadoa.setBounds(463, 162, 78, 14);
		contentPane.add(lblVacinadoa);
		
		JComboBox<String> comboBoxVacinado = new JComboBox<String>();
		comboBoxVacinado.setModel(new DefaultComboBoxModel<String>(new String[] { "", "Sim", "N\u00E3o" }));
		if (comboBoxVacinado.equals("Sim")) {
			comboBoxVacinado.setSelectedIndex(1);
		} else {
			comboBoxVacinado.setSelectedIndex(0);
		}
		comboBoxVacinado.setBounds(541, 160, 78, 20);
		contentPane.add(comboBoxVacinado);
		
		JLabel lblCastrado = new JLabel("Castrado: ");
		lblCastrado.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblCastrado.setBounds(10, 162, 69, 14);
		contentPane.add(lblCastrado);
		
		JComboBox<String> comboBoxCastrado = new JComboBox<String>();
		comboBoxCastrado.setModel(new DefaultComboBoxModel<String>(new String[] { "", "Sim", "N\u00E3o" }));
		if (comboBoxCastrado.equals("Sim")) {
			comboBoxCastrado.setSelectedIndex(0);
		} if(comboBoxCastrado.equals("N\u00E3o")) {
			comboBoxCastrado.setSelectedIndex(1);
		}
		comboBoxCastrado.setBounds(76, 160, 110, 20);
		contentPane.add(comboBoxCastrado);
		
		JLabel lblTamanho = new JLabel("Tamanho: ");
		lblTamanho.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblTamanho.setBounds(10, 207, 69, 14);
		contentPane.add(lblTamanho);
		
		MaskFormatter mascaraDataNascimento = null;
		try {
			mascaraDataNascimento = new MaskFormatter("##/####");
			mascaraDataNascimento.setPlaceholderCharacter('_');
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		JFormattedTextField formattedTextFieldDataNascimento = new JFormattedTextField(mascaraDataNascimento);
		formattedTextFieldDataNascimento.setBounds(350, 205, 63, 20);
		contentPane.add(formattedTextFieldDataNascimento);
		
		JLabel lblPeso = new JLabel("Peso: ");
		lblPeso.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblPeso.setBounds(469, 207, 38, 14);
		contentPane.add(lblPeso);
		
		MaskFormatter mascaraPeso = null;
		try {
			mascaraPeso = new MaskFormatter("##.##");
			mascaraDataNascimento.setPlaceholderCharacter('_');
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		JFormattedTextField formattedTextFieldPeso = new JFormattedTextField(mascaraPeso);
		formattedTextFieldPeso.setBounds(508, 205, 63, 20);
		contentPane.add(formattedTextFieldPeso);
		
		JLabel lblKg = new JLabel("Quilos");
		lblKg.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblKg.setBounds(581, 208, 38, 14);
		contentPane.add(lblKg);
		
		JLabel lblM = new JLabel("Metros");
		lblM.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblM.setBounds(147, 208, 42, 14);
		contentPane.add(lblM);
		
		JLabel lblTemperamento = new JLabel("Temperamento: ");
		lblTemperamento.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblTemperamento.setBounds(298, 244, 115, 14);
		contentPane.add(lblTemperamento);
		
		MaskFormatter mascaraTamanho = null;
		try {
			mascaraTamanho = new MaskFormatter("##.##");
			mascaraTamanho.setPlaceholderCharacter('_');
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		JFormattedTextField formattedTextFieldTamanho = new JFormattedTextField(mascaraTamanho);
		formattedTextFieldTamanho.setBounds(76, 205, 69, 20);
		contentPane.add(formattedTextFieldTamanho);
		
		JTextPane textPaneTemperamento = new JTextPane();
		textPaneTemperamento.setBounds(403, 244, 216, 30);
		contentPane.add(textPaneTemperamento);
		
		JLabel lblResgate = new JLabel("Data de Resgate: ");
		lblResgate.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblResgate.setBounds(10, 240, 110, 20);
		contentPane.add(lblResgate);
		
		MaskFormatter mascaraDataResgate = null;
		try {
			mascaraDataResgate = new MaskFormatter("##/##/####");
			mascaraDataResgate.setPlaceholderCharacter('_');
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		JFormattedTextField formattedTextFieldDataResgate = new JFormattedTextField(mascaraDataResgate);
		formattedTextFieldDataResgate.setBounds(116, 242, 86, 20);
		contentPane.add(formattedTextFieldDataResgate);
		
		JLabel lblObservaes = new JLabel("Observa\u00E7\u00F5es: ");
		lblObservaes.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		lblObservaes.setBounds(10, 292, 102, 14);
		contentPane.add(lblObservaes);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(106, 292, 513, 84);
		contentPane.add(textPane);
		
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI loginGUI = new LoginGUI();
				loginGUI.setVisible(true);
				dispose();
			}
		});
		btnSair.setBounds(509, 387, 110, 23);
		contentPane.add(btnSair);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnimalGUI animalGUI = new AnimalGUI();
				animalGUI.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBounds(389, 387, 110, 23);
		contentPane.add(btnCancelar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AnimalService animalService = new AnimalService();
				Animal animal = new Animal();
				
				animal.setNome(textFieldNome.getText());
				animal.setRga(textFieldRGA.getText());
				animal.setTipo(comboBoxTipo.getSelectedItem().toString());
				animal.setGenero(comboBoxGenero.getSelectedItem().toString());
				//animal.setTamanho(Double.parseDouble(comboBoxCastrado.getSelectedItem().toString()));
				animal.setDeficiencia(comboBoxDeficiencia.getSelectedItem().toString());
				//animal.setVacinado(comboBoxVacinado);
				//animal.setTamanho(Double.parseDouble(formattedTextFieldTamanho.getSelectedText()));
				animal.setDataNascimento(formattedTextFieldDataNascimento.getSelectedText());
				animal.setPeso(Double.parseDouble(formattedTextFieldPeso.getText()));
				animal.setDataResgate(formattedTextFieldDataResgate.getText());
				animal.setTemperamento(formattedTextFieldTamanho.getText());
				animal.setObservacao(textPane.getText());
				
				String rga = animal.getRga();
				animalService.adicionarAnimal(animal);
//				try {
//					if (animalService.validarCadastroAnimal(rga)) {
//						if (animalService.adicionarAnimal(animal)) {
//							JOptionPane.showMessageDialog(null, "Animal cadastrado com sucesso");
//							TelaInicialGUI telaInicialGui = new TelaInicialGUI();
//							telaInicialGui.setVisible(true);
//							dispose();
//						} else {
//							JOptionPane.showMessageDialog(null, "O cadastro não pode ser realizado, tente novamente!", "ERROR", 0);
//							
//						}
//					}
//				} catch (HeadlessException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			}
		});
		btnCadastrar.setBounds(262, 387, 110, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnLimparCampos = new JButton("Limpar Campos");
		btnLimparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btnLimparCampos.setBounds(106, 387, 134, 23);
		contentPane.add(btnLimparCampos);
		
		JLabel lblMesano = new JLabel("Mes/Ano");
		lblMesano.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblMesano.setBounds(419, 208, 46, 14);
		contentPane.add(lblMesano);
		
		JLabel lblDiamesano = new JLabel("Dia/Mes/Ano");
		lblDiamesano.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblDiamesano.setBounds(212, 245, 69, 14);
		contentPane.add(lblDiamesano);
		
		JButton btnTeste = new JButton("TESTE");
		btnTeste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnTeste.setBounds(172, 150, 89, 23);
		contentPane.add(btnTeste);
		
		
	}

	/**
	 * @param comboBoxRaca
	 */
	public void listaRacas(JComboBox<Raca> comboBoxRaca) {
		RacaDAO racaDAO = new RacaDAO();
		DefaultComboBoxModel<Raca> modelRacas = null;
		try {
			modelRacas = new DefaultComboBoxModel(racaDAO.getRaca().toArray());
			
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		comboBoxRaca.setModel(modelRacas);
	}

}
