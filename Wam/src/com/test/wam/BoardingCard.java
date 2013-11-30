package com.test.wam;

public class BoardingCard {
	
	private String mSeatAssignment;
	
	private Transportation mTransportationType;
	
	

	/**
	 * @param mSeatAssignment
	 * @param mTransportationType
	 */
	public BoardingCard(String mSeatAssignment,
			Transportation mTransportationType) {
		this.mSeatAssignment = mSeatAssignment;
		this.mTransportationType = mTransportationType;
	}

	/**
	 * @return the mSeatAssignment
	 */
	public String getSeatAssignment() {
		return mSeatAssignment;
	}

	/**
	 * @param mSeatAssignment the mSeatAssignment to set
	 */
	public void setSeatAssignment(String mSeatAssignment) {
		this.mSeatAssignment = mSeatAssignment;
	}

	/**
	 * @return the mTransportationType
	 */
	public Transportation getTransportationType() {
		return mTransportationType;
	}

	/**
	 * @param mTransportationType the mTransportationType to set
	 */
	public void setTransportationType(Transportation mTransportationType) {
		this.mTransportationType = mTransportationType;
	}
}
