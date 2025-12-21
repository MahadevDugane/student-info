package com.example.studentInfo.repository;

import com.example.studentInfo.bean.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerAccountRepository extends JpaRepository<Customer,Integer> {

//    @Query(value="select * from sys.customer c,sys.account a where a.cust_id=c.id group by c.id,c.name,c.ifsc,c.address",nativeQuery = true)
//    public List<Customer> getCustomers(); // Fetch customer with accounts eagerly
   @Query("SELECT c FROM Customer c LEFT JOIN FETCH c.accounts WHERE c.id = :id")
   Optional<Customer> findCustomerWithAccounts(@Param("id") Long id);

}
