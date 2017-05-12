package pers.guanzf.common.core.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProduceExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table g_produce
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table g_produce
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table g_produce
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table g_produce
     *
     * @mbg.generated
     */
    public ProduceExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table g_produce
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table g_produce
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table g_produce
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table g_produce
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table g_produce
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table g_produce
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table g_produce
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
     * This method corresponds to the database table g_produce
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
     * This method corresponds to the database table g_produce
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table g_produce
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
     * This class corresponds to the database table g_produce
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

        public Criteria andProduceIdIsNull() {
            addCriterion("PRODUCE_ID is null");
            return (Criteria) this;
        }

        public Criteria andProduceIdIsNotNull() {
            addCriterion("PRODUCE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProduceIdEqualTo(String value) {
            addCriterion("PRODUCE_ID =", value, "produceId");
            return (Criteria) this;
        }

        public Criteria andProduceIdNotEqualTo(String value) {
            addCriterion("PRODUCE_ID <>", value, "produceId");
            return (Criteria) this;
        }

        public Criteria andProduceIdGreaterThan(String value) {
            addCriterion("PRODUCE_ID >", value, "produceId");
            return (Criteria) this;
        }

        public Criteria andProduceIdGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCE_ID >=", value, "produceId");
            return (Criteria) this;
        }

        public Criteria andProduceIdLessThan(String value) {
            addCriterion("PRODUCE_ID <", value, "produceId");
            return (Criteria) this;
        }

        public Criteria andProduceIdLessThanOrEqualTo(String value) {
            addCriterion("PRODUCE_ID <=", value, "produceId");
            return (Criteria) this;
        }

        public Criteria andProduceIdLike(String value) {
            addCriterion("PRODUCE_ID like", value, "produceId");
            return (Criteria) this;
        }

        public Criteria andProduceIdNotLike(String value) {
            addCriterion("PRODUCE_ID not like", value, "produceId");
            return (Criteria) this;
        }

        public Criteria andProduceIdIn(List<String> values) {
            addCriterion("PRODUCE_ID in", values, "produceId");
            return (Criteria) this;
        }

        public Criteria andProduceIdNotIn(List<String> values) {
            addCriterion("PRODUCE_ID not in", values, "produceId");
            return (Criteria) this;
        }

        public Criteria andProduceIdBetween(String value1, String value2) {
            addCriterion("PRODUCE_ID between", value1, value2, "produceId");
            return (Criteria) this;
        }

        public Criteria andProduceIdNotBetween(String value1, String value2) {
            addCriterion("PRODUCE_ID not between", value1, value2, "produceId");
            return (Criteria) this;
        }

        public Criteria andProduceNameIsNull() {
            addCriterion("PRODUCE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andProduceNameIsNotNull() {
            addCriterion("PRODUCE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andProduceNameEqualTo(String value) {
            addCriterion("PRODUCE_NAME =", value, "produceName");
            return (Criteria) this;
        }

        public Criteria andProduceNameNotEqualTo(String value) {
            addCriterion("PRODUCE_NAME <>", value, "produceName");
            return (Criteria) this;
        }

        public Criteria andProduceNameGreaterThan(String value) {
            addCriterion("PRODUCE_NAME >", value, "produceName");
            return (Criteria) this;
        }

        public Criteria andProduceNameGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCE_NAME >=", value, "produceName");
            return (Criteria) this;
        }

        public Criteria andProduceNameLessThan(String value) {
            addCriterion("PRODUCE_NAME <", value, "produceName");
            return (Criteria) this;
        }

        public Criteria andProduceNameLessThanOrEqualTo(String value) {
            addCriterion("PRODUCE_NAME <=", value, "produceName");
            return (Criteria) this;
        }

        public Criteria andProduceNameLike(String value) {
            addCriterion("PRODUCE_NAME like", value, "produceName");
            return (Criteria) this;
        }

        public Criteria andProduceNameNotLike(String value) {
            addCriterion("PRODUCE_NAME not like", value, "produceName");
            return (Criteria) this;
        }

        public Criteria andProduceNameIn(List<String> values) {
            addCriterion("PRODUCE_NAME in", values, "produceName");
            return (Criteria) this;
        }

        public Criteria andProduceNameNotIn(List<String> values) {
            addCriterion("PRODUCE_NAME not in", values, "produceName");
            return (Criteria) this;
        }

        public Criteria andProduceNameBetween(String value1, String value2) {
            addCriterion("PRODUCE_NAME between", value1, value2, "produceName");
            return (Criteria) this;
        }

        public Criteria andProduceNameNotBetween(String value1, String value2) {
            addCriterion("PRODUCE_NAME not between", value1, value2, "produceName");
            return (Criteria) this;
        }

        public Criteria andProduceTypeIsNull() {
            addCriterion("PRODUCE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andProduceTypeIsNotNull() {
            addCriterion("PRODUCE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andProduceTypeEqualTo(String value) {
            addCriterion("PRODUCE_TYPE =", value, "produceType");
            return (Criteria) this;
        }

        public Criteria andProduceTypeNotEqualTo(String value) {
            addCriterion("PRODUCE_TYPE <>", value, "produceType");
            return (Criteria) this;
        }

        public Criteria andProduceTypeGreaterThan(String value) {
            addCriterion("PRODUCE_TYPE >", value, "produceType");
            return (Criteria) this;
        }

        public Criteria andProduceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCE_TYPE >=", value, "produceType");
            return (Criteria) this;
        }

        public Criteria andProduceTypeLessThan(String value) {
            addCriterion("PRODUCE_TYPE <", value, "produceType");
            return (Criteria) this;
        }

        public Criteria andProduceTypeLessThanOrEqualTo(String value) {
            addCriterion("PRODUCE_TYPE <=", value, "produceType");
            return (Criteria) this;
        }

        public Criteria andProduceTypeLike(String value) {
            addCriterion("PRODUCE_TYPE like", value, "produceType");
            return (Criteria) this;
        }

        public Criteria andProduceTypeNotLike(String value) {
            addCriterion("PRODUCE_TYPE not like", value, "produceType");
            return (Criteria) this;
        }

        public Criteria andProduceTypeIn(List<String> values) {
            addCriterion("PRODUCE_TYPE in", values, "produceType");
            return (Criteria) this;
        }

        public Criteria andProduceTypeNotIn(List<String> values) {
            addCriterion("PRODUCE_TYPE not in", values, "produceType");
            return (Criteria) this;
        }

        public Criteria andProduceTypeBetween(String value1, String value2) {
            addCriterion("PRODUCE_TYPE between", value1, value2, "produceType");
            return (Criteria) this;
        }

        public Criteria andProduceTypeNotBetween(String value1, String value2) {
            addCriterion("PRODUCE_TYPE not between", value1, value2, "produceType");
            return (Criteria) this;
        }

        public Criteria andProducePriceIsNull() {
            addCriterion("PRODUCE_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andProducePriceIsNotNull() {
            addCriterion("PRODUCE_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andProducePriceEqualTo(Float value) {
            addCriterion("PRODUCE_PRICE =", value, "producePrice");
            return (Criteria) this;
        }

        public Criteria andProducePriceNotEqualTo(Float value) {
            addCriterion("PRODUCE_PRICE <>", value, "producePrice");
            return (Criteria) this;
        }

        public Criteria andProducePriceGreaterThan(Float value) {
            addCriterion("PRODUCE_PRICE >", value, "producePrice");
            return (Criteria) this;
        }

        public Criteria andProducePriceGreaterThanOrEqualTo(Float value) {
            addCriterion("PRODUCE_PRICE >=", value, "producePrice");
            return (Criteria) this;
        }

        public Criteria andProducePriceLessThan(Float value) {
            addCriterion("PRODUCE_PRICE <", value, "producePrice");
            return (Criteria) this;
        }

        public Criteria andProducePriceLessThanOrEqualTo(Float value) {
            addCriterion("PRODUCE_PRICE <=", value, "producePrice");
            return (Criteria) this;
        }

        public Criteria andProducePriceIn(List<Float> values) {
            addCriterion("PRODUCE_PRICE in", values, "producePrice");
            return (Criteria) this;
        }

        public Criteria andProducePriceNotIn(List<Float> values) {
            addCriterion("PRODUCE_PRICE not in", values, "producePrice");
            return (Criteria) this;
        }

        public Criteria andProducePriceBetween(Float value1, Float value2) {
            addCriterion("PRODUCE_PRICE between", value1, value2, "producePrice");
            return (Criteria) this;
        }

        public Criteria andProducePriceNotBetween(Float value1, Float value2) {
            addCriterion("PRODUCE_PRICE not between", value1, value2, "producePrice");
            return (Criteria) this;
        }

        public Criteria andProducePurchaseTimesIsNull() {
            addCriterion("PRODUCE_PURCHASE_TIMES is null");
            return (Criteria) this;
        }

        public Criteria andProducePurchaseTimesIsNotNull() {
            addCriterion("PRODUCE_PURCHASE_TIMES is not null");
            return (Criteria) this;
        }

        public Criteria andProducePurchaseTimesEqualTo(Integer value) {
            addCriterion("PRODUCE_PURCHASE_TIMES =", value, "producePurchaseTimes");
            return (Criteria) this;
        }

        public Criteria andProducePurchaseTimesNotEqualTo(Integer value) {
            addCriterion("PRODUCE_PURCHASE_TIMES <>", value, "producePurchaseTimes");
            return (Criteria) this;
        }

        public Criteria andProducePurchaseTimesGreaterThan(Integer value) {
            addCriterion("PRODUCE_PURCHASE_TIMES >", value, "producePurchaseTimes");
            return (Criteria) this;
        }

        public Criteria andProducePurchaseTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("PRODUCE_PURCHASE_TIMES >=", value, "producePurchaseTimes");
            return (Criteria) this;
        }

        public Criteria andProducePurchaseTimesLessThan(Integer value) {
            addCriterion("PRODUCE_PURCHASE_TIMES <", value, "producePurchaseTimes");
            return (Criteria) this;
        }

        public Criteria andProducePurchaseTimesLessThanOrEqualTo(Integer value) {
            addCriterion("PRODUCE_PURCHASE_TIMES <=", value, "producePurchaseTimes");
            return (Criteria) this;
        }

        public Criteria andProducePurchaseTimesIn(List<Integer> values) {
            addCriterion("PRODUCE_PURCHASE_TIMES in", values, "producePurchaseTimes");
            return (Criteria) this;
        }

        public Criteria andProducePurchaseTimesNotIn(List<Integer> values) {
            addCriterion("PRODUCE_PURCHASE_TIMES not in", values, "producePurchaseTimes");
            return (Criteria) this;
        }

        public Criteria andProducePurchaseTimesBetween(Integer value1, Integer value2) {
            addCriterion("PRODUCE_PURCHASE_TIMES between", value1, value2, "producePurchaseTimes");
            return (Criteria) this;
        }

        public Criteria andProducePurchaseTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("PRODUCE_PURCHASE_TIMES not between", value1, value2, "producePurchaseTimes");
            return (Criteria) this;
        }

        public Criteria andProduceWeightIsNull() {
            addCriterion("PRODUCE_WEIGHT is null");
            return (Criteria) this;
        }

        public Criteria andProduceWeightIsNotNull() {
            addCriterion("PRODUCE_WEIGHT is not null");
            return (Criteria) this;
        }

        public Criteria andProduceWeightEqualTo(Float value) {
            addCriterion("PRODUCE_WEIGHT =", value, "produceWeight");
            return (Criteria) this;
        }

        public Criteria andProduceWeightNotEqualTo(Float value) {
            addCriterion("PRODUCE_WEIGHT <>", value, "produceWeight");
            return (Criteria) this;
        }

        public Criteria andProduceWeightGreaterThan(Float value) {
            addCriterion("PRODUCE_WEIGHT >", value, "produceWeight");
            return (Criteria) this;
        }

        public Criteria andProduceWeightGreaterThanOrEqualTo(Float value) {
            addCriterion("PRODUCE_WEIGHT >=", value, "produceWeight");
            return (Criteria) this;
        }

        public Criteria andProduceWeightLessThan(Float value) {
            addCriterion("PRODUCE_WEIGHT <", value, "produceWeight");
            return (Criteria) this;
        }

        public Criteria andProduceWeightLessThanOrEqualTo(Float value) {
            addCriterion("PRODUCE_WEIGHT <=", value, "produceWeight");
            return (Criteria) this;
        }

        public Criteria andProduceWeightIn(List<Float> values) {
            addCriterion("PRODUCE_WEIGHT in", values, "produceWeight");
            return (Criteria) this;
        }

        public Criteria andProduceWeightNotIn(List<Float> values) {
            addCriterion("PRODUCE_WEIGHT not in", values, "produceWeight");
            return (Criteria) this;
        }

        public Criteria andProduceWeightBetween(Float value1, Float value2) {
            addCriterion("PRODUCE_WEIGHT between", value1, value2, "produceWeight");
            return (Criteria) this;
        }

        public Criteria andProduceWeightNotBetween(Float value1, Float value2) {
            addCriterion("PRODUCE_WEIGHT not between", value1, value2, "produceWeight");
            return (Criteria) this;
        }

        public Criteria andProduceImageUrlIsNull() {
            addCriterion("PRODUCE_IMAGE_URL is null");
            return (Criteria) this;
        }

        public Criteria andProduceImageUrlIsNotNull() {
            addCriterion("PRODUCE_IMAGE_URL is not null");
            return (Criteria) this;
        }

        public Criteria andProduceImageUrlEqualTo(String value) {
            addCriterion("PRODUCE_IMAGE_URL =", value, "produceImageUrl");
            return (Criteria) this;
        }

        public Criteria andProduceImageUrlNotEqualTo(String value) {
            addCriterion("PRODUCE_IMAGE_URL <>", value, "produceImageUrl");
            return (Criteria) this;
        }

        public Criteria andProduceImageUrlGreaterThan(String value) {
            addCriterion("PRODUCE_IMAGE_URL >", value, "produceImageUrl");
            return (Criteria) this;
        }

        public Criteria andProduceImageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCE_IMAGE_URL >=", value, "produceImageUrl");
            return (Criteria) this;
        }

        public Criteria andProduceImageUrlLessThan(String value) {
            addCriterion("PRODUCE_IMAGE_URL <", value, "produceImageUrl");
            return (Criteria) this;
        }

        public Criteria andProduceImageUrlLessThanOrEqualTo(String value) {
            addCriterion("PRODUCE_IMAGE_URL <=", value, "produceImageUrl");
            return (Criteria) this;
        }

        public Criteria andProduceImageUrlLike(String value) {
            addCriterion("PRODUCE_IMAGE_URL like", value, "produceImageUrl");
            return (Criteria) this;
        }

        public Criteria andProduceImageUrlNotLike(String value) {
            addCriterion("PRODUCE_IMAGE_URL not like", value, "produceImageUrl");
            return (Criteria) this;
        }

        public Criteria andProduceImageUrlIn(List<String> values) {
            addCriterion("PRODUCE_IMAGE_URL in", values, "produceImageUrl");
            return (Criteria) this;
        }

        public Criteria andProduceImageUrlNotIn(List<String> values) {
            addCriterion("PRODUCE_IMAGE_URL not in", values, "produceImageUrl");
            return (Criteria) this;
        }

        public Criteria andProduceImageUrlBetween(String value1, String value2) {
            addCriterion("PRODUCE_IMAGE_URL between", value1, value2, "produceImageUrl");
            return (Criteria) this;
        }

        public Criteria andProduceImageUrlNotBetween(String value1, String value2) {
            addCriterion("PRODUCE_IMAGE_URL not between", value1, value2, "produceImageUrl");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("CREATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("CREATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("CREATE_DATE =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("CREATE_DATE <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("CREATE_DATE >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("CREATE_DATE <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("CREATE_DATE in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("CREATE_DATE not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andProducePraiseNumIsNull() {
            addCriterion("PRODUCE_PRAISE_NUM is null");
            return (Criteria) this;
        }

        public Criteria andProducePraiseNumIsNotNull() {
            addCriterion("PRODUCE_PRAISE_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andProducePraiseNumEqualTo(Integer value) {
            addCriterion("PRODUCE_PRAISE_NUM =", value, "producePraiseNum");
            return (Criteria) this;
        }

        public Criteria andProducePraiseNumNotEqualTo(Integer value) {
            addCriterion("PRODUCE_PRAISE_NUM <>", value, "producePraiseNum");
            return (Criteria) this;
        }

        public Criteria andProducePraiseNumGreaterThan(Integer value) {
            addCriterion("PRODUCE_PRAISE_NUM >", value, "producePraiseNum");
            return (Criteria) this;
        }

        public Criteria andProducePraiseNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("PRODUCE_PRAISE_NUM >=", value, "producePraiseNum");
            return (Criteria) this;
        }

        public Criteria andProducePraiseNumLessThan(Integer value) {
            addCriterion("PRODUCE_PRAISE_NUM <", value, "producePraiseNum");
            return (Criteria) this;
        }

        public Criteria andProducePraiseNumLessThanOrEqualTo(Integer value) {
            addCriterion("PRODUCE_PRAISE_NUM <=", value, "producePraiseNum");
            return (Criteria) this;
        }

        public Criteria andProducePraiseNumIn(List<Integer> values) {
            addCriterion("PRODUCE_PRAISE_NUM in", values, "producePraiseNum");
            return (Criteria) this;
        }

        public Criteria andProducePraiseNumNotIn(List<Integer> values) {
            addCriterion("PRODUCE_PRAISE_NUM not in", values, "producePraiseNum");
            return (Criteria) this;
        }

        public Criteria andProducePraiseNumBetween(Integer value1, Integer value2) {
            addCriterion("PRODUCE_PRAISE_NUM between", value1, value2, "producePraiseNum");
            return (Criteria) this;
        }

        public Criteria andProducePraiseNumNotBetween(Integer value1, Integer value2) {
            addCriterion("PRODUCE_PRAISE_NUM not between", value1, value2, "producePraiseNum");
            return (Criteria) this;
        }

        public Criteria andProduceBadNumIsNull() {
            addCriterion("PRODUCE_BAD_NUM is null");
            return (Criteria) this;
        }

        public Criteria andProduceBadNumIsNotNull() {
            addCriterion("PRODUCE_BAD_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andProduceBadNumEqualTo(Integer value) {
            addCriterion("PRODUCE_BAD_NUM =", value, "produceBadNum");
            return (Criteria) this;
        }

        public Criteria andProduceBadNumNotEqualTo(Integer value) {
            addCriterion("PRODUCE_BAD_NUM <>", value, "produceBadNum");
            return (Criteria) this;
        }

        public Criteria andProduceBadNumGreaterThan(Integer value) {
            addCriterion("PRODUCE_BAD_NUM >", value, "produceBadNum");
            return (Criteria) this;
        }

        public Criteria andProduceBadNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("PRODUCE_BAD_NUM >=", value, "produceBadNum");
            return (Criteria) this;
        }

        public Criteria andProduceBadNumLessThan(Integer value) {
            addCriterion("PRODUCE_BAD_NUM <", value, "produceBadNum");
            return (Criteria) this;
        }

        public Criteria andProduceBadNumLessThanOrEqualTo(Integer value) {
            addCriterion("PRODUCE_BAD_NUM <=", value, "produceBadNum");
            return (Criteria) this;
        }

        public Criteria andProduceBadNumIn(List<Integer> values) {
            addCriterion("PRODUCE_BAD_NUM in", values, "produceBadNum");
            return (Criteria) this;
        }

        public Criteria andProduceBadNumNotIn(List<Integer> values) {
            addCriterion("PRODUCE_BAD_NUM not in", values, "produceBadNum");
            return (Criteria) this;
        }

        public Criteria andProduceBadNumBetween(Integer value1, Integer value2) {
            addCriterion("PRODUCE_BAD_NUM between", value1, value2, "produceBadNum");
            return (Criteria) this;
        }

        public Criteria andProduceBadNumNotBetween(Integer value1, Integer value2) {
            addCriterion("PRODUCE_BAD_NUM not between", value1, value2, "produceBadNum");
            return (Criteria) this;
        }

        public Criteria andProduceSellNumIsNull() {
            addCriterion("PRODUCE_SELL_NUM is null");
            return (Criteria) this;
        }

        public Criteria andProduceSellNumIsNotNull() {
            addCriterion("PRODUCE_SELL_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andProduceSellNumEqualTo(Integer value) {
            addCriterion("PRODUCE_SELL_NUM =", value, "produceSellNum");
            return (Criteria) this;
        }

        public Criteria andProduceSellNumNotEqualTo(Integer value) {
            addCriterion("PRODUCE_SELL_NUM <>", value, "produceSellNum");
            return (Criteria) this;
        }

        public Criteria andProduceSellNumGreaterThan(Integer value) {
            addCriterion("PRODUCE_SELL_NUM >", value, "produceSellNum");
            return (Criteria) this;
        }

        public Criteria andProduceSellNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("PRODUCE_SELL_NUM >=", value, "produceSellNum");
            return (Criteria) this;
        }

        public Criteria andProduceSellNumLessThan(Integer value) {
            addCriterion("PRODUCE_SELL_NUM <", value, "produceSellNum");
            return (Criteria) this;
        }

        public Criteria andProduceSellNumLessThanOrEqualTo(Integer value) {
            addCriterion("PRODUCE_SELL_NUM <=", value, "produceSellNum");
            return (Criteria) this;
        }

        public Criteria andProduceSellNumIn(List<Integer> values) {
            addCriterion("PRODUCE_SELL_NUM in", values, "produceSellNum");
            return (Criteria) this;
        }

        public Criteria andProduceSellNumNotIn(List<Integer> values) {
            addCriterion("PRODUCE_SELL_NUM not in", values, "produceSellNum");
            return (Criteria) this;
        }

        public Criteria andProduceSellNumBetween(Integer value1, Integer value2) {
            addCriterion("PRODUCE_SELL_NUM between", value1, value2, "produceSellNum");
            return (Criteria) this;
        }

        public Criteria andProduceSellNumNotBetween(Integer value1, Integer value2) {
            addCriterion("PRODUCE_SELL_NUM not between", value1, value2, "produceSellNum");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table g_produce
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
     * This class corresponds to the database table g_produce
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