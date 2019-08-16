package app.services;

import app.repository.StableRepository;
import app.repository.entity.Stable;
import app.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class StableService {
    private final static Logger LOGGER = Logger.getLogger(StableService.class.getName());
    @Autowired
    StableRepository repository;

    public Stable findById(Long id){
        return repository.findById(id).get();
    }

    public List<Stable> findAll(){
        List<Stable> result = null;
        try{
            LOGGER.log(Level.INFO, "Получение списка конюшен");
            result = repository.findAll();
            LOGGER.log(Level.INFO, "Список конюшен получен: {0}", Utils.toString(result));
        }catch (Exception ex){
            LOGGER.log(Level.SEVERE, "Ошибка получения списка конюшен: {0}", ex.getMessage());
        }
        return result;
    }

    public void add(Stable stable){
        try{
            LOGGER.log(Level.INFO, "Добавление конюшни");
            repository.save(stable);
            LOGGER.log(Level.INFO, "Конюшня добалена: {0}", Utils.toString(stable));
        }catch (Exception ex){
            LOGGER.log(Level.SEVERE, "Ошибка добавления конюшни: {0}", ex.getMessage());
        }
    }

    public void edit(Stable newStable){
        try{
            LOGGER.log(Level.INFO, "Обновление информации о конюшне");
            Stable oldStable = repository.findById(newStable.getId()).get();
            LOGGER.log(Level.INFO, "Старое значение: {0}", Utils.toString(oldStable));
            if (oldStable != null){
                oldStable.setName(newStable.getName());

                oldStable.getAddress().setCountry(newStable.getAddress().getCountry());
                oldStable.getAddress().setRegion(newStable.getAddress().getRegion());
                oldStable.getAddress().setCity(newStable.getAddress().getCity());
                oldStable.getAddress().setDistrict(newStable.getAddress().getDistrict());
                oldStable.getAddress().setStreet(newStable.getAddress().getStreet());
                oldStable.getAddress().setHouse(newStable.getAddress().getHouse());
                oldStable.getAddress().setLocality(newStable.getAddress().getLocality());
                oldStable.getAddress().setBuilding(newStable.getAddress().getBuilding());
                oldStable.getAddress().setHousing(newStable.getAddress().getHousing());
                oldStable.getAddress().setDescription(newStable.getAddress().getDescription());
                oldStable.getAddress().setUrl(newStable.getAddress().getUrl());

                repository.save(oldStable);
                LOGGER.log(Level.INFO, "Обновление прошло успещно новое значение: {0}", Utils.toString(oldStable));
            }
        } catch (Exception ex){
            LOGGER.log(Level.SEVERE, "Ошибка при обновлении информации о конюшне {0}", ex.getMessage());
        }
    }

    public void delete(Long id){
        try{
            LOGGER.log(Level.INFO, "Попытка удаления информации о конюшне id:{0} ", id);
            Stable stable = repository.findById(id).get();
            repository.delete(stable);
            LOGGER.log(Level.INFO, "Информация о конюшне успешно удалена: {0}", Utils.toString(stable));
        }catch (Exception ex){
            LOGGER.log(Level.SEVERE, "Ошибка удаления информации о конюшне: {0}", ex.getMessage());
        }
    }
}
