
package com.kholo.FlyAway.models;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Place implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long placeId;

    private String placeName;

    public Place(Long placeId, String placeName) {
        this.placeId = placeId;
        this.placeName = placeName;
    }

  public Place() {
        
    }

    public Place(String placeName) {
        this.placeName = placeName;
    }

    public Long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }
}
