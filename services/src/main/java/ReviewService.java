import com.ubb.cms.Review;
import com.ubb.cms.utils.ReviewStatus;
import com.ubb.cms.utils.UserPaperEmb;

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
