import scraper.CacheScraper;
import scraper.DefaultScraper;
import scraper.Home;
import scraper.Scraper;

public class Main {
    public static void main(String[] args) {
        String url = "https://www.newhomesource.com/specdetail/130-victoria-peak-loop-dripping-springs-tx-78620/2108550";
//        String url = "localhost";
        Scraper scraper = new CacheScraper();
        Home home = scraper.scrape(url);
        System.out.println(home);
    }
}