package com.andresmromero.br.bo.reservation.application.context.service.command;

import com.andresmromero.br.bo.reservation.application.context.service.command.customer.create.CreateCustomerCmd;
import com.andresmromero.br.bo.reservation.application.context.service.command.customer.delete.byId.DeleteCustomerByIdCmd;
import com.andresmromero.br.bo.reservation.application.context.service.command.customer.update.byId.UpdateResevCustomerByIdCmd;
import com.andresmromero.br.bo.reservation.application.context.service.command.reservation.create.CreateReservationCmd;
import com.andresmromero.br.bo.reservation.application.context.service.command.reservation.create.CreateReservationCmdRes;
import com.andresmromero.br.bo.reservation.application.context.service.command.reservation.update.status.UpdateStatusResvCmd;
import com.andresmromero.br.bo.reservation.application.context.service.command.reservation.update.status.UpdateStatusResvCmdRes;

public interface ReservationCmdSvc {

    CreateReservationCmdRes create_reservation(CreateReservationCmd command);

    UpdateStatusResvCmdRes update_status(UpdateStatusResvCmd command);

    void save_customer(CreateCustomerCmd command);

    void update_customer_by_id(UpdateResevCustomerByIdCmd command);

    void delete_customer_by_id(DeleteCustomerByIdCmd command);

}
