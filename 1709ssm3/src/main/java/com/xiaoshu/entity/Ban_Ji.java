package com.xiaoshu.entity;

import java.io.Serializable;
import javax.persistence.*;
@Table(name="ban_ji")
public class Ban_Ji implements Serializable {
    @Id
    private Integer banjiid;

    private String banji;

    private static final long serialVersionUID = 1L;

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

    /**
     * @return banji
     */
    public String getBanji() {
        return banji;
    }

    /**
     * @param banji
     */
    public void setBanji(String banji) {
        this.banji = banji == null ? null : banji.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", banjiid=").append(banjiid);
        sb.append(", banji=").append(banji);
        sb.append("]");
        return sb.toString();
    }
}