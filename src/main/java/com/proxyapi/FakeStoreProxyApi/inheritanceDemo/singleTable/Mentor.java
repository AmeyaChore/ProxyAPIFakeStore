package com.proxyapi.FakeStoreProxyApi.inheritanceDemo.singleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@PrimaryKeyJoinColumn(name= "user_id")
@DiscriminatorValue("1")
public class Mentor extends User {
    private double avgRating;
}
