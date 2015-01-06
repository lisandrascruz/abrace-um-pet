package usuario.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.JOptionPane;

public class CriptografiaService {

	public String criptografar(String senha) {
		try {
			MessageDigest md;
			md = MessageDigest.getInstance("MD5");
			md.update(senha.getBytes(), 0, senha.length());
			senha = (new BigInteger(1, md.digest()).toString(16));
		} catch (NoSuchAlgorithmException e1) {
			JOptionPane.showMessageDialog(null, e1, "ERROR", 0);
		}
		return senha;
	}
}
