package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewMemberModel {
    private String email;
    private String name;
    private String role;
}
