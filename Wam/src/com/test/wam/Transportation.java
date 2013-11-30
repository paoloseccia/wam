package com.test.wam;

public class Transportation {

	private String mType;

	private String mNumber;

	private String mPlaceToTake;

	private String mInfo;

	/**
	 * @param mType
	 * @param mNumber
	 * @param mPlaceToTake
	 * @param mInfo
	 */
	public Transportation(String mType, String mNumber, String mPlaceToTake,
			String mInfo) {
		this.mType = mType;
		this.mNumber = mNumber;
		this.mPlaceToTake = mPlaceToTake;
		this.mInfo = mInfo;
	}
	

	/**
	 * @return the mType
	 */
	public String getType() {
		return mType;
	}

	/**
	 * @param mType the mType to set
	 */
	public void setType(String mType) {
		this.mType = mType;
	}

	/**
	 * @return the mNumber
	 */
	public String getNumber() {
		return mNumber;
	}

	/**
	 * @param mNumber the mNumber to set
	 */
	public void setNumber(String mNumber) {
		this.mNumber = mNumber;
	}

	/**
	 * @return the mPlaceToTake
	 */
	public String getPlaceToTake() {
		return mPlaceToTake;
	}

	/**
	 * @param mPlaceToTake the mPlaceToTake to set
	 */
	public void setPlaceToTake(String mPlaceToTake) {
		this.mPlaceToTake = mPlaceToTake;
	}

	/**
	 * @return the mInfo
	 */
	public String getInfo() {
		return mInfo;
	}

	/**
	 * @param mInfo the mInfo to set
	 */
	public void setInfo(String mInfo) {
		this.mInfo = mInfo;
	}
}
