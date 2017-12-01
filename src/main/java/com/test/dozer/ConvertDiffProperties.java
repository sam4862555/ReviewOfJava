package com.test.dozer;

import com.test.dozer.bean.DiffDTO;
import com.test.dozer.bean.DiffVO;
import com.test.dozer.bean.SameDTO;
import com.test.dozer.bean.SameVO;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

/**
 * Created by szh on 2017/12/1.
 */
public class ConvertDiffProperties {

    public static void main(String[] args){
        Mapper mapper = new DozerBeanMapper();

        DiffDTO srcDTO = new DiffDTO();
        srcDTO.setId(1);
        srcDTO.setName("szh");

        System.out.println("DTO to VO");
        DiffVO destVO = mapper.map(srcDTO, DiffVO.class);
        System.out.println(destVO);



        DiffVO srcVO = new DiffVO();
        srcVO.setId(1);
        srcVO.setUsername("szh");

        System.out.println("VO to DTO");
        DiffDTO destDTO = mapper.map(srcVO, DiffDTO.class);
        System.out.println(destDTO);

    }
}
