package com.one.portfoilo.domain.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderStatus {

    INIT("주문 생성"),
    CANCELED("주문 취소"),
    PAYMENT_COMPLETE("결제 완료"),
    PAYMENT_FAILED("결제 실패"),
    RECEIVED("주문 접수"),
    COMPLETE("처리 완료");

    private final String text;
}
