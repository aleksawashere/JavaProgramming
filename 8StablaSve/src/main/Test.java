package main;

import labis.cvorovi.CvorStabla;
import labis.exception.LabisException;

public class Test {

	public static void main(String[] args) throws LabisException {
		
		//        5
		//    3       1
		//  1   4   7  3
		//    2
		
		CvorStabla c1 = new CvorStabla(5);
		CvorStabla c2 = new CvorStabla(3);
		CvorStabla c3 = new CvorStabla(1);
		CvorStabla c4 = new CvorStabla(1);
		CvorStabla c5 = new CvorStabla(4);
		CvorStabla c6 = new CvorStabla(7);
		CvorStabla c7 = new CvorStabla(2);
	    CvorStabla c8 = new CvorStabla(3);

		c1.levo = c2;
		c1.desno = c3;
		
		c2.levo = c4;
		c2.desno = c5;
		
		c3.levo = c6;
		c4.desno = c7;
		
		c3.desno = c8;
		
		BinarnoStablo stablo = new BinarnoStablo();
		stablo.koren = c1;
		
		System.out.println(stablo.proizvodListR(stablo.koren));
	}

}
