package id.ac.ui.cs.advprog.ratingandreview.controllers;

import id.ac.ui.cs.advprog.ratingandreview.models.Review;
import id.ac.ui.cs.advprog.ratingandreview.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("review", new Review());
        return "review";
    }

    @PostMapping
    public String submitReview(Review review) {
        reviewService.saveReview(review);
        return "redirect:/reviews";
    }
}
