CREATE TABLE app_user (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(30) NOT NULL UNIQUE,
    name VARCHAR(25) NOT NULL,
    phone VARCHAR(12) NOT NULL UNIQUE,
    description TEXT,
    avatar VARCHAR(255),
    pin VARCHAR(4)
);

CREATE TABLE chat (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(25),
    type VARCHAR(20) NOT NULL,
    date_create TIMESTAMP NOT NULL
);

CREATE TABLE chat_room (
    user_id BIGINT NOT NULL,
    chat_id BIGINT NOT NULL,
    role VARCHAR(25),
    PRIMARY KEY (user_id, chat_id),
    FOREIGN KEY (user_id) REFERENCES app_user(id) ON DELETE CASCADE,
    FOREIGN KEY (chat_id) REFERENCES chat(id) ON DELETE CASCADE
);

CREATE TABLE message (
    id BIGSERIAL PRIMARY KEY,
    chat_id BIGINT NOT NULL,
    sender_id BIGINT NOT NULL,
    recipient_id BIGINT NOT NULL,
    message TEXT NOT NULL,
    date_sender TIMESTAMP,
    read_it BOOLEAN DEFAULT FALSE,
    file VARCHAR(255),
    FOREIGN KEY (chat_id) REFERENCES chat(id) ON DELETE CASCADE
);