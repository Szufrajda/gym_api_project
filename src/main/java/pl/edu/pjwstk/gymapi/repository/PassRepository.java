package pl.edu.pjwstk.gymapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pjwstk.gymapi.model.Pass;
import pl.edu.pjwstk.gymapi.model.enums.PassType;

import java.util.List;

@Repository
public interface PassRepository extends JpaRepository<Pass, Long> {
    List<Pass> findPassByPasstype(PassType passType);
}
