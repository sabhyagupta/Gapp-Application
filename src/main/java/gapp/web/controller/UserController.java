package gapp.web.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

import gapp.model.Users;
import gapp.model.Department;
import gapp.model.EducationBckgd;
import gapp.model.OtherRequirement;
import gapp.model.OtherRequirementValue;
import gapp.model.Programs;
import gapp.model.dao.ApplicationStatusDao;
import gapp.model.dao.ContestantDao;
import gapp.model.dao.DepartmentDao;
import gapp.model.dao.EducationalBackgroundDao;
import gapp.model.dao.OtherFieldDao;
import gapp.model.dao.OtherRequirementValueDao;
import gapp.model.dao.ProgramDao;
import gapp.model.dao.RoleDao;
import gapp.model.dao.UserDao;
import gapp.model.Contestant;

@Controller
@SessionAttributes("dept")
public class UserController {
	@Autowired
	UserDao userDao;
	@Autowired
	RoleDao roledao;
	@Autowired
	DepartmentDao DptDao;
	@Autowired
	ProgramDao prgDao;
	@Autowired
	OtherFieldDao otherDao;
	@Autowired
	ContestantDao contestantDao;
	@Autowired
	ApplicationStatusDao applicationStatusDao;
	@Autowired
	EducationalBackgroundDao educationDao;
	@Autowired
	private WebApplicationContext context;
	@Autowired
	OtherRequirementValueDao othervaluedao;
	private String Status;
	
	@RequestMapping(value = "ManageDepartment.html", method = RequestMethod.GET)
	public String Department(ModelMap models) {

		List<Department> Department = DptDao.getDepartment();

		models.put("Department", Department);
		return "ManageDepartment";
	}
	/*
	 * @RequestMapping(value="ManageDepartment.html") public String
	 * Program(ModelMap models) { int programs=prgDao.getProgram1(null).size();
	 * models.put("programs",programs); return "ManageDepartment";
	 * 
	 * }
	 */

	@RequestMapping(value = "Register.html", method = RequestMethod.GET)
	public String Register() {

		return "Register";

	}

	@RequestMapping(value = "Register.html", method = RequestMethod.POST)
	public String Register(@RequestParam String Firstname, @RequestParam String Lastname, @RequestParam String email,
			@RequestParam String password, ModelMap models) {
		Boolean flag = false;
		Users user = new Users();
		try {
			if (userDao.getUsers(email, password).equals(null)) {
				flag = false;
			} else
				flag = true;
		} catch (Exception e) {
			e.getMessage();
		}
		if (!flag) {
			user.setFname(Firstname);
			user.setLname(Lastname);
			user.setEmail(email.toLowerCase());
			user.setPassword(password);
			user.setRolename(roledao.getRole(1));
			user = userDao.saveUser(user);
			models.addAttribute("meassage", "Congratulation You are Registered");
			return "Login";
		} else {
			models.addAttribute("message", "User already exist by this email");
			return "Register";
		}
	}

	@RequestMapping(value = "Login.html", method = RequestMethod.GET)
	public String Login() {
		return "Login";
	}

	@SuppressWarnings("unused")
	@RequestMapping(value = "Login.html", method = RequestMethod.POST)
	public String Login1(@RequestParam String email, @RequestParam String pwd, ModelMap models,
			HttpServletRequest request) {
		Boolean flag = false;
		Users user = userDao.getUsers(email, pwd);
		try {
			if (user.equals(null)) {
				flag = false;
			} else
				flag = true;
		} catch (Exception e) {
			e.getMessage();
		}
		if (!flag) {
			models.addAttribute("message", "Incorrect credentials");
			return "Login";
		} else {
			request.getSession().setAttribute("username", user.getFname() + " " + user.getLname());
			request.getSession().setAttribute("useremail", user.getEmail());
			if (user.getRolename().getRoleName().equals("admin")) {
				return "redirect:Welcome.html";
			} else if (user.getRolename().getRoleName().equals("staff")) {
				return "redirect:Welcomestaff.html";
			} else {
				return "redirect:StudentInformation.html";
			}
		}
	}
	
	@RequestMapping(value = "Welcomestaff.html")
	public String Welcomestaff(ModelMap models) {
		return "Welcomestaff";
	}

	@RequestMapping(value = "AddDepartment.html", method = RequestMethod.GET)
	public String Add(ModelMap models) {
		return "AddDepartment";
	}

	@RequestMapping(value = "AddDepartment.html", method = RequestMethod.POST)
	public String Add1(@RequestParam String Department, ModelMap models) {
		Department dept = new Department();
		dept.setDptname(Department);
		DptDao.saveDepartment(dept);
		return "redirect:ManageDepartment.html";
	}

	@RequestMapping(value = "AddProgram.html", method = RequestMethod.GET)
	public String AddProgram(ModelMap models) {
		models.put("departments", DptDao.getDepartment());
		return "AddProgram";
	}

	@RequestMapping(value = "AddProgram.html", method = RequestMethod.POST)
	public String AddProgram(@RequestParam String Program, @RequestParam String dptname) {
		Programs prg = new Programs();
		prg.setPrgname(Program);
		prg.setDptid(DptDao.getDepartment(dptname));
		prgDao.saveProgram(prg);
		return "redirect:ManageDepartment.html";
	}

	@RequestMapping(value = "AdditionalRequirement.html", method = RequestMethod.GET)
	public String AdditionalRequired(ModelMap models) {
		models.put("departments", DptDao.getDepartment());
		return "AdditionalRequirement";
	}

	@RequestMapping(value = "AdditionalRequirement.html", method = RequestMethod.POST)
	public String AdditionalRequired(@RequestParam String Additionalfield, @RequestParam String TypeField,
			@RequestParam String dptname, @RequestParam String check) {
		OtherRequirement other = new OtherRequirement();
		Boolean flag = false;
		if (check.equals(true)) {
			flag = false;
		} else {
			flag = true;
		}
		other.setNameField(Additionalfield);
		other.setTypeField(TypeField);
		other.setRequired(flag);
		other.setDepartment(DptDao.getDepartment(dptname));
		otherDao.saveOtherRequirement(other);
		return "redirect:ManageDepartment.html";
	}

	@RequestMapping(value = "Welcome.html", method = RequestMethod.GET)
	public String Welcome(ModelMap models) {
		return "Welcome";
	}

	@RequestMapping(value = "View.html", method = RequestMethod.GET)
	public String View(ModelMap models, @RequestParam String dptname) {
		List<OtherRequirement> other = otherDao.getOtherRequirement(dptname);
		List<Department> Department = DptDao.getDepartment();
		List<Programs> prg = prgDao.getProgram(dptname);
		models.put("otherRequirement", other);
		models.put("Department", Department);
		models.put("prg", prg);
		models.put("selecteddptname", dptname);
		return "View";
	}

	@RequestMapping(value = "EditDepartment.html", method = RequestMethod.GET)
	public String EditDepartment(ModelMap models, @RequestParam Integer Deptid) {
		models.put("department", DptDao.getDepartment(Deptid));
		return "EditDepartment";
	}

	@RequestMapping(value = "EditDepartment.html", method = RequestMethod.POST)
	public String EditDepartment(ModelMap models, @RequestParam String dptid, @RequestParam String dptname) {
		DptDao.updateDepartment(dptname, Integer.parseInt(dptid));
		return "redirect:ManageDepartment.html";
	}

	@RequestMapping(value = "RemoveProgram.html")
	public String Remove(@RequestParam Integer prgid) {
		prgDao.Remove(prgid);
		return "redirect:ManageDepartment.html";
	}

	/*
	 * @RequestMapping(value="EditDepartment.html",method=RequestMethod.POST )
	 * public String Remove2(ModelMap models,@RequestParam String
	 * dptid,@RequestParam String dptname) {
	 * DptDao.updateDepartment(dptname,Integer.parseInt(dptid)); return
	 * "redirect:ManageDepartment.html"; }
	 */
	@RequestMapping(value = "RemoveRequirement.html")
	public String OtherRequirementRemove(@RequestParam Integer otherid) {
		otherDao.OtherRequirementRemove(otherid);
		return "redirect:ManageDepartment.html";
	}

	@RequestMapping(value = "Logout.html")
	public String Logout(HttpSession session) {
		session.invalidate();
		return "redirect:Login.html";

	}

	@RequestMapping(value = "StudentInformation.html", method = RequestMethod.GET)
	public String Contestant(ModelMap models, HttpServletRequest request) {

		String usern = request.getSession().getAttribute("useremail").toString();
		models.put("Contestant", contestantDao.getContestant(usern));
		return "StudentInformation";
	}

	@RequestMapping(value = "ViewApplication.html", method = RequestMethod.GET)
	public String ContestantDetails(ModelMap models, HttpServletRequest request, @RequestParam Integer Aid) {
		
		models.put("applicant", contestantDao.getContestantDetails(Aid));
		return "ViewApplication";
      
	}

	@RequestMapping(value = "NewApplication.html", method = RequestMethod.GET)
	public String dropdown(ModelMap models, HttpServletRequest request, HttpServletResponse response,
			@RequestParam(required = false) Integer dept) throws Throwable {
		if (dept != null) {
			Department dpt = DptDao.getDepartment(dept);
			List<String> prog = new ArrayList<String>();
			List<Programs> prgs = dpt.getPid();
			for (Programs p : prgs) {
				prog.add(p.getPrgname());
			}
			String json = null;
			json = new Gson().toJson(prog);
			response.setContentType("application/json");
			response.getWriter().write(json);
			return null;
		} else {
			models.put("departments", DptDao.getDepartment());
			return "NewApplication";
		}
	}
	private File getFileDirectory()
	{
		String path=context.getServletContext().getRealPath("/WEB-INF/files");
		return new File(path);
	}
	@RequestMapping(value = "NewApplication.html", method = RequestMethod.POST)
	public String dropdown(ModelMap models, HttpServletRequest request, HttpServletResponse response,
			@RequestParam String Fname,@RequestParam String lname,@RequestParam String dob,
			@RequestParam String citizen,@RequestParam String Phone,@RequestParam String dept,
			@RequestParam String prg,@RequestParam String term,@RequestParam String Gender,
			@RequestParam Float gpa,@RequestParam MultipartFile file) throws IllegalStateException, IOException{
		String uploadtranscript=file.getOriginalFilename();
		file.transferTo(new File(getFileDirectory(),file.getOriginalFilename()));
		Contestant cont=new Contestant();
		java.util.Date dobdate = new java.util.Date();
		if(!file.isEmpty())
		{
			cont.setTranscript(uploadtranscript);
		}
		cont.setDateofsubmission(dobdate);
		if(!dob.equals(""))
    	{
    		DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        	try {
        		dobdate = sdf.parse(dob);
    		} catch (ParseException e) {
    		}
    	}
		
		cont.setFname(Fname);
		cont.setLname(lname);
	    cont.setGpa(gpa);
		cont.setDoB(dobdate);
		cont.setTerm(term);
		cont.setCitizen(citizen);
		cont.setDept(DptDao.getDepartment(Integer.parseInt(dept)));
		cont.setPid(prgDao.getProgram(Integer.parseInt(dept),prg));
        cont.setCIN(0);
        cont.setStatus(applicationStatusDao.getApplicationStatus("Not Submitted"));
        cont.setUser(userDao.getUsers((String)request.getSession().getAttribute("useremail")));
		Integer phn=Integer.parseInt(Phone);
		cont.setPhnumber(phn);
		cont.setGender(Gender);
		Contestant newapp= contestantDao.saveContestant(cont);
		return "redirect:SaveAcademic.html?appid=" + newapp.getAid();
}
	@RequestMapping(value = "SaveAcademic.html", method = RequestMethod.GET)
	public String SaveAcademicDetails(ModelMap models,@RequestParam Integer appid){
		 models.put("educations",educationDao.getEducationalByaid(appid));
         return "SaveAcademic"; 
		}
	
	@RequestMapping(value = "SaveAcademic.html", method = RequestMethod.POST)
	public String SaveAcademicDetails(ModelMap models, HttpServletRequest request, HttpServletResponse response,
			@RequestParam String Major,@RequestParam String yop,@RequestParam String colg,
			@RequestParam String Degree,@RequestParam Integer aid){
		  
		EducationBckgd ed =new EducationBckgd();
		//ed.setEid("0");
         ed.setMajor(Major);
         ed.setYoP(yop);
         ed.setClgName(colg);
         ed.setDegree(Degree);
         ed.setAid(contestantDao.getSingleContestantDetails(aid));
         EducationBckgd edu= educationDao.saveEducationBckgd(ed);
         return "redirect:SaveAcademic.html?appid=" + aid; 
		}
	@RequestMapping(value = "saveAdditionalRequirement.html", method = RequestMethod.GET)
	public String Saveotherrequirement(@RequestParam Integer appid,ModelMap models){
		Contestant applicant = contestantDao.getContestantDetails(appid);
		models.put("applicant", applicant);
		models.put("other",otherDao.getOtherRequirement(applicant.getDept().getDptname()));
		models.put("othervalue",othervaluedao.getOtherRequirementValue(appid));
         return "saveAdditionalRequirement"; 
		}
	@RequestMapping(value = "saveAdditionalRequirement.html", method = RequestMethod.POST)
	public String Saveotherrequirement(@RequestParam Integer fieldId,@RequestParam Integer aid,
			@RequestParam String txtvalue) throws IOException{
		OtherRequirementValue otherRequirementValue = new OtherRequirementValue();
		otherRequirementValue.setOtherValue(txtvalue);
		otherRequirementValue.setAid(contestantDao.getContestantDetails(aid));
		otherRequirementValue.setOtherId(otherDao.getOtherRequirement(fieldId));
			othervaluedao.saveOtherRequirementValue(otherRequirementValue);
        
         return "redirect:saveAdditionalRequirement.html?appid=" + aid;
		}
	@RequestMapping(value = "uploadAdditionalRequirement.html", method = RequestMethod.POST)
	public String updateotherrequirement(ModelMap models,@RequestParam MultipartFile file ,@RequestParam Integer fieldId,
			@RequestParam Integer aid) throws IOException{
		OtherRequirementValue otherRequirementValue = new OtherRequirementValue();
		if(!file.isEmpty())
		{
			String uploadtranscript=file.getOriginalFilename();
			file.transferTo(new File(getFileDirectory(),file.getOriginalFilename()));
			otherRequirementValue.setOtherValue(uploadtranscript);
		}
		otherRequirementValue.setAid(contestantDao.getContestantDetails(aid));
		otherRequirementValue.setOtherId(otherDao.getOtherRequirement(fieldId));
			othervaluedao.saveOtherRequirementValue(otherRequirementValue);
			
			return "redirect:saveAdditionalRequirement.html?appid=" + aid;
		}
	@RequestMapping(value = "/saveapplication.html")
	public String SaveStatus(@RequestParam Integer appid){
		contestantDao.getudateStatusdate(applicationStatusDao.getApplicationStatus("Submitted"), appid);
		return "redirect:StudentInformation.html"; 
	}
	
	@RequestMapping(value = "EditApplication.html", method = RequestMethod.GET)
	public String EditApplication(ModelMap models, @RequestParam Integer Aid) {
		models.put("departments", DptDao.getDepartment());
		Contestant contestant = contestantDao.getContestantDetails(Aid);
		models.put("contestant",contestant);
		models.put("programs", prgDao.getProgram(contestant.getDept().getDptname()));
		return "EditApplication";
	}

	@RequestMapping(value = "EditApplication.html", method = RequestMethod.POST)
	public String EditApplication(@RequestParam String Fname,@RequestParam String lname,@RequestParam String dob,
			@RequestParam String citizen,@RequestParam String Phone,@RequestParam String dept,
			@RequestParam String prg,@RequestParam String term,@RequestParam String Gender,
			@RequestParam Float gpa,@RequestParam String aid,@RequestParam MultipartFile file) throws IllegalStateException, IOException {
		String uploadtranscript = "";
		if(!file.isEmpty()){
			String oldfilename = contestantDao.getOldFileName(Integer.parseInt(aid));
			String oldpath=context.getServletContext().getRealPath("/WEB-INF/files/" + oldfilename);
			File oldfile = new File(oldpath);
			if(oldfile.exists()){
				oldfile.delete();
			}

			uploadtranscript=file.getOriginalFilename();
			file.transferTo(new File(getFileDirectory(),file.getOriginalFilename()));
		}
		java.util.Date dobdate = new java.util.Date();
		if(!dob.equals(""))
    	{
    		DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        	try {
        		dobdate = sdf.parse(dob);
    		} catch (ParseException e) {
    		}
    	}
		Department deptObj = DptDao.getDepartment(Integer.parseInt(dept));
		Programs prgmObj = prgDao.getProgram(Integer.parseInt(dept),prg);
		
		contestantDao.EditApplication(Fname,lname,dobdate,citizen,Integer.parseInt(Phone),deptObj,prgmObj,term,Gender,uploadtranscript,Integer.parseInt(aid),gpa);
		return "redirect:EditAcademics.html?appid=" + aid;
	}
	@RequestMapping("download.html") 
	public void download(HttpServletResponse response,@RequestParam String filenm) throws IllegalStateException, IOException
	{
		String filepath = context.getServletContext().getRealPath("/WEB-INF/files/" + filenm);
    	File file = new File(filepath);
    	if(file.exists()){
	    	String mimeType= URLConnection.guessContentTypeFromName(file.getName());
			if(mimeType==null){
				mimeType = "application/octet-stream";
			}
	        response.setContentType(mimeType);
	        response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + file.getName() +"\""));
	        response.setContentLength((int)file.length());
			InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
	        FileCopyUtils.copy(inputStream, response.getOutputStream());
    	}
	}

	@RequestMapping(value = "EditAcademics.html", method = RequestMethod.GET)
	public String EditAcademics(ModelMap models,@RequestParam Integer appid) {
		models.put("educations",educationDao.getEducationalByaid(appid));
        return "EditAcademics"; 
	}
	@RequestMapping(value = "EditAcademics.html", method = RequestMethod.POST)
	public String EditAcademics(ModelMap models, HttpServletRequest request, HttpServletResponse response,
			@RequestParam String Major,@RequestParam String yop,@RequestParam String colg,
			@RequestParam String Degree,@RequestParam Integer aid){
		  
		EducationBckgd ed =new EducationBckgd();
		//ed.setEid("0");
         ed.setMajor(Major);
         ed.setYoP(yop);
         ed.setClgName(colg);
         ed.setDegree(Degree);
         ed.setAid(contestantDao.getSingleContestantDetails(aid));
         EducationBckgd edu= educationDao.saveEducationBckgd(ed);
         return "redirect:EditAcademics.html?appid=" + aid; 
		}
	@RequestMapping(value = "delete.html", method = RequestMethod.GET)
	public String delete(ModelMap models, @RequestParam Integer appid,@RequestParam Integer eid){
		educationDao.Remove(eid);
         return "redirect:EditAcademics.html?appid=" + appid; 
		}
	@RequestMapping(value = "EditAdditionalRequirement.html", method = RequestMethod.GET)
	public String Editotherrequirement(@RequestParam Integer appid,ModelMap models){
		Contestant applicant = contestantDao.getContestantDetails(appid);
		models.put("applicant", applicant);
		models.put("other",otherDao.getOtherRequirement(applicant.getDept().getDptname()));
		models.put("othervalue",othervaluedao.getOtherRequirementValue(appid));
         return "EditAdditionalRequirement"; 
		}
	@RequestMapping(value = "EditAdditionalRequirement.html", method = RequestMethod.POST)
	public String Editotherrequirement(@RequestParam Integer fieldId,@RequestParam Integer aid,
			@RequestParam String otherValue,@RequestParam String fieldvalueId){
		if(fieldvalueId.equals("")){
		OtherRequirementValue otherRequirementValue = new OtherRequirementValue();
		otherRequirementValue.setOtherValue(otherValue);
		otherRequirementValue.setAid(contestantDao.getContestantDetails(aid));
		otherRequirementValue.setOtherId(otherDao.getOtherRequirement(fieldId));
			othervaluedao.saveOtherRequirementValue(otherRequirementValue);
		}else
		{
			othervaluedao.updateOtherRequirementValue(Integer.parseInt(fieldvalueId), otherValue);
		}
        
         return "redirect:EditAdditionalRequirement.html?appid=" + aid;
		}
	@RequestMapping(value = "uploadeditAdditionalRequirement.html", method = RequestMethod.POST)
	public String uploadeditAdditionalRequirement(ModelMap models,@RequestParam MultipartFile file ,@RequestParam Integer fieldId,
			@RequestParam Integer aid,@RequestParam String fieldvalueId) throws IOException{
		if(fieldvalueId.equals("")){
		OtherRequirementValue otherRequirementValue = new OtherRequirementValue();
		if(!file.isEmpty())
		{
			String uploadtranscript=file.getOriginalFilename();
			file.transferTo(new File(getFileDirectory(),file.getOriginalFilename()));
			otherRequirementValue.setOtherValue(uploadtranscript);
		}
		otherRequirementValue.setAid(contestantDao.getContestantDetails(aid));
		otherRequirementValue.setOtherId(otherDao.getOtherRequirement(fieldId));
			othervaluedao.saveOtherRequirementValue(otherRequirementValue);
		}
		else{
			if(!file.isEmpty()){
				String oldfilename = othervaluedao.getOldFileName(Integer.parseInt(fieldvalueId));
				String oldpath=context.getServletContext().getRealPath("/WEB-INF/files/" + oldfilename);
				File oldfile = new File(oldpath);
				if(oldfile.exists()){
					oldfile.delete();
				}

				 String uploadtranscript=file.getOriginalFilename();
				file.transferTo(new File(getFileDirectory(),file.getOriginalFilename()));
				othervaluedao.updateOtherRequirementValue(Integer.parseInt(fieldvalueId), uploadtranscript);
				
			}
		}
			
			return "redirect:EditAdditionalRequirement.html?appid=" + aid;
		}
	}
