package softuni.exam.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.domain.entities.Player;

import java.math.BigDecimal;
import java.util.Set;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    Player findByFirstNameAndLastName(String firstName, String lastName);

//    @Query("SELECT p FROM Player p WHERE p.team.name = :team")
Set<Player> findAllByTeamName(String team);

    //    @Query("SELECT p FROM Player p WHERE p.salary > :salary ORDER BY p.salary DESC")
    Set<Player> findAllBySalaryIsGreaterThanOrderBySalaryDesc(BigDecimal salary);
}
