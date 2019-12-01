package rocks.process.acrm.data.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rocks.process.acrm.data.domain.Match;


@Repository

public interface MatchRepository extends JpaRepository<Match, Long> {


}