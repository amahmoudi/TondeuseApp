package com.baki.test;

import static org.junit.Assert.assertNull;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.baki.Orientation;
import com.baki.OrientationEnum;

public class OrientationTest {

	private Orientation orient;

	@Before
	public void setUp() throws Exception {
		orient = new Orientation();
	}

	@Test
	public void testGetMyOrientation() {
		{
			orient.setMyOrientation(null);
			assertNull(orient.getMyOrientation());
		}
		{
			orient.setMyOrientation(OrientationEnum.N);
			Assert.assertEquals(orient.getMyOrientation(), OrientationEnum.N);
		}

	}

}
