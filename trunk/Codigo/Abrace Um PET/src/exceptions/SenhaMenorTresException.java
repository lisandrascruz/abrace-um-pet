package exceptions;

import javax.swing.JOptionPane;

public class SenhaMenorTresException {
	
	public SenhaMenorTresException(){
		JOptionPane.showMessageDialog(null, "A senha deve conter pelo menos 3 digitodfssd0s", "ERROR", 0);
	}
}
