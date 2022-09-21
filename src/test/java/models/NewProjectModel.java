package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewProjectModel {
    private String name;
    private String code;
    private String description;
}
