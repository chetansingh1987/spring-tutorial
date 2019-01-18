package com.test.springmvc;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.datamanagement.hibernate.dto.EmployeeDTO;



@Repository("DAO")
public class HibernateTester {
	
	public static void main(String[] args) throws Exception{
		System.out.println(new HibernateTester().getEmployee(1));
	}
	

	private HibernateTemplate hTem;
	
	@Autowired
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		hTem = hibernateTemplate;
		int i=1;
	}
    @Transactional(readOnly = true)
    public EmployeeDTO getEmployee(Integer id )throws Exception{
           String query =" from EmployeeDTO where id=?";
           SessionFactory sessionFactory =   hTem.getSessionFactory();
           Session session =  sessionFactory.getCurrentSession();
           Query hibernateQuery =session.createQuery(query);
           hibernateQuery.setParameter(0, id);
           EmployeeDTO  result =  (EmployeeDTO) hibernateQuery.list().get(0);


           return result;

    }
	
}
