package com.one.portfoilo.domain.product;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ProductType {
    MONTHLY_RENT("월세"),
    JEOUNSE("전세"),
    MAEMAE("매매");

    private final String text;
}
