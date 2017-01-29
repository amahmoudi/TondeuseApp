package com.baki.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.baki.Coordonnees;
import com.baki.Position;
import com.baki.Tondeuse;
/**
 * 
 * @author Dell
 *
 */
public class TondeuseTest {

	private Tondeuse tondeuse;
	
/**
 * 
 * @throws Exception
 */
	@Before
	public void setUp() throws Exception {
		tondeuse = new Tondeuse();
	}

	@Test
	public void testGetPositionActuel() {
		final Position positionActuel = new Position();
		final Coordonnees coord = new Coordonnees();
		coord.setX(1);
		positionActuel.setCoord(coord);
		tondeuse.setPositionActuel(positionActuel);
		Assert.assertEquals(tondeuse.getPositionActuel().getCoord().getX(), 1);
	}

	@Test
	public void testGetLstSequence() {

		tondeuse.setLstSequence("test");
		Assert.assertEquals(tondeuse.getLstSequence(), "test");
	}

}
