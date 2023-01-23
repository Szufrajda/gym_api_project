package pl.edu.pjwstk.gymapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pjwstk.gymapi.model.Equipment;
import pl.edu.pjwstk.gymapi.model.enums.ExerciseType;

import java.util.Optional;

public interface EquipmentsRepository extends JpaRepository<Equipment, Long> {
    Optional<Equipment> findEquipmentByNameAndExerciseType(String name, ExerciseType exerciseType);
    Equipment findEquipmentByName(String name);
}
