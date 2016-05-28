package backend_main.utils;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Jakob on 28.05.2016.
 */
public class JavaScriptEntityLink {

    private String label_;
    private String entity_url_;
    private String list_url_;

    public JavaScriptEntityLink(String label, String entity_url, String list_url)
    {
        this.label_ = label;
        this.list_url_ = list_url;
        this.entity_url_ = entity_url;
    }

    @JsonProperty("label")
    public String getLabel() {
        return label_;
    }

    @JsonProperty("label")
    public void setLabel(String label_) {
        this.label_ = label_;
    }

    @JsonProperty("entity_url")
    public String getEntityUrl() {
        return entity_url_;
    }

    @JsonProperty("entity_url")
    public void setEntityUrl(String entity_url_) {
        this.entity_url_ = entity_url_;
    }

    @JsonProperty("list_url")
    public String getListUrl() {
        return list_url_;
    }

    @JsonProperty("list_url")
    public void setListUrl(String list_url_) {
        this.list_url_ = list_url_;
    }
}
