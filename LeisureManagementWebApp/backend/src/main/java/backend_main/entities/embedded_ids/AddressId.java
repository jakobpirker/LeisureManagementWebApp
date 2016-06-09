package backend_main.entities.embedded_ids;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
//@JsonPropertyOrder({})
public class AddressId implements Serializable {

    private String street;
    private String city;
    private Integer postalcode;

    public AddressId(){
        this.street = "";
        this.city = "";
        this.postalcode = 0;
    }

    @JsonProperty("Postleitzahl")
    public Integer getPostalCode() {
        return postalcode;
    }

    @JsonProperty("Stadt")
    public String getCity() {
        return city;
    }

    @JsonProperty("Strasse")
    public String getStreet() {
        return street;
    }

    @JsonProperty("Strasse")
    public void setStreet(String street) {
        this.street = street;
    }

    @JsonProperty("Stadt")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("Postleitzahl")
    public void setPostalcode(Integer postalcode) {
        this.postalcode = postalcode;
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
