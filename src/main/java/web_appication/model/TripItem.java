package web_appication.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@ApiModel(value = "tripItem", description = "Entity of trip item, will be an abstract class to inherit of")
@Table(name = "TRIPITEM")
//@NoArgsConstructor
//@AllArgsConstructor
//@Setter
//@Getter
//@ToString(exclude = "id")
@Entity
public class TripItem {

    @ApiModelProperty
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID",unique = true,updatable = false, nullable = false)
    private int id;

    @ApiModelProperty(notes = "id of a trip, that tripItem belongs to")
    @Column(name = "TRIPID", nullable = false,updatable = false)
    private int tripId;

    @ApiModelProperty(notes = "desctription of a tripItem")
    @Column(name = "DESCRIPTION")
    private String description;

    public TripItem(int tripId, String description) {
        this.tripId = tripId;
        this.description = description;
    }

    public TripItem() {
    }

    public TripItem(int id, int tripId, String description) {
        this.id = id;
        this.tripId = tripId;
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public int getTripId() {
        return tripId;
    }

    public String getDescription() {
        return description;
    }

}
