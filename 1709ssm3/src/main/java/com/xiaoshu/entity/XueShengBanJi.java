package com.xiaoshu.entity;

public class XueShengBanJi {
	private Integer renshu;

	private String banji;

	public Integer getRenshu() {
		return renshu;
	}

	public void setRenshu(Integer renshu) {
		this.renshu = renshu;
	}

	public String getBanji() {
		return banji;
	}

	public void setBanji(String banji) {
		this.banji = banji;
	}

	@Override
	public String toString() {
		return "XueShengBanJi [renshu=" + renshu + ", banji=" + banji + "]";
	}

	public XueShengBanJi(Integer renshu, String banji) {
		super();
		this.renshu = renshu;
		this.banji = banji;
	}

	public XueShengBanJi() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
