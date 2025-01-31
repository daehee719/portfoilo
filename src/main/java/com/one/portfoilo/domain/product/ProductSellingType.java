package com.one.portfoilo.domain.product;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ProductSellingType {
    SELLING("판매중"),
    HOLD("판매 보류"),
    STOP_SELLING("판매 중지");

    private final String text;
}
