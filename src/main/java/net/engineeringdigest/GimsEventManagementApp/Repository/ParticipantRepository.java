package net.engineeringdigest.GimsEventManagementApp.Repository;

import net.engineeringdigest.GimsEventManagementApp.Entity.ParticipantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<ParticipantEntity, Long> {
}
