package niz;

public class Niz {
	
	int[] niz;
	int broj = 0;
	
	public Niz(int kapacitet) {
		niz = new int[kapacitet];
	}
	
	//Ubacivanje na kraj niza, jednog elementa
	void ubacivanjeKraj(int brojNov){
		if(niz.length == broj){
			System.out.println("Nas niz je pun!");
			return;
		}
		
		niz[broj++] = brojNov;
	}
	
	//Ubacivanje na kraj niza putem niza parametara
	void ubacivanjeKraj(int... nekiNiz){
		for(int i = 0; i<nekiNiz.length; i++){
			ubacivanjeKraj(nekiNiz[i]);
		}
	}
	
	//Ubacivanje na pocetak niza, jednog elementa
	void ubacivanjePocetak(int noviBroj){
		
		if(broj == niz.length){
			System.out.println("Greska! Niz je pun.");
			return;
		}
		
		for(int i = broj; i>0; i--){
			niz[i] = niz[i-1];
		}
		
		niz[0] = noviBroj;
		broj++;
		
	}
	
	//Ubacivanje na pocetak niza putem niza parametara
		void ubacivanjePocetak(int... nekiNiz){
			for(int i = 0; i<nekiNiz.length; i++){
				ubacivanjePocetak(nekiNiz[i]);
			}
		}
	
	//Trazenje maksimalnog elementa niza
		int maxNiz(){
			
			if(broj == 0){
				throw new RuntimeException("Niz je prazan. Ne mogu vratiti maksimum.");
			}
			
			int max = niz[0];
			
			for(int i=0; i<broj; i++){
				if(niz[i] > max){
					max = niz[i];
				}
			}
			
			//System.out.println("Maksimalna vrednost: " + max);
			return max;
		}
	
	//Maksimalan negativan element
		int maxNegativ(){
			
			if(broj == 0){
				throw new RuntimeException("Niz je prazan. Ne mogu vratiti maksimum negativa.");
			}
			
			int max = Integer.MIN_VALUE;
			boolean uspesno = false;
			
			for(int i = 0; i<broj; i++){
				if(niz[i]<0 && niz[i]>max){
					max = niz[i];
					uspesno = true;
				}
			}
			
			if(uspesno){
				return max;
			}
			else{
				throw new RuntimeException("Ne postoji nijedan negativan element niza.");
			}
				
		}
		
	//Ubacivanje na tacan indeks niza
		void ubaciNaTacanIndeks(int noviBroj, int indeks){
			
			if(indeks < 0 || indeks > broj){
				System.out.println("Indeks nije dobro unet");
				return;
			}
			
			if(broj == niz.length){
				System.out.println("Niz je pun");
				return;
			}
			
			for(int i = broj; i>indeks; i--){
				niz[i] = niz[i-1];
			}
			
			niz[indeks] = noviBroj;
			broj++;
			
		}
		
	//Sortirano ubacivanje u niz	
		
	void ubaciSortirano(int noviBroj){
		
		if(broj == niz.length){
			System.out.println("Niz je pun");
			return;
		}
		
		for(int i = 0; i<broj; i++){
			if(niz[i]>noviBroj){
				ubaciNaTacanIndeks(noviBroj, i);
				return;
			}
		}
		
		niz[broj++] = noviBroj;
		
	}

	//Sortirati niz rastuce (SELECTION SORT)
	void sortSelection(){
		
		for(int i = 0; i < broj - 1; i++){
			
			for(int j = i+1; j<broj; j++){
				if(niz[j] < niz[i]){
					
					int tmp = niz[i];
					niz[i] = niz[j];
					niz[j] = tmp;
					
				}
				
			}
			
		}
		
	}
	
	//Sortirati niz opadajuce (SELECTION SORT)
	void sortSelectionOpadajuce(){
		
		for(int i = 0; i < broj - 1; i++){
			
			for(int j = i+1; j<broj; j++){
				if(niz[j] > niz[i]){
					
					int tmp = niz[i];
					niz[i] = niz[j];
					niz[j] = tmp;
					
				}
				
			}
			
		}
		
	}
		
	//Frekvencija datog elementa u nizu (nestaticka metoda, radi samo sa nizom koji se nalazi unutar objekta)
	int frekvencija (int broj){
		
		int brojac = 0;
		
		for(int i = 0; i<this.broj; i++){
			if(niz[i] == broj){
				brojac++;
			}
		}
		
		return brojac;
		
	}
	
	//Frekvencija datog elementa u nizu (staticka metoda, radi sa svim nizovima)
	static int frekvencija(int noviBroj, int[] noviNiz){
		
		int brojac = 0;
		
		for(int i = 0; i<noviNiz.length; i++){
			if(noviNiz[i] == noviBroj){
				brojac++;
			}
		}
		
		return brojac;
		
	}
	
	//Unija nizova
	void unija(int[] niz1, int[] niz2){
		
		niz = new int[niz1.length + niz2.length];
		broj = 0;
		
		for(int i = 0; i<niz1.length; i++){
			if(frekvencija(niz1[i])==0)
				niz[broj++] = niz1[i];
		}
		
		for(int i = 0; i<niz2.length; i++){
			if(frekvencija(niz2[i])==0)
				niz[broj++] = niz2[i];
		}
		
	}
	
	//Spajanje 2 rastuca niza
	void spoji2Rastuce(int[] niz1, int[] niz2){
		
		niz = new int[niz1.length + niz2.length];
		broj = 0;
		
		int brojac1 = 0;
		int brojac2 = 0;
		
		// brojac1 != niz1.length && brojac != niz2.length
		while(!(brojac1 == niz1.length && brojac2 == niz2.length)){
					
			if(brojac1 == niz1.length){
				niz[broj++] = niz2[brojac2++];
				continue;
			}
			
			if(brojac2 == niz2.length){
				niz[broj++] = niz1[brojac1++];
				continue;
			}
			
			if(niz1[brojac1] < niz2[brojac2]){
				niz[broj++] = niz1[brojac1++];
			}
			else{
				niz[broj++] = niz2[brojac2++];
			}
		}
		
	}
	
	//Zbir 3 najvece vrednosti niza
	int zbirNaj3(){
		
		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		int max3 = Integer.MIN_VALUE;
		
		int iMax1 = -1;
		int iMax2 = -1;
		
		for(int i=0; i<broj; i++){
			if(niz[i] > max1){
				max1 = niz[i];
				iMax1 = i;
			}
		}
		
		for(int i=0; i<broj; i++){
			if(niz[i] > max2 && i != iMax1){
				max2 = niz[i];
				iMax2 = i;
			}
		}
		
		for(int i=0; i<broj; i++){
			if(niz[i] > max3 && i != iMax1 && i != iMax2){
				max3 = niz[i];
			}
		}
		
		return max1 + max2 + max3;
		
	}

	//Zbir 3 najvece vrednosti niza - jedan prolazak
	int zbirNaj3Prolaz(){
		
		
		
		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		int max3 = Integer.MIN_VALUE;
		
		for(int i=0; i<broj; i++){
			
			if(niz[i] >= max1){
				max3 = max2;
				max2 = max1;
				max1 = niz[i];
			}
			
			else if(niz[i] >= max2){
				max3 = max2;
				max2 = niz[i];
			}
			
			else if(niz[i] >= max3){
				max3 = niz[i];
			}
			
		}
		
		return max1 + max2 + max3;
		
	}
	
	//Stampanje niza
	void print(){
		
		System.out.println("Nas niz je:");
		
		for(int i=0; i<broj; i++){
			System.out.println(niz[i] + " ");
		}
	}
	
}
