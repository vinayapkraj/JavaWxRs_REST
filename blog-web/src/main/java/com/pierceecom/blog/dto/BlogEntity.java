package com.pierceecom.blog.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@JsonPropertyOrder({ "id", "title", "content" })
@RequiredArgsConstructor
@Table
@Entity
public class BlogEntity {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @NotBlank(message = "Title of blog is required")
    private String title;

    @NotBlank(message = "Content of blog is required")
    private String content;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BlogEntity that = (BlogEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}