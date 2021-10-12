package mypojo;
// Generated Sep 28, 2021 9:20:21 PM by Hibernate Tools 4.3.1


import DAO.DAOKalkulasi;
import DAO.DAOVote;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;

/**
 * TblKalkulasi generated by hbm2java
 */
@ManagedBean
public class TblKalkulasi  implements java.io.Serializable {


     private int idkalkulasi;
     private String docalculate;
     private Date datecalculate;
     
     private List<Map<String, String>> listCalon;

    public TblKalkulasi() {
    }

    public TblKalkulasi(int idkalkulasi, String docalculate, Date datecalculate) {
       this.idkalkulasi = idkalkulasi;
       this.docalculate = docalculate;
       this.datecalculate = datecalculate;
    }
   
    public int getIdkalkulasi() {
        return this.idkalkulasi;
    }
    
    public void setIdkalkulasi(int idkalkulasi) {
        this.idkalkulasi = idkalkulasi;
    }
    public String getDocalculate() {
        return this.docalculate;
    }
    
    public void setDocalculate(String docalculate) {
        this.docalculate = docalculate;
    }
    public Date getDatecalculate() {
        return this.datecalculate;
    }
    
    public void setDatecalculate(Date datecalculate) {
        this.datecalculate = datecalculate;
    }
    
    
    public List<Map<String, String>> getListCalon() {
        List<Map<String, String>> isi = new ArrayList<>();
        Map<String, String> tmpCalon = new HashMap<>();
        
        // -- CALON KETUA -- \\
        tmpCalon.put("kdvote", "CL01");
        tmpCalon.put("nama", "Alkaios Nikolas");
        tmpCalon.put("img", "https://images.pexels.com/photos/105809/pexels-photo-105809.jpeg?auto=compress");
        tmpCalon.put("ket", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur porttitor gravida aliquet. Maecenas eros turpis, mollis et viverra at, vehicula lacinia dui. Nam non lacus tincidunt, hendrerit nisl tristique, faucibus tortor. Aliquam ornare tempor quam. Praesent elementum varius felis, eu tempor metus finibus vitae.");
        isi.add(tmpCalon);
        tmpCalon = new HashMap<>();
        
        tmpCalon.put("kdvote", "CL02");
        tmpCalon.put("nama", "Lionel Isidore");
        tmpCalon.put("img", "https://images.pexels.com/photos/7752793/pexels-photo-7752793.jpeg?auto=compress");
        tmpCalon.put("ket", "Morbi in iaculis magna. In hac habitasse platea dictumst. Etiam quis mauris vitae dolor iaculis porttitor. Sed viverra vehicula nibh, sit amet sagittis enim faucibus vitae. In venenatis tristique nisl et vulputate. Aliquam erat volutpat. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.");
        isi.add(tmpCalon);
        tmpCalon = new HashMap<>();
        
        tmpCalon.put("kdvote", "CL03");
        tmpCalon.put("nama", "Mark Stanimir");
        tmpCalon.put("img", "https://images.pexels.com/photos/145971/pexels-photo-145971.jpeg?auto=compress");
        tmpCalon.put("ket", "Donec malesuada viverra sem eget molestie. Quisque sed justo at mi rhoncus consequat. Nunc non porta tortor, eget faucibus ligula. Vestibulum odio dui, ullamcorper ac arcu ut, viverra bibendum magna. Nunc efficitur neque eu accumsan faucibus. Etiam id purus mollis, faucibus velit vitae, vehicula tortor.");
        isi.add(tmpCalon);
        tmpCalon = new HashMap<>();
        
        DAOVote dao = new DAOVote();
        String calon = "";
        int no = 1;
        for(int i = 0; i < isi.size(); i++) {
            Map<String, String> v = isi.get(i);
            calon += " (SELECT COUNT(*) FROM tbl_vote WHERE kdvote='"+ v.get("kdvote") +"') calon"+ no +", ";
            no++;
        }
        calon += "1";
        
        Map<String, Object> kalkulasi = dao.getAll(calon).get(0);
        for(int i = 0; i < isi.size(); i++) {
            Map<String, String> v = isi.get(i);
            v.put("kalkulasi", kalkulasi.get("calon"+(i+1)).toString());
        }
        return isi;
    }
    
    public String calculate() {
        DAOKalkulasi dao = new DAOKalkulasi();
        List<TblKalkulasi> lst = dao.getAll();
        this.idkalkulasi = lst.get(0).getIdkalkulasi();
        this.docalculate = (lst.get(0).getDocalculate().toString().equals("1") ? "0" : "1");
        this.datecalculate = new Date();
        dao.upd(this);
        return "?faces-redirect=true";
    }
    
    public List<TblKalkulasi> getStatusKalkulasi() {
        DAOKalkulasi dao = new DAOKalkulasi();
        return dao.getAll();
                
    }




}

