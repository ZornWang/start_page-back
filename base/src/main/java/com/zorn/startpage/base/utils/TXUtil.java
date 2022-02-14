package com.zorn.startpage.base.utils;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.region.Region;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.sms.v20190711.SmsClient;
import com.tencentcloudapi.sms.v20190711.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20190711.models.SendSmsResponse;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
@Setter
@ConfigurationProperties(prefix = "txyun")
public class TXUtil {
    //    sms
    private String secretId;
    private String secretKey;
    private String appId;
    private String sign;

    //    cos
    // 存储桶名称
    private String bucketName;
    // 访问域名
    private String URL;

    public SendSmsResponse sendSMS(String phone, String code, String templateId) throws TencentCloudSDKException {

        /* 必要步骤：
         * 实例化一个认证对象，入参需要传入腾讯云账户密钥对 secretId 和 secretKey
         * 本示例采用从环境变量读取的方式，需要预先在环境变量中设置这两个值
         * CAM 密钥查询：https://console.cloud.tencent.com/cam/capi*/
        Credential cred = new Credential(secretId, secretKey);

        // 实例化一个 http 选项，可选，无特殊需求时可以跳过
        HttpProfile httpProfile = new HttpProfile();
        // 设置代理
//            httpProfile.setProxyHost("host");
//            httpProfile.setProxyPort(port);
        /* SDK 默认使用 POST 方法。
         * 如需使用 GET 方法，可以在此处设置，但 GET 方法无法处理较大的请求 */
        httpProfile.setReqMethod("POST");
        /* SDK 有默认的超时时间，非必要请不要进行调整
         * 如有需要请在代码中查阅以获取最新的默认值 */
        httpProfile.setConnTimeout(60);
        /* SDK 会自动指定域名，通常无需指定域名，但访问金融区的服务时必须手动指定域名
         * 例如 SMS 的上海金融区域名为 sms.ap-shanghai-fsi.tencentcloudapi.com */
        httpProfile.setEndpoint("sms.tencentcloudapi.com");

        /* 非必要步骤:
         * 实例化一个客户端配置对象，可以指定超时时间等配置 */
        ClientProfile clientProfile = new ClientProfile();
        /* SDK 默认用 TC3-HMAC-SHA256 进行签名
         * 非必要请不要修改该字段 */
        clientProfile.setSignMethod("HmacSHA256");
        clientProfile.setHttpProfile(httpProfile);
        /* 实例化 SMS 的 client 对象
         * 第二个参数是地域信息，可以直接填写字符串 ap-guangzhou，或者引用预设的常量 */
        SmsClient client = new SmsClient(cred, "", clientProfile);

        SendSmsRequest req = new SendSmsRequest();
        req.setSmsSdkAppid(appId);
        req.setTemplateID(templateId);
        req.setSign(sign);

        String phoneNumber = "+86" + phone;

        String[] phoneNumbers = {phoneNumber};
        req.setPhoneNumberSet(phoneNumbers);

        String[] params = {code};
        req.setTemplateParamSet(params);

        return client.SendSms(req);
    }

    public String uploadfile(MultipartFile file, String prefix, String fileName) {

        // 创建COS 凭证
        COSCredentials credentials = new BasicCOSCredentials(secretId, secretKey);
        // 配置 COS 区域 就购买时选择的区域 我这里是 广州（guangzhou）
        ClientConfig clientConfig = new ClientConfig(new Region("ap-guangzhou"));
        // 创建 COS 客户端连接
        COSClient cosClient = new COSClient(credentials, clientConfig);
        String originalFilename = file.getOriginalFilename();
        try {
            String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
            File localFile = File.createTempFile(String.valueOf(System.currentTimeMillis()), substring);
            file.transferTo(localFile);
            fileName = prefix + fileName + substring;
            // 将 文件上传至 COS
            PutObjectRequest objectRequest = new PutObjectRequest(bucketName, fileName, localFile);
            cosClient.putObject(objectRequest);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cosClient.shutdown();
        }
        return URL + fileName;
    }
}
