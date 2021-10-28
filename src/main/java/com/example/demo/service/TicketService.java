package com.example.demo.service;

import com.example.demo.DTO.TicketDTO;
import com.example.demo.mapper.TicketMapper;
import com.example.demo.model.Ticket;
import com.example.demo.repository.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TicketService {
    @Autowired
    private final TicketRepository ticketRepository;
    @Autowired
    private final TicketMapper ticketDto;

    public Ticket addTicket(Ticket ticket) {
        Ticket save = ticketRepository.save(ticket);
        return save;
    }

    public TicketDTO addTicketDto(Ticket ticket) {
        Ticket save = ticketRepository.save(ticket);
        return ticketDto.mapToDto(save);
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket getTicketById (Long id) {
        Optional<Ticket> byId = ticketRepository.findById(id);
        return byId.orElseGet(Ticket::new);
    }

    public boolean deleteTicket (Long id) {
        ticketRepository.deleteById(id);
        return true;
    }

    public List<TicketDTO> getAllTicketDto() {
        return ticketRepository.findAll().stream()
                .map(ticketDto::mapToDto)
                .collect(Collectors.toList());
    }

    public TicketDTO getTicketByIdDto (Long id) {
        return ticketDto.mapToDto(ticketRepository.findById(id).orElseGet(Ticket::new));
    }
}
