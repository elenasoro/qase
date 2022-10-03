package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewSuiteModel {
    private String name;
    private String description;
    private String preconditions;
}
