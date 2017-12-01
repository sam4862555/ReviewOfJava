package com.test.dozer.bean;

import org.dozer.Mapping;

import java.util.List;

/**
 * Created by szh on 2017/12/1.
 */
public class RebateRuleDTO {

    private Integer rebateRuleId;

    private String rebateRuleName;

    private String rebateRuleDescri;

    @Mapping("rebateVOList")
    private List<RebateDTO> rebateDTOList;

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

    public String getRebateRuleDescri() {
        return rebateRuleDescri;
    }

    public void setRebateRuleDescri(String rebateRuleDescri) {
        this.rebateRuleDescri = rebateRuleDescri;
    }

    public List<RebateDTO> getRebateDTOList() {
        return rebateDTOList;
    }

    public void setRebateDTOList(List<RebateDTO> rebateDTOList) {
        this.rebateDTOList = rebateDTOList;
    }
}
