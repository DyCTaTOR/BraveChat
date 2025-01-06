package user.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    @SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String username;

    @NotNull
    private String name;

    @NotNull
    @Column(unique = true)
    private String phone;

    @Nullable
    private String description;

    @Nullable
    private String avatar;

    @Nullable
    private String pin;

    @Nullable
    private LocalDate birthday;
}
