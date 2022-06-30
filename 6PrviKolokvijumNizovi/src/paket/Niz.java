package paket;

import labis.exception.LabisException;
import labis.niz.ANiz;

public class Niz extends ANiz{

	
	//1. Niz - U nizu zameniti svaki element proizvodom njegovih suseda.
	//      Prvi zameniti proizvodom prvog i drugog, a poslednji proizvodom poslednjeg
	//		i pretposlednjeg elementa niza.
	
	// 1  2  3  4  5
	
	void printNiz(){
		
		if(niz == null){
			System.out.println("Niz ne postoji");
			return;
		}
		
		if(niz.length == 0){
			System.out.println("Niz je prazan");
			return;
		}
		
		for(int i=0; i<niz.length; i++){
			System.out.print(niz[i] + " ");
		}
		
	}
	
	void zameni(){
		
		int[] noviNiz = new int[niz.length];
		//{2,0,0,0,20}
		
		//I slucaj: prvi element
		
		noviNiz[0] = niz[0] * niz[1];
		
		//II slucaj: poslednji element
		
		noviNiz[noviNiz.length - 1] = niz[noviNiz.length - 1] * niz[noviNiz.length - 2];
		
		//III slucaj: slucajevi izmedju
		
		for(int i=1; i<niz.length-1; i++){
			noviNiz[i] = niz[i+1] * niz[i-1];
		}
		
		//Spoji sa nasim nizom
		
		niz = noviNiz;
	}

	void zameniR(){
		
		if(niz == null || niz.length == 0 || niz.length == 1){
			return;
		}
		
		int trenutni;
		int prethodni = niz[0];
		
		for(int i = 0; i<niz.length-1;i++){
			
			trenutni = niz[i];
			niz[i] = prethodni * niz[i+1];
			prethodni = trenutni;
			
		}
		
		niz[niz.length-1] = prethodni * niz[niz.length-1];
		
	}
	
	//2. Niz, parametar K - Metoda vraca duzinu najkraceg podniza ciji je zbir veci od prosledjenog
	// 					 parametra K.

	// 2  3  6  2  4  7  9
	
	int duzinaNajkracegPodniz(int index, int broj){
		
		int zbir = 0;
		int brojac = 0;
		
		for(int i = index; i<niz.length ;i++){
			
			zbir = zbir+niz[i];
			brojac++;
			
			if(zbir > broj){
				return brojac;
			}
		}
		
		return Integer.MAX_VALUE;
	}
	
	int duzinaNajkraceg(int broj) throws LabisException{
		
		if(niz == null){
			throw new LabisException("Niz ne postoji");
		}
		
		int duzinaNajmanjeg = Integer.MAX_VALUE;
		int duzinaZaIndex;
		
		for(int i = 0; i<niz.length; i++){
			
			duzinaZaIndex = duzinaNajkracegPodniz(i, broj);
			
			if(duzinaZaIndex < duzinaNajmanjeg){
				duzinaNajmanjeg = duzinaZaIndex;
			}
			
		}
		
		if(duzinaNajmanjeg != Integer.MAX_VALUE){
			return duzinaNajmanjeg;
		}
		else{
			throw new LabisException("Ne postoji ovakav podniz;");
		}
		
		
		
	}
	
	
	
	
	
}

