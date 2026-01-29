package net.engineeringdigest.GimsEventManagementApp.DTO;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamResponseDTO {

    private Long id;
    private String teamName;
    private LocalDateTime registeredAt;
    private List<ParticipantResponseDTO> participants;

}
