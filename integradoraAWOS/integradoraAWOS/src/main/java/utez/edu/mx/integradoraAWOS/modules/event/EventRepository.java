package utez.edu.mx.integradoraAWOS.modules.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findAll();

    Event findById(long id);

    Event save(Event event);

    @Modifying @Query(value = "DELETE FROM event WHERE id = :id", nativeQuery = true)
    void deleteById(@Param("id") long id);

    //@Modifying @Query(value = "UPDATE ")
}
