package com.example.demo.DTO;

import lombok.*;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SessionDTO{
    private Set<MovieDTO> moviesDto;
    private String time;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SessionDTO)) return false;
        SessionDTO that = (SessionDTO) o;
        return moviesDto.equals(that.moviesDto) && time.equals(that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(moviesDto, time);
    }
}

