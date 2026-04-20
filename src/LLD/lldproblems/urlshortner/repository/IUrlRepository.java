package LLD.lldproblems.urlshortner.repository;

import LLD.lldproblems.urlshortner.entity.UrlMapping;

public interface IUrlRepository {

    UrlMapping save(String longUrl);
    UrlMapping findByShortCode(String shortCode);
}
