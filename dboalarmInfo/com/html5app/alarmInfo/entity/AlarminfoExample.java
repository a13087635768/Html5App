package com.html5app.alarmInfo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AlarminfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AlarminfoExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAlmpositionIsNull() {
            addCriterion("AlmPosition is null");
            return (Criteria) this;
        }

        public Criteria andAlmpositionIsNotNull() {
            addCriterion("AlmPosition is not null");
            return (Criteria) this;
        }

        public Criteria andAlmpositionEqualTo(String value) {
            addCriterion("AlmPosition =", value, "almposition");
            return (Criteria) this;
        }

        public Criteria andAlmpositionNotEqualTo(String value) {
            addCriterion("AlmPosition <>", value, "almposition");
            return (Criteria) this;
        }

        public Criteria andAlmpositionGreaterThan(String value) {
            addCriterion("AlmPosition >", value, "almposition");
            return (Criteria) this;
        }

        public Criteria andAlmpositionGreaterThanOrEqualTo(String value) {
            addCriterion("AlmPosition >=", value, "almposition");
            return (Criteria) this;
        }

        public Criteria andAlmpositionLessThan(String value) {
            addCriterion("AlmPosition <", value, "almposition");
            return (Criteria) this;
        }

        public Criteria andAlmpositionLessThanOrEqualTo(String value) {
            addCriterion("AlmPosition <=", value, "almposition");
            return (Criteria) this;
        }

        public Criteria andAlmpositionLike(String value) {
            addCriterion("AlmPosition like", value, "almposition");
            return (Criteria) this;
        }

        public Criteria andAlmpositionNotLike(String value) {
            addCriterion("AlmPosition not like", value, "almposition");
            return (Criteria) this;
        }

        public Criteria andAlmpositionIn(List<String> values) {
            addCriterion("AlmPosition in", values, "almposition");
            return (Criteria) this;
        }

        public Criteria andAlmpositionNotIn(List<String> values) {
            addCriterion("AlmPosition not in", values, "almposition");
            return (Criteria) this;
        }

        public Criteria andAlmpositionBetween(String value1, String value2) {
            addCriterion("AlmPosition between", value1, value2, "almposition");
            return (Criteria) this;
        }

        public Criteria andAlmpositionNotBetween(String value1, String value2) {
            addCriterion("AlmPosition not between", value1, value2, "almposition");
            return (Criteria) this;
        }

        public Criteria andAlmpointIsNull() {
            addCriterion("AlmPoint is null");
            return (Criteria) this;
        }

        public Criteria andAlmpointIsNotNull() {
            addCriterion("AlmPoint is not null");
            return (Criteria) this;
        }

        public Criteria andAlmpointEqualTo(String value) {
            addCriterion("AlmPoint =", value, "almpoint");
            return (Criteria) this;
        }

        public Criteria andAlmpointNotEqualTo(String value) {
            addCriterion("AlmPoint <>", value, "almpoint");
            return (Criteria) this;
        }

        public Criteria andAlmpointGreaterThan(String value) {
            addCriterion("AlmPoint >", value, "almpoint");
            return (Criteria) this;
        }

        public Criteria andAlmpointGreaterThanOrEqualTo(String value) {
            addCriterion("AlmPoint >=", value, "almpoint");
            return (Criteria) this;
        }

        public Criteria andAlmpointLessThan(String value) {
            addCriterion("AlmPoint <", value, "almpoint");
            return (Criteria) this;
        }

        public Criteria andAlmpointLessThanOrEqualTo(String value) {
            addCriterion("AlmPoint <=", value, "almpoint");
            return (Criteria) this;
        }

        public Criteria andAlmpointLike(String value) {
            addCriterion("AlmPoint like", value, "almpoint");
            return (Criteria) this;
        }

        public Criteria andAlmpointNotLike(String value) {
            addCriterion("AlmPoint not like", value, "almpoint");
            return (Criteria) this;
        }

        public Criteria andAlmpointIn(List<String> values) {
            addCriterion("AlmPoint in", values, "almpoint");
            return (Criteria) this;
        }

        public Criteria andAlmpointNotIn(List<String> values) {
            addCriterion("AlmPoint not in", values, "almpoint");
            return (Criteria) this;
        }

        public Criteria andAlmpointBetween(String value1, String value2) {
            addCriterion("AlmPoint between", value1, value2, "almpoint");
            return (Criteria) this;
        }

        public Criteria andAlmpointNotBetween(String value1, String value2) {
            addCriterion("AlmPoint not between", value1, value2, "almpoint");
            return (Criteria) this;
        }

        public Criteria andAlmtimeIsNull() {
            addCriterion("AlmTime is null");
            return (Criteria) this;
        }

        public Criteria andAlmtimeIsNotNull() {
            addCriterion("AlmTime is not null");
            return (Criteria) this;
        }

        public Criteria andAlmtimeEqualTo(Date value) {
            addCriterion("AlmTime =", value, "almtime");
            return (Criteria) this;
        }

        public Criteria andAlmtimeNotEqualTo(Date value) {
            addCriterion("AlmTime <>", value, "almtime");
            return (Criteria) this;
        }

        public Criteria andAlmtimeGreaterThan(Date value) {
            addCriterion("AlmTime >", value, "almtime");
            return (Criteria) this;
        }

        public Criteria andAlmtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("AlmTime >=", value, "almtime");
            return (Criteria) this;
        }

        public Criteria andAlmtimeLessThan(Date value) {
            addCriterion("AlmTime <", value, "almtime");
            return (Criteria) this;
        }

        public Criteria andAlmtimeLessThanOrEqualTo(Date value) {
            addCriterion("AlmTime <=", value, "almtime");
            return (Criteria) this;
        }

        public Criteria andAlmtimeIn(List<Date> values) {
            addCriterion("AlmTime in", values, "almtime");
            return (Criteria) this;
        }

        public Criteria andAlmtimeNotIn(List<Date> values) {
            addCriterion("AlmTime not in", values, "almtime");
            return (Criteria) this;
        }

        public Criteria andAlmtimeBetween(Date value1, Date value2) {
            addCriterion("AlmTime between", value1, value2, "almtime");
            return (Criteria) this;
        }

        public Criteria andAlmtimeNotBetween(Date value1, Date value2) {
            addCriterion("AlmTime not between", value1, value2, "almtime");
            return (Criteria) this;
        }

        public Criteria andAlminfoIsNull() {
            addCriterion("AlmInfo is null");
            return (Criteria) this;
        }

        public Criteria andAlminfoIsNotNull() {
            addCriterion("AlmInfo is not null");
            return (Criteria) this;
        }

        public Criteria andAlminfoEqualTo(String value) {
            addCriterion("AlmInfo =", value, "alminfo");
            return (Criteria) this;
        }

        public Criteria andAlminfoNotEqualTo(String value) {
            addCriterion("AlmInfo <>", value, "alminfo");
            return (Criteria) this;
        }

        public Criteria andAlminfoGreaterThan(String value) {
            addCriterion("AlmInfo >", value, "alminfo");
            return (Criteria) this;
        }

        public Criteria andAlminfoGreaterThanOrEqualTo(String value) {
            addCriterion("AlmInfo >=", value, "alminfo");
            return (Criteria) this;
        }

        public Criteria andAlminfoLessThan(String value) {
            addCriterion("AlmInfo <", value, "alminfo");
            return (Criteria) this;
        }

        public Criteria andAlminfoLessThanOrEqualTo(String value) {
            addCriterion("AlmInfo <=", value, "alminfo");
            return (Criteria) this;
        }

        public Criteria andAlminfoLike(String value) {
            addCriterion("AlmInfo like", value, "alminfo");
            return (Criteria) this;
        }

        public Criteria andAlminfoNotLike(String value) {
            addCriterion("AlmInfo not like", value, "alminfo");
            return (Criteria) this;
        }

        public Criteria andAlminfoIn(List<String> values) {
            addCriterion("AlmInfo in", values, "alminfo");
            return (Criteria) this;
        }

        public Criteria andAlminfoNotIn(List<String> values) {
            addCriterion("AlmInfo not in", values, "alminfo");
            return (Criteria) this;
        }

        public Criteria andAlminfoBetween(String value1, String value2) {
            addCriterion("AlmInfo between", value1, value2, "alminfo");
            return (Criteria) this;
        }

        public Criteria andAlminfoNotBetween(String value1, String value2) {
            addCriterion("AlmInfo not between", value1, value2, "alminfo");
            return (Criteria) this;
        }

        public Criteria andAlmstatusIsNull() {
            addCriterion("AlmStatus is null");
            return (Criteria) this;
        }

        public Criteria andAlmstatusIsNotNull() {
            addCriterion("AlmStatus is not null");
            return (Criteria) this;
        }

        public Criteria andAlmstatusEqualTo(Byte value) {
            addCriterion("AlmStatus =", value, "almstatus");
            return (Criteria) this;
        }

        public Criteria andAlmstatusNotEqualTo(Byte value) {
            addCriterion("AlmStatus <>", value, "almstatus");
            return (Criteria) this;
        }

        public Criteria andAlmstatusGreaterThan(Byte value) {
            addCriterion("AlmStatus >", value, "almstatus");
            return (Criteria) this;
        }

        public Criteria andAlmstatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("AlmStatus >=", value, "almstatus");
            return (Criteria) this;
        }

        public Criteria andAlmstatusLessThan(Byte value) {
            addCriterion("AlmStatus <", value, "almstatus");
            return (Criteria) this;
        }

        public Criteria andAlmstatusLessThanOrEqualTo(Byte value) {
            addCriterion("AlmStatus <=", value, "almstatus");
            return (Criteria) this;
        }

        public Criteria andAlmstatusIn(List<Byte> values) {
            addCriterion("AlmStatus in", values, "almstatus");
            return (Criteria) this;
        }

        public Criteria andAlmstatusNotIn(List<Byte> values) {
            addCriterion("AlmStatus not in", values, "almstatus");
            return (Criteria) this;
        }

        public Criteria andAlmstatusBetween(Byte value1, Byte value2) {
            addCriterion("AlmStatus between", value1, value2, "almstatus");
            return (Criteria) this;
        }

        public Criteria andAlmstatusNotBetween(Byte value1, Byte value2) {
            addCriterion("AlmStatus not between", value1, value2, "almstatus");
            return (Criteria) this;
        }

        public Criteria andAlmclassIsNull() {
            addCriterion("AlmClass is null");
            return (Criteria) this;
        }

        public Criteria andAlmclassIsNotNull() {
            addCriterion("AlmClass is not null");
            return (Criteria) this;
        }

        public Criteria andAlmclassEqualTo(Byte value) {
            addCriterion("AlmClass =", value, "almclass");
            return (Criteria) this;
        }

        public Criteria andAlmclassNotEqualTo(Byte value) {
            addCriterion("AlmClass <>", value, "almclass");
            return (Criteria) this;
        }

        public Criteria andAlmclassGreaterThan(Byte value) {
            addCriterion("AlmClass >", value, "almclass");
            return (Criteria) this;
        }

        public Criteria andAlmclassGreaterThanOrEqualTo(Byte value) {
            addCriterion("AlmClass >=", value, "almclass");
            return (Criteria) this;
        }

        public Criteria andAlmclassLessThan(Byte value) {
            addCriterion("AlmClass <", value, "almclass");
            return (Criteria) this;
        }

        public Criteria andAlmclassLessThanOrEqualTo(Byte value) {
            addCriterion("AlmClass <=", value, "almclass");
            return (Criteria) this;
        }

        public Criteria andAlmclassIn(List<Byte> values) {
            addCriterion("AlmClass in", values, "almclass");
            return (Criteria) this;
        }

        public Criteria andAlmclassNotIn(List<Byte> values) {
            addCriterion("AlmClass not in", values, "almclass");
            return (Criteria) this;
        }

        public Criteria andAlmclassBetween(Byte value1, Byte value2) {
            addCriterion("AlmClass between", value1, value2, "almclass");
            return (Criteria) this;
        }

        public Criteria andAlmclassNotBetween(Byte value1, Byte value2) {
            addCriterion("AlmClass not between", value1, value2, "almclass");
            return (Criteria) this;
        }

        public Criteria andAlmvalueIsNull() {
            addCriterion("AlmValue is null");
            return (Criteria) this;
        }

        public Criteria andAlmvalueIsNotNull() {
            addCriterion("AlmValue is not null");
            return (Criteria) this;
        }

        public Criteria andAlmvalueEqualTo(Float value) {
            addCriterion("AlmValue =", value, "almvalue");
            return (Criteria) this;
        }

        public Criteria andAlmvalueNotEqualTo(Float value) {
            addCriterion("AlmValue <>", value, "almvalue");
            return (Criteria) this;
        }

        public Criteria andAlmvalueGreaterThan(Float value) {
            addCriterion("AlmValue >", value, "almvalue");
            return (Criteria) this;
        }

        public Criteria andAlmvalueGreaterThanOrEqualTo(Float value) {
            addCriterion("AlmValue >=", value, "almvalue");
            return (Criteria) this;
        }

        public Criteria andAlmvalueLessThan(Float value) {
            addCriterion("AlmValue <", value, "almvalue");
            return (Criteria) this;
        }

        public Criteria andAlmvalueLessThanOrEqualTo(Float value) {
            addCriterion("AlmValue <=", value, "almvalue");
            return (Criteria) this;
        }

        public Criteria andAlmvalueIn(List<Float> values) {
            addCriterion("AlmValue in", values, "almvalue");
            return (Criteria) this;
        }

        public Criteria andAlmvalueNotIn(List<Float> values) {
            addCriterion("AlmValue not in", values, "almvalue");
            return (Criteria) this;
        }

        public Criteria andAlmvalueBetween(Float value1, Float value2) {
            addCriterion("AlmValue between", value1, value2, "almvalue");
            return (Criteria) this;
        }

        public Criteria andAlmvalueNotBetween(Float value1, Float value2) {
            addCriterion("AlmValue not between", value1, value2, "almvalue");
            return (Criteria) this;
        }

        public Criteria andAlmnoIsNull() {
            addCriterion("AlmNo is null");
            return (Criteria) this;
        }

        public Criteria andAlmnoIsNotNull() {
            addCriterion("AlmNo is not null");
            return (Criteria) this;
        }

        public Criteria andAlmnoEqualTo(Integer value) {
            addCriterion("AlmNo =", value, "almno");
            return (Criteria) this;
        }

        public Criteria andAlmnoNotEqualTo(Integer value) {
            addCriterion("AlmNo <>", value, "almno");
            return (Criteria) this;
        }

        public Criteria andAlmnoGreaterThan(Integer value) {
            addCriterion("AlmNo >", value, "almno");
            return (Criteria) this;
        }

        public Criteria andAlmnoGreaterThanOrEqualTo(Integer value) {
            addCriterion("AlmNo >=", value, "almno");
            return (Criteria) this;
        }

        public Criteria andAlmnoLessThan(Integer value) {
            addCriterion("AlmNo <", value, "almno");
            return (Criteria) this;
        }

        public Criteria andAlmnoLessThanOrEqualTo(Integer value) {
            addCriterion("AlmNo <=", value, "almno");
            return (Criteria) this;
        }

        public Criteria andAlmnoIn(List<Integer> values) {
            addCriterion("AlmNo in", values, "almno");
            return (Criteria) this;
        }

        public Criteria andAlmnoNotIn(List<Integer> values) {
            addCriterion("AlmNo not in", values, "almno");
            return (Criteria) this;
        }

        public Criteria andAlmnoBetween(Integer value1, Integer value2) {
            addCriterion("AlmNo between", value1, value2, "almno");
            return (Criteria) this;
        }

        public Criteria andAlmnoNotBetween(Integer value1, Integer value2) {
            addCriterion("AlmNo not between", value1, value2, "almno");
            return (Criteria) this;
        }

        public Criteria andAlmmonoIsNull() {
            addCriterion("AlmMono is null");
            return (Criteria) this;
        }

        public Criteria andAlmmonoIsNotNull() {
            addCriterion("AlmMono is not null");
            return (Criteria) this;
        }

        public Criteria andAlmmonoEqualTo(String value) {
            addCriterion("AlmMono =", value, "almmono");
            return (Criteria) this;
        }

        public Criteria andAlmmonoNotEqualTo(String value) {
            addCriterion("AlmMono <>", value, "almmono");
            return (Criteria) this;
        }

        public Criteria andAlmmonoGreaterThan(String value) {
            addCriterion("AlmMono >", value, "almmono");
            return (Criteria) this;
        }

        public Criteria andAlmmonoGreaterThanOrEqualTo(String value) {
            addCriterion("AlmMono >=", value, "almmono");
            return (Criteria) this;
        }

        public Criteria andAlmmonoLessThan(String value) {
            addCriterion("AlmMono <", value, "almmono");
            return (Criteria) this;
        }

        public Criteria andAlmmonoLessThanOrEqualTo(String value) {
            addCriterion("AlmMono <=", value, "almmono");
            return (Criteria) this;
        }

        public Criteria andAlmmonoLike(String value) {
            addCriterion("AlmMono like", value, "almmono");
            return (Criteria) this;
        }

        public Criteria andAlmmonoNotLike(String value) {
            addCriterion("AlmMono not like", value, "almmono");
            return (Criteria) this;
        }

        public Criteria andAlmmonoIn(List<String> values) {
            addCriterion("AlmMono in", values, "almmono");
            return (Criteria) this;
        }

        public Criteria andAlmmonoNotIn(List<String> values) {
            addCriterion("AlmMono not in", values, "almmono");
            return (Criteria) this;
        }

        public Criteria andAlmmonoBetween(String value1, String value2) {
            addCriterion("AlmMono between", value1, value2, "almmono");
            return (Criteria) this;
        }

        public Criteria andAlmmonoNotBetween(String value1, String value2) {
            addCriterion("AlmMono not between", value1, value2, "almmono");
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