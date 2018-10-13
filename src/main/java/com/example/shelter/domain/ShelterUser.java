package com.example.shelter.domain;

import java.math.BigDecimal;
import java.util.Date;

public class ShelterUser {


    private Long id;

    private String userName;

    private String userCradNo;

    private String userMobile;

    private String userEmail;

    private String userNation;

    private Integer userGender;

    private Date userBirth;

    private String userProfession;

    private BigDecimal userIncome;

    private String userEducational;

    private Long userPoint;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCradNo() {
        return userCradNo;
    }

    public void setUserCradNo(String userCradNo) {
        this.userCradNo = userCradNo;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserNation() {
        return userNation;
    }

    public void setUserNation(String userNation) {
        this.userNation = userNation;
    }

    public Integer getUserGender() {
        return userGender;
    }

    public void setUserGender(Integer userGender) {
        this.userGender = userGender;
    }

    public Date getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(Date userBirth) {
        this.userBirth = userBirth;
    }

    public String getUserProfession() {
        return userProfession;
    }

    public void setUserProfession(String userProfession) {
        this.userProfession = userProfession;
    }

    public BigDecimal getUserIncome() {
        return userIncome;
    }

    public void setUserIncome(BigDecimal userIncome) {
        this.userIncome = userIncome;
    }

    public String getUserEducational() {
        return userEducational;
    }

    public void setUserEducational(String userEducational) {
        this.userEducational = userEducational;
    }

    public Long getUserPoint() {
        return userPoint;
    }

    public void setUserPoint(Long userPoint) {
        this.userPoint = userPoint;
    }
}
