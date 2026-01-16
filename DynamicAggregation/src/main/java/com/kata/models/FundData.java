package com.kata.models;

import lombok.*;

import java.util.Objects;


@Getter
public class FundData {
    private String fundId;
    private String investorId;
    private String currency;
    @Setter
    private String level1;
    private int amount;
    @Setter
    private String dynamicGroupByKey;

    public FundData(){}

    public FundData(String fundId, String investorId, String currency, String level1, int amount){
        this.fundId = fundId;
        this.investorId = investorId;
        this.currency = currency;
        this.level1 = level1;
        this.amount = amount;
    }

    public String getGroupByKey(){
        return fundId + investorId + currency + level1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FundData fundData = (FundData) o;
        return amount == fundData.amount && Objects.equals(fundId, fundData.fundId) && Objects.equals(investorId, fundData.investorId) && Objects.equals(currency, fundData.currency) && Objects.equals(level1, fundData.level1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fundId, investorId, currency, level1, amount);
    }
}
