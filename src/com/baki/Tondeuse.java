package com.baki;

/**
 * 
 * @author Dell
 *
 */
public class Tondeuse {

	private Position positionActuel;
	private String lstSequence;

	public Tondeuse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tondeuse(Position positionActuel, String lstSequence) {
		super();
		this.positionActuel = positionActuel;
		this.lstSequence = lstSequence;
	}

	/**
	 * @return the positionActuel
	 */
	public Position getPositionActuel() {
		return positionActuel;
	}

	/**
	 * @param positionActuel
	 *            the positionActuel to set
	 */
	public void setPositionActuel(Position positionActuel) {
		this.positionActuel = positionActuel;
	}

	/**
	 * @return the lstSequence
	 */
	public String getLstSequence() {
		return lstSequence;
	}

	/**
	 * @param lstSequence
	 *            the lstSequence to set
	 */
	public void setLstSequence(String lstSequence) {
		this.lstSequence = lstSequence;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Tondeuse [positionActuel=%s, lstSequence=%s]", positionActuel, lstSequence);
	}

}
