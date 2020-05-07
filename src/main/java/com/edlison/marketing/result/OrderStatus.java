package com.edlison.marketing.result;

public enum OrderStatus {
    NOT_PAY(0L),
    PAYED(1L),
    DELIVERING(2L),
    COMPLETED(3L);

    private final Long status;

    OrderStatus(Long status) {
        this.status = status;
    }

    public Long getStatus() {
        return status;
    }
}
