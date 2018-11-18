package com.settleup.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "searchResults")
@Data
/**
 * This is the SearchResults class designed to store the results of the apartment search.
 * @author srevin
 */
public class SearchResults {

    @JsonProperty("searchResults")
    private List<SettleUp> searchResults;

}
