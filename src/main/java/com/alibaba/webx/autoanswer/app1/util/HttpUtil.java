package com.alibaba.webx.autoanswer.app1.util;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Encoder;
import javax.crypto.Mac;

@SuppressWarnings("restriction")
public class HttpUtil {
    /*
     * ����MD5+BASE64
     */
    public static String MD5Base64(String s) throws UnsupportedEncodingException {
        if (s == null)
            return null;
        String encodeStr = "";

        //string �������Ϊutf-8
        byte[] utfBytes = s.getBytes("UTF-8");

        MessageDigest mdTemp;
        try {
            mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(utfBytes);
            byte[] md5Bytes = mdTemp.digest();
            BASE64Encoder b64Encoder = new BASE64Encoder();
            encodeStr = b64Encoder.encode(md5Bytes);
        } catch (Exception e) {
            throw new Error("Failed to generate MD5 : " + e.getMessage());
        }
        return encodeStr;
    }

    /*
     * ���� HMAC-SHA1
     */
    public static String HMACSha1(String data, String key) {
        String result;
        try {

            SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(signingKey);
            byte[] rawHmac = mac.doFinal(data.getBytes());
            result = (new BASE64Encoder()).encode(rawHmac);
        } catch (Exception e) {
            throw new Error("Failed to generate HMAC : " + e.getMessage());
        }
        return result;
    }

    /*
     * ��ͬ��javaScript�е� new Date().toUTCString();
     */
    public static String toGMTString(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z", Locale.UK);
        df.setTimeZone(new java.util.SimpleTimeZone(0, "GMT"));
        return df.format(date);
    }

    /*
     * ����POST����
     */
    public static String sendPost(String url, String body, String ak_id, String ak_secret) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);

            /*
             * http header ����
             */
            String method = "POST";
            String accept = "application/json";
            String content_type = "application/json";
            String path = realUrl.getFile();
            String date = toGMTString(new Date());

            // 1.��body��MD5+BASE64����
            String bodyMd5 = MD5Base64(body);
            String stringToSign = method + "\n" + accept + "\n" + bodyMd5 + "\n" + content_type + "\n" + date ;
            // 2.���� HMAC-SHA1
            String signature = HMACSha1(stringToSign, ak_secret);
            // 3.�õ� authorization header
            String authHeader = "Dataplus " + ak_id + ":" + signature;

            // �򿪺�URL֮�������
            URLConnection conn = realUrl.openConnection();
            // ����ͨ�õ���������
            conn.setRequestProperty("accept", accept);
            conn.setRequestProperty("content-type", content_type);
            conn.setRequestProperty("date", date);
            conn.setRequestProperty("Authorization", authHeader);
            // ����POST�������������������
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // ��ȡURLConnection�����Ӧ�������
            out = new PrintWriter(conn.getOutputStream());
            // �����������
            out.print(body);
            // flush������Ļ���
            out.flush();
            // ����BufferedReader����������ȡURL����Ӧ
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("���� POST ��������쳣��" + e);
            e.printStackTrace();
        }
        // ʹ��finally�����ر��������������
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }


    /*
     * GET����
     */

    public static String sendGet(String url, String task_id,String ak_id, String ak_secret) {
        String result = "";
        BufferedReader in = null;
        try {
            URL realUrl = new URL(url+"/"+task_id);
            /*
             * http header ����
             */
            String method = "GET";
            String accept = "application/json";
            String content_type = "application/json";
            String path = realUrl.getFile();
            String date = toGMTString(new Date());
            // 1.��body��MD5+BASE64����
            //String bodyMd5 = MD5Base64("");
            String stringToSign = method + "\n" + accept + "\n" + "" + "\n" + content_type + "\n" + date;
            // 2.���� HMAC-SHA1
            String signature = HMACSha1(stringToSign, ak_secret);
            // 3.�õ� authorization header
            String authHeader = "Dataplus " + ak_id + ":" + signature;
            // �򿪺�URL֮�������
            URLConnection connection = realUrl.openConnection();
            // ����ͨ�õ���������
            connection.setRequestProperty("accept", accept);
            connection.setRequestProperty("content-type", content_type);
            connection.setRequestProperty("date", date);
            connection.setRequestProperty("Authorization", authHeader);
            // ����ʵ�ʵ�����
            connection.connect();
            // ���� BufferedReader����������ȡURL����Ӧ
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("����GET��������쳣��" + e);
            e.printStackTrace();
        }
        // ʹ��finally�����ر�������
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
