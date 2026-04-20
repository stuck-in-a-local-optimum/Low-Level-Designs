package LLD.lldproblems.urlshortner.service;

import LLD.lldproblems.urlshortner.entity.UrlMapping;
import LLD.lldproblems.urlshortner.repository.IUrlRepository;
import LLD.lldproblems.urlshortner.repository.InMemoryUrlRepository;

public class UrlService {
    private InMemoryUrlRepository urlRepository;
    private Base62Encoder base62Encoder;

    public UrlService(){
        this.urlRepository = new InMemoryUrlRepository();
        this.base62Encoder = new Base62Encoder();
    }

    public String shortenUrl(String longUrl){
        UrlMapping mapping = urlRepository.save(longUrl);

        String shortCode = base62Encoder.encode(mapping.getId());
        urlRepository.updateUrlMapping(mapping, shortCode);
        return "https://myshort.url/" + shortCode;

    }

    public String getLongUrl(String shortCode){
        UrlMapping mapping = urlRepository.findByShortCode(shortCode);

        if(mapping == null){
            throw  new RuntimeException("URL not found");
        }
        return mapping.getLongURL();
    }
}
