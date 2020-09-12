import java.util.ArrayList;
import java.util.Iterator;
public class Professor {
	private String dni;

	public Professor(String dni) {
		this.dni = dni;
	}
	public String getDni() {
		return this.dni;
	}

	/* Possa notes aleatoriament a cada una de les asignatures del alumne */
	public void qualifica(Alumne a){
		Iterator<Assignatura> it = a.getAssignatura().iterator(); 
		while ( it.hasNext()) {
			it.next().setNota(Math.random()*10);
		}
	}				

	public double calcularMitjana(Alumne a){
		Iterator<Assignatura> it = a.getAssignatura().iterator();
		double mitjana = 0;
		double totalAsignatures = a.getAssignatura().size();
		while ( it.hasNext() ) {
			mitjana = mitjana + it.next().getNota();
		}
		return mitjana / totalAsignatures;
	}	
}