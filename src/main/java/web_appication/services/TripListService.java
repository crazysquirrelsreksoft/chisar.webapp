package web_appication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web_appication.model.TripItem;
import web_appication.repositories.TripReposotory;

import java.util.List;

@Service
public class TripListService {

    @Autowired
    private TripReposotory tripReposotory;

public long addTripItem(TripItem tripItem){
    tripItem=tripReposotory.save(tripItem);
    return tripItem.getId();
}

public List<TripItem> getTripList (){
   return tripReposotory.findAll(); //  добавить сортировку по дате
}

public List<TripItem> getTripList(int tripId){
    return tripReposotory.getItemsByTripId(tripId);
}

public  void deleteTripItem(int id){tripReposotory.deleteById(id);}

public void commitTripChanges(){tripReposotory.flush();}

}
