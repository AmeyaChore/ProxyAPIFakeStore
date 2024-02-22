package com.proxyapi.FakeStoreProxyApi.inheritanceDemo.singleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@PrimaryKeyJoinColumn(name = "user_id")
@DiscriminatorValue("2")
@Entity
public class Instructor extends User {
    private String company;
}
