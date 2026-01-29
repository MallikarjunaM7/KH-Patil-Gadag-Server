package net.engineeringdigest.GimsEventManagementApp.Controller;

import net.engineeringdigest.GimsEventManagementApp.DTO.ApiResponseDTO;
import net.engineeringdigest.GimsEventManagementApp.DTO.EventRequestDTO;
import net.engineeringdigest.GimsEventManagementApp.DTO.EventResponseDTO;
import net.engineeringdigest.GimsEventManagementApp.DTO.TeamRequestDTO;
import net.engineeringdigest.GimsEventManagementApp.Service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    public EventService eventService;
    public EventController(EventService eventService)
    {
        this.eventService = eventService;
    }

    @GetMapping("/")
    public String home() {
        return "KH Patil Event Management Backend is running";
    }

    @GetMapping("/get-all-events")
    public ResponseEntity<ApiResponseDTO> getAllEvents()
    {
        List<EventResponseDTO> eventResponseDTOList = eventService.getAllEvents();
        ApiResponseDTO apiResponseDTO = new ApiResponseDTO(true, "Events Fetched Successfully", eventResponseDTOList);

        return ResponseEntity.ok().body(apiResponseDTO);
    }

    @GetMapping("/get-event-by-id/{id}")
    public ResponseEntity<ApiResponseDTO> getEventById(@PathVariable Long id) {
        EventResponseDTO eventResponseDTO = eventService.getEventById(id);
        return ResponseEntity.ok(
                new ApiResponseDTO(true, "Event Fetched Successfully", eventResponseDTO)
        );
    }


    @PostMapping("/{id}/register")
    public ResponseEntity<ApiResponseDTO> registerTeam(@PathVariable Long id, @RequestBody TeamRequestDTO team)
    {
        eventService.registerTeam(id, team);
        ApiResponseDTO apiResponseDTO = new ApiResponseDTO(true, "Operation Success", "Team Registered Successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponseDTO);
    }

    @PostMapping("/add-event")
    public ResponseEntity<ApiResponseDTO> addEvent(@RequestBody EventRequestDTO eventRequestDTO)
    {
        eventService.addEvent(eventRequestDTO);
        ApiResponseDTO apiResponseDTO = new ApiResponseDTO(true, "Operation Success", "Event Successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponseDTO);
    }

    @DeleteMapping("/delete-event-by-id/{id}")
    public ResponseEntity<ApiResponseDTO> deleteEventById(@PathVariable Long id)
    {
        eventService.deleteEventById(id);
        ApiResponseDTO apiResponseDTO = new ApiResponseDTO(true, "Operation Success", "Event Deleted Successfully");
        return ResponseEntity.ok().body(apiResponseDTO);
    }
}
