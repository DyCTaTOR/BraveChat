package chatRoom.model;

import chatRoom.enums.ChatRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import message.model.Message;
import user.model.AppUser;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "chat_room_id_seq")
    @SequenceGenerator(name = "chat_room_id_seq", sequenceName = "chat_room_id_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    private AppUser appUser;

    @ManyToOne
    private Message message;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ChatRole role;
}
