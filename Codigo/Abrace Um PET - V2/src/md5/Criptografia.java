package md5;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Criptografia {
	
	public void criptografar(String senha){
		try {
			MessageDigest md;
			md = MessageDigest.getInstance("MD5");
			md.update(senha.getBytes(), 0, senha.length());
			senha = (new BigInteger(1, md.digest()).toString(16));
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}