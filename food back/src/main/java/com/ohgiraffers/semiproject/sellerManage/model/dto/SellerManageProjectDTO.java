package com.ohgiraffers.semiproject.sellerManage.model.dto;

import java.sql.Date;

public class SellerManageProjectDTO {

    private int code;

    private int memberCode;

    private String projectTitle;

    private Date start;

    private Date end;

    private int amount;

    private String achievementStatus;

    private String progressStatus;

    private int planCode;
    private int plan;
    private int businessCode;

    private String businessName;


    public SellerManageProjectDTO() {
    }

    public SellerManageProjectDTO(int code, int memberCode, String projectTitle, Date start, Date end, int amount, String achievementStatus, String progressStatus, int planCode, int plan, int businessCode, String businessName) {
        this.code = code;
        this.memberCode = memberCode;
        this.projectTitle = projectTitle;
        this.start = start;
        this.end = end;
        this.amount = amount;
        this.achievementStatus = achievementStatus;
        this.progressStatus = progressStatus;
        this.planCode = planCode;
        this.plan = plan;
        this.businessCode = businessCode;
        this.businessName = businessName;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(int memberCode) {
        this.memberCode = memberCode;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getAchievementStatus() {
        return achievementStatus;
    }

    public void setAchievementStatus(String achievementStatus) {
        this.achievementStatus = achievementStatus;
    }

    public String getProgressStatus() {
        return progressStatus;
    }

    public void setProgressStatus(String progressStatus) {
        this.progressStatus = progressStatus;
    }

    public int getPlanCode() {
        return planCode;
    }

    public void setPlanCode(int planCode) {
        this.planCode = planCode;
    }

    public int getPlan() {
        return plan;
    }

    public void setPlan(int plan) {
        this.plan = plan;
    }

    public int getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(int businessCode) {
        this.businessCode = businessCode;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    @Override
    public String toString() {
        return "SellerManageProjectDTO{" +
                "code=" + code +
                ", memberCode=" + memberCode +
                ", projectTitle='" + projectTitle + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", amount=" + amount +
                ", achievementStatus='" + achievementStatus + '\'' +
                ", progressStatus='" + progressStatus + '\'' +
                ", planCode=" + planCode +
                ", plan=" + plan +
                ", businessCode=" + businessCode +
                ", businessName='" + businessName + '\'' +
                '}';
    }
}
