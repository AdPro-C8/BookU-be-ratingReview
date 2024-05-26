package id.ac.ui.cs.advprog.ratingandreview.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

public class ReviewTest {

    @Test
    public void testBuilderAndGetters() {
        UUID bookId = UUID.randomUUID();
        Review review = new Review.Builder()
                .id(1L)
                .content("Excellent read!")
                .rating(5)
                .user("user123")
                .bookId(bookId)
                .build();

        // Assert that all getters retrieve the correct data set by the builder
        assertEquals(1L, review.getId());
        assertEquals("Excellent read!", review.getContent());
        assertEquals(5, review.getRating());
        assertEquals("user123", review.getUser());
        assertEquals(bookId, review.getBookId());
    }

    @Test
    public void testSettersWhereApplicable() {
        UUID bookId = UUID.randomUUID();
        Review review = new Review.Builder()
                .user("initialUser")
                .build();

        // Using the available setter methods
        review.setUser("user456");
        review.setBookId(bookId);

        // Assert the setter changes
        assertEquals("user456", review.getUser());
        assertEquals(bookId, review.getBookId());
    }
}
