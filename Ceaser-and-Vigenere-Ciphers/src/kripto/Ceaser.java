package kripto;

public class Ceaser extends Cipher{

	//ASCII tablosun da 65 ve 90 arası buyuk harfler icin 97 ve 122 arası kucuk harfler arası 
	
	@Override
	String encrypt(String orjinalMetin, String anahtar) {
		// TODO Auto-generated method stub
		
		String sifreliMetin="";

		for(int i=0;i<orjinalMetin.length(); i++) {
			
			a=orjinalMetin.charAt(i);
			
			if(91<a) {//Kucuk harf icin
				if(122<a+anahtar.length()) 
					a=(char) (96+(a+anahtar.length()-122));
				
				else
					a=(char) (a+anahtar.length());
			
			}
			
			else if(64<a) {//Buyuk harf icin
				
				if(90<a+anahtar.length()) 
					a=(char) (64+(a+anahtar.length()-90));
			
				else
					a=(char) (a+anahtar.length());
			
			}
			
			sifreliMetin +=a;
		}

		return "Orjinal metin:"+orjinalMetin+",anahtar:"+anahtar+",Sifreli metin:"+sifreliMetin;
	}
	
	@Override
	String decrypt(String sifreliMetin, String anahtar) {
		// TODO Auto-generated method stub
		
		String orjinalMetin="";
		
		for(int i=0;i<sifreliMetin.length(); i++) {
		
			a=sifreliMetin.charAt(i);
			if(90<a) {//Kucuk harf icin
				if(97>a-anahtar.length()) 
					a=(char) (123-(97-(a-anahtar.length())));
				
				else
					a=(char) (a-anahtar.length());
			
			}
			
			else if(64<a) {//Buyuk harf icin
				
				if(64>a-anahtar.length()) 
					a=(char) (90-(64-(a-anahtar.length())));
			
				else
					a=(char) (a-anahtar.length());
			
			}
			orjinalMetin +=a;
			
		}
		
		return "Sifreli metin:"+sifreliMetin+",anahtar:"+anahtar+",Orjinal metin:"+orjinalMetin;
	}

	
}
