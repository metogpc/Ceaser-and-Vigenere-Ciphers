package kripto;


public abstract class Cipher {

	protected char a;
	
	abstract String encrypt(String orjinalMetin, String anahtar);
	abstract String decrypt(String sifreliMetin , String anahtar);
	

	
	
	
	
}
