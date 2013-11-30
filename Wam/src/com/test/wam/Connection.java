package com.test.wam;

public class Connection {

	private String mFrom;

	private String mTo;

	private BoardingCard mCard;

	/**
	 * @param mFrom
	 * @param mTo
	 * @param mCard
	 */
	public Connection(String mFrom, String mTo, BoardingCard mCard) {
		this.mFrom = mFrom;
		this.mTo = mTo;
		this.mCard = mCard;
	}

	/**
	 * @return the mFrom
	 */
	public String getFrom() {
		return mFrom;
	}

	/**
	 * @param mFrom
	 *            the mFrom to set
	 */
	public void setFrom(String mFrom) {
		this.mFrom = mFrom;
	}

	/**
	 * @return the mTo
	 */
	public String getTo() {
		return mTo;
	}

	/**
	 * @param mTo
	 *            the mTo to set
	 */
	public void setTo(String mTo) {
		this.mTo = mTo;
	}

	/**
	 * @return the mCard
	 */
	public BoardingCard getCard() {
		return mCard;
	}

	/**
	 * @param mCard
	 *            the mCard to set
	 */
	public void setCard(BoardingCard mCard) {
		this.mCard = mCard;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append(getCard().getTransportationType().getType()).append(" - ")
				.append(getFrom()).append(" > ").append(getTo());

		return sb.toString();
	}

	/**
	 * Make Board descritpion
	 * 
	 * @return
	 */
	public String getDescription() {

		StringBuilder sb = new StringBuilder();
		
		sb.append("From ").append(getFrom()).append(", take ").
		append(getCard().getTransportationType().getType());
		
		if(getCard().getTransportationType().getNumber() != null){
			sb.append(" ").append(getCard().getTransportationType().getNumber());
		}
		
		sb.append(" to ").append(getTo()).append(".");
		
		if(getCard().getTransportationType().getPlaceToTake() != null){
			sb.append(" ").append(getCard().getTransportationType().getPlaceToTake()).append(".");
		}
		
		if(getCard().getSeatAssignment() != null){
			sb.append(" ").append(getCard().getSeatAssignment()).append(".");
		}else sb.append(" ").append("No seat to place.");
		
		
		if(getCard().getTransportationType().getInfo() != null){
			sb.append(" ").append(getCard().getTransportationType().getInfo());
		}
		
		return sb.toString();
	}
}
