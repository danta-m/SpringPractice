package com.example.demo.DTO;

import lombok.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String login;
    private List<RoleDTO> roleDTOList;
    private List <TicketDTO> ticketDTOList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDTO)) return false;
        UserDTO userDTO = (UserDTO) o;
        return login.equals(userDTO.login) && roleDTOList.equals(userDTO.roleDTOList) && ticketDTOList.equals(userDTO.ticketDTOList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, roleDTOList, ticketDTOList);
    }
}
