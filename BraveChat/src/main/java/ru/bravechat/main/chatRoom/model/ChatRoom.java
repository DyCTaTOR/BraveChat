package ru.bravechat.main.chatRoom.model;

import ru.bravechat.main.chat.model.Chat;
import ru.bravechat.main.chatRoom.enums.ChatRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.bravechat.main.message.model.Message;
import ru.bravechat.main.user.model.AppUser;

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
    private AppUser user;

    @ManyToOne
    private Chat chat;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ChatRole role;
}
