package entity;


import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Report {
    private Long id;
    private String report;
    private String comment;
    private String nameOfReport;
    private LocalDateTime createdDate;
    private Status status;
    private User user;
}
