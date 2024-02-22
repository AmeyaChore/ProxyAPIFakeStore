package com.proxyapi.FakeStoreProxyApi.inheritanceDemo.joinedClass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "jt_instructor")
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "user_id")
public class Instructor extends User{
    private String company;
}
