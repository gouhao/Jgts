package com.xdja.jwt.jgts;

import android.app.Application;

import com.xdja.jwt.jgts.inteface.JwtPluginInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * 插件信息类
 * 
 * @author LHC
 * 
 */
public class PluginMainClass extends Application implements JwtPluginInterface {

	@Override
	public void onCreate() {
		super.onCreate();
	}

	/**
	 * 返回主类
	 * 
	 * @return
	 */
	@Override
	public String getDesciption() {
		return "MainActivity";
	}

	/**
	 * 返回插件类型 BA: 功能模块类插件 SKIN: 皮肤包 PATCH: 补丁 默认为BA
	 * 
	 * @return
	 */
	@Override
	public String getType() {
		return "LOCAL";
	}

	/**
	 * 返回方法列表
	 */
	@Override
	public List<String> getMethod() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 返回应用程序图标资源号 默认为icon.png，
	 */
	@Override
	public int getDrawable() {
		// TODO Auto-generated method stub
		return R.mipmap.ic_launcher;
	}

	/**
	 * 返回应用程序名称
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "警情推送";
	}

	@Override
	public List<String> getPro() {
		// TODO Auto-generated method stub
		List<String> listStr = new ArrayList<String>();
		listStr.add("serverIP");
		listStr.add("serverPort");
		listStr.add("sessionID");
		listStr.add("isSafeCon");
		listStr.add("userPower");
		return listStr;
	}
}