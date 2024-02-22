package com.proxyapi.FakeStoreProxyApi.repositories;

import com.proxyapi.FakeStoreProxyApi.models.Product;
import com.proxyapi.FakeStoreProxyApi.projections.ProductWithIdTitlePrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Product getByTitleContaining(String name);

//    List<Product> getByCategory(Category category);
    List<Product> findByCategory_Id(Long id);

    void deleteById(Long id);

    Optional<Product> findById(Long id);

    Product save(Product product);

    @Query("select p from Product p where p.id=:ameya")
    List<Product> something (@Param("ameya")Long id);

    /*in this type of HQl query where we want specific columns from product we need
      projection like ProductWithIdTitlePrice and have to put getter name as alias of each attribute below

      and in case of HQL alias is required */
    @Query("select p.id as id, p.title as title, p.price as price from Product p where p.id=:ameya")
    List<ProductWithIdTitlePrice> sometingSpecific(@Param("ameya")Long id);

    /*Dont want hibernate to convert the HQl query written below so to avoid hibernate conversion
     to convert HQl we use native query=true
     *at table name we have to write table name which is present in database not the class name as we wrote above*/
    @Query(value = "select * from product p where p.id=:id",nativeQuery = true)
    List<Product>somethingSQL(@Param("id")Long id);

    /*If my DB changes normal HQl query will not change because hibernate will convert those according to database
    * but Native HQl query has to change with respect to database
    *
    * Native HQL query are tightly coupled
    * HQL query are dependent on hibernate to get convert so they are not tightly coupled
    *
    * Native HQL will gives you more control on query
    * HQL give you lesser control than Native and slower in performance*/

    /*
    Find all product native query
    @Query(value = "select * from product p", nativeQuery = true)
    List<Product> getAllProduct();
     */

}
