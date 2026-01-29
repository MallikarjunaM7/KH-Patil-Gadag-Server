package net.engineeringdigest.GimsEventManagementApp.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "teams")

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class TeamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "team_name", nullable = false)
    private String teamName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", nullable = false)
    private EventEntity event;

    @Column(name = "registered_at")
    private LocalDateTime registeredAt;

    @OneToMany(mappedBy = "team")
    private List<ParticipantEntity> participants;

    @PrePersist
    public void save()
    {
        this.setRegisteredAt(LocalDateTime.now());
    }
}
