package com.xiaoshu.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;
@Table(name="xue_sheng")
public class Xue_Sheng implements Serializable {
    @Id
    private Integer bianhao;

    @Column(name = "xing_ming")
    private String xingming;

    private String xingbie;

    private String aihao;
    
    @Transient
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date start;
    @Transient
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date end;
    @Transient
    private Ban_Ji banji;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date shengri;
    private String zhaopian;

    private Integer banjiid;

    
    public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	private static final long serialVersionUID = 1L;

    /**
     * @return bianhao
     */
    public Integer getBianhao() {
        return bianhao;
    }

    /**
     * @param bianhao
     */
    public void setBianhao(Integer bianhao) {
        this.bianhao = bianhao;
    }

    /**
     * @return xing_ming
     */
    public String getXingming() {
        return xingming;
    }

    /**
     * @param xingMing
     */
    public void setXingming(String xingMing) {
        this.xingming = xingMing == null ? null : xingMing.trim();
    }

    /**
     * @return xingbie
     */
    public String getXingbie() {
        return xingbie;
    }

    /**
     * @param xingbie
     */
    public void setXingbie(String xingbie) {
        this.xingbie = xingbie == null ? null : xingbie.trim();
    }

    public Ban_Ji getBanji() {
		return banji;
	}

	public void setBanji(Ban_Ji banji) {
		this.banji = banji;
	}

	/**
     * @return aihao
     */
    public String getAihao() {
        return aihao;
    }

    /**
     * @param aihao
     */
    public void setAihao(String aihao) {
        this.aihao = aihao == null ? null : aihao.trim();
    }

    /**
     * @return shengri
     */
    public Date getShengri() {
        return shengri;
    }

    /**
     * @param shengri
     */
    public void setShengri(Date shengri) {
        this.shengri = shengri;
    }

    /**
     * @return zhaopian
     */
    public String getZhaopian() {
        return zhaopian;
    }

    /**
     * @param zhaopian
     */
    public void setZhaopian(String zhaopian) {
        this.zhaopian = zhaopian == null ? null : zhaopian.trim();
    }

    /**
     * @return banjiid
     */
    public Integer getBanjiid() {
        return banjiid;
    }

    /**
     * @param banjiid
     */
    public void setBanjiid(Integer banjiid) {
        this.banjiid = banjiid;
    }

	@Override
	public String toString() {
		return "Xue_Sheng [bianhao=" + bianhao + ", xingming=" + xingming + ", xingbie=" + xingbie + ", aihao=" + aihao
				+ ", start=" + start + ", end=" + end + ", banji=" + banji + ", shengri=" + shengri + ", zhaopian="
				+ zhaopian + ", banjiid=" + banjiid + ", getBianhao()=" + getBianhao() + ", getXingming()="
				+ getXingming() + ", getXingbie()=" + getXingbie() + ", getBanji()=" + getBanji() + ", getAihao()="
				+ getAihao() + ", getShengri()=" + getShengri() + ", getZhaopian()=" + getZhaopian() + ", getBanjiid()="
				+ getBanjiid() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

    
}