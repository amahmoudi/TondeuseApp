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

/**
 * @author Dell
 *
 */
public class CoordonneesTest {

	private Coordonnees coord;

	@Before
	public void setUp() throws Exception {
		coord = new Coordonnees();
	}

	@Test
	public void testGetX() {
		coord.setX(1);
		Assert.assertEquals(coord.getX(), 1);
	}

	@Test
	public void testGetY() {
		coord.setY(2);
		Assert.assertEquals(coord.getY(), 2);
	}

	@Test
	public void testGetMyOrientation() {
		{
			coord.setMyOrientation(null);
			assertNull(coord.getMyOrientation());
		}
		{
			coord.setMyOrientation(OrientationEnum.N);
			Assert.assertEquals(coord.getMyOrientation(), OrientationEnum.N);
		}

	}

}
