package net.engineeringdigest.GimsEventManagementApp.Exception;

import net.engineeringdigest.GimsEventManagementApp.DTO.ApiResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateEntryException.class)
    public ResponseEntity<ApiResponseDTO> handleDuplicateEntryException(DuplicateEntryException ex)
    {
        ApiResponseDTO apiResponseDTO = new ApiResponseDTO(false, "Duplicate Entry", ex.getMessage());
        return ResponseEntity.badRequest().body(apiResponseDTO);
    }
}
