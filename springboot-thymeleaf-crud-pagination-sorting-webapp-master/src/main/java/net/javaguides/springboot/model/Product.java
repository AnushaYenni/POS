package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "pack")
	private String pack;
	
	@Column(name = "max")
	private String max;
	
	@Column(name = "purchase")
	private String purchase;
	
	@Column(name = "sp")
	private String sp;
	
	@Column(name = "gst")
	private String gst;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPack() {
		return pack;
	}
	public void setPack(String pack) {
		this.pack = pack;
	}
	public String getMax() {
		return max;
	}
	public void setMax(String max) {
		this.max = max;
	}
	public String getPurchase() {
		return purchase;
	}
	public void setPurchase(String purchase) {
		this.purchase = purchase;
	}
	public String getSp() {
		return sp;
	}
	public void setSp(String sp) {
		this.sp = sp;
	}
	public String getGst() {
		return gst;
	}
	public void setGst(String gst) {
		this.gst = gst;
	
	}
}
