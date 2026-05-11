package ie.atu.oop_project.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.Min;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Goal {
    @Id
    private Long id;

    private Long userId;

    @Min(value = 0, message = "Goal must be greater than 0")
    private Long goalTarget;

    @NotBlank(message = "Must be goal or loss")
    private String goalType;

    @NotBlank(message = "Must enter valid date")
    private LocalDate dateGoal;
}
