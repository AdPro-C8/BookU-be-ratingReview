    package id.ac.ui.cs.advprog.ratingandreview.models;

    import java.util.UUID;

import jakarta.persistence.*;

    @Entity
    @Table(
        name = "reviews",
        uniqueConstraints = @UniqueConstraint(columnNames = {"user", "book_id"})
    )
    public class Review {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "content")
        private String content;

        @Column(name = "rating")
        private int rating;

        @Column(name = "username")  // Changed from 'user' to 'username'
        private String user;

        @Column(name = "book_id", nullable = false)
        private UUID bookId;

        protected Review() {
            // JPA requires a no-arg constructor
        }

        private Review(Builder builder) {
            this.id = builder.id;
            this.content = builder.content;
            this.rating = builder.rating;
            this.user = builder.user;
            this.bookId = builder.bookId;
        }

        public static class Builder {
            private Long id;
            private String content;
            private int rating;
            private String user;
            private UUID bookId;

            public Builder() {
            }

            public Builder id(Long id) {
                this.id = id;
                return this;
            }

            public Builder content(String content) {
                this.content = content;
                return this;
            }

            public Builder rating(int rating) {
                this.rating = rating;
                return this;
            }

            public Builder user(String user) {
                this.user = user;
                return this;
            }

            public Builder bookId(UUID bookId) {
                this.bookId = bookId;
                return this;
            }

            public Review build() {
                return new Review(this);
            }
        }

        // Getters and setters
        public Long getId() {
            return id;
        }

        public String getContent() {
            return content;
        }

        public int getRating() {
            return rating;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public UUID getBookId() {
            return bookId;
        }

        public void setBookId(UUID bookId) {
            this.bookId = bookId;
        }
    }
