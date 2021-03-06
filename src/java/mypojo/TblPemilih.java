package mypojo;
// Generated Sep 28, 2021 9:20:21 PM by Hibernate Tools 4.3.1

import DAO.DAOPemilih;
import util.MyUtility;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;




/**
 * TblPemilih generated by hbm2java
 */
@ManagedBean
public class TblPemilih  implements java.io.Serializable {


     private String userid;
     private String passwd;
     private String nama;
     private String hasvote;
     private String role;
     private String unqiduser;
     
     private String errorMsg = "";
     private Boolean error = false;

    public TblPemilih() {
    }

    public TblPemilih(String userid, String passwd, String nama, String hasvote, String role, String unqiduser) {
       this.userid = userid;
       this.passwd = passwd;
       this.nama = nama;
       this.hasvote = hasvote;
       this.role = role;
       this.unqiduser = unqiduser;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }
    
    
   
    public String getUserid() {
        return this.userid;
    }
    
    public void setUserid(String userid) {
        this.userid = userid;
    }
    public String getPasswd() {
        return this.passwd;
    }
    
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    public String getNama() {
        return this.nama;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getHasvote() {
        return this.hasvote;
    }
    
    public void setHasvote(String hasvote) {
        this.hasvote = hasvote;
    }
    public String getRole() {
        return this.role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    public String getUnqiduser() {
        return this.unqiduser;
    }
    
    public void setUnqiduser(String unqiduser) {
        this.unqiduser = unqiduser;
    }
    
    public String cobaPindah() {
        return "index2.xhtml?faces-redirect=true";
    }
    public String logout() {
        String redirectPage = "/index.xhtml?faces-redirect=true";
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        session.invalidate();
        return redirectPage;
    }
    public String cekLogin() {
        String redirectPage = "login.xhtml";
        DAOPemilih pm = new DAOPemilih();
        List<TblPemilih> isi = pm.getByIdLogin(userid);
        System.out.println(isi);
        if(isi.size() == 1){
            if(isi.get(0).getPasswd().equals(passwd)) {
                HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
                HttpSession session = request.getSession();
                session.setAttribute("login", true);
                session.setAttribute("datalogin", isi.get(0));
                redirectPage = "dashboard/user.xhtml?faces-redirect=true";
                if(isi.get(0).getRole().equals("admin")) {
                    redirectPage = "dashboard/admin.xhtml?faces-redirect=true";
                }
                return redirectPage;
            }
        }
        errorMsg = "Login Fail, Username or Password Wrong..!";
        error = true;
        return redirectPage;
    }
    
    public String getPassRand() {
        MyUtility util = new MyUtility();
        return util.getSaltString(8);
    }
    
    public String addData() {
        String redirectPage = "admin-pemilih-add.xhtml";
        MyUtility util = new MyUtility();
        DAOPemilih pm = new DAOPemilih();
        List<TblPemilih> isi = pm.getById(userid);
        if(isi.isEmpty()) {
            setRole("user");
            setHasvote("0");
            setUnqiduser(util.generateUUID());
            pm.add(this);
            redirectPage = "admin-pemilih.xhtml?faces-redirect=true";
            return redirectPage;
        }
        errorMsg = "Userid has been taken.!";
        error = true;
        return redirectPage;
    }
    public String updData() {
        String redirectPage = "admin-pemilih.xhtml?faces-redirect=true";
        DAOPemilih pm = new DAOPemilih();
        List<TblPemilih> isi = pm.getById(userid);
        
        setRole(isi.get(0).getRole());
        setHasvote(isi.get(0).getHasvote());
        setUnqiduser(isi.get(0).getUnqiduser());
        pm.upd(this);
        
        return redirectPage;
    }
    public String delData(String idnya) {
        String redirectPage = "admin-pemilih.xhtml?faces-redirect=true";
        DAOPemilih pm = new DAOPemilih();
        pm.del(idnya);
        return redirectPage;
    }
    
    public List<TblPemilih> getAllData() {
        DAOPemilih pm = new DAOPemilih();
        List<TblPemilih> isi = pm.getAll();
        return isi;
    }
    
    public String showEdit(String idnya) {
        DAOPemilih pm = new DAOPemilih();
        List<TblPemilih> isi = pm.getById(idnya);
        
        userid = isi.get(0).getUserid();
        passwd = isi.get(0).getPasswd();
        nama = isi.get(0).getNama();
        hasvote = isi.get(0).getHasvote();
        role = isi.get(0).getRole();
        unqiduser = isi.get(0).getUnqiduser();
        return "admin-pemilih-edit.xhtml";
    }
    




}


