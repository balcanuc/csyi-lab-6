package amazon.cloudshape.rest;

import amazon.cloudshape.core.Blob;
import amazon.cloudshape.core.Bucket;
import amazon.cloudshape.core.DataStore;
import amazon.cloudshape.core.MemoryStore;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Defines the mapping between application components and REST verbs/paths.
 */
@RestController
public class ServiceController {

    private final DataStore store = new MemoryStore();

    @RequestMapping(value = "/buckets/{name}", method = RequestMethod.GET)
    public Bucket bucket(@PathVariable("name") String bucketName) {
        return store.loadBucket(bucketName);
    }

    @RequestMapping(value = "/buckets", method = RequestMethod.GET)
    public List<Bucket> buckets() {
        return store.loadBuckets();
    }

    @RequestMapping(value = "/buckets", method = RequestMethod.POST)
    public void newBucket(@RequestParam(value = "name") String bucketName) {
        store.saveBucket(new Bucket(bucketName));
    }

    @RequestMapping(value = "/buckets/{name}", method = RequestMethod.DELETE)
    public void deleteBucket(@PathVariable(value = "name") String bucketName) {
        store.deleteBucket(bucketName);
    }

    @RequestMapping(value = "/buckets/{name}/blobs/{key}", method = RequestMethod.GET)
    public Blob blob(@PathVariable("name") String bucketName,
                     @PathVariable("key") String bucketKey) {
        return store.loadBlob(bucketName, bucketKey);
    }

    @RequestMapping(value = "/buckets/{name}/blobs", method = RequestMethod.GET)
    public List<Blob> blobs(@PathVariable("name") String bucketName) {
        return store.loadBlobs(bucketName);
    }

    @RequestMapping(value = "/buckets/{name}/blobs", method = RequestMethod.POST)
    public void newBlob(@PathVariable("name") String bucketName,
                        @RequestParam(value = "key") String blobKey,
                        @RequestParam(value = "value") String blobValue) {
        store.saveBlob(bucketName, new Blob(blobKey, blobValue));
    }

    @RequestMapping(value = "/buckets/{name}/blobs/{key}", method = RequestMethod.DELETE)
    public void deleteBlob(@PathVariable("name") String bucketName,
                           @PathVariable("key") String blobKey) {
        store.deleteBlob(bucketName, blobKey);
    }
}
