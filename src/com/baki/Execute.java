package com.baki;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Execute {

	public static void main(String[] args) {

		Surface surface = new Surface();

		surface.init(System.getProperty("user.dir") + "/test.txt");

		List<Tondeuse> lstTondeuses = surface.getLstTondeuses();
		

		for (int i = 0; i < lstTondeuses.size(); i++) {

			System.out.println("Tondeuse n° " + (i + 1));
			Tondeuse tondeuse = lstTondeuses.get(i);
			
			final int pointXdeb = tondeuse.getPositionActuel().getCoord().getX();
			final int pointYdeb = tondeuse.getPositionActuel().getCoord().getY();
			final String text0 = "T" + (i + 1) + "(" + pointXdeb + "," + pointYdeb + ","+ tondeuse.getPositionActuel().getCoord().getMyOrientation() + ")";
			JLabel jlabel0 = new JLabel(text0);
			jlabel0.setFont(new Font("Verdana", 1, 10));
			final JPanel jPanel0 = surface.getCell()[pointXdeb][pointYdeb];
			jPanel0.add(jlabel0);
			jPanel0.setBackground(Color.green);
			jPanel0.updateUI();
			
			String lstSequence = tondeuse.getLstSequence();
			for (int j = 0; j < lstSequence.length(); j++) {
				
				Position positionActuel = tondeuse.getPositionActuel();
				char charAt = lstSequence.charAt(j);

				positionActuel.adjustPosition(charAt);
				
				final int pointXCurrent = positionActuel.getCoord().getX();
				final int pointYCurrent = positionActuel.getCoord().getY();
				
				final String text = "T" + (i + 1) + "(" + pointXCurrent + "," + pointYCurrent + ","+ tondeuse.getPositionActuel().getCoord().getMyOrientation() + ")";
				
				JLabel jlabel1 = new JLabel(text);
				jlabel1.setFont(new Font("Verdana", 1, 10));
				final JPanel jPanel1 = surface.getCell()[pointXCurrent][pointYCurrent];
//				jPanel1.add(jlabel1);
				jPanel1.updateUI();
//				surface.getCell()[pointXCurrent][pointYCurrent].setBackground(Color.red);
				
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//				}
			}
			
			
			final String textfinal = "T" + (i + 1) + "(" + tondeuse.getPositionActuel().getCoord().getX() + "," + tondeuse.getPositionActuel().getCoord().getY() + ","+ tondeuse.getPositionActuel().getCoord().getMyOrientation() + ")";
			
			JLabel jlabelfinal = new JLabel(textfinal);
			jlabelfinal.setFont(new Font("Verdana", 1, 10));
			final JPanel jPanel2 = surface.getCell()[tondeuse.getPositionActuel().getCoord().getX()][tondeuse.getPositionActuel().getCoord().getY()];
			jPanel2.add(jlabelfinal);
			jPanel2.setBackground(Color.YELLOW);
			jPanel2.updateUI();
			
			System.out.println(tondeuse.getPositionActuel());

		}

	}
	
}
