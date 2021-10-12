/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mypojo.HibUtil;
import mypojo.TblVote;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author AIRGG
 */
public class DAOVote {
    public void add(TblVote tblnya) {
        Transaction tx = null;
        Session sess = HibUtil.getSessionFactory().openSession();
        try {
            tx = sess.beginTransaction();
            sess.save(tblnya);
            tx.commit();
        }catch(Exception e) {
            System.out.println("Error kene(Add): "+e);
        }
    }
    
    public List<Map<String, Object>> getAll(String param) {
        List<Map<String, Object>> rtr = new ArrayList<>();
        List<TblVote> lst = new ArrayList();
        Transaction tx = null;
        Session sess = HibUtil.getSessionFactory().openSession();
        try {
            tx = sess.beginTransaction();
            String sql = "SELECT "+ param +" FROM tbl_vote LIMIT 1";
            Query q = sess.createSQLQuery(sql);
            q.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            // https://www.tutorialspoint.com/hibernate/hibernate_native_sql.htm
//            lst = q.list();
            for(Object object : q.list()) {
                Map row = (Map)object;
                rtr.add(row);
            }
//            lst = q.list();
            tx.commit();
        }catch(Exception e) {
            System.out.println("Error kene(getById): "+e);
        }
        return rtr;
        
    }
    
    public static void main(String[] args) {
        DAOVote dao = new DAOVote();
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
        
        String calon = "";
        int no = 1;
        for(int i = 0; i < isi.size(); i++) {
            Map<String, String> v = isi.get(i);
            calon += " (SELECT COUNT(*) FROM tbl_vote WHERE kdvote='"+ v.get("kdvote") +"') calon"+ no +", ";
            no++;
        }
        calon += "1";
        System.out.println(calon);
        
        System.out.println(dao.getAll(calon).get(0));
//        isi.forEach((v) -> {
//            
//        });
//        dao.getAll();
    }
}
