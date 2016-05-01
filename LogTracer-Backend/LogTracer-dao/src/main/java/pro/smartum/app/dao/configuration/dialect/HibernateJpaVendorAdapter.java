package pro.smartum.app.dao.configuration.dialect;



public class HibernateJpaVendorAdapter extends org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter {

    private HibernateJpaDialect dialect;

    @Override
    public HibernateJpaDialect getJpaDialect() {
        dialect = new HibernateJpaDialect();
        return dialect;
    }
}
