package entity;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    private Long id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String email;
    private String password;

    private Role role;

}
