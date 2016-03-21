package amazon.cloudshape.core;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MemoryStoreTest {

    private static final String BUCKET_NAME = "iphone";

    @Test
    public void createBuckets() {
        DataStore store = new MemoryStore();

        Bucket bucket1 = new Bucket(BUCKET_NAME);
        store.saveBucket(bucket1);
        Bucket bucket2 = store.loadBucket(BUCKET_NAME);

        assertNotNull(bucket2);
        assertEquals(bucket1, bucket2);

        List<Bucket> buckets = store.loadBuckets();

        assertNotNull(buckets);
        assertEquals(bucket1, buckets.get(0));
    }

    @Test(expected = BucketNotFoundException.class)
    public void deleteBuckets() {
        DataStore store = new MemoryStore();

        Bucket bucket1 = new Bucket(BUCKET_NAME);
        store.saveBucket(bucket1);

        store.deleteBucket(BUCKET_NAME);
        store.loadBucket(BUCKET_NAME);
    }

    @Test
    public void createBlobs() {
        DataStore store = new MemoryStore();
        store.saveBucket(new Bucket(BUCKET_NAME));

        Blob blob1 = new Blob("sold by", "Apple");
        store.saveBlob(BUCKET_NAME, blob1);
        Blob blob2 = store.loadBlob(BUCKET_NAME, "sold by");

        assertEquals(blob1, blob2);

        List<Blob> blobs = store.loadBlobs(BUCKET_NAME);

        assertNotNull(blobs);
        assertEquals(blob1, blobs.get(0));
    }

    @Test(expected = BlobNotFoundException.class)
    public void deleteBlobs() {
        DataStore store = new MemoryStore();
        store.saveBucket(new Bucket(BUCKET_NAME));

        String key = "sold by";
        String value = "Apple";
        Blob blob1 = new Blob(key, value);
        store.saveBlob(BUCKET_NAME, blob1);

        store.deleteBlob(BUCKET_NAME, key);
        store.loadBlob(BUCKET_NAME, key);
    }
}
