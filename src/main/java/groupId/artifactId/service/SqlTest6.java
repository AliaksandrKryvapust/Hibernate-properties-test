package by.it_academy.jd2.hw.example.crm.service;

import by.it_academy.jd2.hw.example.crm.hw.one_to_one.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class SqlTest6 {

    /**
     * 1. на страницу просмотра списка сотрудников добавить поиск по
     *  Имени - полное соответвие
     *  Зарплаты - больше или меньше (на выбор) заданного значения
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Session sessionOne = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = HibernateUtil.getSessionFactory().createEntityManager().getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);

        Root<Employee> itemRoot = criteriaQuery.from(Employee.class);

        criteriaQuery.where(
                criteriaBuilder.and(
                        criteriaBuilder.equal(itemRoot.get("name"), "9999")
                )
        );

        Query<Employee> query = sessionOne.createQuery(criteriaQuery);

        query.setFirstResult(60);
        query.setMaxResults(20);

        List<Employee> resultList = query.getResultList();

        for (Employee employee : resultList) {
            System.out.println(employee);
        }


        HibernateUtil.shutdown();
    }
}
