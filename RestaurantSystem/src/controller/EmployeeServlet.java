package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import model.Employee;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		if(action.equals("insert")){
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			int position = Integer.parseInt(request.getParameter("position"));
			String ssalary = request.getParameter("salary");
			
			Employee employee = new Employee();
			employee.setId(id);
			employee.setName(name);
			employee.setPosition(position);
			if(ssalary.equals("")){
				
			}else{
				int salary = Integer.parseInt(ssalary);
				employee.setSalary(salary);
			}
			
			EmployeeDAO dao = new EmployeeDAO();
			boolean result = dao.invalidId(id);
			if(result){
				RequestDispatcher rd = request.getRequestDispatcher("insert.jsp");
				request.setAttribute("employee", employee);
				request.setAttribute("message", "รหัสซ้ำ กรอกรหัสใหม่");
				rd.forward(request, response);
			}else{
				result = dao.insert(employee);
				if(result){
					List<Employee> employees = dao.selectAll();
					RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
					request.setAttribute("employees", employees);
					rd.forward(request, response);
				}
			}
		}else if(action.equals("selectall")){
			EmployeeDAO dao = new EmployeeDAO();
			List<Employee> employees = dao.selectAll();
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			request.setAttribute("employees", employees);
			rd.forward(request, response);
		}else if(action.equals("searchbyidorname")){
			String idname = request.getParameter("idname");
			EmployeeDAO dao = new EmployeeDAO();
			List<Employee> employees = dao.selectByIdOrName(idname);
			
			RequestDispatcher rd = request.getRequestDispatcher("search.jsp");
			request.setAttribute("employees", employees);
			rd.forward(request, response);
		}else if(action.equals("searchbyidforupdate")){
			String id = request.getParameter("idsearch");
			EmployeeDAO dao = new EmployeeDAO();
			Employee employee = dao.selectById(id);
			
			RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
			request.setAttribute("employee", employee);
			rd.forward(request, response);
		}else if(action.equals("searchbyidfordelete")){
			String id = request.getParameter("idsearch");
			EmployeeDAO dao = new EmployeeDAO();
			Employee employee = dao.selectById(id);
			
			RequestDispatcher rd = request.getRequestDispatcher("delete.jsp");
			request.setAttribute("employee", employee);
			rd.forward(request, response);
		}else if(action.equals("update")){
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			int position = Integer.parseInt(request.getParameter("position"));
			String ssalary = request.getParameter("salary");
			int salary = Integer.parseInt(ssalary);
			
			Employee employee = new Employee(id, name, position, salary);
			
			EmployeeDAO dao = new EmployeeDAO();
			boolean result = dao.update(employee);
			if(result){
				List<Employee> employees = dao.selectAll();
				RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
				request.setAttribute("employees", employees);
				rd.forward(request, response);
			}
		}else if(action.equals("delete")){
			String id = request.getParameter("id");
			
			EmployeeDAO dao = new EmployeeDAO();
			boolean result = dao.delete(id);
			if(result){
				List<Employee> employees = dao.selectAll();
				RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
				request.setAttribute("employees", employees);
				rd.forward(request, response);
			}
		}
	}

}
