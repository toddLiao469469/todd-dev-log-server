package com.example.infrastructure.repo

import com.example.data.table.Posts
import com.example.data.table.PostsTags
import com.example.data.table.Tags
import com.example.domain.model.PostWithTags
import kotlinx.datetime.toKotlinLocalDateTime
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

class PostRepo {
    fun getAllPosts(): List<PostWithTags> =
        transaction {
            val posts =
                Posts.selectAll()
                    .map { row ->
                        row[Posts.id] to PostWithTags(
                            id = row[Posts.id],
                            content = row[Posts.content],
                            createdAt = row[Posts.createdAt].toKotlinLocalDateTime(),
                            updatedAt = row[Posts.updatedAt].toKotlinLocalDateTime(),
                            tags = emptyList(),
                        )
                    }.toMap()


            val tagsMap = PostsTags
                .join(
                    Tags,
                    JoinType.INNER,
                    additionalConstraint = { PostsTags.tagId eq Tags.id },
                )
                .selectAll()
                .groupBy(
                    keySelector = { it[PostsTags.postId] },
                    valueTransform = { it[Tags.name] },
                )



            posts.values
                .map { post ->
                    post.copy(tags = tagsMap[post.id] ?: emptyList())
                }
        }

    fun insertPost(content: String) {
        transaction {
            Posts.insert {
                it[Posts.content] = content
            }
        }
    }
}
