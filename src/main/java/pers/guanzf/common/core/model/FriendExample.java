package pers.guanzf.common.core.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FriendExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table g_friend
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table g_friend
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table g_friend
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table g_friend
     *
     * @mbg.generated
     */
    public FriendExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table g_friend
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table g_friend
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table g_friend
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table g_friend
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table g_friend
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table g_friend
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table g_friend
     *
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table g_friend
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table g_friend
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table g_friend
     *
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table g_friend
     *
     * @mbg.generated
     */
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

        public Criteria andFriendIdIsNull() {
            addCriterion("FRIEND_ID is null");
            return (Criteria) this;
        }

        public Criteria andFriendIdIsNotNull() {
            addCriterion("FRIEND_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFriendIdEqualTo(String value) {
            addCriterion("FRIEND_ID =", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdNotEqualTo(String value) {
            addCriterion("FRIEND_ID <>", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdGreaterThan(String value) {
            addCriterion("FRIEND_ID >", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdGreaterThanOrEqualTo(String value) {
            addCriterion("FRIEND_ID >=", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdLessThan(String value) {
            addCriterion("FRIEND_ID <", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdLessThanOrEqualTo(String value) {
            addCriterion("FRIEND_ID <=", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdLike(String value) {
            addCriterion("FRIEND_ID like", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdNotLike(String value) {
            addCriterion("FRIEND_ID not like", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdIn(List<String> values) {
            addCriterion("FRIEND_ID in", values, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdNotIn(List<String> values) {
            addCriterion("FRIEND_ID not in", values, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdBetween(String value1, String value2) {
            addCriterion("FRIEND_ID between", value1, value2, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdNotBetween(String value1, String value2) {
            addCriterion("FRIEND_ID not between", value1, value2, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendMyIdIsNull() {
            addCriterion("FRIEND_MY_ID is null");
            return (Criteria) this;
        }

        public Criteria andFriendMyIdIsNotNull() {
            addCriterion("FRIEND_MY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFriendMyIdEqualTo(String value) {
            addCriterion("FRIEND_MY_ID =", value, "friendMyId");
            return (Criteria) this;
        }

        public Criteria andFriendMyIdNotEqualTo(String value) {
            addCriterion("FRIEND_MY_ID <>", value, "friendMyId");
            return (Criteria) this;
        }

        public Criteria andFriendMyIdGreaterThan(String value) {
            addCriterion("FRIEND_MY_ID >", value, "friendMyId");
            return (Criteria) this;
        }

        public Criteria andFriendMyIdGreaterThanOrEqualTo(String value) {
            addCriterion("FRIEND_MY_ID >=", value, "friendMyId");
            return (Criteria) this;
        }

        public Criteria andFriendMyIdLessThan(String value) {
            addCriterion("FRIEND_MY_ID <", value, "friendMyId");
            return (Criteria) this;
        }

        public Criteria andFriendMyIdLessThanOrEqualTo(String value) {
            addCriterion("FRIEND_MY_ID <=", value, "friendMyId");
            return (Criteria) this;
        }

        public Criteria andFriendMyIdLike(String value) {
            addCriterion("FRIEND_MY_ID like", value, "friendMyId");
            return (Criteria) this;
        }

        public Criteria andFriendMyIdNotLike(String value) {
            addCriterion("FRIEND_MY_ID not like", value, "friendMyId");
            return (Criteria) this;
        }

        public Criteria andFriendMyIdIn(List<String> values) {
            addCriterion("FRIEND_MY_ID in", values, "friendMyId");
            return (Criteria) this;
        }

        public Criteria andFriendMyIdNotIn(List<String> values) {
            addCriterion("FRIEND_MY_ID not in", values, "friendMyId");
            return (Criteria) this;
        }

        public Criteria andFriendMyIdBetween(String value1, String value2) {
            addCriterion("FRIEND_MY_ID between", value1, value2, "friendMyId");
            return (Criteria) this;
        }

        public Criteria andFriendMyIdNotBetween(String value1, String value2) {
            addCriterion("FRIEND_MY_ID not between", value1, value2, "friendMyId");
            return (Criteria) this;
        }

        public Criteria andFriendFriendIdIsNull() {
            addCriterion("FRIEND_FRIEND_ID is null");
            return (Criteria) this;
        }

        public Criteria andFriendFriendIdIsNotNull() {
            addCriterion("FRIEND_FRIEND_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFriendFriendIdEqualTo(String value) {
            addCriterion("FRIEND_FRIEND_ID =", value, "friendFriendId");
            return (Criteria) this;
        }

        public Criteria andFriendFriendIdNotEqualTo(String value) {
            addCriterion("FRIEND_FRIEND_ID <>", value, "friendFriendId");
            return (Criteria) this;
        }

        public Criteria andFriendFriendIdGreaterThan(String value) {
            addCriterion("FRIEND_FRIEND_ID >", value, "friendFriendId");
            return (Criteria) this;
        }

        public Criteria andFriendFriendIdGreaterThanOrEqualTo(String value) {
            addCriterion("FRIEND_FRIEND_ID >=", value, "friendFriendId");
            return (Criteria) this;
        }

        public Criteria andFriendFriendIdLessThan(String value) {
            addCriterion("FRIEND_FRIEND_ID <", value, "friendFriendId");
            return (Criteria) this;
        }

        public Criteria andFriendFriendIdLessThanOrEqualTo(String value) {
            addCriterion("FRIEND_FRIEND_ID <=", value, "friendFriendId");
            return (Criteria) this;
        }

        public Criteria andFriendFriendIdLike(String value) {
            addCriterion("FRIEND_FRIEND_ID like", value, "friendFriendId");
            return (Criteria) this;
        }

        public Criteria andFriendFriendIdNotLike(String value) {
            addCriterion("FRIEND_FRIEND_ID not like", value, "friendFriendId");
            return (Criteria) this;
        }

        public Criteria andFriendFriendIdIn(List<String> values) {
            addCriterion("FRIEND_FRIEND_ID in", values, "friendFriendId");
            return (Criteria) this;
        }

        public Criteria andFriendFriendIdNotIn(List<String> values) {
            addCriterion("FRIEND_FRIEND_ID not in", values, "friendFriendId");
            return (Criteria) this;
        }

        public Criteria andFriendFriendIdBetween(String value1, String value2) {
            addCriterion("FRIEND_FRIEND_ID between", value1, value2, "friendFriendId");
            return (Criteria) this;
        }

        public Criteria andFriendFriendIdNotBetween(String value1, String value2) {
            addCriterion("FRIEND_FRIEND_ID not between", value1, value2, "friendFriendId");
            return (Criteria) this;
        }

        public Criteria andFriendSimilarityDegreeIsNull() {
            addCriterion("FRIEND_SIMILARITY_DEGREE is null");
            return (Criteria) this;
        }

        public Criteria andFriendSimilarityDegreeIsNotNull() {
            addCriterion("FRIEND_SIMILARITY_DEGREE is not null");
            return (Criteria) this;
        }

        public Criteria andFriendSimilarityDegreeEqualTo(Float value) {
            addCriterion("FRIEND_SIMILARITY_DEGREE =", value, "friendSimilarityDegree");
            return (Criteria) this;
        }

        public Criteria andFriendSimilarityDegreeNotEqualTo(Float value) {
            addCriterion("FRIEND_SIMILARITY_DEGREE <>", value, "friendSimilarityDegree");
            return (Criteria) this;
        }

        public Criteria andFriendSimilarityDegreeGreaterThan(Float value) {
            addCriterion("FRIEND_SIMILARITY_DEGREE >", value, "friendSimilarityDegree");
            return (Criteria) this;
        }

        public Criteria andFriendSimilarityDegreeGreaterThanOrEqualTo(Float value) {
            addCriterion("FRIEND_SIMILARITY_DEGREE >=", value, "friendSimilarityDegree");
            return (Criteria) this;
        }

        public Criteria andFriendSimilarityDegreeLessThan(Float value) {
            addCriterion("FRIEND_SIMILARITY_DEGREE <", value, "friendSimilarityDegree");
            return (Criteria) this;
        }

        public Criteria andFriendSimilarityDegreeLessThanOrEqualTo(Float value) {
            addCriterion("FRIEND_SIMILARITY_DEGREE <=", value, "friendSimilarityDegree");
            return (Criteria) this;
        }

        public Criteria andFriendSimilarityDegreeIn(List<Float> values) {
            addCriterion("FRIEND_SIMILARITY_DEGREE in", values, "friendSimilarityDegree");
            return (Criteria) this;
        }

        public Criteria andFriendSimilarityDegreeNotIn(List<Float> values) {
            addCriterion("FRIEND_SIMILARITY_DEGREE not in", values, "friendSimilarityDegree");
            return (Criteria) this;
        }

        public Criteria andFriendSimilarityDegreeBetween(Float value1, Float value2) {
            addCriterion("FRIEND_SIMILARITY_DEGREE between", value1, value2, "friendSimilarityDegree");
            return (Criteria) this;
        }

        public Criteria andFriendSimilarityDegreeNotBetween(Float value1, Float value2) {
            addCriterion("FRIEND_SIMILARITY_DEGREE not between", value1, value2, "friendSimilarityDegree");
            return (Criteria) this;
        }

        public Criteria andFriendCreateTimeIsNull() {
            addCriterion("FRIEND_CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andFriendCreateTimeIsNotNull() {
            addCriterion("FRIEND_CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andFriendCreateTimeEqualTo(Date value) {
            addCriterion("FRIEND_CREATE_TIME =", value, "friendCreateTime");
            return (Criteria) this;
        }

        public Criteria andFriendCreateTimeNotEqualTo(Date value) {
            addCriterion("FRIEND_CREATE_TIME <>", value, "friendCreateTime");
            return (Criteria) this;
        }

        public Criteria andFriendCreateTimeGreaterThan(Date value) {
            addCriterion("FRIEND_CREATE_TIME >", value, "friendCreateTime");
            return (Criteria) this;
        }

        public Criteria andFriendCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("FRIEND_CREATE_TIME >=", value, "friendCreateTime");
            return (Criteria) this;
        }

        public Criteria andFriendCreateTimeLessThan(Date value) {
            addCriterion("FRIEND_CREATE_TIME <", value, "friendCreateTime");
            return (Criteria) this;
        }

        public Criteria andFriendCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("FRIEND_CREATE_TIME <=", value, "friendCreateTime");
            return (Criteria) this;
        }

        public Criteria andFriendCreateTimeIn(List<Date> values) {
            addCriterion("FRIEND_CREATE_TIME in", values, "friendCreateTime");
            return (Criteria) this;
        }

        public Criteria andFriendCreateTimeNotIn(List<Date> values) {
            addCriterion("FRIEND_CREATE_TIME not in", values, "friendCreateTime");
            return (Criteria) this;
        }

        public Criteria andFriendCreateTimeBetween(Date value1, Date value2) {
            addCriterion("FRIEND_CREATE_TIME between", value1, value2, "friendCreateTime");
            return (Criteria) this;
        }

        public Criteria andFriendCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("FRIEND_CREATE_TIME not between", value1, value2, "friendCreateTime");
            return (Criteria) this;
        }

        public Criteria andFriendDisableIsNull() {
            addCriterion("FRIEND_DISABLE is null");
            return (Criteria) this;
        }

        public Criteria andFriendDisableIsNotNull() {
            addCriterion("FRIEND_DISABLE is not null");
            return (Criteria) this;
        }

        public Criteria andFriendDisableEqualTo(String value) {
            addCriterion("FRIEND_DISABLE =", value, "friendDisable");
            return (Criteria) this;
        }

        public Criteria andFriendDisableNotEqualTo(String value) {
            addCriterion("FRIEND_DISABLE <>", value, "friendDisable");
            return (Criteria) this;
        }

        public Criteria andFriendDisableGreaterThan(String value) {
            addCriterion("FRIEND_DISABLE >", value, "friendDisable");
            return (Criteria) this;
        }

        public Criteria andFriendDisableGreaterThanOrEqualTo(String value) {
            addCriterion("FRIEND_DISABLE >=", value, "friendDisable");
            return (Criteria) this;
        }

        public Criteria andFriendDisableLessThan(String value) {
            addCriterion("FRIEND_DISABLE <", value, "friendDisable");
            return (Criteria) this;
        }

        public Criteria andFriendDisableLessThanOrEqualTo(String value) {
            addCriterion("FRIEND_DISABLE <=", value, "friendDisable");
            return (Criteria) this;
        }

        public Criteria andFriendDisableLike(String value) {
            addCriterion("FRIEND_DISABLE like", value, "friendDisable");
            return (Criteria) this;
        }

        public Criteria andFriendDisableNotLike(String value) {
            addCriterion("FRIEND_DISABLE not like", value, "friendDisable");
            return (Criteria) this;
        }

        public Criteria andFriendDisableIn(List<String> values) {
            addCriterion("FRIEND_DISABLE in", values, "friendDisable");
            return (Criteria) this;
        }

        public Criteria andFriendDisableNotIn(List<String> values) {
            addCriterion("FRIEND_DISABLE not in", values, "friendDisable");
            return (Criteria) this;
        }

        public Criteria andFriendDisableBetween(String value1, String value2) {
            addCriterion("FRIEND_DISABLE between", value1, value2, "friendDisable");
            return (Criteria) this;
        }

        public Criteria andFriendDisableNotBetween(String value1, String value2) {
            addCriterion("FRIEND_DISABLE not between", value1, value2, "friendDisable");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table g_friend
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table g_friend
     *
     * @mbg.generated
     */
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