public class TestNotes {
	public static void main(String[] args) {
		
		/* Construim 3 alumnes */
		Alumne alu1 = new Alumne("a12345");
		Alumne alu2 = new Alumne("b12345");
		Alumne alu3 = new Alumne("c12345"); 
		
		/* Afegim algunes assignatures a cada alumne */ 
		alu1.addAssignatura(new Assignatura("Xarxes"));
		alu1.addAssignatura(new Assignatura("Programacio"));
		
		alu2.addAssignatura(new Assignatura("Bases de Dades"));
		alu2.addAssignatura(new Assignatura("Programacio"));
		alu2.addAssignatura(new Assignatura("Sistemes Operatius"));
		alu2.addAssignatura(new Assignatura("Fol"));
	
		alu3.addAssignatura(new Assignatura("Bases de Dades"));
		alu3.addAssignatura(new Assignatura("Sistemes Operatius"));
		alu3.addAssignatura(new Assignatura("Fol"));

		/* Construim un professor */
		Professor p = new Professor("12345678F");
	
		/* El professor possa notes als alumnes sense cap mena de criteri*/
		p.qualifica(alu1);
		p.qualifica(alu2);
		p.qualifica(alu3);
		
		/* Mostrem les notes de les assignatures de cada alumne i la seva mitja */
		System.out.println("Mostrem les notes de les assignatures de cada alumne i la seva mitja\n");

		System.out.println(alu1);
		System.out.println("mitjana: " + p.calcularMitjana(alu1));
		System.out.println();
		System.out.println(alu2);
		System.out.println("mitjana: " + p.calcularMitjana(alu2));
		System.out.println();
		System.out.println(alu3);
		System.out.println("mitjana: " + p.calcularMitjana(alu3));
		System.out.println();
		
		/* Intentem afegir a un alumne una assignatura que ja cursa */
		String str1 = new String("Fol");
		Assignatura assig6 = new Assignatura(str1);
		System.out.println("Intentem afegir una assignatura que l'alumne ja cursa\n");
		alu2.addAssignatura(assig6);
		/* Mostrem un altre cop les assignatures del alumne*/
		System.out.println("Mostrem un altre cop les assignatures del alumne");
		System.out.println();
		System.out.println(alu2); 
	}
}
