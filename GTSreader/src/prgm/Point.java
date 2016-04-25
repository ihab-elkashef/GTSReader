package prgm;

public class Point {
	
	private double x, y, z;
	
	public Point(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Point() {
		// TODO Auto-generated constructor stub
	}

	public Point additioner(Point a){
		Point somme = new Point();
		somme.setX(this.getX() + a.getX());
		somme.setY(this.getY() + a.getY());
		somme.setZ(this.getZ() + a.getZ());
		return somme;
	}
	
	public Point soustraire(Point b){
		Point soustract = new Point();
		soustract.setX(this.getX() - b.getX());
		soustract.setY(this.getY() - b.getY());
		soustract.setZ(this.getZ() - b.getZ());
		return soustract;
	}
	
	public double scalaire(Point p){
		double scal ;
		scal = this.x * p.getX() + this.getY() * p.getY() + this.getZ() *p.getZ();
		return scal;
	}
	
	public Point vectoriel(Point v){
		Point vec = new Point();
		vec.setX(this.getX() * v.getZ() - this.getZ() * v.getY());
		vec.setY(this.getZ() * v.getX() - this.getX() * v.getZ());
		vec.setZ(this.getX() * v.getY() - this.getY() * v.getX());
		return vec;
	}
	
	public void vecteurUnitaire(){
		double valeurAbs = Math.sqrt(this.getX()*this.getX() + this.getY()*this.getY() + this.getZ()*this.getZ());
		this.setX(this.getX()/valeurAbs);
		this.setY(this.getY()/valeurAbs);
		this.setZ(this.getZ()/valeurAbs);
	}

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
	public double getZ() {
		return z;
	}
	public void setZ(double z) {
		this.z = z;
	}

	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
}
