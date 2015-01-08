package animal.gui.consultar;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import animal.dominio.Animal;
import animal.gui.AnimalGUI;
import animal.service.AnimalService;

public class ConsultarAnimalRGAGUI extends JFrame {
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	private JPanel	contentPane;
	protected JTextField textFieldRGA;

	/**
	 * Create the frame.
	 */
	public ConsultarAnimalRGAGUI(){
		setTitle("Consulta de Animal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblConsultarAnimal = new JLabel("Consulta de Animal");
		lblConsultarAnimal.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblConsultarAnimal.setBounds(28, 62, 193, 14);
		contentPane.add(lblConsultarAnimal);
		
		
		JLabel lblRga = new JLabel("RGA: ");
		lblRga.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		lblRga.setBounds(152, 218, 46, 14);
		contentPane.add(lblRga);
		
		textFieldRGA = new JTextField();
		textFieldRGA.setBounds(190, 216, 188, 20);
		contentPane.add(textFieldRGA);
		textFieldRGA.setColumns(10);
		
		JButton btnConsultarRGA = new JButton("Consultar");
		btnConsultarRGA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					consultarAnimalRGA(textFieldRGA);
			}
			
			public void consultarAnimalRGA(JTextField textFieldRGA) {		
				try{
					ConsultarAnimalGUI consulta = new ConsultarAnimalGUI();
					AnimalService as = new AnimalService();
					Animal animal = new Animal();
				
					animal = as.consultarAnimal(textFieldRGA.getText());
					
					consulta.textFieldNome.setText(animal.getNome());
					consulta.textFieldRGA.setText(animal.getRga());
					consulta.texTemperamento.setText(animal.getTemperamento());
					consulta.textField.setText(animal.getObservacao());
					consulta.formattedTextFieldDataNascimento.setText(animal.getDataNascimento());
					consulta.formattedTextFieldDataResgate.setText(animal.getDataResgate());
					consulta.formattedTextFieldPeso.setText(String.valueOf(animal.getPeso()));
					consulta.formattedTextFieldTamanho.setText(String.valueOf(animal.getTamanho()));
					consulta.comboBoxCastrado.setSelectedItem(animal.getCastrado());
					consulta.comboBoxDeficiencia.setSelectedItem(animal.getDeficiencia());
					consulta.comboBoxGenero.setSelectedItem(animal.getGenero());
					consulta.comboBoxTipo.setSelectedItem(animal.getTipo());
					consulta.comboBoxVacinado.setSelectedItem(animal.getVacinado());
					consulta.animal = animal;
					if(animal.getId() != 0){
						consulta.setVisible(true);
						dispose();
					} else{
						JOptionPane.showMessageDialog(null, "Não encontrado", "ERROR", 0);
					}
				
				} catch(Exception ex){
					JOptionPane.showMessageDialog(null, ex, "ERROR", 0);
				}
				
			}
		});
		btnConsultarRGA.setBounds(388, 215, 89, 23);
		contentPane.add(btnConsultarRGA);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AnimalGUI a = new AnimalGUI();
				a.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(530, 383, 89, 23);
		contentPane.add(btnVoltar);
	}
}
