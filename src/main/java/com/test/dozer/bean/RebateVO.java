package com.test.dozer.bean;

/**
 * Created by szh on 2017/12/1.
 */
public class RebateVO {

    private Integer rebateId;

    private Double fixed;

    private Double upper;

    private Double floor;

    public Integer getRebateId() {
        return rebateId;
    }

    public void setRebateId(Integer rebateId) {
        this.rebateId = rebateId;
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
        return "RebateVO{" +
                "rebateId=" + rebateId +
                ", fixed=" + fixed +
                ", upper=" + upper +
                ", floor=" + floor +
                '}';
    }
}
