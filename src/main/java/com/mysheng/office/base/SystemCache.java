package com.mysheng.office.base;

import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;

/*
 * shangjunwei 2017-08-08
 * app端缓存用户类
 * */

public class SystemCache {

	//key：医师ID+"-1"  用户ID+"-2"，vaule：c 用于验证用户登录
	public static ConcurrentHashMap<String, String> USER_MAP =new ConcurrentHashMap<String, String>();
	
	//key：c，vaule：用户ID 用于验证用户登录
	public static ConcurrentHashMap<String, String> USER_TOKEN_MAP = new ConcurrentHashMap<String, String>();


}
