package com.andresmromero.br.bo.pay.domain.content.payment.repository.comm;


import com.andresmromero.br.bo.pay.domain.content.payment.service.comm.mapper.UpdateStatusResvCmdRes;
import com.andresmromero.br.bo.pay.domain.content.payment.service.comm.mapper.UpdateStatusResvCmdx;

import java.util.UUID;

public interface PaymentCommService {

    UpdateStatusResvCmdRes update_status_reservation(UpdateStatusResvCmdx command, UUID reservationId);

}
