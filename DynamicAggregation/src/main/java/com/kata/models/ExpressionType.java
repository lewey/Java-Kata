package com.kata.models;

import java.util.function.BiPredicate;

//Ideally these should be separate classes with their own function factory
public enum ExpressionType {
    STARTS_WITH,
    CONTAINS,
    REGEX,
    NONE; // this would perhaps live somewhere else
}
