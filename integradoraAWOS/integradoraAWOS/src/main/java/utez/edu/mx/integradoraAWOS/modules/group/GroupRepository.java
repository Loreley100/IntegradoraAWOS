package utez.edu.mx.integradoraAWOS.modules.group;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    List<Group> findAll();

    Group findById(long id);

    Group save(Group group);

    @Modifying
    @Query(value = "DELETE FROM group WHERE id = :id", nativeQuery = true)
    void deleteById(@Param("id") long id);
}
