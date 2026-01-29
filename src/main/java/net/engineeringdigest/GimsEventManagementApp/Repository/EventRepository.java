package net.engineeringdigest.GimsEventManagementApp.Repository;

import net.engineeringdigest.GimsEventManagementApp.Entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventEntity, Long> {
}
