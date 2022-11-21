package by.it_academy.jd2.hw.example.crm.storage;

import by.it_academy.jd2.hw.example.crm.hw.one_to_one.Employee;
import by.it_academy.jd2.hw.example.crm.model.EPredicateOperator;
import by.it_academy.jd2.hw.example.crm.model.ESalaryOperator;
import by.it_academy.jd2.hw.example.crm.model.EmployeeSearchFilter;
import by.it_academy.jd2.hw.example.crm.service.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeStorage {
    private static final EmployeeStorage instance = new EmployeeStorage();

    public List<Employee> page(EmployeeSearchFilter filter){
        Session sessionOne = HibernateUtil.getSessionFactory().openSession();
        sessionOne.beginTransaction();

        CriteriaBuilder criteriaBuilder = HibernateUtil.getSessionFactory().createEntityManager().getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);

        Root<Employee> itemRoot = criteriaQuery.from(Employee.class);

        List<Predicate> predicates = new ArrayList<>();
        if(filter.getName() != null){
            predicates.add(criteriaBuilder.equal(itemRoot.get("name"), filter.getName()));
        }

        if (filter.getSalary() != null){
            ESalaryOperator operator = filter.getSalaryOperator();
            if(operator == null){
                operator = ESalaryOperator.GREAT_OR_EQUAL;
            }
            Predicate predicate;
            switch (operator){
                case GREAT_OR_EQUAL:
                    predicate = criteriaBuilder.ge(itemRoot.get("salary"), Double.valueOf(filter.getSalary()));
                    break;
                case LESS_OR_EQUAL:
                    predicate = criteriaBuilder.le(itemRoot.get("salary"), Double.valueOf(filter.getSalary()));
                    break;
                default:
                    predicate = null;
            }

            if(predicate == null){
                throw new IllegalArgumentException("Я не знаю как обработать переданный поисковый оператор");
            }

            predicates.add(predicate);
        }

        EPredicateOperator predicateOperator = filter.getPredicateOperator();

        if(predicateOperator == null){
            predicateOperator = EPredicateOperator.AND;
        }

        Predicate[] predicatesArr = predicates.toArray(new Predicate[0]);

        Expression<Boolean> restriction;

        if(EPredicateOperator.AND.equals(predicateOperator)){
            restriction = criteriaBuilder.and(predicatesArr);
        } else {
            restriction = criteriaBuilder.or(predicatesArr);
        }

        criteriaQuery.where(restriction);

        Query<Employee> query = sessionOne.createQuery(criteriaQuery);

        int size = filter.getSize();

        if(size == 0){
            size = 20;
        }

        query.setMaxResults(size);
        query.setFirstResult(filter.getPage() * size);

        List<Employee> resultList = query.getResultList();

        sessionOne.getTransaction().commit();

        return resultList;
    }

    public static EmployeeStorage getInstance() {
        return instance;
    }
}
