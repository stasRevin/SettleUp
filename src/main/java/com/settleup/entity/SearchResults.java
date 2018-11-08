package com.settleup.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class SearchResults {

    @JsonProperty("searchResults")
    private List<SettleUp> searchResults;
}
