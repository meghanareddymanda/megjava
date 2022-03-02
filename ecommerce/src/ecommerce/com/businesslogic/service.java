package ecommerce.com.businesslogic;
import ecommerce.com.Product;
import ecommerce.com.Rating;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;   
import org.hibernate.cfg.Configuration;


public class Service {
	private static SessionFactory sessionFactory = null;
	Transaction transaction = null;
	Session sessiong = null;
	
	public void  addProductDetails(Product product) {
		// initialize the session
		Session session = null;
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		// begin transaction
		transaction = session.beginTransaction();	
		// this save() will form "insert into table " query	// automatically// in DB"
		session.save(product);
		transaction.commit();

	}
	
	public Product getProductDetailsById(int id) {
		Session session = null;
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		// begin transaction
		transaction=session.beginTransaction();
		
		Product product = (Product)session.get(Product.class, id);
		return product;

	}
	
	public List<Product> getListOfAllProductDetails() {
		// Initialize the session
		Session session = null;
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();

		// begin transaction
		transaction = session.beginTransaction();
		
		Query query =session.createQuery("FROM Product");
		
		List<Product> productList = query.list();
		
		return productList;
	
	}
	
	//update product details by id
	
	public Product updateProductDetailsById(Product p, int id) {
		// Initialize the session
				Session session = null;
				sessionFactory = new Configuration().configure().buildSessionFactory();
				session = sessionFactory.openSession();
				// begin transaction
				transaction = session.beginTransaction();
				//
				Product p1 = (Product)session.get(Product.class, id);
				
				p1.setLaptopName(p.getLaptopName());
				p1.setScreensize(p.getScreensize());
				p1.setColor(p.getColor());
				p1.setWeight(p.getWeight());
				p1.setModel(p.getModel());
		        session.update(p1);
		        transaction.commit();
		        return p1;
		
	}
//	
	public Product findProductById(int id) {
		
		sessionFactory = new Configuration().configure().buildSessionFactory();
		sessiong = sessionFactory.openSession();
		// begin transaction
		transaction=sessiong.beginTransaction();
		Product a = (Product)sessiong.load(Product.class, id);
		return a;
	}
	
	//we need common session

	public void deleteProductRecordById(int id) {
		
		sessionFactory = new Configuration().configure().buildSessionFactory();
		sessiong = sessionFactory.openSession();
		transaction=sessiong.beginTransaction();
	    Product d = findProductById(id); //fetching existing id from the database with the help of findByIdMethod()
		sessiong.delete(d);
		transaction.commit();
		   
	}
//	
	public String deleteAllProductDetails() {
//		// Initialize the session
				Session session = null;
				sessionFactory = new Configuration().configure().buildSessionFactory();
				session = sessionFactory.openSession();
				// begin transaction
				transaction = session.beginTransaction();
				Query query = sessiong.createQuery("delete");
				Integer del = query.executeUpdate();
			transaction.commit();
					if (del > 0) {
						return "Deleted Successfully!";
					} else {
						return "Record Not Available!";
					}
				}
	
//
//
//
////***********rating*************

				public void AddRating(Rating r) {
					// initialize the session
					Session session = null;
					sessionFactory = new Configuration().configure().buildSessionFactory();
					session = sessionFactory.openSession();
					// begin transaction
					transaction = session.beginTransaction();
					session.save(r);// this save() will form "insert into table " query // automatically// in DB"
					transaction.commit();

				}
				
				//by id
				public Rating getRatingById(int id) {
					Session session = null;
					sessionFactory = new Configuration().configure().buildSessionFactory();
					session = sessionFactory.openSession();
					// begin transaction
					transaction = session.beginTransaction();
					return (Rating) session.get(Rating.class, id);
				}
//
				public List<Rating> getListOfAllRating() {
					Session session = null;
					sessionFactory = new Configuration().configure().buildSessionFactory();
					session = sessionFactory.openSession();

					Query q = session.createQuery("Rating");
					List<Rating> Rlist = q.list();
					return Rlist;

				}
//
				public Rating updateRatingById(Rating rate, int id) {
					Session session = null;
					sessionFactory = new Configuration().configure().buildSessionFactory();
					session = sessionFactory.openSession();
					// begin transaction
					transaction = session.beginTransaction();

					Rating r = (Rating) session.get(Rating.class, id);

					r.setNumberOfStars(rate.getNumberOfStars()); // values are coming from client that isMainClas
					r.setRating(rate.getRating());

					session.update(r);
					transaction.commit();
					return r;

				}

///// this method is used for only retrieve the id from DB
				public Rating findRatingById(int ratingId) {

					sessionFactory = new Configuration().configure().buildSessionFactory();
					sessiong = sessionFactory.openSession();
					// begin transaction
					transaction = sessiong.beginTransaction();
					return (Rating) sessiong.load(Rating.class, ratingId);
				}

////we need common session
//
				public void deleteRatingRecordById(int id) {

					sessionFactory = new Configuration().configure().buildSessionFactory();
					sessiong = sessionFactory.openSession();
					transaction = sessiong.beginTransaction();
					Rating d = findRatingById(id); // fetching existing id from the database with the help
																	// of findByIdMethod()
					sessiong.delete(d);
					transaction.commit();

				}

				public String deleteAllRatingDetails() {
					sessionFactory = new Configuration().configure().buildSessionFactory();
					sessiong = sessionFactory.openSession();
					transaction = sessiong.beginTransaction();
					Query query = sessiong.createQuery("Delete");
					Integer result = query.executeUpdate();
					transaction.commit();

					if (result > 0) {
						return "Rating deleted";
					} else {
						return "Rating Not Available";
				}
				}

				


			}