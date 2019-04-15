package web_appication.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import web_appication.model.TripItem;

import java.util.List;

public interface TripReposotory extends JpaRepository <TripItem,Integer>{

    @Query(value="select ID, TRIPID, DESCRIPTION from TRIPITEM t where TRIPID=:tripId",nativeQuery = true)
    List<TripItem> getItemsByTripId(@Param("tripId") int tripId);

}
