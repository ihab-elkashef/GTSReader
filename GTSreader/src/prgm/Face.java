package prgm;

public class Face {
	
	private Segment seg1, seg2, seg3;
	
	public Face(Segment seg1, Segment seg2, Segment seg3){
		this.seg1 = seg1;
		this.seg2 = seg2;
		this.seg3 = seg3;
	}

	public Segment getSeg1() {
		return seg1;
	}
	public void setSeg1(Segment seg1) {
		this.seg1 = seg1;
	}
	public Segment getSeg2() {
		return seg2;
	}
	public void setSeg2(Segment seg2) {
		this.seg2 = seg2;
	}
	public Segment getSeg3() {
		return seg3;
	}
	public void setSeg3(Segment seg3) {
		this.seg3 = seg3;
	}

	public String toString() {
		return "Face [seg1=" + seg1 + ", seg2=" + seg2 + ", seg3=" + seg3 + "]";
	}
}
