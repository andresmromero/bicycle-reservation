package com.andresmromero.br.bo.context.domain.vo;

public class CellPhoneNumberVo extends LongVo {

    private final Integer countryCode;
    private final Long localNumber;

    public CellPhoneNumberVo(Integer countryCode, Long localNumber) {

        super(localNumber);
        this.countryCode = countryCode;
        this.localNumber = localNumber;
    }

    public Integer getCountryCode() {

        return countryCode;
    }

    public Long getLocalNumber() {

        return localNumber;
    }

}
