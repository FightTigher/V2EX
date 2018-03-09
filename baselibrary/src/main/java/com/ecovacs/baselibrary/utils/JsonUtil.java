package com.ecovacs.baselibrary.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.lang.reflect.Type;

public final class JsonUtil
{
	private static final Gson gson = new GsonBuilder().disableHtmlEscaping().create();
	
	public  static String toJson(Object obj)
	{
		return gson.toJson(obj);
	}
    public  static String toJson(Object obj, Type type)
    {
        return gson.toJson(obj,type);
    }
	public static <T> T fromJson(String json, Class<T> clazz)
	{
		try
		{
			return gson.fromJson(json, clazz);
		}catch(JsonSyntaxException e)
		{
            e.printStackTrace();
		}
		return null;
	}
    public static <T> T fromJson(String json, Type clazz)
    {
        try
        {
            return gson.fromJson(json, clazz);
        }catch(JsonSyntaxException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
