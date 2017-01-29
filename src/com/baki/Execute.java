package com.baki;

import java.util.List;

public class Execute {

	public static void main(String[] args) {

		Surface surface = new Surface();

		surface.init(System.getProperty("user.dir") + "/teste.txt");

		List<Tondeuse> lstTondeuses = surface.getLstTondeuses();
		for (int i = 0; i < lstTondeuses.size(); i++) {

			System.out.println("Tondeuse n° " + i);

			Tondeuse tondeuse = lstTondeuses.get(i);
			Position positionActuel = tondeuse.getPositionActuel();
			String lstSequence = tondeuse.getLstSequence();

			for (int j = 0; j < lstSequence.length(); j++) {
				char charAt = lstSequence.charAt(j);
				positionActuel.adjustPosition(charAt);
			}

			System.out.println(tondeuse.getPositionActuel());

		}

	}

}
