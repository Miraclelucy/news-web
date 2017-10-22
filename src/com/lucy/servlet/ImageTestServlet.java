package com.lucy.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ImageTestServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The doPost method of the servlet. <br>
	 * This method is called when a form has its tag value method equals to
	 * post.
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}
	
	/**
	 * The doGet method of the servlet. <br>
	 * This method is called when a form has its tag value method equals to get.
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("image/jpeg");

		OutputStream out = response.getOutputStream();
		BufferedImage image = new BufferedImage(100, 20,
				BufferedImage.TYPE_INT_RGB);

		Graphics g = image.getGraphics();
		g.setColor(Color.PINK);
		g.fillRect(0, 0, 100, 20);
		g.setColor(Color.BLACK);
		g.setFont(new Font("����",Font.BOLD,18));

		Random random = new Random();
		int length = 6;
		String checkcode = "";
		char code;
		int number;
		for (int i = 0; i < length; i++) {
			number = random.nextInt(26);
			if (number % 2 == 0) {
				code = (char) ('0' + (char) (number % 10));
			} else {
				code = (char) ('a' + (char) (number));
			}
			checkcode += code + "";

		}
		
		HttpSession session=request.getSession(true);
		session.setAttribute("yanzheng",checkcode);
		g.drawLine(0,15,100,1);
		g.drawLine(2, 17, 80, 2);
		g.drawString(checkcode, 10,19);		
		g.dispose();
		ImageIO.write(image, "JPEG", out);
	}

}
