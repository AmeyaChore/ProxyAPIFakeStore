package com.proxyapi.FakeStoreProxyApi.inheritanceDemo.joinedClass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "jt_mentor")
/*
* below annotation users user id pforeign key as a primary key for mentor table */
@PrimaryKeyJoinColumn(name= "user_id")
public class Mentor extends User{
    private double avgRating;
}
