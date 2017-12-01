package com.test.dozer.bean;

import java.util.List;

/**
 * Created by szh on 2017/12/1.
 */
public class RebateRuleVO {

    private Integer rebateRuleId;

    private String rebateRuleName;

    private List<RebateVO> rebateVOList;

    public Integer getRebateRuleId() {
        return rebateRuleId;
    }

    public void setRebateRuleId(Integer rebateRuleId) {
        this.rebateRuleId = rebateRuleId;
    }

    public String getRebateRuleName() {
        return rebateRuleName;
    }

    public void setRebateRuleName(String rebateRuleName) {
        this.rebateRuleName = rebateRuleName;
    }

    public List<RebateVO> getRebateVOList() {
        return rebateVOList;
    }

    public void setRebateVOList(List<RebateVO> rebateVOList) {
        this.rebateVOList = rebateVOList;
    }
}
