package com.test.dozer.bean;

/**
 * Created by szh on 2017/12/1.
 */
public class RebateDTO {

    private Integer rebateId;

    private Double rebateRate;

    private Double fixed;

    private Double upper;

    private Double floor;

    public Integer getRebateId() {
        return rebateId;
    }

    public void setRebateId(Integer rebateId) {
        this.rebateId = rebateId;
    }

    public Double getRebateRate() {
        return rebateRate;
    }

    public void setRebateRate(Double rebateRate) {
        this.rebateRate = rebateRate;
    }

    public Double getFixed() {
        return fixed;
    }

    public void setFixed(Double fixed) {
        this.fixed = fixed;
    }

    public Double getUpper() {
        return upper;
    }

    public void setUpper(Double upper) {
        this.upper = upper;
    }

    public Double getFloor() {
        return floor;
    }

    public void setFloor(Double floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "RebateDTO{" +
                "rebateId=" + rebateId +
                ", rebateRate=" + rebateRate +
                ", fixed=" + fixed +
                ", upper=" + upper +
                ", floor=" + floor +
                '}';
    }
}
