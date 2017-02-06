package com.baki;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.baki.gui.Fenetre;

/**
 * 
 * @author Dell
 *
 */
public class Surface  extends Fenetre{

	private List<Tondeuse> lstTondeuses;
	private List<String> ligneFile;

	public Surface() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Surface(List<Tondeuse> lstTondeuses) {
		super();
		this.lstTondeuses = lstTondeuses;
	}

	/**
	 * @return the lstTondeuses
	 */
	public List<Tondeuse> getLstTondeuses() {
		if (lstTondeuses == null)
			return new ArrayList<>();
		return lstTondeuses;
	}

	/**
	 * @param lstTondeuses
	 *            the lstTondeuses to set
	 */
	public void setLstTondeuses(List<Tondeuse> lstTondeuses) {
		this.lstTondeuses = lstTondeuses;
	}

	/**
	 * @return the ligneFile
	 */
	public List<String> getLigneFile() {
		return ligneFile;
	}

	/**
	 * @param ligneFile
	 *            the ligneFile to set
	 */
	public void setLigneFile(List<String> ligneFile) {
		this.ligneFile = ligneFile;
	}

	public void init(String pathFichier) {

		/// lecture de fichier
		List<String> lstFich = new ArrayList<>();
		try {
			InputStream flux = new FileInputStream(pathFichier);
			InputStreamReader lecture = new InputStreamReader(flux);
			BufferedReader buff = new BufferedReader(lecture);
			String ligne;
			while ((ligne = buff.readLine()) != null) {
				lstFich.add(ligne);

			}
			buff.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		if (lstFich.isEmpty()) {
			System.out.println("le fichier est vide ou introuvable");
			return;
		}
		setLigneFile(lstFich);
		// init position max + position min + init la position initial de chaque
		// tondeuse + la lecture de la liste des sequences pour chaque tondeuse
		initListTondeuses();

	}

	private void initListTondeuses() {

		final List<String> ligneFileData = getLigneFile();

		// init position max == la premiere ligne de fichier
		String[] splitCoordMax = ligneFileData.get(0).split("\\s+");
		Coordonnees coordCoordMax = new Coordonnees();
		coordCoordMax.setX(Integer.valueOf(splitCoordMax[0]));
		coordCoordMax.setY(Integer.valueOf(splitCoordMax[1]));
		coordCoordMax.setMyOrientation(OrientationEnum.UNDEFINED);

		// init position min == (0,0)
		final Coordonnees coordDepart = new Coordonnees();
		coordDepart.setX(0);
		coordDepart.setY(0);
		coordDepart.setMyOrientation(OrientationEnum.UNDEFINED);

		List<Tondeuse> lstTmp = new ArrayList<>();
		for (int i = 1; i < ligneFileData.size(); i++) {

			// recuperation des coordonnees de chaque tondeuse
			String[] split = ligneFileData.get(i++).split("\\s+");
			Coordonnees coord = new Coordonnees();
			coord.setX(Integer.valueOf(split[0]));
			coord.setY(Integer.valueOf(split[1]));
			coord.setMyOrientation(OrientationEnum.valueOf(split[2]));

			/// set la position actuel de chaque tondeuse
			Position positionActuel = new Position();
			positionActuel.setCoord(coord);

			// init position max == la premiere ligne de fichier
			positionActuel.setCoordLimit(coordCoordMax);

			// init position min == (0,0)
			positionActuel.setCoordDepart(coordDepart);

			// creer la nouvelle tondeuse et sa position + plus la liste des
			// sequences a executer
			Tondeuse tondeuse = new Tondeuse();
			tondeuse.setPositionActuel(positionActuel);
			tondeuse.setLstSequence(ligneFileData.get(i));
			lstTmp.add(tondeuse);
		}
		setLstTondeuses(lstTmp);
	}

	@Override
	public String toString() {
		return String.format("Surface [lstTondeuses=%s]", lstTondeuses);
	}
}
