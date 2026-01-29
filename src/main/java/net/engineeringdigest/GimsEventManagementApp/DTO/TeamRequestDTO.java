package net.engineeringdigest.GimsEventManagementApp.DTO;

import lombok.*;

import java.util.List;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamRequestDTO {

    private String teamName;
    private List<ParticipantRequestDTO> participants;
}
