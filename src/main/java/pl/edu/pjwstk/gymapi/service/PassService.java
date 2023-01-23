package pl.edu.pjwstk.gymapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pjwstk.gymapi.model.Pass;
import pl.edu.pjwstk.gymapi.model.enums.PassType;
import pl.edu.pjwstk.gymapi.repository.PassRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PassService {
    private PassRepository passRepository;
    private ClientService clientService;

    @Autowired
    public PassService(PassRepository passRepository, ClientService clientService) {
        this.passRepository = passRepository;
        this.clientService = clientService;
    }

    public Pass createPass(Pass pass){
        return passRepository.save(pass);
    }

    public Pass updatePass(Long id, Pass updatePass){
        Pass passToUpdate = getPassById(id);

        if (updatePass.getClient() != null){
            passToUpdate.setClient(updatePass.getClient());
        }
        if (updatePass.getPasstype() != null){
            passToUpdate.setPasstype(updatePass.getPasstype());
        }
        if (updatePass.getCena() != 0){
            passToUpdate.setCena(updatePass.getCena());
        }
        return passRepository.save(passToUpdate);
    }

    public List<Pass> getPasses(){
        return passRepository.findAll();
    }

    public Pass getPassById(Long id){
        Optional<Pass> a = passRepository.findById(id);
        if (a.isPresent()){
            return a.get();
        }
        throw new IllegalArgumentException();
    }

    public void deletePassById(Long id){
        passRepository.deleteById(id);
    }

    public List<Pass> findPassesByPassType(PassType passType){
        return passRepository.findPassByPasstype(passType);
    }
}
