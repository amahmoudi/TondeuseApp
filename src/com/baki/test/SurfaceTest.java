package com.baki.test;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.baki.Surface;
import com.baki.Tondeuse;

public class SurfaceTest {

	private Surface surface;

	@Before
	public void setUp() throws Exception {
		surface = new Surface();
	}

	@Test
	public void testGetLstTondeuses() {
		final ArrayList<Tondeuse> lstTondeuses = new ArrayList<>();
		surface.setLstTondeuses(lstTondeuses);
		Assert.assertEquals(surface.getLstTondeuses(), lstTondeuses);
	}

	@Test
	public void testGetLigneFile() {
		final ArrayList<String> lstLignefile = new ArrayList<>();
		lstLignefile.add("test");
		surface.setLigneFile(lstLignefile);
		Assert.assertEquals(surface.getLigneFile().get(0), "test");
	}

	@Test
	public void testInit() {
		surface.init(System.getProperty("user.dir") + "/test.txt");

		Assert.assertEquals(surface.getLstTondeuses().size(), 2);

		Assert.assertEquals(surface.getLstTondeuses().get(0).getLstSequence(), "GAGAGAGAA");

	}

}
