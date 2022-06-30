package paket;

import labis.cvorovi.CvorDSListe;
import labis.cvorovi.CvorJSListe;
import labis.liste.ADSLista;

public class DSLista extends ADSLista{
	
	//Naopako stampanje, uz pomoc prethodnog elementa liste
		void printNaopacke(){
		
			if(prvi == null){
				System.out.println("Lista je prazna!");
				return;
			}
			
			CvorDSListe pom = prvi;
			
			while(pom.sledeci != null){
				
				pom = pom.sledeci;
				
			}
			
			System.out.println("Lista unazad: ");
			
			while(pom!=null){
				
				System.out.print(pom.podatak + " ");
				pom = pom.prethodni;
				
			}
			
			System.out.println();
			
		}
	
		void printNaopackeC(){
			
			CvorDSListe poslednji = prvi.prethodni;
			CvorDSListe pom = poslednji;
			
			System.out.println("Unazad:");
			do{
				System.out.print(pom.podatak + " ");
				pom = pom.prethodni;
			} while(pom != poslednji);
			System.out.println();
			
		}
	//Zadatak 1: DS lista - Metodom se krece od drugog elementa i izbacuje svaki treci element.

		void izbaciSledeci(CvorDSListe neki){
			
			if(neki == null || neki.sledeci == null){
				return;
			}
			
			neki.sledeci = neki.sledeci.sledeci;
			
			if(neki.sledeci != null){
				neki.sledeci.prethodni = neki;
			}
		}
		
		int brojElemenata(){
			
			int brojac = 0;
			CvorDSListe pom = prvi;
			
			while(pom != null){
				brojac++;
				pom = pom.sledeci;
			}
			
			return brojac;
			
		}
		
		void izbaciSvakiTreci(){
			
			//1  3  4  5  8  9  10 
			
			if(brojElemenata() < 5){
				return;
			}
			
			CvorDSListe pom = prvi.sledeci.sledeci.sledeci;
				
			while(true){
				
				izbaciSledeci(pom);
				
				pom = pom.sledeci;
				if(pom == null){
					return;
				}
				
				pom = pom.sledeci;
				if(pom == null){
					return;
				}		
				
			}
			
			
		}
		
	//Zadatak 2: Ciklicna DS lista - Izbaciti sve negativne brojeve iz liste.

		void izbaciSveNegativne(){
			
			if(prvi.sledeci == prvi){
				prvi = null;
				return;
			}
			
			CvorDSListe poslednji;
			
			while(prvi.podatak<0){
				
				poslednji = prvi.prethodni;
				
				prvi = prvi.sledeci;
				
				poslednji.sledeci = prvi;
				prvi.prethodni = poslednji;
				
			}
			
			CvorDSListe pom = prvi;
			
			do{
				
				if(pom.sledeci.podatak < 0){
					pom.sledeci = pom.sledeci.sledeci;
					pom.sledeci.prethodni = pom;
				}
				else{
					pom = pom.sledeci;
				}
				
			} while(pom.sledeci != prvi);
			
		}

	//Zadatak 3: DS lista i parametri M i N - preskoci M elemenata pa izbaci N elemenata.
		
		public void preskociMIzbaciN(int m, int n){
			
			if(prvi == null){
				return;
			}
			
			if(m<0 || n<0){
				return;
			}
			
			if(m == 0){
				prvi = null;
				return;
			}
			
			if(n == 0){
				return;
			}
			
			CvorDSListe pom = prvi;
			
			while(true){
			
			for(int i = 0; i<m-1; i++){
				pom = pom.sledeci;
				if(pom == null){
					return;
				}
			}
			
			for(int i=0; i<n; i++){
				izbaciSledeci(pom);
			}
			
			pom = pom.sledeci;
			if(pom == null){
				break;
			}
			
		}	
		}
	
		
		
}
