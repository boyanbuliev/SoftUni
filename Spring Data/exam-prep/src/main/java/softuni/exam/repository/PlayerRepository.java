package softuni.exam.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.domain.entities.Player;

import java.math.BigDecimal;
import java.util.Set;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    Player findByFirstNameAndLastName(String firstName, String lastName);

    @Query("SELECT p FROM Player p WHERE p.team.name = :team ORDER BY p.id")
    Set<Player> findAllByTeamOrderById(String team);

    @Query("SELECT p FROM Player p WHERE p.salary > :salary ORDER BY p.salary DESC")
    Set<Player> findAllBySalaryGreaterThan(BigDecimal salary);
}
