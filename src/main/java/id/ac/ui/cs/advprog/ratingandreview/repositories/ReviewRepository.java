package id.ac.ui.cs.advprog.ratingandreview.repositories;

import id.ac.ui.cs.advprog.ratingandreview.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}