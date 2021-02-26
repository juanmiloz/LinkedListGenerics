package model;

public class Prueba implements Comparable<Prueba>{

	private String mark;
	private String nameModel;
	private int modelYear;
	
	public Prueba(String mark, String nameModel, int modelYear) {
		this.mark = mark;
		this.nameModel = nameModel;
		this.modelYear = modelYear;
	}
	
	public String getMark() {
		return mark;
	}
	
	public String getnameModel() {
		return nameModel;
	}
	
	public int getModelYear() {
		return modelYear;
	}

	@Override
	public int compareTo(Prueba p) {
		int numReturn = 0;
		if(modelYear>p.getModelYear()) {
			numReturn = -1;
		}else if(modelYear<p.getModelYear()) {
			numReturn = 1;
		}else {
			numReturn = 0; 
		}
		return numReturn;
	}
	
	@Override
	public String toString() {
		String info = "marca: " + mark + " modelo: " + nameModel + " año: " + modelYear;
		return info;	
	}
}
