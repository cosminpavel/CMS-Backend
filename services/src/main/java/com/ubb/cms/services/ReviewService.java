package com.ubb.cms.services;

import com.ubb.cms.model.Review;
import com.ubb.cms.model.utils.ReviewStatus;
import com.ubb.cms.model.utils.UserPaperEmb;
import com.ubb.cms.repository.ReviewRepository;

import java.util.List;

/**
 * Created by nascasergiualin on 03/05/2017.
 */
public class ReviewService
{
    private ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository)
    {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getAll()
    {
        return reviewRepository.getAll();
    }

    public void addReview(UserPaperEmb user_paper, ReviewStatus status, String comment)
    {
        reviewRepository.add(new Review(user_paper, status, comment));
    }

    public void deleteUser(int key)
    {
        reviewRepository.delete(key);
    }

    public Review findById(int key)
    {
        return reviewRepository.findById(key);
    }
}
