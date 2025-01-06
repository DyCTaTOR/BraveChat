package chatRoom.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ChatRole {
    ADMIN("Admin"),
    MODERATOR("Moderator"),
    PARTICIPANT("Participant");

    private String label;
}
