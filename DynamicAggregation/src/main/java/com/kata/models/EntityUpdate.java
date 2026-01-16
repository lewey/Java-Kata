package com.kata.models;


import lombok.Getter;
import java.util.Optional;

public class EntityUpdate {

    @Getter
    private final ExpressionType expressionType;
    private final String expressionValue;

    public EntityUpdate(ExpressionType expressionType, String expressionValue){
        this.expressionType = expressionType;
        this.expressionValue = expressionValue;
    }

    public EntityUpdate(ExpressionType expressionType){
        this.expressionType = expressionType;
        this.expressionValue = null;
    }


    public Optional<String> getExpressionValue(){
        return Optional.ofNullable(expressionValue);
    }

}
