package com.xiaoshu.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Xue_ShengExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Xue_ShengExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andBianhaoIsNull() {
            addCriterion("bianhao is null");
            return (Criteria) this;
        }

        public Criteria andBianhaoIsNotNull() {
            addCriterion("bianhao is not null");
            return (Criteria) this;
        }

        public Criteria andBianhaoEqualTo(Integer value) {
            addCriterion("bianhao =", value, "bianhao");
            return (Criteria) this;
        }

        public Criteria andBianhaoNotEqualTo(Integer value) {
            addCriterion("bianhao <>", value, "bianhao");
            return (Criteria) this;
        }

        public Criteria andBianhaoGreaterThan(Integer value) {
            addCriterion("bianhao >", value, "bianhao");
            return (Criteria) this;
        }

        public Criteria andBianhaoGreaterThanOrEqualTo(Integer value) {
            addCriterion("bianhao >=", value, "bianhao");
            return (Criteria) this;
        }

        public Criteria andBianhaoLessThan(Integer value) {
            addCriterion("bianhao <", value, "bianhao");
            return (Criteria) this;
        }

        public Criteria andBianhaoLessThanOrEqualTo(Integer value) {
            addCriterion("bianhao <=", value, "bianhao");
            return (Criteria) this;
        }

        public Criteria andBianhaoIn(List<Integer> values) {
            addCriterion("bianhao in", values, "bianhao");
            return (Criteria) this;
        }

        public Criteria andBianhaoNotIn(List<Integer> values) {
            addCriterion("bianhao not in", values, "bianhao");
            return (Criteria) this;
        }

        public Criteria andBianhaoBetween(Integer value1, Integer value2) {
            addCriterion("bianhao between", value1, value2, "bianhao");
            return (Criteria) this;
        }

        public Criteria andBianhaoNotBetween(Integer value1, Integer value2) {
            addCriterion("bianhao not between", value1, value2, "bianhao");
            return (Criteria) this;
        }

        public Criteria andXingMingIsNull() {
            addCriterion("xing_ming is null");
            return (Criteria) this;
        }

        public Criteria andXingMingIsNotNull() {
            addCriterion("xing_ming is not null");
            return (Criteria) this;
        }

        public Criteria andXingMingEqualTo(String value) {
            addCriterion("xing_ming =", value, "xingMing");
            return (Criteria) this;
        }

        public Criteria andXingMingNotEqualTo(String value) {
            addCriterion("xing_ming <>", value, "xingMing");
            return (Criteria) this;
        }

        public Criteria andXingMingGreaterThan(String value) {
            addCriterion("xing_ming >", value, "xingMing");
            return (Criteria) this;
        }

        public Criteria andXingMingGreaterThanOrEqualTo(String value) {
            addCriterion("xing_ming >=", value, "xingMing");
            return (Criteria) this;
        }

        public Criteria andXingMingLessThan(String value) {
            addCriterion("xing_ming <", value, "xingMing");
            return (Criteria) this;
        }

        public Criteria andXingMingLessThanOrEqualTo(String value) {
            addCriterion("xing_ming <=", value, "xingMing");
            return (Criteria) this;
        }

        public Criteria andXingMingLike(String value) {
            addCriterion("xing_ming like", value, "xingMing");
            return (Criteria) this;
        }

        public Criteria andXingMingNotLike(String value) {
            addCriterion("xing_ming not like", value, "xingMing");
            return (Criteria) this;
        }

        public Criteria andXingMingIn(List<String> values) {
            addCriterion("xing_ming in", values, "xingMing");
            return (Criteria) this;
        }

        public Criteria andXingMingNotIn(List<String> values) {
            addCriterion("xing_ming not in", values, "xingMing");
            return (Criteria) this;
        }

        public Criteria andXingMingBetween(String value1, String value2) {
            addCriterion("xing_ming between", value1, value2, "xingMing");
            return (Criteria) this;
        }

        public Criteria andXingMingNotBetween(String value1, String value2) {
            addCriterion("xing_ming not between", value1, value2, "xingMing");
            return (Criteria) this;
        }

        public Criteria andXingbieIsNull() {
            addCriterion("xingbie is null");
            return (Criteria) this;
        }

        public Criteria andXingbieIsNotNull() {
            addCriterion("xingbie is not null");
            return (Criteria) this;
        }

        public Criteria andXingbieEqualTo(String value) {
            addCriterion("xingbie =", value, "xingbie");
            return (Criteria) this;
        }

        public Criteria andXingbieNotEqualTo(String value) {
            addCriterion("xingbie <>", value, "xingbie");
            return (Criteria) this;
        }

        public Criteria andXingbieGreaterThan(String value) {
            addCriterion("xingbie >", value, "xingbie");
            return (Criteria) this;
        }

        public Criteria andXingbieGreaterThanOrEqualTo(String value) {
            addCriterion("xingbie >=", value, "xingbie");
            return (Criteria) this;
        }

        public Criteria andXingbieLessThan(String value) {
            addCriterion("xingbie <", value, "xingbie");
            return (Criteria) this;
        }

        public Criteria andXingbieLessThanOrEqualTo(String value) {
            addCriterion("xingbie <=", value, "xingbie");
            return (Criteria) this;
        }

        public Criteria andXingbieLike(String value) {
            addCriterion("xingbie like", value, "xingbie");
            return (Criteria) this;
        }

        public Criteria andXingbieNotLike(String value) {
            addCriterion("xingbie not like", value, "xingbie");
            return (Criteria) this;
        }

        public Criteria andXingbieIn(List<String> values) {
            addCriterion("xingbie in", values, "xingbie");
            return (Criteria) this;
        }

        public Criteria andXingbieNotIn(List<String> values) {
            addCriterion("xingbie not in", values, "xingbie");
            return (Criteria) this;
        }

        public Criteria andXingbieBetween(String value1, String value2) {
            addCriterion("xingbie between", value1, value2, "xingbie");
            return (Criteria) this;
        }

        public Criteria andXingbieNotBetween(String value1, String value2) {
            addCriterion("xingbie not between", value1, value2, "xingbie");
            return (Criteria) this;
        }

        public Criteria andAihaoIsNull() {
            addCriterion("aihao is null");
            return (Criteria) this;
        }

        public Criteria andAihaoIsNotNull() {
            addCriterion("aihao is not null");
            return (Criteria) this;
        }

        public Criteria andAihaoEqualTo(String value) {
            addCriterion("aihao =", value, "aihao");
            return (Criteria) this;
        }

        public Criteria andAihaoNotEqualTo(String value) {
            addCriterion("aihao <>", value, "aihao");
            return (Criteria) this;
        }

        public Criteria andAihaoGreaterThan(String value) {
            addCriterion("aihao >", value, "aihao");
            return (Criteria) this;
        }

        public Criteria andAihaoGreaterThanOrEqualTo(String value) {
            addCriterion("aihao >=", value, "aihao");
            return (Criteria) this;
        }

        public Criteria andAihaoLessThan(String value) {
            addCriterion("aihao <", value, "aihao");
            return (Criteria) this;
        }

        public Criteria andAihaoLessThanOrEqualTo(String value) {
            addCriterion("aihao <=", value, "aihao");
            return (Criteria) this;
        }

        public Criteria andAihaoLike(String value) {
            addCriterion("aihao like", value, "aihao");
            return (Criteria) this;
        }

        public Criteria andAihaoNotLike(String value) {
            addCriterion("aihao not like", value, "aihao");
            return (Criteria) this;
        }

        public Criteria andAihaoIn(List<String> values) {
            addCriterion("aihao in", values, "aihao");
            return (Criteria) this;
        }

        public Criteria andAihaoNotIn(List<String> values) {
            addCriterion("aihao not in", values, "aihao");
            return (Criteria) this;
        }

        public Criteria andAihaoBetween(String value1, String value2) {
            addCriterion("aihao between", value1, value2, "aihao");
            return (Criteria) this;
        }

        public Criteria andAihaoNotBetween(String value1, String value2) {
            addCriterion("aihao not between", value1, value2, "aihao");
            return (Criteria) this;
        }

        public Criteria andShengriIsNull() {
            addCriterion("shengri is null");
            return (Criteria) this;
        }

        public Criteria andShengriIsNotNull() {
            addCriterion("shengri is not null");
            return (Criteria) this;
        }

        public Criteria andShengriEqualTo(Date value) {
            addCriterionForJDBCDate("shengri =", value, "shengri");
            return (Criteria) this;
        }

        public Criteria andShengriNotEqualTo(Date value) {
            addCriterionForJDBCDate("shengri <>", value, "shengri");
            return (Criteria) this;
        }

        public Criteria andShengriGreaterThan(Date value) {
            addCriterionForJDBCDate("shengri >", value, "shengri");
            return (Criteria) this;
        }

        public Criteria andShengriGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("shengri >=", value, "shengri");
            return (Criteria) this;
        }

        public Criteria andShengriLessThan(Date value) {
            addCriterionForJDBCDate("shengri <", value, "shengri");
            return (Criteria) this;
        }

        public Criteria andShengriLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("shengri <=", value, "shengri");
            return (Criteria) this;
        }

        public Criteria andShengriIn(List<Date> values) {
            addCriterionForJDBCDate("shengri in", values, "shengri");
            return (Criteria) this;
        }

        public Criteria andShengriNotIn(List<Date> values) {
            addCriterionForJDBCDate("shengri not in", values, "shengri");
            return (Criteria) this;
        }

        public Criteria andShengriBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("shengri between", value1, value2, "shengri");
            return (Criteria) this;
        }

        public Criteria andShengriNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("shengri not between", value1, value2, "shengri");
            return (Criteria) this;
        }

        public Criteria andZhaopianIsNull() {
            addCriterion("zhaopian is null");
            return (Criteria) this;
        }

        public Criteria andZhaopianIsNotNull() {
            addCriterion("zhaopian is not null");
            return (Criteria) this;
        }

        public Criteria andZhaopianEqualTo(String value) {
            addCriterion("zhaopian =", value, "zhaopian");
            return (Criteria) this;
        }

        public Criteria andZhaopianNotEqualTo(String value) {
            addCriterion("zhaopian <>", value, "zhaopian");
            return (Criteria) this;
        }

        public Criteria andZhaopianGreaterThan(String value) {
            addCriterion("zhaopian >", value, "zhaopian");
            return (Criteria) this;
        }

        public Criteria andZhaopianGreaterThanOrEqualTo(String value) {
            addCriterion("zhaopian >=", value, "zhaopian");
            return (Criteria) this;
        }

        public Criteria andZhaopianLessThan(String value) {
            addCriterion("zhaopian <", value, "zhaopian");
            return (Criteria) this;
        }

        public Criteria andZhaopianLessThanOrEqualTo(String value) {
            addCriterion("zhaopian <=", value, "zhaopian");
            return (Criteria) this;
        }

        public Criteria andZhaopianLike(String value) {
            addCriterion("zhaopian like", value, "zhaopian");
            return (Criteria) this;
        }

        public Criteria andZhaopianNotLike(String value) {
            addCriterion("zhaopian not like", value, "zhaopian");
            return (Criteria) this;
        }

        public Criteria andZhaopianIn(List<String> values) {
            addCriterion("zhaopian in", values, "zhaopian");
            return (Criteria) this;
        }

        public Criteria andZhaopianNotIn(List<String> values) {
            addCriterion("zhaopian not in", values, "zhaopian");
            return (Criteria) this;
        }

        public Criteria andZhaopianBetween(String value1, String value2) {
            addCriterion("zhaopian between", value1, value2, "zhaopian");
            return (Criteria) this;
        }

        public Criteria andZhaopianNotBetween(String value1, String value2) {
            addCriterion("zhaopian not between", value1, value2, "zhaopian");
            return (Criteria) this;
        }

        public Criteria andBanjiidIsNull() {
            addCriterion("banjiid is null");
            return (Criteria) this;
        }

        public Criteria andBanjiidIsNotNull() {
            addCriterion("banjiid is not null");
            return (Criteria) this;
        }

        public Criteria andBanjiidEqualTo(Integer value) {
            addCriterion("banjiid =", value, "banjiid");
            return (Criteria) this;
        }

        public Criteria andBanjiidNotEqualTo(Integer value) {
            addCriterion("banjiid <>", value, "banjiid");
            return (Criteria) this;
        }

        public Criteria andBanjiidGreaterThan(Integer value) {
            addCriterion("banjiid >", value, "banjiid");
            return (Criteria) this;
        }

        public Criteria andBanjiidGreaterThanOrEqualTo(Integer value) {
            addCriterion("banjiid >=", value, "banjiid");
            return (Criteria) this;
        }

        public Criteria andBanjiidLessThan(Integer value) {
            addCriterion("banjiid <", value, "banjiid");
            return (Criteria) this;
        }

        public Criteria andBanjiidLessThanOrEqualTo(Integer value) {
            addCriterion("banjiid <=", value, "banjiid");
            return (Criteria) this;
        }

        public Criteria andBanjiidIn(List<Integer> values) {
            addCriterion("banjiid in", values, "banjiid");
            return (Criteria) this;
        }

        public Criteria andBanjiidNotIn(List<Integer> values) {
            addCriterion("banjiid not in", values, "banjiid");
            return (Criteria) this;
        }

        public Criteria andBanjiidBetween(Integer value1, Integer value2) {
            addCriterion("banjiid between", value1, value2, "banjiid");
            return (Criteria) this;
        }

        public Criteria andBanjiidNotBetween(Integer value1, Integer value2) {
            addCriterion("banjiid not between", value1, value2, "banjiid");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}