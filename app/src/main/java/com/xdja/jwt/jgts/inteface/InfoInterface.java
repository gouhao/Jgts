package com.xdja.jwt.jgts.inteface;

import java.util.List;

/**
 * 插件接口
 * @author LHC
 *
 */
public interface InfoInterface{
	
	/**
	 * 描述信息，主类
	 * @return
	 */
	public String getDesciption();
	
	/**
	 * 插件类型
	 * @return
	 */
	public String getType();
	
	/**
	 * 插件供调用方法集合
	 * @return
	 */
	public List<String> getMethod();
	
	/**
	 * 获取图标资源文件ID
	 */
	public int getDrawable();
	
	/**
	 * 插件名称
	 */
	public String getName();
	
	/**
	 * 获取插件程序需要的参数
	 */
	public List<String> getPro();
}