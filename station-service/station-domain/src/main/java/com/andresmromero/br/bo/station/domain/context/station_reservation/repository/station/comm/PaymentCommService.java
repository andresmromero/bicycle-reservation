package com.andresmromero.br.bo.station.domain.context.station_reservation.repository.station.comm;


import com.andresmromero.br.bo.station.domain.context.station_reservation.service.mapper.UpdateStatusResvCmd;
import com.andresmromero.br.bo.station.domain.context.station_reservation.service.mapper.UpdateStatusResvCmdRes;

import java.util.UUID;

public interface PaymentCommService {

    UpdateStatusResvCmdRes update_status_reservation(UpdateStatusResvCmd command, UUID reservationId);

}
