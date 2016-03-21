package amazon.cloudshape.core;

import java.util.List;

/**
 * Defines a basic storage for both buckets and blobs.
 */
public interface DataStore {

    Bucket loadBucket(String bucketName);

    List<Bucket> loadBuckets();

    void saveBucket(Bucket bucket);

    void deleteBucket(String bucketName);

    Blob loadBlob(String bucketName, String blobKey);

    List<Blob> loadBlobs(String bucketName);

    void saveBlob(String bucketName, Blob blob);

    void deleteBlob(String bucketName, String blobKey);
}
