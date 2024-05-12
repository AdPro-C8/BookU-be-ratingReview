package id.ac.ui.cs.advprog.ratingandreview.repositories;

import id.ac.ui.cs.advprog.ratingandreview.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    // No need to define save(), it’s provided by JpaRepository
    List<Review> findByUser(String user);
}
