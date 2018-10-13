package com.example.shelter.mapper;


import com.example.shelter.domain.ShelterUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface ShelterUserMapper {


    @Select("SELECT * FROM shelter_user WHERE id = #{id}")
    ShelterUser selectUser(@Param("id")Long id);

//    @Insert("INSERT INTO shelter_user(NAME, PASSWORD, PHONE) VALUES(#{name}, #{password}, #{phone})")
//    int insert(@Param("name") String name, @Param("password") String password, @Param("phone") String phone);

}
