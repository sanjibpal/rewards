package com.charter.entities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "retailer")
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
public class Retailer {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    @Convert(converter = StringTrimConverter.class)
    @Column(name = "FIRSTNAME")
    private String firstName;
    @Convert(converter = StringTrimConverter.class)
    @Column(name = "LASTNAME")
    private String lastName;
    @Convert(converter = StringTrimConverter.class)
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PASSWORD")
    private String password;
}
