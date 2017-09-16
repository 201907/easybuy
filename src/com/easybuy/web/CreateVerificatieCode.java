package com.easybuy.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easybuy.utils.VeriCodeUtil;

@WebServlet("/createVerificatieCode")
public class CreateVerificatieCode extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		VeriCodeUtil codeUtil = new VeriCodeUtil();
		codeUtil.setBaseMode(VeriCodeUtil.BaseMode.STRMODE);
		req.getSession().setAttribute("VeriCode", codeUtil.createVerifiCodeImage(resp.getOutputStream(), 75, 35));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
