package com.baki;

public class Orientation {

	private OrientationEnum myOrientation;

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
		return String.format("Orientation [myOrientation=%s]", myOrientation);
	}

}
