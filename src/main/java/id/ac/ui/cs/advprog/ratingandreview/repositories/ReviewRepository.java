package id.ac.ui.cs.advprog.ratingandreview.repositories;

import id.ac.ui.cs.advprog.ratingandreview.models.Review;
import id.ac.ui.cs.advprog.ratingandreview.models.RatingByBookId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    // No need to define save(), it’s provided by JpaRepository
    List<Review> findByUser(String user);

    @Query("SELECT r.bookId as bookId, AVG(r.rating) as averageRating FROM Review r GROUP BY bookId")
    List<RatingByBookId> findByGroupByBookId();

    @Query("SELECT r.bookId as bookId, AVG(r.rating) as averageRating FROM Review r GROUP BY bookId ORDER BY averageRating ASC")
    List<RatingByBookId> findByGroupByBookIdOrderByAsc();

    @Query("SELECT r.bookId as bookId, AVG(r.rating) as averageRating FROM Review r GROUP BY bookId ORDER BY averageRating DESC")
    List<RatingByBookId> findByGroupByBookIdOrderByDesc();
}
