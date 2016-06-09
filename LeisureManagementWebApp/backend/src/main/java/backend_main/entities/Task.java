package backend_main.entities;

import backend_main.entities.embedded_ids.PersonId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Task {

    @Id
    @JsonProperty("Beschreibung")
    private String id;

    @JsonProperty("Materialien")
    private String materials;

    @ManyToOne
    @JsonIgnore
    private Staff staff;

    public Task() {
        this.id = "";
        this.materials = "";
        this.staff = null;
    }

    @JsonIgnore
    public Staff getStaff() {
        return staff;
    }

    @JsonIgnore
    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    //---------------------------------------------------------------
    // serial- and deserializing specific content

    @JsonIgnore
    @Transient
    ObjectMapper mapper = new ObjectMapper();

    @Transient
    @JsonIgnore
    private PersonId staff_id;

    @JsonProperty("Mitarbeiter")
    public PersonId getStaffJson() {
        if(this.staff != null)
        {
            return this.staff.getId();
        }
        else
        {
            return null;
        }
    }

    @JsonProperty("Mitarbeiter")
    public void setStaffId(String id_string) throws Exception {
        if(id_string != null) {
            this.staff_id = mapper.readValue(id_string, PersonId.class);
        }
        else {
            this.staff_id = null;
        }
    }

    @JsonIgnore
    public PersonId getStaffId(){
        return this.staff_id;
    }
}
