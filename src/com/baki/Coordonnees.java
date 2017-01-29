package com.baki;

/**
 * 
 * @author Dell
 *
 */
public class Coordonnees {

	private int x;
	private int y;
	private OrientationEnum myOrientation;

	public Coordonnees() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Coordonnees(int x, int y, OrientationEnum myOrientation) {
		super();
		this.x = x;
		this.y = y;
		this.myOrientation = myOrientation;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the myOrientation
	 */
	public OrientationEnum getMyOrientation() {
		return myOrientation;
	}

	/**
	 * @param myOrientation
	 *            the myOrientation to set
	 */
	public void setMyOrientation(OrientationEnum myOrientation) {
		this.myOrientation = myOrientation;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Coordonnees [x=%s, y=%s, myOrientation=%s]", x, y, myOrientation);
	}

}
