package pers.guanzf.common.core.model;

import java.util.Date;

public class PersonProduce {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column g_person_produce.PERSON_PRODUCE_ID
     *
     * @mbg.generated
     */
    private String personProduceId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column g_person_produce.PERSON_ID
     *
     * @mbg.generated
     */
    private String personId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column g_person_produce.PRODUCE_ID
     *
     * @mbg.generated
     */
    private String produceId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column g_person_produce.comment
     *
     * @mbg.generated
     */
    private String comment;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column g_person_produce.CREATE_TIME
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column g_person_produce.COMMENT_IMG_URL
     *
     * @mbg.generated
     */
    private String commentImgUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column g_person_produce.COMMENT_VALUE
     *
     * @mbg.generated
     */
    private Float commentValue;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column g_person_produce.PERSON_PRODUCE_ID
     *
     * @return the value of g_person_produce.PERSON_PRODUCE_ID
     *
     * @mbg.generated
     */
    public String getPersonProduceId() {
        return personProduceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column g_person_produce.PERSON_PRODUCE_ID
     *
     * @param personProduceId the value for g_person_produce.PERSON_PRODUCE_ID
     *
     * @mbg.generated
     */
    public void setPersonProduceId(String personProduceId) {
        this.personProduceId = personProduceId == null ? null : personProduceId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column g_person_produce.PERSON_ID
     *
     * @return the value of g_person_produce.PERSON_ID
     *
     * @mbg.generated
     */
    public String getPersonId() {
        return personId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column g_person_produce.PERSON_ID
     *
     * @param personId the value for g_person_produce.PERSON_ID
     *
     * @mbg.generated
     */
    public void setPersonId(String personId) {
        this.personId = personId == null ? null : personId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column g_person_produce.PRODUCE_ID
     *
     * @return the value of g_person_produce.PRODUCE_ID
     *
     * @mbg.generated
     */
    public String getProduceId() {
        return produceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column g_person_produce.PRODUCE_ID
     *
     * @param produceId the value for g_person_produce.PRODUCE_ID
     *
     * @mbg.generated
     */
    public void setProduceId(String produceId) {
        this.produceId = produceId == null ? null : produceId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column g_person_produce.comment
     *
     * @return the value of g_person_produce.comment
     *
     * @mbg.generated
     */
    public String getComment() {
        return comment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column g_person_produce.comment
     *
     * @param comment the value for g_person_produce.comment
     *
     * @mbg.generated
     */
    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column g_person_produce.CREATE_TIME
     *
     * @return the value of g_person_produce.CREATE_TIME
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column g_person_produce.CREATE_TIME
     *
     * @param createTime the value for g_person_produce.CREATE_TIME
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column g_person_produce.COMMENT_IMG_URL
     *
     * @return the value of g_person_produce.COMMENT_IMG_URL
     *
     * @mbg.generated
     */
    public String getCommentImgUrl() {
        return commentImgUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column g_person_produce.COMMENT_IMG_URL
     *
     * @param commentImgUrl the value for g_person_produce.COMMENT_IMG_URL
     *
     * @mbg.generated
     */
    public void setCommentImgUrl(String commentImgUrl) {
        this.commentImgUrl = commentImgUrl == null ? null : commentImgUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column g_person_produce.COMMENT_VALUE
     *
     * @return the value of g_person_produce.COMMENT_VALUE
     *
     * @mbg.generated
     */
    public Float getCommentValue() {
        return commentValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column g_person_produce.COMMENT_VALUE
     *
     * @param commentValue the value for g_person_produce.COMMENT_VALUE
     *
     * @mbg.generated
     */
    public void setCommentValue(Float commentValue) {
        this.commentValue = commentValue;
    }
}