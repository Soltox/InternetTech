package rocks.process.acrm.data.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rocks.process.acrm.data.domain.Player;


@Repository

public interface PlayerRepository extends JpaRepository<Player, Long> {


}
