package id.ac.ui.cs.advprog.ratingandreview.services;

import id.ac.ui.cs.advprog.ratingandreview.dto.ReviewFormData;
import id.ac.ui.cs.advprog.ratingandreview.models.Review;
import id.ac.ui.cs.advprog.ratingandreview.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }
    public Optional<Review> findReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    public List<Review> findAllReviews() {
        return reviewRepository.findAll();
    }

}