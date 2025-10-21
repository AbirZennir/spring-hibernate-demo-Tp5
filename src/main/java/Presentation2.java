import dao.IDao;
import entities.Category;
import entities.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import util.HibernateConfig;

public class Presentation2 {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(HibernateConfig.class);

        @SuppressWarnings("unchecked")
        IDao<Category> categoryDao = (IDao<Category>) context.getBean("categoryDao");

        @SuppressWarnings("unchecked")
        IDao<Product> productDao = (IDao<Product>) context.getBean("productDao");

        // 1) Créer une catégorie
        Category cat = new Category("Informatique");
        categoryDao.create(cat);

        // 2) Créer un produit rattaché à cette catégorie
        Product p = new Product();
        p.setName("Clavier");
        p.setPrice(150.0);
        p.setCategory(cat);

        productDao.create(p);

        System.out.println("OK: Produit '" + p.getName() + "' dans la catégorie '" + cat.getName() + "'.");
    }
}
