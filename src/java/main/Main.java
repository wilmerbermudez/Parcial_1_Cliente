package main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.incoorp.Util.JPAUtil;
import com.incoorp.dao.LibroDAO;
import com.incoorp.dao.PersonaDAO;
import com.incoorp.dao.ReservaDAO;
import com.incoorp.interfaces.InterBean;
import com.incoorp.interfaces.InterBeanPersona;
//import com.incoorp.interfaces.Repository;
import com.incoorp.model.Libro;
import com.incoorp.model.Persona;
import com.incoorp.model.Reserva;
import com.incoorp.service.LibroService;
import com.incoorp.service.PersonaService;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author incoorp
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    //static Session session = JPAUtil.getSessionFactory().openSession();
    //static Repository<Persona, String> repo = new PersonaDAO();
    private static InterBeanPersona daoPersona = new PersonaService();
    static ReservaDAO repoReserva = new ReservaDAO();
    private static InterBean daoL = new LibroService();
    //static Repository<Reserva, Long> repoReserva = new ReservaDAO();
    //static LibroBean bean = new LibroBean();
    public static void main(String[] args) {

        System.out.println(daoPersona.getAllWithReserva());
        /*Libro libro = new Libro();
        libro.setISBN("1");
        libro.setAutor("Nadie");
        repoLibro.save(libro);
        /*session.beginTransaction();
        List<Libro> libro = session.createQuery("SELECT o FROM Libro o").list();
        System.out.println(libro);
        session.close();*/
       
       
       //Personas
       //session.beginTransaction();
   
        //session.persist(p);
        //session.getTransaction().commit();
        //session.close();
       
       //Libros
        /*Libro libro = new Libro();
        libro.setISBN("2");
        libro.setTitulo("Java2");
        libro.setDescripcion("Medio");
        libro.setEdicion("2");
        libro.setPaginas(200L);
        libro.setAutor("Arturo ");
        repoLibro.save(libro);*/
        
        //Reserva
       //session.beginTransaction();
       /*repo.update(p);
       repoReserva.delete(3L);
        Reserva r = new Reserva();
        List<Libro> libros = new ArrayList<Libro>();
        libros.add(new Libro("4", "java3", "Aqui NO", "Dificil", 500L, "3"));
        //repo.save(p);
        r.setLibros(libros);
        p.setReserva(r);
        repo.update(p);
        
        /*session.persist(p);
        session.getTransaction().commit();
        session.close();*/
        
    }
    
}
