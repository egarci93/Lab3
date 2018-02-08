import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {
    public static void main (String[] unused) {
        String webName = "http://tgftp.nws.noaa.gov/data/raw/fz/fzus53.klot.srf.lot.txt";
        String webPage = urlToString(webName);
        String[] a = webPage.split( "\\S+"); // "\\S+" counts all spaces.
        System.out.println(a.length);

    }
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        }catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
}
