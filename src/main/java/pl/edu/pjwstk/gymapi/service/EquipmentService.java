package pl.edu.pjwstk.gymapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pjwstk.gymapi.model.Equipment;
import pl.edu.pjwstk.gymapi.model.enums.ExerciseType;
import pl.edu.pjwstk.gymapi.repository.EquipmentsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentService {
    private EquipmentsRepository equipmentsRepository;

    @Autowired
    public EquipmentService(EquipmentsRepository equipmentsRepository){
        this.equipmentsRepository = equipmentsRepository;
    }

    public Equipment createEquipment(Equipment equipment){
        return equipmentsRepository.save(equipment);
    }

    public Equipment findByNameAndExerciseType(String name, ExerciseType exerciseType){
        Optional<Equipment> equipment = equipmentsRepository.findEquipmentByNameAndExerciseType(name, exerciseType);
        if(equipment.isPresent()){
            return equipment.get();
        }
        throw new IllegalArgumentException();
    }

    public List<Equipment> getAllEquipments(){
        return equipmentsRepository.findAll();
    }

    public Equipment getEquipmentById(Long id){
        return equipmentsRepository.getReferenceById(id);
    }

    public void deleteEquipmentById(Long id){
        equipmentsRepository.deleteById(id);
    }
}
