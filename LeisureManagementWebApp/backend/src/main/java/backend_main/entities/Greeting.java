package backend_main.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;

@Entity
public class Greeting{

    @Id
    @GeneratedValue
    @Column
    @JsonIgnore     // NOTE: setter also not called!! -> Important for @GeneratedValue
    private String id;

    @Column
    private String content;

    @Column
    private String add_content;

    public Greeting() {
    }

    @JsonProperty("Additional Content") // NOTE: this name is used in all according JSONS!! -> Serial- and Deserialization
    public void setAddContent(String add_content) {
        this.add_content = add_content;
    }

    @JsonProperty("Additional Content")
    public String getAddContent() {
        return add_content;
    }

    @JsonProperty("Content")
    public void setContent(String content) {
        this.content = content;
    }

    @JsonProperty("Content")
    public String getContent() {
        return this.content;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId() {
        return this.id;
    }
}
