package com.example.demo.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Map.Entry;

/**
 * HttpClient4.3工具类
 * @author hang.luo
 */
public class HttpClientUtils{
    private static Logger logger = LoggerFactory.getLogger(HttpClientUtils.class); // 日志记录

    private static RequestConfig requestConfig = null;

    static{
        // 设置请求和传输超时时间
        requestConfig = RequestConfig.custom().setSocketTimeout(2000).setConnectTimeout(2000).build();
    }
    /**
     * post请求传输json参数
     * @param url  url地址
     * @param json 参数
     * @return
     */
    public static JSONObject httpPost(String url, Object obj){
        // post请求返回结果
        CloseableHttpClient httpClient = HttpClients.createDefault();
        JSONObject jsonResult = null;
        HttpPost httpPost = new HttpPost(url);
        // 设置请求和传输超时时间
        httpPost.setConfig(requestConfig);
        try{
        	String jsonStr=JsonUtil.ObjectToJsonStr(obj);
            if (null!=jsonStr){
                // 解决中文乱码问题
                StringEntity entity = new StringEntity(jsonStr, "utf-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                httpPost.setEntity(entity);
            }
            CloseableHttpResponse result = httpClient.execute(httpPost);
            // 请求发送成功，并得到响应
            if (result.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                String str = "";
                try{
                    // 读取服务器返回过来的json字符串数据
                    str = EntityUtils.toString(result.getEntity(), "utf-8");
                    // 把json字符串转换成json对象
                    jsonResult = JSONObject.parseObject(str);
                }
                catch (Exception e){
                    logger.error("post请求提交失败:" + url, e);
                }
            }
        }catch (IOException e){
            logger.error("post请求提交失败:" + url, e);
            e.printStackTrace();
        }finally {
            httpPost.releaseConnection();
        }
        return jsonResult;
    }

    /**
     * post请求传输String参数 例如：name=Jack&sex=1&type=2
     * Content-type:application/x-www-form-urlencoded
     * @param url            url地址
     * @param strParam       参数
     * @return
     */
    public static JSONObject httpPost(String url, String strParam) {
        // post请求返回结果
        CloseableHttpClient httpClient = HttpClients.createDefault();
        JSONObject jsonResult = null;
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);
        try {
            if (null != strParam){
                // 解决中文乱码问题
                StringEntity entity = new StringEntity(strParam, "utf-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/x-www-form-urlencoded");
                httpPost.setEntity(entity);
            }
            CloseableHttpResponse result = httpClient.execute(httpPost);
            // 请求发送成功，并得到响应
            if (result.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String str = "";
                try{
                    // 读取服务器返回过来的json字符串数据
                    str = EntityUtils.toString(result.getEntity(), "utf-8");
                    // 把json字符串转换成json对象
                    jsonResult = JSONObject.parseObject(str);
                }catch (Exception e){
                    logger.error("post请求提交失败:" + url, e);
                }
            }
        }catch (IOException e){
            logger.error("post请求提交失败:" + url, e);
            e.printStackTrace();
        }finally{
            httpPost.releaseConnection();
        }
        return jsonResult;
    }

    /**
     * 发送get请求
     * @param url 路径
     * @return
     */
    public static JSONObject httpGet(String url){
        // get请求返回结果
        JSONObject jsonResult = null;
        CloseableHttpClient client = HttpClients.createDefault();
        // 发送get请求
        HttpGet request = new HttpGet(url);
        request.setConfig(requestConfig);
        try{
            CloseableHttpResponse response = client.execute(request);

            // 请求发送成功，并得到响应
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                // 读取服务器返回过来的json字符串数据
                HttpEntity entity = response.getEntity();
                String strResult = EntityUtils.toString(entity, "utf-8");
                // 把json字符串转换成json对象
                jsonResult = JSONObject.parseObject(strResult);
            }else{
                logger.error("get请求提交失败:" + url);
            }
        }
        catch (IOException e){
            logger.error("get请求提交失败:" + url, e);
            e.printStackTrace();
        }finally{
            request.releaseConnection();
        }
        return jsonResult;
    }

    public static String postFileMultiPart(String url,Map<String,ContentBody> reqParam) throws ClientProtocolException, IOException{
        CloseableHttpClient httpclient = HttpClients.createDefault();
        
        try {
            // 创建httpget.    
            HttpPost httppost = new HttpPost(url);
        	
            //setConnectTimeout：设置连接超时时间，单位毫秒。setConnectionRequestTimeout：设置从connect Manager获取Connection 超时时间，单位毫秒。这个属性是新加的属性，因为目前版本是可以共享连接池的。setSocketTimeout：请求获取数据的超时时间，单位毫秒。 如果访问一个接口，多少时间内无法返回数据，就直接放弃此次调用。
            HttpPost httpPost = new HttpPost(url);
            httpPost.setConfig(requestConfig);
            
            System.out.println("executing request " + httppost.getURI());
            
            MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
            for(Entry<String,ContentBody> param : reqParam.entrySet()){
            	multipartEntityBuilder.addPart(param.getKey(), param.getValue());
            }
            HttpEntity reqEntity = multipartEntityBuilder.build();
            httppost.setEntity(reqEntity);
            
            // 执行post请求.    
            CloseableHttpResponse response = httpclient.execute(httppost);
            
            System.out.println("got response");
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            	try {  
                    // 获取响应实体    
                    HttpEntity entity = response.getEntity();  
                    //System.out.println("--------------------------------------");  
                    // 打印响应状态    
                    //System.out.println(response.getStatusLine());  
                    if (entity != null) { 
                    	return EntityUtils.toString(entity,Charset.forName("UTF-8"));
                    }
                    //System.out.println("------------------------------------");  
                } finally {  
                    response.close();
                }
            }else{
                logger.error("formdata请求提交失败:" + url);
            }
        } finally {  
            // 关闭连接,释放资源    
            try {  
                httpclient.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }
        return null;  
    }
}