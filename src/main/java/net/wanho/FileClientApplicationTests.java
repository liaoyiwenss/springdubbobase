package net.wanho;

import net.wanho.utils.FastDFSClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileClientApplicationTests {

    @Test
    public void Upload() {
        String fileUrl = this.getClass().getResource("/files/1A836D2B3A3348DDAB19807E6CEA8028.jpg").getPath();
        File file = new File(fileUrl);
        String str = FastDFSClient.uploadFile(file);
        FastDFSClient.getResAccessUrl(str);
    }

    @Test
    public void Delete() {
        FastDFSClient.deleteFile("group1/M00/00/00/rBEAClu8OiSAFbN_AAbhXQnXzvw031.jpg");
    }


}
