package com.spike.community.model;

public class Like {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column like.id
     *
     * @mbg.generated Thu Sep 26 14:35:39 CST 2019
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column like.liker
     *
     * @mbg.generated Thu Sep 26 14:35:39 CST 2019
     */
    private Long liker;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column like.liked
     *
     * @mbg.generated Thu Sep 26 14:35:39 CST 2019
     */
    private Long liked;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column like.gmt_create
     *
     * @mbg.generated Thu Sep 26 14:35:39 CST 2019
     */
    private Long gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column like.gmt_modified
     *
     * @mbg.generated Thu Sep 26 14:35:39 CST 2019
     */
    private Long gmtModified;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column like.status
     *
     * @mbg.generated Thu Sep 26 14:35:39 CST 2019
     */
    private Integer status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column like.id
     *
     * @return the value of like.id
     *
     * @mbg.generated Thu Sep 26 14:35:39 CST 2019
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column like.id
     *
     * @param id the value for like.id
     *
     * @mbg.generated Thu Sep 26 14:35:39 CST 2019
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column like.liker
     *
     * @return the value of like.liker
     *
     * @mbg.generated Thu Sep 26 14:35:39 CST 2019
     */
    public Long getLiker() {
        return liker;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column like.liker
     *
     * @param liker the value for like.liker
     *
     * @mbg.generated Thu Sep 26 14:35:39 CST 2019
     */
    public void setLiker(Long liker) {
        this.liker = liker;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column like.liked
     *
     * @return the value of like.liked
     *
     * @mbg.generated Thu Sep 26 14:35:39 CST 2019
     */
    public Long getLiked() {
        return liked;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column like.liked
     *
     * @param liked the value for like.liked
     *
     * @mbg.generated Thu Sep 26 14:35:39 CST 2019
     */
    public void setLiked(Long liked) {
        this.liked = liked;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column like.gmt_create
     *
     * @return the value of like.gmt_create
     *
     * @mbg.generated Thu Sep 26 14:35:39 CST 2019
     */
    public Long getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column like.gmt_create
     *
     * @param gmtCreate the value for like.gmt_create
     *
     * @mbg.generated Thu Sep 26 14:35:39 CST 2019
     */
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column like.gmt_modified
     *
     * @return the value of like.gmt_modified
     *
     * @mbg.generated Thu Sep 26 14:35:39 CST 2019
     */
    public Long getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column like.gmt_modified
     *
     * @param gmtModified the value for like.gmt_modified
     *
     * @mbg.generated Thu Sep 26 14:35:39 CST 2019
     */
    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column like.status
     *
     * @return the value of like.status
     *
     * @mbg.generated Thu Sep 26 14:35:39 CST 2019
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column like.status
     *
     * @param status the value for like.status
     *
     * @mbg.generated Thu Sep 26 14:35:39 CST 2019
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}