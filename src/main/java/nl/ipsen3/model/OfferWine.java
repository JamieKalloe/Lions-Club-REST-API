
package nl.ipsen3.model;

import com.fasterxml.jackson.annotation.JsonView;
import java.util.Date;
import nl.ipsen3.View;

/**
 *
 * @author Philip
 * @since 25-01-16
 */
public class OfferWine {
        
    @JsonView(View.Public.class)
    private int id, wineId, offerId;
    
    public OfferWine(){}
    
    public int getId() {
        return id;
    }
    
    public int getOfferId() {
        return offerId;
    }

    public int getWineId() {
        return wineId;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }
     
    public void setWineId(int wineId) {
        this.wineId = wineId;
    }
}
