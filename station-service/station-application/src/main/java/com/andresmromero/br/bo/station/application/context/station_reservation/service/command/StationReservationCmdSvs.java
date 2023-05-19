package com.andresmromero.br.bo.station.application.context.station_reservation.service.command;

import com.andresmromero.br.bo.station.application.context.station_reservation.service.command.reservation.receive.ReceiveReservationCmd;
import com.andresmromero.br.bo.station.application.context.station_reservation.service.command.reservation.receive.ReceiveReservationRes;
import com.andresmromero.br.bo.station.application.context.station_reservation.service.command.stat_resev.create.CreateStatResevCmd;
import com.andresmromero.br.bo.station.application.context.station_reservation.service.command.stat_resev.delete.Id.DelStatResevByIdCmd;
import com.andresmromero.br.bo.station.application.context.station_reservation.service.command.stat_resev.update.byId.UpdStatResevIdCmd;

public interface StationReservationCmdSvs {

    ReceiveReservationRes receive_reservation(ReceiveReservationCmd command);

    void create_stationReservEntity(CreateStatResevCmd command);

    void update_stationReservEntity(UpdStatResevIdCmd command);

    void delete_stationReservEntity(DelStatResevByIdCmd command);

}
