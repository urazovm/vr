package ru.vashrekrut.util;

import ru.vashrekrut.enums.CacheItemKey;
import ru.vashrekrut.domain.DomainObject;
import ru.vashrekrut.domain.examination.Answer;
import ru.vashrekrut.domain.examination.Examination;
import ru.vashrekrut.domain.examination.Question;
import ru.vashrekrut.domain.user.User;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by root on 9/10/16.
 */
public class CacheUtil {
    private CacheUtil() {}

    private static ConcurrentMap<CacheItemKey, List<DomainObject>> cache = new ConcurrentHashMap<>();

    public static void updateCache(CacheItemKey type, List objectsList) {
        cache.putIfAbsent(type, objectsList);
    }

    public static List getEntry(CacheItemKey key) {
        return cache.get(key);
    }

    public static DomainObject getEntryValue(CacheItemKey key, UUID itemId) {
        return cache.get(key).parallelStream().filter(
                baseModel -> baseModel.getId().equals(itemId)).findFirst().orElse(null);
    }

    public static void addToCache(CacheItemKey key, final DomainObject item) {
        if ((key == CacheItemKey.EXAMINATIONS && item instanceof Examination) ||
                (key == CacheItemKey.QUESTIONS && item instanceof Question) ||
                (key == CacheItemKey.ANSWERES && item instanceof Answer) ||
                (key == CacheItemKey.ACCOUNT && item instanceof User))
            cache.get(key).add(item);
        else
            throw new IllegalArgumentException("Value object's class is not appropriate to key");
    }

    public static void updateCacheValue(CacheItemKey key, final DomainObject item) {
        if ((key == CacheItemKey.EXAMINATIONS && item instanceof Examination) ||
                (key == CacheItemKey.QUESTIONS && item instanceof Question) ||
                (key == CacheItemKey.ANSWERES && item instanceof Answer) ||
                (key == CacheItemKey.ACCOUNT && item instanceof User))
            cache.get(key).parallelStream().forEach(o -> {
                if (o.getId().equals(item.getId())) {
                    o = item;
                }
            });
        else
            throw new IllegalArgumentException("Value object's class is not appropriate to key");
    }

    public static void removeFromCache(CacheItemKey key, final UUID itemId) {
        cache.get(key).removeIf(o -> o.getId().equals(itemId));
    }
}
