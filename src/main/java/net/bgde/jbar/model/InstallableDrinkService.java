package net.bgde.jbar.model;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.stream.Stream;
import com.google.common.collect.Streams;


@Service
@Transactional
public class InstallableDrinkService {

    private final InstallableDrinkRepository installableDrinkRepository;
    private final DrinkTypeRepository drinkTypeRepository;

    public InstallableDrinkService(InstallableDrinkRepository installableDrinkRepository, DrinkTypeRepository drinkTypeRepository) {
        this.installableDrinkRepository = installableDrinkRepository;
        this.drinkTypeRepository = drinkTypeRepository;
    }

    public InstallableDrink create(String name, DrinkType type){
        if(!drinkTypeRepository.existsById(type.getName())){
            drinkTypeRepository.save(type);
        }
        InstallableDrink installableDrink = new InstallableDrink(name, type);
        return installableDrinkRepository.save(installableDrink);
    }

    public Stream<InstallableDrink> findAll(){
        return Streams.stream(installableDrinkRepository.findAll());
    }

    public Stream<InstallableDrink> findAllByType(DrinkType type){
        return Streams.stream(installableDrinkRepository.findAllByType(type));
    }
}
