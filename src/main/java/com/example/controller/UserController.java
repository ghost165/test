package com.example.controller;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.init.FormatAuthCode;
import com.example.model.UserModel;
import com.example.service.IUserService;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
@RequestMapping("user")
public class UserController {
	
	@RequestMapping("/authCode")
	public void authCode(HttpServletResponse response,HttpSession session)throws IOException{
		BufferedImage image = FormatAuthCode.getAuthCode(4, 24, 30, session);
		ImageIO.write(image, "jpg", response.getOutputStream());
	}
}
