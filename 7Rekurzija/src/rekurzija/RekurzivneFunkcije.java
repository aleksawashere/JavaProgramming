package rekurzija;

public class RekurzivneFunkcije {

	
	//Proizvod svih cifara
	
	
	static int ProizvodCifaraR(int broj){
		
		if(broj == 0){
			return 0;
		}
		
		return ProizvodCifara(Math.abs(broj));
		
	}
	
	private static int ProizvodCifara(int broj){
		//12345
		
		if(broj == 0){
			return 1;
		}
		
		int zadnja = broj % 10;
		int ostatak = broj / 10;
		
		int proizvod = zadnja * ProizvodCifara(ostatak);
		return proizvod;
		
		
	}
	
	
	// Ispis niza
	
	static void IspisiNizR(int[] niz){
		
		if(niz == null){
			throw new RuntimeException("NIz ne postoji;");
		}
		
		if(niz.length == 0){
			System.out.println("Niz nema elemente, prazan je.");
			return;
		}
		
		IspisiNiz(niz,0);
		
	}
	
	static void IspisiNiz(int[] niz, int index){
		
		if(index == niz.length){
			return;
		}
		
		System.out.println(niz[index] + " ");
		IspisiNiz(niz, index+1);
		
	}
	

	
	
	
	
	
}
