package usuario.gui.imagem;

import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Imagens {
	public static void imagemLogin(JLabel label) {
		try {
			label.setIcon(new ImageIcon(new File("imagens/login.png").getCanonicalPath()));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static void imagemCadastro(JButton button) {
		try {
			button.setIcon(new ImageIcon(new File("imagens/cadastro.png").getCanonicalPath()));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
