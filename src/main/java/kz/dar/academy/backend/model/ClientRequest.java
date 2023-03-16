package kz.dar.academy.backend.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequest {
    @NotNull(message = "ClientId can't be empty")
    private String clientId;
    private String name;
    private String surname;
    private String email;
}
