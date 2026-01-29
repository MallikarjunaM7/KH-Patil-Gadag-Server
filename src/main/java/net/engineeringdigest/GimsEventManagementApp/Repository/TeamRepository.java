package net.engineeringdigest.GimsEventManagementApp.Repository;

import net.engineeringdigest.GimsEventManagementApp.Entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<TeamEntity, Long>
{
}
