package utez.edu.mx.integradoraAWOS.modules.type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeRepository extends JpaRepository<Type , Long> {

    List<Type> findAll();

    Type findById(long idType);

    Type save(Type type);

    @Modifying
    @Query(value = "DELETE FROM type WHERE id = :idType", nativeQuery = true)
    void deleteById(@Param("idType") long idType);
}
