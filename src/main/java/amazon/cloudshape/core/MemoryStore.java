package amazon.cloudshape.core;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


/**
 * Volatile storage that maintains all data in memory.
 */
public class MemoryStore implements DataStore {

    private final ConcurrentMap<String, Map<String, String>> objects = new ConcurrentHashMap<>();

    @Override
    public Bucket loadBucket(String bucketName) {
        if (objects.containsKey(bucketName)) {
            return new Bucket(bucketName);
        } else {
            throw new BucketNotFoundException();
        }
    }

    @Override
    public List<Bucket> loadBuckets() {
        List<Bucket> result = new ArrayList<>();
        for (String key : objects.keySet()) {
            result.add(new Bucket(key));
        }
        return result;
    }

    @Override
    public void saveBucket(Bucket bucket) {
        objects.putIfAbsent(bucket.getName(), new HashMap<String, String>());
    }

    @Override
    public void deleteBucket(String bucketName) {
        objects.remove(bucketName);
    }

    @Override
    public Blob loadBlob(String bucketName, String blobKey) {
        Map<String, String> blobs = objects.get(bucketName);

        if (blobs != null) {
            String blobValue = blobs.get(blobKey);

            if (blobValue != null) {
                return new Blob(blobKey, blobValue);
            }
        }

        throw new BlobNotFoundException();
    }

    @Override
    public List<Blob> loadBlobs(String bucketName) {
        if (objects.containsKey(bucketName)) {
            List<Blob> result = new ArrayList<>();
            for (Map.Entry<String, String> entry : objects.get(bucketName).entrySet()) {
                result.add(new Blob(entry.getKey(), entry.getValue()));
            }
            return result;
        } else {
            throw new BucketNotFoundException();
        }
    }

    @Override
    public void saveBlob(String bucketName, Blob blob) {
        if (objects.containsKey(bucketName)) {
            objects.get(bucketName).put(blob.getKey(), blob.getValue());
        } else {
            throw new BucketNotFoundException();
        }
    }

    @Override
    public void deleteBlob(String bucketName, String blobKey) {
        if (objects.containsKey(bucketName)) {
            objects.get(bucketName).remove(blobKey);
        } else {
            throw new BucketNotFoundException();
        }
    }
}
