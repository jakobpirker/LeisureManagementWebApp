package backend_main.entities;

import backend_main.entities.embedded_ids.AddressId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;

@Entity
public class Accommodation {

    @Id
    @JsonProperty("Unterkunft")
    private String id;

    @JsonProperty("Zimmer")
    private String room;

    @OneToOne
    private Address address;

    @OneToOne(mappedBy = "accommodation", cascade=CascadeType.ALL)
    @JsonIgnore
    private Participant participant;

    public Accommodation(){
        this.id = "";
        this.room = "";
        this.address = null;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    public String getId() {return this.id; }

    //---------------------------------------------------------------
    // serial- and deserializing specific content

    @Transient
    @JsonIgnore
    private AddressId address_id;

    @JsonIgnore
    @Transient
    ObjectMapper mapper = new ObjectMapper();

    @JsonProperty("Adresse")
    public AddressId getAddress() {
        if(this.address != null)
        {
            return this.address.getId();
        }
        else
        {
            return null;
        }
    }

    @JsonProperty("Adresse")
    public void setAddressId(String id_string) throws Exception {
        if(id_string != null) {
            this.address_id = mapper.readValue(id_string, AddressId.class);
        }
        else {
            this.address_id = null;
        }
    }

    public AddressId getAddressId(){
        return this.address_id;
    }
}
