package com.example.demo.repository;

import com.example.demo.model.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository{
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Product> getAll() {
        Session session = null;
        List<Product> products = new ArrayList<>();

        try {
            session = ConnectionUtils.getSessionFactory().openSession();
            TypedQuery<Product> query = session.createQuery("from Product", Product.class);
            products = query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (session != null) {
                session.close();
            }
        }
        return products;
    }

    @Override
    public void createProduct(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.save(product);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void deleteProduct(int productId) {
        System.out.println("hihi");
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            System.out.println("hihi");
            session.remove(getProductById(productId));

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Product getProductById(int productId) {

        Session session = null;
        Product product = null;

        try {
            session = ConnectionUtils.getSessionFactory().openSession();
            TypedQuery<Product> query = session.createQuery("from Product p where p.id = :productId", Product.class).setParameter("productId", productId);
            product = query.getSingleResult();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (session != null) {
                session.close();
            }
        }
        return product;
    }

    @Override
    public void editProduct(Product product) {

        System.out.println("hihi");
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            System.out.println("hihi");
            session.update(product);
            transaction.commit();
            ConnectionUtils.getEntityManager().clear();


        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Product> searchByName(String productName) {
        List<Product> searchedProducts = new ArrayList<>();
        for (int i = 0; i < this.getAll().size(); i++) {
            if(this.getAll().get(i).getName().toLowerCase().contains(productName)){
                searchedProducts.add(this.getAll().get(i));
            }
        }
        return searchedProducts;
    }

    @Override
    public boolean checkExistence(int productId) {
        return ConnectionUtils.getEntityManager().find(Product.class, productId) != null;
    }


}
