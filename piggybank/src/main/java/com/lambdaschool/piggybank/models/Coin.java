package com.lambdaschool.piggybank.models;


import javax.persistence.*;



@Entity
@Table(name = "coins")
public class Coin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long coinid;

	private long   numberofcoins;
	private long   facevalue;
	private String name;
	private String nameall;

	public Coin() {}

	public Coin(
			long numberofcoins,
			long facevalue,
			String name,
			String nameall
	) {
		this.numberofcoins = numberofcoins;
		this.facevalue     = facevalue;
		this.name          = name;
		this.nameall       = nameall;
	}

	public long getCoinid() {
		return coinid;
	}

	public void setCoinid(long coinid) {
		this.coinid = coinid;
	}

	public long getNumberofcoins() {
		return numberofcoins;
	}

	public void setNumberofcoins(long numberofcoins) {
		this.numberofcoins = numberofcoins;
	}

	public long getFacevalue() {
		return facevalue;
	}

	public void setFacevalue(long facevalue) {
		this.facevalue = facevalue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameall() {
		return nameall;
	}

	public void setNameall(String nameall) {
		this.nameall = nameall;
	}

}
