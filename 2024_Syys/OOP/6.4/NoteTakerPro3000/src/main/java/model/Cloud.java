package model;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
    private String file = "save.dat";   // hardcoded the savefile as I'm lazy as hell


    public Cloud(){

    }

    // this needs to be planned better and async'ed
    // but now let's just see how it works
    public void load(UUID sysId){
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
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private void save(){
        try {
            s3client.putObject(bucket, systemId.toString(), new File(file));
        }catch (AmazonServiceException e){
            System.out.println(e.getErrorMessage());
        }
        System.out.println("Saved to R2");
    }
    public void save(UUID sysId){
        this.systemId = sysId;
        save();
    }
}
