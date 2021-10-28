package com.example.demo.DTO;

import lombok.*;
import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketDTO {
    private UserDTO usersDto;
    private SessionDTO sessionsDto;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TicketDTO)) return false;
        TicketDTO ticketDTO = (TicketDTO) o;
        return usersDto.equals(ticketDTO.usersDto) && sessionsDto.equals(ticketDTO.sessionsDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usersDto, sessionsDto);
    }
}
