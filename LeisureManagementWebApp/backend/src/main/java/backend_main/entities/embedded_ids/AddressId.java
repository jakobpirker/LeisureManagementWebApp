package backend_main.entities.embedded_ids;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
//@JsonPropertyOrder({})
public class AddressId implements Serializable {

    @JsonProperty("Strasse")
    private String street;

    @JsonProperty("Stadt")
    private String city;

    @JsonProperty("Postleitzahl")
    private Integer postalcode;

    public AddressId(){
        this.street = "";
        this.city = "";
        this.postalcode = 0;
    }

    @JsonIgnore
    public Integer getPostalCode() {
        return postalcode;
    }

    @JsonIgnore
    public String getCity() {
        return city;
    }

    @JsonIgnore
    public String getStreet() {
        return street;
    }

    @Override
    public boolean equals(Object obj){
        return (obj!=null &&
                obj instanceof AddressId &&
                postalcode.equals(((AddressId)obj).getPostalCode())  &&
                city.equals(((AddressId)obj).getCity())  &&
                street.equals(((AddressId)obj).getStreet()) );
    }

    @Override
    public int hashCode(){
        return (postalcode + city + Integer.toString(postalcode)).hashCode();
    }
}
