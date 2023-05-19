package com.andresmromero.br.bo.reservation.application.context.service.command.reservation.update.status;

import com.andresmromero.br.bo.context.domain.model.attribute_Id.ReservationId;
import com.andresmromero.br.bo.context.domain.model.enums.ReservationStatus;
import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import com.andresmromero.br.bo.reservation.application.context.exception.ResvAppExc;
import com.andresmromero.br.bo.reservation.domain.context.reservation.entity.reservation.ReservationAgg;
import com.andresmromero.br.bo.reservation.domain.context.reservation.repository.persistence.ReservationResvPersSvc;
import com.andresmromero.br.bo.reservation.infra.pers.context.jpa.exception.ResvInfraExc;
import lombok.AllArgsConstructor;

import java.util.List;

@ApplicationComp
@AllArgsConstructor
public class UpdateStatusResv {

    private ReservationResvPersSvc reservationResvPersSvc;

    public UpdateStatusResvCmdRes invoke(UpdateStatusResvCmd command) {

        ReservationId reservationId = new ReservationId(command.reservationId());

        ReservationAgg reservation = get_reservation(reservationId);

        String conditional = command.conditional().toUpperCase();
        String newStatus = command.newStatus().toUpperCase();

        if (conditional.equals(reservation.getStatus().name())) {


            ReservationAgg reservationUpdate = ReservationAgg.Builder.builder()

                                                                     .reservationId(reservation.getId())
                                                                     .customerId(reservation.getCustomerId())
                                                                     .stationId(reservation.getStationId())
                                                                     .price(reservation.getPrice())
                                                                     .trackingId(reservation.getTrackingId())
                                                                     .status(get_reservation_status(newStatus))
                                                                     .messageBox(reservation.getMessageBox())
                                                                     .build();

            reservationResvPersSvc.save_reservation(reservationUpdate);

        } else {

            return UpdateStatusResvCmdRes.builder()
                                         .message(List.of("The current status of the reserve is " +
                                                                  reservation.getStatus().name() +
                                                                  ". Status update is not allowed"))
                                         .build();

        }


        return UpdateStatusResvCmdRes.builder().message(List.of("payment done")).build();
    }

    private ReservationAgg get_reservation(ReservationId reservationId) {

        return reservationResvPersSvc.get_reservation(reservationId)
                                     .orElseThrow(() -> new ResvAppExc(
                                             "Error when finding for the reservation in the application"));
    }

    private ReservationStatus get_reservation_status(String reservationStatus) {

        if (reservationStatus.equals(ReservationStatus.APPROVED.name())) {
            return ReservationStatus.APPROVED;
        }
        if (reservationStatus.equals(ReservationStatus.PAID.name())) {
            return ReservationStatus.PAID;
        }
        if (reservationStatus.equals(ReservationStatus.CANCELLED.name())) {
            return ReservationStatus.CANCELLED;
        }
        if (reservationStatus.equals(ReservationStatus.PENDING.name())) {
            return ReservationStatus.PENDING;
        }
        if (reservationStatus.equals(ReservationStatus.CANCELLING.name())) {
            return ReservationStatus.CANCELLING;
        }

        throw new ResvInfraExc("reservation status no found");
    }

}
