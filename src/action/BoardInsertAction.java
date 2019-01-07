package action;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BoardDAO;
import vo.BoardBean;

/**
 * Servlet implementation class BoardInsertAction
 */
@WebServlet("/board/insert")
public class BoardInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsertAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		int fileSize = 5*1024*1024;
		ServletContext context = request.getServletContext();
		String realFolder = context.getRealPath("/boardUpload");
		MultipartRequest multi = new MultipartRequest(request, 
					realFolder,
					fileSize,
					"utf-8",
					new DefaultFileRenamePolicy());
		BoardBean bb = new BoardBean();
		String name = multi.getParameter("name");
		String pass = multi.getParameter("pass");
		String subject = multi.getParameter("subject");
		String content = multi.getParameter("content");
		String filename = multi.getFilesystemName("filename");
		String orgname = multi.getFilesystemName("filename");
		bb.setBoard_name(name);
		bb.setBoard_pass(pass);
		bb.setBoard_subject(subject);
		bb.setBoard_content(content);
		bb.setBoard_file(orgname);
		
		BoardDAO dao = new BoardDAO();
		dao.boardInsert(bb);
		
		response.sendRedirect("list");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
