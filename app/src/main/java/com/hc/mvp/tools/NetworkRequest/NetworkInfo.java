package com.hc.mvp.tools.NetworkRequest;

/**
 * Created by Administrator on 2018/3/6.
 * 网络地址
 */
public class NetworkInfo {


    public static String url_title = "http://192.168.1.191:8080";

    //登录
    public static String Url_login = url_title + "/test/login";  //name=成龙&password=123456
    //注册
    public static String Url_register = url_title + "/test/register";//name=成龙&password=123456
    //首页
    public static String Url_home = url_title + "/main/home";
    public static String Url_home_banner = url_title + "/main/home/banner";
    //我的
    public static String Url_person = url_title + "/main/person";

}
