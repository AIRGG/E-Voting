/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mypojo.HibUtil;
import mypojo.TblKalkulasi;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author AIRGG
 */
public class DAOKalkulasi {
    private final static String namaTbl = "TblKalkulasi";
    private final static String idTbl = "idkalkulasi";
    
    public void upd(TblKalkulasi tblnya) {
        Transaction tx = null;
        Session sess = HibUtil.getSessionFactory().openSession();
        try {
            tx = sess.beginTransaction();
            sess.update(tblnya);
            tx.commit();
        }catch(Exception e) {
            System.out.println("Error kene(Upd): "+e);
        }
    }
    
    public List<TblKalkulasi> getById(String idnya) {
        List<TblKalkulasi> lst = new ArrayList();
        Transaction tx = null;
        Session sess = HibUtil.getSessionFactory().openSession();
        try {
            tx = sess.beginTransaction();
            
            String sql = "from "+ namaTbl +" where 1=1 ";
            if(idnya != null) sql += " and "+ idTbl +"=:vId";
            Query q = sess.createQuery(sql);
            if(idnya != null) q.setString("vId", idnya);
            
            lst = q.list();
            tx.commit();
        }catch(Exception e) {
            System.out.println("Error kene(getById): "+e);
        }
        return lst;
    }
    public List<TblKalkulasi> getAll() {
        return getById(null);
    }
}
