package com.onlieshop.boot.repo;

import com.onlieshop.boot.entity.Shop;
import org.springframework.data.repository.CrudRepository;

// <Shop,Long > з якою сутністю працюємо + яке у нього id (який тип)
public interface ShopsRepo extends CrudRepository<Shop,Long> {


}
