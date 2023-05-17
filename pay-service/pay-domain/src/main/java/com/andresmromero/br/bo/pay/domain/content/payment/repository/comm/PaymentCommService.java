package com.andresmromero.br.bo.pay.domain.content.payment.repository.comm;


import com.andresmromero.br.bo.pay.domain.content.payment.service.comm.mapper.UpdateStatusResvCmd;
import com.andresmromero.br.bo.pay.domain.content.payment.service.comm.mapper.UpdateStatusResvCmdRes;

import java.util.UUID;

public interface PaymentCommService {

    UpdateStatusResvCmdRes update_status_reservation(UpdateStatusResvCmd command, UUID reservationId);

}
