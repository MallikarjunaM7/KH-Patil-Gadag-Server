package net.engineeringdigest.GimsEventManagementApp.Mapper;

import net.engineeringdigest.GimsEventManagementApp.DTO.EventRequestDTO;
import net.engineeringdigest.GimsEventManagementApp.DTO.EventResponseDTO;
import net.engineeringdigest.GimsEventManagementApp.Entity.EventEntity;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {

    private final TeamMapper teamMapper;
    public EventMapper(TeamMapper teamMapper)
    {
        this.teamMapper = teamMapper;
    }

    public EventResponseDTO entityToResponse(EventEntity eventEntity)
    {
        return EventResponseDTO.builder()
                .id(eventEntity.getId())
                .name(eventEntity.getName())
                .description(eventEntity.getDescription())
                .eventDate(eventEntity.getEventDate())
                .eventTime(eventEntity.getEventTime())
                .eventType(eventEntity.getEventType())
                .maxTeamSize(eventEntity.getMaxTeamSize())
                .teams(eventEntity.getTeams().stream().map(teamMapper::EntityToResponse).toList())
                .build();
    }

    public EventEntity RequestToEntity(EventRequestDTO eventRequestDTO)
    {
        return EventEntity.builder()
                .name(eventRequestDTO.getName())
                .description(eventRequestDTO.getDescription())
                .eventDate(eventRequestDTO.getEventDate())
                .eventTime(eventRequestDTO.getEventTime())
                .eventType(eventRequestDTO.getEventType())
                .maxTeamSize(eventRequestDTO.getMaxTeamSize())
                .build();
    }
}
