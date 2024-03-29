package rocks.process.acrm.data.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rocks.process.acrm.data.domain.Player;
import rocks.process.acrm.data.domain.Team;


@Repository

public interface TeamRepository extends JpaRepository<Team, Long> {

Team findOneTeamById(Long id);
}