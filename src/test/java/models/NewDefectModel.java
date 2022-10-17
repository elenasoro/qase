package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewDefectModel {
    private String title;
    private String actualResult;
}
