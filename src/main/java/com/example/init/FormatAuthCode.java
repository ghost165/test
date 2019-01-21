package com.example.init;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.servlet.http.HttpSession;
public class FormatAuthCode {
	private static char[] chs= "0123456789QWERTYUIOPASDFGHJKLZXCVBNM".toCharArray();
	public static BufferedImage getAuthCode(int count,int width,int height,HttpSession session) {
		if(count<1 || width<1 || height<1 || session == null) {
			return null;
		}
		BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D g = image.createGraphics();
		g.setColor(new Color(238,238,238));
		g.fillRect(0,0,width,height);
		g.setFont(new Font("Times New Roman",Font.BOLD,25));
		
		StringBuffer code= new StringBuffer();
		Random random = new Random();
		for(int i=0;i<count;i++) {
			int index = random.nextInt(chs.length);
            g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));// 随机字符颜色
			g.drawString(String.valueOf(chs[index]), 20*i+5, 23);
			code.append(chs[index]);
		}
		session.setAttribute("authCode", code.toString());
		return image;
	}
	
	private FormatAuthCode() {};
}
