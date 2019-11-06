package com.example.newsletter.repository;

import com.example.newsletter.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;


@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    @Query(value = "select * from subscription s where s.id in (select subscription_id from user_subscriptions where user_id in(select id from user where username=?))", nativeQuery = true)
    public List<Subscription> findAllUserSub(String u_name);

    @Query(value = "select * from subscription ORDER BY subscription.name",nativeQuery = true)
    public List<Subscription> sortByName();

    @Query(value = "select * from subscription ORDER BY id", nativeQuery = true)
    public List<Subscription> sortById();

    @Query(value = "select * from subscription where name=?", nativeQuery = true)
    public Subscription SubDuration(String s_name);

}
