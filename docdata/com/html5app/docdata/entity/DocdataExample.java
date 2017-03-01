package com.html5app.docdata.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DocdataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DocdataExample() {
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

        public Criteria andDatatimeIsNull() {
            addCriterion("DataTime is null");
            return (Criteria) this;
        }

        public Criteria andDatatimeIsNotNull() {
            addCriterion("DataTime is not null");
            return (Criteria) this;
        }

        public Criteria andDatatimeEqualTo(Date value) {
            addCriterion("DataTime =", value, "datatime");
            return (Criteria) this;
        }

        public Criteria andDatatimeNotEqualTo(Date value) {
            addCriterion("DataTime <>", value, "datatime");
            return (Criteria) this;
        }

        public Criteria andDatatimeGreaterThan(Date value) {
            addCriterion("DataTime >", value, "datatime");
            return (Criteria) this;
        }

        public Criteria andDatatimeGreaterThanOrEqualTo(Date value) {
            addCriterion("DataTime >=", value, "datatime");
            return (Criteria) this;
        }

        public Criteria andDatatimeLessThan(Date value) {
            addCriterion("DataTime <", value, "datatime");
            return (Criteria) this;
        }

        public Criteria andDatatimeLessThanOrEqualTo(Date value) {
            addCriterion("DataTime <=", value, "datatime");
            return (Criteria) this;
        }

        public Criteria andDatatimeIn(List<Date> values) {
            addCriterion("DataTime in", values, "datatime");
            return (Criteria) this;
        }

        public Criteria andDatatimeNotIn(List<Date> values) {
            addCriterion("DataTime not in", values, "datatime");
            return (Criteria) this;
        }

        public Criteria andDatatimeBetween(Date value1, Date value2) {
            addCriterion("DataTime between", value1, value2, "datatime");
            return (Criteria) this;
        }

        public Criteria andDatatimeNotBetween(Date value1, Date value2) {
            addCriterion("DataTime not between", value1, value2, "datatime");
            return (Criteria) this;
        }

        public Criteria andDoctagnameIsNull() {
            addCriterion("DocTagName is null");
            return (Criteria) this;
        }

        public Criteria andDoctagnameIsNotNull() {
            addCriterion("DocTagName is not null");
            return (Criteria) this;
        }

        public Criteria andDoctagnameEqualTo(String value) {
            addCriterion("DocTagName =", value, "doctagname");
            return (Criteria) this;
        }

        public Criteria andDoctagnameNotEqualTo(String value) {
            addCriterion("DocTagName <>", value, "doctagname");
            return (Criteria) this;
        }

        public Criteria andDoctagnameGreaterThan(String value) {
            addCriterion("DocTagName >", value, "doctagname");
            return (Criteria) this;
        }

        public Criteria andDoctagnameGreaterThanOrEqualTo(String value) {
            addCriterion("DocTagName >=", value, "doctagname");
            return (Criteria) this;
        }

        public Criteria andDoctagnameLessThan(String value) {
            addCriterion("DocTagName <", value, "doctagname");
            return (Criteria) this;
        }

        public Criteria andDoctagnameLessThanOrEqualTo(String value) {
            addCriterion("DocTagName <=", value, "doctagname");
            return (Criteria) this;
        }

        public Criteria andDoctagnameLike(String value) {
            addCriterion("DocTagName like", value, "doctagname");
            return (Criteria) this;
        }

        public Criteria andDoctagnameNotLike(String value) {
            addCriterion("DocTagName not like", value, "doctagname");
            return (Criteria) this;
        }

        public Criteria andDoctagnameIn(List<String> values) {
            addCriterion("DocTagName in", values, "doctagname");
            return (Criteria) this;
        }

        public Criteria andDoctagnameNotIn(List<String> values) {
            addCriterion("DocTagName not in", values, "doctagname");
            return (Criteria) this;
        }

        public Criteria andDoctagnameBetween(String value1, String value2) {
            addCriterion("DocTagName between", value1, value2, "doctagname");
            return (Criteria) this;
        }

        public Criteria andDoctagnameNotBetween(String value1, String value2) {
            addCriterion("DocTagName not between", value1, value2, "doctagname");
            return (Criteria) this;
        }

        public Criteria andDocvalueIsNull() {
            addCriterion("DocValue is null");
            return (Criteria) this;
        }

        public Criteria andDocvalueIsNotNull() {
            addCriterion("DocValue is not null");
            return (Criteria) this;
        }

        public Criteria andDocvalueEqualTo(Float value) {
            addCriterion("DocValue =", value, "docvalue");
            return (Criteria) this;
        }

        public Criteria andDocvalueNotEqualTo(Float value) {
            addCriterion("DocValue <>", value, "docvalue");
            return (Criteria) this;
        }

        public Criteria andDocvalueGreaterThan(Float value) {
            addCriterion("DocValue >", value, "docvalue");
            return (Criteria) this;
        }

        public Criteria andDocvalueGreaterThanOrEqualTo(Float value) {
            addCriterion("DocValue >=", value, "docvalue");
            return (Criteria) this;
        }

        public Criteria andDocvalueLessThan(Float value) {
            addCriterion("DocValue <", value, "docvalue");
            return (Criteria) this;
        }

        public Criteria andDocvalueLessThanOrEqualTo(Float value) {
            addCriterion("DocValue <=", value, "docvalue");
            return (Criteria) this;
        }

        public Criteria andDocvalueIn(List<Float> values) {
            addCriterion("DocValue in", values, "docvalue");
            return (Criteria) this;
        }

        public Criteria andDocvalueNotIn(List<Float> values) {
            addCriterion("DocValue not in", values, "docvalue");
            return (Criteria) this;
        }

        public Criteria andDocvalueBetween(Float value1, Float value2) {
            addCriterion("DocValue between", value1, value2, "docvalue");
            return (Criteria) this;
        }

        public Criteria andDocvalueNotBetween(Float value1, Float value2) {
            addCriterion("DocValue not between", value1, value2, "docvalue");
            return (Criteria) this;
        }

        public Criteria andDocdeldateIsNull() {
            addCriterion("DocDelDate is null");
            return (Criteria) this;
        }

        public Criteria andDocdeldateIsNotNull() {
            addCriterion("DocDelDate is not null");
            return (Criteria) this;
        }

        public Criteria andDocdeldateEqualTo(Integer value) {
            addCriterion("DocDelDate =", value, "docdeldate");
            return (Criteria) this;
        }

        public Criteria andDocdeldateNotEqualTo(Integer value) {
            addCriterion("DocDelDate <>", value, "docdeldate");
            return (Criteria) this;
        }

        public Criteria andDocdeldateGreaterThan(Integer value) {
            addCriterion("DocDelDate >", value, "docdeldate");
            return (Criteria) this;
        }

        public Criteria andDocdeldateGreaterThanOrEqualTo(Integer value) {
            addCriterion("DocDelDate >=", value, "docdeldate");
            return (Criteria) this;
        }

        public Criteria andDocdeldateLessThan(Integer value) {
            addCriterion("DocDelDate <", value, "docdeldate");
            return (Criteria) this;
        }

        public Criteria andDocdeldateLessThanOrEqualTo(Integer value) {
            addCriterion("DocDelDate <=", value, "docdeldate");
            return (Criteria) this;
        }

        public Criteria andDocdeldateIn(List<Integer> values) {
            addCriterion("DocDelDate in", values, "docdeldate");
            return (Criteria) this;
        }

        public Criteria andDocdeldateNotIn(List<Integer> values) {
            addCriterion("DocDelDate not in", values, "docdeldate");
            return (Criteria) this;
        }

        public Criteria andDocdeldateBetween(Integer value1, Integer value2) {
            addCriterion("DocDelDate between", value1, value2, "docdeldate");
            return (Criteria) this;
        }

        public Criteria andDocdeldateNotBetween(Integer value1, Integer value2) {
            addCriterion("DocDelDate not between", value1, value2, "docdeldate");
            return (Criteria) this;
        }

        public Criteria andDoccountIsNull() {
            addCriterion("DocCount is null");
            return (Criteria) this;
        }

        public Criteria andDoccountIsNotNull() {
            addCriterion("DocCount is not null");
            return (Criteria) this;
        }

        public Criteria andDoccountEqualTo(Short value) {
            addCriterion("DocCount =", value, "doccount");
            return (Criteria) this;
        }

        public Criteria andDoccountNotEqualTo(Short value) {
            addCriterion("DocCount <>", value, "doccount");
            return (Criteria) this;
        }

        public Criteria andDoccountGreaterThan(Short value) {
            addCriterion("DocCount >", value, "doccount");
            return (Criteria) this;
        }

        public Criteria andDoccountGreaterThanOrEqualTo(Short value) {
            addCriterion("DocCount >=", value, "doccount");
            return (Criteria) this;
        }

        public Criteria andDoccountLessThan(Short value) {
            addCriterion("DocCount <", value, "doccount");
            return (Criteria) this;
        }

        public Criteria andDoccountLessThanOrEqualTo(Short value) {
            addCriterion("DocCount <=", value, "doccount");
            return (Criteria) this;
        }

        public Criteria andDoccountIn(List<Short> values) {
            addCriterion("DocCount in", values, "doccount");
            return (Criteria) this;
        }

        public Criteria andDoccountNotIn(List<Short> values) {
            addCriterion("DocCount not in", values, "doccount");
            return (Criteria) this;
        }

        public Criteria andDoccountBetween(Short value1, Short value2) {
            addCriterion("DocCount between", value1, value2, "doccount");
            return (Criteria) this;
        }

        public Criteria andDoccountNotBetween(Short value1, Short value2) {
            addCriterion("DocCount not between", value1, value2, "doccount");
            return (Criteria) this;
        }

        public Criteria andSendflagIsNull() {
            addCriterion("sendFlag is null");
            return (Criteria) this;
        }

        public Criteria andSendflagIsNotNull() {
            addCriterion("sendFlag is not null");
            return (Criteria) this;
        }

        public Criteria andSendflagEqualTo(Byte value) {
            addCriterion("sendFlag =", value, "sendflag");
            return (Criteria) this;
        }

        public Criteria andSendflagNotEqualTo(Byte value) {
            addCriterion("sendFlag <>", value, "sendflag");
            return (Criteria) this;
        }

        public Criteria andSendflagGreaterThan(Byte value) {
            addCriterion("sendFlag >", value, "sendflag");
            return (Criteria) this;
        }

        public Criteria andSendflagGreaterThanOrEqualTo(Byte value) {
            addCriterion("sendFlag >=", value, "sendflag");
            return (Criteria) this;
        }

        public Criteria andSendflagLessThan(Byte value) {
            addCriterion("sendFlag <", value, "sendflag");
            return (Criteria) this;
        }

        public Criteria andSendflagLessThanOrEqualTo(Byte value) {
            addCriterion("sendFlag <=", value, "sendflag");
            return (Criteria) this;
        }

        public Criteria andSendflagIn(List<Byte> values) {
            addCriterion("sendFlag in", values, "sendflag");
            return (Criteria) this;
        }

        public Criteria andSendflagNotIn(List<Byte> values) {
            addCriterion("sendFlag not in", values, "sendflag");
            return (Criteria) this;
        }

        public Criteria andSendflagBetween(Byte value1, Byte value2) {
            addCriterion("sendFlag between", value1, value2, "sendflag");
            return (Criteria) this;
        }

        public Criteria andSendflagNotBetween(Byte value1, Byte value2) {
            addCriterion("sendFlag not between", value1, value2, "sendflag");
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