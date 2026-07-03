module bankdata {
    requires static lombok;
    requires org.hibernate.orm.core;
    requires com.fasterxml.jackson.annotation;
    requires jakarta.persistence;
    requires spring.data.commons;
    requires spring.context;
    requires spring.data.jpa;

//    exports io.github.unawarespecs.bankapp.entity;
    exports io.github.unawarespecs.bankapp.model;
    exports io.github.unawarespecs.bankapp.service;
    exports io.github.unawarespecs.bankapp.entity;
    exports io.github.unawarespecs.bankapp.repo;
//    exports io.github.unawarespecs.bankapp.repo;
//    exports io.github.unawarespecs.bankapp.service;
}