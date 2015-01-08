package animal.raca.gui.consulta;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import animal.gui.consultar.ConsultarAnimalRGAGUI;
import animal.raca.dominio.Raca;
import animal.raca.gui.RacaGUI;
import animal.raca.service.RacaService;
import animal.service.AnimalService;
import animal.service.Validacoes;

public class ConsultaRacaGUI extends JFrame {
	
	private static final long		serialVersionUID	= 1L;
	protected Validacoes			validacoes			= new Validacoes();
	protected RacaService			racaService			= new RacaService();
	protected Raca					raca				= new Raca();
	protected JPanel				contentPane;
	protected JTextField			textFieldNome;
	protected JTextField			textFieldOrigem;
	protected JLabel				lblCadastroRacaCachorro;
	protected JFormattedTextField	formattedTextFieldTamanhoMaximo;
	protected JFormattedTextField	formattedTextFieldTamanhoMinimo;
	protected JFormattedTextField	formattedTextFieldExpectativaDeVida;
	protected JComboBox < ?>		comboBoxTipo;
	protected JEditorPane			editorPane;
	private JButton					btnEditar;
	private JButton					btnExcluir;
	
	/**
	 * Create the frame.
	 */
	public ConsultaRacaGUI(){
		setTitle("Consulta de Ra\u00E7a ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCadastroRacaCachorro = new JLabel("Consultar Ra\u00E7a ");
		lblCadastroRacaCachorro.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblCadastroRacaCachorro.setBounds(10, 28, 327, 14);
		contentPane.add(lblCadastroRacaCachorro);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblNome.setBounds(10, 108, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblOrigem = new JLabel("Origem:");
		lblOrigem.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblOrigem.setBounds(10, 149, 62, 17);
		contentPane.add(lblOrigem);
		
		JLabel lblTamanhoMaximo = new JLabel("Tamanho Maximo: ");
		lblTamanhoMaximo.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblTamanhoMaximo.setBounds(358, 106, 119, 14);
		contentPane.add(lblTamanhoMaximo);
		
		JLabel lblTamanhoMinimo = new JLabel("Tamanho Minimo: ");
		lblTamanhoMinimo.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblTamanhoMinimo.setBounds(358, 150, 109, 14);
		contentPane.add(lblTamanhoMinimo);
		
		JLabel lblExpectativaDeVida = new JLabel("Expectativa de vida: ");
		lblExpectativaDeVida.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblExpectativaDeVida.setBounds(358, 196, 130, 14);
		contentPane.add(lblExpectativaDeVida);
		
		textFieldNome = new JTextField();
		textFieldNome.setEditable(false);
		textFieldNome.setBounds(76, 106, 239, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldOrigem = new JTextField();
		textFieldOrigem.setEditable(false);
		textFieldOrigem.setBounds(76, 148, 239, 20);
		contentPane.add(textFieldOrigem);
		textFieldOrigem.setColumns(10);
		
		MaskFormatter mascaraTamanho = null;
		try {
			mascaraTamanho = new MaskFormatter("#.##");
			mascaraTamanho.setPlaceholderCharacter('_');
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Tamanho inválido!", "ERROR", 0);
			e.printStackTrace();
		}
		
		formattedTextFieldTamanhoMaximo = new JFormattedTextField(mascaraTamanho);
		formattedTextFieldTamanhoMaximo.setEditable(false);
		formattedTextFieldTamanhoMaximo.setBounds(489, 104, 62, 20);
		contentPane.add(formattedTextFieldTamanhoMaximo);
		
		formattedTextFieldTamanhoMinimo = new JFormattedTextField(mascaraTamanho);
		formattedTextFieldTamanhoMinimo.setEditable(false);
		formattedTextFieldTamanhoMinimo.setBounds(489, 148, 62, 20);
		contentPane.add(formattedTextFieldTamanhoMinimo);
		
		MaskFormatter mascaraExpectativaVida = null;
		try {
			mascaraExpectativaVida = new MaskFormatter("##");
			mascaraExpectativaVida.setPlaceholderCharacter('_');
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Tamanho inválido!", "ERROR", 0);
			e.printStackTrace();
		}
		
		formattedTextFieldExpectativaDeVida = new JFormattedTextField(mascaraExpectativaVida);
		formattedTextFieldExpectativaDeVida.setEditable(false);
		formattedTextFieldExpectativaDeVida.setBounds(489, 194, 62, 20);
		contentPane.add(formattedTextFieldExpectativaDeVida);
		
		comboBoxTipo = new JComboBox();
		comboBoxTipo.setToolTipText("Consulta");
		comboBoxTipo.setEnabled(false);
		comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] { "", "Gato", "Cachorro" }));
		comboBoxTipo.setBounds(76, 194, 101, 20);
		contentPane.add(comboBoxTipo);
		
		JLabel lblTemoeramento = new JLabel("Temperamento: ");
		lblTemoeramento.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblTemoeramento.setBounds(10, 261, 101, 20);
		contentPane.add(lblTemoeramento);
		
		editorPane = new JEditorPane();
		editorPane.setEditable(false);
		editorPane.setBounds(76, 292, 475, 75);
		contentPane.add(editorPane);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RacaGUI racaGUI = new RacaGUI();
				racaGUI.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBounds(462, 383, 89, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblTipo.setBounds(10, 195, 46, 17);
		contentPane.add(lblTipo);
		
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				camposEditaveis(btnCancelar);
			}
			
			/**
			 * DEIXA OS CAMPOS EDITAVEIS, OCULTA ALGUNS BOTOES E ATIVA OUTROS.
			 * @param btnCancelar
			 */
			private void camposEditaveis(JButton btnCancelar) {
				editorPane.setEditable(true);
				textFieldNome.setEditable(true);
				textFieldOrigem.setEditable(true);
				formattedTextFieldExpectativaDeVida.setEditable(true);
				formattedTextFieldTamanhoMaximo.setEditable(true);
				formattedTextFieldTamanhoMinimo.setEditable(true);
				
				JButton btnSalvar = new JButton("Salvar");
				btnSalvar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						RacaService rs = new RacaService();
						try {
							setarValores();
							rs.edicaoRaca(raca);
							JOptionPane.showMessageDialog(null, "Raça atualizada com sucesso");
							ConsultaRacaNomeGUI consultar = new ConsultaRacaNomeGUI();
							consultar.setVisible(true);
							dispose();
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null, ex, "Erro ao atualizar raça.", 0);
						}
					}
					/**
					 * MÉTODO PARA SETAR OS VALORES ATUALIZADOS
					 */
					private void setarValores() {
						raca.setNome(textFieldNome.getText());
						raca.setTipo(comboBoxTipo.getSelectedItem().toString());
						raca.setOrigem(textFieldOrigem.getText());
						raca.setTamanhoMax(Double.parseDouble(formattedTextFieldTamanhoMaximo.getText()));
						raca.setTamanhoMin(Double.parseDouble(formattedTextFieldTamanhoMinimo.getText()));
						raca.setExpectativaVida(Integer.parseInt(formattedTextFieldExpectativaDeVida.getText()));
						raca.setTemperamento(editorPane.getText());
					}
					
				});
				btnSalvar.setBounds(358, 383, 89, 23);
				contentPane.add(btnSalvar);
				
				btnEditar.setVisible(false);
				btnExcluir.setVisible(false);
				btnCancelar.setVisible(false);
				
				JButton btnCancelar2 = new JButton("Cancelar");
				btnCancelar2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ConsultarAnimalRGAGUI c = new ConsultarAnimalRGAGUI();
						c.setVisible(true);
						dispose();
					}
					
				});
				btnCancelar2.setBounds(462, 383, 89, 23);
				contentPane.add(btnCancelar2);
			}
			
		});
		btnEditar.setBounds(358, 383, 89, 23);
		contentPane.add(btnEditar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(253, 383, 89, 23);
		contentPane.add(btnExcluir);
		
	}
}
