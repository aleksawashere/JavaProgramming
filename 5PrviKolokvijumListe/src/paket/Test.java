package paket;

import labis.exception.LabisException;
import labis.test.ListGenerator;

public class Test {

	public static void main(String[] args) throws LabisException{

		DSLista lista1 = new DSLista();
		int[] niz1 = {1,2,3,4,5,6,7,8,9,10};

		
		ListGenerator.napraviDSListuCommon(lista1, niz1, false);

		ListGenerator.ispisiDSListu(lista1.prvi);//sa leva na desno
		System.out.println();
		lista1.printNaopacke();
		
		lista1.preskociMIzbaciN(2,3);
		
		ListGenerator.ispisiDSListu(lista1.prvi);//sa leva na desno
		System.out.println();
		lista1.printNaopacke();

	}

}
