package com.andresmromero.br.bo.station.application.context.station_reservation.service.command;

import com.andresmromero.br.bo.context.shared.annotation.ApplicationSvc;
import com.andresmromero.br.bo.station.application.context.station_reservation.service.command.reservation.receive.ReceiveReservationCmd;
import com.andresmromero.br.bo.station.application.context.station_reservation.service.command.reservation.receive.ReceiveReservationHdl;
import com.andresmromero.br.bo.station.application.context.station_reservation.service.command.reservation.receive.ReceiveReservationRes;
import com.andresmromero.br.bo.station.application.context.station_reservation.service.command.stat_resev.create.CreateStatResevCmd;
import com.andresmromero.br.bo.station.application.context.station_reservation.service.command.stat_resev.create.CreateStatResevHdl;
import com.andresmromero.br.bo.station.application.context.station_reservation.service.command.stat_resev.delete.Id.DelStatResevByIdCmd;
import com.andresmromero.br.bo.station.application.context.station_reservation.service.command.stat_resev.delete.Id.DelStatResevByIdHdl;
import com.andresmromero.br.bo.station.application.context.station_reservation.service.command.stat_resev.update.byId.UpdStatResevIdCmd;
import com.andresmromero.br.bo.station.application.context.station_reservation.service.command.stat_resev.update.byId.UpdStatResvByIdHdl;
import lombok.AllArgsConstructor;

@ApplicationSvc
@AllArgsConstructor
public class StationReservationCmdAdpt implements StationReservationCmdSvs {

    private final ReceiveReservationHdl receivedPaymentHdl;
    private final CreateStatResevHdl createStatResevHdl;
    private final DelStatResevByIdHdl deleteStatResevByIdHdl;
    private final UpdStatResvByIdHdl updateStatResevByIdHdl;


    @Override
    public ReceiveReservationRes receive_reservation(ReceiveReservationCmd command) {

        return receivedPaymentHdl.handle(command);

    }

    @Override
    public void create_stationReservEntity(CreateStatResevCmd command) {

        createStatResevHdl.invoke(command);
    }

    @Override
    public void update_stationReservEntity(UpdStatResevIdCmd command) {

        updateStatResevByIdHdl.invoke(command);
    }

    @Override
    public void delete_stationReservEntity(DelStatResevByIdCmd command) {

        deleteStatResevByIdHdl.invoke(command);
    }

}
