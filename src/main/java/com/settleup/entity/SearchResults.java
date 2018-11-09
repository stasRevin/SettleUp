package com.settleup.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "searchResults")
@Data
public class SearchResults {

    @JsonProperty("searchResults")
    private List<SettleUp> searchResults;

}
