package LLD.lldproblems.urlshortner.repository;

import LLD.lldproblems.urlshortner.entity.UrlMapping;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUrlRepository implements IUrlRepository{
    private Map<Long, UrlMapping> db = new HashMap<>();
    private Map<String, UrlMapping> shortCodeMap = new HashMap<>();
    private long idCounter = 1;

    @Override
    public UrlMapping save(String longUrl) {
        UrlMapping urlMapping = new UrlMapping();
        urlMapping.setLongURL(longUrl);
        urlMapping.setId(this.idCounter++);
        this.db.put(urlMapping.getId(), urlMapping);
        return urlMapping;
    }

    @Override
    public UrlMapping findByShortCode(String shortCode) {
        return shortCodeMap.get(shortCode);
    }

    public void updateUrlMapping(UrlMapping urlMapping, String shortCode){
        urlMapping.setShortCode(shortCode);
        this.shortCodeMap.put(shortCode, urlMapping);
    }
}
