package com.example.SpringBoot.entity;
/**
 * select  memberId,userid,payType,sum(amount) from maill group by memberId,userid,payType
 * @Title: Maill
 * @Description:TODO (用一句话描述该类文件做什么)
 * @Team: 财务产品研发部
 * @Author liu.li
 * @Date 2017年8月15日
 * @version
 */
public class Maill {
    private Long memberId;
    private Long userid;
    private String payType;
    private String amount;
    public Long getMemberId() {
        return memberId;
    }
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
    public Long getUserid() {
        return userid;
    }
    public void setUserid(Long userid) {
        this.userid = userid;
    }
    public String getPayType() {
        return payType;
    }
    public void setPayType(String payType) {
        this.payType = payType;
    }
    public String getAmount() {
        return amount;
    }
    public void setAmount(String amount) {
        this.amount = amount;
    }
}
