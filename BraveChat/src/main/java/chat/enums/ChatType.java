package chat.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ChatType {
    PERSONAL("Personal"),
    DIALOG("Dialog"),
    GROUP_CHAT("GroupChat");

    private String label;
}
