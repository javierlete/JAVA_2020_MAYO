package com.ipartek.formacion.ejemplopoo.tipos;

public class Punto { //public class Punto extends Object {
	protected static final double Y_POR_DEFECTO = 0.0; // protected = visible a través de herencia Y/O mismo paquete
	protected static final double X_POR_DEFECTO = 0.0;
	
	// 1. Variables de instancia (almacenamiento de datos)
	private double x, y;

	// 3. Constructor de la clase con todas las variables de instancia
	// (Inicialización rápida de un objeto)
	public Punto(double x, double y) {
		setX(x);
		setY(y);
	}
	
	public Punto() {
		this(X_POR_DEFECTO, Y_POR_DEFECTO);
	}

	// 6. Métodos de instancia
	public Punto sumar(Punto punto) {
		//return new Punto(x + punto.getX(), y + punto.getY());
		return sumar(this, punto);
		// main() {
		// 	punto1 = new Punto(1,2)
		// 	punto2 = new Punto(3,4)
		// 	punto1.sumar(punto2)
		// }
		// En este método se hacen las siguientes asignaciones en la llamada
		// this = punto1
		// punto = punto2
		
		// sumar(this, punto)
		// Es equivalente a Punto.sumar(this, punto)
		// Indirectamente estamos haciendo Punto.sumar(punto1, punto2)
	}

	// 7. Métodos estáticos (de clase)
	public static Punto sumar(Punto p1, Punto p2) {
		return new Punto(p1.getX() + p2.getX(), p1.getY() + p2.getY());
	}

	// 2. Getters y setters (acceso exterior a los datos: métodos de acceso)
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	// 5. hashCode() e equals() (permite comparar dos objetos de este tipo por
	// contenido)
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Punto other = (Punto) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}

	// 4. toString() (Conversor a texto del objeto)
	@Override
	public String toString() {
		return "Punto [x=" + x + ", y=" + y + "]";
	}
}
