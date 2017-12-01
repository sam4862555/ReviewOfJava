package com.test.dozer;

import com.test.dozer.bean.SameDTO;
import com.test.dozer.bean.SameVO;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

/**
 * Created by szh on 2017/12/1.
 */
public class ConvertSameProperties {

    public static void main(String[] args){
        Mapper mapper = new DozerBeanMapper();

        SameDTO src = new SameDTO();
        src.setId(1);
        src.setName("szh");
        src.setAddress("heaven");
        src.setTel("0000-0000-00000");

        System.out.println("DTO to VO");
        SameVO destObject = mapper.map(src, SameVO.class);
        System.out.println(destObject);

        System.out.println("VO to DTO");
        SameVO copyVO = (SameVO) destObject.clone();
        SameDTO toDTOObject = mapper.map(copyVO , SameDTO.class);
        System.out.println(toDTOObject);

    }

}
