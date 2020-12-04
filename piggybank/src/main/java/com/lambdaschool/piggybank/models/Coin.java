package com.lambdaschool.piggybank.models;


import javax.persistence.*;



@Entity
@Table(name = "coins")
public class Coin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long coinid;

	private long   quantity;
	private long   value;
	private String name;
	private String nameplural;

	public Coin() {}

	public Coin(
			long quantity,
			long value,
			String name,
			String nameplural
	) {
		this.quantity   = quantity;
		this.value      = value;
		this.name       = name;
		this.nameplural = nameplural;
	}

	public long getCoinid() {
		return coinid;
	}

	public void setCoinid(long coinid) {
		this.coinid = coinid;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameplural() {
		return nameplural;
	}

	public void setNameplural(String nameplural) {
		this.nameplural = nameplural;
	}

}
