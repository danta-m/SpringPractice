package com.example.demo.DTO;

import lombok.*;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class MovieDTO{
    private String title;
    private String description;
    private Set<SessionDTO> sessionDto;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MovieDTO)) return false;
        MovieDTO movieDTO = (MovieDTO) o;
        return title.equals(movieDTO.title) && description.equals(movieDTO.description)
                & sessionDto.equals(movieDTO.sessionDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, sessionDto);
    }
}
