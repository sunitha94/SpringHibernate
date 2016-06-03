package com.hb.example.repository;

import com.hb.example.model.Address;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ehc on 2/6/16.
 */
public interface AddressRepository extends CrudRepository<Address,Integer> {
}
