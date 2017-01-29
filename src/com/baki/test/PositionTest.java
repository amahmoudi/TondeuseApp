/**
 * 
 */
package com.baki.test;

import static org.junit.Assert.assertNull;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.baki.Coordonnees;
import com.baki.OrientationEnum;
import com.baki.Position;

/**
 * @author Dell
 *
 */
public class PositionTest {

	private Position pos;

	@Before
	public void setUp() throws Exception {
		pos = new Position();
	}

	@Test
	public void testGetCoordLimit() {

		{
			pos.setCoordLimit(null);
			assertNull(pos.getCoordLimit());
		}
		{
			final Coordonnees coordLimit = new Coordonnees();
			coordLimit.setMyOrientation(OrientationEnum.UNDEFINED);
			pos.setCoordLimit(coordLimit);
			Assert.assertEquals(pos.getCoordLimit().getMyOrientation(), OrientationEnum.UNDEFINED);
		}
	}

	@Test
	public void testGetCoord() {

		{
			pos.setCoord(null);
			assertNull(pos.getCoord());
		}
		{
			final Coordonnees coord = new Coordonnees();
			coord.setX(1);
			pos.setCoord(coord);
			Assert.assertEquals(pos.getCoord().getX(), 1);
		}
	}

	@Test
	public void testGetCoordDepart() {

		{
			pos.setCoordLimit(null);
			assertNull(pos.getCoordDepart());
		}
		{
			final Coordonnees coordDepart = new Coordonnees();
			coordDepart.setMyOrientation(OrientationEnum.N);
			pos.setCoordLimit(coordDepart);
			Assert.assertEquals(pos.getCoordDepart().getMyOrientation(), OrientationEnum.N);
		}
	}

	@Test
	public void testAdjustPosition() {

		final Coordonnees coord = new Coordonnees();
		coord.setMyOrientation(OrientationEnum.N);
		coord.setX(1);
		coord.setY(1);
		pos.setCoord(coord);
		pos.setCoordDepart(new Coordonnees(0, 0, OrientationEnum.UNDEFINED));
		pos.setCoordLimit(new Coordonnees(5, 5, OrientationEnum.UNDEFINED));
		{
			pos.adjustPosition('G');
			Assert.assertEquals(pos.getCoord().getMyOrientation(), OrientationEnum.E);
			Assert.assertEquals(pos.getCoord().getX(), 1);
			Assert.assertEquals(pos.getCoord().getY(), 1);
		}
		{
			pos.adjustPosition('D');
			Assert.assertEquals(pos.getCoord().getMyOrientation(), OrientationEnum.S);
			Assert.assertEquals(pos.getCoord().getX(), 1);
			Assert.assertEquals(pos.getCoord().getY(), 1);
		}
		{
			pos.adjustPosition('A');
			Assert.assertEquals(pos.getCoord().getMyOrientation(), OrientationEnum.S);
			Assert.assertEquals(pos.getCoord().getX(), 1);
			Assert.assertEquals(pos.getCoord().getY(), 0);
		}

	}

}
