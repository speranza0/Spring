package com.spring.marble.dto;

public class UserParam {
	private String id;
	private Integer dicesum;
	private Integer dicecount;
	private Integer roundnum;
	private Float avg;

	
	
	public UserParam() {
	}

	public UserParam(String id, Integer dicesum, Integer roundnum) {
		this.id = id;
		this.dicesum = dicesum;
		this.roundnum = roundnum;
	}



	public UserParam(String id, Integer dicesum, Integer dicecount, Integer roundnum, Float avg) {
		this.id = id;
		this.dicesum = dicesum;
		this.dicecount = dicecount;
		this.roundnum = roundnum;
		this.avg = avg;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public Integer getDicesum() {
		return dicesum;
	}



	public void setDicesum(Integer dicesum) {
		this.dicesum = dicesum;
	}



	public Integer getDicecount() {
		return dicecount;
	}



	public void setDicecount(Integer dicecount) {
		this.dicecount = dicecount;
	}



	public Integer getRoundnum() {
		return roundnum;
	}



	public void setRoundnum(Integer roundnum) {
		this.roundnum = roundnum;
	}



	public Float getAvg() {
		return avg;
	}



	public void setAvg(Float avg) {
		this.avg = avg;
	}

	
	
}
