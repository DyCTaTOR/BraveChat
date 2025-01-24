package ru.bravechat.main.chat.model;

import ru.bravechat.main.chat.enums.ChatType;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "chat_id_seq")
    @SequenceGenerator(name = "chat_id_seq", sequenceName = "chat_id_seq", allocationSize = 1)
    private Long id;

    @Nullable
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ChatType type;

    @NotNull
    private LocalDateTime dateCreate;
}
