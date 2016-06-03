package backend_main.entities.embedded_ids;

import java.io.Serializable;

public class AddressId implements Serializable {

    private Integer postalcode;

    private String city;

    private String street;

    public Integer getPostalCode() {
        return postalcode;
    }

    public void setPostalCode(Integer postal_code_) {
        this.postalcode = postal_code_;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city_) {
        this.city = city_;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street_) {
        this.street = street_;
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
