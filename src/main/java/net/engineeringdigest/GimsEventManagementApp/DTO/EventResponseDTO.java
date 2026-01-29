package net.engineeringdigest.GimsEventManagementApp.DTO;

import lombok.*;
import net.engineeringdigest.GimsEventManagementApp.Constant.EventType;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventResponseDTO {

    private Long id;
    private String name;
    private String description;
    private LocalDate eventDate;
    private LocalTime eventTime;
    private EventType eventType;
    private int maxTeamSize;
    private List<TeamResponseDTO> teams;
}
