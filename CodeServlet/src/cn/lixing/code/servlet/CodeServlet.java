package cn.lixing.code.servlet;

import static cn.lixing.code.servlet.Uilts.SelectDbUilts.decrypteQpcodeData;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CodeServlet")
public class CodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CodeObject codeObject;
	private String KeyPersiontUrl;
	private String DevicesUrl;
	private String CustUrl;
	private String UnactivatedUrl;
	
	public CodeServlet() {
		codeObject=new CodeObject();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Ê±¼ä"+new Date());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("srcUrl",codeObject.getSrcUrl());
        req.setAttribute("textUrl",codeObject.getTextUrl());
        
		resp.setContentType("text/html");
		req.setCharacterEncoding("UTF-8");
		PrintWriter out=resp.getWriter();
		
		String c=req.getParameter("select");
		req.setAttribute("select",c);
		if("keyPersionCode".equals(c)) {
			out.print("keyPersionCodePage");
			try {
				decrypteQpcodeData(1);
			} catch (Exception e) {
				req.getRequestDispatcher("error.jsp").forward(req,resp);
				return;
			}
			req.setAttribute("keyPersiontUrl",codeObject.getKeyPersiontUrl());
			KeyPersiontUrl=codeObject.getKeyPersiontUrl();
			req.getRequestDispatcher(KeyPersiontUrl).forward(req,resp);
			return;
		}else if("custPersionCode".equals(c)) {
			out.print("custPersionCodePage");
			try {
				decrypteQpcodeData(0);
			} catch (Exception e) {
				req.getRequestDispatcher("error.jsp").forward(req,resp);
				return;
			}
			req.setAttribute("custUrl",codeObject.getCustUrl());
			CustUrl=codeObject.getCustUrl();
			req.getRequestDispatcher(CustUrl).forward(req,resp);
			return;
		}else if("devicesCode".equals(c)) {
			out.print("devicesCodePage");
			try {
				decrypteQpcodeData(2);
			} catch (Exception e) {
				req.getRequestDispatcher("error.jsp").forward(req,resp);
				return;
			}
			req.setAttribute("devicesUrl",codeObject.getDevicesUrl());
			DevicesUrl=codeObject.getDevicesUrl();
			req.getRequestDispatcher(DevicesUrl).forward(req,resp);
			return;
		}else {
			out.print("unactivatedCodePage");
			try {
				decrypteQpcodeData(5);
			} catch (Exception e) {
				req.getRequestDispatcher("error.jsp").forward(req,resp);
				return;
			}
			req.setAttribute("unactivatedUrl",codeObject.getUnactivatedUrl());
			UnactivatedUrl=codeObject.getUnactivatedUrl();
			req.getRequestDispatcher(UnactivatedUrl).forward(req,resp);
			return;
		}
	}
	
	
}
