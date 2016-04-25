package test;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import prgm.Face;
import prgm.Point;
import prgm.Segment;


public class TestPointSegmentFace {
	Point p1, p2, p3;
	Segment s1,s2,s3;
	Face f1;

	@Before
	public void setUp() throws Exception {
		p1 = new Point(1.0, -2.0, 3.0);
		p2 = new Point(4.0, 5.0, 6.0);
		p3 = new Point(7.0, 8.0, 9.0);
		s1 = new Segment(p1, p2);
		s2 = new Segment(p2, p3);
		s3 = new Segment(p1, p3);
		f1 = new Face(s1, s2, s3);
	}

	@Test
	public void testGetCoordPoint() {
		assertTrue(p1.getX()== 1.0);
		assertTrue(p1.getY()== -2.0);
		assertTrue(p1.getZ()== 3.0);
		assertFalse(p1.getX()== 11);
	}
	
	@Test
	public void testSetCoordPoint() {
		p1.setX(1.1); p1.setY(1.2); p1.setZ(1.3);
		assertTrue(p1.getX()== 1.1);
		assertTrue(p1.getY()== 1.2);
		assertTrue(p1.getZ()== 1.3);
	}
	
	@Test
	public void testGetPoint() {
		assertTrue(s1.getPt1()== p1);
		assertTrue(s1.getPt2()== p2);
		assertFalse(s1.getPt2()== p1);
	}
	
	@Test
	public void testSetPoint() {
		s1.setPt1(p2);s1.setPt2(p1);
		assertTrue(s1.getPt1()== p2);
		assertTrue(s1.getPt2()== p1);
	}
	
	@Test
	public void testGetSegment() {
		assertTrue(f1.getSeg1()== s1);
		assertTrue(f1.getSeg2()== s2);
		assertTrue(f1.getSeg3()== s3);
		assertFalse(f1.getSeg3()== s2);
	}
	
	
	

}
