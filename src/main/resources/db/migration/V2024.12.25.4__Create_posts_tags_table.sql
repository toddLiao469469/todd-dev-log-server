-- V1__Create_posts_tags_table.sql

CREATE TABLE posts_tags
(
    post_id    INT NOT NULL REFERENCES posts (id) ON DELETE CASCADE,
    tag_id     INT NOT NULL REFERENCES tags (id) ON DELETE CASCADE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)
