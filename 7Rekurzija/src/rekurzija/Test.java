package rekurzija;

public class Test {

	public static void main(String[] args) {

		//System.out.println(RekurzivneFunkcije.ProizvodCifaraR(-21312));
		
		//int[] niz = null;
		//RekurzivneFunkcije.IspisiNizR(niz);
		
		Cvor c1 = new Cvor();
		Cvor c2 = new Cvor();
		Cvor c3 = new Cvor();
		Cvor c4 = new Cvor();
		
		c1.podatak = 1;
		c1.sledeci = c2;
		
		c2.podatak = 2;
		c2.sledeci = c3;
		
		c3.podatak = 3;
		c3.sledeci = c4;
		
		c4.podatak = 4;
		
		JSLista lista = new JSLista();
		lista.prvi = c1;
		
		lista.printListaR();
		
		
	}

}
