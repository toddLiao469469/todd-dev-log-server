package com.example.data.table

import org.jetbrains.exposed.sql.Table

object PostsTags : Table("posts_tags") {
    val postId = integer("post_id").references(Posts.id)
    val tagId = integer("tag_id").references(Tags.id)
    override val primaryKey = PrimaryKey(postId, tagId)
}
