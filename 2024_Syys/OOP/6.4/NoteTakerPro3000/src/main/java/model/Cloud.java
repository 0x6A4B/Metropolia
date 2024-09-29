package model;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Date;
import java.util.UUID;

/*
        It seems AWS has deprecated this SDK and changed it, I'm not doing this again we'll just use
        this old SDK for this project... :( kick a bucket AWS!
 */

// We'll just put these API keys here, this is just a little assignment in school and not production anyway
public class Cloud {
    private final String token = "67jvXGdHu6-kR2Q40kJT1Wx8H9sofcqMgpuALY87";
    private UUID systemId;
    private final String accessKey = "30d03e7bdbd3281d9f357e1d6b429a3a";
    private final String secretKey = "a525589fb90f6fefae24c39880fec2dd6f151eb19d3af3252c9396d4c898fe59";
    private final AWSCredentials creds = new BasicAWSCredentials(accessKey, secretKey);
    private final AmazonS3 s3client = AmazonS3ClientBuilder.standard().withCredentials(
                    new AWSStaticCredentialsProvider(creds))
            .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(
                    "https://0b7ee75e7d0ca725c756c3ed02ac3983.r2.cloudflarestorage.com"
                    , "auto")).build();
    private final String bucket = "notetaker";
    private final String file = SaveFile.getFileName();


    public Cloud(){}

    // this needs to be planned better and async'ed
    // but now let's just see how it works
    public void load(UUID sysId){
        System.out.println("Loading from R2...");
        System.out.println("Is cloud file newer than local: " + cloudNewer());

        if (!cloudNewer())
            return;

        System.out.println("Cloud file is newer => downloading..");
        try{
            S3Object o = s3client.getObject(bucket, sysId.toString());
            S3ObjectInputStream s3is = o.getObjectContent();
            FileOutputStream os = new FileOutputStream(new File(file));

            byte[] read_buf = new byte[1024];
            int read_len = 0;
            while((read_len = s3is.read(read_buf)) > 0)
                os.write(read_buf, 0, read_len);

            s3is.close();
            os.close();
            System.out.println("Loaded from R2");
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
            System.out.println("No save found perhaps?");
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private void save(){
        System.out.println("Comparing cloud date and local file date...");
        System.out.println("Local file is newer: " + localNewer());

        if(!localNewer())
            return;

        System.out.println("Local file newer so uploading to cloud...");
        try {
            s3client.putObject(bucket, systemId.toString(), new File(file));
        }catch (AmazonServiceException e){
            System.err.println(e.getErrorMessage());
        }
        System.out.println("Saved to R2");
        stampLocalFile();
    }
    public void save(UUID sysId){
        this.systemId = sysId;
        save();
    }

    public void delete(UUID sysId){
        try {
            s3client.deleteObject(bucket, sysId.toString());
        }catch (AmazonServiceException e){
            System.err.println(e.getErrorMessage());
        }
    }

    // is the local file newer => to minimize unnecessary mutations
    private int modified(){
        return getCloudDate().compareTo(getLocalDate());
    }
    private boolean localNewer(){ return getLocalDate().compareTo(getCloudDate()) > 0; }
    private boolean cloudNewer(){ return getCloudDate().compareTo(getLocalDate()) > 0; }

    private Date getCloudDate(){
        ListObjectsV2Result result =  s3client.listObjectsV2(new ListObjectsV2Request()
                .withBucketName(bucket));

        for (S3ObjectSummary objectSummary : result.getObjectSummaries())
            return objectSummary.getLastModified();
        return new Date("01/01/1900"); // if cloud has no file then it definitely isn't newer..
        // I mean this could be handled more elegantly... but who cares
    }

    private Date getLocalDate(){
        try {
            return new Date(
                    Files.readAttributes(Paths.get(file)
                        , BasicFileAttributes.class).lastModifiedTime().toMillis());
        }catch(IOException e){
            System.err.println(e.getMessage());
        }
        return new Date("01/01/1900"); // make sure to load from cloud if file missing
    }

    // unfortunately as the cloud stamps the file when received we need to stamp our file to
    // match cloud date... or is there a way to stop the silly cloud stamping it upon receive?
    // modified date is the simplest way to try to keep track of which file version
    private void stampLocalFile(){
        try {
            Files.setLastModifiedTime(Paths.get(file)
                    , FileTime.from(getCloudDate().toInstant()));
        }catch (IOException e){ System.err.println(e.getMessage()); }
    }
}
