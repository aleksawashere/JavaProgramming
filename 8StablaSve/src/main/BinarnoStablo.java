package main;

import labis.cvorovi.CvorStabla;
import labis.exception.LabisException;
import labis.stabla.ABinarnoStablo;

public class BinarnoStablo extends ABinarnoStablo{
	
	//CvorStabla koren;
	
	
	//Zbir elemenata u stablu
	
	int zbirElemenataR() throws LabisException{
		
		if(koren==null){
			throw new LabisException("Stablo je prazno!");
		}
		return zbirElemenata(koren);
	}
	
	int zbirElemenata(CvorStabla cvor){
		
		if(cvor==null){
			return 0;
		}
		
		return zbirElemenata(cvor.levo) + zbirElemenata(cvor.desno) + cvor.podatak;
		
	}
	
	//Broj elemenata u stablu
	
	int brojElemenataR(){
		if(koren == null){
			throw new RuntimeException("Stablo je prazno!!!");
		}
		
		return brojElemenata(koren);
	}
	
	int brojElemenata(CvorStabla cvor){
		
		if(cvor == null){
			return 0;
		}
		
		return brojElemenata(cvor.levo) + brojElemenata(cvor.desno) + 1;
		
	}
	
	//Srednja vrednost stabla
	
	double srednja() throws LabisException{
		
		if(koren == null){
			throw new RuntimeException("Stablo je prazno!!!");
		}
		
		return (double)zbirElemenataR()/brojElemenataR();
	}
	
	
	//Maksimalni element u stablu
	
		//Pomocna funkcija
		private int max(int... niz){
			int max = niz[0];
			
			for(int i=0; i<niz.length; i++){
				if(niz[i] > max){
					max = niz[i];
				}
			}
			
			return max;
		}
		
		//Glavna funkcija
		int maksElementR(){
			
			if(koren == null){
				throw new RuntimeException("Stablo je prazno!");
			}
			
			return maksElement(koren);
		}
		
		private int maksElement(CvorStabla cvor){
		
		if(cvor==null){
			return Integer.MIN_VALUE;
		}
		
		int maxLevog = maksElement(cvor.levo);
		int maxDesnog = maksElement(cvor.desno);
		
		return max(maxLevog, maxDesnog, cvor.podatak);
		
	}

	//Cvor koji sadrzi maksimalni element u stablu
		
	CvorStabla vratiCvorMaksR(){
		
		if(koren == null){
			throw new RuntimeException("Stablo je prazno!");
		}
		
		return vratiCvorMaks(koren);
	}
		
	CvorStabla vratiCvorMaks(CvorStabla cvor){
		
		if(cvor == null){
			return null;
		}
		
		CvorStabla adresaLevi = vratiCvorMaks(cvor.levo);
		CvorStabla adresaDesni = vratiCvorMaks(cvor.desno);
		
		CvorStabla adresaMaks = cvor;
		
		if(adresaLevi != null && adresaLevi.podatak > adresaMaks.podatak){
			adresaMaks = adresaLevi;
		}
		
		if(adresaDesni != null && adresaDesni.podatak > adresaMaks.podatak){
			adresaMaks = adresaDesni;
		}
		
		return adresaMaks;
	}

	//Preorder ispis
	void preOrder(CvorStabla cvor){
		
		if(cvor==null){
			return;
		}
		
		System.out.print(cvor.podatak + " ");
		
		preOrder(cvor.levo);
		
		preOrder(cvor.desno);
		
	}
	
	//Inorder ispis
	void inOrder(CvorStabla cvor){
		
		if(cvor==null){
			return;
		}
		
		inOrder(cvor.levo);
		
		System.out.print(cvor.podatak + " ");
		
		inOrder(cvor.desno);
		
	}
	
	//Postorder ispis
	void postOrder(CvorStabla cvor){
		
		if(cvor==null){
			return;
		}
		
		postOrder(cvor.levo);
		
		postOrder(cvor.desno);
		
		System.out.print(cvor.podatak + " ");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	//------Slozenije metode--------
	
	
	// Provera da li postoji prosledjeni broj u stablu

	boolean postoji(int broj, CvorStabla cvor){
		
		if(cvor==null){
			return false;
		}
		
		if(postoji(broj, cvor.levo) || postoji(broj, cvor.desno) || cvor.podatak == broj){
			
			return true;
		}
		else{
			return false;
		}
		
	}
	
	// Provera da li neki cvor (objekat) postoji u stablu
	
	boolean postoji(CvorStabla neki, CvorStabla cvor){
		
		if(cvor==null){
			return false;
		}
		
		if(postoji(neki, cvor.levo) || postoji(neki, cvor.desno) || cvor == neki){
			
			return true;
		}
		else{
			return false;
		}
		
	}
	
	// Koliko brojeva stabla se nalazi u prosledjenom intervalu
	
	int brojElemenataInterval(int donja, int gornja, CvorStabla cvor){
		
		if(cvor==null){
			return 0;
		}
		
		int levo = brojElemenataInterval(donja, gornja,cvor.levo);
		int desno = brojElemenataInterval(donja, gornja,cvor.desno);
		
		if(cvor.podatak >= donja && cvor.podatak <= gornja){
			return levo + desno + 1;
		}
		else{
			return levo + desno;
		}
	}
	
	// Koliko stablo ima listova
	int brojListova(CvorStabla cvor){
		
		if(cvor == null){
			return 0;
		}
		
		int levo = brojListova(cvor.levo);
		int desno = brojListova(cvor.desno);
		
		if(cvor.levo == null && cvor.desno == null){
			return levo + desno + 1;
		}
		
		else{
			return levo + desno;
		}
		
	}

	// Kolika je visina stabla
	int visina(CvorStabla cvor){
		
		if(cvor == null){
			return 0;
		}
		
		int levo = visina(cvor.levo);
		int desno = visina(cvor.desno);
		
		return max(levo, desno) + 1;
		
	}

	// Koliki je najveci zbir svih zbirova podstabala
	
	int najveciZbirPodR(){
		
		if(koren == null){
			throw new RuntimeException("Prazno stablo!!!");
		}
		
		return najveciZbirPod(koren);
	}
	
	int najveciZbirPod(CvorStabla cvor){
		
		if(cvor==null){
			return Integer.MIN_VALUE;
		}
		
		int levo = najveciZbirPod(cvor.levo);
		int desno = najveciZbirPod(cvor.desno);
		
		int zbir = zbirElemenata(cvor);
		
		return max(levo,desno,zbir);
		
		
	}
	
	// Koliki je najveci zbir dece
	
	int najveciZbirDeceR(){
		
		if(koren == null){
			throw new RuntimeException("Prazno stablo!");
		}
		
		if(koren.levo == null && koren.desno == null){
			throw new RuntimeException("Stablo nema nikakvu decu!");
		}
		
		return najveciZbirDece(koren);
	}
	
	int najveciZbirDece(CvorStabla cvor){
		
		if(cvor == null){
			return Integer.MIN_VALUE;
		}
		
		if(cvor.levo == null && cvor.desno == null){
			return Integer.MIN_VALUE;
		}
		
		int levo = najveciZbirDece(cvor.levo);
		int desno = najveciZbirDece(cvor.desno);
		
		int levoDete;
		int desnoDete;
		
		if(cvor.levo != null){
			levoDete = cvor.levo.podatak;
		}
		else{
			levoDete = 0;
		}
		
		if(cvor.desno != null){
			desnoDete = cvor.desno.podatak;
		}
		else{
			desnoDete = 0;
		}
		
		int trenutni = levoDete + desnoDete;
		
		return max(levo, desno, trenutni);
		
	}
	
	
	
	
	
	//-----NEREKURZIVNE METODE SA STABLIMA------
	
	// Vrati cvor (objekat) koji se nalazi skroz levo
	
	CvorStabla vratiSkrozLevi(CvorStabla cvor){
		
		if(cvor == null){
			return null;
		}
		
		CvorStabla pom = cvor;
		
		while(true){
			
			if(pom.levo == null){
				return pom;
			}
			else{
				pom = pom.levo;
			}
			
			
		}
		
	}
	
	// Vrati cvor (objekat) koji se nalazi skroz desno

	CvorStabla vratiSkrozDesni(CvorStabla cvor){
		
		if(cvor == null){
			return null;
		}
		
		CvorStabla pom = cvor;
		
		while(true){
			
			if(pom.desno == null){
				return pom;
			}
			else{
				pom = pom.desno;
			}
			
			
		}
		
	}
	
	
	// Ubaci u stablo sortirano (BST stablo)
	
	void ubaciBST(int noviBroj){
		
		CvorStabla noviCvor = new CvorStabla(noviBroj);
		
		if(koren == null){
			koren = noviCvor;
			return;
		}
		
		CvorStabla pom = koren;
		
		while(true){
			
			if(noviBroj < pom.podatak){
				if(pom.levo == null){
					pom.levo = noviCvor;
					return;
				}
				else{
					pom = pom.levo;
				}

			}
			
			else{
				if(pom.desno == null){
					pom.desno = noviCvor;
					return;
				}
				else{
					pom = pom.desno;
				}

			}
			
		}
		
	}
	
	void ubaciBST(int... niz){
		for(int i = 0; i<niz.length;i++){
			ubaciBST(niz[i]);
		}
	}
	
	// Ispisi put kojim se kreces od korena do prosledjenog elementa (ITERATIVNI NACIN)
	
	void ispisiOdKorenaDoProsledjenog(CvorStabla trazeni){
		
		if(!postoji(trazeni, koren)){
			
			System.out.println("Trazeni cvor ne postoji u nasem stablu!");
			return;
			
		}
		
		CvorStabla pom = koren;
		
		while(true){
			
			System.out.print(pom.podatak + " ");
			
			//kada dodjemo do trazenog cvora
			if(pom == trazeni){
				return;
			}
			
			if(postoji(trazeni, pom.levo)){
				pom = pom.levo;
			}
			else{
				pom = pom.desno;
			}
		}
		
		
	}
	
	// Ispisi put kojim se kreces od korena do prosledjenog elementa (REKURZIVNI NACIN)
	
	void ispisiOdKorenaDoProsledjenogRekR(CvorStabla trazeni)
	{
		if(postoji(trazeni,koren)){
			ispisiOdKorenaDoProsledjenogRek(koren, trazeni);
		}
		else{
			System.out.println("Trazeni ne postoji u nasem stablu!");
		}
	}
	
	void ispisiOdKorenaDoProsledjenogRek(CvorStabla cvor, CvorStabla trazeni){
		
		System.out.print(cvor.podatak + " ");
		
		if(cvor == trazeni){
			return;
		}
		
		if(postoji(trazeni, cvor.levo)){
			ispisiOdKorenaDoProsledjenogRek(cvor.levo, trazeni);
		}
		else{
			ispisiOdKorenaDoProsledjenogRek(cvor.desno, trazeni);
		}
		
	}
	
	// Ispisi put kojim se kreces od prosledjenog elementa do korena (obrnuto) (REKURZIVNI NACIN)
	
	void ispisiOdProsedjenogDoKorenaRekR(CvorStabla trazeni){
		
		if(postoji(trazeni,koren)){
			ispisiOdProsedjenogDoKorenaRek(koren, trazeni);
		}
		else{
			System.out.println("Trazeni cvor ne postoji u nasem stablu.");
		}
		
	}
	
	void ispisiOdProsedjenogDoKorenaRek(CvorStabla cvor, CvorStabla trazeni){
		
		if(cvor == trazeni){
			
			System.out.print(cvor.podatak + " ");
			return;
			
		}
		
		if(postoji(trazeni, cvor.levo)){
			ispisiOdProsedjenogDoKorenaRek(cvor.levo, trazeni);
		}
		
		else{
			ispisiOdProsedjenogDoKorenaRek(cvor.desno, trazeni);
		}
		
		System.out.print(cvor.podatak + " ");
		
	}

	// Ispisi PreOrder metodom sve elemente, kao i njihove nivoe na kojima se zapravo nalaze
	
	void preOrderNovo(CvorStabla cvor, int nivo){
		
		if(cvor == null){
			return;
		}
		
		System.out.println("Podatak: " + cvor.podatak + " , nivo: " + nivo);
		
		preOrderNovo(cvor.levo, nivo+1);
		
		preOrderNovo(cvor.desno, nivo+1);
		
	}

	
	
	
	//-----RC3 zadaci------
	
	// RC3 2. zadatak
	
	CvorStabla vratiCvorRC3(CvorStabla cvor){
		
		CvorStabla pom = cvor;
		
		while(true){
			
			if(pom.levo == null && pom.desno == null){
				return pom;
			}
			
			if(visina(pom.levo) >= visina(pom.desno)){
				pom = pom.levo;
			}
			else{
				pom = pom.desno;
			}
			
		}
		
	}
	
	@Override
	public CvorStabla vratiCvorNaNajvecojDubini(CvorStabla k) throws LabisException {
		
		if(k == null){
			throw new LabisException("Prazno stablo");
		}
		
		return vratiCvorRC3(k);
	}
	
	
	//RC3 3. zadatak
	
	int nivoListaNajplici(CvorStabla cvor, int nivo){
		
		if(cvor == null){
			return Integer.MAX_VALUE;
		}
		
		if(cvor.levo == null && cvor.desno == null){
			return nivo;
		}
		
		int najpliciLevo = nivoListaNajplici(cvor.levo, nivo+1);
		int najpliciDesno = nivoListaNajplici(cvor.desno, nivo+1);
		
		return Math.min(najpliciLevo, najpliciDesno);
	}

	CvorStabla vratiNajpliciList(CvorStabla cvor){
		
		CvorStabla pom = cvor;
		
		while(true){
			
			if(pom.levo == null && pom.desno == null){
				return pom;
			}
			
			if(nivoListaNajplici(pom.levo, 1) <= nivoListaNajplici(pom.desno, 1)){
				
				pom = pom.levo;
				
			}
			else{
				pom = pom.desno;
			}
			
		}
	}
	
	@Override
	public CvorStabla vratiListNaNajmanjojDubini(CvorStabla k) throws LabisException {
		
		if(k == null){
			throw new LabisException("Stablo prazno!!!");
		}
		
		return vratiNajpliciList(k);
	}

	
	//RC3 4. zadatak
	
	@Override
	public CvorStabla vratiNajveciNaPutanji(CvorStabla k, CvorStabla neki) throws LabisException {
		
		if(!postoji(neki, k)){
			throw new LabisException("Trazeni 'neki' ne postoji u nasem stablu");
		}
		
		CvorStabla pom = k;
		CvorStabla max = new CvorStabla(Integer.MIN_VALUE);
		
		while(true){
			
			if(pom.podatak >= max.podatak){
				max = pom;
			}
			
			if(pom == neki){
				return max;
			}
			
			if(postoji(neki, pom.levo)){
				pom = pom.levo;
			}
			
			else{
				pom = pom.desno;
			}
			
		}
	}
	
	
	//RC3 5. zadatak
	
	boolean veciOdSvihJedan(int broj, CvorStabla cvor){
		
		if(cvor == null){
			return true;
		}
		
		if(veciOdSvihJedan(broj, cvor.levo) && veciOdSvihJedan(broj,cvor.desno) && broj > cvor.podatak){
			return true;
		}
		else{
			return false;
		}
		
		
	}
	
	int brojCvorovaVecihOdSvojihSledbenika(CvorStabla cvor){
		
		if(cvor == null){
			return 0;
		}
		
		int levo = brojCvorovaVecihOdSvojihSledbenika(cvor.levo);
		int desno = brojCvorovaVecihOdSvojihSledbenika(cvor.desno);
		
		if(veciOdSvihJedan(cvor.podatak, cvor.levo) && veciOdSvihJedan(cvor.podatak, cvor.desno)){
			
			return levo + desno + 1;
			
		}
		else{
			return levo + desno;
		}
	}
	
	@Override
	public int vratiBrojCvorovaVecihOdSvojihSledbenika(CvorStabla k) throws LabisException {
		
		if(k == null)
			throw new LabisException("Greska");
		
		return brojCvorovaVecihOdSvojihSledbenika(k);
	}
	
	
	//RC4 2. zadatak
	
	void izbaci(CvorStabla trazeni){
		
		if(!postoji(trazeni,koren)){
			return;
		}
		
		CvorStabla roditelj = null;
		CvorStabla pom = koren;
	
		//Trazenje trazenog
		while(true){
			if(pom == trazeni){
				break;
			}
			
			if(postoji(trazeni,pom.levo)){
				roditelj = pom;
				pom = pom.levo;
			}
			else{
				roditelj = pom;
				pom = pom.desno;
			}
			
		}
		
		//Izbacivanje korena
		
		if(trazeni == koren){
			
			//kada je list(jedini element)
			if(koren.levo == null && koren.desno == null){
				koren = null;
				return;
			}
			
			//polulist
			//na desno
			if(koren.levo == null){
				koren = koren.desno;
				return;
			}
			
			//na levo
			if(koren.desno == null){
				koren = koren.levo;
				return;
			}
			
			//unutrasnji cvor
			CvorStabla najDesniji = vratiSkrozDesni(trazeni.levo);
			trazeni.podatak = najDesniji.podatak;
			izbaci(najDesniji);
			return;
			
		}
		
		boolean levoJe = true;
		
		if(roditelj.desno == trazeni){
			levoJe = false;
		}
		
		//Izbacivanje lista
		
		if(trazeni.levo == null && trazeni.desno == null){
			
			if(levoJe){
				roditelj.levo = null;
				return;
			}
			else{
				roditelj.desno = null;
				return;
			}
			
		}
		
		//Izbacivanje polulista
		
		if(trazeni.levo == null){
			
			if(levoJe){
				roditelj.levo = trazeni.desno;
				return;
			}
			else{
				roditelj.desno = trazeni.desno;
				return;
			}
			
		}
		
		if(trazeni.desno == null){
			
			if(levoJe){
				roditelj.levo = trazeni.levo;
				return;
			}
			else{
				roditelj.desno = trazeni.levo;
				return;
			}
			
		}
		
		
		//Izbacivanje unutrasnjeg cvora
		
		CvorStabla najDesnijiElement = vratiSkrozDesni(trazeni.levo);
	  
		trazeni.podatak = najDesnijiElement.podatak;
		
		izbaci(najDesnijiElement);
		
		
		
	}
	
	
	//RC4 4. zadatak
	
	CvorStabla najveciPolulist(CvorStabla cvor){
		
		if(cvor == null){
			return null;
		}
		
		CvorStabla najveciLevo = najveciPolulist(cvor.levo);
		CvorStabla najveciDesno = najveciPolulist(cvor.desno);
		
		CvorStabla max = null;
		
		if(cvor.levo != null ^ cvor.desno != null){
			// T T -> F
			// T F -> T
			// F T -> T
			// F F -> F
			max = cvor;
		}
		
		if(najveciLevo != null && max == null){
			max = najveciLevo;
		}
		
		else if(najveciLevo!=null && max != null){
			if(najveciLevo.podatak > max.podatak){
				max = najveciLevo;
			}
		}
		
		if(najveciDesno != null && max == null){
			max = najveciDesno;
		}
		else if(najveciDesno != null && max != null){
		
			if(najveciDesno.podatak > max.podatak){
				max = najveciDesno;
		}
		}

		return max;
	}
	
	
	//RC4 5. zadatak
	
	boolean proveriAVL(CvorStabla cvor){
		
		if(cvor == null){
			return true;
		}
		
		boolean levo = proveriAVL(cvor.levo);
		boolean desno = proveriAVL(cvor.desno);
		
		boolean trenutno = true;
		
		if(cvor.levo != null && cvor.podatak <= cvor.levo.podatak){
			trenutno = false;
		}
		
		if(cvor.desno != null && cvor.podatak > cvor.desno.podatak){
			trenutno = false;
		}
		
		if( Math.abs(visina(cvor.levo) - visina(cvor.desno)) > 1){
			trenutno = false;
		}

		if(levo && desno && trenutno){
			return true;
		}
		else{
			return false;
		}
	}



	
	
	
	
	//----------ZADACI SA ROKOVA---------------
	
	//1. Vrati cvor (objekat) koji ima najvecu razliku zbira levog i zbira desnog podstabla, 
	//   od svih podstabala u datom stablu.
	
	
//	int zbirElemenata(CvorStabla cvor){
//		
//		if(cvor==null){
//			return 0;
//		}
//		
//		return zbirElemenata(cvor.levo) + zbirElemenata(cvor.desno) + cvor.podatak;
//		
//	}
   CvorStabla cvorSaNajRazlikomR(CvorStabla cvor) throws LabisException{
	   
	   if(cvor == null){
		   throw new LabisException("Prazno je stablo!");
	   }
	   
	   return cvorSaNajRazlikom(cvor);
	   
   }
	
	
	CvorStabla cvorSaNajRazlikom(CvorStabla cvor){
		
		if(cvor == null){
			return null;
		}
		
		CvorStabla adresaLevog = cvorSaNajRazlikom(cvor.levo);
		CvorStabla adresaDesnog = cvorSaNajRazlikom(cvor.desno);
		
		int razlikaLevog = 0;
		int razlikaDesnog = 0;
		int razlikaTrenutnog;
		
		razlikaTrenutnog = zbirElemenata(cvor.levo) - zbirElemenata(cvor.desno);
		
		if(adresaLevog != null){
			razlikaLevog = zbirElemenata(adresaLevog.levo) - zbirElemenata(adresaLevog.desno);
		}
		
		if(adresaDesnog != null){
			razlikaDesnog = zbirElemenata(adresaDesnog.levo) - zbirElemenata(adresaDesnog.desno);
		}
		
		if(razlikaLevog > razlikaDesnog && razlikaLevog > razlikaTrenutnog){
			return adresaLevog;
		}
		
		if(razlikaDesnog > razlikaLevog && razlikaDesnog > razlikaTrenutnog){
			return adresaDesnog;
		}
		
		return cvor;
	}
	

	
	
	
	
	//2. Dato je stablo, nadji najveci zbir od zbirova svih podstabala.
	
	//**Radili smo vec!**
	
	
//	int najveciZbirPodR(){
//		
//		if(koren == null){
//			throw new RuntimeException("Prazno stablo!!!");
//		}
//		
//		return najveciZbirPod(koren);
//	}
//	
//	int najveciZbirPod(CvorStabla cvor){
//		
//		if(cvor==null){
//			return Integer.MIN_VALUE;
//		}
//		
//		int levo = najveciZbirPod(cvor.levo);
//		int desno = najveciZbirPod(cvor.desno);
//		
//		int zbir = zbirElemenata(cvor);
//		
//		return max(levo,desno,zbir);
//		
//		
//	}
	

	
	//3. Dato stablo i broj kao parametar, izracunaj zbir elemenata koji su na nivou koji je prosledjen kao broj,
	//   i to samo zbir onih koji imaju oba deteta (unutrasnji cvorovi).
	
	
	
	int zbirUnutrasnjihCvorovaNaNekomNivou(CvorStabla cvor, int broj) throws LabisException{
		
		if(postojiNekiUnutrasnjiCvorNaProsledjenomNivou(cvor,broj,1)){
			return zbirUnutrasnjihCvorovaNaNekomNivou(cvor,broj,1);
		}
		
		throw new LabisException("Unutrasnji cvorovi ne postoje");
		
	}
	
	private boolean postojiNekiUnutrasnjiCvorNaProsledjenomNivou(CvorStabla cvor, int broj, int nivo){
		
		if(cvor == null){
			return false;
		}
		
		boolean levo = postojiNekiUnutrasnjiCvorNaProsledjenomNivou(cvor.levo, broj, nivo+1);
		boolean desno = postojiNekiUnutrasnjiCvorNaProsledjenomNivou(cvor.desno, broj, nivo+1);
		boolean trenutni = false;
		
		if(cvor.levo!=null && cvor.desno != null && nivo == broj){
			trenutni = true;
		}
		
		if(levo || desno || trenutni){
			return true;
		}
		
		else{
			return false;
		}
	
		
	}
	
	
	private int zbirUnutrasnjihCvorovaNaNekomNivou(CvorStabla cvor, int broj, int nivo){
		
		if(cvor == null){
			return 0;
		}
		
		int levo = zbirUnutrasnjihCvorovaNaNekomNivou(cvor.levo, broj, nivo+1);
		int desno = zbirUnutrasnjihCvorovaNaNekomNivou(cvor.desno, broj, nivo+1);
		
		if(nivo == broj && cvor.levo != null && cvor.desno != null){
			
			return levo + desno + cvor.podatak;
			
		}
		
		else{
			return levo + desno;
		}
		
	}
	

	//4. Dato stablo i broj, potrebno je pronaci broj podstabala ciji je zbir veci od prosledjenog broja (parametra).
	
//	int zbirElemenata(CvorStabla cvor){
//		
//		if(cvor==null){
//			return 0;
//		}
//		
//		return zbirElemenata(cvor.levo) + zbirElemenata(cvor.desno) + cvor.podatak;
//		
//	}
	
	int brojStabalaCijiJeZbirVeciOdDatogBrojaR(CvorStabla cvor, int broj){
		
		return brojStabalaCijiJeZbirVeciOdDatogBroja(cvor,broj);
		
	}
	
	int brojStabalaCijiJeZbirVeciOdDatogBroja(CvorStabla cvor, int broj){
		
		if(cvor == null){
			return 0;
		}
		
		int levo = brojStabalaCijiJeZbirVeciOdDatogBroja(cvor.levo, broj);
		int desno = brojStabalaCijiJeZbirVeciOdDatogBroja(cvor.desno, broj);
		
		if(zbirElemenata(cvor) > broj){
			
			return levo + desno + 1;
			
		}
		
		else{
			
			return levo + desno;
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//5. Najveca razlika izmedju nekog roditelja i deteta, u celom stablu za svakog roditelja i njegovo dete.
	
	
	int najvecaRazlikaRoditeljDeteR(CvorStabla cvor) throws LabisException{
		
		if(cvor == null || (cvor.levo == null && cvor.desno == null)){
			throw new LabisException("Nema 2 cvora!!");
		}
		
		return najvecaRazlikaRoditeljDete(cvor);
		
	}
	
	int najvecaRazlikaRoditeljDete(CvorStabla cvor){
		
		if (cvor == null){
			return Integer.MIN_VALUE;
		}
		
		int levo = najvecaRazlikaRoditeljDete(cvor.levo);
		int desno = najvecaRazlikaRoditeljDete(cvor.desno);
		
		int trenutnoLevo = Integer.MIN_VALUE;
		int trenutnoDesno = Integer.MIN_VALUE;
		
		if(cvor.levo != null){
			
			trenutnoLevo = cvor.podatak - cvor.levo.podatak;
			
		}
		
		if(cvor.desno != null){
			
			trenutnoDesno = cvor.podatak - cvor.desno.podatak;
			
		}
		
		return Math.max(Math.max(levo, desno),Math.max(trenutnoLevo, trenutnoDesno));
	}
	
	//6. Vrati najveci zbir od korena do nekog lista u stablu.

	
	int najveciZbirOdKorenaDoNekogListaUStabluR(CvorStabla cvor) throws LabisException{
		
		if(cvor == null){
			throw new LabisException("Prazno stablo!!");
		}
		
		return najveciZbirOdKorenaDoNekogListaUStablu(cvor);
		
	}

	int najveciZbirOdKorenaDoNekogListaUStablu(CvorStabla cvor){
		
		//slucaj list
		if(cvor.levo==null && cvor.desno==null){
			return cvor.podatak;
		}
		
		int levo;
		int desno;
		
		//slucaj polulist
		if(cvor.desno == null){
			levo = najveciZbirOdKorenaDoNekogListaUStablu(cvor.levo);
			return levo + cvor.podatak;
		}
		
		if(cvor.levo == null){
			desno = najveciZbirOdKorenaDoNekogListaUStablu(cvor.desno);
			return desno + cvor.podatak;
		}
		
		levo = najveciZbirOdKorenaDoNekogListaUStablu(cvor.levo);
		desno = najveciZbirOdKorenaDoNekogListaUStablu(cvor.desno);
		return Math.max(levo, desno) + cvor.podatak;
		
	}
	
	
	//7. Vrati razliku izmedju zbira svih pozitivnih elemenata i apsolutne vrednosti zbira svih negativnih elemenata.
	
	int metoda7(CvorStabla cvor) throws LabisException{
		
		if(cvor == null){
			throw new LabisException("Prazno stablo.");
		}
		
		int ZbirPozitivnih = zbirPozitivnih7(cvor);
		int ZbirNegativnih = zbirNegativnih7(cvor);
		
		return ZbirPozitivnih - Math.abs(ZbirNegativnih);

	}
	
	int zbirPozitivnih7(CvorStabla cvor){
		
		if(cvor == null){
			
			return 0;
		}
		
		int levo = zbirPozitivnih7(cvor.levo);
		int desno = zbirPozitivnih7(cvor.desno);
		
		if(cvor.podatak >= 0){
			
			return levo + desno + cvor.podatak;
			
		}
		else{
			return levo + desno;
		}
	}
	
	int zbirNegativnih7(CvorStabla cvor){
		
		if(cvor == null){
			
			return 0;
		}
		
		int levo = zbirNegativnih7(cvor.levo);
		int desno = zbirNegativnih7(cvor.desno);
		
		if(cvor.podatak < 0){
			
			return levo + desno + cvor.podatak;
			
		}
		else{
			return levo + desno;
		}
	}
	
	//8. Parametrima su data 2 cvora i koren, potrebno je vratiti proizvod svih zajednicke pretke od ova 2 parametrom 
	//   prosledjena cvora.
	
//	boolean postoji(CvorStabla neki, CvorStabla cvor){
//		
//		if(cvor==null){
//			return false;
//		}
//		
//		if(postoji(neki, cvor.levo) || postoji(neki, cvor.desno) || cvor == neki){
//			
//			return true;
//		}
//		else{
//			return false;
//		}
//		
//	}
	
	int zajednickiPreciR(CvorStabla cvor, CvorStabla trazeni1, CvorStabla trazeni2) throws LabisException{
		

		if(!postoji(trazeni1,cvor) || !postoji(trazeni2,cvor) || trazeni1 == cvor || trazeni2 == cvor) {
			throw new LabisException("Nemamo zajednickih predaka.");
		}
		
		return zajednickiPreci(cvor, trazeni1, trazeni2);
		
	}
	
	int zajednickiPreci(CvorStabla cvor, CvorStabla trazeni1, CvorStabla trazeni2){
		
		if(cvor == null){
			return 1;
		}
		
		int levo = zajednickiPreci(cvor.levo, trazeni1, trazeni2);
		int desno = zajednickiPreci(cvor.desno, trazeni1, trazeni2);
		
		if(postoji(trazeni1,cvor) && postoji(trazeni2,cvor)){
			return levo * desno * cvor.podatak;
		}
		
		else{
			return levo*desno;
		}
		
	}
	
	//9. Za dati interval (parametrom prosledjena gornja i donja granica), vrati broj elemenata stabla koji upadaju
	//   u taj interval.
	
	
	int brojElemenataUZadatomIntervaluR(CvorStabla cvor, int donja, int gornja) throws LabisException{
		
		if(cvor == null){
			throw new LabisException("Prazno stablo!");
		}
		
		return brojElemenataUZadatomIntervalu(cvor,donja, gornja);
		
	}
	
	int brojElemenataUZadatomIntervalu(CvorStabla cvor, int donja, int gornja){
		
		if(cvor == null){
			return 0;
		}
		
		int levo = brojElemenataUZadatomIntervalu(cvor.levo, donja, gornja);
		int desno = brojElemenataUZadatomIntervalu(cvor.desno, donja, gornja);
		
		if(cvor.podatak > donja && cvor.podatak < gornja){
			return levo + desno + 1;
		}
		else{
			return levo + desno;
		}
		
	}

	
	//10. Zbir svih listova stabla na najdubljem nivou stabla.

//	int visina(CvorStabla cvor){
//		
//		if(cvor == null){
//			return 0;
//		}
//		
//		int levo = visina(cvor.levo);
//		int desno = visina(cvor.desno);
//		
//		return Math.max(levo, desno) + 1;
//		
//	}
	
	
	int zbirSvihNajdubljihR(CvorStabla cvor) throws LabisException{
		
		if(cvor == null){
			
			throw new LabisException("Prazno stablo.");
			
		}
		
		int najdublji = visina(cvor);
		
		return zbirSvihNajdubljih(cvor, najdublji, 1);
		
		
		
	}
	
	int zbirSvihNajdubljih(CvorStabla cvor, int trazeniNivo, int nivo){
		
		if(cvor==null){
			return 0;
		}
		
		int levo = zbirSvihNajdubljih(cvor.levo, trazeniNivo, nivo+1);
		int desno = zbirSvihNajdubljih(cvor.desno, trazeniNivo, nivo+1);
		
		if(cvor.levo == null && cvor.desno == null && nivo == trazeniNivo){
			return levo + desno + cvor.podatak;
		}
		else{
			return levo + desno;
		}
		
		
	}

	
	//11. Vrati proizvod svih listova stabla.

	int proizvodListR(CvorStabla cvor) throws LabisException{
		
		if(cvor == null){
			throw new LabisException("Prazno stablo");
		}
		
		return proizvodList(cvor);
		
	}
	
	int proizvodList(CvorStabla cvor){
		
		if(cvor == null){
			return 1;
		}
		
		int levo = proizvodList(cvor.levo);
		int desno = proizvodList(cvor.desno);
		
		if(cvor.levo == null && cvor.desno == null){
			
			return levo * desno * cvor.podatak;
			
		}
		
		else{
			
			return levo * desno;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}


