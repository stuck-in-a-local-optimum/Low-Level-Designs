package LLD.lldproblems.urlshortner;

import LLD.lldproblems.urlshortner.service.UrlService;

public class Main {

    /*
    *  REQUIREMENTS:
    *  A. FUNCTIONAL REQUIREMENTS
    *   i. Long URL --> Short URL
    *   ii. Short URL --> Redirects to original
    *
    * B. NON-FUNCTIONAL REQUIREMENTS
    *    i. Very fast redirects (read-heavy)
    *    ii. High Availability
    *    iii. Scalable to millions/bilions of URLs
    *
    *
    * HIGH-LEVEL DESIGN
    * 1. FLOW
    *   i. create short URL
    *       - client -> POST API -> Generate Short Code -> Store -> Return short URL
    *   ii. Redirect
    *      - client -> GET API -> Lookup for mapped longURL from db --> Redirect (HTTP 302)
    *
    * CORE COMPONENTS
    *  1. Controller / API layer
    *  2. Service Layer
    *  3. Storage (DB)
    *  4. Code Generator
    *
    *
    * CRITICAL DESIGN DECISION
    * How do we generate short URL?
    *  Options:
    *       1. Hash (MD5 / SHA) ---> collision issues
    *       2. Random String ---> Collision handling needed
    *       3. Auto-increment id + Base62 encoding (as we have 62 unique chars: a-xA-Z0-9) [NO COLLISION has each unique number will have its unique base62 encoding]
    *
    * example: ID = 1000
    *       1000/62 = 16 , 1000 % 62 = 8  --> 168
    *      "168" --> g8 in base62
    * */

    public static void main(String[] args) {
        UrlService service  = new UrlService();
        String shortUrl = service.shortenUrl("https://ajeetyadav.com");

        String code = shortUrl.substring(shortUrl.lastIndexOf("/") + 1);
        String original = service.getLongUrl(code);
        System.out.println("Original URL: "+ original);
    }


}
