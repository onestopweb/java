package cn.action;
import java.util.ArrayList;
import java.util.List;
import cn.biz.StudentBiz;
import cn.biz.impl.StudentBizImpl;
import cn.entity.Classes;
import cn.entity.Student;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 学生 控制器
 * */
@SuppressWarnings("serial")
public class StudentAction extends ActionSupport {
	private StudentBiz studentBiz = new StudentBizImpl();
	private List<Student> students = new ArrayList<Student>();
	private Student student = new Student();
	private Integer id;
	private List<Classes> classesList = new ArrayList<Classes>();
	private Integer classId;
	/**
	 * 显示学生列表
	 * @return
	 */
	public String list(){
		students = studentBiz.getAll();
		return SUCCESS;
	}
	/**
	 * 根据 id 查询学生信息
	 * @return
	 */
	public String selected(){
		student = studentBiz.getStudentById(id);
		classesList = studentBiz.getClassesList();
		return SUCCESS;
	}
	/**
	 * 修改学生信息
	 * @return
	 */
	public String updated(){
		Classes classes = new Classes();
		classes = studentBiz.getClassesById(classId);
		student.setClasses(classes);
		if(studentBiz.update(student) > 0){
			students = studentBiz.getAll();
			return SUCCESS;
		}else{
			return INPUT;
		}
		
	}
	public StudentBiz getStudentBiz() {
		return studentBiz;
	}
	public void setStudentBiz(StudentBiz studentBiz) {
		this.studentBiz = studentBiz;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Classes> getClassesList() {
		return classesList;
	}
	public void setClassesList(List<Classes> classesList) {
		this.classesList = classesList;
	}
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
}
