package com.one.portfoilo.domain.product.type;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ProductType {
    MONTHLY_RENT("월세"),
    JEOUNSE("전세"),
    MAEMAE("매매");

    private final String text;
}
