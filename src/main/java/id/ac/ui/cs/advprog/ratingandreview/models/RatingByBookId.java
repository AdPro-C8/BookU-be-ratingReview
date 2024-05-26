package id.ac.ui.cs.advprog.ratingandreview.models;

import java.util.UUID;

public interface RatingByBookId {
    UUID getBookId();
    float getAverageRating();
}
