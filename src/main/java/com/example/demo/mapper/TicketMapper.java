package com.example.demo.mapper;

import com.example.demo.DTO.TicketDTO;
import com.example.demo.model.Ticket;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper implements Mapper<TicketDTO, Ticket> {

    @Override
    public TicketDTO mapToDto (Ticket ticket) {
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setUsersDto(ticketDTO.getUsersDto());
        ticketDTO.setSessionsDto(ticketDTO.getSessionsDto());
        return ticketDTO;
    }
}
