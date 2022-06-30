package ciklicneJS;

public class Test {

	public static void main(String[] args) {
		
		JSCiklicna lista = new JSCiklicna();
				
		lista.print();
		//lista.petlja()
		
		lista.ubaciNaKrajJSCik(5);
		lista.ubaciNaKrajJSCik(15);
		lista.ubaciNaKrajJSCik(6);
		
		lista.print();
	
	}

}
