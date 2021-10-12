/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import mypojo.HibUtil;
import mypojo.TblPemilih;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author AIRGG
 */
public class DAOPemilih {
    public void add(TblPemilih tblnya) {
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
    public void upd(TblPemilih tblnya) {
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
    public void del(String idnya) {
        Transaction tx = null;
        Session sess = HibUtil.getSessionFactory().openSession();
        try {
            tx = sess.beginTransaction();
            TblPemilih datanow = (TblPemilih) sess.load(TblPemilih.class, new String(idnya));
            sess.delete(datanow);
            tx.commit();
        }catch(Exception e) {
            System.out.println("Error kene(Del): "+e);
        }
    }
    public List<TblPemilih> getByIdLogin(String idnya) {
        List<TblPemilih> lst = new ArrayList();
        Transaction tx = null;
        Session sess = HibUtil.getSessionFactory().openSession();
        try {
            tx = sess.beginTransaction();
            String sql = "from TblPemilih WHERE 1=1 ";
            if(idnya != null) sql += " AND userid=:vId ";
            Query q = sess.createQuery(sql);
            if(idnya != null) q.setString("vId", idnya);
            lst = q.list();
            tx.commit();
        }catch(Exception e) {
            System.out.println("Error kene(getById): "+e);
        }
        return lst;
    }
    public List<TblPemilih> getById(String idnya) {
        List<TblPemilih> lst = new ArrayList();
        Transaction tx = null;
        Session sess = HibUtil.getSessionFactory().openSession();
        try {
            tx = sess.beginTransaction();
            String sql = "from TblPemilih WHERE role='user' ";
            if(idnya != null) sql += " AND userid=:vId ";
            Query q = sess.createQuery(sql);
            if(idnya != null) q.setString("vId", idnya);
            lst = q.list();
            tx.commit();
        }catch(Exception e) {
            System.out.println("Error kene(getById): "+e);
        }
        return lst;
    }
    public List<TblPemilih> getAll() {
        return getById(null);
    }
}
