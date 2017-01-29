package com.baki;

/**
 * 
 * @author Dell
 *
 */
public class Position {

	private Coordonnees coord;
	private Coordonnees coordLimit;
	private Coordonnees coordDepart;

	public Position() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Position(Coordonnees coord) {
		super();
		this.coord = coord;
	}

	/**
	 * @return the coordLimit
	 */
	public Coordonnees getCoordLimit() {
		return coordLimit;
	}

	/**
	 * @param coordLimit
	 *            the coordLimit to set
	 */
	public void setCoordLimit(Coordonnees coordLimit) {
		this.coordLimit = coordLimit;
	}

	/**
	 * @return the coord
	 */
	public Coordonnees getCoord() {
		return coord;
	}

	/**
	 * @param coord
	 *            the coord to set
	 */
	public void setCoord(Coordonnees coord) {
		this.coord = coord;
	}

	/**
	 * @return the coordDepart
	 */
	public Coordonnees getCoordDepart() {
		return coordDepart;
	}

	/**
	 * @param coordDepart
	 *            the coordDepart to set
	 */
	public void setCoordDepart(Coordonnees coordDepart) {
		this.coordDepart = coordDepart;
	}

	public void adjustPosition(char lettre) {
		OrientationEnum myOrientation = coord.getMyOrientation();
		int y = coord.getY();
		int x = coord.getX();
		boolean b = SequenceEnum.G.getValue() == lettre || SequenceEnum.D.getValue() == lettre;
		switch (myOrientation) {
		case N:
			if (b) {
				coord.setMyOrientation(OrientationEnum.E);
			} else if (y < coordLimit.getY()) {
				coord.setY(y + 1);
			}
			break;
		case S:
			if (b) {
				coord.setMyOrientation(OrientationEnum.W);
			} else if (y > coordDepart.getY()) {
				coord.setY(y - 1);
			}
			break;
		case E:
			if (b) {
				coord.setMyOrientation(OrientationEnum.S);
			} else if (x < coordLimit.getX()) {
				coord.setX(x + 1);
			}
			break;
		case W:
			if (b) {
				coord.setMyOrientation(OrientationEnum.N);
			} else if (x > coordDepart.getX()) {
				coord.setX(x - 1);
			}
			break;

		default:
			/// par defaut les coordonnes sont les coordonnees de depart
			coord.setMyOrientation(OrientationEnum.UNDEFINED);
			coord.setX(0);
			coord.setY(0);
			break;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Position [coord=%s %s %s]", coord.getX(), coord.getY(), coord.getMyOrientation());
	}

}
