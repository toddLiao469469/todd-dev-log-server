-- V1__Create_posts_table.sql

CREATE TABLE posts
(
    id         SERIAL PRIMARY KEY,
    title      VARCHAR(255) NOT NULL,
    content    TEXT         NOT NULL,
    author_id  INT          NOT NULL REFERENCES users (id) ON DELETE CASCADE,
    status     VARCHAR(50)  NOT NULL DEFAULT 'draft', -- 狀態: draft, published
    created_at TIMESTAMP             DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP             DEFAULT CURRENT_TIMESTAMP
);