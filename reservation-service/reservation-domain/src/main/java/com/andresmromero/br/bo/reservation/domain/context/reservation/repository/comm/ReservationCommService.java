package com.andresmromero.br.bo.reservation.domain.context.reservation.repository.comm;

import com.andresmromero.br.bo.context.domain.model.enums.PaymentStatus;
import com.andresmromero.br.bo.reservation.domain.context.reservation.service.comm.GetAvailableComm;
import com.andresmromero.br.bo.reservation.domain.context.reservation.service.comm.GetAvailableQryComm;
import com.andresmromero.br.bo.reservation.domain.context.reservation.service.response.ReservationDomRes;

public interface ReservationCommService {

    void send_payment(ReservationDomRes ReservationDomRes, PaymentStatus paymentStatus);

    GetAvailableQryComm get_station(GetAvailableComm query);

}
