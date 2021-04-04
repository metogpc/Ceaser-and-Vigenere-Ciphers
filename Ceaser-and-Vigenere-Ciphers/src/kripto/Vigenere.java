package kripto;

import java.util.ArrayList;


public class Vigenere extends Cipher{

	//Tablo ArrayListinde alfabemizi tutuyoruz.
	//anahtarSayilari fonksiyonunda girilen Kelimenin harflerin tablodaki sayı karşılığını bir diziye aktarıp diziyi donduruyoruz.
	//Bunları yapmamın sebebi tum isleri ASCII tablosuna gore yapmaktansa daha anlasılır ve okunur bir kod olması
	
	private ArrayList<Character> tablo=new ArrayList<Character>();
	
	public Vigenere() {
		// TODO Auto-generated constructor stub
		tabloDoldur(tablo);
	}
	
	private void tabloDoldur(ArrayList<Character> tablo) {
		for(int j=65;j<91;j++) {
			a=(char) j;
			tablo.add(a);
		}
	}
	
	/*
	private void tabloYazdir(ArrayList<Character> tablo) {	 //Harf tablomuzu gormek icin
		for(int i=0;i<tablo.size();i++) 
			System.out.println(tablo.get(i));
	}
	*/
	
	private int[] anahtarSayilari(int[] dizi , String anahtar, ArrayList<Character> tablo) {
		
		for(int i=0;i<anahtar.length();i++)
			dizi[i]=tablo.indexOf(anahtar.charAt(i));
		
		return dizi;
	}
	
	@Override
	String encrypt(String orjinalMetin, String anahtar) {
		// TODO Auto-generated method stub
		int a;
		int b=0;
		String sifreliMetin="";
		int[] dizi=new int[anahtar.length()];
		
		dizi=anahtarSayilari(dizi, anahtar, tablo);
		
		for(int i=0;i<orjinalMetin.length();i++) {
			if(b>=dizi.length) 
				b=0;
			
			if(tablo.size()<dizi[b]+tablo.indexOf(orjinalMetin.charAt(i))){
				a=dizi[b]+tablo.indexOf(orjinalMetin.charAt(i))-tablo.size();
				sifreliMetin+=tablo.get(a);
			}
			else 
				sifreliMetin+=tablo.get(dizi[b]+tablo.indexOf(orjinalMetin.charAt(i)));
			
			
			b++;

		}
		return "Orjinal Metin:"+orjinalMetin+" Sifreli metin:"+sifreliMetin;
	}

	@Override
	String decrypt(String sifreliMetin, String anahtar) {
		// TODO Auto-generated method stub
		String orjinalMetin="";
		int a;
		int b=0;
		tabloDoldur(tablo);
		int[] dizi=new int[anahtar.length()];
		
		dizi=anahtarSayilari(dizi, anahtar, tablo);
		
		for(int i=0;i<sifreliMetin.length();i++) {
			if(b>=dizi.length)
				b=0;
			
			if(0>tablo.indexOf(sifreliMetin.charAt(i))-dizi[b]){

				a=tablo.size()+(tablo.indexOf(sifreliMetin.charAt(i))-dizi[b]);
				orjinalMetin+=tablo.get(a);
		
			
			}
			else 
				orjinalMetin+=tablo.get(tablo.indexOf(sifreliMetin.charAt(i))-dizi[b]);
			
			b++;

		}
		
		return "Sifreli Metin:"+sifreliMetin+" Orjinal Metin:"+orjinalMetin;
	}

}
