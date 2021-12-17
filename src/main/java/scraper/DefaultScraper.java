package scraper;

import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class DefaultScraper implements Scraper {

    private static final String PRICE_SELECTOR = ".detail__info-xlrg";
    private static final String BEDROOMS_SELECTOR = ".nhs_BedsInfo";
    private static final String BATHROOMS_SELECTOR = ".nhs_BathsInfo";
    private static final String GARAGE_SELECTOR = ".nhs_GarageInfo";

    @Override@SneakyThrows

    public Home scrape(String url) {
        Document doc = Jsoup.connect(url).get();
        int price = getPrice(doc);
        double bedrooms = getBedrooms(doc);
        double bathrooms = getBathrooms(doc);
        double garages = getGarages(doc);
        return new Home(price, bedrooms, bathrooms, garages);
    }

    private int getPrice(Document doc) {
        String price = doc.selectFirst(PRICE_SELECTOR).text().replaceAll("[^0-9]", "");
        return Integer.parseInt(price);
    }

    private double getBedrooms(Document doc) {
        String beds = doc.selectFirst(BEDROOMS_SELECTOR).text().replaceAll("BR", "");
//        System.out.println(beds);
        return Double.parseDouble(beds);
    }

    private double getBathrooms(Document doc) {
        String baths = doc.selectFirst(BATHROOMS_SELECTOR).text().replaceAll("BA", "");
//        System.out.println(baths);
        return Double.parseDouble(baths);
    }

    private double getGarages(Document doc) {
        String garage = doc.selectFirst(GARAGE_SELECTOR).text().replaceAll("GR", "");
//        System.out.println(garage);
        return Double.parseDouble(garage);
    }
}
