package net.engineeringdigest.GimsEventManagementApp.Mapper;

import net.engineeringdigest.GimsEventManagementApp.DTO.TeamRequestDTO;
import net.engineeringdigest.GimsEventManagementApp.DTO.TeamResponseDTO;
import net.engineeringdigest.GimsEventManagementApp.Entity.EventEntity;
import net.engineeringdigest.GimsEventManagementApp.Entity.TeamEntity;
import org.springframework.stereotype.Component;

@Component
public class TeamMapper {

    private final ParticipantMapper participantMapper;
    public TeamMapper(ParticipantMapper participantMapper)
    {
        this.participantMapper = participantMapper;
    }

    public TeamResponseDTO EntityToResponse(TeamEntity teamEntity)
    {
        return TeamResponseDTO.builder()
                .id(teamEntity.getId())
                .teamName(teamEntity.getTeamName())
                .registeredAt(teamEntity.getRegisteredAt())
                .participants(
                        teamEntity.getParticipants()
                                .stream()
                                .map(participantMapper::EntityToResponse)
                                .toList()
                ).build();
    }

    public TeamEntity RequestToEntity(TeamRequestDTO teamRequestDTO, EventEntity eventEntity)
    {
        return TeamEntity.builder().teamName(teamRequestDTO.getTeamName()).event(eventEntity).build();
    }
}
