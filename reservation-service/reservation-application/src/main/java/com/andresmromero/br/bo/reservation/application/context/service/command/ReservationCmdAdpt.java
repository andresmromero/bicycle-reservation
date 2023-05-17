package com.andresmromero.br.bo.reservation.application.context.service.command;

import com.andresmromero.br.bo.context.shared.annotation.ApplicationSvc;
import com.andresmromero.br.bo.reservation.application.context.service.command.customer.create.CreateCustomerCmd;
import com.andresmromero.br.bo.reservation.application.context.service.command.customer.create.CreateCustomerHdl;
import com.andresmromero.br.bo.reservation.application.context.service.command.customer.delete.byId.DeleteCustomerByIdCmd;
import com.andresmromero.br.bo.reservation.application.context.service.command.customer.delete.byId.DeleteCustomerByIdHdl;
import com.andresmromero.br.bo.reservation.application.context.service.command.customer.update.byId.UpdateCustomerByIdHdl;
import com.andresmromero.br.bo.reservation.application.context.service.command.customer.update.byId.UpdateResevCustomerByIdCmd;
import com.andresmromero.br.bo.reservation.application.context.service.command.reservation.create.CreateReservationCmd;
import com.andresmromero.br.bo.reservation.application.context.service.command.reservation.create.CreateReservationCmdRes;
import com.andresmromero.br.bo.reservation.application.context.service.command.reservation.create.CreateReservationHdl;
import com.andresmromero.br.bo.reservation.application.context.service.command.reservation.update.status.UpdateStatusResvCmd;
import com.andresmromero.br.bo.reservation.application.context.service.command.reservation.update.status.UpdateStatusResvCmdRes;
import com.andresmromero.br.bo.reservation.application.context.service.command.reservation.update.status.UpdateStatusResvHdl;
import lombok.AllArgsConstructor;

@ApplicationSvc
@AllArgsConstructor
public class ReservationCmdAdpt implements ReservationCmdSvc {

    private final CreateReservationHdl createReservationHdl;
    private final UpdateStatusResvHdl updateStatusResvHdl;

    private final CreateCustomerHdl createCustomerHdl;
    private final UpdateCustomerByIdHdl updateCustomerByIdHdl;
    private final DeleteCustomerByIdHdl deleteCustomerByIdHdl;

    @Override
    public CreateReservationCmdRes create_reservation(CreateReservationCmd command) {

        return createReservationHdl.handle(command);
    }

    @Override
    public UpdateStatusResvCmdRes update_status(UpdateStatusResvCmd command) {

        return updateStatusResvHdl.handle(command);
    }

    @Override
    public void save_customer(CreateCustomerCmd command) {

        createCustomerHdl.invoke(command);
    }

    @Override
    public void update_customer_by_id(UpdateResevCustomerByIdCmd command) {

        updateCustomerByIdHdl.invoke(command);
    }

    @Override
    public void delete_customer_by_id(DeleteCustomerByIdCmd command) {

        deleteCustomerByIdHdl.invoke(command);
    }

}
