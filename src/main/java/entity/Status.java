package entity;

import lombok.*;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class Status {
    public final static String ACCEPT = "ACCEPT";
    public final static String UNCHECKED = "VERIFY";
    public final static String NOT_ACCEPTED = "REFUSE";

    private Long id;
    private String name;
}
