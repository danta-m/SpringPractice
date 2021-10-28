package com.example.demo.controller;

import com.example.demo.DTO.TicketDTO;
import com.example.demo.model.Ticket;
import com.example.demo.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
@AllArgsConstructor
public class ControllerTickets {
    private final TicketService ticketService;

    @PostMapping("/add")
    public Ticket addTicket(@RequestBody Ticket ticket) {
        return ticketService.addTicket(ticket);
    }

    @GetMapping("/all")
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/get/{id}")
    public Ticket findTicketById(@PathVariable Long id) {
        return ticketService.getTicketById(id);
    }

    @GetMapping("/delete/{id}")
    public boolean deleteTicket(@PathVariable Long id) {
        return ticketService.deleteTicket(id);
    }

    @GetMapping("/allDto")
    public List<TicketDTO> getAllUsersDto() {
        return ticketService.getAllTicketDto();
    }

    @GetMapping("/getDto/{id}")
    public TicketDTO getTicketByIdDto(@PathVariable Long id) {
        return ticketService.getTicketByIdDto(id);
    }
}
