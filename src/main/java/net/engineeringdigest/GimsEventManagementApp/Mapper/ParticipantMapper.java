package net.engineeringdigest.GimsEventManagementApp.Mapper;

import net.engineeringdigest.GimsEventManagementApp.DTO.ParticipantRequestDTO;
import net.engineeringdigest.GimsEventManagementApp.DTO.ParticipantResponseDTO;
import net.engineeringdigest.GimsEventManagementApp.Entity.ParticipantEntity;
import net.engineeringdigest.GimsEventManagementApp.Entity.TeamEntity;
import org.springframework.stereotype.Component;

@Component
public class ParticipantMapper {

    public ParticipantResponseDTO EntityToResponse(ParticipantEntity participantEntity)
    {
        return ParticipantResponseDTO.builder()
                .id(participantEntity.getId())
                .fullname(participantEntity.getFullName())
                .phone(participantEntity.getPhone())
                .batch(participantEntity.getBatch())
                .currentYear(participantEntity.getCurrentYear())
                .build();
    }

    public ParticipantEntity RequestToEntity(ParticipantRequestDTO participantRequestDTO, TeamEntity team)
    {
        return ParticipantEntity.builder()
                .fullName(participantRequestDTO.getFullName())
                .phone(participantRequestDTO.getPhone())
                .team(team)
                .batch(participantRequestDTO.getBatch())
                .currentYear(participantRequestDTO.getCurrentYear())
                .build();
    }
}
