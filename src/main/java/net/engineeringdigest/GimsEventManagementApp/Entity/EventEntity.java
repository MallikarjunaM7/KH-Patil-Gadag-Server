package net.engineeringdigest.GimsEventManagementApp.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.engineeringdigest.GimsEventManagementApp.Constant.EventType;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "events")
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class EventEntity {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "event_date", nullable = false)
    private LocalDate eventDate;

    @Column(name = "event_time", nullable = false)
    private LocalTime eventTime;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "event_type", nullable = false)
    private EventType eventType;

    @Column(name = "max_team_size", nullable = false)
    private int maxTeamSize;

    @OneToMany(
    mappedBy = "event",
    cascade = CascadeType.ALL,
    orphanRemoval = true
)
    private List<TeamEntity> teams;
}
