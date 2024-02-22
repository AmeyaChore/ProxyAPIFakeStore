package com.proxyapi.FakeStoreProxyApi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Category extends BaseModel{

    //By default spring will think this is a saperate relation
    //if below mapping is done then even though spring will consider
    //these two mapping different,  which are present in Categorya and product are in deed similar
    //so pring will create diferent M:M mapping tabel
//    @OneToMany(mappedBy = "category")
//    private List<Product> products;
    private String name;

}
