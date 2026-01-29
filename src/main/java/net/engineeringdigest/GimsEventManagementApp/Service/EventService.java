package net.engineeringdigest.GimsEventManagementApp.Service;

import net.engineeringdigest.GimsEventManagementApp.DTO.EventRequestDTO;
import net.engineeringdigest.GimsEventManagementApp.DTO.EventResponseDTO;
import net.engineeringdigest.GimsEventManagementApp.DTO.ParticipantRequestDTO;
import net.engineeringdigest.GimsEventManagementApp.DTO.TeamRequestDTO;
import net.engineeringdigest.GimsEventManagementApp.Entity.EventEntity;
import net.engineeringdigest.GimsEventManagementApp.Entity.ParticipantEntity;
import net.engineeringdigest.GimsEventManagementApp.Entity.TeamEntity;
import net.engineeringdigest.GimsEventManagementApp.Exception.DuplicateEntryException;
import net.engineeringdigest.GimsEventManagementApp.Mapper.EventMapper;
import net.engineeringdigest.GimsEventManagementApp.Mapper.ParticipantMapper;
import net.engineeringdigest.GimsEventManagementApp.Mapper.TeamMapper;
import net.engineeringdigest.GimsEventManagementApp.Repository.EventRepository;
import net.engineeringdigest.GimsEventManagementApp.Repository.ParticipantRepository;
import net.engineeringdigest.GimsEventManagementApp.Repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class EventService {

    public TeamRepository teamRepository;
    public EventRepository eventRepository;
    public ParticipantRepository participantRepository;
    public EventMapper eventMapper;
    public TeamMapper teamMapper;
    public ParticipantMapper participantMapper;

    public EventService(
            EventRepository eventRepository,
            EventMapper eventMapper,
            TeamRepository teamRepository,
            ParticipantRepository participantRepository,
            TeamMapper teamMapper,
            ParticipantMapper participantMapper
    )
    {
        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
        this.teamRepository = teamRepository;
        this.participantRepository = participantRepository;
        this.teamMapper = teamMapper;
        this.participantMapper = participantMapper;
    }

    public List<EventResponseDTO> getAllEvents()
    {
        List<EventEntity> allEvents = eventRepository.findAll();
        List<EventResponseDTO> eventDTOS = new ArrayList<>();

        for(EventEntity eventEntity: allEvents)
        {
            eventDTOS.add(eventMapper.entityToResponse(eventEntity));
        }

        return eventDTOS;
    }

    public EventResponseDTO getEventById(Long id)
    {
        EventEntity eventEntity = eventRepository.findById(id)
                .orElse(null);

        if (eventEntity == null) {
            throw new RuntimeException("Event Not Found");
        }

        return eventMapper.entityToResponse(eventEntity);
    }

    public void registerTeam(Long id, TeamRequestDTO team)
    {
        System.out.println(team.getTeamName());
        EventEntity eventEntity = eventRepository.findById(id).orElseThrow(() -> new RuntimeException("Event Not Found"));

        HashSet<String> phoneSet = new HashSet<>();

        for(TeamEntity teamEntity: eventEntity.getTeams())
        {
            if(teamEntity.getTeamName().equals(team.getTeamName()))
            {
                throw new DuplicateEntryException("This team name already exists please use other team name");
            }
            for(ParticipantEntity participantEntity: teamEntity.getParticipants())
            {
                phoneSet.add(participantEntity.getPhone());
            }
        }
        HashSet<String> currentTeamPhoneSet = new HashSet<>();
        for(ParticipantRequestDTO participantRequestDTO: team.getParticipants())
        {
            if(currentTeamPhoneSet.contains(participantRequestDTO.getPhone()))
            {
                throw new DuplicateEntryException("Duplicate phone in same team " + participantRequestDTO.getPhone());
            }else{
                currentTeamPhoneSet.add(participantRequestDTO.getPhone());
            }
            if(phoneSet.contains(participantRequestDTO.getPhone()))
            {
                throw new DuplicateEntryException("User already registered with phone number " + participantRequestDTO.getPhone());
            }
        }

        TeamEntity newTeam = teamMapper.RequestToEntity(team, eventEntity);

        System.out.println(newTeam.getTeamName());

        teamRepository.save(newTeam);

        List<ParticipantRequestDTO> participants = team.getParticipants();

        for(ParticipantRequestDTO participantRequestDTO: participants)
        {
            participantRepository.save(participantMapper.RequestToEntity(participantRequestDTO, newTeam));
        }
    }

    public void addEvent(EventRequestDTO eventRequestDTO)
    {
        EventEntity eventEntity = eventMapper.RequestToEntity(eventRequestDTO);

        eventRepository.save(eventEntity);
    }

    public void deleteEventById(Long id)
    {
        eventRepository.deleteById(id);

    }

}
