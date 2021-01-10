package entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Role {
    public final static String CLIENT = "CLIENT";
    public final static String INSPECTOR = "INSPECTOR";

    private Long id;
    private String role;
}

