package ch.etmles.auctionapp.Repositories;

public class ImageRepository {

    private static final String BASE_URL = "https://s3.us-west-2.amazonaws.com/les-jardiniers-du-dimanche.etml.es/";

    public static String getImageUrl(int imageNumber) {
        return BASE_URL + imageNumber + ".jpg";
    }
}
