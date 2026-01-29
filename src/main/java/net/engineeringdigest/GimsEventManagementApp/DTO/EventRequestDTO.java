package net.engineeringdigest.GimsEventManagementApp.DTO;

import lombok.*;
import net.engineeringdigest.GimsEventManagementApp.Constant.EventType;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class EventRequestDTO {

    private String name;
    private String description;
    private LocalDate eventDate;
    private LocalTime eventTime;
    private EventType eventType;
    private int maxTeamSize;
}
