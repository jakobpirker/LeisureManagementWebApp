package backend_main.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;

@Entity
public class Greeting {

    @Id
    @GeneratedValue
    @Column
    @JsonIgnore     // NOTE: setter also not called!! -> Important for @GeneratedValue
    private Long id;

    @Column
    private String content;

    @Column
    private String add_content;

//    @Column
//    private String number;

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

//    @JsonProperty("Number")
//    public String getNumber() {
//        return number;
//    }
//
//    @JsonProperty("Number")
//    public void setNumber(String number) {
//        this.number = number;
//    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
}
