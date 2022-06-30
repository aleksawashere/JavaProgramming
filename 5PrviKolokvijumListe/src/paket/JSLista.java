package paket;

import labis.cvorovi.CvorJSListe;
import labis.exception.LabisException;
import labis.liste.AJSLista;

public class JSLista extends AJSLista{

	//Zadatak 1: JS lista, dat parametar k - Vrati broj parova elemenata 
	//           ciji je zbir veci od prosledjenog K.

	//   3  5  7  9  1 
	//  k = 8, br=5
	
		int brojParova(int k) throws LabisException{
			
			if(prvi == null){
				throw new LabisException("Lista ne postoji!");
			}
			
			CvorJSListe spori = prvi;
			CvorJSListe brzi = prvi.sledeci;
			
			int brojac = 0;
			
			while(spori.sledeci != null){
				while(brzi != null){
					
					if(spori.podatak + brzi.podatak > k){
						System.out.println(spori.podatak + " " + brzi.podatak);
						brojac++;
					}
					
					brzi = brzi.sledeci;
					
				}
				
				spori = spori.sledeci;
				brzi = spori.sledeci;
			}
			
			return brojac;
			
		}
	
	//Zadatak 2: Date su dve JS Liste kao parametri, a elementi tih lista su temperature po danima.
	//           Metoda treba vratiti najveci zbir temperatura za neki dan (dakle na istoj poziciji).
	
		//  30 20 20 30 20 20
		//  15 20 30 20 40
		//  --------------
		//  45 40 50 50 60
		
		int najveciZbirTemp(CvorJSListe c1, CvorJSListe c2) throws LabisException{
			
			if(c1 == null || c2 == null){
				
				throw new LabisException("Jedna od lista ili obe su prazne!");
				
			}
			
			CvorJSListe pom1 = c1;
			CvorJSListe pom2 = c2;
			
			int maxZbir = Integer.MIN_VALUE;
			int trenutniZbir;
	
			while( !(pom1 == null || pom2 == null) ){
				
				trenutniZbir = pom1.podatak + pom2.podatak;
				
				if(trenutniZbir > maxZbir){
					maxZbir = trenutniZbir;
				}
				
				pom1 = pom1.sledeci;
				pom2 = pom2.sledeci;
				

			}
			
			return maxZbir;
			
		}
		
		
		
		
	//Zadatak 3: JS lista i parametri BROJ i N - ubaci BROJ na N-to mesto od kraja liste.

	int brojElemenata(){
		
		int brojac = 0;
		CvorJSListe pom = prvi;
		
		while(pom != null){
			brojac++;
			pom = pom.sledeci;
		}
		
		return brojac;
		
	}
	
	// 1 2 3 4 5 88 6 7
	//Broj = 88, N = 3
	
	void ubaciNaNbrojaDoKraja(int broj, int n){
		
		if(n<1){
			return;
		}
		

		CvorJSListe novi = new CvorJSListe(broj, null);
		int brElemenata = brojElemenata();
		
		if(n == brElemenata + 1){
			novi.sledeci = prvi;
			prvi = novi;
			return;
		}
		
		if(n>brElemenata+1){
			return;
		}
		
		CvorJSListe pom = prvi;
		
		for(int i=0; i<brElemenata-n;i++){
			pom = pom.sledeci;
		}
		
		novi.sledeci = pom.sledeci;
		pom.sledeci = novi;
			
			
		}
		
	}
	

