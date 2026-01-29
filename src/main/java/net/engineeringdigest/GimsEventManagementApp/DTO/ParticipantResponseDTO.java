package net.engineeringdigest.GimsEventManagementApp.DTO;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParticipantResponseDTO {

    private Long id;
    private String fullname;
    private String phone;
    private int batch;
    private int currentYear;

}
