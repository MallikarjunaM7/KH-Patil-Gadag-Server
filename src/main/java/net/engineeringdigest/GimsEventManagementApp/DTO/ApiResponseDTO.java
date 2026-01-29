package net.engineeringdigest.GimsEventManagementApp.DTO;

import lombok.Data;

@Data
public class ApiResponseDTO {

    boolean success;
    String message;
    Object data;

    public ApiResponseDTO(boolean success, String message, Object data)
    {
        this.success = success;
        this.message = message;
        this.data = data;
    }
}
