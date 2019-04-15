package web_appication.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web_appication.model.TripItem;
import web_appication.services.TripListService;

import java.util.List;

@Api(tags = "tripItemController")
@RestController
public class tripItemController {

    @Autowired
    private TripListService tripListService;

    @ApiOperation( "добавление tripItem")
    @PostMapping("/tripItem/add/{tripId}/{description}")
    public ResponseEntity addTripItem(@PathVariable("tripId") int tripId, @PathVariable String description){
        tripListService.addTripItem(new TripItem(tripId,description));
        return ResponseEntity.ok().body("Trip Item "+description+" has been added to the trip №"+tripId);
    }

    @ApiOperation("получение всего списка tripItem")
    @GetMapping("/tripItem/getAll")
    public List<TripItem> getAllTripItems(){
            return tripListService.getTripList();}

    @GetMapping("/tripItem/getByTripId/{tripId}")
    @ApiOperation("получение списка tripItem для конкретного tripId")
    public List<TripItem> getTripItemsByTripId(@PathVariable("tripId") int tripId){
            return tripListService.getTripList(tripId);
        }

     @ApiOperation("удаление TripItem")
     @DeleteMapping("/tripItem/deleteTripItem/{id}")
    public ResponseEntity deleteTripItem(@PathVariable("id") int id) {
         try {
             tripListService.deleteTripItem(id);
         } catch (IllegalArgumentException e) {
             return ResponseEntity.ok().body(e.getMessage());
         }
         return ResponseEntity.ok().body("TripItem " + id + " has been deleted");
     }


     @ApiOperation("перенос изменений в базу")
     @GetMapping("/tripItem/commitAllTripItemChanges")
     public ResponseEntity commitAllTripItemChanges(){
        tripListService.commitTripChanges();
        return ResponseEntity.ok().body("Changes have been commited");
     }
}
