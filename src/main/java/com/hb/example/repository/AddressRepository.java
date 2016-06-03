package com.hb.example.repository;

import com.hb.example.model.Address;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by ehc on 2/6/16.
 */
public interface AddressRepository extends CrudRepository<Address,Integer> {
  List<Address> findByCity(String city);
}
