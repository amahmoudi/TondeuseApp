package com.baki;

/**
 * 
 * @author Dell
 *
 */
public enum SequenceEnum {
	A('A'), D('D'), G('G');

	private char value;

	/**
	 * 
	 * @param value
	 */
	private SequenceEnum(char value) {
		this.value = value;
	}

	/**
	 * 
	 * @return
	 */
	public char getValue() {
		return value;
	}
}
