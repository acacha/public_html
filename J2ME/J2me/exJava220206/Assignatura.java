public class Assignatura {
	private String id;
	private double nota;
	
	public Assignatura(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	public String toString() {
		return "Assignatura: " + id  + ", " + "Nota: " + nota;
	}
}
