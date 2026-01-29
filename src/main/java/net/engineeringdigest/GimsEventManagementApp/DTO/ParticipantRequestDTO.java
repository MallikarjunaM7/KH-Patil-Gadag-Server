package net.engineeringdigest.GimsEventManagementApp.DTO;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParticipantRequestDTO {

    private String fullName;
    private String phone;
    private int batch;
    private int currentYear;
}
