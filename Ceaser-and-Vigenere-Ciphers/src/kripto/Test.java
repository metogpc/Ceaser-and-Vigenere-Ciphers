package kripto;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Ceaser cs=new Ceaser();
		Vigenere vg=new Vigenere();
		
		/*
		 * Ceaser şifrelemsinde buyuk , kucuk harf farketmiyor. Vigenere de ise sadece buyuk harf 
		 */
		System.out.println(cs.encrypt("MERHABA", "Metin")+"\n");
		
		System.out.println(cs.decrypt("RJWMFGF", "Metin"));
		
		System.out.println("\n******************************************************\n");

		System.out.println(vg.encrypt("MERHABA", "METIN"));	
		System.out.println(vg.decrypt("YIKPNNE", "METIN"));
		
	}

}
