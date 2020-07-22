package com.xiaoshu.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Table(name = "p_person")
public class YuanGong implements Serializable {
    @Id
    private Integer id;

    @Column(name = "p_name")
    private String pname;

    private String gender;

    @Column(name = "company_id")
    private Integer companyid;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date shijian;
    @Transient
    private gongsi gongsi;

    public gongsi getGongsi() {
		return gongsi;
	}

	public void setGongsi(gongsi gongsi) {
		this.gongsi = gongsi;
	}

	private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return p_name
     */
    public String getPname() {
        return pname;
    }

    /**
     * @param pName
     */
    public void setPname(String pName) {
        this.pname = pName == null ? null : pName.trim();
    }

    /**
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * @return company_id
     */
    public Integer getCompanyid() {
        return companyid;
    }

    /**
     * @param companyId
     */
    public void setCompanyid(Integer companyId) {
        this.companyid = companyId;
    }

    /**
     * @return shijian
     */
    public Date getShijian() {
        return shijian;
    }

    /**
     * @param shijian
     */
    public void setShijian(Date shijian) {
        this.shijian = shijian;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pName=").append(pname);
        sb.append(", gender=").append(gender);
        sb.append(", companyId=").append(companyid);
        sb.append(", shijian=").append(shijian);
        sb.append("]");
        return sb.toString();
    }
}